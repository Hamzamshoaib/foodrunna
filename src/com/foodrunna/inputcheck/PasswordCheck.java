package com.foodrunna.inputcheck;

import java.util.regex.Pattern;

public class PasswordCheck {
	
	public static boolean passwordFormat (String password) {
		boolean validFormat = true;
		
		if (password.length() < 8 || password.length() > 16) { //must be between 8 and 16 characters
			validFormat = false;
		}
		if (!Pattern.matches(".*[.\\[\\]\\^&_#@?/;:]*.*", password) || Pattern.matches(".*[\"\'\\\\<>].*", password)){ 
			//password must include . [ ] _ ^ & # @ ? / ; :
			//password must not include " ' \ < >
			validFormat = false;
		}
		if (!Pattern.matches(".*[A-Z]+.*", password)) {
			validFormat = false;
		}
		if (!Pattern.matches(".*[0-9]+.*", password)) {
			validFormat = false;
		}
		return validFormat;
	}

}
