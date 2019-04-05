package apps;

import java.util.Iterator;
import java.util.NoSuchElementException;

import structures.Vertex;


public class PartialTreeList implements Iterable<PartialTree> {

	/**
	 * Inner class - to build the partial tree circular linked list 
	 * 
	 */
	public static class Node {
		/**
		 * Partial tree
		 */
		public PartialTree tree;

		/**
		 * Next node in linked list
		 */
		public Node next;

		/**
		 * Initializes this node by setting the tree part to the given tree,
		 * and setting next part to null
		 * 
		 * @param tree Partial tree
		 */
		public Node(PartialTree tree) {
			this.tree = tree;
			next = null;
		}
	}

	/**
	 * Pointer to last node of the circular linked list
	 */
	private Node rear;

	/**
	 * Number of nodes in the CLL
	 */
	private int size;

	/**
	 * Initializes this list to empty
	 */
	public PartialTreeList() {
		rear = null;
		size = 0;
	}

	/**
	 * Adds a new tree to the end of the list
	 * 
	 * @param tree Tree to be added to the end of the list
	 */
	public void append(PartialTree tree) {
		Node ptr = new Node(tree);
		if (rear == null) {
			ptr.next = ptr;
		} else {
			ptr.next = rear.next;
			rear.next = ptr;
		}
		rear = ptr;
		size++;
	}

	/**
	 * Removes the tree that is at the front of the list.
	 * 
	 * @return The tree that is removed from the front
	 * @throws NoSuchElementException If the list is empty
	 */
	public PartialTree remove() 
			throws NoSuchElementException {

		/* COMPLETE THIS METHOD */
		
		if(rear == null){
			throw new NoSuchElementException("No item in list");
		}
		
		Node frontNode = rear.next;
		PartialTree front = frontNode.tree;
		
		if(rear.next == rear){
			front = rear.tree;
			rear = null;
			return front;
		}else{
			
			rear.next = rear.next.next;
			size--;
		}
		
		return front;	
	}

	/**
	 * Removes the tree in this list that contains a given vertex.
	 * 
	 * @param vertex Vertex whose tree is to be removed
	 * @return The tree that is removed
	 * @throws NoSuchElementException If there is no matching tree
	 */
	public PartialTree removeTreeContaining(Vertex vertex) 
			throws NoSuchElementException {
		/* COMPLETE THIS METHOD */
		Node ptrTemp = rear;
		Node prevTemp = rear.next;
		PartialTree ptr = ptrTemp.tree;
		PartialTree prev = prevTemp.tree;
		boolean check = false;
		
		//loop through the list. If the root of one is equal to vertex, remove it form list and adjust 
		//the circular tree by setting ptr.next to prev.next (prev actually acts as the pointer in front of ptr)
		for(int i = 0; i<size+2;i++){
			
			System.out.println(prev.getRoot().toString());
			
			if(prev.getRoot().equals(vertex)){
				ptrTemp.next=prevTemp.next;
				check = true;
				size--;
				return prev;
			}
			
			ptrTemp = prevTemp;
			prevTemp = prevTemp.next;
			ptr = ptrTemp.tree;
			prev = prevTemp.tree;
		}
		
		if(check == true){
			System.out.println("Found matching tree");
		}else{
			throw new NoSuchElementException("No matching tree found");
		}
	
		return null;
	}

	/**
	 * Gives the number of trees in this list
	 * 
	 * @return Number of trees
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns an Iterator that can be used to step through the trees in this list.
	 * The iterator does NOT support remove.
	 * 
	 * @return Iterator for this list
	 */
	public Iterator<PartialTree> iterator() {
		return new PartialTreeListIterator(this);
	}

	private class PartialTreeListIterator implements Iterator<PartialTree> {

		private PartialTreeList.Node ptr;
		private int rest;

		public PartialTreeListIterator(PartialTreeList target) {
			rest = target.size;
			ptr = rest > 0 ? target.rear.next : null;
		}

		public PartialTree next() 
				throws NoSuchElementException {
			if (rest <= 0) {
				throw new NoSuchElementException();
			}
			PartialTree ret = ptr.tree;
			ptr = ptr.next;
			rest--;
			return ret;
		}

		public boolean hasNext() {
			return rest != 0;
		}

		public void remove() 
				throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

	}
}


