package com.java.estruturadados.teste;

import java.util.Stack;

import com.java.estruturadados.pilha.Pilha;

public class TestePilha {

	public static void main(String[] args) {

		Pilha<Integer> pilha = new Pilha<Integer>();
		
		System.out.println(pilha.estaVazia());
		System.out.println(pilha.topo());
		
		for(int i=1; i<=10; i++) {
			pilha.empilhar(i);
		}

		System.out.println(pilha);		
		System.out.println(pilha.tamanho());
		System.out.println(pilha.estaVazia());
		
		System.out.println(pilha.topo());
		System.out.println(pilha.desempilha());
		System.out.println(pilha);
		
		
		
		Stack<Integer>stack = new Stack<Integer>();
		
		System.out.println(stack.isEmpty());
		
		for(int i=1; i<=10; i++) {
			stack.push(i);//adiciona;
		}
		
		System.out.println(stack);
		System.out.println(stack.isEmpty());//vazia;
		System.out.println(stack.size()); //tamanho;
		
		System.out.println(stack.peek()); //desempilha;
		System.out.println(stack.pop()); //remover um elemento;
		System.out.println(stack);	
		
	}

}


