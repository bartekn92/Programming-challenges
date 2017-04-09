package org.bartekn92.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class CPUPlayerMinimax extends CPUPlayer {

	public CPUPlayerMinimax(Board board) {
		super(board);
	}

	@Override
	Move move() {
		int[] result = minimax(2, mySeed);
		return new Move(result[1], result[2]);
	}


	private int[] minimax(int depth, Seed player) {
		List<Move> nextMoves = generateMoves();

		int bestScore = (player == mySeed) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		int currentScore;
		int bestRow = -1;
		int bestCol = -1;

		if (nextMoves.isEmpty() || depth == 0) {
			bestScore = evaluate();
		} else {
			for (Move move : nextMoves) {
				cells[move.getX()][move.getY()].setContent(player);
				if (player == mySeed) {
					currentScore = minimax(depth - 1, oppSeed)[0];
					if (currentScore > bestScore) {
						bestScore = currentScore;
						bestRow = move.getX();
						bestCol = move.getY();
					}
				} else {
					currentScore = minimax(depth - 1, mySeed)[0];
					if (currentScore < bestScore) {
						bestScore = currentScore;
						bestRow = move.getX();
						bestCol = move.getY();
					}
				}
				cells[move.getX()][move.getY()].setContent(Seed.EMPTY);
			}
		}
		return new int[] { bestScore, bestRow, bestCol };
	}

	private List<Move> generateMoves() {
		List<Move> nextMoves = new ArrayList<Move>();

		if (hasWon(mySeed) || hasWon(oppSeed)) {
			return nextMoves; 
		}

		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				if (cells[row][col].getContent() == Seed.EMPTY) {
					nextMoves.add(new Move(row, col));
				}
			}
		}
		return nextMoves;
	}

	private int evaluate() {
		int score = 0;
		score += evaluateLine(0, 0, 0, 1, 0, 2); // row 0
		score += evaluateLine(1, 0, 1, 1, 1, 2); // row 1
		score += evaluateLine(2, 0, 2, 1, 2, 2); // row 2
		score += evaluateLine(0, 0, 1, 0, 2, 0); // col 0
		score += evaluateLine(0, 1, 1, 1, 2, 1); // col 1
		score += evaluateLine(0, 2, 1, 2, 2, 2); // col 2
		score += evaluateLine(0, 0, 1, 1, 2, 2); // diagonal
		score += evaluateLine(0, 2, 1, 1, 2, 0); // alternate diagonal
		return score;
	}

	private int evaluateLine(int row1, int col1, int row2, int col2, int row3, int col3) {
		int score = 0;

		if (cells[row1][col1].getContent() == mySeed) {
			score = 1;
		} else if (cells[row1][col1].getContent() == oppSeed) {
			score = -1;
		}

		if (cells[row2][col2].getContent() == mySeed) {
			if (score == 1) { 
				score = 10;
			} else if (score == -1) { 
				return 0;
			} else { 
				score = 1;
			}
		} else if (cells[row2][col2].getContent() == oppSeed) {
			if (score == -1) { 
				score = -10;
			} else if (score == 1) {
				return 0;
			} else { 
				score = -1;
			}
		}

		if (cells[row3][col3].getContent() == mySeed) {
			if (score > 0) { 
				score *= 10;
			} else if (score < 0) {
				return 0;
			} else {
				score = 1;
			}
		} else if (cells[row3][col3].getContent() == oppSeed) {
			if (score < 0) { 
				score *= 10;
			} else if (score > 1) { 
				return 0;
			} else { 
				score = -1;
			}
		}
		return score;
	}

	private int[] winningPatterns = { 0b111000000, 0b000111000, 0b000000111, // rows
			0b100100100, 0b010010010, 0b001001001, // cols
			0b100010001, 0b001010100 // diagonals
	};

	private boolean hasWon(Seed thePlayer) {
		int pattern = 0b000000000;
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				if (cells[row][col].getContent() == thePlayer) {
					pattern |= (1 << (row * COLS + col));
				}
			}
		}
		for (int winningPattern : winningPatterns) {
			if ((pattern & winningPattern) == winningPattern)
				return true;
		}
		return false;
	}
}