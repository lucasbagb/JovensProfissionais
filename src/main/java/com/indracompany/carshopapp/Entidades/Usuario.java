package com.indracompany.carshopapp.Entidades;

/**
 * A classe <code>Usuario</code> � uma classe p�blica designada apenas a
 * manipula��o de dados, portanto sendo constitu�da apenas de atributos e
 * <code>Getters/Setters</code>. Devido a esta configura��o, sua presen�a em
 * instancia��es deste Aplicativo usualmente se restringe a settar um Objeto
 * <code>Usuario</code> como vari�vel de outra Classe.
 * 
 * @author Lucas Amorim, Julio Silva
 *
 */
public class Usuario {

	// vari�veis
	// ------------------------------------------------------------------

	protected int password;
	protected String username;

	// getters and setters
	// ------------------------------------------------------------------

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
