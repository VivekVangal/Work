package com.my.datastructure.impl;

public class LinkedList<T extends Object> {

	private Node<T> head;
	private Node<T> tail;

	public void add(T element) {
		Node<T> nd = new Node<T>();
		nd.setData(element);
		System.out.println("Adding: "+element);
		if (head == null) {
			head = nd;
			tail = nd;
		} else {
			tail.setNext(nd);
			tail = nd;
		}
	}

	public void addAfter(T element, T after) {
		Node<T> tmp = head;
		Node<T> refNode = null;
		System.out.println("Traversing to all nodes..");
		while (tmp.getNext() != null) {
			if (tmp.compareTo(after) == 0) {
				refNode = tmp;
				break;
			}
			tmp = tmp.getNext();
		}
		if (refNode != null) {
			Node<T> nodeToAdd = new Node<T>();
			nodeToAdd.setData(element);
			nodeToAdd.setNext(refNode.getNext());
			if (refNode == tail) {
				tail = nodeToAdd;
			}
			refNode.setNext(nodeToAdd);
			System.out.println("Adding: "+element);
		} else {
			System.out.println("Unable to find the given element...");
		}
	}

	public void deleteFront() {
		if(head==null)
		{
			System.out.println("Underflow...");
		}
		Node<T> tmp = head;
		head = tmp.getNext();
		if(head == null) {
			tail = null;
		}
		System.out.println("Deleted "+tmp.getData());
	}
	
	public void deleteAfter(T after) {
		Node<T> tmp = head;
		Node<T> refNode = null;
		System.out.println("Traversing to all nodes..");
		while(tmp.getNext()!=null)
		{
			if(tmp.compareTo(after)==0)
			{
				refNode = tmp;
				break;
			}
			tmp = tmp.getNext();
		}
		if(refNode !=null)
		{
			if(refNode==tail)
			{
				System.out.println("No element after that tail node to delete...");
			}
			Node<T> nodeToDelete = refNode.getNext();
			refNode.setNext(nodeToDelete.getNext());
			if(refNode.getNext() == tail)
			{
				tail = refNode;
			}
			System.out.println("Deleted "+nodeToDelete.getData());
		}
		else
		{
			System.out.println("Unable to find the given element...");
		}
		
	}
	
	public void traverse() {
		Node<T> tmp = head;
		while(tmp!=null)
		{
			System.out.println(tmp.getData());
			tmp=tmp.getNext();
		}
	}
	public static void main(String a[]){
		LinkedList<Integer> sl = new LinkedList<Integer>();
		sl.add(3);
		sl.add(32);
		sl.add(54);
		sl.add(89);
		sl.addAfter(76, 54);
		sl.traverse();
		sl.deleteFront();
		sl.deleteAfter(76);
		sl.traverse();
		}
	
	private static class Node<T> implements Comparable<T> {
		private T data;
		private Node<T> next;

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		@Override
		public int compareTo(T arg) {
			if (arg == this.data) {
				return 0;
			} else {
				return 1;
			}
		}
	}
}
