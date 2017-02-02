
public class Main {

	public static void main(String [] args)
	{
		int[] nums = {5,3,2,3,4,1,55,12,51,11,66,25,17,555,556,557,554};

		//AVL tree = new AVL();
		//for(int i = 0; i<nums.length;i++) tree.insert(nums[i]);
		//tree.print();
		
		BTree tree = new BTree();
		
		Stack yigin = new Stack(11);
		yigin.push(10);
		yigin.push(5);
		yigin.push(1);
		yigin.push(3);
		yigin.push(7);
		
		System.out.println("boyut : "+ yigin.pop());
		yigin.push(22);
		System.out.println("pop : "+ yigin.pop());
		System.out.println("pop : "+ yigin.pop());
		System.out.println("pop : "+ yigin.pop());
		
		yigin.push(57);
		System.out.println("peek : "+ yigin.peek());
		yigin.list();
	}

	private static void print(int[] nums)
	{
		for(int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i] + " ");
		}
	}
}
