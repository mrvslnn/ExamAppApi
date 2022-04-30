package pages;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Login {
    static Response response;
    static String expectedRole="";


    public void loginForAllUsers(){

        String expectedRole="";
        String actualRole="";
        List<String> allEmails= new ArrayList<>();
        allEmails.add("superadmin@example.com");
        allEmails.add("moderator@example.com");
        allEmails.add("editor@example.com");
        allEmails.add("expert@example.com");
        allEmails.add("salesman@example.com");
        allEmails.add("schooladmin@example.com");
        allEmails.add("student@example.com");

        Map<String, Object> credentials= new HashMap<>();
        for (int i = 0; i <allEmails.size() ; i++) {
            credentials.put("email",allEmails.get(i));
            credentials.put("password","Test123456!");

            response= given().contentType(ContentType.JSON).body(credentials).log().all().
                    when().post("http://kps-qa.sytes.net:9001/api/auth/login").prettyPeek();

            if (i==0){
                expectedRole=allEmails.get(0).split("@")[0].toUpperCase();//SUPERADMIN
                String[] roles=response.jsonPath().getString("data.roles[0]").split("_");// SUPER_ADMIN
                actualRole=roles[0]+roles[1];//SUPERADMIN
                assertEquals("roles didn't match",expectedRole,actualRole);
            }else if(i==5){
                expectedRole=allEmails.get(5).split("@")[0].toUpperCase();
                String[] roles=response.jsonPath().getString("data.roles[0]").split("_");
                actualRole=roles[0]+roles[1];
                assertEquals("roles didn't match",expectedRole,actualRole);
            }else {
                expectedRole=allEmails.get(i).split("@")[0].toUpperCase();
                actualRole=response.jsonPath().getString("data.roles[0]");
                assertEquals("roles didn't match",expectedRole,actualRole);
            }
            assertEquals(response.statusCode(),200);
        }




    }


    public void verifyUserLogin(){


        String actualRole= response.jsonPath().getString("data.roles[0]");
        assertEquals(200,response.statusCode());

    }




}
