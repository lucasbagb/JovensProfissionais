package Defasado;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Entidades.Carro;
import Entidades.Cliente;
import Entidades.Funcionario;
import Entidades.Gerente;
import Entidades.Usuario;
import Entidades.Vendedor;

public class SistemaCopy {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		// String admUsername = "adm";
		// int admPassword = 789456123;
		// -------------------------------------------------------------------------
		// ArrayList's para salvar os dados
		ArrayList<Cliente> listaCliente = new ArrayList<>();
		ArrayList<Carro> listaCarro = new ArrayList<>();
		ArrayList<Funcionario> listaFuncionario = new ArrayList<>();
		// listaCliente.get(INDICE).getNome();
		// -------------------------------------------------------------------------
		// base de dados inicial do sistema
		Double margemDeLucro = 1.28;

		Carro carro = new Carro(null, null, null, margemDeLucro);
		carro.setMarca("Ford");
		carro.setModelo("EcoSport");
		carro.setPlaca("EHX1299");
		carro.setPreco(34999.99);
		listaCarro.add(carro);
		Usuario usuario1 = new Usuario();
		usuario1.setPassword(1234);
		usuario1.setUsername("lbonazza");
		// usuario1.setTipoLogin("Cliente");
		Usuario usuario2 = new Usuario();
		usuario2.setUsername("vcelestino");
		usuario2.setPassword(1234);
		// usuario2.setTipoLogin("Gerente");
		Usuario usuario3 = new Usuario();
		usuario3.setUsername("krodrigues");
		usuario3.setPassword(1234);
		// usuario3.setTipoLogin("Vendedor");
		Cliente cliente = new Cliente(null, null, null, null, 0);
		cliente.setNome("Lucas Amorim");
		cliente.setCpf("419.858.668-38");
		cliente.setTelefone("97451-5466");
		cliente.setUsuario(usuario1);
		listaCliente.add(cliente);
		Gerente gerente = new Gerente(null, null, 0);
		gerente.setNome("Vitor Celestino");
		// gerente.setReferencia("ger001");
		gerente.setUsuario(usuario2);
		gerente.setComissao(500.00);
		listaFuncionario.add(gerente);
		Vendedor vendedor = new Vendedor(null, null, 0);
		vendedor.setNome("Kamila Rodrigues");
		// vendedor.setReferencia("ven001");
		vendedor.setUsuario(usuario3);
		vendedor.setComissao(250.00);
		listaFuncionario.add(vendedor);
		// -------------------------------------------------------------------------
		// variáveis de repetição
		int aux0 = 0; // variável de instanciamento (cliente = 1, vendedor = 2,
						// gerente = 3) e validação de login
		int aux1 = 0; // variável auxiliar de login
		int k = 0; // variável de repetição do cadastro de um novo usuário
		int i = 0; // variavel de repetição do sistema
		int j = 0; // variavel de repetição do acesso fisico
		String simNaoa = "n"; // variavel de validação de cadastro de clientes
		String simNaob = "n"; // variavel de validação de cadastro de carros
		int acesso = 0; // variável de instanciamento de operação

		// -------------------------------------------------------------------------
		// dados de datas do acesso ao sistema para emissão dos relatórios
		Calendar hoje = Calendar.getInstance();
		int dia = hoje.get(Calendar.DAY_OF_MONTH);
		int mes = hoje.get(Calendar.MONTH);
		mes = mes + 1;
		int ano = hoje.get(Calendar.YEAR);
		int hora = hoje.get(Calendar.HOUR);
		int minuto = hoje.get(Calendar.MINUTE);
		// -------------------------------------------------------------------------
		Scanner entrada = new Scanner(System.in);
		// -------------------------------------------------------------------------
		// inicialização de variáveis
		Integer loginSenha = 0;
		String loginUsuario = "h";

		// -------------------------------------------------------------------------

