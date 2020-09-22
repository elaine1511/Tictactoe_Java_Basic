package Baitapvemang2chieu;

import java.util.Scanner;

public class Tic_tac_toe {
	static Scanner sc = new Scanner(System.in);
	static int boardlength = 7;
	static char[][] board = new char[boardlength + 1][boardlength + 1];

	public static void main(String[] args) {
		System.out.println("Welcome to Tic tac toe game");
		boolean winner = false; 

		while (!winner) {
			playerturn('X');
			if (check_winner('X')) {
				winner = true;
			} else {
				playerturn('O');
				if (check_winner('O')) {
					winner = true;
				}
			}
		}
	}

	private static boolean check_winner(char player) {
		return check_horizontal_winner(player) || check_vertical_winner(player) || check_main_diagonal_winner(player)
				|| check_second_diagonal_winner(player);
	}

	private static boolean check_main_diagonal_winner(char player) {
		for (int row = 1; row <= boardlength-4; row++) {
			for(int col=1;col<=boardlength-4;col++)
			if (board[row][col] == player && board[row + 1][col + 1] == player && board[row + 2][col + 2] == player
					&& board[row + 3][col + 3] == player && board[row + 4][col + 4] == player) {
				System.out.println("Player "+ String.valueOf(player)+" is the winner");
				return true;
			}
		}
		return false;
	}
	
	private static boolean check_second_diagonal_winner(char player) {
		for(int row=1; row<= boardlength-4; row++) {
			for(int col=boardlength;col>=5;col--) {
			if (board[row][col] == player && board[row + 1][col - 1] == player && board[row + 2][col - 2] == player
					&& board[row + 3][col - 3] == player && board[row + 4][col - 4] == player) {
				System.out.println("Player "+ String.valueOf(player)+" is the winner");
				return true;
			}	
		}
	}
		return false;
	}
	
	private static boolean check_vertical_winner(char player) {
		for (int col = 1; col <= boardlength; col++) {
			for (int row = 1; row <= boardlength - 4; row++) {
				if (board[row][col] == player && board[row + 1][col] == player && board[row + 2][col] == player
						&& board[row + 3][col] == player && board[row + 4][col] == player) {
					System.out.println("Player "+ String.valueOf(player)+" is the winner");
					return true;
				}

			}
		}
		return false;
	}

	private static boolean check_horizontal_winner(char player) {
//		loop over each row and check for winner
		for (int row = 1; row <= boardlength; row++) {
			for (int col = 1; col <= boardlength - 4; col++) {
				if (board[row][col] == player && board[row][col + 1] == 'X' && board[row][col + 2] == player
						&& board[row][col + 3] == player && board[row][col + 4] == player) {
					System.out.println("Player "+ String.valueOf(player)+" is the winner");
					return true;
				}

			}
		}
		return false;
	}

	private static void playerturn(char player) {
		boolean done = false;

		do {
			System.out.println("Please enter row positon for player " + String.valueOf(player)+":");
			int row = sc.nextInt();
			sc = new Scanner(System.in);
			System.out.println("Please enter column positon for player "+ String.valueOf(player)+":");
			int col = sc.nextInt();
			sc = new Scanner(System.in);
			
			if(row< 1 || row> boardlength || col< 1 || col> boardlength) {
				continue;
			}
			if(board[row][col]=='X' || board[row][col]=='O') {
				continue;	
			}

			board[row][col] = player;
			done = true;
			print_board();
		} while (!done);

	}

	private static void print_board() {
		for (int row = 1; row <= boardlength; row++) {
			for (int col = 1; col <= boardlength; col++) {
				System.out.print(((board[row][col] != 'X' && board[row][col] != 'O') ? "-" : board[row][col]) + "|");
			}
			System.out.println();
		}

	}
}
