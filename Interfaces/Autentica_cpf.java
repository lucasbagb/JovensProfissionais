package Interfaces;

/**
 * Estabelece autenticação base de parâmetros de <b>CPF</b>, usualmente originados em
 * Objetos da classe {@link Entidades.Cliente}.
 * 
 * @author Julio Silva, Lucas Amorim
 *
 */
public interface Autentica_cpf {

	boolean autenticaCpf(String cpf);

}
