package thirdday;
import io.restassured.RestAssured;
import org.testng.annotations.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class SampleTest1 {
    @BeforeClass
    public void setUpRestAssured(){
        RestAssured.baseURI = "http://ergast.com";
//        RestAssured.basePath = "/api/f1/drivers/max_verstappen.json";
    }
    @Test
    public void tc01(){
        given().get("/api/f1/drivers/max_verstappen.json")
                .then()
                .statusCode(200)
                .time(lessThan(3500L));
//        given().log().all();
//        given().log().params();
//        given().log().body();
//        given().log().headers();
//        given().log().cookies();
//        given().log().method();

    }
    @Test
    public void tc02(){
        given().log().all()
                .get("/api/f1/drivers/hamilton.json")
                .then().log().all()
                .statusCode(200)
                .time(lessThan(3500L));
    }
    @Test
    public void tc03(){
        given().pathParam("driver","max_verstappen")
                .when().log().all()
                .get("/api/f1/drivers/{driver}.json")
                .then().log().all()
                .statusCode(200)
                .time(lessThan(3500L))
                .assertThat()
                .body("MRData.DriverTable.Drivers.permanentNumber[0]",equalTo("33"));

    }

    // Using dataProvider
    @Test(dataProvider =  "Drivers")
    public void tc04(String driver, String permanenNumber){
        given().pathParam("driver",driver)
                .when().log().all()
                .get("/api/f1/drivers/{driver}.json")
                .then().log().all()
                .statusCode(200)
                .time(lessThan(20000L))
                .assertThat()
                .body("MRData.DriverTable.Drivers.permanentNumber[0]",equalTo(permanenNumber))
                .body("MRData.DriverTable.driverId",equalTo(driver));
    }
    @DataProvider(name = "Drivers")
    public Object[][] test(){
        return new Object[][]{
                {"max_verstappen","33"},
                {"hamilton","44"}

        };
    }
}
