public class QuickSort {

	public void sort(int[] array, int left, int right)
	{
		if(left < right)
		{
			int q = partition(array, left, right); // divide 
			sort(array, left, q - 1);
			sort(array, q + 1, right);
		}
	}
	
	private int partition(int[] array, int left, int right)
	{
		int a = left; // sol başlangıc indisi
		int b = right; // bitiş indisi
		int pivot = array[(left + right) / 2]; // pivotu dizinin ortası olarak belirliyoruz
		int temp;
		
		while( a <= b ) // parça bitene kadar
		{
			while(array[a] < pivot) a++; // pivottan küçükleri say
			while(array[b] > pivot) b--; // piottan büyükleri say
			if( a <= b )
			{   // küçükler ile büyükleri yer değiştirelim
				temp = array[a]; 
				array[a] = array[b];
				array[b] = temp;
				a++;
				b--;
			}
		}
		return a; // devam edilecek indis
	}
	
	private void print(int[] array)
	{
		for(int i = 0; i < array.length; i++) System.out.print(array[i] + " ");
	}
	public static void main(String[] args)
	{
		int [] array = { 15,44,11,77,23,16,1,6,69,33};
		
		QuickSort q = new QuickSort();
		q.sort(array, 0, array.length - 1);
		q.print(array);
	}
}
