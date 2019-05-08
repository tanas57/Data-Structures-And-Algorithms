/**
 * 
 */
package as;

/**
 * @author MusluNET
 *
 */
public class Queue {
	
	private class Node{
		
		protected Object data;
		protected Node next;
		
		public Node(Object data) {
			this.data = data;
			this.next = null;
		}
		
		public Object getData() { return this.data; }
		public void setNext(Node next) { this.next = next; }
		public Node getNext() { return this.next; }
	}
	
	private Node head;
	private int lenght;
	
	public Queue() {
		this.head = null;
		this.lenght = 0;
	}
	public void Enqueue(Object data) {
		Node tempNode = new Node(data);
		
		if(head == null) head = tempNode; // queue is empty
		else {
			Node temp = head;
			while(temp.getNext() != null) temp = temp.getNext(); 
			temp.setNext(tempNode);
		}
		lenght++;
	}
	
	public void Dequeue() {
		System.out.println(head.getData());
		this.head = head.getNext();
		lenght--;
	}
	
	public void printQueue() {
		Node temp = head;
		while(temp != null) {
			System.out.println("Data : " + temp.getData());
			temp = temp.getNext();
		}
	}
	
	public int getLenght() { return this.lenght; }
	
}
