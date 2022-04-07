package Dsfiles;

public class Linkedlistexecute {

	public static void main(String[] args) {
		Linkedlist Linkedlist=new Linkedlist();
		// Adding to Linked list at Beginning
		Linkedlist.insertatfirst(100);
		Linkedlist.insertatfirst(200);
		Linkedlist.insertatfirst(300);
		Linkedlist.insertatfirst(400);
		Linkedlist.insertatfirst(500);
		Linkedlist.display();
		//Adding to Linked list at end
		Linkedlist.insertAtlast(600);
		Linkedlist.display();
		// Adding to Linked list specific position
		Linkedlist.insertAtPos(3,700);
		Linkedlist.display();
		//Deleting at position
		Linkedlist.deleteAtPos(2);
		Linkedlist.display();
	}
}
