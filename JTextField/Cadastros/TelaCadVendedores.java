package JTextField.Cadastros;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.ManipuladorGerentes;
import DAO.ManipuladorVendedores;
import Entidades.Vendedor;
import JTextField.HintTextField;
import Validadores.ValidaCadastro;

public class TelaCadVendedores {

	public void JTPVendedores() {
		int repeticao = 0;
		do {

			ManipuladorGerentes mg = new ManipuladorGerentes();
			String[][] listaGerentes = mg.gerentes;

			TelaCadVendedores tcv = new TelaCadVendedores();
			String responsavel = tcv.JOPVendedores(listaGerentes);

			JTextField nome = new HintTextField("Joao da Silva");
			JTextField user = new HintTextField("jsilva");
			JTextField password = new JPasswordField();
			JTextField password1 = new JPasswordField();

			String gerente = responsavel;

			Object[] message = { "Digite seu nome: ", nome, "Digite o usuário: ", user, "Digite a senha:", password,
					"Confirme a senha:", password1 };

			int option = JOptionPane.showConfirmDialog(null, message, "Cadastro de novo vendedor",
					JOptionPane.OK_CANCEL_OPTION);

			if (option == JOptionPane.OK_OPTION) {

				ValidaCadastro vc = new ValidaCadastro();

				if ((vc.ValidadorCamposFuncionarios(nome, user, password, password1))
						&& vc.ValidadorSenhas(password, password1)) {

					Vendedor vendedor = new Vendedor(nome.getText(), user.getText(),
							Integer.parseInt(password.getText()), gerente);

					ManipuladorVendedores mv = new ManipuladorVendedores();
					try {
						mv.escreveCadastros(vendedor.toString());
						mv.fechaManipulador();
					} catch (IOException ioe) {
						System.out.println(ioe.getStackTrace());
					}
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.", "Cadastro de novo vendedor",
							JOptionPane.INFORMATION_MESSAGE);
				}

			} else {
				repeticao = 1;

			}
		} while (repeticao == 0);
	}

	private String JOPVendedores(String[][] gerentes) {

		String[] gerentesNomes = new String[gerentes.length - 1];

		for (int i = 0; i < (gerentes.length - 1); i++) {

			gerentesNomes[i] = (i) + " · " + gerentes[i][2];

		}

		JFrame frame = new JFrame("Input Dialog With Multiple Options");
		String carroEscolhido = (String) JOptionPane.showInputDialog(frame,
				"Qual será o responsável por este vendedor?", "Cadastro de vendedor - IndraCarShopApp",
				JOptionPane.QUESTION_MESSAGE, null, gerentesNomes, gerentesNomes[0]);

		if (carroEscolhido != null) {
			// avança a tela, mostra detalhes do carro
			String[] escolha = new String[2];
			escolha = carroEscolhido.split(" ·");
			int x = Integer.parseInt(escolha[0]);

			return gerentes[x][2]; // deve ser os dados do veículo escolhido

		} else {
			return null;
		}

	}

}
