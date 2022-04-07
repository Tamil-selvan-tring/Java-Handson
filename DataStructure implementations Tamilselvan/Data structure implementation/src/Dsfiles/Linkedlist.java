package Dsfiles;
public class Linkedlist {
	int data;
	Linkedlist next;
	Linkedlist head;
	Linkedlist(){
		head=null;
	}
	//Saved node as class Linkedlist's object
	Linkedlist(int dataval){
	data=dataval;
	next=null;
	}
	public void insertatfirst(int val)
	{
		Linkedlist newnode=new Linkedlist(val);
		// When list is empty
		if(head==null)
		{
			head=newnode;
		}
		// List is not empty
		else 
		{
			newnode.next=head;
			head=newnode;
		}
	}
	// Display all the elements in the list
	public void display() 
	{
		Linkedlist temp=head;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println(" ");
	}
	public void insertAtlast(int val)
	{
		Linkedlist newLinkedlist=new Linkedlist(val);
		if(head==null)
		{
		head=newLinkedlist;
		}
		else 
		{
				Linkedlist temp = new Linkedlist(val);
			    temp = head;
			     while(temp.next != null)
			       temp = temp.next;
			     temp.next = newLinkedlist;
		}
	
	}
	//Insert the element in specified position
	public void insertAtPos(int pos,int val)
	{
		if(pos==0)
		{
			insertatfirst(val);
			return;
		}
		Linkedlist newLinkedlist=new Linkedlist(val);
		Linkedlist temp=head;
		for(int i=0;i<pos-1;i++)
		{
			temp=temp.next;
		if(temp==null)
		{
			System.out.println("Invalid Position");
			return;
		}
		}
		newLinkedlist.next=temp.next;
		temp.next=newLinkedlist;
	
		}
		public void deleteAtPos(int pos)
		{
		if(head==null)
		{
			System.out.println("Empty list");
			return;
		}
		if(pos==0)
		{
			head=head.next;
			return;
		}
			Linkedlist temp=head;
			Linkedlist previous=null;
			for(int i=0;i<pos;i++)
			{
			//previous node address stored 
				previous=temp;
			//Move to next node
			temp=temp.next;
			}
			// Reassign
			previous.next=temp.next;
		}
}
