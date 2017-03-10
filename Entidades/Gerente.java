package Entidades;

/**
 * A classe <code>Gerente</code> é uma classe pública que extende a classe
 * {@link Funcionario Funcionario}.
 * 
 * @author Lucas Amorim, Julio Silva
 *
 */
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
