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

		Object[] message = { "Digite o usu�rio: ", user, "Digite a senha:", password };

		int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);

		int instancia = percorreLogins(user, password);

		if ((option == JOptionPane.OK_OPTION) && (instancia == 1)) {
			JOptionPane.showMessageDialog(null,
					"Bem-vindo, desejamos que tenha uma �tima experi�ncia em nosso aplicativo.", "Login",
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
			JOptionPane.showMessageDialog(null, "Senha inv�lida. Tente novamente.", "Login",
					JOptionPane.INFORMATION_MESSAGE);
			TelaLogin tl = new TelaLogin();
			tl.JTPLogin();
		} else if ((option == JOptionPane.OK_OPTION) && (instancia == 5)) {
			JOptionPane.showMessageDialog(null, "A senha deve conter apenas algarismos num�ricos!", "Login",
					JOptionPane.ERROR_MESSAGE);
			TelaLogin tl = new TelaLogin();
			tl.JTPLogin();
		} else if ((option == JOptionPane.OK_OPTION) && (instancia == 6)) {
			JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "Login",
					JOptionPane.ERROR_MESSAGE);
			TelaLogin tl = new TelaLogin();
			tl.JTPLogin();
		} else if ((option == JOptionPane.OK_OPTION) && (instancia == 0)) {
			JOptionPane.showMessageDialog(null, "Usu�rio inv�lido, verifique os seus dados.", "Login",
					JOptionPane.ERROR_MESSAGE);
			TelaLogin tl = new TelaLogin();
			tl.JTPLogin();
		} else {

		}
	}

	public int percorreLogins(JTextField user, JTextField password) {

		try {
			String usuario = user.getText().trim();
			int senha = Integer.parseInt(password.getText());

			// Percorre clientes
			ManipuladorClientes ma = new ManipuladorClientes();
			// ma.disponibilizaCadastros();

			for (int i = 0; i < ma.clientes.length; i++) {
				// o programa n�o acessa \/
				if (usuario.equals(ma.clientes[i][0].trim())) {
					if (senha == Integer.parseInt(ma.clientes[i][1])) {

						StringBuilder linha = new StringBuilder();

						for (int j = 0; j < ma.clientes[0].length; j++) {
							linha.append(ma.clientes[i][j]);
							if (j != (ma.clientes[0].length - 1)) {
								linha.append(";");
							}
						}

						userData = linha.toString();
						return 1;
					} else if (i == ma.clientes.length - 1) {
						return 4;
					}
				}
			}
			ma.fechaManipulador();

			// Percorre gerentes
			ManipuladorGerentes mg = new ManipuladorGerentes();
			// mg.disponibilizaCadastros();

			for (int j = 0; j < mg.gerentes.length; j++) {
				if (usuario.equals(mg.gerentes[j][0].trim())) {
					if (senha == Integer.parseInt(ma.campo[j][1])) {
						StringBuilder linha = new StringBuilder();

						for (int k = 0; k < ma.clientes[0].length; k++) {
							linha.append(ma.clientes[j][k]);
							if (k != (ma.clientes[0].length - 1)) {
								linha.append(";");
							}
						}

						userData = linha.toString();
						return 2;
					} else {
						return 4;
					}
				}
			}
			mg.fechaManipulador();

			// Percorre vendedores
			ManipuladorVendedores mv = new ManipuladorVendedores();
			// mv.disponibilizaCadastros();

			for (int k = 0; k < mv.vendedores.length; k++) {
				if (usuario.equals(mv.vendedores[k][0].trim())) {
					if (senha == Integer.parseInt(ma.campo[k][1])) {
						StringBuilder linha = new StringBuilder();

						for (int l = 0; l < ma.clientes[0].length; l++) {
							linha.append(ma.clientes[k][l]);
							if (l != (ma.clientes[0].length - 1)) {
								linha.append(";");
							}
						}

						userData = linha.toString();
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