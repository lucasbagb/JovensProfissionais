package DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class ManipuladorArquivo {

	public String[][] campo;
	protected int colunas;

	// Escreve no arquivo para o qual foi instanciado.
	protected PrintWriter escritorArquivo;
	// Lê o arquivo para o qual foi instanciado.
	protected BufferedReader lerArquivo;

	public ManipuladorArquivo(String caminhoArquivo, int colunas) {
		this.colunas = colunas;
		try {
			abreArquivo(caminhoArquivo);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * Lê uma linha da origem ligada ao <code>BufferedReader</code>.
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
	 * Abre um arquivo no caminho indicado caso tal arquivo já exista. Em caso
	 * contrário, cria um arquivo com a extensão e caminho indicados no
	 * parâmetro <code>caminhoArquivo</code>.
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
		lerArquivo.mark(4000);
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
	 * Transfere os dados do arquivo <code>.csv</code> para uma variável
	 * manipulável <code>campo</code>.
	 * 
	 * @param colunas
	 * @see percorreCadastrosGerais
	 * @throws IOException
	 */
	public abstract void disponibilizaCadastros() throws IOException;

	public abstract String getLinha(int indice);

	public void escreveCadastros(String cadastro) throws IOException {
		String linha = lerLinha();
		while (linha != null) {
			linha = lerLinha();
		}

		escreverLinha(cadastro);
		disponibilizaCadastros();
	}

	/**
	 * Imprime os dados provenientes da variável manipulável criada dentro de
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
	 * Fecha as variáveis de tipo <code>BufferedReader</code> e
	 * <code>PrintWriter</code> do <code>ManipuladorArquivo</code>
	 * 
	 * @throws IOException
	 */
	public void fechaManipulador() throws IOException {
		this.escritorArquivo.close();
		this.lerArquivo.close();
	}

}
