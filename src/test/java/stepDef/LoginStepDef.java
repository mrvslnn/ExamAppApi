package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.Login;

public class LoginStepDef {

    Login login=new Login();

    @Given("make a request for all user")
    public void make_a_request_for_all_user() {

        login.loginForAllUsers();

    }
    @When("verify if the login successful")
    public void verify_if_the_login_successful() {

        login.verifyUserLogin();
        //System.out.println("SUPERADMINTOKEN  --> "+Login.token("SUPER_ADMIN"));
    }
}

