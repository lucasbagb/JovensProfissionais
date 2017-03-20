package com.indracompany.carshopapp.Entidades;

/**
 * A classe <code>Administrador</code> � uma classe p�blica e abstrata criada
 * para definir um acesso padr�o para que o gestor do estabelecimento possa
 * cadastrar novos {@link Funcionario Funcionario}. Possui um �nico atributo, o
 * {@link #senhaAdministrador}, que � de acesso <code>static</code> e define a
 * senha de acesso da classe.
 * 
 * @author Lucas Amorim, Julio Silva
 * @see {@link JTextField.Cadastros.TelaCadFuncionarios#JTPFuncionarios()
 *      JTPFuncionarios()}
 *
 */
public abstract class Administrador {

	// ATEN��O!!! Voc� n�o deveria estar aqui, isso quer dizer que est� fazendo
	// algo ILEGAL!!
	// Ainda d� tempo de desistir, afinal, se eu descobrir irei colocar um pre�o
	// em sua cabe�a...
	//
	//
	//
	//
	// ...
	//
	//
	//
	//
	// Eu avisei....
	//
	//
	//
	//
	//
	// ...
	//
	//
	//
	//
	//
	//
	//
	//
	//
	// ...
	//
	//
	//
	//
	//
	//
	//
	//
	//
	// ...
	//
	//
	//
	//
	//
	//
	//
	//
	//

	/**
	 * Define uma senha de acesso geral ao aplicativo de vendas, e por ter de
	 * ser acessada em inst�ncias paralelas (como em
	 * {@link JTextField.Cadastros.TelaCadFuncionarios TelaCadFuncionarios}),
	 * recebe naturalmente a configura��o <code>static</code>.
	 * 
	 */
	public static final int senhaAdministrador = 987654321;

}
