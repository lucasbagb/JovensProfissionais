package Entidades;

import java.io.IOException;
import java.util.Calendar;

import DAO.ManipuladorGerentes;
import DAO.ManipuladorVendedores;
import Validadores.ValidarCPF;

/**
 * A classe <code>Vendas</code> � uma classe p�blica que coordena diversos
 * par�metros das classes {@link Gerente Gerente}, {@link Vendedor Vendedor},
 * {@link Cliente Cliente} e {@link Carro Carro}, de modo a registrar a
 * intera��o entre tais Classes na realiza��o de vendas em m�ltiplos meios. Esta
 * � primariamente uma classe de efetua��o de registros de tais par�metros,
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
	 * <code>Setter</code> de data da transa��o, toma como par�metro a inst�ncia de momento
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
	 * �<code>Getter</code> da data de transa��o parametrizada na venda.
	 * 
	 * @return data de transa��o formatada.
	 */
	public String getData() {
		return "Data da transa��o: " + data[0] + "/" + data[1] + "/" + data[2] + " - " + data[3] + ":" + data[4] + ".";
	}
	
	public String getDataArquivo(){
		return data[2] + "." + data[1] + "." + data[0] + " - " + data[3] + "h" + data[4];
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
		
		return 	(	"_________________________________________________________________________________\n \n"
				+ 	"---------------------------> INDRA CAR SHOP APP v2.0 <---------------------------\n"
				+ 	"_________________________________________________________________________________\n \n"
				+ 	" < " + this.getData() + " >\n \n"
				+	"���������������������������������������������������������������������������������\n \n"
				+	" Cliente: " + this.cliente.getNome() + "\n \n"
				+	" Contato: " + this.cliente.getTelefone() + "\n \n"
				+	" CPF: " + ValidarCPF.imprimecpf(this.cliente.getCpf()) + "\n \n"
				+	"���������������������������������������������������������������������������������\n \n"
				+	" Carro: < " + this.carro.getMarca() + this.carro.getModelo() + " >\n \n"
				+	" Placa: < " + this.carro.getPlaca() + " >\n \n"
				+	"���������������������������������������������������������������������������������\n \n"
				+	" Valor da NF: < R$" + this.carro.getPreco() + "\n \n"
				+	" Quantidade de parcelas: < " + this.quantidadeParcelas + " >\n \n"
				+	"_________________________________________________________________________________\n \n \n"
				+	"..............Assinatura do gerente respons�vel:.....x_____________..............\n \n \n"
				+	"..............Assinatura do cliente:.................x_____________..............\n \n"
				+	"_________________________________________________________________________________");
		
		
		
//		return (this.getDataArquivo() + "\nDados do carro:\n" + this.carro.getMarca() + "\t" + this.carro.getModelo() + "\t" + this.carro.getPlaca() + "\nDados do cliente:\n"
//				+ this.cliente.getNome() + "\t" + this.cliente.getCpf() + "\t" + this.getData() + "\nQuantidade de parcelas:"
//				+ this.getQuantidadeParcelas());
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
