package JTextField;

import javax.swing.JOptionPane;

public class TelaGerentes {

	public void JTPGerentes(String campo) {
		String[] gerente = campo.split(";");
		int repetidor = 0;
		do {
			Object[] options = { "Cadastro", "Venda", "Relatório", "Voltar" };

			switch (JOptionPane.showOptionDialog(null, "Deseja realizar qual operação?", "Tela Gerentes - IndraCarShopApp",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0])) {

			case 0:
				// cadastro
				TelaCadastros tc = new TelaCadastros();
				tc.JTPCadastros();
				break;

			case 1:
				// vendas
				TelaVendas tv = new TelaVendas(gerente, 2);
				tv.JTPVendas(gerente, 2);
				break;

			case 2:
				// relatorios
				TelaRelatorios tr = new TelaRelatorios();
				tr.JTPRelatorios();
				break;

			default:
				repetidor = 1;
				break;

			}

		} while (repetidor == 0);
	}
}
