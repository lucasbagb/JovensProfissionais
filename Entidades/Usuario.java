package Entidades;

public class Usuario implements Interfaces.Autentica_login {

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

	// métodos
	// ------------------------------------------------------------------

	@Override
	public boolean autenticaLogin(Usuario usuario) {
		if (this.username == usuario.username) {
			if (this.password == usuario.password) {
				return true;
			} else {
				System.out.println("Senha incorreta.");
				return false;
			}
		} else {
			System.out.println("Usuário incorreto.");
			return false;
		}
	}

}
