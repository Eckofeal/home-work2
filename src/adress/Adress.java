package adress;

public class Adress {
    private String sity;
    private String street;
    private int houseNumber;

    public Adress(String sity, String street, int houseNumber) {
        if(houseNumber > 0) {
            this.houseNumber = houseNumber;
        }
        if(!street.isEmpty()) {
            this.street = street;
        }
        if(!sity.isEmpty()) {
            this.sity = sity;
        }
    }

    public String getSity() {
        return sity;
    }

    public void setSity(String sity) {
        if(!sity.isEmpty()) {
            this.sity = sity;
        }
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        if(!street.isEmpty()) {
            this.street = street;
        }
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        if(houseNumber > 0) {
            this.houseNumber = houseNumber;
        }
    }
}
