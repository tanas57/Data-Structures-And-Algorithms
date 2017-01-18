public class AVL {
	private Node root;
	
	private class Node
	{
		private Node parent;
		private Node left;
		private Node right;
		private int balance;
		private int data;
		
		Node(int key)
		{
			parent = left = right = null;
			data = key;
			balance = 0;
		}
	}

	public void insert(int key)
	{
		Node n = new Node(key); // yeni node oluşturduk
		insert(root,n); // recursive fonksiyona gidiyoruz.
	}
	
	private void insert(Node r, Node n)
	{
		if(r == null) // kök boş ise elemanı kök yapıyoruz.
		{
			root = n;
		}
		else{
			// kök boş değilse, eğer kökten küçükse sol'a, değilse sağ çocuga ekleyeceğiz
			if(r.data > n.data) // sol
			{
				if(r.left == null) // boş olana kadar recursive olarak geziyoruz.
				{  // çocuklar arası bağlantı yapıldı
					n.parent = r;
					r.left = n;
				}
				else insert(r.left,n);
			}
			else{ // sağ
				if(r.right == null)
				{   // çocuklar arası bağlantı yapıldı
					n.parent = r;
					r.right = n;
				}
				else insert(r.right,n);
			}
		}
		// balance kontrolü
		balance(n);
	}

	private void balance(Node n)
	{
		n.balance = balance2(n);
	}
	
	private int balance2(Node n)
	{
		if(n!=null) return (balance2(n.left) - balance2(n.right));
		else return 0;
	}
	
	public void print()
	{
		printInOrder(root);
	}
	
	private void printInOrder(Node r)
	{
		if(r != null)
		{
			printInOrder(r.left);
			System.out.print(r.data + "(" + r.balance +") ");
			printInOrder(r.right);
		}
	}
}
