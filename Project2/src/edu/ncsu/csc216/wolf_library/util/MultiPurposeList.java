/**
 * 
 */
package edu.ncsu.csc216.wolf_library.util;

import java.util.NoSuchElementException;

/**
 * @author scottschwarzer
 *
 */
public class MultiPurposeList<T> {

	private e head;
	private Node iterator;
	private int size;
	
	
	public MultiPurposeList() {
		
		this.head = null;
		this.size = 0;
		this.iterator = null;
		
	}
	
	public void resetIterator() {
		
		this.iterator = this.head;
		
	}
	
	public boolean hasNext() {
		
		if(this.iterator.next == null) return false;
		return true;
		
	}
	
	public Node next() throws NoSuchElementException {
		
		if (this.iterator == null || this.iterator.next == null) {
			
			throw new NoSuchElementException();
			
		}
		Node copy = this.iterator;
		this.iterator = this.iterator.next;
		return copy;
		
	}
	
	public void addItem(int pos, T element) throws Exception {
		
		if (element == null) {
			
			throw new NullPointerException();
			
		}
		if (pos < 0 || pos > this.size) {
			
			throw new IndexOutOfBoundsException();
			
		}
		if (this.head == null) {
			
			this.head = new Node(element, null);
			
		}
		
		if () //add at position?
			
	this.size++;	
	}
	
	public boolean isEmpty() {
		
		if (this.front == null) return true;
		return false;
		
	}
	
	public lookAtItemN(int pos) throws IndexOutOfBoundsException {
		
		if (pos < 0 || pos >= this.size) {
			
			throw new IndexOutOfBoundsException();
			
		}
		
	}
	
	public void addToRear(T element) {
		
		Node current = this.head;
		while (current.next != null) {
			
			current = current.next;
			
		}
		current.next = new Node(element, );//position?
		this.size++;
		
	}
	
	public remove(int pos) {
		
	}
	
	public void moveAheadOne(int pos) {
		
	}
	
	public int size() {
		
		return this.size;
		
	}
	
}

class Node<T> {
	
	private T data;
	public Node next;
	
	public Node(T element, Node b) {
		
		this.next = b;
		
	}
}