package com.jinfinite.games.tictactoe;

public class TicTacToe {

	private TicTacToeBoard board;
	private Console console;
	private int availableSlots;
	private boolean winner;
	private int playerIndex;
	private Player[] players;

	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		game.setup();
		game.play();
	}

	public void setup() {
		availableSlots = 9;
		winner = false;
		playerIndex = 0;
		this.board = new TicTacToeBoard();
		this.players = new Player[2];
		this.console = new Console();
		console.welcome();
		String[] names = console.getPlayerNames();
		players[0] = new Player(names[0], 'X');
		players[1] = new Player(names[1], 'O');
	}

	public void play() {
		while (availableSlots > 0) {
			board.printBoard();
			int[] results = console.getPositions(players[playerIndex].getName());
			if (board.insertPosition(results, players[playerIndex].getCharacter())){
				playerIndex = (playerIndex == 0) ? playerIndex + 1 : playerIndex - 1 ;
				availableSlots--;				
				if (foundWinner(results)){
					break;
				}
			}
		}
		announceWinner();
	}
	
	public void announceWinner(){
		board.printBoard();
		if (winner){
			console.congratulate(players[playerIndex].getName());
		} else {
			console.announceTie();
		}
		if (console.playAgain()){
			setup();
			play();
		}		
	}
	
	public boolean foundWinner(int[] position){
		if (board.foundWinner(position)){
			winner = true;
			return true;
		}
		return false;
	}
	

}
