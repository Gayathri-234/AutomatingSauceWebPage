package testngpractices;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class sauceDemoWebAutomationTest extends BaseTest {

    @Test

    public void verifyLoginIsWorkingWithValidStandardCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        boolean navigationStatus = loginPage.navigateToLoginPage();
        Assert.assertTrue(navigationStatus);

        loginPage.enterName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickButton();

        //Validating ProductPage
        ProductPage productPage = new ProductPage(driver);
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
        loginPage.enterName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickButton();
        //Step 2: CLick on menuBar
        SideMenuBar menuBarPage = new SideMenuBar(driver);
        menuBarPage.clickMenuBar();
        //Step 3:verify the 4 items in menubar
        List<WebElement> menuItems = menuBarPage.getMenuItems();
        System.out.println("No.of.Items in MenuBar:" + menuItems.size());
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(menuItems.get(i).getAttribute("id"));
        }
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
        loginPage.enterName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickButton();
        //2.Click SideMenuBar
        SideMenuBar menuBarPage = new SideMenuBar(driver);
        menuBarPage.clickMenuBar();
        Thread.sleep(1000);
        //3.Click cross button to close the menu bar
        menuBarPage.clickMenuBarCloseBtn();

    }

    @Test
    public void verifyAllItemsMenuBarListPage() throws InterruptedException {
        //1.Login Browser
        LoginPage loginPage = new LoginPage(driver);
        boolean navigationStatus = loginPage.navigateToLoginPage();
        Assert.assertTrue(navigationStatus);
        loginPage.enterName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickButton();
        //2.Click SideMenuBar
        SideMenuBar menuBarPage = new SideMenuBar(driver);
        menuBarPage.clickMenuBar();
        Thread.sleep(1000);
        menuBarPage.clickAllItemsFromMenu();
        Thread.sleep(1000);
        menuBarPage.clickMenuBarCloseBtn();
        Thread.sleep(1000);

        AllItemsMenuBar allItemsMenuBar = new AllItemsMenuBar(driver);
        //Validating AllItems Page
        List<WebElement> allItemsPageList = allItemsMenuBar.getAllItemsPage();
        System.out.println("No.Of.Item in the Page:" + allItemsPageList.size());
        for (int i = 0; i < allItemsPageList.size(); i++) {
            System.out.println(allItemsPageList.get(i).getText());
        }
    }

    @Test
    public void verifyCorrectSortingValuesArePresent()  {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000)); //TimeUnit format will be deprecated

        //Step:1 Login
        LoginPage loginPage = new LoginPage(driver);
        boolean navigationStatus = loginPage.navigateToLoginPage();
        Assert.assertTrue(navigationStatus);
        loginPage.enterName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickButton();



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

