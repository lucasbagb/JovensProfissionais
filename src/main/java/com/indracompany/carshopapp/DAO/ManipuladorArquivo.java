package com.indracompany.carshopapp.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * A classe <code>ManipuladorArquivo</code> � uma classe p�blica e abstrata, que
 * trata explicitamente da manipula��o dos arquivos de extens�o
 * <code>.csv</code> localizados na database local. Al�m de abrir, ler, escrever
 * e fechar arquivos, a classe tamb�m prop�e um modelo de m�todo de
 * <em>transcri��o</em> de arquivos para vari�veis locais, o m�todo abstrato
 * {@link #disponibilizaCadastros()}.
 * 
 * @author Julio Silva, Lucas Amorim
 * @see {@link ManipuladorCarros}, {@link ManipuladorClientes},
 *      {@link ManipuladorGerentes}, {@link ManipuladorVendedores}
 *
 */
public abstract class ManipuladorArquivo {

	public String[][] campo;
	protected int colunas;

	// Escreve no arquivo para o qual foi instanciado.
	protected PrintWriter escritorArquivo;
	// L� o arquivo para o qual foi instanciado.
	protected BufferedReader lerArquivo;

	public ManipuladorArquivo(String caminhoArquivo, int colunas) {
		this.colunas = colunas;
		try {
			abreArquivo(caminhoArquivo);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public ManipuladorArquivo(String caminhoArquivo) {
		try {
			abreArquivo(caminhoArquivo);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * L� uma linha da origem ligada ao <code>BufferedReader</code> da classe.
	 * 
	 * @return A linha lida pelo <code>BufferedReader</code>
	 * @throws IOException
	 */
	public String lerLinha() throws IOException {
		return lerArquivo.readLine();
	}

	/**
	 * Insere uma linha em formato String no arquivo.
	 * 
	 * @param linha
	 *            : A linha a ser escrita no arquivo
	 */
	public void escreverLinha(String linha) {
		escritorArquivo.println(linha);
	}

	/**
	 * Abre um arquivo no caminho indicado caso tal arquivo j� exista. Em caso
	 * contr�rio, cria um arquivo com a extens�o e caminho indicados no
	 * par�metro <code>caminhoArquivo</code>.
	 * 
	 * @param caminhoArquivo
	 *            : O caminho do arquivo a ser aberto/criado
	 * @throws IOException
	 * @see {@link #escritorArquivo}, {@link #lerArquivo},
	 *      {@link #disponibilizaCadastros()}
	 */
	public void abreArquivo(String caminhoArquivo) throws IOException {
		File arquivo = new File(caminhoArquivo);

		if (!arquivo.isFile()) {
			escritorArquivo = new PrintWriter(new FileWriter(arquivo));
		}

		escritorArquivo = new PrintWriter(new FileWriter(arquivo, true));
		lerArquivo = new BufferedReader(new FileReader(arquivo));
		lerArquivo.mark(8000);
		disponibilizaCadastros();
	}

	/**
	 * Determina a quantidade de linhas de dados existente no arquivo.
	 * 
	 * @return quantidadeLinhas
	 * @throws IOException
	 */
	public int percorreCadastrosGerais() throws IOException {

		String linha = lerLinha();
		int quantidadeLinhas = 1;

		while (linha != null) {
			linha = lerLinha();
			quantidadeLinhas++;
		}
		return quantidadeLinhas;
	}

	/**
	 * Transfere os dados do arquivo <code>.csv</code> para uma vari�vel
	 * manipul�vel <code>campo</code>.
	 * 
	 * @param colunas
	 * @see percorreCadastrosGerais
	 * @throws IOException
	 */
	public abstract void disponibilizaCadastros() throws IOException;

	/**
	 * Percorre a <code>database</code> do Aplicativo para percorr�-la at� o
	 * <b>�ndice</b> parametrizado, ent�o populando uma vari�vel local com os
	 * dados do <code>.csv</code> percorrido.
	 * 
	 * @param indice
	 * @return <b>String</b> que representa a linha correspondente ao
	 *         <em>�ndice</em>
	 */
	public abstract String getLinha(int indice);

	/**
	 * Insere novos cadastros na database local, utilizando um par�metro
	 * <code>String</code> que j� deve ser formatado em separa��o por ";", de
	 * modo a poder ser inserido no arquivo <code>.csv</code> desejado.
	 * 
	 * @param cadastro
	 * @throws IOException
	 */
	public void escreveCadastros(String cadastro) throws IOException {
		String linha = lerLinha();
		while (linha != null) {
			linha = lerLinha();
		}

		escreverLinha(cadastro);
		disponibilizaCadastros();
	}

	/**
	 * Imprime os dados provenientes da vari�vel manipul�vel criada dentro de
	 * uma das <b>classes filhas</b> de <code>ManipuladorArquivo</code>.
	 * 
	 * @see {@link ManipuladorCarros}, {@link ManipuladorClientes},
	 *      {@link ManipuladorGerentes}, {@link ManipuladorVendedores}
	 */
	public void imprimeCadastros() {
		for (int i = 0; i < this.campo.length; i++) {
			for (int j = 0; j < this.campo[0].length; j++) {
				System.out.print(this.campo[i][j]);
				if (i != (this.campo.length - 1)) {
					System.out.print("\t");
				}
			}
			System.out.println();
		}
	}

	/**
	 * Fecha as vari�veis de tipo <code>BufferedReader</code> e
	 * <code>PrintWriter</code> do <code>ManipuladorArquivo</code>
	 * 
	 * @throws IOException
	 */
	public void fechaManipulador() throws IOException {
		this.escritorArquivo.close();
		this.lerArquivo.close();
	}

}
