package com.indracompany.carshopapp.Interfaces;

import com.indracompany.carshopapp.Entidades.Usuario;

/**
 * A <code>Autentica_login</code> � uma interface que estabelece formato de uma
 * autentica��o padr�o do programa, por meio de seu �nico m�todo, o
 * {@link #autenticaLogin(Usuario)}, que recebe um Objeto do tipo
 * {@link Entidades.Usuario Usuario} como par�metro.
 * 
 * @author Lucas Amorim, Julio Silva
 *
 */
public interface AutenticaLogin {

	/**
	 * Contrato de autentica��o de logins, receber� um Objeto
	 * {@link Entidades.Usuario} como par�metro de valida��o.
	 * 
	 * @param usuario
	 * @return <b>boolean</b> que indica se o login � v�lido (<b>true</b>) ou n�o
	 *         (<b>false</b>)
	 */
	boolean autenticaLogin(Usuario usuario);

}
