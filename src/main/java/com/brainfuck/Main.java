package com.brainfuck;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.brainfuck.codigo.Codigo;
import com.brainfuck.fita.Fita;
import com.brainfuck.ponteiro.Ponteiro;

public class Main {

	public static void main(String[] args) {
		//Verificação da falta de argumentos
		if (args.length == 0) return;
		
		//Verificação do tipo de arquivo
		if (!args[0].endsWith(".b") && !args[0].endsWith(".bf")) return;
		
		//Inicialização da fita e do ponteiro
		Fita fita = new Fita();
		Ponteiro ponteiro = new Ponteiro();
		
		//Variáveis que servirão para tratar e obter só o que é relevante para o código
		String codigoTratado = "";
		String comandosValidos = "<>+-[].,";
		
		//Localização do arquivo do código TO DO: implementar algo que reconheça somente o
		//formato de arquivo específico do Brainfuck (.b ou .bf)
		String caminhoArquivo = args[0];
		File arquivo = new File(caminhoArquivo);
		
		//Try-catch que trata o caso do arquivo não existir
		try (Scanner leitor = new Scanner(arquivo)) {
			//Aqui iremos abrir o arquivo e separar cada caracter, deixando pra fora todos
			//que não são usados no código
			while (leitor.hasNextLine()) {
				String linhaAtual = leitor.nextLine();
				for(int i = 0; i < linhaAtual.length(); i++) {
					if(comandosValidos.indexOf(linhaAtual.charAt(i)) != -1) codigoTratado += linhaAtual.charAt(i);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado");
		}
		
		//Com o código tratado, iremos inicializar o objeto código
		Codigo codigo = new Codigo(codigoTratado);
		
		//Com tudo pronto, agora iremos rodar o interpretador e assim fazer o programa
		//acontecer
		ponteiro.interpretarCodigo(codigo, fita);

	}

}
