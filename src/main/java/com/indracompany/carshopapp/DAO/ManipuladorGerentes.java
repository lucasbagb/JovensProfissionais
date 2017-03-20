package com.indracompany.carshopapp.DAO;

import java.io.IOException;

public class ManipuladorGerentes extends ManipuladorArquivo {

	public String[][] gerentes;

	public ManipuladorGerentes() {
		super("C:/Users/lbonazza/workspace/ProjetoProva/Beta/Database/Gerentes.csv", 3);
	}

	public String[][] getGerentes() {
		return gerentes;
	}

	public void setGerentes(String[][] gerentes) {
		this.gerentes = gerentes;
	}
	
	@Override
	public void disponibilizaCadastros() throws IOException {

		int qntdLinhas = percorreCadastrosGerais();

		this.gerentes = new String[qntdLinhas][this.colunas];

		this.lerArquivo.reset();
		String linha = lerLinha();
		
			for (int i = 0; i < qntdLinhas; i++) {
				if (linha != null) {
					String[] c = linha.split(";");
					for (int j = 0; j < this.colunas; j++) {
						this.gerentes[i][j] = c[j];
					}
					linha = lerLinha();
				}
			}
	}
	
	@Override
	public String getLinha(int indice){
		StringBuilder linha = new StringBuilder();
		for (int j = 0; j < this.gerentes[0].length; j++){
			linha.append(gerentes[indice][j]);
			if (j != (this.gerentes[0].length - 1)){
				linha.append(";");
			}
		}
		
		return linha.toString();
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
