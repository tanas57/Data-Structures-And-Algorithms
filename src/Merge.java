

public class Merge {
/*
 * böl sýrala birleþtir.
 * girilen dizi yarýya bölünür taa ki tek elemana kadar.
 * ardýndan sýralanarak birleþtirilir
 */
	private int[] array;
    private int[] temp;
    private int length;
	public void Sort(int[] nums)
    {
        this.length = nums.length;
        this.array = nums;
        this.temp = new int[length];
        Divide(0, length - 1);
    }
    private void Divide(int left, int right)
    {
        if (left < right)
        {
            int center = left + (right - left) / 2; // array's middle
            Divide(left, center); 	   // divide left side
            Divide(center + 1, right); // divide right side
            Merge(left, right, center);
        }
    }
    private void Merge(int left, int right, int center)
    {
        for (int i = left; i <= right; i++) temp[i] = array[i]; // iþlem yapýlacak aralýk geçici diziye atýlýr
        int a = left; // dizinin baþlangýç noktasý
        int b = center + 1; // bölüm noktasý + 1 sað kýsmýn baþlangýç indisi
        int c = left; // deðiþtirilen parçanýn indisi
        while(a <= center && b <= right) // sol kýsým ortaya, diðer kýsým bitiþe gelene kadar
        {
        	// sað ve sol parçalarýn deðerini karþýlaþtýr
            if(temp[a] <= temp[b]) // küçükse eþit ise sol kýsýmdaki gelir.
            {
                array[c] = temp[a]; 
                a++; // bir sonraki indisler için 
            }
            else
            {
                array[c] = temp[b]; // büyük ise sað kýsým ile yer deðiþtirir.
                b++; // bir sonraki indisler için
            }
            c++; // diðer indise geç
        }
        while(a <= center) // iþlem görmemiþ kýsýmlarý orta noktaya gelene kadar array'a aktarýyoruz
        {
            array[c] = temp[a];
            c++;
            a++;
        }
    }

}
