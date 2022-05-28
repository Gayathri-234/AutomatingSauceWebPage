package testngpractices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class sauceDemoWebAutomation {

//public class LoginPageTest {

    ChromeDriver driver; //Declaration

    @BeforeMethod
    public void setupForLogin() {
        System.out.println("Before Method");


        WebDriverManager.chromedriver().setup(); //automatically manages browser executable file
        driver = new ChromeDriver(); //Object assignment

        //Step 2 - Navigate to login url
        driver.navigate().to("https://www.saucedemo.com/"); // Back and FOrward supported

    }




    @Test
    public void verify_Login_Is_Working_With_Valid_StandardCredentials() {


        //Step 3- Enter username
        String userNameTextFieldId = "user-name";
        driver.findElement(By.id(userNameTextFieldId)).sendKeys("standard_user");

        //Step 4- Enter password
        String passwordTextFieldId = "password";
        driver.findElement(By.id(passwordTextFieldId)).sendKeys("secret_sauce");

        //Step 5- click login button
        String loginButtonId = "login-button";
        driver.findElement(By.id(loginButtonId)).click();

        //Assert / validation
        String productHeaderTitleText = "#header_container > div.header_secondary_container > span";
        String productHeaderTitleActualValue = driver.findElement(By.cssSelector(productHeaderTitleText)).getText();
        String productHeaderTitleExpectedValue = "PRODUCTS";
        Assert.assertEquals(productHeaderTitleActualValue, productHeaderTitleExpectedValue);


    }

    @Test
    public void verifyLoginIsWorkingWithInvalidStandardCredentials() {

        //Step 3- Enter username
        String userNameTextFieldId = "user-name";
        driver.findElement(By.id(userNameTextFieldId)).sendKeys("standard_user1");

        //Step 4- Enter password
        String passwordTextFieldId = "password";
        driver.findElement(By.id(passwordTextFieldId)).sendKeys("secret_sauce");

        //Step 5- click login button
        String loginButtonId = "login-button";
        driver.findElement(By.id(loginButtonId)).click();

        //Validation
        String invalidLoginErrorMessageXpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3";
        String invalidActualLoginErrorMessage = driver.findElement(By.xpath(invalidLoginErrorMessageXpath)).getText();
        String invalidExpectedLoginErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(invalidActualLoginErrorMessage, invalidExpectedLoginErrorMessage);
    }

    @AfterMethod
    public void cleanUp() {
        System.out.println("After Method");
        driver.quit(); // Closes entire browser
//        driver.close(); //Closes the Tab only not the Entire Browser - Not recommended
    }


}
