package com.indracompany.carshopapp.JTextField.Cadastros;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.indracompany.carshopapp.Entidades.Administrador;

public class TelaCadFuncionarios {

	public void JTPFuncionarios() {

		JOptionPane.showMessageDialog(null, "Esta opera��o s� � permitida para o dono da loja!", "Cadastro de gerente - IndraCarShopApp - ATEN��O!",
				JOptionPane.WARNING_MESSAGE);

		JTextField password = new JPasswordField();

		Object[] message = { "Digite a sua senha de administrador:", password };

		int option = JOptionPane.showConfirmDialog(null, message, "Cadastro de funcion�rio - IndraCarShopApp", JOptionPane.OK_CANCEL_OPTION);
		if ((option == JOptionPane.OK_OPTION)
				&& (Integer.parseInt(password.getText())) == Administrador.senhaAdministrador) {

			int repeticao = 0;
			do {

				Object[] options = { "Gerente", "Vendedor", "Voltar" };

				switch (JOptionPane.showOptionDialog(null, "Deseja realizar que tipo de cadastro?", "Cadastro de funcion�rio - IndraCarShopApp",
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0])) {

				case 0:
					TelaCadGerentes tg = new TelaCadGerentes();
					tg.JTPGerentes();
					break;

				case 1:
					TelaCadVendedores tv = new TelaCadVendedores();
					tv.JTPVendedores();
					break;

				default:
					repeticao = 1;
					break;

				}
			} while (repeticao == 0);
		} else if ((option == JOptionPane.OK_OPTION)
				&& (Integer.parseInt(password.getText())) != Administrador.senhaAdministrador) {
			JOptionPane.showMessageDialog(null, "Senha inv�lida!", "ATEN��O!", JOptionPane.ERROR_MESSAGE);

			TelaCadFuncionarios tf = new TelaCadFuncionarios();
			tf.JTPFuncionarios();

		} else {
		}
	}
}
