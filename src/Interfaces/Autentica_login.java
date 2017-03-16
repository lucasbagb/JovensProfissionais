package Interfaces;

import Entidades.Usuario;

/**
 * A <code>Autentica_login</code> é uma interface que estabelece formato de uma
 * autenticação padrão do programa, por meio de seu único método, o
 * {@link #autenticaLogin(Usuario)}, que recebe um Objeto do tipo
 * {@link Entidades.Usuario Usuario} como parâmetro.
 * 
 * @author Lucas Amorim, Julio Silva
 *
 */
public interface Autentica_login {

	/**
	 * Contrato de autenticação de logins, receberá um Objeto
	 * {@link Entidades.Usuario} como parâmetro de validação.
	 * 
	 * @param usuario
	 * @return <b>boolean</b> que indica se o login é válido (<b>true</b>) ou não
	 *         (<b>false</b>)
	 */
	boolean autenticaLogin(Usuario usuario);

}
