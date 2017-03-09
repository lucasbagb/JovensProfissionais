package Entidades;

public class Vendedor extends Funcionario {

	public Vendedor(String nome, String user, int password, String gerenteNome) {
		super(nome, user, password);
		gerente = new Gerente(gerenteNome);
		this.gerente.nome = gerenteNome;
	}

	private Gerente gerente;

	public void setComissao(double valorVenda) {
		this.comissao += (valorVenda * 0.05);
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	@Override
	public String toString() {
		return (this.usuario.username + ";" + this.usuario.password + ";" + this.nome + ";" + this.gerente.nome);
	}
}
