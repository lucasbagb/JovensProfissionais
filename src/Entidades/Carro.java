package Entidades;

/**
 * A classe <code>Carro</code> é uma classe pública e possui
 * <code>Override</code> do método {@link #toString()}, para transcrição de seus
 * dados em <code>database</code> local de arquivos <code>.csv</code>.
 * 
 * @author Lucas Amorim, Julio Silva
 *
 */
public class Carro {

	public Carro(String marca, String modelo, String placa, double preco) {
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.preco = preco;
	}

	/**
	 * Variável financeira de estabelecimento de margem de lucro da empresa na
	 * venda de carros pelo aplicativo.
	 * 
	 */
	private final double margemLucro = 1.28;
	private String marca;
	private String modelo;
	private String placa;
	private double preco;

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public double getPreco() {
		return preco;
	}

	/**
	 * Determina o valor de revenda do veículo com base na {@link #margemLucro}.
	 * 
	 * @param precoCompra
	 */
	public void setPreco(double precoCompra) {
		int a = (int) (precoCompra * margemLucro);
		a = (int) ((a / 500) + 1);
		a = a * 500;
		this.preco = a;
	}

	@Override
	public String toString() {
		return (this.marca + ";" + this.modelo + ";" + this.placa + ";" + this.preco);
	}

}
