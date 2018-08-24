package app;

public class Booking {
    private String firstname;
    private String lastname;
    private Integer totalprice;
    private boolean depositpaid;
    private String [] bookingdates;
    private String checkin;
    private String checkout;
    private String additionalneeds;

    public Booking(String firstname, String lastname, Integer totalprice, boolean depositpaid, String checkin, String checkout, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.checkin = checkin;
        this.checkout = checkout;
        this.additionalneeds = additionalneeds;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public String[] getBookingdates() {
        return bookingdates;
    }

    public String getCheckin() {
        return checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public void setBookingdates(String[] bookingdates) {
        this.bookingdates = bookingdates;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }
}
