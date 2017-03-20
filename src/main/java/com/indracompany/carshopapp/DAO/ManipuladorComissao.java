package com.indracompany.carshopapp.DAO;

import java.io.IOException;

public class ManipuladorComissao extends ManipuladorArquivo {

	public String[][] arquivosComissao;

	public ManipuladorComissao() {
		super("C:/Users/lbonazza/ProjetoVenda/Comissoes.csv", 3);
	}

	@Override
	public void disponibilizaCadastros() throws IOException {

		int qntdLinhas = percorreCadastrosGerais();

		this.arquivosComissao = new String[qntdLinhas][this.colunas];

		this.lerArquivo.reset();
		String linha = lerLinha();

		for (int i = 0; i < qntdLinhas; i++) {
			if (linha != null) {
				String[] c = linha.split(";");
				for (int j = 0; j < this.colunas; j++) {
					this.arquivosComissao[i][j] = c[j];
				}
				linha = lerLinha();
			}
		}
	}

	@Override
	public String getLinha(int indice) {
		StringBuilder linha = new StringBuilder();
		for (int j = 0; j < this.arquivosComissao.length; j++) {
			linha.append(arquivosComissao[indice]);
			if (j != (this.arquivosComissao[0].length - 1)) {
				linha.append(";");
			}
		}

		return linha.toString();
	}

}