		do { // repetidor do sistema
			Object[] opcoes = { "Acesso", "Cadastro", "Sair" };
			switch (JOptionPane.showOptionDialog(null, "Bem vindo a IndraCarShop!", null, JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0])) {
			case 0: // acesso
				do {// repetidor de login

					JTextField user = new JTextField();
					JTextField password = new JPasswordField();

					Object[] message = { "Digite o usuário: ", user, "Digite a senha:", password };

					int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
						loginUsuario = user.getText();
						try {
							loginSenha = Integer.parseInt(password.getText());

							for (int x = 0; x < listaFuncionario.size(); x++) {
								if (loginUsuario.equals(listaFuncionario.get(x).getUsuario().getUsername())) {
									if (loginSenha == listaFuncionario.get(x).getUsuario().getPassword()) {
										if (listaFuncionario.get(x) instanceof Vendedor) {
											aux0 = 2; // acesso de vendedor
											JOptionPane.showMessageDialog(null, "Bem-vindo vendedor.", "Login",
													JOptionPane.INFORMATION_MESSAGE);
										} else if (listaFuncionario.get(x) instanceof Gerente) {
											aux0 = 3; // acesso de gerente
											JOptionPane.showMessageDialog(null, "Bem-vindo gerente.", "Login",
													JOptionPane.INFORMATION_MESSAGE);
										}
									} else {
										JOptionPane.showMessageDialog(null, "Senha inválida. Tente novamente.", "Login",
												JOptionPane.INFORMATION_MESSAGE);
									}
									aux1 = 1;
								}
							}
							for (int y = 0; y < listaCliente.size(); y++) {
								if (loginUsuario.equals(listaCliente.get(y).getUsuario().getUsername())) {
									if (loginSenha == listaCliente.get(y).getUsuario().getPassword()) {
										aux0 = 1; // acesso de cliente
										JOptionPane.showMessageDialog(null,
												"Bem-vindo, desejamos que tenha boas compras em nosso aplicativo.",
												"Login", JOptionPane.INFORMATION_MESSAGE);
									} else {
										JOptionPane.showMessageDialog(null, "Senha inválida. Tente novamente.", "Login",
												JOptionPane.INFORMATION_MESSAGE);
									}
									aux1 = 1;
								}
							}

							if (aux1 == 0) {
								JOptionPane.showMessageDialog(null, "Usuário inválido. Tente novamente.", "Login",
										JOptionPane.INFORMATION_MESSAGE);
								aux0 = 0;
							}

						} catch (java.lang.NumberFormatException x) {
							JOptionPane.showMessageDialog(null, "A senha contém apenas algarismos numéricos!", "Login",
									JOptionPane.ERROR_MESSAGE);
						}

					} else {
						aux0 = 9;
					}
				} while (aux0 == 0);
				break;

