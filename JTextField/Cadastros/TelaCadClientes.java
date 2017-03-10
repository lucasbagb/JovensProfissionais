package JTextField.Cadastros;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.ManipuladorClientes;
import Entidades.Cliente;
import Validadores.ValidaCadastro;

public class TelaCadClientes {

	public void JTPClientes() {
		int repetidor = 0;
		do {

			JTextField cpf = new JTextField();
			JTextField nome = new JTextField();
			JTextField telefone = new JTextField();
			JTextField user = new JTextField();
			JTextField password = new JPasswordField(6);
			JTextField password1 = new JPasswordField(6);

			Object[] message = { "Digite seu nome: ", nome, "Digite seu CPF: ", cpf, "Digite seu telefone: ", telefone,
					"Digite o usuário: ", user, "Digite a senha:", password, "Confirme a senha:", password1 };

			int option = JOptionPane.showConfirmDialog(null, message, "Cadastro de novo usuário",
					JOptionPane.OK_CANCEL_OPTION);

			if (option == JOptionPane.OK_OPTION) {

				ValidaCadastro vc = new ValidaCadastro();
				try {
					Integer password2 = Integer.parseInt(password.getText());
					Integer password3 = Integer.parseInt(password1.getText());

					if (nome.getText().isEmpty() || user.getText().isEmpty() || password.getText().isEmpty()
							|| password1.getText().isEmpty()) {
						vc.ValidadorCamposClientes(cpf, nome, telefone, user, password, password1);

					} else if (password2 != password3) {
						vc.ValidadorSenhas(password, password1);

					} else {

						Cliente cliente = new Cliente(cpf.getText(), nome.getText(), telefone.getText(), user.getText(),
								Integer.parseInt(password.getText()));
						ManipuladorClientes mc = new ManipuladorClientes();
						try {
							mc.escreveCadastros(cliente.toString());
							mc.fechaManipulador();
						} catch (IOException ioe) {
							System.out.println(ioe.getStackTrace());
						}
						JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.",
								"Cadastro de novo cliente", JOptionPane.INFORMATION_MESSAGE);
						repetidor = 1;
					}
				} catch (java.lang.NumberFormatException x) {
					JOptionPane.showMessageDialog(null, "A senha deve conter apenas algarismos numéricos!", "Login",
							JOptionPane.ERROR_MESSAGE);
				}

			} else {

				repetidor = 1;

			}
		} while (repetidor == 0);
	}
}
