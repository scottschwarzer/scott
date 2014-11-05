/**
 * 
 */
package edu.ncsu.csc216.wolf_library.patron;

/**
 * @author scottschwarzer
 *
 */
public class Patron {
	
	private int maxCheckedOut;
	private int numCheckedOut;
	private String id;
	private int password;
	
	public Patron (String ident, String pass, int maxBooks) throws IllegalArgumentException {
		
		String identtrim = ident.replaceAll("\\s","");
		String passtrim = pass.replaceAll("\\s","");
		
		if (identtrim == null || passtrim == null || identtrim.length() == 0 || passtrim.length() == 0
				|| maxBooks < 1 || identtrim.equals("admin") == true) {
			throw new IllegalArgumentException();
		}
		
		this.id = identtrim;
		this.password = passtrim.hashCode();
		this.maxCheckedOut = maxBooks;
		
		
	}
	
	public String traverseReserveQueue() {
		
	}
	
	public String traverseCheckedOut() {
		
	}
	
	public void closeAccount() {
		
	}
	
	public void returnBook(int a) {
		
	}
	
	public void moveAheadOneInReserves(int a) {
		
	}
	
	public void unReserve(int a) {
		
	}
	
	public void reserve(Book book) {
		
	}
	
	private String traverseQueue(MultiPurposeList<Book>) {
		
	}
	
	private void checkOut() {
		
	}
	
	private Book removeFirstAvailable() {
		
		return null;
		
	}
}
