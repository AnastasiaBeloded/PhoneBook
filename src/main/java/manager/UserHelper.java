package manager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class UserHelper extends HelperBase {


    public UserHelper(WebDriver wd) {
        super(wd);
    }


    public void openLoginRegistrationForm() {

        WebElement loginTab = wd.findElement(By.cssSelector("[href$='/login']"));
        loginTab.click();
    }

    public void submitLogin() {
        wd.findElement(By.xpath("//button[1]")).click();

    }

    public void submitRegistration() {
        wd.findElement(By.xpath("//button[2]")).click();

    }

    public void fillLoginRegistrationForm(String email, String password) {
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);

    }

    public boolean isLogged() {
        List<WebElement> list = wd.findElements(By.xpath("//button[text()='Sign Out']"));
        return list.size()>0;
    }

    public void logout() {
        click(By.xpath("//button[text()='Sign Out']"));
    }

    public boolean isAlertDisplayed() {
      Alert alert = new WebDriverWait(wd, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
      if(alert==null){
          return false;
      }else {
          return true;
      }

    }

    public boolean isErrorFormatDisplay() {
        Alert alert = wd.switchTo().alert();
       /* alert.getText();//text
        alert.sendKeys("Hello World");
        alert.accept();////click ok button
        alert.dismiss();///click cancel button*/

        String errorText = alert.getText();
        System.out.println(errorText);
        alert.accept();
        return errorText.contains("Wrong email or password format");
    }
}
