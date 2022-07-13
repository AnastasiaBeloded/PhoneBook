package tests;

import contacts.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContact extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if (!app.getUserHelper().isLogged()) {
            app.getUserHelper().login(new User().setEmail("mia@gmail.com").setPassword("Mmia12345$"));
        }
        app.contact().providerContactData();

    }

    @Test
    public void removeOneContactSuccess(){

        Assert.assertEquals(app.contact().removeOneContact(),1);


    }
    @Test
    public void removeAllContactsSuccess(){
        app.contact().removeAllContacts();
        Assert.assertTrue(app.contact().isNoContactsHere());
    }

}
