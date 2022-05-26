package testngpractices;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgBasics {
    String url;
    //public static void main(String[] args) {
    @BeforeClass
    public void beforeClass(){
        System.out.println("--Before Class");
        url= "https://www.saucedemo.com/";
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("--Before Method");
        System.out.println("open Browser");
        System.out.println("Navigate to Url:"+ url);

    }

    @Test
    public static void verify_Login_With_Valid_Credentials() {
        System.out.println("--Test Method");
        System.out.println("Enter the Username:");
        System.out.println("Enter the Password:");
        System.out.println("Click Login");
    }
    @Test
    public static void verify_Login_With_InValid_Credentials() {
        System.out.println("--Test Method1");
        System.out.println("Enter the Username:");
        System.out.println("Enter the Password:");
        System.out.println("Click Login");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("--After Method");
        System.out.println("Close the Browser");
    }
}

