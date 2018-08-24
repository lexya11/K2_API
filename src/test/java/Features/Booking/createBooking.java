package Features.Booking;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class createBooking {
    @BeforeClass
    public void setUpRestAssured(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
    }
}
