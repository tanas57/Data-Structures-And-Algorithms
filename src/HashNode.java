public class HashNode {
	private int key;
    private String firstName;
    private String lastName;
    private char gender;

    HashNode(int identity , String name, String surname, char gend) {
          this.key = identity ;
          this.firstName = name;
          this.lastName = surname;
          this.gender = gend;
    }     

    public int getKey() {
          return key;
    }

    public String getFirstName() {
          return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getGender() {
        if(gender == 'm') return "Male";
        else return "Female";
    }
}
