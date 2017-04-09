package org.bartekn92.tictactoe;

public abstract class CPUPlayer {
	   protected int ROWS = Board.ROWS;
	   protected int COLS = Board.COLS;
	 
	   protected Cell[][] cells;
	   protected Seed mySeed;
	   protected Seed oppSeed;
	 
	   public CPUPlayer(Board board) {
	      cells = board.getCells();
	   }
	 
	   public void setSeed(Seed seed) {
	      this.mySeed = seed;
	      oppSeed = (mySeed == Seed.CROSS) ? Seed.CIRCLE : Seed.CROSS;
	   }
	 
	   abstract Move move();
	}
