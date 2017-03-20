package com.indracompany.carshopapp.JTextField;

import javax.swing.JOptionPane;

import com.indracompany.carshopapp.JTextField.Cadastros.TelaCadClientes;

public class TelaBoasVindas {

	public void JTPBoasVindas() {

		int repeticao = 0;
		do {

			Object[] options = { "Acesso", "Cadastro", "Sair" };

			switch (JOptionPane.showOptionDialog(null, "Bem vindo a IndraCarShop!", "IndraCarShopApp",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0])) {

			case 0:
				TelaLogin tl = new TelaLogin();
				tl.JTPLogin();
				break;

			case 1:
				TelaCadClientes tc = new TelaCadClientes();
				tc.JTPClientes();
				break;

			default:
				JOptionPane.showMessageDialog(null, "Obrigado por acessar nosso aplicativo.", "IndraCarShopApp",
						JOptionPane.INFORMATION_MESSAGE);
				repeticao = 1;
				break;

			}
		} while (repeticao == 0);
	}
}
