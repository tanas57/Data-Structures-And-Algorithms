// Binary Search Tree
public class BST {
	private Node root;
	private class Node
	{
		private Node parent;
		private Node left;
		private Node right;
		private int data;
		
		Node(int k)
		{
			left = right = null;
			data = k;
		}
	}
	
	public void insert(int k)
	{
		Node n = new Node(k);
		insert(root,n);
	}
	
	private void insert(Node r, Node n)
	{
		if(root == null) root = n;
		else{
			if(r.data > n.data) // sola
			{
				if(r.left == null) // en sola geldik
				{
					r.left = n;
					n.parent = r.left;
				}
				else insert(r.left,n);
			}
			else
			{ // sa�a
				if(r.right == null) // en sa�a geldik
				{
					r.right = n;
					n.parent = r.right;
				}
				else insert(r.right,n);
			}
		}
	}

	public void search(int k)
	{
		boolean control = search(root, k);
		if(control) System.out.println("Bulundu");
		else System.out.println("Bulunamad�");
	}
	
	private boolean search(Node r, int k)
	{
		if( r != null)
		{
			if(r.data == k) return true;
			else if(r.data > k) search(r.left,k);
			else if(r.data < k) search(r.right,k);
		}
		return false;
	}
	
	public void max()
	{
		System.out.println(max(root));
	}
	// en b�y�k de�er i�in a�ac�n en sa��na gideriz
	private int max(Node r)
	{
		if(r!=null)
		{
			max(r.right);
		}
		return r.data;
	}
	
	public void min()
	{
		System.out.println(min(root));
	}
	// en k���k de�er i�in a�ac�n en soluna gideriz
	private int min(Node r)
	{
		if(r!=null)
		{
			min(r.left);
		}
		return r.data;
	}
	
	public void print(Node r)
	{
		if( r != null )
		{
			print(r.left);
			System.out.print(r.data + " ");
			print(r.right);
		}
	}
}
