/**
 * 
 */
package edu.ncsu.csc216.wolf_library.inventory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc216.wolf_library.util.MultiPurposeList;
import edu.ncsu.csc216.wolf_library.util.Node;

/**
 * @author scottschwarzer
 *
 */
public class BookDB {
	
	private MultiPurposeList<Book> database = null;
	
	public BookDB(String filename) throws FileNotFoundException {
		
		File file = new File(filename);
		Scanner filereader;
		try {
			
			filereader = new Scanner(file);
			int pos = 0;
			
			while (filereader.hasNextLine()) {
				
				Book book = new Book(filereader.nextLine());
				database.addItem(pos,book);
				pos++;
				
			}
			
		} catch (IllegalArgumentException e) {
			
			System.out.println("File cannot be read.");
			
		}
		
	}
	
	//TODO
	public String traverse() {
		
		return null;
		
	}
	
	public Book findItemAt(int pos) throws IndexOutOfBoundsException {
		
		if (pos < 0 || pos >= database.size()) {
			
			throw new IndexOutOfBoundsException();
			
		}
		Node item = database.lookAtItemN(pos); //TODO
		Book book = item.data;
		return book;
		
	}
	
	//TODO
	private void readFromFile(String a) {
		
	}
	
	//TODO
	private void insertInOrder(Book b) {
		
	}

}
