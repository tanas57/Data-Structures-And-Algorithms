public class CountingSort {
	
	// 3 adet dizi olacak
	// 1si sýralanmamýþ hali, birisi sýralanmýþ hali
	// biriside sayýlardan kaç adet olduðunu sayan dizi
	
	// fonsiyonun aldýðý deðerler (sýralancak dizi, dizi boyutu, dizideki en büyük eleman)
	public int[] sort(int[] array,int n, int bigger)
	{
		int[] sorted = new int[n];
		int[] count = new int[bigger + 1]; // en büyük sayý kadar uzunlukta dizi açtýk
		for(int i = 1; i <= n; i++) {count[array[i]] = count[array[i]] + 1; System.out.print(count[i] + " "); }//  sayýlardan kaçar tane var saydýk
		System.out.println();
		for(int i = 1; i <= bigger; i++) {count[i] = count[i] + count[i - 1]; System.out.print(count[i] + " "); } // sayýnýn hangi indise geleceðini hesaplýyor
		System.out.println();
		for(int i = n; i >= 0; i--)
		{
			// sayýlmýþ sayýlarý, sondan baþlayarak baþa doðru yazdýrýyoruz.
			sorted[count[array[i]] - 1] = array[i]; // neden -1 derseniz, 0.indisten baþlamak için
			count[array[i]] = count[array[i]] - 1; 
		}
		return sorted;
	}
}
