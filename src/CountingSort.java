public class CountingSort {
	
	// 3 adet dizi olacak
	// 1si sıralanmamış hali, birisi sıralanmış hali
	// biriside sayılardan kaç adet olduğunu sayan dizi
	
	// fonsiyonun aldığı değerler (sıralancak dizi, dizi boyutu, dizideki en büyük eleman)
	public int[] sort(int[] array,int n, int bigger)
	{
		int[] sorted = new int[n];
		int[] count = new int[bigger + 1]; // en büyük sayı kadar uzunlukta dizi açtık
		for(int i = 1; i <= n; i++) count[array[i]] = count[array[i]] + 1; //  sayılardan kaçar tane var saydık
		for(int i = 1; i <= bigger; i++) count[i] = count[i] + count[i - 1]; // sayının hangi indise geleceğini hesaplıyor
		for(int i = n; i >= 0; i--)
		{
			// sayılmış sayıları, sondan başlayarak başa doğru yazdırıyoruz.
			sorted[count[array[i]] - 1] = array[i]; // neden -1 derseniz, 0.indisten başlamak için
			count[array[i]] = count[array[i]] - 1; 
		}
		return sorted;
	}
}
