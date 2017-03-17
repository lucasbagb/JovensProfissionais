package com.indracompany.carshopapp.Validadores;

import java.util.InputMismatchException;

/**
 * A Classe <code>ValidarCPF</code> � uma classe p�blica de autentica��o de
 * par�metros pessoais <em>CPF</em>, usualmente originados em Objetos de tipo
 * {@link Entidades.Cliente Cliente}. A classe possui um �nico m�todo de
 * valida��o (<em>booleano</em>), o {@link #isCpf(String) isCpf}.
 * 
 * @author Julio Silva, Lucas Amorim
 *
 */
public class ValidarCPF {

	static String cpf;

	/**
	 * Efetua valida��o real do CPF, desde checar inser��o de formato de n�mero
	 * �nico ("<em>111...</em>") at� checagem de peso e convers�o,
	 * <code>char</code> por <code>char</code>, da <code>String cpf</code>
	 * inserida.
	 * 
	 * @param cpf
	 * @return <b>boolean</b> que indicar� o sucerro (<b>true</b>) ou falha
	 *         (<b>false</b>) na valida��o.
	 */
	public static boolean isCpf(String CPF) {

		if (CPF.contains(".")) {
			cpf = CPF.replace(".", "").replace("-", "");
		}

		/*
		 * Considera se houve inser��o de sequ�ncias de n�meros iguais, ou se a
		 * String inserida possui um tamanho diferente do permitido.
		 */
		if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
				|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
				|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
				|| cpf.equals("99999999999") || (cpf.length() != 11)) {
			return (false);
		}

		char digito10, ultimoDigito;
		int soma, i, r, formatoNumerico, peso;

		/*
		 * Bloco "try" - protege o c�digo para eventuais erros de convers�o para
		 * o tipo primitivo int.
		 */
		try {
			// C�lculo do 1� D�gito Verificador
			soma = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				/*
				 * Converte o i-�simo caractere do CPF em um n�mero: por
				 * exemplo, transforma o caractere '0', no inteiro 0 (48 � a
				 * posi��o de '0' na tabela ASCII)
				 */
				formatoNumerico = (int) (cpf.charAt(i) - 48);
				soma = soma + (formatoNumerico * peso);
				peso = peso - 1;
			}

			r = 11 - (soma % 11);
			if ((r == 10) || (r == 11)) {
				digito10 = '0';
			} else {
				// Converte no respectivo caractere num�rico
				digito10 = (char) (r + 48);
			}

			// C�lculo do 2� D�gito Verificador
			soma = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				formatoNumerico = (int) (cpf.charAt(i) - 48);
				soma = soma + (formatoNumerico * peso);
				peso = peso - 1;
			}

			r = 11 - (soma % 11);
			if ((r == 10) || (r == 11))
				ultimoDigito = '0';
			else
				ultimoDigito = (char) (r + 48);

			/*
			 * Verifica se os d�gitos calculados conferem com os digitos
			 * inseridos como par�metro do m�todo.
			 */
			if ((digito10 == cpf.charAt(9)) && (ultimoDigito == cpf.charAt(10))) {
				return (true);
			} else {
				return (false);
			}
		} catch (InputMismatchException ime) {
			return (false);
		}
	}

	/**
	 * Imprime o CPF, em formato <b>XXX.XXX.XXX-XX</b>.
	 * 
	 * @param cpf
	 * @return <b>String</b> que representa o CPF formatado
	 */
	public static String imprimecpf(String cpf) {
		return (cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-"
				+ cpf.substring(9, 11));
	}

}
