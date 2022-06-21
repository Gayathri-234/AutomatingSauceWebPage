package testngpractices;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class amazonWebAutomation extends BaseTest {
    @Test
       public void Click_Search_TextBox() throws InterruptedException  {
       String signIn="nav-link-accountList-nav-line-1";
       String userId = "ap_email";
       String click_Id ="continue";
       String click_Pwd = "ap_password";
       String sign_In = "signInSubmit";
       //String actual_logo ="nav-logo-sprites";
        driver.findElement(By.id(signIn)).click();
        driver.findElement(By.id(userId)).click();
        driver.findElement(By.id(userId)).sendKeys("v.gayathri234@gmail.com");
        driver.findElement(By.id(click_Id)).click();
        driver.findElement(By.id(click_Pwd)).sendKeys("India@2020");
        driver.findElement(By.id(sign_In)).click();
        Thread.sleep(2000);
        String WebPageLogo = "//*[@id=\"nav-logo-sprites\"]";String Actual_Logo = driver.findElement(By.cssSelector(WebPageLogo)).getText();
        String Expected_Logo = "Amazon";
        Assert.assertEquals(Actual_Logo,Expected_Logo);
    }



    }

