package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Moderator;

public class ModeratorStepDef {
    Moderator moderator= new Moderator();


    @Given("I have a request as {string} to create a {string}")
    public void iHaveARequestAsToCreateA(String creator, String created) {
        moderator.createModerator(creator,created);
    }

    @Then("verify created user with {int} status code")
    public void verifyCreatedUserWithStatusCode( int statusCode) {
        moderator.verifyCreatedUser(statusCode);
    }


    @Given("I have a request to get moderator with id {int}")
    public void iHaveARequestToGetModeratorWithId(int id) {
        moderator.getModeratorWithId(id);
    }

    @When("verify user with status code {int}")
    public void verifyUserWithStatusCode(int statusCode) {
        moderator.verifyModeratorWithStatusCode(statusCode);
    }



    @Given("I have a request as {string} to create {string}")
    public void iHaveARequestAsToCreate(String role, String create) {
        moderator.createTopic(role,create);
    }
    @Then("verify created topic with status code {int}")
    public void verifyCreatedTopicWithStatusCode(int statusCode) {
    }


    @Given("Given I have a request as {string} to create {string}")
    public void givenIHaveARequestAsToCreate(String role, String subject) {
        moderator.subjectCreate(role,subject);

    }

    @Then("verify created subject with status code {int}")
    public void verifyCreatedSubjectWithStatusCode(int arg0) {
    }
}
