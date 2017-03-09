package Validadores;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ValidaCadastro {

	public boolean ValidadorSenhas(JTextField password, JTextField password1) {

		try {
			Integer password2 = Integer.parseInt(password.getText());
			Integer password3 = Integer.parseInt(password1.getText());

			if (password2 == password3) {

				return true;

			} else {
				JOptionPane.showMessageDialog(null, "As senhas não coincidem", "Login", JOptionPane.ERROR_MESSAGE);
				return false;

			}

		} catch (java.lang.NumberFormatException x) {
			JOptionPane.showMessageDialog(null, "A senha deve conter apenas algarismos numéricos!", "Login",
					JOptionPane.ERROR_MESSAGE);
			return false;

		}

	}

	public boolean ValidadorCamposFuncionarios(JTextField nome, JTextField user, JTextField password,
			JTextField password1) {
		if (nome.getText().isEmpty() || user.getText().isEmpty() || password.getText().isEmpty() || password1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Favor preencher todos os campos!", "Cadastro de novo usuário",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			return true;
		}
	}

	public boolean ValidadorCamposCarros(JTextField marca, JTextField modelo, JTextField placa, JTextField preco) {
		if (marca.getText().isEmpty() || modelo.getText().isEmpty() || placa.getText().isEmpty() || preco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Favor preencher todos os campos!", "Cadastro de novo usuário",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			return true;
		}
	}
	
	

	public boolean ValidadorCamposClientes(JTextField cpf, JTextField nome, JTextField telefone, JTextField user,
			JTextField password, JTextField password1) {
		if (cpf.getText().isEmpty() || nome.getText().isEmpty() || telefone.getText().isEmpty()
				|| user.getText().isEmpty() || password.getText().isEmpty() || password1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Favor preencher todos os campos!", "Cadastro de novo usuário",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			return true;
		}
	}
}
