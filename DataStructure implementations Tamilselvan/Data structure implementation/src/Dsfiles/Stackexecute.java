package Dsfiles;
import java.util.*;
public class Stackexecute 
{
	int arr[];
	int limit=0;
	int top=-1;
	static Scanner input=new Scanner(System.in);
	Stackexecute(int limit)
	{
		this.arr=new int[limit];
		this.limit=limit;
	}
	public void pop()
	{
		if(arr.length<=0)
		{
			System.out.println("Stack underflow");
		}
		else
		{
			System.out.println("Popped item is:"+arr[top--]);
		}	
	}
	public void push()
	{
		if(top>=limit-1)
		{
			System.out.println("Stack Overflow");
		}
		else
		{
			System.out.println("Enter item value");
			arr[++top]=input.nextInt();			
		}
	}
	public void display()
	{
		for(int i=top;i>=0;i--)
		{
			System.out.println(arr[i]);
		}
	}
	public void peek()
	{
		if(top>=0)
		{
			System.out.println(arr[top]);
		}
		else
		{
			System.out.println("Stack Empty");
		}
	}
	public static void main(String[] args)
	{
		
		System.out.println("Enter Stack limit");
		int limit=input.nextInt();
		Stackexecute stack=new Stackexecute(limit);
		
		while(true)
		{
			System.out.println("Press 1.push 2.pop 3.peek 4.display 5.Exit");
			int respone=input.nextInt();
			switch(respone)
			{
				case 1:
					stack.push();
					break;
				case 2:
					stack.pop();
					break;
				case 3:
					stack.peek();
					break;
				case 4:
					stack.display();
					break;
				case 5:
					System.exit(1);
				case default:
					System.out.println("Invalid input");

			}
		}
	}

}
