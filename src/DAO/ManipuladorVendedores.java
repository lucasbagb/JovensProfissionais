package DAO;

import java.io.IOException;

public class ManipuladorVendedores extends ManipuladorArquivo {

	public String[][] vendedores;
	
	public ManipuladorVendedores() {
		super("C:/Users/lbonazza/workspace/ProjetoProva/Beta/Database/Vendedores.csv", 3);
	}

	public String[][] getVendedores() {
		return vendedores;
	}

	public void setVendedores(String[][] vendedores) {
		this.vendedores = vendedores;
	}

	@Override
	public void disponibilizaCadastros() throws IOException {

		int qntdLinhas = percorreCadastrosGerais();

		this.vendedores = new String[qntdLinhas][this.colunas];

		this.lerArquivo.reset();
		String linha = lerLinha();
		
		for (int i = 0; i < qntdLinhas; i++) {
			if (linha != null) {
				String[] c = linha.split(";");
				for (int j = 0; j < this.colunas; j++) {
					this.vendedores[i][j] = c[j];
				}
				linha = lerLinha();
			}
		}
	}
	
	@Override
	public String getLinha(int indice){
		StringBuilder linha = new StringBuilder();
		for (int j = 0; j < this.vendedores[0].length; j++){
			linha.append(vendedores[indice][j]);
			if (j != (this.vendedores[0].length - 1)){
				linha.append(";");
			}
		}
		
		return linha.toString();
	}

	public void comissaoVendedor(String cadastro) {
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
