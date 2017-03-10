package JTextField;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DAO.ManipuladorCarros;

public class TelaCompras {

	public void JTPCompras(String campo) {

		String[] cliente = campo.split(";");
		// cliente[] = username, password, cpf, nome, telefone

		// implementação do acesso ao banco
		ManipuladorCarros mc = new ManipuladorCarros();
		String[][] listaCarros = mc.carros;

		int repetidor = 1;
		do {

			TelaCompras tc = new TelaCompras();
			String dadosCarro[] = tc.JOPCompras(listaCarros);

			if (dadosCarro != null) {

				Object[] message = { "Estes são os dados do veículo escolhido: ", " >> Marca:", dadosCarro[0], " >> Modelo:",
						dadosCarro[1], " >>>> Apenas por: (R$)", dadosCarro[3],
						"Deseja prosseguir com a compra deste veículo?" };

				int option = JOptionPane.showConfirmDialog(null, message, "Compra de veículos - IndraCarShopApp",
						JOptionPane.OK_CANCEL_OPTION);

				if (option == JOptionPane.OK_OPTION) {

					// OPERAÇÃO DE COMPRA
					// usar dadosCarro e dadosCliente

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
				"Compra de veículos - IndraCarShopApp", JOptionPane.QUESTION_MESSAGE, null, carrosMarcasModelos,
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
