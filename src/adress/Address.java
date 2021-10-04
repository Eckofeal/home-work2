package adress;

public class Address {
    private String sity;
    private String street;
    private int houseNumber;

    public Address(String sity, String street, int houseNumber) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.sity = sity;
    }

    public String getSity() {
        return sity;
    }

    public void setSity(String sity) {
        this.sity = sity;
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
