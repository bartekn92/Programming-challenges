package org.bartekn92.tictactoe;

public enum Seed {
	EMPTY(" "), CROSS("X"), CIRCLE("O");
	
	private String text;

	private Seed(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}	
}
