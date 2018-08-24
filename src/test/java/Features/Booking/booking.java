package Features.Booking;

import app.Booking;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class booking {
    @BeforeClass
    public void setUpRestAssured(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
    }
    @Test(dataProvider = "Booking")
    public void showAllBooking(String idBooking, String firstname){
        given().log().all()
                .get("/booking/"+idBooking)
                .then().log().all()
                .statusCode(200)
                .assertThat()
                .body("firstname",equalTo(firstname));
    }
    @DataProvider(name = "Booking")
    public Object[][] data(){
        return new Object[][]{
                {"1","Sally"},
                {"2","Mark"},
                {"3","Sally"},
                {"4","Susan"},
                {"5","Mary"},
                {"6","Jim"},
                {"7","Eric"},
                {"8","Sally"},
                {"9","Sally"}


        };
    }
    @Test
    public void searchDateBooking(){
        given()
                .get("/booking/1")
                .then().log().all()
                .statusCode(200)
                .assertThat()
                .body("bookingdates.checkin",equalTo("2015-05-16"));
    }
    @Test
    public void searchBooking(){
        Booking booking = new Booking("Sally","Jackson",874,false,"","","");
        given().
                body(booking).
                when().log().all().
                get("/booking/1").
                then().
                assertThat().
                statusCode(200);
    }
    @Test
    public void createBooking(){
        Booking booking = new Booking("Sally","Jackson",874,false,"","","");
        given().
                body(booking).
                when().log().all().
                post("/booking").
                then().
                assertThat().
                statusCode(200);
    }


}
