package fourthday;

import app.Address;
import app.Car;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class MockServerTest {
    private static RequestSpecification requestSpec;

    @BeforeClass
    public  void setup(){
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://localhost")
                .setPort(9876)
                .setBasePath("/api/f1")
                .build();

    }
    @Test
    public void serializeAddressToJson(){
        Address myAddress = new Address("My street", 1, 1234, "Amsterdam");
        given().
                body(myAddress).
                when().log().all().
                post("http://localhost:9876/address").
                then().
                assertThat().
                statusCode(200);

    }
    @Test
    public void deserializeJsonToAddress() {
        Address MyAddress =
                given().
                        when().log().all().
                        get("http://localhost:9876/address").
                        as(Address.class);

        Assert.assertEquals("Amsterdam", MyAddress.getCity());
    }
    @DataProvider(name = "Cars")
    public Object[][] Cars(){
        return new Object[][]{
                {new Car("Alfa Romeo","Giulia",2016),404},
                {new Car("Ford", "Focus",  2012),200}

        };
    }
    @Test(dataProvider = "Cars")
    public void serializeCarToJson(Car car, Integer statusCode){

        given().body(car).
                when().log().all().
                post("http://localhost:9876/car/postcar").
                then().log().all().
                assertThat().
                statusCode(statusCode);
    }

    @Test
    public void deserializeJsonToCar() {
        Car myCar =
                given().
                        when().log().all().
                        get("http://localhost:9876/car/postcar").
                        as(Car.class);

        Assert.assertEquals("Focus", myCar.getModel());
    }
    @Test
    public void basicAuthenticateTest(){
        given().spec(requestSpec).auth().preemptive().basic("oauth","gimmeatoken").
                // base64 = oauth:gimmeatoken
                when().log().all().
                get("oauth2/token").
                then().log().all().statusCode(200);
    }

}
