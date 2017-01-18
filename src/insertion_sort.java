

public class insertion_sort {
	public static void main(String [] args)
	{
		int[] nums = {31,1,56,33,777,123,25,15,17,20,11,10,1,23,3};
		insertion_sort dz = new insertion_sort();
		dz.Sort(nums);
		dz.print(nums);
	}
	
	private void Sort(int[] nums){
	int temp = 0;
	int lenght = nums.length;
		for(int i = 1; i < lenght; i++) // 1den başlayarak dizinin sonuna kadar devam et
		{
			if(nums[i] < nums[i-1]) // büyük ile küçüğü değiştir ve tekrar indis 1 e git.
			{
				temp = nums[i]; // dizide indisler arası değişiklik olacağından
				nums[i] = nums[i-1]; // temp adında bir değişkene ihtiyaç duyarız.
				nums[i-1] = temp;
				i = 1;
			}
		}
	}
	private void print(int[] nums)
	{
		for(int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i] + " ");
		}
	}
}