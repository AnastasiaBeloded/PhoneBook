package tests;

import org.testng.annotations.Test;

public class LoginTests extends TestBase{



    @Test
    public void successLogin(){
        //open form
        openLoginRegistrationForm();

        //fill form
        fillLoginRegistrationForm("noa@gmail.com","Nnoa12345$");

        //login
        submitLogin();

        //assert

    }
    @Test
    public void loginNegativeTestWrongEmail(){
        //open form
       openLoginRegistrationForm();
        //fill form invalid data
       fillLoginRegistrationForm("noagmail.com","Nnoa12345$");
        //login
        submitLogin();
        //assert(log success?) logout present ? not



    }





}
