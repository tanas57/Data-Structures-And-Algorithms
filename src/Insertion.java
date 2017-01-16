

public class Insertion {
	public void Sort(int[] nums){
/*
 * �kinci elemandan ba�l�y�p, bir eksi�ini kar��la�t�r�yoruz.
 * De�i�tirilen yerde tekrar ba�a d�n�p kar��la�t�r�yoruz
 * (insert sort) performans� O(n2)�dir. Bunun sebebi dizideki eleman say�s� 
 * kadar ge�i� gerekmesi ve her ge�i�te en k�t� ihtimalle elemsan say�s� 
 * kadar kayd�rma gerekmesidir. Yani insertion sort�un en k�t� durumu 
 * tersten s�ral� bir listedir.
 * 
 */
	int temp = 0;
	int lenght = nums.length;
		for(int i = 1; i < lenght; i++)
		{
			if(nums[i] < nums[i-1])
			{
				temp = nums[i];
				nums[i] = nums[i-1];
				nums[i-1] = temp;
				i = 1;
			}
		}
	}
}
