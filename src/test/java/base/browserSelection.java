package base;

import driverselection.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class browserSelection {
    public WebDriver driver;

    @BeforeMethod
    public void LaunchBrowser() {
        DriverManager driverManager = new DriverManager();
        driver=driverManager.getDriver("edge");

        driver.navigate().to("https://www.amazon.com/");

    }
    @AfterMethod
    public void BrowserClose() {
        driver.quit();

    }

}

