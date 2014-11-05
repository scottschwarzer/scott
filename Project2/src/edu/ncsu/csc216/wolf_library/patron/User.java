/**
 * 
 */
package edu.ncsu.csc216.wolf_library.patron;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author scottschwarzer
 * TODO javadoc
 */
public class User {
	
	private String id;
	private int password;
	
	public User(String ident, String pass) throws IllegalArgumentException {
		
		String identtrim = ident.replaceAll("\\s","");
		String passtrim = pass.replaceAll("\\s","");
		
		if (identtrim == null || passtrim == null || identtrim.length() == 0 || passtrim.length() == 0
				|| containsWhitespace(identtrim) == true || containsWhitespace(passtrim) == true ) {
			throw new IllegalArgumentException();
		}
		
		this.id = ident;
		this.password = pass.hashCode();
		
	}
	
	public boolean verifyPassword(String pass) {
		
		if (this.password == pass.hashCode()) return true;
		return false;
		
	}
	
	public String getId() {
		
		return id;
		
		
	}
	
	private boolean containsWhitespace(String string) {
		
		String trimmedstring = string.replaceAll("\\s","");
		Pattern p = Pattern.compile("\\s");
		Matcher m = p.matcher(trimmedstring);
		boolean found = m.find();
		return found;
		
	}
	
	public int compareTo(User user) {
		
		int i = this.id.compareTo(user.id);
		return i;
		
	}

}
