package com.foodrunna.inputcheck;

import java.util.regex.Pattern;

public class MobileNumberCheck {
	
	public static boolean MobileFormat (String mobileNumber) {
		if (Pattern.matches("04[0-9]{8}", mobileNumber)){
			return true;
		}
		return false;
	}
}
