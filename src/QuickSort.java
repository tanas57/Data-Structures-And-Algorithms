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
		int a = left; // sol ba�lang�c indisi
		int b = right; // biti� indisi
		int pivot = array[(left + right) / 2]; // pivotu dizinin ortas� olarak belirliyoruz
		int temp;
		
		while( a <= b ) // par�a bitene kadar
		{
			while(array[a] < pivot) a++; // pivottan k���kleri say
			while(array[b] > pivot) b--; // piottan b�y�kleri say
			if( a <= b )
			{   // k���kler ile b�y�kleri yer de�i�tirelim
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
