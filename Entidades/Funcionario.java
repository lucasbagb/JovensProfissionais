package Entidades;

/**
 * A classe <code>Funcionario</code> é uma classe pública e abstrata. A classe
 * possui <code>Override</code> do método {@link #toString()}.
 * 
 * @author Lucas Amorim, Julio Silva
 *
 */
public abstract class Funcionario { // vendedores e gerentes

	// variáveis
	// ------------------------------------------------------------------

	public Funcionario(String nome, String user, int password) {
		this.nome = nome;
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

	@Override
	public String toString() {
		return (this.usuario.username + ";" + this.usuario.password + ";" + this.nome);
	}
}
