package tests;

import contacts.User;
import manager.MyDataProvider;
import org.testng.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(app.getUserHelper().isLogged()){
            app.getUserHelper().logout();
        }
    }

    @Test(groups = {"web"})
    public void loginSuccess(){
        logger.info("Test stars with email: mia@gmail.com and password: Mmia12345$");

        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegistrationForm("mia@gmail.com","Mmia12345$");
        app.getUserHelper().submitLogin();

        Assert.assertTrue(app.getUserHelper().isLogged());
        logger.info("Test passed");

    }
    @Test(dataProvider = "dataLogin",dataProviderClass = MyDataProvider.class)
    public void loginSuccess2(String email, String password){
        logger.info("Test stars with dataLogin");

        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegistrationForm(email,password);
        app.getUserHelper().submitLogin();

        Assert.assertTrue(app.getUserHelper().isLogged());
        logger.info("Test passed");

    }
    @Test(dataProvider = "loginCvs",dataProviderClass = MyDataProvider.class)
    public void loginSuccess3(User user){
        logger.info("Test stars with dataLogin");

        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegistrationForm(user);
        app.getUserHelper().submitLogin();

        Assert.assertTrue(app.getUserHelper().isLogged());
        logger.info("Test passed");

    }

    @Test(enabled = false)
    public void loginNegativeTestWrongEmail() {
        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegistrationForm("noagmail.com", "Nnoa12345$");
        app.getUserHelper().submitLogin();

        Assert.assertFalse(app.getUserHelper().isLogged());
        Assert.assertTrue(app.getUserHelper().isAlertDisplayed());
        Assert.assertTrue(app.getUserHelper().isErrorFormatDisplay());

    }


}
