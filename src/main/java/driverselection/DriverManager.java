package driverselection;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private WebDriver driver;

    public WebDriver getDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.out.println("==ChromeBrowser Created==");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("edge")) {
            System.out.println("==SafariBrowser Created==");
            WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
        }
        else {
            System.out.println("==FireFox==");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }
}
