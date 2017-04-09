package org.bartekn92.tictactoe;

public class Cell {
	private Seed content;
	private int row;
	private int col;
	
	public Cell(int row, int col) {
		this.row = row;
	    this.col = col;
	    clear();
	}
	 
	public void clear() {
		content = Seed.EMPTY;
	}
	 
	public Seed getContent() {
		return content;
	}

	public void setContent(Seed content) {
		this.content = content;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}  
}
