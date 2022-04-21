package com.java.estruturadados.estrutura;

/**Classe estatica com estrutura LIFO.
 * @author Marilainny Martins da Siva
 * @version 1.00
 * @since 14.04.22
 */
/*
 * Classe EstruturaEstatica comportamento LIFO
 * 	verificar quantidade de elementos na pilha
 *  empilhar elemento
 *  verificar se pilha está vazia
 *  espiar/verificar elemento topo da pilha
 *  desempilhar elemento da pilha
 *  
 */
public class EstruturaEstatica <T>{

	protected T[] elementos;

	protected int tamanho;

	public EstruturaEstatica(int capacidade) {
		this.elementos = (T[]) new Object[capacidade];
		this.tamanho = 0;		
	}

	public EstruturaEstatica() {
		this(10);
	}
	/*
	 * Método verifica se a pilha está vazia;
	 */
	public boolean estaVazia() {
		return this.tamanho == 0;
	}
	/*
	 * Método para verificar elemento no topo (peek);
	 */
	public T topo() {
		if(this.estaVazia()) {
			return null;
		}else {
			return this.elementos[tamanho -1];
		}
	}
	/*
	 * Método retorna o tamanho da pilha;
	 */
	public int tamanho(){
		return this.tamanho;		
	}
	/*
	 * Método desempilha elemento (pop);
	 * 	Verificar se está vazia;
	 *  retornar o elemento com tamanho - 1 posição;
	 *  
	 */
	public T desempilha() {
		if(this.estaVazia()) {
			return null;			
		}else {
			return this.elementos[--tamanho];
		}		
	}

	/*Método para aumentar a capacidade
	 * 	verifica se o tamanho é igual a quantidade de elementos;
	 *  caso true, cria um novo objeto que recebe a capacidade de elementos elevada a um fator;
	 *  o for insere os elementos no novo objeto;
	 *  elementos recebe os elementos do novo objeto*/
	protected void aumentaCapacidade() {
		if(this.tamanho == this.elementos.length) { 
			T[] newElementos = (T[]) new Object[this.elementos.length * 2];
			for(int i=0; i<this.elementos.length; i++) {
				newElementos[i] = this.elementos[i]; 
			}

			this.elementos = newElementos;
		}
	}

	/*Método adiciona elementos
	 * 	verifica a capacidade, chamando o método aumentaCapacidade();
	 *  verifica se a capacidade do tamanho é menor que o tamanho dos elementos;
	 *  o vetor de elementos inicia com o tamanho atual, recebe o elemento;
	 *  atualiza o tamanho;
	 *  return true*/
	public boolean adiciona(T elemento){
		this.aumentaCapacidade();		
		if (this.tamanho < this.elementos.length) {		
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;			
			return true;
		}
		
		return false;
	}

	/*Método adiciona elemento em uma posição especifica.
	 * 	verifica a capacidade, chamando o método aumentaCapacidade();
	 *  verifica se posição é maior ou igual a zero e posição menor que tamanho;
	 *  caso false lança uma Exception;
	 *  o for decrementa o tamanho, enquanto i for menor que o tamanho do elemento, ele decrementa;
	 *  elementos recebe i+1 posição, acrescenta ao elementos.
	 *  return false caso a posição for inválida*/
	public boolean adiciona(int posicao, T elemento) {
		this.aumentaCapacidade(); 
		if (!(posicao >=0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posição Inválida");			
		}
		for (int i = this.tamanho-1; i >= elementos.length; i--) {
			this.elementos[i+1] = this.elementos[i];
		}
		
		return false;
	}

	public String toString() {
		
		//construtor builder para impressão dos dados formatado.
		StringBuilder vetorElementos = new StringBuilder(); 

		vetorElementos.append("[");
		
		//tamanho vai até a penultima interação.
		for (int i = 0; i < this.tamanho-1; i++) { 
			vetorElementos.append(this.elementos[i]);
			vetorElementos.append(", ");

		}

		if (this.tamanho>0){//verificar se tem dados para imprimir
			vetorElementos.append(this.elementos[this.tamanho-1]); //acessando a última posição.

		}

		vetorElementos.append("]");
		return vetorElementos.toString();
	}

}
