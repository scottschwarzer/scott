/**
 * 
 */
package edu.ncsu.csc216.wolf_library.util;

import java.util.NoSuchElementException;

/**
 * Creates a generic linked list that will be used for the books
 * @author scottschwarzer
 */
public class MultiPurposeList<T> {

	private Node head;
	private Node iterator;
	private int size;
	
	/**
	 * Constructor for the list, initializes each field 
	 */
	public MultiPurposeList() {
		
		this.head = null;
		this.size = 0;
		this.iterator = null;
		
	}
	
	/**
	 * Sends the iterator back to the beginning 
	 */
	public void resetIterator() {
		
		this.iterator = this.head;
		
	}
	
	/**
	 * Iterator method that checks if the node is empty
	 * @return false if empty, true if not empty
	 */
	public boolean hasNext() {
		
		if(this.iterator == null) return false;
		return true;
		
	}
	
	/**
	 * Moves the iterator to the next element in the list 
	 * @return the element that iterator points to 
	 * @throws NoSuchElementException if node is null
	 */
	public T next() throws NoSuchElementException {
		
		if (this.iterator == null) {
			
			throw new NoSuchElementException();
			
		}
		
		Node copy = this.iterator;
		this.iterator = this.iterator.next;
		return copy;
		
	}
	
	/**
	 * Adds item to the list 
	 * @param pos
	 * @param element
	 * @throws NullPointerException
	 * @throws IndexOutOfBoundsException
	 */
	public void addItem(int pos, T element) throws NullPointerException, IndexOutOfBoundsException {
		
		if (element == null) throw new NullPointerException();
			
		if (pos < 0 || pos > this.size) throw new IndexOutOfBoundsException();
		
		if (this.head == null) {
			
			this.head = new Node(element, this.head);
			
		} else {
			
			if(pos == 0){
				Node copy = new Node(element, this.head);
				this.head = copy;
			} else {

				Node copy = this.head;
				for (int i = 0; i < pos; i++) {
					copy = this.next();
				}
				copy.next = new Node(element, copy.next);
			}
			
		}
		
		this.size++;
		this.resetIterator();
	}
	
	public boolean isEmpty() {
		
		if (this.head == null) return true;
		return false;
		
	}
	
	public T lookAtItemN(int pos) throws IndexOutOfBoundsException {
		
		if (pos < 0 || pos >= this.size)
			throw new IndexOutOfBoundsException();

		Node copy = this.head;
		if (pos == 0) {
			return copy;
		} else {
			
			for (int i = 0; i < pos; i++) {
				copy = this.next();
			}
		}
		this.resetIterator();
		return copy.next;
	}
	
	public void addToRear(T element) throws NullPointerException {
		try {
			this.addItem(this.size, element);
		} catch (Exception e) {
			throw new NullPointerException();
		}
	}
	
	public T remove(int pos) throws IndexOutOfBoundsException {
		if (pos < 0 || pos >= this.size) {
			
			throw new IndexOutOfBoundsException();
			
		} else {
			if (pos == 0) {
				this.head = this.head.next;
			} else {
				Node copy = this.head;
				for (int i = 0; i < pos; i++) {
					copy = this.next();
				}

				copy.next = copy.next.next;
			}
			this.resetIterator();
			this.size--;
		}
	}
	
	public void moveAheadOne(int pos) throws IndexOutOfBoundsException{
		if (pos < 0 || pos >= this.size) {
			
			throw new IndexOutOfBoundsException();
			
		} else {
			if (pos != 0) {
				Node n = this.lookAtItemN(pos);
				Node n2 = n.next;
				
				Node copy = n;
				n = n2.next;
				n2 = copy;
				
				System.out.printf("%d, %d\n",n2.data, n.data);
				n2.data = copy.data;
				
				System.out.printf("%d, %d\n",n2.data, n.data);
				this.resetIterator();
			}
			
		}
	}
	
	public int size() {
		
		return this.size;
		
	}
	
}

class Node<T> {
	
	public T data;
	public Node next;
	
	public Node(T element, Node b) {
		this.data = element;
		this.next = b;
		
	}
}
