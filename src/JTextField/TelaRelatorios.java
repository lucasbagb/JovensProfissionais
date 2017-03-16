package JTextField;

import javax.swing.JOptionPane;

public class TelaRelatorios {
	
	public void JTPRelatorios(){
		
		int repeticao = 0;
		do {

			Object[] options = { "Vendas", "Comissão", "Voltar" };

			switch (JOptionPane.showOptionDialog(null, "Deseja visualizar qual tipo de relatório?", "Tela Relatórios - IndraCarShopApp",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0])) {

			case 0:
				TelaRelatoriosVendas trv = new TelaRelatoriosVendas();
				trv.JTPRelatoriosVendas();
				break;

			case 1:
				TelaRelatoriosComissao trc = new TelaRelatoriosComissao();
				trc.JTPRelatoriosComissao();
				break;

			default:
				repeticao = 1;
				break;

			}
		} while (repeticao == 0);
		
	}

}
