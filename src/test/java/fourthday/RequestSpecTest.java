package fourthday;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;

import static io.restassured.RestAssured.given;

public class RequestSpecTest {
    private static RequestSpecification requestSpec;
    @BeforeClass
    public static void createRequestSpec(){
        requestSpec =
                new RequestSpecBuilder().
                        setBaseUri("https://restful-booker.herokuapp.com").
                        setBasePath("/booking/1").
                        build();
    }
    @Test
    public void useRequestSpec(){
        given().spec(requestSpec)
                .when().get("/booking/1")
                .then().log().all()
                .assertThat().statusCode(200);
    }

}
