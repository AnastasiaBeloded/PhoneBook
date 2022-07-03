package tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {


    @BeforeMethod
    public void preCondition() {
        if (app.getUserHelper().isLogged()) {
            app.getUserHelper().logout();
        }

    }


    @Test
    public void registrationSuccess() {
        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegistrationForm("noa003@gmail.com", "Nnoa12345$");
        app.getUserHelper().submitRegistration();

    }

}
