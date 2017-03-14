package DAO;

import java.io.IOException;

import Entidades.Vendas;

public class ManipuladorVendas extends ManipuladorArquivo {

	private Vendas venda;
	String[][] vendas;
	public String[] arquivosVendas;

	// ABRE OS NOMES DAS VENDAS
	public ManipuladorVendas() {
		super("C:/Users/lbonazza/workspace/ProjetoProva/Beta/Database/Vendas.csv", 1);
	}
	
	// ACESSA UMA VENDA ESPECÍFICA
	public ManipuladorVendas(String caminho) {
		super(caminho);
	}

	// ESCREVE VENDAS NOVAS
	public ManipuladorVendas(Vendas venda) {
		super("C:/Users/lbonazza/workspace/ProjetoProva/Beta/Database/RelatoriosVenda/" + venda.getDataArquivo() + ".txt", 8);
		this.venda = venda;
	}
	
	public void escreveVenda(Vendas venda) {
		String linha = venda.toStringVendas();
		escreverLinha(linha);
		
		ManipuladorVendas name = new ManipuladorVendas();
		try {
			name.lerArquivo.reset();
			name.escreveCadastros(this.venda.getDataArquivo());
			name.fechaManipulador();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
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

			this.lerArquivo.reset();
			String linha = lerLinha();
			for (int i = 0; i < qntdLinhas; i++) {
				if (linha != null) {
					this.arquivosVendas[i] = linha;
				}
			}
		}
	}


	public String lerArquivoVenda() throws IOException {
		this.lerArquivo.reset();
		String linha = lerLinha();
		while (!linha.contains("Guido Caloi Avenue, nº 1002 - Jd")) {
			linha += lerLinha() + "\n";
		}
		return linha;
	}
	
	public String lerVenda() throws IOException {
		this.lerArquivo.reset();
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