			case 1: // cadastro de usuários
				JTextField cpf = new JTextField();
				JTextField nome = new JTextField();
				JTextField telefone = new JTextField();
				JTextField user = new JTextField();
				JTextField password = new JPasswordField();
				JTextField password1 = new JPasswordField();
				do {
					Object[] message = { "Digite seu nome: ", nome, "Digite seu CPF: ", cpf, "Digite seu telefone: ",
							telefone, "Digite o usuário: ", user, "Digite a senha:", password, "Confirme a senha:",
							password1 };
					int option = JOptionPane.showConfirmDialog(null, message, "Cadastro de novo usuário",
							JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
						try {
							Integer password2 = Integer.parseInt(password.getText());
							Integer password3 = Integer.parseInt(password1.getText());

							if (password2 == password3) {
								// loginSenha =
								// Integer.parseInt(password.getText());
								Cliente cliente1 = new Cliente(loginUsuario, loginUsuario, loginUsuario, loginUsuario, password3);
								cliente1.setNome(String.valueOf(nome));
								cliente1.setCpf(String.valueOf(cpf));
								cliente1.setTelefone(String.valueOf(telefone));
								Usuario usuario = new Usuario();
								usuario.setUsername(String.valueOf(user));
								usuario.setPassword(Integer.parseInt(password.getText()));
								// usuario.setTipoLogin("Cliente");
								cliente.setUsuario(usuario);
								listaCliente.add(cliente);
								k = 1;
								if (cpf == null || nome == null || telefone == null || user == null) {
									JOptionPane.showMessageDialog(null, "Favor preencher todos os campos!",
											"Cadastro de novo usuário", JOptionPane.ERROR_MESSAGE);
									k = 0;
								} else {
									JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.",
											"Cadastro de novo usuário", JOptionPane.INFORMATION_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(null, "As senhas não coincidem", "Login",
										JOptionPane.ERROR_MESSAGE);
							}
						} catch (java.lang.NumberFormatException x) {
							JOptionPane.showMessageDialog(null, "A senha deve conter apenas algarismos numéricos!",
									"Login", JOptionPane.ERROR_MESSAGE);
						}

					} else {
						k = 1;
					}
				} while (k == 0);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Obrigado por acessar nosso aplicativo.", "Login",
						JOptionPane.INFORMATION_MESSAGE);
				i = 1;
			}

			// -------------------------------------------------------------------------

			if (aux0 == 2 || aux0 == 3) {

				do {// repetidor das operações do sistema

					Object[] opcoes2 = { "Cadastro", "Venda", "Relatórios" };
					switch (JOptionPane.showOptionDialog(null, "Qual operação deseja realizar?", null,
							JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes2, opcoes2[0])) {

					case 0: // cadastro
						Object[] opcoes3 = { "Cliente", "Veículo", "Vendedor" };
						switch (JOptionPane.showOptionDialog(null, "Deseja realizar que tipo de cadastro?", null,
								JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes3, opcoes3[0])) {

						case 0: // cadastro de cliente

							JTextField cpf = new JTextField();
							JTextField nome = new JTextField();
							JTextField telefone = new JTextField();
							JTextField user = new JTextField();
							JTextField password = new JPasswordField();
							JTextField password1 = new JPasswordField();
							do {
								Object[] message = { "Digite seu nome: ", nome, "Digite seu CPF: ", cpf,
										"Digite seu telefone: ", telefone, "Digite o usuário: ", user,
										"Digite a senha:", password, "Confirme a senha:", password1 };
								int option = JOptionPane.showConfirmDialog(null, message, "Cadastro de novo usuário",
										JOptionPane.OK_CANCEL_OPTION);
								if (option == JOptionPane.OK_OPTION) {
									try {
										Integer password2 = Integer.parseInt(password.getText());
										Integer password3 = Integer.parseInt(password1.getText());
										if (password2 == password3) {
											// loginSenha =
											// Integer.parseInt(password.getText());
											Cliente cliente1 = new Cliente(loginUsuario, loginUsuario, loginUsuario, loginUsuario, password3);
											cliente1.setNome(String.valueOf(nome));
											cliente1.setCpf(String.valueOf(cpf));
											cliente1.setTelefone(String.valueOf(telefone));
											Usuario usuario = new Usuario();
											usuario.setUsername(String.valueOf(user));
											usuario.setPassword(Integer.parseInt(password.getText()));
											// usuario.setTipoLogin("Cliente");
											cliente.setUsuario(usuario);
											listaCliente.add(cliente);
											k = 1;
											JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.",
													"Cadastro de novo usuário", JOptionPane.INFORMATION_MESSAGE);
										} else {
											JOptionPane.showMessageDialog(null, "As senhas não coincidem", "Login",
													JOptionPane.ERROR_MESSAGE);
										}
									} catch (java.lang.NumberFormatException x) {
										JOptionPane.showMessageDialog(null,
												"A senha deve conter apenas algarismos numéricos!", "Login",
												JOptionPane.ERROR_MESSAGE);
									}

								} else {
									JOptionPane.showMessageDialog(null, "Obrigado por acessar nosso aplicativo.",
											"Cadastro de novo usuário", JOptionPane.INFORMATION_MESSAGE);
									k = 1;
									simNaoa = "s";
								}
							} while (simNaoa.equals("n") || simNaoa.equals("N"));

							break;

						case 1: // cadastro de veiculos
							JTextField marca = new JTextField();
							JTextField modelo = new JTextField();
							JTextField placa = new JTextField();
							JTextField preco = new JTextField();

							do {
								Object[] message1 = { "Digite a marca do veículo: ", marca,
										"Digite o modelo do veículo: ", modelo, "Digite a placa do veículo: ", placa,
										"Digite o preço de compra do veículo: ", preco };
								int option = JOptionPane.showConfirmDialog(null, message1, "Cadastro de novo veículo",
										JOptionPane.OK_CANCEL_OPTION);

								if (option == JOptionPane.OK_OPTION) {
									Carro carro0 = new Carro(loginUsuario, loginUsuario, loginUsuario, option);
									carro0.setMarca(String.valueOf(marca));
									carro0.setModelo(String.valueOf(modelo));
									carro0.setPlaca(String.valueOf(placa));
									carro0.setPreco((Double.valueOf(String.valueOf(preco))) * margemDeLucro);

								}
							} while (simNaob.equals("n") || simNaob.equals("N"));

							break;

						case 2: // cadastro de vendedores
							Vendedor vendedor0 = new Vendedor(loginUsuario, loginUsuario, loginSenha);
							break;

						default:
							JOptionPane.showMessageDialog(null, "Obrigado por acessar nosso aplicativo.", " ",
									JOptionPane.INFORMATION_MESSAGE);
							j = 1;
							break;
						}

						break;

					case 1: // venda
						break;

					case 2: // relatório
						break;

					default:
						JOptionPane.showMessageDialog(null, "Obrigado por acessar nosso aplicativo.", " ",
								JOptionPane.INFORMATION_MESSAGE);
						j = 1;
						break;
					}

				} while (j == 0);
			}

			// -------------------------------------------------------------------------

			if (aux0 == 1) {

			}

		} while (i == 0);
	}
}
