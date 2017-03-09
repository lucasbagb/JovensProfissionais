package Entidades;

public class Carro {

	public Carro(String marca, String modelo, String placa, double preco) {
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.preco = preco;
	}

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

	public void setPreco(double precoCompra) {
		int a = (int)(precoCompra*1.28);
		a = (int) ((a/500)+1);
		a = a * 500;
		this.preco = a;
	}
	
	@Override
	public String toString() {
		return (this.marca + ";" + this.modelo + ";" + this.placa + ";" + this.preco);
	}

}
