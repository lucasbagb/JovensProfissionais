package com.indracompany.carshopapp.JTextField;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.indracompany.carshopapp.DAO.ManipuladorClientes;
import com.indracompany.carshopapp.DAO.ManipuladorGerentes;
import com.indracompany.carshopapp.DAO.ManipuladorVendedores;

public class TelaLogin {

	static String userData;

	public void JTPLogin() {

		JTextField user = new JTextField();
		JTextField password = new JPasswordField();

		Object[] message = { "Digite o usu�rio: ", user, "Digite a senha:", password };

		int option = JOptionPane.showConfirmDialog(null, message, "Login - IndraCarShopApp",
				JOptionPane.OK_CANCEL_OPTION);

		int instancia = percorreLogins(user, password);

		if ((option == JOptionPane.OK_OPTION) && (instancia == 1)) {
			JOptionPane.showMessageDialog(null,
					"Bem-vindo, desejamos que tenha uma �tima experi�ncia em nosso aplicativo.",
					"Login - IndraCarShopApp", JOptionPane.INFORMATION_MESSAGE);
			TelaCompras tc = new TelaCompras();
			tc.JTPCompras(userData);
		} else if ((option == JOptionPane.OK_OPTION) && (instancia == 2)) {
			TelaGerentes to = new TelaGerentes();
			to.JTPGerentes(userData);
		} else if ((option == JOptionPane.OK_OPTION) && (instancia == 3)) {
			TelaVendedores tv = new TelaVendedores();
			tv.JTPVendedores(userData);
		} else if ((option == JOptionPane.OK_OPTION) && (instancia == 4)) {
			JOptionPane.showMessageDialog(null, "Senha e/ou username incorretos. Tente novamente.",
					"Login - IndraCarShopApp", JOptionPane.INFORMATION_MESSAGE);
			TelaLogin tl = new TelaLogin();
			tl.JTPLogin();
		} else if ((option == JOptionPane.OK_OPTION) && (instancia == 5)) {
			JOptionPane.showMessageDialog(null, "A senha deve conter apenas algarismos num�ricos!",
					"Login - IndraCarShopApp", JOptionPane.ERROR_MESSAGE);
			TelaLogin tl = new TelaLogin();
			tl.JTPLogin();
		} else if ((option == JOptionPane.OK_OPTION) && (instancia == 6)) {
			JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "Login - IndraCarShopApp",
					JOptionPane.ERROR_MESSAGE);
			TelaLogin tl = new TelaLogin();
			tl.JTPLogin();
		} else if ((option == JOptionPane.OK_OPTION) && (instancia == 0)) {
			JOptionPane.showMessageDialog(null, "Usu�rio inv�lido, verifique os seus dados.", "Login - IndraCarShopApp",
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
				if (ma.clientes[i][0] != null) {
					if (usuario.equals(ma.clientes[i][0])) {
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
							continue;
						}
					}
				}
			}
			ma.fechaManipulador();

			// Percorre gerentes
			ManipuladorGerentes mg = new ManipuladorGerentes();
			// mg.disponibilizaCadastros();

			for (int j = 0; j < mg.gerentes.length; j++) {
				if (mg.gerentes[j][0] != null) {
					if (usuario.equals(mg.gerentes[j][0])) {
						if (senha == Integer.parseInt(mg.gerentes[j][1])) {
							StringBuilder linha = new StringBuilder();

							for (int k = 0; k < mg.gerentes[0].length; k++) {
								linha.append(mg.gerentes[j][k]);
								if (k != (mg.gerentes[0].length - 1)) {
									linha.append(";");
								}
							}

							userData = linha.toString();
							return 2;
						} else if (j == mg.gerentes.length - 1) {
							continue;
						}
					}
				}
			}
			mg.fechaManipulador();

			// Percorre vendedores
			ManipuladorVendedores mv = new ManipuladorVendedores();
			// mv.disponibilizaCadastros();

			for (int k = 0; k < mv.vendedores.length; k++) {
				if (mv.vendedores[k][0] != null) {
					if (usuario.equals(mv.vendedores[k][0].trim())) {
						if (senha == Integer.parseInt(ma.campo[k][1])) {
							StringBuilder linha = new StringBuilder();

							for (int l = 0; l < mv.vendedores[0].length; l++) {
								linha.append(mv.vendedores[k][l]);
								if (l != (mv.vendedores[0].length - 1)) {
									linha.append(";");
								}
							}

							userData = linha.toString();
							return 3;
						} else if (k == mv.vendedores.length - 1) {
							return 4;
						}
					}
				} else {
					return 4;
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