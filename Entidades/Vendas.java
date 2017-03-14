package Entidades;

import java.io.IOException;
import java.util.Calendar;

import DAO.ManipuladorGerentes;
import DAO.ManipuladorVendedores;
import Validadores.ValidarCPF;

/**
 * A classe <code>Vendas</code> é uma classe pública que coordena diversos
 * parâmetros das classes {@link Gerente Gerente}, {@link Vendedor Vendedor},
 * {@link Cliente Cliente} e {@link Carro Carro}, de modo a registrar a
 * interação entre tais Classes na realização de vendas em múltiplos meios. Esta
 * é primariamente uma classe de efetuação de registros de tais parâmetros,
 * feita para <code>databases</code> de arquivos <code>.csv</code>.
 * 
 * @author Lucas Amorim, Julio Silva
 *
 */
public class Vendas {
	
	public Vendas(Carro carro, Cliente cliente, int quantidadeParcelas){
		this.setCarro(carro);
		this.setCliente(cliente);
		this.setQuantidadeParcelas(quantidadeParcelas);
		this.setData();
	}
	
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
	 * <code>Setter</code> de data da transação, toma como parâmetro a instância de momento
	 * da classe <code>Calendar</code> e a armazena num vetor local.
	 * 
	 */
	public void setData() {
		Calendar dataTransacao = Calendar.getInstance();
		data[0] = dataTransacao.get(Calendar.DAY_OF_MONTH);
		data[1] = (dataTransacao.get(Calendar.MONTH)) + 1;
		data[2] = dataTransacao.get(Calendar.YEAR);
		data[3] = dataTransacao.get(Calendar.HOUR_OF_DAY);
		data[4] = dataTransacao.get(Calendar.MINUTE);
	}

	/**
	 * ´<code>Getter</code> da data de transação parametrizada na venda.
	 * 
	 * @return data de transação formatada.
	 */
	public String getData() {
		String mes = String.format("%02d", data[1]);
		String dia = String.format("%02d", data[0]);
		String hora = String.format("%02d", data[3]);
		String minuto = String.format("%02d", data[4]);
		
		return "Data da transação: " + dia + "/" + mes + "/" + data[2] + " - " + hora + ":" + minuto + ".";
	}
	
	public String getDataArquivo(){
		String mes = String.format("%02d", data[1]);
		String dia = String.format("%02d", data[0]);
		String hora = String.format("%02d", data[3]);
		String minuto = String.format("%02d", data[4]);
		
		return data[2] + "." + mes + "." + dia + " - " + hora + "h" + minuto;
	}

	// métodos
	// ------------------------------------------------------------------

	/**
	 * Mostra sequencialmente os parâmetros-padrão de uma venda, em formato
	 * adaptado para inserção em arquivos <code>.txt</code>
	 * 
	 * @return parâmetros da venda, separados por <code>;</code>
	 */
	public String toStringVendas() {
		
		String preco = String.format("%.2f", (this.carro.getPreco()));
		String parcela = String.format("%.2f", (this.carro.getPreco() / this.quantidadeParcelas));
		
		return 	(	"________________________________________________________________________\r\n\r\n"
				+ 	"-----------------------------------------> INDRA CAR SHOP APP v2.0 <-----------------------------------------\r\n"
				+ 	"________________________________________________________________________\r\n"
				+ 	" Data da transação: < " + this.getData().replace(".", "") + " >\r\n\r\n"
				+	" Cliente: < " + this.cliente.getNome() + " >\r\n"
				+	" Contato: < " + this.cliente.getTelefone() + " >\r\n"
				+	" CPF: < " + ValidarCPF.imprimecpf(this.cliente.getCpf()) + " >\r\n\r\n"
				+	" Carro: < " + this.carro.getMarca() + " - " + this.carro.getModelo() + " >\r\n"
				+	" Placa: < " + this.carro.getPlaca() + " >\r\n\r\n"
				+	" Valor da NF: < R$" + preco + " >\r\n"
				+	" Quantidade de parcelas: < " + this.quantidadeParcelas + " >\r\n"
				+	" Valor das parcelas: < R$" + parcela + " >\r\n"
				+	"________________________________________________________________________\r\n \r\n"
				+	"  Assinatura do gerente responsável:.....x_______________\r\n \r\n"
				+	"  Assinatura do cliente:...............................x_______________\r\n"
				+	"________________________________________________________________________\r\n"
				+ 	" Tower III - Guido Caloi Avenue, nº 1002 - Jd. São Luís, São Paulo/SP, 05802-140");
		
		
		
//		return (this.getDataArquivo() + "\nDados do carro:\n" + this.carro.getMarca() + "\t" + this.carro.getModelo() + "\t" + this.carro.getPlaca() + "\nDados do cliente:\n"
//				+ this.cliente.getNome() + "\t" + this.cliente.getCpf() + "\t" + this.getData() + "\nQuantidade de parcelas:"
//				+ this.getQuantidadeParcelas());
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
