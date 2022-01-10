/*
 * Defines a doubly-linked list class
 * @author Sol Valdimarsdottir
 * @author Sam Yadav
*/

// HELlllllllOlOOO

import java.util.NoSuchElementException;

public class LinkedList<T> {
	private class Node {
		private T data;
		private Node next;
		private Node prev;

		public Node(T data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	private int length;
	private Node first;
	private Node last;
	private Node iterator;

	/**** CONSTRUCTORS ****/

	/**
	 * Instantiates a new LinkedList with default values
	 * 
	 * @precondition - None *************************************
	 * @postcondition - New LinkedList object created with null values
	 */
	public LinkedList() {
		this.first = null;
		this.last = null;
		this.iterator = null;
		this.length = 0;
	}

	/**
	 * Converts the given array into a LinkedList
	 * 
	 * @param array the array of values to insert into this LinkedList
	 * @postcondition new linked list is created with data from array
	 */

	public LinkedList(T[] array) {
		// should handle "null" Object case, make a new empty linked list

		this();

		for (int i = 0; i < array.length; i++) {
			this.addLast(array[i]);
		}
	}

	/**
	 * Instantiates a new LinkedList by copying another List
	 * 
	 * @param original the LinkedList to copy
	 * @postcondition a new List object, which is an identical, but separate, copy
	 *                of the LinkedList original
	 */
	public LinkedList(LinkedList<T> original) {

	}

	/**** ACCESSORS ****/

	/**
	 * Returns the value stored in the first node
	 * 
	 * @precondition length isn't 0/no empty linked list
	 * @return the value stored at node first
	 * @throws NoSuchElementException when List is empty
	 * @postcondition: method returns T data of the first data node of the linked
	 *                 list
	 */
	public T getFirst() throws NoSuchElementException {
		if (this.length == 0) {
			throw new NoSuchElementException("getHead(): List is empty.");
		}

		return first.data;
	}

	/**
	 * Returns the value stored in the last node
	 * 
	 * @precondition length is not 0
	 * @return the value stored in the node last
	 * @throws NoSuchElementException when list is empty
	 * @postcondition returns T data of the last node in linked list
	 */
	public T getLast() throws NoSuchElementException {
		if (this.length == 0) {
			throw new NoSuchElementException("getHead(): List is empty.");
		}

		return this.last.data;
	}

	/**
	 * Returns the data stored in the iterator node
	 * 
	 * @precondition <fill in here>
	 * @throw NullPointerException <fill in here>
	 */
	public T getIterator() throws NullPointerException {
		return null;
	}

	/**
	 * Returns the current length of the LinkedList
	 * 
	 * @return the length of the LinkedList from 0 to n
	 */
	public int getLength() {
		return this.length;
	}

	/**
	 * Returns whether the LinkedList is currently empty
	 * 
	 * @return whether the LinkedList is empty
	 */
	public boolean isEmpty() {
		return length == 0;
	}

	/**
	 * Returns whether the iterator is offEnd, i.e. null
	 * 
	 * @return whether the iterator is null
	 */
	public boolean offEnd() {
		return false;
	}

	/**** MUTATORS ****/

	/**
	 * Creates a new first element
	 * 
	 * @param data the data to insert at the front of the LinkedList
	 * @postcondition a new node is inserted at the top of the linked list
	 */
	public void addFirst(T data) {
		Node N = new Node(data);
		if (length == 0) {
			first = last = N;
		} else {
			N.next = first;
			first = N;
		}
		length++;

	}

	/**
	 * Creates a new last element
	 * 
	 * @param data the data to insert at the end of the LinkedList
	 * @postcondition a new node is inserted at the end of the list
	 */
	public void addLast(T data) {
		if (length == 0) {
			first = last = new Node(data);
		} else {
			this.last.next = new Node(data);
			this.last.next.prev = this.last;
			this.last = this.last.next;
		}
		length++;
	}

	/**
	 * Inserts a new element after the iterator
	 * 
	 * @param data the data to insert
	 * @precondition <fill in here>
	 * @throws NullPointerException <fill in here>
	 */
	public void addIterator(T data) throws NullPointerException {
		return;
	}

	/**
	 * removes the element at the front of the LinkedList
	 * 
	 * @precondition Shouldn't be an empty list
	 * @postcondition the first node should be removed
	 * @throws NoSuchElementException when the list is empty
	 */
	public void removeFirst() throws NoSuchElementException {
		if (length == 0) {
			throw new NoSuchElementException("removeFirst(): Cannot remove from an empty List!");
		} else if (length == 1) {
			first = last = null;
		} // case where there's only one length
		else {
			this.first = this.first.next;
			// Node temp=first; temp=temp.next;
		}
		length--;
	}

	/**
	 * removes the element at the end of the LinkedList
	 * 
	 * @precondition list is not empty
	 * @postcondition the last node is removed
	 * @throws NoSuchElementException if list is empty
	 */
	public void removeLast() throws NoSuchElementException {
		if (length == 0) {
			throw new NoSuchElementException("removeFirst(): Cannot remove from an empty List!");
		} else if (length == 1) {
			first = last = null;
		} // case where there's only one length
		else {
//      this.last.prev.next = null; //removes the forward link from 2nd last to last
			this.last = this.last.prev;
		}
		length--;
	}

	/**
	 * removes the element referenced by the iterator
	 * 
	 * @precondition <fill in here>
	 * @postcondition <fill in here>
	 * @throws NullPointerException <fill in here>
	 */
	public void removeIterator() throws NullPointerException {

	}

	/**
	 * places the iterator at the first node
	 * 
	 * @precondition <fill in here>
	 * @postcondition <fill in here>
	 * @throws NullPointerException <fill in here>
	 */
	public void positionIterator() {

	}

	/**
	 * Moves the iterator one node towards the last
	 * 
	 * @precondition <fill in here>
	 * @postcondition <fill in here>
	 * @throws NullPointerException <fill in here>
	 */
	public void advanceIterator() throws NullPointerException {

	}

	/**
	 * Moves the iterator one node towards the first
	 * 
	 * @precondition <fill in here>
	 * @postcondition <fill in here>
	 * @throws NullPointerException <fill in here>
	 */
	public void reverseIterator() throws NullPointerException {

	}

	/**** ADDITIONAL OPERATIONS ****/

	/**
	 * Converts the LinkedList to a String, with each value separated by a blank
	 * line At the end of the String, place a new line character
	 * 
	 * @return the LinkedList as a String
	 */
	@Override
	public String toString() {
		String result = "";
		Node temp = first;
		while (temp != null) {
			result += temp.data + " ";
			temp = temp.next;
		}
		result += "\n";
		return result;
	}

	/**
	 * Determines whether the given Object is another LinkedList, containing the
	 * same data in the same order
	 * 
	 * @param o another Object
	 * @return whether there is equality
	 */
	@SuppressWarnings("unchecked") // good practice to remove warning here
	@Override
	public boolean equals(Object o) {
		return false;
	}

	/** CHALLENGE METHODS */

	/**
	 * Zippers two LinkedLists to create a third List which contains alternating
	 * values from this list and the given parameter For example: [1,2,3] and
	 * [4,5,6] -> [1,4,2,5,3,6] For example: [1, 2, 3, 4] and [5, 6] -> [1, 5, 2, 6,
	 * 3, 4] For example: [1, 2] and [3, 4, 5, 6] -> [1, 3, 2, 4, 5, 6]
	 * 
	 * @param list the second LinkedList in the zipper
	 * @return a new LinkedList, which is the result of zippering this and list
	 * @postcondition this and list are unchanged
	 */
	public LinkedList<T> zipperLists(LinkedList<T> list) {
		return null;
	}

	/**
	 * Determines whether a LinkedList is reversible, i.e. the data is the same
	 * written both forward and backward e.g. isReversible(1 2 3 2 1) -> true e.g.
	 * isReversible(A B B A) -> true
	 * 
	 * @return whether the list is reversible
	 */
	public boolean isReversible() {
		return false;
	}
}
