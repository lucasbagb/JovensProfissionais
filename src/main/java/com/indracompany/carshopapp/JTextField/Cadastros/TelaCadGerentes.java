package com.indracompany.carshopapp.JTextField.Cadastros;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.indracompany.carshopapp.DAO.ManipuladorGerentes;
import com.indracompany.carshopapp.Entidades.Gerente;
import com.indracompany.carshopapp.JTextField.HintTextField;
import com.indracompany.carshopapp.Validadores.ValidaCadastro;

public class TelaCadGerentes {

	public void JTPGerentes() {
		int repeticao = 0;
		do {

			JTextField nome = new HintTextField("Joao da Silva");
			JTextField user = new HintTextField("jsilva");
			JTextField password = new JPasswordField();
			JTextField password1 = new JPasswordField();

			Object[] message = { "Digite seu nome: ", nome, "Digite o usu�rio: ", user, "Digite a senha:", password,
					"Confirme a senha:", password1 };

			int option = JOptionPane.showConfirmDialog(null, message, "Cadastro de gerente - IndraCarShopApp",
					JOptionPane.OK_CANCEL_OPTION);

			if (option == JOptionPane.OK_OPTION) {

				ValidaCadastro vc = new ValidaCadastro();

				try {
					Integer password2 = Integer.parseInt(password.getText());
					Integer password3 = Integer.parseInt(password1.getText());

					if (nome.getText().isEmpty() || user.getText().isEmpty() || password.getText().isEmpty()
							|| password1.getText().isEmpty()) {
						vc.ValidadorCamposFuncionarios(nome, user, password, password1);

					} else if (password2 != password3) {
						vc.ValidadorSenhas(password, password1);

					} else {

						Gerente gerente = new Gerente(nome.getText(), user.getText(),
								Integer.parseInt(password.getText()));
						ManipuladorGerentes mg = new ManipuladorGerentes();
						try {
							mg.escreveCadastros(gerente.toString());
							mg.fechaManipulador();
							repeticao = 1;
						} catch (IOException ioe) {
							System.out.println(ioe.getStackTrace());
						}
						JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.",
								"Cadastro de gerente - IndraCarShopApp", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (java.lang.NumberFormatException x) {
					JOptionPane.showMessageDialog(null, "A senha deve conter apenas algarismos num�ricos!",
							"Cadastro de gerente - IndraCarShopApp", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				repeticao = 1;

			}
		} while (repeticao == 0);
	}

	public void ValidaGerentes() {

	}
}
