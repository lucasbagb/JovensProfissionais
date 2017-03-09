package Entidades;

import java.io.IOException;

import DAO.ManipuladorGerentes;

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

		// Não há gerente algum em registro com aquele nome
		return false;
	}

	@Override
	public String toString() {
		return (this.usuario.username + ";" + this.usuario.password + ";" + this.nome + ";" + this.gerente.nome);
	}
}
