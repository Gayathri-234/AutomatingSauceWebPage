package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AllItemsMenuBar {
    private WebDriver driver;

    public AllItemsMenuBar(WebDriver driver) {
        this.driver = driver;
    }


    private By allItemsContainerPageList = By.xpath("//*[@class=\"inventory_item_name\"]");

     public List<WebElement> getAllItemsPage() {
       return  driver.findElements(allItemsContainerPageList);

    }
}
