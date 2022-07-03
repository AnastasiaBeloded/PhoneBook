package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if(app.getUserHelper().isLogged()){
            app.getUserHelper().logout();
        }

    }

    @Test
    public void loginSuccess(){

        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegistrationForm("noa@gmail.com","Nnoa12345$");
        app.getUserHelper().submitLogin();

        Assert.assertTrue(app.getUserHelper().isLogged());



    }

    @Test
    public void loginNegativeTestWrongEmail() {
        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegistrationForm("noagmail.com", "Nnoa12345$");
        app.getUserHelper().submitLogin();

        Assert.assertFalse(app.getUserHelper().isLogged());
        Assert.assertTrue(app.getUserHelper().isAlertDisplayed());
        Assert.assertTrue(app.getUserHelper().isErrorFormatDisplay());



    }


}
