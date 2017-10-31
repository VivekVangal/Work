package com.my.datastructure.impl;

public class StackImplementation<T extends Object> {
	private int size;
	private T[] stackArray;
	private int top;
	
	@SuppressWarnings("unchecked")
	public StackImplementation(int size) {
		this.size = size;
		this.stackArray = (T[]) new Object[size];
		this.top=-1;
	}
	
	public boolean isStackEmpty()
	{
		if(top==-1)
			return true;
		return false;
	}
	
	public boolean isStackFull()
	{
		if(top==(size-1))
		{
			return true;
		}
		return false;
	}
	
	public void push(T item) throws Exception 
	{
		if(isStackFull())
		{
			System.out.println("Cant add item "+ item +" as the Stack is already full");
			throw new Exception("StackOverflowException");
		}
		else
		{
			stackArray[++top]=item;
			System.out.println("New element added: "+item);
		}
	}
	
	public T pop() throws Exception
	{
		T item = null;
		if(isStackEmpty())
		{
			System.out.println("Stack is empty. Pop operation cant be performed");
			throw new Exception("StackUnderflowException");
		}
		else
		{
			item = stackArray[top--];
			System.out.println("Element removed: "+item);
		}
		return item;
	}
	
	public static void main(String[] args) throws Exception
	{
		StackImplementation<String> stringStack = new StackImplementation<String>(5);
		stringStack.push("java2novice");
		stringStack.push("superNovice");
		stringStack.push("andrew");
		stringStack.push("douglass");
		stringStack.pop();
		stringStack.pop();
		stringStack.pop();
		stringStack.pop();
		StackImplementation<Integer> integerStack = new StackImplementation<Integer>(2);
		integerStack.push(23);
		integerStack.push(34);
	}
}
