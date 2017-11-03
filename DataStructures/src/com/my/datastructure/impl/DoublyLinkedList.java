package com.my.datastructure.impl;

public class DoublyLinkedList<E> {

	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	public DoublyLinkedList() {
		size = 0;
	}
	
	private void addFirst(E element) {
		Node<E> nodeToAdd = new Node<E>();
		nodeToAdd.setElement(element);
		if(head == null)
		{
			head = nodeToAdd;
			tail = nodeToAdd;
		}
		else
		{
			nodeToAdd.setNext(head);
			head.setPrev(nodeToAdd);
			head=nodeToAdd;
		}
		size++;
	}
	
	private void addLast(E element) {
		Node<E> nodeToAdd = new Node<E>();
		nodeToAdd.setElement(element);
		if(head == null)
		{
			head = nodeToAdd;
			tail = nodeToAdd;
		}
		else 
		{
			tail.setNext(nodeToAdd);
			nodeToAdd.setPrev(tail);
			tail = nodeToAdd;
		}
	}
	
	private void addAfter(E element,E after)
	{
		Node<E> tmp = head;
		Node<E> refNode = null;
		System.out.println("Traversing through the list...");
		while(tmp!=null)
		{
			if(tmp.compareTo(after)==0) {
				refNode = tmp;
				break;
			}
			tmp = tmp.getNext();
		}
		if(refNode!=null) {
			Node<E> nodeToAdd = new Node<E>();
			nodeToAdd.setElement(element);
			nodeToAdd.setPrev(refNode);
			nodeToAdd.setNext(refNode.getNext());
			refNode.setNext(nodeToAdd);
			if(tail == refNode)
			{
				tail = nodeToAdd;
			}
			else
			{
				nodeToAdd.getNext().setPrev(nodeToAdd);
			}
		}
		Node<E> nodeToAdd = new Node<E>();
		nodeToAdd.setElement(element);
	}
	
	public E removeFirst()
	{
		E element = null;
		if(head == null)
		{
			System.out.println("Underflow...");
		}
		else if(head == tail)
		{
			element = head.getElement();
			head = null;
			tail = null;
		}
		else
		{
			element = head.getElement();
			head = head.getNext();
			head.setPrev(null);
		}
		System.out.println("Removed Element: "+element);
		return element; 
	}
	
	public E removeLast()
	{
		E element=null;
		if(tail == null)
		{
			System.out.println("Underflow...");
		}
		else if(head == tail)
		{
			element = head.getElement();
			head = null;
			tail =null;
		}
		else
		{
			element = tail.getElement();
			tail = tail.getPrev();
			tail.setNext(null);
		}
		System.out.println("Removed element: "+element);
		return element;
	}

	
	private class Node<E> implements Comparable<E>{
		private E element;
		private Node<E> next;
		private Node<E> prev;
		public E getElement() {
			return element;
		}
		public void setElement(E element) {
			this.element = element;
		}
		public Node<E> getNext() {
			return next;
		}
		public void setNext(Node<E> next) {
			this.next = next;
		}
		public Node<E> getPrev() {
			return prev;
		}
		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}
		@Override
		public int compareTo(E arg) {
			if (arg == this.element) {
				return 0;
			} else {
				return 1;
			}
		}
	}

	public static void main(String a[]){
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
		dll.addFirst(10);
		dll.addFirst(34);
		dll.addLast(56);
		dll.addLast(364);
		dll.iterateForward();
		dll.removeFirst();
		dll.removeLast();
		dll.iterateBackward();
		}

	private void iterateBackward() {
		// TODO Auto-generated method stub
		Node<E> tmp = tail;
		while(tmp!=null)
		{
			System.out.println(tmp.getElement());
			tmp = tmp.getPrev();
		}
	}

	private void iterateForward() {
		// TODO Auto-generated method stub
		Node<E> tmp = head;
		while(tmp!=null)
		{
			System.out.println(tmp.getElement());
			tmp = tmp.getNext();
		}
	}
}
