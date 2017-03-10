package Entidades;

import java.io.IOException;
import java.util.Calendar;

import DAO.ManipuladorGerentes;
import DAO.ManipuladorVendedores;

/**
 * A classe <code>Vendas</code> � uma classe p�blica que coordena diversos
 * par�metros das classes {@link Gerente Gerente}, {@link Vendedor Vendedor},
 * {@link Cliente Cliente} e {@link Carro Carro}, de modo a registrar a
 * intera��o entre tais Classes na realiza��o de vendas em m�ltiplos meios. Esta
 * � uma primariamente uma classe de efetua��o de registros de tais par�metros,
 * feita para <code>databases</code> de arquivos <code>.csv</code>.
 * 
 * @author Lucas Amorim, Julio Silva
 *
 */
public class Vendas {

	// vari�veis
	// ------------------------------------------------------------------
	private Carro carro;
	private Cliente cliente;
	private Gerente gerente;
	private Vendedor vendedor;
	private int quantidadeParcelas;
	private ManipuladorGerentes mgerentes;
	private ManipuladorVendedores mvendedores;

	int[] data = new int[5];

	// getters and setters
	// ------------------------------------------------------------------

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getQuantidadeParcelas() {
		return "O pagamento foi feito em :" + quantidadeParcelas + "parcelas.";
	}

	public void setQuantidadeParcelas(int quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}

	/**
	 * Setter de data da transa��o, toma como par�metro a inst�ncia de momento
	 * da classe <code>Calendar</code> e a armazena num vetor local.
	 * 
	 */
	public void setData() {
		Calendar dataTransacao = Calendar.getInstance();
		data[0] = dataTransacao.get(Calendar.DAY_OF_MONTH);
		data[1] = (dataTransacao.get(Calendar.MONTH)) + 1;
		data[2] = dataTransacao.get(Calendar.YEAR);
		data[3] = dataTransacao.get(Calendar.HOUR);
		data[4] = dataTransacao.get(Calendar.MINUTE);
	}

	/**
	 * Getter da data de transa��o parametrizada na venda.
	 * 
	 * @return data de transa��o formatada.
	 */
	public String getData() {
		return "Data da transa��o: " + data[0] + "/" + data[1] + "/" + data[2] + " - " + data[3] + ":" + data[4] + ".";
	}

	// m�todos
	// ------------------------------------------------------------------

	/**
	 * Mostra sequencialmente os par�metros-padr�o de uma venda, em formato
	 * adaptado para inser��o em arquivos <code>.csv</code>
	 * 
	 * @return par�metros da venda, separados por <code>;</code>
	 */
	public String toStringVendas() {
		return (this.carro.getMarca() + ";" + this.carro.getModelo() + ";" + this.carro.getPlaca() + ";"
				+ this.cliente.getNome() + ";" + this.cliente.getCpf() + ";" + this.getData() + ";"
				+ this.getQuantidadeParcelas());
	}

	/**
	 * Mostra sequencialmente os par�metros-padr�o de adi��es de comiss�o, para
	 * as classes {@link Gerente <code>Gerente</code>} e {@link Vendedor
	 * <code>Vendedor</code>}, em formato adaptado para inser��o em arquivos
	 * <code>.csv</code>
	 * 
	 * @param objeto
	 * @throws IOException
	 */
	public void toStringComissao(Object objeto) throws IOException {
		if (objeto instanceof Gerente) {

			String cadastro0 = this.gerente.nome + ";" + this.gerente.usuario.username + ";" + this.gerente.comissao;
			this.mgerentes.comissaoGerente(cadastro0);

		} else if (objeto instanceof Vendedor) {

			String cadastro1 = this.vendedor.getGerente().nome + ";" + this.vendedor.getGerente().usuario.username + ";"
					+ this.vendedor.getGerente().comissao;
			this.mgerentes.comissaoGerente(cadastro1);

			String cadastro2 = this.vendedor.nome + ";" + this.vendedor.usuario.username + ";" + this.vendedor.comissao;
			this.mvendedores.comissaoVendedor(cadastro2);

		}
	}

}
