package Entidades;

import java.io.IOException;
import java.util.Calendar;

import DAO.ManipuladorGerentes;
import DAO.ManipuladorVendedores;

/**
 * A classe <code>Vendas</code> é uma classe pública que coordena diversos
 * parâmetros das classes {@link Gerente Gerente}, {@link Vendedor Vendedor},
 * {@link Cliente Cliente} e {@link Carro Carro}, de modo a registrar a
 * interação entre tais Classes na realização de vendas em múltiplos meios. Esta
 * é uma primariamente uma classe de efetuação de registros de tais parâmetros,
 * feita para <code>databases</code> de arquivos <code>.csv</code>.
 * 
 * @author Lucas Amorim, Julio Silva
 *
 */
public class Vendas {

	// variáveis
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
	 * Setter de data da transação, toma como parâmetro a instância de momento
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
	 * Getter da data de transação parametrizada na venda.
	 * 
	 * @return data de transação formatada.
	 */
	public String getData() {
		return "Data da transação: " + data[0] + "/" + data[1] + "/" + data[2] + " - " + data[3] + ":" + data[4] + ".";
	}

	// métodos
	// ------------------------------------------------------------------

	/**
	 * Mostra sequencialmente os parâmetros-padrão de uma venda, em formato
	 * adaptado para inserção em arquivos <code>.csv</code>
	 * 
	 * @return parâmetros da venda, separados por <code>;</code>
	 */
	public String toStringVendas() {
		return (this.carro.getMarca() + ";" + this.carro.getModelo() + ";" + this.carro.getPlaca() + ";"
				+ this.cliente.getNome() + ";" + this.cliente.getCpf() + ";" + this.getData() + ";"
				+ this.getQuantidadeParcelas());
	}

	/**
	 * Mostra sequencialmente os parâmetros-padrão de adições de comissão, para
	 * as classes {@link Gerente <code>Gerente</code>} e {@link Vendedor
	 * <code>Vendedor</code>}, em formato adaptado para inserção em arquivos
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
