package JTextField;

import DAO.ManipuladorComissao;

public class TelaRelatoriosComissao {
	
	public void JTPRelatoriosComissao(){
		
		// Implementação do acesso ao banco
		ManipuladorComissao mc = new ManipuladorComissao();
		String[][] listaVendas = mc.arquivosComissao;
		
	}

}
