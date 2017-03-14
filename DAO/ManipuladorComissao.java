package DAO;

import java.io.IOException;

public class ManipuladorComissao extends ManipuladorArquivo{
	
	public String[] arquivosComissao;

	public ManipuladorComissao() {
		super("C:/Users/lbonazza/ProjetoVenda/Comissoes.csv", 3);
	}

	@Override
	public void disponibilizaCadastros() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getLinha(int indice) {
		// TODO Auto-generated method stub
		return null;
	}

}
