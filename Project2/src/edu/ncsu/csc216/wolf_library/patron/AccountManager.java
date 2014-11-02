package edu.ncsu.csc216.wolf_library.patron;

/**
 * Describes behaviors of a patron management systems that permits user login.
 * The management system has an administrator.
 * @author Jo Perry
 */
public interface AccountManager {
	
	/**
	 * Logs a user into the system. 
	 * @param id user's id
	 * @param password user's password
	 * @throws IllegalStateException if a patron or the administrator is already logged in
	 * @throws IllegalArgumentException if the patron account does not exist
	 */
	public void login(String id, String password);
	
	/**
	 * Logs the current patron or administrator out of the system.
	 */
	public void logout();
	
	/**
	 * Returns the currently logged in user.
	 * @return the currently logged in user.
	 */
	public Patron getCurrentPatron();
	
	/**
	 * Is an administrator logged into the system?
	 * @return true if yes, false if no
	 */
	public boolean isAdminLoggedIn();
	
	/**
	 * Is a patron logged into the system?
	 * @return true if yes, false if no
	 */
	public boolean isPatronLoggedIn();
	
	/**
	 * Add a new patron to the patron database. The administrator must be logged in.
	 * @param id new patron's id
	 * @param password new patron's password
	 * @param num number associated with this patron
	 * @throws IllegalStateException if the database is full or the administrator is not logged in
	 * @throws IllegalArgumentException if patron cannot be added to the patron database
	 */
	public void addNewPatron(String id, String password, int num);
	
	/**
	 * Cancel a patron account. 
	 * @param id patron's id
	 * @throws IllegalStateException if the administrator is not logged in
	 * @throws IllegalArgumentException if patron cannot be removed due to some error
	 */
	public void cancelAccount(String id);
	
	/**
	 * List all patron accounts. 
	 * @return string of patron ids separated by newlines
	 */
	public String listAcounts();

}