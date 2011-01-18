package executor;

import java.util.regex.Pattern;

public class FieldParser {
	
	public static boolean checkUser(String user) {
		String text = user.trim();
		String regex = "^[A-Za-z0-9_]{4,20}";
		
		if (!Pattern.matches(regex, text))
			return false;
		
		return true;
	}
	
	public static boolean checkCustomUser(String user, int min, int max) {
		String text = user.trim();
		String regex = "^[A-Za-z0-9_]{"+min+","+max+"}";
		
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
	
	public static boolean checkCustomName(String name, int min,  int max) {
		String text = name.trim();		
		
		if (text.equals("") || text.length() < min || text.length() > max)
			return false;
		
		return true;
	}

	public static boolean checkFloat(String number, boolean signed) {
		String text = number.trim();
		String regex = null;
		
		if (signed)
			regex = "([ ]*)((-?+)|(\\+{0,1}+))([ ]*)([0-9]+)([ 0-9 ]*)([ ]*)((\\.)([0-9]{1,2}))";
		else
			regex = "([ ]*)((\\+{0,1}+))([ ]*)([0-9]+)([ 0-9 ]*)([ ]*)((\\.)([0-9]{1,2}))";
			//regex = "([ ]*)((\\+{0,1}+))([ ]*)([0-9]+)([ 0-9 ]*)([ ]*)((\\.)([0-9]+))?+([ ]*)([0-9]*)([ ]*)";
					
		if (!Pattern.matches(regex, text))
			return false;
		
		return true;
	}
	
	public static boolean checkInt(String number) {
		String text = number.trim();
		String regex = "^[0-9]+$";	
		
		if (!Pattern.matches(regex, text))
			return false;
		
		return true;
	}
	
	public static boolean checkDate(String date) {
		String text = date.trim();
		String regex = "^(0[1-9]|1[012])[-/.](0[1-9]|[12][0-9]|3[01])[-/.](19|20)\\d\\d$";	
		
		if (!Pattern.matches(regex, text))
			return false;
		
		return true;
	}
	
	public static double roundDouble(double number) {
		int dec = 2;
		
		return Math.round(number * Math.pow(10, dec)) / Math.pow(10, dec);
	}
}
