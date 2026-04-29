package com.brainfuck.codigo;

public class Codigo {
	private String codigoOrdenado;
	private int tamanho;
	
	public Codigo(String codigo) {
		this.codigoOrdenado = codigo;
		this.tamanho = codigoOrdenado.length();
	}
	
	public char getComando(int indice) {
		return codigoOrdenado.charAt(indice);
	}
	
	public int getTamanho() {
		return this.tamanho;
	}
}
