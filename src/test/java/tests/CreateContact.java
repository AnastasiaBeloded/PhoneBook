package tests;

import contacts.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateContact extends TestBase{
    @BeforeMethod
    public void preCondition() {
        if (app.getUserHelper().isLogged()) {
        }else
            app.getUserHelper().openLoginRegistrationForm();
            app.getUserHelper().fillLoginRegistrationForm("noa@gmail.com","Nnoa12345$");
            app.getUserHelper().submitLogin();

    }

    @Test
    public void createNewContact(){
        int i =(int)System.currentTimeMillis()/1000%3600;
        User user = new User().setName("Mia"+i).setLastName("Bio"+i).setPhone("0527899879").setEmail("miaBio@gmail.com")
                .setAddress("NY").setDescription("Friend");
        app.getUserHelper().openAddContactForm();
        app.getUserHelper().fillNewContactForm(user);


    }


}
