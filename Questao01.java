package exercicios;

/* Programa para exibir linhas com um asterisco
 * Data 15 FEV 2022   Autor: Ramirez
 */ 
public class Questao01 {
	
	// Metodo de iniciação do programa
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Montador obj = new Montador(6,'*');
		obj.executar();
	}
	
}

/*  Classe para montar a quantidade de linhas e exibir 
 *  
 */
class Montador {
	/*  Variável para definir a quantidade de linhas. 	*/
	private int tamMax;
	/* Variável para definir o caracter a ser exibido.  */
	private char caracter;
	
	
	/** Método construtor da classe sem parâmetros
	 *  Será definido a quantidade padrão de 06 linhas e
	 *  o caracter para exibição será o '*'.
	 */
	Montador() {
		this.tamMax = 6;
		this.caracter = '*';
	}
	
	/** Método construtor da classe com parâmetros
	 *  Poderá ser informado no construtor da classe a quantidade de linha
	 *  e o caracter que deverá ser impresso em cada linha.
	 * @param tamanho - define a quantidade de linhas que será exibida.
	 * @param caracter - define o caracter que vai ser exibido nas linhas.
	 */
	Montador(int tamanho,char caracter) {
		this.tamMax = tamanho;
		this.caracter = caracter;
	}
	
	/** Método executar() inicia a execução da funcionalidade
	 *  de exibição das linhas com espaços e caracter
	 **/
	public void executar() {
		for (int n = this.tamMax;n>0;n--) {
			System.out.println(this.montarLinha(n));
		}
	}
 
	
	/** o método montarLinha() recebe um valor 'n' e 
	 * monta uma linha com a quantidade de caractes utilizando 
	 * definida pela quantidade máxima de linhas subtraida de 'n' (tamMax - n) +1, 
	 * sendo uma quantidade de espaços em branco acrescida antes dos caracters.
	 * @param n - posicao da linha para a quantidade de caracteres e espaços em brando
	 * @return Este método retonar uma String com espaços em branco e  uma
	 *  quantidade de caracter.
	 **/
	public String montarLinha(int n) {
		String linha = "";
		n--;
		for (int p=0;p<n;p++) {
			linha += " ";
		}
		for (int p=0;p<tamMax-n;p++) {
			linha += caracter;
		}
		return linha;
	}

}
