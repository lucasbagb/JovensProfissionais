package JTextField;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TelaCompras {

	public void JTPCompras(String campo) {

		String[] cliente = campo.split(";");
		// cliente[] = username, password, cpf, nome, telefone

		// implementa��o do acesso ao banco

		String[][] listaCarros = null; // acrescer new String e as dimens�es
		// o String listaCarros deve ser preenchido pelos dados do BD
		
		int repetidor = 1;
		do {

			TelaCompras tc = new TelaCompras();
			String dadosCarro[] = tc.JOPCompras(listaCarros);

			if (dadosCarro != null) {

				Object[] message = { "Estes s�o os dados do ve�culo escolhido: ", "Marca:", dadosCarro[0], "Modelo:",
						dadosCarro[1], "Apenas por: (R$)", dadosCarro[3],
						"Deseja prosseguir com a compra deste ve�culo?" };

				int option = JOptionPane.showConfirmDialog(null, message, "Compra de ve�culos - IndraCarShopApp",
						JOptionPane.OK_CANCEL_OPTION);
			} else {
				repetidor = 1;
			}
		} while (repetidor == 0);
	}

	public String[] JOPCompras(String[][] carros) {

		String[] carrosMarcasModelos = new String[carros.length];

		for (int i = 0; i < carros.length; i++) {

			carrosMarcasModelos[i] = (i) + "." + carros[i][0] + " " + carros[i][1];

			System.out.println(carrosMarcasModelos[i]);

		}

		JFrame frame = new JFrame("Input Dialog With Multiple Options");
		String carroEscolhido = (String) JOptionPane.showInputDialog(frame, "Qual carro gostaria de visualizar?",
				"Compra de ve�culos - IndraCarShopApp", JOptionPane.QUESTION_MESSAGE, null, carrosMarcasModelos,
				carrosMarcasModelos[0]);

		if (carroEscolhido != null) {
			// avan�a a tela, mostra detalhes do carro

			String[] escolha = carroEscolhido.split(".");

			int x = Integer.parseInt(escolha[0]);

			return carros[x]; // deve ser os dados do ve�culo escolhido

		} else {
			return null;
		}

	}
}
