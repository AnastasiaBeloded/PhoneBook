package tests;


import contacts.User;
import manager.MyDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {


    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (app.getUserHelper().isLogged()) {
            app.getUserHelper().logout();
        }

    }

    @Test(groups = "web")
    public void registrationSuccess() {
        int i = (int)System.currentTimeMillis()/1000;
        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegistrationForm("noa"+i+"@gmail.com", "Nnoa12345$");
        app.getUserHelper().submitRegistration();

    }
    @Test(dataProvider = "registrationCvs",dataProviderClass = MyDataProvider.class)
    public void registrationSuccess2(User user) {

        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegistrationForm(user);
        app.getUserHelper().submitRegistration();

    }


}
