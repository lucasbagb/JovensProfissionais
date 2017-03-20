package com.indracompany.carshopapp.JTextField;

import com.indracompany.carshopapp.DAO.ManipuladorComissao;

public class TelaRelatoriosComissao {
	
	public void JTPRelatoriosComissao(){
		
		// Implementa��o do acesso ao banco
		ManipuladorComissao mc = new ManipuladorComissao();
		String[][] listaVendas = mc.arquivosComissao;
		
	}

}
