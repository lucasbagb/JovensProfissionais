package com.indracompany.carshopapp.JTextField;

import javax.swing.JOptionPane;

import com.indracompany.carshopapp.JTextField.Cadastros.TelaCadCarros;
import com.indracompany.carshopapp.JTextField.Cadastros.TelaCadFuncionarios;

public class TelaCadastros {

	public void JTPCadastros() {
		int repetidor = 0;
		do {
			Object[] options = { "Carro", "Funcion�rio", "Voltar" };

			switch (JOptionPane.showOptionDialog(null, "Deseja realizar que tipo de cadastro?", "Tela de Cadastros - IndraCarShopApp",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0])) {

			case 0:
				TelaCadCarros tca = new TelaCadCarros();
				tca.JTPCarros();
				break;
			case 1:
				TelaCadFuncionarios tf = new TelaCadFuncionarios();
				tf.JTPFuncionarios();
				break;
			default:
				repetidor = 1;
				break;

			}
		} while (repetidor == 0);
	}

}
