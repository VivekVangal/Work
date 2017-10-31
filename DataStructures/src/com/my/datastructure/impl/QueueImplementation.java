package com.my.datastructure.impl;

public class QueueImplementation<T extends Object> {
	private int size;
	private int front;
	private int rear;
	private T[] queueArr;
	
	@SuppressWarnings("unchecked")
	public QueueImplementation(int size)
	{
		this.size = size;
		front= -1;
		rear = -1;
		queueArr=(T[])new Object[this.size];
	}
	
	public boolean isQueueEmpty()
	{
		if(front == -1 && rear ==-1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isQueueFull()
	{
		if(front == ((rear+1) % size))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public void enqueue(T item) throws Exception
	{
		if(isQueueFull())
		{
			throw new Exception("Queue Is Already in Overflow state. No more elements can be added");
		}
		else if(isQueueEmpty())
		{
			front = 0;
			rear = 0;
		}
		else 
		{
			rear = ((rear+1) % size);
		}
		queueArr[rear] = item;
		System.out.println("New item enqueued: "+ item );
	}
	
	public T dequeue() throws Exception
	{
		T item = null;
		if(isQueueEmpty())
		{
			throw new Exception("Queue is Empty and is in Underflow Status. No items to dequeue");
		}
		else if((front%size) == (rear%size))
		{
			item = queueArr[front];
			front = -1;
			rear = -1;
		}
		else
		{
			item = queueArr[front++];
		}
		System.out.println("New item denqueued: "+ item );
		return item;
	}
	
	public static void main(String[] args) throws Exception
	{
		QueueImplementation<Integer> integerQueue = new QueueImplementation<Integer>(5);
		integerQueue.enqueue(4);
		integerQueue.enqueue(56);
		integerQueue.enqueue(2);
		integerQueue.enqueue(67);
		integerQueue.dequeue();
		integerQueue.dequeue();
		integerQueue.dequeue();
		integerQueue.enqueue(24);
		integerQueue.enqueue(98);
		integerQueue.enqueue(45);
		integerQueue.enqueue(23);
		System.out.println("Front:"+integerQueue.front);
		System.out.println("Rear"+integerQueue.rear);
	}
}
