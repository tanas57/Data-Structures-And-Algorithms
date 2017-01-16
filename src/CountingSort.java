public class CountingSort {
	
	// 3 adet dizi olacak
	// 1si s�ralanmam�� hali, birisi s�ralanm�� hali
	// biriside say�lardan ka� adet oldu�unu sayan dizi
	
	// fonsiyonun ald��� de�erler (s�ralancak dizi, dizi boyutu, dizideki en b�y�k eleman)
	public int[] sort(int[] array,int n, int bigger)
	{
		int[] sorted = new int[n];
		int[] count = new int[bigger + 1]; // en b�y�k say� kadar uzunlukta dizi a�t�k
		for(int i = 1; i <= n; i++) {count[array[i]] = count[array[i]] + 1; System.out.print(count[i] + " "); }//  say�lardan ka�ar tane var sayd�k
		System.out.println();
		for(int i = 1; i <= bigger; i++) {count[i] = count[i] + count[i - 1]; System.out.print(count[i] + " "); } // say�n�n hangi indise gelece�ini hesapl�yor
		System.out.println();
		for(int i = n; i >= 0; i--)
		{
			// say�lm�� say�lar�, sondan ba�layarak ba�a do�ru yazd�r�yoruz.
			sorted[count[array[i]] - 1] = array[i]; // neden -1 derseniz, 0.indisten ba�lamak i�in
			count[array[i]] = count[array[i]] - 1; 
		}
		return sorted;
	}
}
