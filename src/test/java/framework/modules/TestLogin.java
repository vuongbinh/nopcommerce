package framework.modules;

import framework.pages.loginPage;
import jdk.jfr.DataAmount;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestLogin extends TestController {
    @Test(testName = "Verify that customer can access the login page by direct URL")
    void verifyLoginPageisDisplayed() {
        loginPage page = new loginPage(driver);
        pros = spPros.load(locFile);
        page.open();
        Assert.assertTrue(driver.getCurrentUrl().contains(pros.getProperty("url_loginPage")));
    }
    @DataProvider
    Object[][] isRemember(){
        return new Object[][]{
                new Object[]{true},
                new Object[]{false}
        };
    }
    @Test(testName = "Verify that customer can login with valid account",dataProvider = "isRemember")
    void verfiyLoginSuccess(Boolean isRememberMe){
        pros = spPros.load(locFile);
        loginPage page = new loginPage(driver);
        page.open();
        page.login(isRememberMe);
        Assert.assertTrue(driver.findElement(By.xpath(pros.getProperty("xpath_lnkLogout"))).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(pros.getProperty("xpath_lnkMyAccount"))).isDisplayed());
    }
    @DataProvider
    Object[][] invalid_Credential(){
        return new Object[][]{
                new Object[]{"invalid_email@example.com","Test!123",true},
                new Object[]{"louis.christiansen@example.com","invalid_pass",false}
        };
    }
    @Test(testName = "Verify that customer can NOT login with invalid account",dataProvider = "invalid_Credential")
    void verfiyLoginFailed(String usr, String pwd, boolean isRememberMe){
        pros = spPros.load(locFile);
        loginPage page = new loginPage(driver);
        page.open();
        page.login(usr,pwd,isRememberMe);
        Assert.assertTrue(driver.findElement(By.xpath(pros.getProperty("xpath_loginErrMsg"))).isDisplayed());
        Assert.assertTrue(driver.getCurrentUrl().contains(pros.getProperty("url_loginPage")));
    }
}
