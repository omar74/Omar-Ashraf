package Tests;


import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CheckGetRequestTestCase {
    @Test
    public void AssertResponse() {
        given().baseUri("https://64d4c7fbb592423e4694ad0b.mockapi.io")
                .when().get("/api/v1/users")
                .then().log().all()
                .assertThat().statusCode(200);
    }

}
