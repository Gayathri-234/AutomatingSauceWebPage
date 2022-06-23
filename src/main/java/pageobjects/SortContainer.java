package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SortContainer {
    private WebDriver driver;

    public SortContainer(WebDriver driver) {
        this.driver = driver;
    }

    private By sortContainerBtn = By.xpath("//*[@data-test=\"product_sort_container\"]");
    private By sortingValueList =By.xpath("//select[@class='product_sort_container']//option");
    public void clickingSortContainerBtnClickable() {
        driver.findElement(sortContainerBtn).click();
   }
    public List<WebElement> getSortingValueList(){
    return driver.findElements(sortingValueList);

    }
}
