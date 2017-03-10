package JTextField;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DAO.ManipuladorCarros;
import DAO.ManipuladorClientes;
import Entidades.Gerente;
import Entidades.Vendedor;

public class TelaVendas {

	Gerente gerente = new Gerente(null, null, 0);
	Vendedor vendedor = new Vendedor(null, null, 0);

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

				Object[] message = { "Estes são os dados do cliente: ", " >> Nome:", dadosCliente[2], " >> CPF:",
						dadosCliente[3], " >> Telefone:", dadosCliente[4], " >> Usuário:", dadosCliente[0],
						"Os dados estão corretos?" };

				int option = JOptionPane.showConfirmDialog(null, message, "Venda de veículos - IndraCarShopApp",
						JOptionPane.OK_CANCEL_OPTION);

				if (option == JOptionPane.OK_OPTION) {
					repetidor2 = 1;
				}

			} else {
				repetidor2 = 1;
			}
		} while (repetidor2 == 0);

		if (repetidor2 == 1) {
			instanciamento = 1;
		}

		if (instanciamento == 1) {
			// implementação do acesso ao banco de carros
			ManipuladorCarros mc = new ManipuladorCarros();
			String[][] listaCarros = mc.carros;

			int repetidor = 0;
			do {

				TelaVendas tc = new TelaVendas(funcionario, gerVer);
				String dadosCarro[] = tc.JOPVendas(listaCarros);

				if (dadosCarro != null) {

					Object[] message = { "Estes são os dados do veículo escolhido: ", " >> Marca:", dadosCarro[0],
							" >> Modelo:", dadosCarro[1], " >>>> Apenas por: (R$)", dadosCarro[3],
							"Deseja prosseguir com a compra deste veículo?" };

					int option = JOptionPane.showConfirmDialog(null, message, "Compra de veículos - IndraCarShopApp",
							JOptionPane.OK_CANCEL_OPTION);

					if (option == JOptionPane.OK_OPTION) {

						// OPERAÇÃO DE VENDA
						// usar dadosCarro e dadosCliente

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
				"Venda de veículos - IndraCarShopApp", JOptionPane.QUESTION_MESSAGE, null, carrosMarcasModelos,
				carrosMarcasModelos[0]);

		if (carroEscolhido != null) {
			// avança a tela, mostra detalhes do carro
			String[] escolha = new String[2];
			escolha = carroEscolhido.split(" ·");
			int x = Integer.parseInt(escolha[0]);

			return carros[x]; // deve ser os dados do veículo escolhido

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
				"Qual cliente gostaria de realizar a compra?", "Venda de veículos - IndraCarShopApp",
				JOptionPane.QUESTION_MESSAGE, null, clientesNomeCpf, clientesNomeCpf[0]);

		if (clienteEscolhido != null) {
			// avança a tela, mostra detalhes do carro
			String[] escolha = new String[2];
			escolha = clienteEscolhido.split(" ·");
			int x = Integer.parseInt(escolha[0]);

			return clientes[x]; // deve ser os dados do veículo escolhido

		} else {
			return null;
		}

	}

}
