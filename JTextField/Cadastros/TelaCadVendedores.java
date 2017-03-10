package JTextField.Cadastros;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.ManipuladorVendedores;
import Entidades.Vendedor;
import JTextField.HintTextField;
import Validadores.ValidaCadastro;

public class TelaCadVendedores {

	public void JTPVendedores() {
		int repeticao = 0;
		do {

			JTextField nome = new HintTextField("Joao da Silva");
			JTextField user = new HintTextField("jsilva");
			JTextField password = new JPasswordField();
			JTextField password1 = new JPasswordField();
			JTextField gerente = new JTextField("Marcos Ribeiro");

			Object[] message = { "Digite seu nome: ", nome, "Digite o usuário: ", user, "Digite a senha:", password,
					"Confirme a senha:", password1, "Digite o nome de seu gerente responsável:", gerente };

			int option = JOptionPane.showConfirmDialog(null, message, "Cadastro de novo vendedor",
					JOptionPane.OK_CANCEL_OPTION);

			if (option == JOptionPane.OK_OPTION) {

				ValidaCadastro vc = new ValidaCadastro();

				/*
				 * if (vc.ValidadorCamposFuncionarios(nome, user, password,
				 * password1)) { vc.ValidadorCamposFuncionarios(nome, user,
				 * password, password1); } else if (vc.ValidadorSenhas(password,
				 * password1)) { vc.ValidadorSenhas(password, password1); } else
				 */

				if (vc.ValidadorSenhas(password, password1)
						&& (vc.ValidadorCamposFuncionarios(nome, user, password, password1))) {

					Vendedor vendedor = new Vendedor(nome.getText(), user.getText(),
							Integer.parseInt(password.getText()));

					if (vendedor.cruzaDadosGerente(gerente.getText())) {

						ManipuladorVendedores mv = new ManipuladorVendedores();
						try {
							mv.escreveCadastros(vendedor.toString());
							mv.fechaManipulador();
						} catch (IOException ioe) {
							System.out.println(ioe.getStackTrace());
						}
						JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.",
								"Cadastro de novo vendedor", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null,
								"Não há gerentes cadastrados no sistema com esse nome! Cheque a sintaxe e/ou registros",
								"Cadastro - Vendedor", JOptionPane.ERROR_MESSAGE);
					}
				}

			} else {
				repeticao = 1;

			}
		} while (repeticao == 0);
	}

	public void ValidaVendedores() {

	}
}
