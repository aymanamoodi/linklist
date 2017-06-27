import java.util.Scanner;
import java.util.Stack;

public class LinkedList {
	static ListNode head;
	ListNode temp;
	
	static int dl;
	public void InsertNodeAtEnd(ListNode node) {
		if (head == null)
			head = node;
		else {
			 temp = head;
			while (head != null && temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
			//length++;
		}
	}
	public void LengthOfList(){
		temp=head;
		int length = 0;
		while (temp!=null){
			length++;
			temp=temp.next;
		}
		System.out.println("The length of List is "+length);
	}
	public void InsertNodeInMiddle(ListNode node, int dl){
		ListNode p = head;
		ListNode q;
		while(p.next!=null){
		if(p.next.data==dl){
			q=p.next;
			p.next=node;
			node.next=q;
	    }
		p=p.next;
		}
	}

	public void DisplayList(){
		temp=head;
		while(temp!=null){
			System.out.print(temp.data +"-->");
			temp=temp.next;
		}	
		System.out.println("End of List");
	}
	public void delete(int dl){
		ListNode p=head;
		ListNode q;
		if (dl==head.data){
			head= head.next;
		}
		else{
			while (p.next.data!=dl&&p.next!=null){
				p=p.next;
			}
			q= p.next.next;
			p.next=q;
		}
	}
	
	
	public void Reverse(){
		ListNode previous= null;
		ListNode current= head, next;
		
		while(current != null){
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head = previous;
	}
	
	void reversePrint(ListNode temp){
		if(temp == null) return;//Exit condition or base condition. 
		else
			reversePrint(temp.next);
		System.out.println(temp.data);
		
		
	}
	void reversePrintIterative(ListNode temp){
		Stack<Integer> s = new Stack();
		temp= head;
		while(temp!=null){
			int data=temp.data;
			s.push(data);
			temp=temp.next;
		}
		while(!s.isEmpty()){
			
			System.out.println(" the value of list is "+s.pop());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList l = new LinkedList();
		Scanner s = new Scanner(System.in);
		ListNode node = new ListNode();
		System.out.println("enter the value of node");
		node.data = s.nextInt();
		l.InsertNodeAtEnd(node);
		node = new ListNode();
		System.out.println("Enter the value of the new node");
		node.data = s.nextInt();
		l.InsertNodeAtEnd(node);
		l.DisplayList();
		l.LengthOfList();
		node = new ListNode();
		System.out.println("Enter the value of the new node");
		node.data = s.nextInt();
		l.InsertNodeAtEnd(node);
		l.DisplayList();
		l.LengthOfList();
		node=new ListNode();
		System.out.println(("Please enter the value of the node to be inserted"));
		node.data=s.nextInt();
		System.out.println("value where the node to be inserted before the nnode ");
        dl=s.nextInt();
        l.InsertNodeInMiddle(node,dl);
        l.DisplayList();
        l.LengthOfList();
        l.delete(dl);
        l.DisplayList();
        l.LengthOfList();
        l.Reverse();
        l.DisplayList();
        l.reversePrint(head);
        l.reversePrintIterative(head);
	}

}
