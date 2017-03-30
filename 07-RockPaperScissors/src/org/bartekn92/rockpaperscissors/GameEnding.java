package org.bartekn92.rockpaperscissors;

public enum GameEnding {
	USER_WINS("User wins!"), 
	CPU_WINS("CPU wins!"), 
	TIE("Tie!")
	;
	
	private final String text;
	
	private GameEnding(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text;
	}
}
