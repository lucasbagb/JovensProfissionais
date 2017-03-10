package Entidades;

/**
 * A classe <code>Administrador</code> é uma classe pública e abstrata criada
 * para definir um acesso padrão para que o gestor do estabelecimento possa
 * cadastrar novos {@link Funcionario Funcionario}. Possui um único atributo, o
 * {@link #senhaAdministrador}, que é de acesso <code>static</code> e define a
 * senha de acesso da classe.
 * 
 * @author Lucas Amorim, Julio Silva
 * @see {@link JTextField.Cadastros.TelaCadFuncionarios#JTPFuncionarios()
 *      JTPFuncionarios()}
 *
 */
public abstract class Administrador {

	// ATENÇÃO!!! Você não deveria estar aqui, isso quer dizer que está fazendo
	// algo ILEGAL!!
	// Ainda dá tempo de desistir, afinal, se eu descobrir irei colocar um preço
	// em sua cabeça...
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
	 * ser acessada em instâncias paralelas (como em
	 * {@link JTextField.Cadastros.TelaCadFuncionarios TelaCadFuncionarios}),
	 * recebe naturalmente a configuração <code>static</code>.
	 * 
	 */
	public static final int senhaAdministrador = 987654321;

}
