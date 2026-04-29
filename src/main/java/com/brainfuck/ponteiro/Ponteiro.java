package com.brainfuck.ponteiro;

import java.util.Scanner;

import com.brainfuck.codigo.Codigo;
import com.brainfuck.fita.Fita;
import com.brainfuck.input.Input;
import com.brainfuck.laco.Laco;

public class Ponteiro {
	private int posicaoPonteiro = 0;
	
	public void interpretarCodigo(Codigo codigo, Fita fita) {
		int cursorCodigo = 0;
		Laco lacos = new Laco(codigo);
		Scanner leitor = new Scanner(System.in);
		Input input = new Input();
		lacos.criarLaco();
		
		while (cursorCodigo < codigo.getTamanho()) {
			char comando = codigo.getComando(cursorCodigo);
			byte valorCelula = fita.getCelula(posicaoPonteiro);
			switch(comando) {
				case '<' -> this.posicaoPonteiro--;
				case '>' -> this.posicaoPonteiro++;
				case '+' -> {
					byte novoValor = (byte) (valorCelula + 1);
					fita.setCelula(posicaoPonteiro,novoValor);
				}
				case '-' -> {
					byte novoValor = (byte) (valorCelula - 1);
					fita.setCelula(posicaoPonteiro,novoValor);
				}
				case '.' -> System.out.print((char) valorCelula);
				case ',' -> {
					if(input.getInput().isEmpty()) input.setInput(leitor.next());
					fita.setCelula(posicaoPonteiro, (byte) input.getProxInput());
				}
				case '[' -> {
					if(valorCelula == (byte) 0) cursorCodigo = lacos.getLaco(cursorCodigo);
				}
				case ']' -> {
					if(valorCelula != (byte) 0) cursorCodigo = lacos.getLaco(cursorCodigo);
				}
				default -> {}
			}
			cursorCodigo++;
		}
		leitor.close();
	}
	
}
