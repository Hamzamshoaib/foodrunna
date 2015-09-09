package com.foodrunna.inputcheck;

import java.util.regex.Pattern;

public class IsNumeric {
	public static boolean isValidPostcode (String word) {
		
		if (Pattern.matches("^[0-9]{4}$", word)) {
			return true;
		}
		return false;
	}
	
	public static boolean isNumeric (String word) {
		if (Pattern.matches("[\\s0-9]+", word)) {
			return true;
		}
		return false;
	}	
}
