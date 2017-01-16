
import java.util.Stack;
import java.util.Queue;


public class Main {

	public static void main(String [] args)
	{
		int[] nums = {5,3,2,3,2,1};
		CountingSort ct = new CountingSort();
		System.out.println();
		print(ct.sort(nums, nums.length-1, 5));
	}

	private static void print(int[] nums)
	{
		for(int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i] + " ");
		}
	}
}
