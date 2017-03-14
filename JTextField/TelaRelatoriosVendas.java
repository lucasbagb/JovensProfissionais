package JTextField;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DAO.ManipuladorVendas;

public class TelaRelatoriosVendas {

	public void JTPRelatorios() {

		// implementação do acesso ao banco
		ManipuladorVendas mv = new ManipuladorVendas();
		String[] listaVendas = mv.arquivosVendas;

		int repetidor = 1;
		do {

			TelaRelatoriosVendas trv = new TelaRelatoriosVendas();
			String caminhoRelatorio = trv.JOPRelatorios(listaVendas);

			if (caminhoRelatorio != null) {
				
				ManipuladorVendas report = new ManipuladorVendas(caminhoRelatorio);
				
				try {
					String relatorio = report.lerVenda();
					report.fechaManipulador();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null,
						"Bem-vindo, desejamos que tenha uma ótima experiência em nosso aplicativo.", "Relatórios de Vendas - IndraCarShopApp",
						JOptionPane.INFORMATION_MESSAGE);

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