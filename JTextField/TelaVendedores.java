package JTextField;

import javax.swing.JOptionPane;

public class TelaVendedores {

	public void JTPVendedores(String campo) {
		String[] vendedor = campo.split(";");
		int repetidor = 0;
		do {
			Object[] options = { "Cadastro", "Venda", "Relatório", "Voltar" };

			switch (JOptionPane.showOptionDialog(null, "Deseja realizar qual operação?", "IndraCarShopApp",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0])) {

			case 0:
				// cadastro
				TelaCadastros tc = new TelaCadastros();
				tc.JTPCadastros();
				break;

			case 1:
				// vendas
				TelaVendas tv = new TelaVendas(vendedor);
				tv.JTPVendas();
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
