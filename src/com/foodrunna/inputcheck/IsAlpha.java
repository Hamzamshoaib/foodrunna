package com.foodrunna.inputcheck;

import java.util.regex.Pattern;

public class IsAlpha {
	
	public static boolean isAlpha (String word) {
		
		if (Pattern.matches("\\s*[a-zA-Z]+[a-zA-Z\\s]*\\s*", word)) {
			return true;
		}
		return false;
	}
}
