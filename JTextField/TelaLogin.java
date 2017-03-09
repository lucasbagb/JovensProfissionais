package JTextField;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.ManipuladorClientes;
import DAO.ManipuladorGerentes;
import DAO.ManipuladorVendedores;

public class TelaLogin {

	static String userData;

	public void JTPLogin() {

		JTextField user = new JTextField();
		JTextField password = new JPasswordField();

		Object[] message = { "Digite o usuário: ", user, "Digite a senha:", password };

		int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);

		int instancia = percorreLogins(user, password);

		if ((option == JOptionPane.OK_OPTION) && (instancia == 1)) {
			JOptionPane.showMessageDialog(null,
					"Bem-vindo, desejamos que tenha uma ótima experiência em nosso aplicativo.", "Login",
					JOptionPane.INFORMATION_MESSAGE);
			TelaCompras tc = new TelaCompras();
			tc.JTPCompras(userData);
		} else if ((option == JOptionPane.OK_OPTION) && (instancia == 2)) {
			TelaGerentes to = new TelaGerentes();
			to.JTPGerentes(userData);
		} else if ((option == JOptionPane.OK_OPTION) && (instancia == 3)) {
			TelaVendedores tv = new TelaVendedores();
			tv.JTPVendedores(userData);
		} else if ((option == JOptionPane.OK_OPTION) && (instancia == 4)) {
			JOptionPane.showMessageDialog(null, "Senha inválida. Tente novamente.", "Login",
					JOptionPane.INFORMATION_MESSAGE);
			TelaLogin tl = new TelaLogin();
			tl.JTPLogin();
		} else if ((option == JOptionPane.OK_OPTION) && (instancia == 5)) {
			JOptionPane.showMessageDialog(null, "A senha deve conter apenas algarismos numéricos!", "Login",
					JOptionPane.ERROR_MESSAGE);
			TelaLogin tl = new TelaLogin();
			tl.JTPLogin();
		} else if ((option == JOptionPane.OK_OPTION) && (instancia == 6)) {
			JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "Login",
					JOptionPane.ERROR_MESSAGE);
			TelaLogin tl = new TelaLogin();
			tl.JTPLogin();
		} else if ((option == JOptionPane.OK_OPTION) && (instancia == 0)) {
			JOptionPane.showMessageDialog(null, "Usuário inválido, verifique os seus dados.", "Login",
					JOptionPane.ERROR_MESSAGE);
			TelaLogin tl = new TelaLogin();
			tl.JTPLogin();
		} else {

		}
	}

	public int percorreLogins(JTextField user, JTextField password) {

		try {
			String usuario = user.getText();
			int senha = Integer.parseInt(password.getText());

			// Percorre clientes
			ManipuladorClientes ma = new ManipuladorClientes();
			ma.disponibilizaCadastros();

			for (int i = 0; i < ma.campo.length; i++) {
				// o programa não acessa \/
				if (usuario == ma.campo[i][0]) {
					if (senha == Integer.parseInt(ma.campo[i][1])) {
						userData = ma.campo[i].toString();
						return 1;
					} else {
						return 4;
					}
				}
			}
			ma.fechaManipulador();

			// Percorre gerentes
			ManipuladorGerentes mg = new ManipuladorGerentes();
			mg.disponibilizaCadastros();

			for (int j = 0; j < ma.campo.length; j++) {
				if (usuario == ma.campo[j][0]) {
					if (senha == Integer.parseInt(ma.campo[j][1])) {
						userData = mg.campo[j].toString();
						return 2;
					} else {
						return 4;
					}
				}
			}
			mg.fechaManipulador();

			// Percorre vendedores
			ManipuladorVendedores mv = new ManipuladorVendedores();
			mv.disponibilizaCadastros();

			for (int k = 0; k < ma.campo.length; k++) {
				if (usuario == ma.campo[k][0]) {
					if (senha == Integer.parseInt(ma.campo[k][1])) {
						userData = mv.campo[k].toString();
						return 3;
					} else {
						return 4;
					}
				}
			}
			mv.fechaManipulador();
			return 0;

		} catch (java.lang.NumberFormatException x) {
			if (user.getText().isEmpty() || password.getText().isEmpty()) {
				return 6;
			} else {
				return 5;
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return 0;
		}

	}

}