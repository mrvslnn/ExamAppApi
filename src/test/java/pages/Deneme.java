package pages;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;

public class Deneme {
    @Test
    public void portDeneme(){
        String url = ConfigReader.get("baseURI")+ConfigReader.get("testPort");
        Response response=given().contentType(ContentType.JSON).get(url).prettyPeek();
    }


    public void Deneme2() {

        // Response response= given().contentType(ContentType.JSON).headers("Authorization",Login.token("TEACHER")).log().all().when().put();
    }
}
