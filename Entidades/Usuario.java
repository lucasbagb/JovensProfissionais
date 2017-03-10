package Entidades;

/**
 * A classe <code>Usuario</code> é uma classe pública designada apenas a
 * manipulação de dados, portanto sendo constituída apenas de atributos e
 * <code>Getters/Setters</code>. Devido a esta configuração, sua presença em
 * instanciações deste Aplicativo usualmente se restringe a settar um Objeto
 * <code>Usuario</code> como variável de outra Classe.
 * 
 * @author Lucas Amorim, Julio Silva
 *
 */
public class Usuario {

	// variáveis
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
