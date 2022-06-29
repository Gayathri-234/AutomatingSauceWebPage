package testngpractices;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;
import utilities.SeleniumUtilities;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SauceDemoWebAutomationTest extends BaseTest {

    @Test

    public void verifyLoginIsWorkingWithValidStandardCredentials()  {
        //Step 1: Login
       LoginPage loginPage = new LoginPage(driver);
        boolean navigationStatus = loginPage.navigateToLoginPage();
        //Step 2: Getting the Credentials in Cookies.data file
        SeleniumUtilities.setLoginCookies(driver,"session-username","standard_user");
        //Validating ProductPage
        ProductPage productPage = new ProductPage(driver);
        productPage.navigate();
        productPage.isPageDisplayed();
        //Validating LogoImage
        boolean LogoImageStatus = productPage.isLogoImageDisplayed();
        Assert.assertTrue(LogoImageStatus);
        //Validating MenuBar
        boolean MenuBarStatus = productPage.isMenuBarDisplayed();
        Assert.assertTrue(MenuBarStatus);
        //Validating CartButton
        boolean CartBtnStatus = productPage.isCartButtonDisplayed();
        Assert.assertTrue(CartBtnStatus);
        boolean SortContainerButtonStatus = productPage.isCartButtonDisplayed();
        Assert.assertTrue(SortContainerButtonStatus);
    }

    @Test
    //Validating SideMenuBar options
    public void verifyMenuItemsAreCorrectlyDisplayedInTheMenuBar() {
        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        boolean navigationStatus = loginPage.navigateToLoginPage();
        Assert.assertTrue(navigationStatus);
        SeleniumUtilities.setLoginCookies(driver,"session-username","standard_user");
        ProductPage productPage = new ProductPage(driver);
        productPage.navigate();
        //Step 2: CLick on menuBar
        SideMenuBar menuBarPage = new SideMenuBar(driver);
        menuBarPage.clickMenuBar();
        List<WebElement> menuItems = menuBarPage.getMenuItems();
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(menuItems.get(i).getAttribute("id"));
        }
        //Step 3:verify the 4 items in menubar
        System.out.println("No.of.Items in MenuBar:" + menuItems.size());
        System.out.println(menuItems.size());
        Assert.assertEquals(menuItems.size(), 4);

    }

    //Step 4:Verify the cross_btn
    @Test
    public void verifyCrossButtonClosesMenuBar() throws InterruptedException {
        //1.Login Browser
        LoginPage loginPage = new LoginPage(driver);
        boolean navigationStatus = loginPage.navigateToLoginPage();
        Assert.assertTrue(navigationStatus);
        SeleniumUtilities.setLoginCookies(driver,"session-username","standard_user");
        ProductPage productPage = new ProductPage(driver);
        productPage.navigate();
        //2.Click SideMenuBar
        SideMenuBar menuBarPage = new SideMenuBar(driver);
        menuBarPage.clickMenuBar();
        Thread.sleep(2000);
        //3.Click cross button to close the menu bar
        menuBarPage.clickMenuBarCloseBtn();

    }
    @Test
    public void verifyAllItemsMenuBarListPage() throws InterruptedException {
        //1.Login Browser
        LoginPage loginPage = new LoginPage(driver);
        boolean navigationStatus = loginPage.navigateToLoginPage();
        Assert.assertTrue(navigationStatus);
        SeleniumUtilities.setLoginCookies(driver,"session-username","standard_user");
        ProductPage productPage = new ProductPage(driver);
        productPage.navigate();
        //2.Click SideMenuBar
        SideMenuBar menuBarPage = new SideMenuBar(driver);
        menuBarPage.clickMenuBar();
        Thread.sleep(2000);
        menuBarPage.clickAllItemsFromMenu();
        menuBarPage.clickMenuBarCloseBtn();
        AllItemsMenuBar allItemsMenuBar = new AllItemsMenuBar(driver);
        //Validating AllItems Page
        List<WebElement> allItemsPageList = allItemsMenuBar.getAllItemsPage();
        System.out.println("No.Of.Item in the Page:" + allItemsPageList.size());
        for (int i = 0; i < allItemsPageList.size(); i++) {
            System.out.println(allItemsPageList.get(i).getText());
        }
    }

    @Test
    public void verifyCorrectSortingValuesArePresent() throws IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000)); //TimeUnit format will be deprecated

        //Step:1 Login
        LoginPage loginPage = new LoginPage(driver);
        boolean navigationStatus = loginPage.navigateToLoginPage();
        Assert.assertTrue(navigationStatus);
        SeleniumUtilities.setLoginCookies(driver,"session-username","standard_user");
        ProductPage productPage = new ProductPage(driver);
        productPage.navigate();
        SeleniumUtilities.takeScreenShot(driver);
        SortContainer sortContainer = new SortContainer(driver);

        //Step 2: Validating SortContainer List
        List<WebElement> actualSortContainerList = sortContainer.getSortingValueList();
        System.out.println("No of Elements in Sort Container:" + actualSortContainerList.size());

        List<String> expectedSortingValueList = Arrays.asList("Name (A to Z)", "Name (Z to A)", "Price (low to high)", "Price (high to low)");
        System.out.println(expectedSortingValueList);

        for (int i=0;i<expectedSortingValueList.size();i++) {
            String actualSortValue = actualSortContainerList.get(i).getText();
            System.out.println("Elements in the SortContainer:" + actualSortValue);
            Assert.assertEquals(actualSortValue,expectedSortingValueList.get(i));
        }


    }


}

