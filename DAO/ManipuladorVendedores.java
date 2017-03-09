package DAO;

import java.io.IOException;

public class ManipuladorVendedores extends ManipuladorArquivo {

	private String[][] vendedores = super.campo;
	
	public ManipuladorVendedores() {
		super("C:/Users/lbonazza/workspace/ProjetoProva/Beta/Database/Vendedores.csv", 3);
	}

	public String[][] getVendedores() {
		return vendedores;
	}

	public void setVendedores(String[][] vendedores) {
		this.vendedores = vendedores;
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
