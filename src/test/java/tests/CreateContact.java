package tests;

import contacts.Contact;
import contacts.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class CreateContact extends TestBase{
    @BeforeMethod
    public void preCondition() {
        if (!app.getUserHelper().isLogged()) {
            app.getUserHelper().login(new User().setEmail("noa@gmail.com").setPassword("Nnoa12345$"));
        }


    }

    @Test
    public void createNewContact(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;

        Contact contact = Contact.builder()
                .name("Mia"+i)
                .lastName("Bio"+i)
                .email("miaBio@gmail.com")
                .phone("0527899879")
                .address("NY")
                .description("Friend").build();

        app.contact().openContactForm();
        app.contact().fillContactForm(contact);
        app.contact().saveContact2();

        Assert.assertTrue(app.contact().isContactAddedByName(contact.getName()));



    }


}
