package JTextField;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DAO.ManipuladorCarros;

public class TelaRelatoriosVendas {

	public void JTPRelatorios() {

		// implementação do acesso ao banco
		ManipuladorVendas mv = new ManipuladorVendas();
		String[] listaVendas = mv.arquivosVendas;

		int repetidor = 1;
		do {

			TelaRelatoriosVendas trv = new TelaRelatoriosVendas();
			String dadosRelatorios[] = trv.JOPRelatorios(listaVendas);

			if (dadosRelatorios != null) {
				
				// caminho do arquivo
				
				JOptionPane.showMessageDialog(null,
						"Bem-vindo, desejamos que tenha uma ótima experiência em nosso aplicativo.", "Relatórios de Vendas - IndraCarShopApp",
						JOptionPane.INFORMATION_MESSAGE);

				// DADOS DA VENDA

			} else {
				repetidor = 1;
			}
		} while (repetidor == 0);
	}

	private String JOPRelatorios(String[] vendas) {

		String[] vendasAnoMesDiaHoraMinuto = new String[vendas.length - 1];

		JFrame frame = new JFrame("Input Dialog With Multiple Options");
		String vendaEscolhida = (String) JOptionPane.showInputDialog(frame, "Qual venda gostaria de visualizar?",
				"Relatórios de Vendas - IndraCarShopApp", JOptionPane.QUESTION_MESSAGE, null, vendasAnoMesDiaHoraMinuto,
				vendasAnoMesDiaHoraMinuto[0]);

		if (vendaEscolhida!= null) {
			return "C:/Users/lbonazza/workspace/ProjetoProva/Beta/Database/RelatoriosVenda/" + vendaEscolhida + ".txt" ;

		} else {
			return null;
		}

	}
}