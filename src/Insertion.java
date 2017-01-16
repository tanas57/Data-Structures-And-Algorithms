

public class Insertion {
	public void Sort(int[] nums){
/*
 * Ýkinci elemandan baþlýyýp, bir eksiðini karþýlaþtýrýyoruz.
 * Deðiþtirilen yerde tekrar baþa dönüp karþýlaþtýrýyoruz
 * (insert sort) performansý O(n2)’dir. Bunun sebebi dizideki eleman sayýsý 
 * kadar geçiþ gerekmesi ve her geçiþte en kötü ihtimalle elemsan sayýsý 
 * kadar kaydýrma gerekmesidir. Yani insertion sort’un en kötü durumu 
 * tersten sýralý bir listedir.
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
