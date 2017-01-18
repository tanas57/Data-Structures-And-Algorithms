

public class Insertion {
	public void Sort(int[] nums){
/*
 * İkinci elemandan başlıyıp, bir eksiğini karşılaştırıyoruz.
 * Değiştirilen yerde tekrar başa dönüp karşılaştırıyoruz
 * (insert sort) performansı O(n2)’dir. Bunun sebebi dizideki eleman sayısı 
 * kadar geçiş gerekmesi ve her geçişte en kötü ihtimalle elemsan sayısı 
 * kadar kaydırma gerekmesidir. Yani insertion sort’un en kötü durumu 
 * tersten sıralı bir listedir.
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
