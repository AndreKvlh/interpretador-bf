package com.brainfuck.fita;

public class Fita {
	private final int totalEspacos = 30000;
	private byte[] memoria = new byte[totalEspacos];
	
	public byte getCelula(int indice) {
		return memoria[indice];
	}
	
	public void setCelula(int indice, byte valor) {
		this.memoria[indice] = valor;
	}
}
