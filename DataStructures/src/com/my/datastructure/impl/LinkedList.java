package com.my.datastructure.impl;

public class LinkedList<T extends Object> {

	private Node<T> head;
	private Node<T> tail;

	public void add(T element) {
		Node<T> nd = new Node<T>();
		nd.setData(element);
		if (head == null) {
			head = nd;
			tail = nd;
		} else {
			tail.setNext(nd);
			tail = nd;
		}
	}

	public void addAfter(T element,T after) {
		Node<T> tmp = head;
		Node<T> refNode = null;
		while(tmp.next!=null)
		{
			if(tmp.getNext().compareTo(after)==0)
			{
				
			}
		}
	}

	private static class Node<T> implements Comparable<T> {
		private T data;
		private Node<T> next;

		@SuppressWarnings("unused")
		public Node<T> getNext() {
			return next;
		}

		@SuppressWarnings("unused")
		public void setNext(Node<T> next) {
			this.next = next;
		}

		@SuppressWarnings("unused")
		public T getData() {
			return data;
		}

		@SuppressWarnings("unused")
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
