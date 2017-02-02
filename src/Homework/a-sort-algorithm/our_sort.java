
public class Sort {
	public String strYour_name = "Muhammet Tayyip MUSLU";
	public long Your_number = 2015510101;
	public void Our_sort(int[] array, int p, int q, int digit){
		String binary1 = ""; String binary2 = "";
		int firstt = 0; int last = 0;
		int proc1,proc2,proc3,proc4;
		firstt = p; last = q;
		while(last > firstt){
			binary1= ""; binary2 = "";
			proc1 = array[firstt]; proc2 = array[last]; proc3 = array[firstt]; proc4 = array[last];
			for(int j = 1; j< digit; j++){
				if(proc1 / 2 >= 0){
					if(proc1 % 2 == 0) binary1 = "0" + binary1;
					else binary1 = "1" + binary1;
					proc1 = proc1 / 2;
				}
				if(proc2 / 2 >= 0){
					if(proc2 % 2 == 0) binary2 = "0" + binary2;
					else binary2 = "1" + binary2;
					proc2 = proc2 / 2;
				}
			}
			for(int ct = 0; ct < digit-1; ct++){
				if(binary1.charAt(ct) == '1' && binary2.charAt(ct) == '0'){
					array[firstt] = proc4; array[last] = proc3;
					break;
				}
				else if(binary1.charAt(ct) == '0' && binary2.charAt(ct) == '1'){
					break;
				}
				else if(binary1.charAt(ct) == '1' && binary2.charAt(ct) == '1'){
					ct++;
					if(binary1.charAt(ct) == '1' && binary2.charAt(ct) == '0'){ array[firstt] = proc4; array[last] = proc3; break; }
					else if(binary1.charAt(ct) == '0' && binary2.charAt(ct) == '1'){/* nothing. */ break; }
					ct--;
				}
				else{/* nothing */}	
			}
			last--;
			if(last <= firstt) { firstt++; last=q; }
		}
		for(int i = 0; i<array.length; i++){
			System.out.println(array[i]);
		}
		System.out.println();
	}
}
