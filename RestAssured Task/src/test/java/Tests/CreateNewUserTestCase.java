package Tests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CreateNewUserTestCase {

    @Test
    public void CreateNewUser() {
        File body = new File("src/test/resources/User'sData.json");
        given().baseUri("https://64d4c7fbb592423e4694ad0b.mockapi.io")
                .contentType(ContentType.JSON)
                .body(body)
                .when().post("/api/v1/users")
                .then().log().all()
                .assertThat().statusCode(201);
    }

    @Test (dependsOnMethods = "CreateNewUser")
    public void AssertResponse() {
        given().baseUri("https://64d4c7fbb592423e4694ad0b.mockapi.io")
                .when().get("/api/v1/users")
                .then().log().all()
                .assertThat().statusCode(200)
                .body("name", hasItem("Omar Ashraf"));


    }
}
