package app;

public class Address {
    private String street;
    private Integer houseNumber;
    private Integer zipCode;
    private String city;

    public Address(String street, Integer houseNumber, Integer zipCode, String city) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.city = city;
    }
    public Address(){

    }

    public String getStreet() {
        return street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
