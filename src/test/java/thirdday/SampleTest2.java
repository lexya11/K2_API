package thirdday;

import io.restassured.*;
import org.testng.annotations.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class SampleTest2 {
    @BeforeClass
    public void setUpRestAssured(){
        RestAssured.baseURI = "http://swapi.co";
    }
    @Test
    public void tc01(){
        given().log().all()
                .get("/api/people/?search=r2")
                .then().log().all()
                .statusCode(200)
                .time(lessThan(20000L));
    }
    @Test
    public void useQueryParameter() {
        given().
                queryParam("search", "r2")
                .get("/api/people")
                .then().log().all()
                .statusCode(200)
                .assertThat()
                .body("results.height[0]",equalTo("96"))
        .body("count",equalTo(1));


    }

}
