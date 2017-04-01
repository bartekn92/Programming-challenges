package org.bartekn92.morse;

public class MorseConventer {
	public static final char WORD_SEPARATOR = '/';
	public static final char CHAR_SEPARATOR = ' ';
	
	public static String toMorseCode(String input) {
        if (!input.matches("[\\s\\dA-Za-z]*")) {
            throw new IllegalArgumentException("Input text too complicated");
        } else if(input.isEmpty()) {
            return new String("");
        }
        int length = input.length();
        StringBuilder result = new StringBuilder(length * 4);
        for(int i = 0; i < length; i++) {
            if(input.charAt(i) == ' ') {
                result.append(WORD_SEPARATOR);
            }
            else
            {
            	result.append(MorseCode.encode(input.charAt(i)));
            }
            result.append(CHAR_SEPARATOR);
        }
        return new String(result.toString().trim());
    }
	
	public static String toText(String code) {
        String[] words = code.split(Character.toString(WORD_SEPARATOR));
        StringBuilder result = new StringBuilder(words.length * words[0].length());
        for(String word : words) {
            String[] letters = word.trim().split(Character.toString(CHAR_SEPARATOR));
            for(String letter : letters) {
                result.append(MorseCode.decode(letter));
            }
            result.append(CHAR_SEPARATOR);
        }
        return result.toString().substring(0, result.length() - 1);
    }
}
