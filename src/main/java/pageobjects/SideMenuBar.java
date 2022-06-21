package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SideMenuBar {
    private WebDriver driver;

    public SideMenuBar(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMenuBar() {
        driver.findElement(sideMenuBar).click();
    }
    public void clickMenuBarCloseBtn() {
        driver.findElement(closeButton).click();
    }

    private By menuBarList = By.xpath("//*[@class=\"bm-item menu-item\"]");
    // private By menuBarList = By.tagName("a");

    private By sideMenuBar = By.xpath("//*[@id=\"react-burger-menu-btn\"]");
    private By allItemsPage = By.id("inventory_sidebar_link");
    private By aboutPage = By.id("about_sidebar_link");
    private By logOutPage = By.id("logout_sidebar_link");
    private By resetAppStatePage = By.id("reset_sidebar_link");
    private By closeButton = By.id("react-burger-cross-btn");

    public boolean isAllItemsDisplayed() {
        boolean displayFlag = driver.findElement(allItemsPage).isDisplayed();
        return displayFlag;
    }

    public boolean isAboutPageDisplayed() {
        boolean displayFlag = driver.findElement(aboutPage).isDisplayed();
        return displayFlag;
    }

    public boolean isLogOutDisplayed() {
        boolean displayFlag = driver.findElement(logOutPage).isDisplayed();
        return displayFlag;
    }

    public boolean isResetAppStateDisplayed() {
        boolean displayFlag = driver.findElement(resetAppStatePage).isDisplayed();
        return displayFlag;
    }

    public boolean isCloseBtnDisplayed() {
        boolean displayFlag = driver.findElement(closeButton).isDisplayed();
        return displayFlag;
    }



    public List<WebElement> getMenuItems() {
        return driver.findElements(menuBarList);

    }

}
