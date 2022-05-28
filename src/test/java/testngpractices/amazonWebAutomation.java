package testngpractices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class amazonWebAutomation {

    ChromeDriver driver;
   @BeforeMethod
      public void LaunchBrowser() {
        WebDriverManager.chromedriver().setup(); //automatically manages browser executable file
        driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.com/");

    }
    @Test
    public void Click_Search_TextBox() {
       String userNameId="ap_email";
       String click_Id ="continue";
        //System.out.println("ap_email");
        driver.findElement(By.id(userNameId)).sendKeys("v.gayathri234@gmail.com");
        driver.findElement(By.id(click_Id)).click();
    }


}