package DAO;

public class ManipuladorCarros extends ManipuladorArquivo {
	
	private String[][] carros = super.campo;

	public ManipuladorCarros() {
		super("C:/Users/lbonazza/workspace/ProjetoProva/Beta/Database/Carros.csv", 4);
	}

	public String[][] getCarros() {
		return carros;
	}

	public void setCarros(String[][] carros) {
		this.carros = carros;
	}

}
