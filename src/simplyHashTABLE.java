public class HashTable {
private final int TABLE_SIZE = 10; // hash tablosu uzunluğu
 
int[] table = new int[TABLE_SIZE];

private int Hash(int key)
{
	return key % TABLE_SIZE; // hash fonksiyonumuz
}

private void add(int key, int val)
{
	int hash = Hash(key);
	if(table[hash] != 0) { hash++; if(hash <= TABLE_SIZE) hash = 0; }
	table[Hash(key)] = val; // ekleme fonksiyonumuz
}
private int get(int key)
{
	return table[Hash(key)];
}
private void print()
{
	for(int i = 0; i < TABLE_SIZE; i++) System.out.print(table[i] + " ");
}
public static void main(String [] args)
{
	HashTable table = new HashTable();/
	table.add(1, 1231);
	table.add(5, 2222);
	table.add(3, 3333);
	table.add(7, 4444);
	table.add(6, 5777);
	System.out.println();
	table.print();
}
}
