package DAO;

import java.io.IOException;

public class ManipuladorCarros extends ManipuladorArquivo {
	
	public String[][] carros;

	public ManipuladorCarros() {
		super("C:/Users/lbonazza/workspace/ProjetoProva/Beta/Database/Carros.csv", 4);
	}

	public String[][] getCarros() {
		return carros;
	}

	public void setCarros(String[][] carros) {
		this.carros = carros;
	}
	
	@Override
	public void disponibilizaCadastros() throws IOException {

		this.lerArquivo.reset();
		
		int qntdLinhas = percorreCadastrosGerais();

		this.carros = new String[qntdLinhas][this.colunas];

		this.lerArquivo.reset();
		String linha = lerLinha();
		
			for (int i = 0; i < qntdLinhas; i++) {
				if (linha != null) {
					String[] c = linha.split(";");
					for (int j = 0; j < this.colunas; j++) {
						this.carros[i][j] = c[j];
					}
					linha = lerLinha();
				}
			}
	}
	
	@Override
	public String getLinha(int indice){
		StringBuilder linha = new StringBuilder();
		for (int j = 0; j < this.carros[0].length; j++){
			linha.append(carros[indice][j]);
			if (j != (this.carros[0].length - 1)){
				linha.append(";");
			}
		}
		
		return linha.toString();
	}

}
