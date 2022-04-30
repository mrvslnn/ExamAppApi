package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pages.Login;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiUtilities {
    static Response response;
    static public void loginWithValidCredentials(String role){
        String email="";
        String password="Test123456!";
        switch (role){
            case "superadmin":
                email= "superadmin@example.com";
                break;
            case "editor":
                email="editor@example.com";
                break;
            case "moderator":
                email="moderator@example.com";
                break;
            case "expert":
                email="expert@example.com";
                break;
            case "schooladmin":
                email="schooladmin@example.com";
                break;
            case "salesman":
                email="salesman@example.com";
                break;
            case "student":
                email="student@example.com";
                break;
        }

        Map<String,Object> loginBody= new HashMap<>();
        loginBody.put("email",email);
        loginBody.put("password",password);


        response=given().contentType(ContentType.JSON).body(loginBody).
                when().post("http://kps-qa.sytes.net:9001/api/auth/login");
    }


    public static Map<String, Object> getToken(String role){

        loginWithValidCredentials(role);
        Login login= new Login();
        String bearerToken = "Bearer "+response.jsonPath().getString("data.token");
        Map<String, Object> token= new HashMap<>();
        token.put("Authorization",bearerToken);
        return token;
    }

}
