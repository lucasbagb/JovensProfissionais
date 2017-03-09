package DAO;

public class ManipuladorClientes extends ManipuladorArquivo {

	private String[][] clientes = super.campo;
	
	public ManipuladorClientes() {
		super("C:/Users/lbonazza/workspace/ProjetoProva/Beta/Database/Clientes.csv", 5);
	}

	public String[][] getClientes() {
		return clientes;
	}

	public void setClientes(String[][] clientes) {
		this.clientes = clientes;
	}

}
