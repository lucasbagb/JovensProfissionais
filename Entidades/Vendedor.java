package Entidades;

/**
 * A classe <code>Vendedor</code> é uma classe pública que extende a classe
 * {@link Funcionario Funcionario} e acessa o <code>databases</code> de arquivos
 * <code>.csv</code> da classe {@link Gerente Gerente}, para criar vínculo. A
 * classe possui <code>Override</code> dos métodos {@link #toString()} e
 * {@link #setComissao(double)}.
 * 
 * @author Lucas Amorim, Julio Silva
 * @see Usuario
 *
 */
public class Vendedor extends Funcionario {

	// private ManipuladorGerentes myManager;
	// private StringBuilder managerData;
	private Gerente gerente;

	public Vendedor(String nome, String user, int password, String gerente) {
		super(nome, user, password);
		this.gerente = new Gerente(gerente);
	}

	public void setComissao(double valorVenda) {
		this.comissao += (valorVenda * 0.05);
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	/**
	 * Mostra sequencialmente os parâmetros-padrão de um vendedro, em formato
	 * adaptado para inserção em arquivos <code>.csv</code>
	 * 
	 * @return parâmetros da vendedor, separados por <code>;</code>
	 */
	@Override
	public String toString() {
		return (this.usuario.username + ";" + this.usuario.password + ";" + this.nome + ";" + this.gerente.nome);
	}
}
