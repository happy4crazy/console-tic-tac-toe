package com.jinfinite.games.tictactoe;;

public class Player {
	private String name;
	private char character;
	
	public Player(String name, char character){
		this.setName(name);
		this.setCharacter(character);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCharacter(char character) {
		this.character = character;
	}

	public char getCharacter() {
		return character;
	}
}
