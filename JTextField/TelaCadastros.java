package JTextField;

import javax.swing.JOptionPane;

import JTextField.Cadastros.TelaCadCarros;
import JTextField.Cadastros.TelaCadFuncionarios;

public class TelaCadastros {

	public void JTPCadastros() {
		int repeticao = 0;
		do {
			Object[] options = { "Carro", "Funcionário", "Voltar" };

			switch (JOptionPane.showOptionDialog(null, "Deseja realizar que tipo de cadastro?", "IndraCarShopApp",
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
				repeticao = 1;
				break;

			}
		} while (repeticao == 0);
	}

}
