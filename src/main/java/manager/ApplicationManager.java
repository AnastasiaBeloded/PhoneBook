package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManager {

    WebDriver wd;
    UserHelper userHelper;
    HelperContact contact;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);


    public void init(){

        wd = new ChromeDriver();
        WebDriverListener listener = new MyListener();
        wd = new EventFiringDecorator(listener).decorate(wd);
        logger.info("All tests run in chrome browser");
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.info("Current Url---->"+wd.getCurrentUrl());

        userHelper = new UserHelper(wd);
        contact = new HelperContact(wd);

    }

    public void stop(){

        wd.quit();
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public HelperContact contact() {
        return contact;
    }
}
