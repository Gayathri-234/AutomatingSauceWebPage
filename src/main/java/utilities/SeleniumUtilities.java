package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;


public class SeleniumUtilities {
    private SeleniumUtilities() {

    }

    public static void takeScreenShot(WebDriver driver) throws IOException {
        Timestamp timestamp = Timestamp.from(Instant.now());

        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File("./screenshot/" + timestamp.getNanos() + ".png");
        FileUtils.copyFile(SrcFile, DestFile);
    }

    public static void setLoginCookies(WebDriver driver,String cookieName,String cookieValue) {

         driver.manage().addCookie(new Cookie(cookieName,cookieValue));
         driver.navigate().refresh();


    }
}

