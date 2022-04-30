package pages;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.ApiUtilities;
import utilities.ModeratorGetPojo;
import utilities.ModeratorPojo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Moderator {

    Response response;
    Faker faker= new Faker();

    public void createModerator(String creator,String created){
        String email=faker.internet().emailAddress();
        String firstName= faker.name().firstName();
        String lastName= faker.name().lastName();
        String mobile= faker.number().digits(10);
        String password= faker.internet().password(8,20,true,true,true);

        ModeratorPojo mp=new ModeratorPojo(email,firstName,lastName,mobile,password);

        response=given().contentType(ContentType.JSON).body(mp).headers(ApiUtilities.getToken(creator)).log().all().
                when().post(created+"s").prettyPeek();              //(header("Authrization","Bearer superadminToken")
    }

    public void verifyCreatedUser( int statusCode){


        assertEquals("User not created wrong status code",statusCode,response.statusCode());
        assertNotNull("The created user id is null",response.jsonPath().getString("data.id"));
        assertFalse("Timestamp is mepty",response.jsonPath().getString("timestamp").isEmpty());


    }

    public void getModeratorWithId(int id){
        response=given().contentType(ContentType.JSON).headers(ApiUtilities.getToken("superadmin")).log().all().
                when().get("moderators/"+id).prettyPeek();



    }

    public void verifyModeratorWithStatusCode(int statusCode){
        ModeratorGetPojo modPojo=response.as(ModeratorGetPojo.class);
        int actualid= modPojo.getData().getId();

        assertEquals("id",155,actualid);
        assertTrue("ErrorsBody",modPojo.getErrors().isEmpty());
    }

    public void createTopic(String authRole,String create){
//        Faker faker = new Faker();
//        String[] months = {"JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
//        String [] gradeLevel={"C1","C2","C3","C4","C5","C6","C7","C8","C9","C10","C11","C12"};
//
//        int sizeMonth = months.length;
//        int sizeGrade= gradeLevel.length;
//        int randomMonth = new Random().nextInt(sizeMonth);
//        int randomGrade= new Random().nextInt(sizeGrade);
//        String month= months[randomMonth];
//        String grade= gradeLevel[randomGrade];
        TopicTest.generateTopic();

        response=given().contentType(ContentType.JSON).headers(ApiUtilities.getToken(authRole)).body(TopicTest.generateTopic()).log().all().
                when(). post(create+"s").prettyPeek();

    }


    static public Map<String,Object> subjectBody(){
        /*
        {
  "parentId": 0,
  "titleEn": "string",
  "titleKz": "string",
  "titleRu": "string"
}
         */
        Map<String, Object> subject= new HashMap<>();
        Faker faker= new Faker();
        String title= faker.animal().name();
        //subject.put("parentId",108);
        subject.put("titleEn",title+"En");
        subject.put("titleKz",title+"Kz");
        subject.put("titleRu",title+"Ru");

        return subject;
    }


    public void subjectCreate(String role, String subject){

        response=given().contentType(ContentType.JSON).headers(ApiUtilities.getToken(role)).body(subjectBody()).log().all().
                when().post(subject+"s").prettyPeek();

    }}
