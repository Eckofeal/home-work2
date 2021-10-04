package address;

public class Address {

    private String city;
    private String street;
    private int houseNumber;

    public Address(String сity, String street, int houseNumber) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = сity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
