package com.jinfinite.games.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {
	private BufferedReader buf;
	
	public Console(){
		this.buf = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void welcome(){
		System.out.println("Hello hello! This is Tic Tac Toe. Get three in a row to beat your foe.");	
	}
	
	public String[] getPlayerNames(){
		String[] names = new String[2];
		try {
			System.out.println("Name of the first player (X):");
			names[0] = this.buf.readLine();
			System.out.println("Name of the second player (O):");	
			names[1] = this.buf.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return names;
	}
	
	public int[] getPositions(String name){
		System.out.println("Input [row column] selection for " + name + ":");
		int[] result = new int[2];
		try {
			String input = buf.readLine();
			String[] tokenized = input.split(" ");
			result[0] = Integer.parseInt(tokenized[0]);
			result[1] = Integer.parseInt(tokenized[1]);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void congratulate(String name){
		System.out.println("Congratulations, " + name + "! You've won!");
	}
	
	public void announceTie(){
		System.out.println("This is a tied game!");
	}
	
	public boolean playAgain(){
		System.out.println("Would you like to play again? [y] to play again or any other key to exit.");
		try {
			if (buf.readLine().equals("y")){
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Thanks for playing! Goodbye!");		
		return false;
	}
}
