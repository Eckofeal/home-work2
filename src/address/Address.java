package address;

public class Address {
    private String сity;
    private String street;
    private int houseNumber;

    public Address(String сity, String street, int houseNumber) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.сity = сity;
    }

    public String getСity() {
        return сity;
    }

    public void setСity(String сity) {
        this.сity = сity;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }
}
