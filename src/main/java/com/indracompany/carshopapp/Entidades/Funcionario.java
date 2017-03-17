package com.indracompany.carshopapp.Entidades;

/**
 * A classe <code>Funcionario</code> � uma classe p�blica e abstrata. A classe
 * possui <code>Override</code> do m�todo {@link #toString()}, para transcri��o
 * de seus dados em <code>database</code> local de arquivos
 * <code>.csv</code>.<br />
 * <br />
 * Esta classe � estabelece uma base de atributos e m�todos padronizados para
 * classes como a Classe {@link Gerente Gerente} e a Classe {@link Vendedor
 * Vendedor}.
 * 
 * @author Lucas Amorim, Julio Silva
 *
 */
public abstract class Funcionario { // vendedores e gerentes

	// vari�veis
	// ------------------------------------------------------------------

	public Funcionario(String nome, String user, int password) {
		this.nome = nome;
		this.usuario = new Usuario();
		this.usuario.username = user;
		this.usuario.password = password;
	}

	public Funcionario(String nome) {
		this.nome = nome;
	}

	protected String nome;
	protected double comissao;
	protected Usuario usuario;

	// getters and setters
	// ------------------------------------------------------------------

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double valorVenda) {
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setUsername(String username) {
		this.usuario.username = username;
	}

	@Override
	public String toString() {
		return (this.usuario.username + ";" + this.usuario.password + ";" + this.nome);
	}
}
