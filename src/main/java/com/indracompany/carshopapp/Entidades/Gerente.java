package com.indracompany.carshopapp.Entidades;

/**
 * A classe <code>Gerente</code> � uma classe p�blica que extende a classe
 * {@link Funcionario Funcionario}. <br />
 * A partir do momento em que exista ao menos um Objeto da classe
 * {@link Vendedor Vendedor} numa inst�ncia deste Aplicativo, por modelo de
 * utliza��o do mesmo, � acordado que deve existir um Objeto da Classe
 * <code>Gerente</code> associado ao <code>Vendedor</code>.<br />
 * <br />
 * Um Objeto desta Classe, tamb�m de acordo com o modelo deste Aplicativo, pode
 * estar associado a 0, 1 ou mais Objetos da Classe <code>Vendedor</code>.
 * 
 * @author Lucas Amorim, Julio Silva
 * @see Usuario
 * 
 */
public class Gerente extends Funcionario {

	public Gerente(String nome, String user, int password) {
		super(nome, user, password);
	}

	public Gerente(String nome) {
		super(nome);
	}

	public void setComissao(double valorVenda) {
		this.comissao += (valorVenda * 0.1);
	}
}
