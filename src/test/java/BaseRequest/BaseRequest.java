package BaseRequest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

abstract public class BaseRequest {
    protected RequestSpecification requestSpec;
    @BeforeClass
    public  void setup(){
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://localhost")
                .setPort(9876)
                .setBasePath("/api/f1")
                .build();

    }
    @Test
    public void tc01(){
        given().spec(requestSpec).auth().preemptive().basic("admin","password123").
                // base64 = oauth:gimmeatoken
                        when().log().all().
                post("https://restful-booker.herokuapp.com/auth").
                then().log().all().
                statusCode(200);
    }
}
