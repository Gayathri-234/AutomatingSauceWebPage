package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private WebDriver driver;
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    private By productTitle = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    private By logoImageId = By.xpath("//*[@id=\"header_container\"]/div[2]/div[1]");
    private By sideMenuBar = By.xpath("//*[@id=\"react-burger-menu-btn\"]");
    private By cartButton = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    private By productSortingButton = By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select");
public void  navigate(){
    driver.navigate().to("https://www.saucedemo.com/inventory.html");
}
    public void isPageDisplayed() {
         new WebDriverWait(driver, Duration.ofSeconds(3000))
                .until(ExpectedConditions.visibilityOfElementLocated(productTitle));
    }
    public boolean isLogoImageDisplayed(){
        boolean displayFlag = driver.findElement(logoImageId).isDisplayed();
        return displayFlag;
    }
    public boolean isMenuBarDisplayed(){
        boolean displayFlag=driver.findElement(sideMenuBar).isDisplayed();
        return displayFlag;

    }
    public boolean isCartButtonDisplayed(){
        boolean displayFlag = driver.findElement(cartButton).isDisplayed();
        return displayFlag;
    }
    public boolean isSortContainerBtnDisplayed(){
        boolean displayFlag = driver.findElement(productSortingButton).isDisplayed();
        return displayFlag;
    }
}


