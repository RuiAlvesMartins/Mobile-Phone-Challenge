public class Contacts {

    private String name;
    private int number;

    // getters
    public String getName() {
        return name;
    }
    public int getNumber() {
        return number;
    }

    // constructors
    public Contacts(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
