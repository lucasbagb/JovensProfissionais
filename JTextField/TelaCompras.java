package JTextField;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.ManipuladorCarros;
import DAO.ManipuladorVendas;
import Entidades.Carro;
import Entidades.Cliente;
import Entidades.Vendas;

public class TelaCompras {

	private Cliente cliente;
	private Carro carro;
	private ManipuladorVendas mv;

	public void JTPCompras(String campo) {

		// cliente[] = username, password, cpf, nome, telefone
		String[] cliente = campo.split(";");
		// Settando parâmetros do cliente locamente
		this.cliente = new Cliente(cliente[3], cliente[2], cliente[4], cliente[0], Integer.parseInt(cliente[1]));

		// implementação do acesso ao banco
		ManipuladorCarros mc = new ManipuladorCarros();
		String[][] listaCarros = mc.carros;

		int repetidor = 1;
		do {

			TelaCompras tc = new TelaCompras();
			String dadosCarro[] = tc.JOPCompras(listaCarros);

			if (dadosCarro != null) {
				// Settando parâmetros de carro localmente
				this.carro = new Carro(dadosCarro[0], dadosCarro[1], dadosCarro[2], Double.parseDouble(dadosCarro[3]));

				Object[] message = { "Estes são os dados do veículo escolhido: ", " >> Marca:", dadosCarro[0],
						" >> Modelo:", dadosCarro[1], " >>>> Apenas por: (R$)", dadosCarro[3],
						"Deseja prosseguir com a compra deste veículo?" };

				int option = JOptionPane.showConfirmDialog(null, message, "Tela de Compras - IndraCarShopApp",
						JOptionPane.OK_CANCEL_OPTION);

				if (option == JOptionPane.OK_OPTION) {
					int repetidor3 = 0;
					do {

						JTextField parcelas = new JTextField();
						Object[] message2 = { "Em quantas parcelas será feito o pagamento?", parcelas };

						int option2 = JOptionPane.showConfirmDialog(null, message2, "Tela de Compras - IndraCarShopApp",
								JOptionPane.OK_CANCEL_OPTION);

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
										"Tela de Compras - IndraCarShopApp", JOptionPane.ERROR_MESSAGE);
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

	private String[] JOPCompras(String[][] carros) {

		String[] carrosMarcasModelos = new String[carros.length - 1];

		for (int i = 0; i < (carros.length - 1); i++) {

			carrosMarcasModelos[i] = (i) + " · " + carros[i][0] + " " + carros[i][1];

		}

		JFrame frame = new JFrame("Input Dialog With Multiple Options");
		String carroEscolhido = (String) JOptionPane.showInputDialog(frame, "Qual carro gostaria de visualizar?",
				"Tela de Compras - IndraCarShopApp", JOptionPane.QUESTION_MESSAGE, null, carrosMarcasModelos,
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
}
