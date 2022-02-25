package exercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* Programa para analisar a quantidade de anagramas
 * em uma palavra.
 * Data 15 FEV 2022   Autor: Ramirez
 */ 
public class Questao03 {
	
	// Metodo de iniciação do programa
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma palavra: ");
        String palavra = scanner.nextLine();
        scanner.close();
        AnagramaCheck obj = new AnagramaCheck();
        obj.iniciar(palavra); 
        obj.imprimirResultado();
	}
	
}

/*  Classe para analisar os Anagramas de uma 
 *  palavra informada
 */
class AnagramaCheck {
	
	/*  Variável para definir a quantidade de linhas. 	*/
	private List<String> anagramasExitentes = new ArrayList<String>();
	
	/** Método para montar a lista de palavras e verificar os anagramas
	 * existentes.
	 * @param value - define a palavra a ser utilizada na localização
	 * dos anagramas.
	 */
	public void iniciar(String value) {
		 List<String> lista = montarListaPalavras(value);
	        int tam = lista.size();
	        for (int cont=0;cont<=tam;cont++) {
	          	for (int pos = cont+1 ;pos<tam;pos++) {
	          	    if (verificarTermos(lista.get(cont) ,lista.get(pos))) {
	          	    	anagramasExitentes.add(" - "+lista.get(cont) + " é anagrama de " + lista.get(pos));                  
	          	    }
	          	}
	        }
	}
	
	/** Método imprimirResultado() imprimi o resultado da análise
	 *  dos anagramas da palavra
	 **/
	public void imprimirResultado() {
		if (this.anagramasExitentes.size()==0) {
			System.out.println("  NÃO EXISTE ANAGRAMAS ");
		} else {
			System.out.println("  LISTA DE ANAGRAMAS ");
			for (String anagrama: this.anagramasExitentes) {
				System.out.println(anagrama);
			}
		}
		System.out.println("Total de anagramas encontrados: " + this.anagramasExitentes.size());
		
	}
	
	/** Método getQuantidadeAnagramas() retorna a quantidade 
	 * de anagramas encontrados
	 **/
	public int getQuantidadeAnagramas() {
		return this.anagramasExitentes.size();
	}
	
	/** Método getListaAnagramas() retorna uma lista com os
	 *  anagramas encontrados na análise
	 **/
	public List<String> getListaAnagramas() {
		return this.anagramasExitentes;
	}
	
	/** Método montarListaPalavras() retorna uma lista de palavras 
	 *  derivada da palavra inicial
	 *  @param value - define a palavra a ser utilizada na localização
	 **/
	private List<String> montarListaPalavras(String value) {
		int cont = 1;
		List<String> lista = new ArrayList<String>();
		int inicio = 0;
		String parte = "";
		for (int pos = 0;pos<value.length();pos++) {
			for (int quant=cont;quant<=value.length();quant++) {
				parte = this.getTermo(value, pos, quant);
				if (parte!=null) lista.add(parte);	
			}
			cont++;
		}
		return lista;
	}

	/** Método executar() inicia a execução da funcionalidade
	 *  de exibição das linhas com espaços e caracter
	 *  @param value - palavra a ser utilizada na localização
	 *  @param posicao - posição inicial da palavra 
	 *  @param quant - quantidade de caracteres da palavra para ser
	 *  retornada
	 **/
	private String getTermo(String value,int posicao,int quant) {
		try {
			return value.substring(posicao,quant);
		} catch(Exception e) { return null; }
	}

	/** Método verificarTermos() para ordenar os termos e 
	 *  verificar se os termos são iguais.
	 *  @param alfa - palavra a ser utilizada na localização
	 *  @param bravo - posição inicial da palavra 
	 **/
	private boolean verificarTermos(String alfa, String bravo) {
		char[] a = alfa.toCharArray();
	    char[] b = bravo.toCharArray();
	    Arrays.sort(a);
	    Arrays.sort(b);
	    if (Arrays.equals(a, b)) return true;
	    else return false;
	}
}

