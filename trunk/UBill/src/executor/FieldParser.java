package executor;

import java.util.regex.Pattern;

public class FieldParser {
	
	public static boolean checkUser(String user) {
		String text = user.trim();
		String regex = "^[A-Za-z0-9]{4,15}";
		
		if (!Pattern.matches(regex, text))
			return false;
		
		return true;
	}
	
	public static boolean checkPassword(char[] password) {
		String text = new String(password);
		String regex = "^[A-Za-z0-9]{4,15}";
		
		if (!Pattern.matches(regex, text))
			return false;
		
		return true;
	}
	
	public static boolean checkPassword2(char[] password1, char[] password2) {
		String pwd1 = new String(password1);
		String pwd2 = new String(password2);
		
		if (pwd2.equals(pwd1))
			return true;
		
		return false;
	}
	
	public static boolean checkName(String name) {
		String text = name.trim();		
		
		if (text.equals("") || text.length() < 4 || text.length() > 30)
			return false;
		
		return true;
	}

	public static boolean checkFloat(String number) {
		String text = number.trim();
		String regex = "([ ]*)((-?+)|(\\+{0,1}+))([ ]*)([0-9]+)([ 0-9 ]*)([ ]*)((\\.)([0-9]+))?+([ ]*)([ 0-9 ]*)([ ]*)";		
					
		if (!Pattern.matches(regex, text))
			return false;
		
		return true;
	}
}
