package Entidades;

public class Gerente extends Funcionario {

	public Gerente(String nome, String user, int password) {
		super(nome, user, password);
	}
	
	public Gerente(String nome){
		super(nome);
	}

	public void setComissao(double valorVenda) {
		this.comissao += (valorVenda * 0.1);
	}
}
