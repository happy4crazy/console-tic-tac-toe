package com.jinfinite.games.tictactoe;

public class TicTacToeBoard {

	char[][] board;
	StringBuilder sb;

	public TicTacToeBoard() {
		this.board = new char[3][3];
	}

	public boolean insertPosition(int[] position, char c) {
		try {
			if (board[position[0]][position[1]] == '\0') {
				board[position[0]][position[1]] = c;
				return true;
			} else {
				System.out.println("Invalid input! Try again.");
				return false;
			}
		} catch (ArrayIndexOutOfBoundsException a) {
			System.out.println("Invalid input! Try again.");
			return false;
		}
	}

	public void printBoard() {
		for (int x = 0; x < 3; x++) {
			sb = new StringBuilder(11);
			for (int y = 0; y < 3; y++) {
				sb.append(" " + ((board[x][y] == '\0') ? " " : board[x][y])
						+ " " + "|");
			}
			System.out.println(sb.toString());
			System.out.println("-----------");
		}
	}

	public boolean foundWinner(int[] position) {
		int row = position[0];
		int col = position[1];
		if (board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
			return true;
		}
		if (board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
			return true;
		}
		if (row == col || row + col == 2) {
			if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
				return true;
			}
			if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
				return true;
			}
		}
		return false;
	}

}
