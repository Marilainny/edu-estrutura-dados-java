package com.java.estruturadados.teste;

import java.util.Stack;

import com.java.estruturadados.pilha.Pilha;

public class TestePilha {

	public static void main(String[] args) {


		Pilha<Integer> pilha = new Pilha<Integer>();
		Stack<Integer>stack = new Stack<Integer>();
		Stack<Integer> original = new Stack<>();
		Stack<Integer> auxiliar = new Stack<>();
		Stack<Integer> destino  = new Stack<>();

		Integer desempilhado = null;
		int num=0;

		original.push(3);
		original.push(2);
		original.push(1);

		torreDeHanoi(original.size(), original, destino, auxiliar);

		imprimirResultado("ADA");
		imprimirResultado("ABCD");
		imprimirResultado("VAVA");

		imprimeResultadoExpressao("A + B");
		imprimeResultadoExpressao("(A + B)");
		imprimeResultadoExpressao("[A + B)");

		imprimeResultadoBinario(2);
		imprimeResultadoBinario(24);
		imprimeResultadoBinario(244);
		imprimeResultadoBinario(2444);

		imprimeQualquerBase(300, 2);
		imprimeQualquerBase(100, 8);
		imprimeQualquerBase(1000, 16);


		System.out.println(pilha.estaVazia());
		System.out.println(pilha.topo());

		System.out.println(pilha);		
		System.out.println(pilha.tamanho());
		System.out.println(pilha.estaVazia());

		System.out.println(pilha.topo());
		System.out.println(pilha.desempilhar());
		System.out.println(pilha);


		System.out.println(stack.isEmpty());


		for(int i=1; i<=10; i++) {
			stack.push(i);//adiciona;
			num = i;

			if(num % 2 == 0) {
				System.out.println("Empilhando o número: "+num);
				pilha.empilhar(num);
			}else {
				desempilhado = pilha.desempilhar();

				if(!pilha.estaVazia()) {
					System.out.println("Pilha está vazia.");
				}else {
					System.out.println("Desempilhado: "
							+desempilhado);
				}
			}

			while (!pilha.estaVazia()) {

				System.out.println("Desempilhado: "
						+pilha.desempilhar());
			}

			System.out.println("Todos os elementos foram desempilhados.");
		}

		for(int i=1; i<=10; i++) {
			pilha.empilhar(i);
		}

		System.out.println(stack);
		System.out.println(stack.isEmpty());//vazia;
		System.out.println(stack.size()); //tamanho;

		System.out.println(stack.peek()); //desempilha;
		System.out.println(stack.pop()); //remover um elemento;
		System.out.println(stack);		
	}
	/*
	 * Método resolver desafio de Torre de Hanoi;
	 * 	uso de recursividade do JAVA;
	 */
	public static void torreDeHanoi(int n, Stack<Integer>original, 
			Stack<Integer>destino, Stack<Integer>auxiliar) {

		if(n > 0) {
			torreDeHanoi(n-1, original, auxiliar, destino);
			destino.push(original.pop());
			System.out.println("------------------------");
			System.out.println("Original: "+original);
			System.out.println("Auxiliar: "+auxiliar);
			System.out.println("Destino:  "+destino);

			torreDeHanoi(n-1, auxiliar, destino, original);	
		}
	}
	/*
	 * Método para impimir o resultado do teste;
	 */
	public static void imprimirResultado(String palavra){
		System.out.println(palavra+" é palidromo? "
				+testaPalindromo(palavra));
	}
	/*
	 * Método para testar se a palavra é um palidromo;
	 */
	public static boolean testaPalindromo(String palavra) {	

		Pilha<Character>pilha = new Pilha<Character>();
		String palavraInversa = "";

		for(int i=0;i<palavra.length(); i++) {
			pilha.empilhar(palavra.charAt(i));			
		}		

		while (!pilha.estaVazia()) {
			palavraInversa += pilha.desempilhar();			
		}

		if(palavraInversa.equalsIgnoreCase(palavra)) {
			return true;
		}else {
			return false;
		}		
	}	

	final static String ABRE = "([{";
	final static String FECHA = ")]}";

	public static void imprimeResultadoExpressao(String expressao) {
		System.out.println("A expressão está balanceada? "
				+verificarSimbolosBalanceados(expressao));
	}
	/*
	 * Método para verificar se a expressão matematica abriu e fechou com os mesmos caracteres;
	 */
	public static boolean verificarSimbolosBalanceados(String expressao) {
		boolean balanceado = true;
		int index = 0;
		char simbolo, topo;

		Pilha<Character>pilha = new Pilha<Character>();

		while(index < expressao.length()){
			simbolo = expressao.charAt(index);

			if(ABRE.indexOf(simbolo)>-1) {
				pilha.empilhar(simbolo);
			}else if(FECHA.indexOf(simbolo)>-1){
				if(pilha.estaVazia()) {
					return false;
				}else {
					topo = pilha.desempilhar();

					if(ABRE.indexOf(topo) != FECHA.indexOf(simbolo)) {
						return false;
					}
				}				
			}			
			index ++;
		}
		return true;
	}

	public static void imprimeResultadoBinario(int numero) {
		System.out.println(numero+" em binário é: "
				+decimalBinario(numero));		
	}
	/*
	 * Método para transformar um valor decimal em binário;
	 */
	public static String decimalBinario(int numero) {

		Stack<Integer>pilha = new Stack<Integer>();
		String numeroBinario = "";
		int resto;

		while(numero > 0) {
			resto = numero %2;
			pilha.push(resto);
			numero /= 2;			
		}
		while(!pilha.isEmpty()) {
			numeroBinario += pilha.pop();			
		}		
		return numeroBinario;		
	}
	public static void imprimeQualquerBase(int numero, int base) {
		System.out.println(numero+" na "+base
				+" é "+decimalQualquerBase(numero, base));		
	}
	/*
	 * Método para transformar um valor decimal em qualquer base decimal;
	 */
	public static String decimalQualquerBase(int numero, int base) {

		if (base > 16) {
			throw new IllegalArgumentException();
		}

		Stack<Integer>pilha = new Stack<Integer>();
		String numeroBase = "";
		int resto;
		String bases = "0123456789ABCDEF";

		while(numero > 0) {
			resto = numero %base;
			pilha.push(resto);
			numero /= base;			
		}
		while(!pilha.isEmpty()) {
			numeroBase += bases.charAt(pilha.pop());			
		}		
		return numeroBase;		
	}
	/*
	 * Método desafio torre de Hanoi, método recursivo no Java;
	 */


}






