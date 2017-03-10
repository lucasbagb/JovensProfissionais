package Entidades;

import java.io.IOException;

import DAO.ManipuladorGerentes;

/**
 * A classe <code>Vendedor</code> � uma classe p�blica que extende a classe
 * {@link Funcionario Funcionario} e acessa o <code>databases</code> de arquivos
 * <code>.csv</code> da classe {@link Gerente Gerente}, atrav�s do m�todo
 * {@link #cruzaDadosGerente(String)}, para criar v�nculo. A classe possui
 * <code>Override</code> dos m�todos {@link #toString()} e
 * {@link #setComissao(double)}.
 * 
 * @author Lucas Amorim, Julio Silva
 *
 */
public class Vendedor extends Funcionario {

	private ManipuladorGerentes myManager;
	private StringBuilder managerData;

	public Vendedor(String nome, String user, int password) {
		super(nome, user, password);
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

	/**
	 * Percorre os cadastros de {@link Gerente Gerente} para o atributo
	 * <code>gerenteNome</code> em input, para checagem de exist�ncia de
	 * registro de tal.
	 * 
	 * @param gerenteNome
	 * @return <code>true</code> se existir um gerente com o nome inserido.
	 */
	public boolean cruzaDadosGerente(String gerenteNome) {

		this.myManager = new ManipuladorGerentes();
		this.managerData = new StringBuilder();
		try {
			this.myManager.disponibilizaCadastros();

			for (int i = 0; i < myManager.campo.length; i++) {
				if (gerenteNome.trim().equalsIgnoreCase(myManager.campo[i][3])) {
					String data = myManager.campo[i][0] + ";" + myManager.campo[i][1] + ";" + myManager.campo[i][2];
					this.managerData.append(data);

					// Instancia gerente com os dados do vetor de manipulador
					this.gerente = new Gerente(myManager.campo[i][2], myManager.campo[i][3],
							Integer.parseInt(myManager.campo[i][1]));

					this.myManager.fechaManipulador();
					// Confirma settings
					return true;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		// N�o h� gerente algum em registro com aquele nome
		return false;
	}

	/**
	 * Mostra sequencialmente os par�metros-padr�o de um vendedro, em formato
	 * adaptado para inser��o em arquivos <code>.csv</code>
	 * 
	 * @return par�metros da vendedor, separados por <code>;</code>
	 */
	@Override
	public String toString() {
		return (this.usuario.username + ";" + this.usuario.password + ";" + this.nome + ";" + this.gerente.nome);
	}
}
