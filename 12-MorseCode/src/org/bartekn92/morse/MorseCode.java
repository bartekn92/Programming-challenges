package org.bartekn92.morse;

public enum MorseCode {
	A(".-"),
    B("-..."),
    C("-.-."),
    D("-.."),
    E("."),
    F("..-."),
    G("--."),
    H("...."),
    I(".."),
    J(".---"),
    K("-.-"),
    L(".-.."),
    M("--"),
    N("-."),
    O("---"),
    P(".--."),
    Q("--.-"),
    R(".-."),
    S("..."),
    T("-"),
    U("..-"),
    V("...-"),
    W(".--"),
    X("-..-"),
    Y("-.--"),
    Z("--.."),
    ZERO('0', "-----"),
    ONE('1', ".----"),
    TWO('2', "..---"),
    THREE('3', "...--"),
    FOUR('4', "....-"),
    FIVE('5', "....."),
    SIX('6', "-...."),
    SEVEN('7', "--..."),
    EIGHT('8', "---.."),
    NINE('9', "----.");
	
	private char character;
	private String code;
	
	private MorseCode(char character, String code)
	{
		this.character = character;
		this.code = code;
	}
	
	private MorseCode(String code) {
        this.character = this.name().charAt(0);
        this.code = code;
    }
	
	public static char decode(String s) {
        for(MorseCode mCode : MorseCode.values()) {
            if(mCode.code.equals(s)) {
                return mCode.character;
            }
        }
        throw new IllegalArgumentException("It is not a valid Morse Code");
    }

    public static String encode(char c) {
        for(MorseCode mCode : MorseCode.values()) {
            if(mCode.character == Character.toUpperCase(c)) {
                return mCode.code;
            }
        }
        throw new IllegalArgumentException(c + " cannot be found");
    }
}
