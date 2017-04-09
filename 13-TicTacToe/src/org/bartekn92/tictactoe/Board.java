package org.bartekn92.tictactoe;

public class Board {
	public static final int ROWS = 3;
	public static final int COLS = 3;
	 
	private Cell[][] cells;
	private int currentRow;
	private int currentCol;
	 
	public Board() {
		cells = new Cell[ROWS][COLS];
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				cells[row][col] = new Cell(row, col);
			}
		}
	}
	public void init() {
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				cells[row][col].clear();
			}
		}
	}
	
	public boolean isDraw() {
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				if (cells[row][col].getContent() == Seed.EMPTY) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean hasWon(Seed seed) {
		return (cells[currentRow][0].getContent() == seed && cells[currentRow][1].getContent() == seed && cells[currentRow][2].getContent() == seed
	            || cells[0][currentCol].getContent() == seed && cells[1][currentCol].getContent() == seed && cells[2][currentCol].getContent() == seed
	            || currentRow == currentCol && cells[0][0].getContent() == seed && cells[1][1].getContent() == seed && cells[2][2].getContent() == seed
	            || currentRow + currentCol == 2 && cells[0][2].getContent() == seed && cells[1][1].getContent()  == seed && cells[2][0].getContent()  == seed);
	}
	
	
	public void paint() {
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				System.out.format(" %s ", cells[row][col].getContent().getText());
				if (col < COLS - 1) System.out.print("|");
			}
			System.out.println();
	        if (row < ROWS - 1) {
	        	System.out.println("-----------");
	        }
		}
	}
	public Cell[][] getCells() {
		return cells;
	}
	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}
	public int getCurrentRow() {
		return currentRow;
	}
	public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}
	public int getCurrentCol() {
		return currentCol;
	}
	public void setCurrentCol(int currentCol) {
		this.currentCol = currentCol;
	}
	
	
}