public class Heap {
	private static int n;
	
	private int left(int i)
	{
		return (2 * i) + 1;
	}
	
	private int right(int i)
	{
		return (2 * i) + 2;
	}
	
	public int minimum(int [] array)
	{
		return array[array.length - 1]; // o(1)
	}
	
	public int maximum(int [] array)
	{
		return array[0]; // o(1)
	}
	
	public void sort(int [] array)
	{
		n = array.length-1;
		
		heapify(array); // O(n) tüm diziyi düzenle
		// tüm sort iþlemi => O(n log(n))
		
		for(int i = n; i >= 0; i --)
		{
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			
			n = n - 1;
			heap(array,0);
		}
	}
	
	private void heapify(int [] array)
	{
		for(int i = n; i >= 0; i--) heap(array,i); // her heap sorgusu => O (log(n))
	}
	
	private void heap(int [] array, int i)
	{
		int left = left(i); // þuanki indisin sol çocuðu
		int right= right(i);// þuanki indisin sað çocuðunun indisi
		int largest = i;    // kendisini büyükmüþ gibi görüyoruz
		
		if((left <= n) && (array[left] > array[largest]) ) // sol çocuðu büyükse en büyük sol oluyor
		largest = left;
		
		if((right <= n) && (array[right] > array[largest]) ) // sað ile büyüðü karþýlaþtýrýyoruz
			largest = right; // büyükse en büyük sað çocuk oluyor
		
		if(largest != i) // iki indis ayný olana kadar
		{
			// indisler arasý deðiþtirme, swap iþlemi yapýyoruz
			int temp = array[i];
			array[i] = array[largest];
			array[largest] = temp;
			
			heap(array,largest); // deðiþtirilen indisleri kontrol ediyoruz
		}
	}
	
	public void print(int [] array)
	{
		for (int i = 0; i < array.length; i++) System.out.print(array[i] + " ");
	}
	
	public static void main(String[] args)
	{
		Heap h = new Heap();
		int[] array = {1,67,41,66,123,71,5,3,7,9,99};
		System.out.println("Sýralanmamýþ hali");
		h.print(array);
		
		h.sort(array); // sýrala
		
		System.out.println("\nSýralanmýþ hali");
		h.print(array);
		System.out.println("\nMaksimum : " + h.maximum(array));
		System.out.println("Minimum  : " + h.minimum(array));
	}
}