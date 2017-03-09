package DAO;

import java.io.IOException;

public class ManipuladorClientes extends ManipuladorArquivo {

	public String[][] clientes;

	public ManipuladorClientes() {
		super("C:/Users/lbonazza/workspace/ProjetoProva/Beta/Database/Clientes.csv", 5);
	}

	public String[][] getClientes() {
		return clientes;
	}

	public void setClientes(String[][] clientes) {
		this.clientes = clientes;
	}

	@Override
	public void disponibilizaCadastros() throws IOException {

		int qntdLinhas = percorreCadastrosGerais();

		this.clientes = new String[qntdLinhas][this.colunas];

		// Resetta o BufferedReader para o mark feito na instanciação inicial.
		this.lerArquivo.reset();
		String linha = lerLinha();
		
			for (int i = 0; i < qntdLinhas; i++) {
				if (linha != null) {
					String[] c = linha.split(";");
					for (int j = 0; j < this.colunas; j++) {
						this.clientes[i][j] = c[j];
					}
					linha = lerLinha();
				}
			}
	}
	
	@Override
	public String getLinha(int indice){
		StringBuilder linha = new StringBuilder();
		for (int j = 0; j < this.clientes[0].length; j++){
			linha.append(clientes[indice][j]);
			if (j != (this.clientes[0].length - 1)){
				linha.append(";");
			}
		}
		
		return linha.toString();
	}
}