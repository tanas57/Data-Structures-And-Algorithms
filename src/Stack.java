public class Stack {
	private int[] elements;
	private int top;
	private int max;
	Stack(int size)
	{
		elements = new int[size];
		top = 0;
		max = size;
	}
	public void push(int element)
	{
		elements[top] = element;
		top++;
	}
	
	public int pop()
	{
		top--;
		return elements[top];
	}
	
	public int peek()
	{
		return elements[top];
	}
	
	public boolean isEmpty()
	{
		if(top > 0) return true;
		else return false;
	}
	
	public boolean isFull()
	{
		if(top == max) return true;
		else return false;
	}
	
	public int size()
	{
		return top;
	}
	
	public void list()
	{
		for(int i = max - 1; i >= 0; i--) { if(elements[i] != 0)System.out.print(elements[i] + " ");}
	}
}
