package exercicios;

import java.util.Scanner;

/* Programa para fazer a validação de uma senha
 * Data 15 FEV 2022   Autor: Ramirez
 */ 
public class Questao02 {
	
	/*
	 *  Método para iniciar o programa.
	 *  Será solicitado o nome do usuário e a senha pelo
	 *  terminal e depois será realizada a validação da senha.
	 */
	public static void main(String[] args) {
		// inicia o Scanner do terminal
		Scanner scanner = new Scanner(System.in);
		// Imprimi a solicitação do nome do usuário
        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine();
        // Imprimi a solicitação da senha
        System.out.print("Usuário '" + nome.toUpperCase() + "' digite sua senha de acesso: ");
        String senha = scanner.nextLine();
        scanner.close();
        
        /* Inicializa a classe de validação da senha definindo o 
         * tamanho mínimo de 6 caracteres  */
        SenhaCheck obj = new SenhaCheck(6);   
        // Faz a validação da senha
        if (obj.validarSenha(senha)) {
        	System.out.println("Senha validada com sucesso.");	
        } else {
        	System.out.println("Senha invalidada com as seguintes falhas:");
        	System.out.println(obj.getMensagem());
        }
        System.out.println("     -- FIM DO PROGRAMA -- ");
        
	}
	
}

/*  Classe para fazer a validação de senhas 
 *
 */
class SenhaCheck {
	/*  Variável para armazenar as mensagens. 	*/
	private String listaMensagem = "";
	/*  Variável para definir a quantidade mínima de caracteres. 	*/
	private int tamanhoMinimo ;
	/*  Variável para verificar se a senha possui número. 	*/
	private boolean possuiNumero = false;
	/*  Variável para verificar se a senha possui letras maiúsculas. */
	private boolean possuiMaiuscula = false;
	/*  Variável para verificar se a senha possui letras minúsculas.. 	*/
	private boolean possuiMinuscula = false;
	/*  Variável para verificar se a senha possui algum símbolo. 	*/
	private boolean possuiSimbolo = false;
	
	/** 
	 * Método construtor da classe sem parâmetros
	 *  Será definido a quantidade padrão de no mínimo 
	 *  06 caracteres para validar a senha
	 */
    public SenhaCheck() {
    	this.tamanhoMinimo = 6;
    }
    
    /**
     * Método construtor da classe com parâmetros
     * @param tamanho - quantidade mínima de caracteres
     * que deve possuir a senha durante a validação.
     */
    public SenhaCheck(int tamanho) {
    	this.tamanhoMinimo = tamanho;
    }
    
    private void addMensagem(String mensagem) {
    	this.listaMensagem += " - " + mensagem + '\n';
    }
    
    public String getMensagem() {
    	return this.listaMensagem;
    }
    
    /**
     *  Metodo que realiza a validação da senha
     *  Observando os seguintes critérios mínimos:
	 *  1 - Tamanho mínimo de caracteres;
	 *  2 - Possuir pelo menos um número;
	 *  3 - Possuir pelo menos uma letra minúscula;
	 *  4 - Possuir pelo menos uma letra maiúscula;
	 *  5 - Possuir pelo menos um caracter especial.
     * @param senha - senha para validação 
     * @return Mensagem informando se a senha é válida 
     * ou possui alguma falha de validação.
     */
    public boolean validarSenha(String senha) {
    	
    	// Verifica a quantidade de caracteres e retorna falso se não atender o critério
    	if (senha.length() < tamanhoMinimo) {
    		this.addMensagem("Falta(m) " + (tamanhoMinimo - senha.length()) +
    			   " caracteres para completar o mínimo");
    		return false;
    	}
    
    	/*
    	 *  Realiza um loop pela senha para fazer as demais validações e 
    	 *  marca se foram encontrados os requisitos
    	 */
	    for (char c : senha.toCharArray()) {
	    	if (c >= 'a' && c <= 'z') possuiMinuscula = true;
	    	else if (c >= 'A' && c <= 'Z') possuiMaiuscula = true;
	    	else if (c >= '0' && c <= '9') possuiNumero = true;
	        else  possuiSimbolo = true;
	    }
	    
	    // Testa se os requisitos foram encontrados e retorna as mensagens de alerta.
	    if ( possuiNumero && possuiMaiuscula && possuiMinuscula && possuiSimbolo) {
	    	this.addMensagem( "Senha válida");
	    	return true;
	    } else {
	    	if (!possuiNumero) this.addMensagem("Falta um número na senha");
	    	if (!possuiMaiuscula) this.addMensagem("Faltou uma letra Maiúscula");
	    	if (!possuiMinuscula) this.addMensagem("Faltou uma letra Minúscula");
	    	if (!possuiSimbolo) this.addMensagem("Faltou um símbolo");
	    	return false;
	    }    	
    }
   
}