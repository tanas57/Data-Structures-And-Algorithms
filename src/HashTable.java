public class HashTable {
private final int TABLE_SIZE = 57;

HashNode [] table;

HashTable()
{
	table = new HashNode[TABLE_SIZE];
	for(byte i = 0; i < TABLE_SIZE; i++) table[i] = null;
}
private int Hash(int key)
{
	return (((379 * key + 5) % TABLE_SIZE) * 179 ) % TABLE_SIZE;
}

private void add(int identity , String name, String surname, char gend)
{
	int hash = Hash(identity);
	while(table[hash] != null) {hash++; if(hash >= TABLE_SIZE) hash = 0;} // reHash
	table[hash] = new HashNode(identity ,name,surname,gend);
}

private void get(int identity)
{
	int hash = Hash(identity);
	while(table[hash].getKey() != identity) 
	{hash++; if(hash >= TABLE_SIZE) hash = 0;}
	
}
private void print()
{
	int i = 0;
	System.out.println("	 Name    Surname     Gender\n");
	while(i < TABLE_SIZE)
	{
		if(table[i] != null)
		System.out.println("Hash : " + i + "  " + table[i].getFirstName()+ "   " + table[i].getLastName() + "      " + table[i].getGender());
		i++;
	}
		
}
public static void main(String [] args)
{
	HashTable table = new HashTable();
	// first, is identity  for each people
	table.add(6616, "Tayyip", "Muslu", 'm');
	table.add(3131, "Fatih", "Yılmaz", 'm');
	table.add(12367, "Sevil", "Muslu", 'f');
	table.add(7712, "Kübra", "Yılmaz", 'f');
	table.add(413, "Koray", "Güneş", 'm');
	table.add(6616, "Deneme", "Kekee", 'm'); // rehash
	table.add(7712, "Deneme2", "Yılmaz", 'f');
	System.out.println();
	table.print();
}
}
