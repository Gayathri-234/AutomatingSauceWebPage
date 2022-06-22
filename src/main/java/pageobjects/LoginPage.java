package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
   private  WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    private By userNameTextFieldId = By.id("user-name");
    private By passwordTextFieldId = By.id("password");
    private By loginButtonId = By.id("login-button");
    private By robotImage=By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[2]");

    public boolean navigateToLoginPage(){
        driver.navigate().to("https://www.saucedemo.com/");
        boolean status = driver.findElement(robotImage).isDisplayed();
        return status;
    }
    public void enterName(String username){

        driver.findElement(userNameTextFieldId).sendKeys(username);
    }
    public void enterPassword(String password){

        driver.findElement(passwordTextFieldId).sendKeys(password);
    }
     public void clickButton(){
        driver.findElement(loginButtonId).click();
}
}
