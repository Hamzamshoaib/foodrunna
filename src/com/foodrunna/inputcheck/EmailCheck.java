package com.foodrunna.inputcheck;

import java.util.regex.Pattern;

public class EmailCheck {
	
	public static boolean emailFormat (String email) {
		if (Pattern.matches("^[.a-zA-Z0-9_-]+@[a-z]+\\.[a-z]+.*", email)) {
			return true;
		}
			
		return false;
	}
}
