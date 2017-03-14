package JTextField;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.ManipuladorCarros;
import DAO.ManipuladorClientes;
import DAO.ManipuladorVendas;
import Entidades.Carro;
import Entidades.Cliente;
import Entidades.Gerente;
import Entidades.Vendas;
import Entidades.Vendedor;

public class TelaVendas {

	Carro carro;
	Cliente cliente;
	Gerente gerente = new Gerente(null, null, 0);
	Vendedor vendedor = new Vendedor(null, null, 0, null);
	private ManipuladorVendas mv;

	public TelaVendas(String[] funcionario, int gerVer) {
		if (gerVer == 1) {
			this.vendedor.setNome(funcionario[2]);
			this.vendedor.setUsername(funcionario[0]);
		} else if (gerVer == 2) {
			this.gerente.setNome(funcionario[2]);
			this.gerente.setUsername(funcionario[0]);
		}

	}

	public void JTPVendas(String[] funcionario, int gerVer) {

		int instanciamento = 0;

		// implementação do acesso ao banco de clientes
		ManipuladorClientes mcc = new ManipuladorClientes();
		String[][] listaClientes = mcc.clientes;

		int repetidor2 = 0;
		do {

			TelaVendas tv = new TelaVendas(funcionario, gerVer);
			String dadosCliente[] = tv.JOPVendasClientes(listaClientes);

			if (dadosCliente != null) {
				// Settando parâmetros do cliente locament
				this.cliente = new Cliente(dadosCliente[3], dadosCliente[2], dadosCliente[4], dadosCliente[0],
						Integer.parseInt(dadosCliente[1]));

				Object[] message = { "Estes são os dados do cliente: ", " >> Nome:", dadosCliente[2], " >> CPF:",
						dadosCliente[3], " >> Telefone:", dadosCliente[4], " >> Usuário:", dadosCliente[0],
						"Os dados estão corretos?" };

				int option = JOptionPane.showConfirmDialog(null, message, "Tela de Vendas - IndraCarShopApp",
						JOptionPane.OK_CANCEL_OPTION);

				if (option == JOptionPane.OK_OPTION) {
					repetidor2 = 1;
				}

			} else {
				repetidor2 = 2;
			}
		} while (repetidor2 == 0);

		if (repetidor2 == 1) {
			instanciamento = 1;
		}

		if (instanciamento == 1) {
			// Implementação do acesso ao banco de carros
			ManipuladorCarros mc = new ManipuladorCarros();
			String[][] listaCarros = mc.carros;

			int repetidor = 0;
			do {

				TelaVendas tc = new TelaVendas(funcionario, gerVer);
				String dadosCarro[] = tc.JOPVendas(listaCarros);

				if (dadosCarro != null) {
					// Settando parâmetros de carro localmente
					this.carro = new Carro(dadosCarro[0], dadosCarro[1], dadosCarro[2],
							Double.parseDouble(dadosCarro[3]));

					Object[] message = { "Estes são os dados do veículo escolhido: ", " >> Marca:", dadosCarro[0],
							" >> Modelo:", dadosCarro[1], " >>>> Apenas por: (R$)", dadosCarro[3],
							"Deseja prosseguir com a compra deste veículo?" };

					int option = JOptionPane.showConfirmDialog(null, message, "Tela de Vendas - IndraCarShopApp",
							JOptionPane.OK_CANCEL_OPTION);

					if (option == JOptionPane.OK_OPTION) {
						int repetidor3 = 0;
						do {

							JTextField parcelas = new JTextField();
							Object[] message2 = { "Em quantas parcelas será feito o pagamento?", parcelas };

							int option2 = JOptionPane.showConfirmDialog(null, message2,
									"Tela de Vendas - IndraCarShopApp", JOptionPane.OK_CANCEL_OPTION);

							if (option2 == JOptionPane.OK_OPTION) {

								try {
									// OPERAÇÃO DE VENDA
									Vendas venda = new Vendas(this.carro, this.cliente,
											Integer.parseInt(parcelas.getText()));
									mv = new ManipuladorVendas(venda);
									mv.escreveVenda(venda);
									try {
										mv.lerVenda();
										mv.fechaManipulador();
									} catch (IOException ioe) {
										ioe.printStackTrace();
									}
									repetidor3 = 1;
									repetidor = 1;
								} catch (java.lang.NumberFormatException x) {
									JOptionPane.showMessageDialog(null, "Quantidade de parcelas inválida!",
											"Tela de Vendas - IndraCarShopApp", JOptionPane.ERROR_MESSAGE);
								}
							} else {
								repetidor3 = 1;
							}
						} while (repetidor3 == 0);
					}

				} else {
					repetidor = 1;
				}
			} while (repetidor == 0);
		}
	}

	private String[] JOPVendas(String[][] carros) {

		String[] carrosMarcasModelos = new String[carros.length - 1];

		for (int i = 0; i < (carros.length - 1); i++) {

			carrosMarcasModelos[i] = (i) + " · " + carros[i][0] + " " + carros[i][1];

		}

		JFrame frame = new JFrame("Input Dialog With Multiple Options");
		String carroEscolhido = (String) JOptionPane.showInputDialog(frame, "Qual carro gostaria de visualizar?",
				"Tela de Vendas - IndraCarShopApp", JOptionPane.QUESTION_MESSAGE, null, carrosMarcasModelos,
				carrosMarcasModelos[0]);

		if (carroEscolhido != null) {
			// Avança a tela, mostra detalhes do carro
			String[] escolha = new String[2];
			escolha = carroEscolhido.split(" ·");
			int x = Integer.parseInt(escolha[0]);

			return carros[x]; // Dados do veículo escolhido

		} else {
			return null;
		}

	}

	private String[] JOPVendasClientes(String[][] clientes) {

		String[] clientesNomeCpf = new String[clientes.length - 1];

		for (int i = 0; i < (clientes.length - 1); i++) {

			clientesNomeCpf[i] = (i) + " · " + clientes[i][2] + " " + clientes[i][3];

		}

		JFrame frame = new JFrame("Input Dialog With Multiple Options");
		String clienteEscolhido = (String) JOptionPane.showInputDialog(frame,
				"Qual cliente gostaria de realizar a compra?", "Tela de Vendas - IndraCarShopApp",
				JOptionPane.QUESTION_MESSAGE, null, clientesNomeCpf, clientesNomeCpf[0]);

		if (clienteEscolhido != null) {
			// avança a tela, mostra detalhes do carro
			String[] escolha = new String[2];
			escolha = clienteEscolhido.split(" ·");
			int x = Integer.parseInt(escolha[0]);

			return clientes[x]; // deve ser os dados do cliente escolhido

		} else {
			return null;
		}

	}

}
