package DAO;

import java.io.IOException;

public class ManipuladorGerentes extends ManipuladorArquivo {

	private String[][] gerentes = super.campo;

	public ManipuladorGerentes() {
		super("C:/Users/lbonazza/workspace/ProjetoProva/Beta/Database/Gerentes.csv", 3);
	}

	public String[][] getGerentes() {
		return gerentes;
	}

	public void setGerentes(String[][] gerentes) {
		this.gerentes = gerentes;
	}

	public void comissaoGerente(String cadastro) {
		try {
			abreArquivo("C:/Users/lbonazza/workspace/ProjetoProva/Beta/Database/RelatorioComissao.csv");
			String linha = lerLinha();
			while (linha != null) {
				linha = lerLinha();
			}
			escreverLinha(cadastro);			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
