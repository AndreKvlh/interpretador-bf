package com.brainfuck.laco;

import java.util.HashMap;
import java.util.Stack;

import com.brainfuck.codigo.Codigo;

public class Laco {
	private HashMap<Integer,Integer> lacos;
	private Codigo codigo;
	
	public Laco(Codigo codigo) {
		this.lacos = new HashMap<>();
		this.codigo = codigo;
	}
	
	public void criarLaco() {
		Stack<Integer> pilha = new Stack<>();
		String simboloLaco = "[]";
		for (int i = 0; i < this.codigo.getTamanho(); i++) {
			if(simboloLaco.indexOf(this.codigo.getComando(i)) == -1) continue;
			if(this.codigo.getComando(i) == '[') {
				pilha.push(i);
				continue;
			}
			int inicio = pilha.pop();
			lacos.put(inicio, i);
			lacos.put(i, inicio);	
		}
	}
	
	public int getLaco(int chave) {
		return this.lacos.get(chave);
	}
}
