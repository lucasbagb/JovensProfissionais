package com.indracompany.carshopapp.Interfaces;

/**
 * Estabelece autentica��o base de par�metros de <b>CPF</b>, usualmente originados em
 * Objetos da classe {@link Entidades.Cliente}.
 * 
 * @author Julio Silva, Lucas Amorim
 *
 */
public interface AutenticaCpf {

	boolean autenticaCpf(String cpf);

}
