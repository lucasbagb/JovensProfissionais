package DAO;

import java.io.IOException;

import com.sun.javafx.charts.Legend.LegendItem;

import Entidades.Vendas;

public class ManipuladorVendas extends ManipuladorArquivo {

	String[][] vendas;
	public String[] arquivosVendas;

	public ManipuladorVendas(Vendas venda) {
		super("C:/Users/lbonazza/workspace/ProjetoProva/Beta/Database/RelatoriosVenda/" + venda.getDataArquivo()
				+ ".txt", 8);
	}

	public ManipuladorVendas() {
		super("C:/Users/lbonazza/ProjetoVenda/Vendas.csv", 1);
	}

	public ManipuladorVendas(String caminho) {
		super(caminho);
	}

	@Override
	public void disponibilizaCadastros() throws IOException {

		int qntdLinhas = percorreCadastrosGerais();

		if (this.colunas > 1) {
			this.vendas = new String[qntdLinhas][this.colunas];

			this.lerArquivo.reset();
			String linha = lerLinha();

			for (int i = 0; i < qntdLinhas; i++) {
				if (linha != null) {
					String[] c = linha.split(";");
					for (int j = 0; j < this.colunas; j++) {
						this.vendas[i][j] = c[j];
					}
					linha = lerLinha();
				}
			}
		} else if (this.colunas == 1) {
			this.arquivosVendas = new String[qntdLinhas];

			String linha = lerLinha();
			for (int i = 0; i < qntdLinhas; i++) {
				if (linha != null) {
					this.arquivosVendas[i] = linha;
				}
			}
		}
	}

	public void escreveVenda(Vendas venda) {
		String linha = venda.toStringVendas();
		escreverLinha(linha);
	}

	public String lerVenda() throws IOException {
		String linha = lerLinha();
		while (linha != null) {
			linha += lerLinha() + "\n";
		}
		return linha;
	}

	@Override
	public String getLinha(int indice) {
		// TODO Auto-generated method stub
		return null;
	}

}
