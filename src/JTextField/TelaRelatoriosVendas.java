package JTextField;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DAO.ManipuladorVendas;

public class TelaRelatoriosVendas {

	public void JTPRelatoriosVendas() {

		// implementação do acesso ao banco
		ManipuladorVendas mv = new ManipuladorVendas();
		String[] listaVendas = mv.arquivosVendas;
		try {
			mv.fechaManipulador();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		int repetidor = 1;
		do {

			TelaRelatoriosVendas trv = new TelaRelatoriosVendas();
			String caminhoRelatorio = trv.JOPRelatoriosVendas(listaVendas);

			if (caminhoRelatorio != null) {

				ManipuladorVendas report = new ManipuladorVendas(caminhoRelatorio);
				String relatorio = null;

				try {
					relatorio = report.lerArquivoVenda();
					report.fechaManipulador();
				} catch (IOException e) {
					e.printStackTrace();
				}

				JOptionPane.showMessageDialog(null, relatorio, "Relatórios de Vendas - IndraCarShopApp",
						JOptionPane.INFORMATION_MESSAGE);

			} else {
				repetidor = 1;
			}
		} while (repetidor == 0);
	}

	private String JOPRelatoriosVendas(String[] vendas) {

		String[] vendasAnoMesDiaHoraMinuto = new String[vendas.length - 1];

		for (int i = 0; i < vendas.length - 1; i++) {
			vendasAnoMesDiaHoraMinuto[i] = vendas[i];
		}

		JFrame frame = new JFrame("Input Dialog With Multiple Options");
		String vendaEscolhida = (String) JOptionPane.showInputDialog(frame, "Qual venda gostaria de visualizar?",
				"Relatórios de Vendas - IndraCarShopApp", JOptionPane.QUESTION_MESSAGE, null, vendasAnoMesDiaHoraMinuto,
				vendasAnoMesDiaHoraMinuto[0]);

		if (vendaEscolhida != null) {
			return "C:/Users/lbonazza/workspace/ProjetoProva/Beta/Database/RelatoriosVenda/" + vendaEscolhida + ".txt";

		} else {
			return null;
		}

	}
}