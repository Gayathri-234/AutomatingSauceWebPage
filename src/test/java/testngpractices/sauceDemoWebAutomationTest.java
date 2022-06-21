package testngpractices;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.ProductPage;
import pageobjects.SideMenuBar;

import java.util.List;

public class sauceDemoWebAutomationTest extends BaseTest {

    @Test

    public void verifyLoginIsWorkingWithValidStandardCredentials() {
        LoginPage loginPageTest = new LoginPage(driver);
        boolean navigationStatus = loginPageTest.navigateToLoginPage();
        Assert.assertTrue(navigationStatus);
        loginPageTest.enterName("standard_user");
        loginPageTest.enterPassword("secret_sauce");
        loginPageTest.clickButton();
        //Validating ProductPage
        ProductPage productPageTest = new ProductPage(driver);
        boolean ProductPageStatus = productPageTest.isPageDisplayed();
        Assert.assertTrue(ProductPageStatus);
        //Validating LogoImage
        boolean LogoImageStatus = productPageTest.isLogoImageDisplayed();
        Assert.assertTrue(LogoImageStatus);
        //Validating MenuBar
        boolean MenuBarStatus = productPageTest.isMenuBarDisplayed();
        Assert.assertTrue(MenuBarStatus);
        //Validating CartButton
        boolean CartBtnStatus = productPageTest.isCartButtonDisplayed();
        Assert.assertTrue(CartBtnStatus);
        boolean SortContainerButtonStatus = productPageTest.isCartButtonDisplayed();
        Assert.assertTrue(SortContainerButtonStatus);
    }

    @Test
    //Validating SideMenuBar options
    public void verifyMenuItemsAreCorrectlyDisplayedInTheMenuBar() {
        // Step 1: Login
        LoginPage loginPageTest = new LoginPage(driver);
        boolean navigationStatus = loginPageTest.navigateToLoginPage();
        Assert.assertTrue(navigationStatus);
        loginPageTest.enterName("standard_user");
        loginPageTest.enterPassword("secret_sauce");
        loginPageTest.clickButton();
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
        LoginPage loginPageTest = new LoginPage(driver);
        boolean navigationStatus = loginPageTest.navigateToLoginPage();
        Assert.assertTrue(navigationStatus);
        loginPageTest.enterName("standard_user");
        loginPageTest.enterPassword("secret_sauce");
        loginPageTest.clickButton();
        //2.Click SideMenuBar
        SideMenuBar menuBarPage = new SideMenuBar(driver);
        menuBarPage.clickMenuBar();
        Thread.sleep(1000);
        //3.Click cross button to close the menu bar
        menuBarPage.clickMenuBarCloseBtn();

    }
    @AfterMethod

    public void cleanUp() {

        System.out.println("After Method");
        driver.quit(); // Closes entire browser
//        driver.close(); //Closes the Tab only not the Entire Browser - Not recommended


     }
    }