package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AllItemsMenuBar {
    private WebDriver driver;

    public AllItemsMenuBar(WebDriver driver) {
        this.driver = driver;
    }


    private By allItemsContainerPageList = By.xpath("//*[@class=\"inventory_item_name\"]");

    String xpath ="//ssasassss";

    //Page Factory
    @FindBy(xpath = "//dfdfdfdfdf") WebElement loginBtn;

      public List<WebElement> getAllItemsPage() {
        loginBtn.click();

       return  driver.findElements(allItemsContainerPageList);

    }
}
