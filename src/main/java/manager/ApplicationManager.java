package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {

    WebDriver wd;
    UserHelper userHelper;


    public void init(){

        wd = new ChromeDriver();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        userHelper = new UserHelper(wd);

    }

    public void stop(){

        wd.quit();
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }


}
