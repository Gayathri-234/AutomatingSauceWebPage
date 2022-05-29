package testngpractices;

import base.browserSelection;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class amazonWebAutomation extends browserSelection {
    @Test
       public void Click_Search_TextBox() throws InterruptedException  {
       String signIn="nav-link-accountList-nav-line-1";
       String userId = "ap_email";
       String click_Id ="continue";
        driver.findElement(By.id(signIn)).click();
        driver.findElement(By.id(userId)).click();
        driver.findElement(By.id(userId)).sendKeys("v.gayathri234@gmail.com");
        driver.findElement(By.id(click_Id)).click();
        Thread.sleep(2000);

    }

}