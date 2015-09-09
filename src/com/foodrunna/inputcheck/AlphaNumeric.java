package com.foodrunna.inputcheck;

import java.util.regex.Pattern;

public class AlphaNumeric {
	
	public static boolean isAlphaNum (String word) {
		
		if (Pattern.matches("\\s*[\\sA-za-z0-9]+\\s*", word)) {
			return true;
		}
		return false;
	}
	public static boolean isAddress (String word) {
		
		if (Pattern.matches("[-:\\sA-za-z0-9]+", word)) {
			return true;
		}
		return false;
	}
}
