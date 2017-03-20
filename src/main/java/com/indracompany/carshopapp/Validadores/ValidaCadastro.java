package com.indracompany.carshopapp.Validadores;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * A classe <code>ValidaCadastro</code> � primariamente um conglomerado de
 * m�todos que tratam poss�veis incongru�ncias em a��es de cadastro:
 * {@link #ValidadorSenhas(JTextField, JTextField) ValidadorSenhas} para senhas
 * de usu�rio,
 * {@link #ValidadorCamposCarros(JTextField, JTextField, JTextField, JTextField)
 * ValidadorCamposCarros} para Objetos da classe {@link Entidades.Carro Carro},
 * {@link #ValidadorCamposClientes(JTextField, JTextField, JTextField, JTextField, JTextField, JTextField)
 * ValidadorCamposClientes} para Objetos de tipo {@link Entidades.Cliente
 * Cliente}, e
 * {@link #ValidadorCamposFuncionarios(JTextField, JTextField, JTextField, JTextField)
 * ValidadorCamposFuncionarios} para Objetos de tipo
 * {@link Entidades.Funcionario Funcionario}.
 * 
 * @author Julio Silva, Lucas Amorim
 * @see {@link JTextField.Cadastros.TelaCadCarros},
 *      {@link JTextField.Cadastros.TelaCadClientes},
 *      {@link JTextField.Cadastros.TelaCadGerentes},
 *      {@link JTextField.Cadastros.TelaCadVendedores}
 *
 */
public class ValidaCadastro {

	/**
	 * M�todo validador de input de senhas, checa se os valores inseridos s�o
	 * <b>iguais</b> e se passam pela convers�o para o tipo
	 * <code>Integer</code>.
	 * 
	 * @param password
	 * @param password1
	 * @return <b>boolean</b> que indica sucesso (<b>true</b>) ou falha
	 *         (<b>false</b>) de valida��o
	 */
	public boolean ValidadorSenhas(JTextField password, JTextField password1) {

		try {
			Integer password2 = Integer.parseInt(password.getText());
			Integer password3 = Integer.parseInt(password1.getText());

			if (password2 == password3) {

				return true;

			} else {
				JOptionPane.showMessageDialog(null, "As senhas n�o coincidem", "Login", JOptionPane.ERROR_MESSAGE);
				return false;

			}

		} catch (java.lang.NumberFormatException x) {
			JOptionPane.showMessageDialog(null, "A senha deve conter apenas algarismos num�ricos!", "Login",
					JOptionPane.ERROR_MESSAGE);
			return false;

		}

	}

	/**
	 * Checa se houve input de valores em cada um dos campos de vari�vel para
	 * instancia��o posterior de classes filhas de {@link Entidades.Funcionario
	 * Funcionario}.
	 * 
	 * @param nome
	 * @param user
	 * @param password
	 * @param password1
	 * @return <b>boolean</b> que indica sucesso (<b>true</b>) ou falha
	 *         (<b>false</b>) de valida��o
	 */
	public boolean ValidadorCamposFuncionarios(JTextField nome, JTextField user, JTextField password,
			JTextField password1) {
		if (nome.getText().isEmpty() || user.getText().isEmpty() || password.getText().isEmpty()
				|| password1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Favor preencher todos os campos!", "Cadastro de novo usu�rio",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Checa se houve input de valores em cada um dos campos de vari�vel para
	 * instancia��o posterior de Objetos da classe {@link Entidades.Carro
	 * Carro}.
	 * 
	 * @param marca
	 * @param modelo
	 * @param placa
	 * @param preco
	 * @return <b>boolean</b> que indica sucesso (<b>true</b>) ou falha
	 *         (<b>false</b>) de valida��o
	 */
	public boolean ValidadorCamposCarros(JTextField marca, JTextField modelo, JTextField placa, JTextField preco) {
		if (marca.getText().isEmpty() || modelo.getText().isEmpty() || placa.getText().isEmpty()
				|| preco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Favor preencher todos os campos!", "Cadastro de novo usu�rio",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Checa se houve input de valores em cada um dos campos de vari�vel para
	 * instancia��o posterior de Objetos da classe {@link Entidades.Cliente
	 * Cliente}.
	 * 
	 * @param cpf
	 * @param nome
	 * @param telefone
	 * @param user
	 * @param password
	 * @param password1
	 * @return <b>boolean</b> que indica sucesso (<b>true</b>) ou falha
	 *         (<b>false</b>) de valida��o
	 */
	public boolean ValidadorCamposClientes(JTextField cpf, JTextField nome, JTextField telefone, JTextField user,
			JTextField password, JTextField password1) {
		if (cpf.getText().isEmpty() || nome.getText().isEmpty() || telefone.getText().isEmpty()
				|| user.getText().isEmpty() || password.getText().isEmpty() || password1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Favor preencher todos os campos!", "Cadastro de novo usu�rio",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			return true;
		}
	}
}
