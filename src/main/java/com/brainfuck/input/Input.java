package com.brainfuck.input;

public class Input {
	private String input;
	private int ponteiroInput;
	
	public Input() {
		this.input = "";
		this.ponteiroInput = 0;
	}
	
	public void setInput(String input) {
		this.input = input;
		this.ponteiroInput = 0;
	}
	
	public int getProxInput() {
		if (ponteiroInput < input.length()) return this.input.charAt(ponteiroInput++);
		return 0;
	}
	
	public String getInput() {
		return this.input;
	}
	
}
