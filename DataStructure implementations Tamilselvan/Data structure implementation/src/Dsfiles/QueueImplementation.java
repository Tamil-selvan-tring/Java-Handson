package Dsfiles;

import java.util.Scanner;

public class QueueImplementation {
	
	int arr[];
	int limit=0;
	int front=-1;
	int rear=-1;
	static Scanner input=new Scanner(System.in);
	QueueImplementation(int limit)
	{
		this.arr=new int[limit];
		this.limit=limit;
	}
	public void dequeue()
	{
		if(arr.length<=0)
		{
			System.out.println("Queue underflow");
		}
		else
		{
			System.out.println("Deleted item is:"+arr[front++]);
		}	
	}
	public void queue()
	{
		if(rear>=limit-1)
		{
			System.out.println("Queue Overflow");
		}
		else
		{
			System.out.println("Enter item value");
			arr[++rear]=input.nextInt();
			if(front<0)
				front++;
		}
	}
	public void display()
	{
		if(rear>=0)
		{
		for(int i=front;i<=rear;i++)
		{
			System.out.println(arr[i]);
		}
		}
		else
		{
			System.out.println("Queue Empty");
		}
	}
	public void peek()
	{
		if(front>=0)
		{
			System.out.println(arr[front]);
		}
		else
		{
			System.out.println("Queue Empty");
		}
	}
	public static void main(String[] args)
	{
		
		System.out.println("Enter Queue limit");
		int limit=input.nextInt();
		QueueImplementation Queue=new QueueImplementation(limit);
		
		while(true)
		{
			System.out.println("Press 1.Queue 2.Dequeue 3.peek 4.display 5.Exit");
			int respone=input.nextInt();
			switch(respone)
			{
				case 1:
					Queue.queue();
					break;
				case 2:
					Queue.dequeue();
					break;
				case 3:
					Queue.peek();
					break;
				case 4:
					Queue.display();
					break;
				case 5:
					System.exit(1);
				case default:
					System.out.println("Invalid input");

			}
		}
	}

}
