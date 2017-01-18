
public class Main {

	public static void main(String [] args)
	{
		int[] nums = {5,3,2,3,4,1,55,12,51,11,66,25,17,};

		AVL tree = new AVL();
		for(int i = 0; i<nums.length;i++) tree.insert(nums[i]);
		
		tree.print();
	}

	private static void print(int[] nums)
	{
		for(int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i] + " ");
		}
	}
}
