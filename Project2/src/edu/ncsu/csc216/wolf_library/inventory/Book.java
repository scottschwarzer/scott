/**
 * 
 */
package edu.ncsu.csc216.wolf_library.inventory;

import java.util.Scanner;

/**
 * @author scottschwarzer
 *
 */
public class Book {
	
	private String info;
	private int numAvailable;
	
	public Book(String str) throws IllegalArgumentException {
			
		Scanner scan = new Scanner(str);
		try {
			
			this.numAvailable = scan.nextInt();
			
		} catch (Exception e) {
			
			throw new IllegalArgumentException();
			
		}
		if (this.numAvailable < 0) {
			
			this.numAvailable = 0;
			
		}
		
		String info = "";
		while (scan.hasNext()) {
			
			info += scan.next() + " ";
			
		}
		if (info.length() == 0) {
			
			throw new IllegalArgumentException();
			
		}	
		if (this.info.isEmpty()) {
			
			throw new IllegalArgumentException();
			
		}
	}
	
	public String getInfo() {
		
		return this.info;
		
	}
	
	public String toString() {
		
		if (this.numAvailable == 0) {
			
			this.info = "* " + this.info;
			
		}
		return this.info;
		
	}
	
	public boolean isAvailable() {
		
		if (this.numAvailable == 0) {
			
			return false;
		
		}
	return true;
	}
	
	public void backToInventory() {
		
		this.numAvailable++;
		
	}
	
	public void removeOneCopyFromInventory() {
		
		if (this.numAvailable == 0) {
			
			throw new IllegalStateException();
			
		} else {
			
			this.numAvailable--;
			
		}
		
	}
	
	public int compareTo(Book b) {
		
        String title1 = this.getInfo().toLowerCase();
        String title2 = b.getInfo().toLowerCase();
       
        Scanner scan1 = new Scanner(title1);
        Scanner scan2 = new Scanner(title2);
       
        boolean check = false;
        int count = 0;
        int score = 0;
        while (!check) {
        	
                String str1 = "", str2 = "";
               
                if (scan1.hasNext()) {
                        str1 = scan1.next();
                }
               
                if (scan2.hasNext()) {
                        str2 = scan2.next();
                }
               
                if (count == 0) {
                        if (str1 != "" && (str1.toLowerCase().compareTo("a") == 0 || str1.toLowerCase().compareTo("the") == 0 || str1.toLowerCase().compareTo("an") == 0)) {
                                str1 = scan1.next();
                        }
                       
                        if (str2 != "" && (str2.toLowerCase().compareTo("a") == 0 || str2.toLowerCase().compareTo("the") == 0 || str2.toLowerCase().compareTo("an") == 0)) {
                                str2 = scan2.next();
                        }
                }
               
                if (str1 == "" || str2 == "") break;

                score += str1.compareTo(str2);
               
                if (score != 0){
                        break;
                }
               
                count++;
        }

        return score;
        
	}
	
}
