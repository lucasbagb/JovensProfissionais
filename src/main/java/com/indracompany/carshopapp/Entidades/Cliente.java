package com.indracompany.carshopapp.Entidades;

/**
 * A classe <code>Cliente</code> � uma base de instancia��o dos objetos que
 * estar�o por tr�s do fechamento financeiro de aquisi��es no aplicativo. Seus
 * dados, assim como o de outras Classes da <code>package Entidades</code>, s�o
 * formatados no <code>Override</code> do m�todo <code>toString</code>, para
 * transcri��o em arquivos de extens�o <code>.csv</code>.
 * 
 * @author Lucas Amorim, Julio Silva
 * @see Usuario
 */
public class Cliente {

	public Cliente(String nome, String cpf, String telefone, String user, int password) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.usuario = new Usuario();
		this.usuario.username = user;
		this.usuario.password = password;
	}

	// vari�veis
	// ------------------------------------------------------------------

	private String nome;
	private String cpf;
	private String telefone;
	private Usuario usuario;

	// getters and setters
	// ------------------------------------------------------------------

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	// m�todos
	// ------------------------------------------------------------------

	@Override
	public String toString() {
		return (this.usuario.username + ";" + this.usuario.password + ";" + this.nome + ";" + this.cpf + ";"
				+ this.telefone);
	}

}
