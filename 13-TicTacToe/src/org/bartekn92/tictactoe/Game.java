package org.bartekn92.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Game {
	private Board board;
	private GameState currentState;
	private Seed currentPlayer;
	private CPUPlayer cpuPlayer;
	private static Scanner in = new Scanner(System.in);

	public Game() {
		board = new Board();
		initGame();
		Random rnd = new Random();
		int rndSeed = rnd.nextInt(2);
		if(rndSeed == 0)
		{
			System.out.println("User - X, CPU - O");
			cpuPlayer.setSeed(Seed.CIRCLE);
			
		}
		else
		{
			System.out.println("User - O, CPU - X");
			cpuPlayer.setSeed(Seed.CROSS);
		}
		do {
			if(currentPlayer == cpuPlayer.mySeed)
				cpuMove(currentPlayer);
			else
				playerMove(currentPlayer);
			board.paint();
			updateGame(currentPlayer); 
			if (currentState == GameState.CROSS_WON) {
				System.out.println("player X won");
			} else if (currentState == GameState.CIRCLE_WON) {
				System.out.println("player O won");
			} else if (currentState == GameState.DRAW) {
				System.out.println("It's draw!");
			}
			currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.CIRCLE : Seed.CROSS;
		} while (currentState == GameState.INPROGRESS); 
	}
	public void initGame() {
		board.init();
		currentPlayer = Seed.CROSS;
		currentState = GameState.INPROGRESS;
		cpuPlayer = new CPUPlayerMinimax(board);
	}

	public void playerMove(Seed seed) {
		boolean validInput = false;
		do {
			System.out.print(seed.getText() + " enter row [1-3]: ");
			int row = in.nextInt() - 1;
			System.out.print(seed.getText() + " enter column [1-3]: ");
			int col = in.nextInt() - 1;
			if (row >= 0 && row < Board.ROWS && col >= 0 && col < Board.COLS
					&& board.getCells()[row][col].getContent() == Seed.EMPTY) {
				board.getCells()[row][col].setContent(seed);
				board.setCurrentRow(row);
				board.setCurrentCol(col);
				validInput = true;
			} else {
				System.out.println("Move at (" + (row + 1) + "," + (col + 1) + ") is invalid. Try again...");
			}
		} while (!validInput);
	}
	
	public void cpuMove(Seed seed)
	{
		System.out.println("CPU move: ");
		Move move = cpuPlayer.move();
		int row = move.getX();
		int col = move.getY();
		board.getCells()[row][col].setContent(seed);
		board.setCurrentRow(row);
		board.setCurrentCol(col);
	}

	public void updateGame(Seed seed) {
		if (board.hasWon(seed)) {
			currentState = (seed == Seed.CROSS) ? GameState.CROSS_WON : GameState.CIRCLE_WON;
		} else if (board.isDraw()) {
			currentState = GameState.DRAW;
		}
	}

	public static void main(String[] args) {
		new Game();
	}
}
