package tests;

import contacts.Contact;
import contacts.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class CreateContact extends TestBase{
    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (!app.getUserHelper().isLogged()) {
            app.getUserHelper().login(new User().setEmail("mia@gmail.com").setPassword("Mmia12345$"));
        }



    }

    @Test(invocationCount = 5)
    public void createNewContact(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;

        Contact contact = Contact.builder()
                .name("Mia"+i)
                .lastName("Bio"+i)
                .email("miaBio@gmail.com")
                .phone("052789"+i)
                .address("NY")
                .description("Friend").build();

        app.contact().openContactForm();
        app.contact().fillContactForm(contact);
        app.contact().saveContact2();

        Assert.assertTrue(app.contact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.contact().isContactAddedByPhone(contact.getPhone()));



    }


}
