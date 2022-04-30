package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.ConfigReader;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.reset;

public class Hooks {
    @Before
    public void setUp(){

        baseURI= ConfigReader.get("baseURI");
    }

    @After
    public void teardown(){

        reset();
    }
}
