package tests;


import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @Test
    public void registrationSuccess(){
        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegistrationForm("noa003@gmail.com","Nnoa12345$");
        app.getUserHelper().submitRegistration();

    }

}
