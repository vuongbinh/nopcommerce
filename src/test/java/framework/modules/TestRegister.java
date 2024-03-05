package framework.modules;

import framework.pages.registerPage;
import framework.supporter.SupportProperty;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRegister extends TestController {
    SupportProperty spPros = new SupportProperty();

    @Test(testName = "Verify customer is able to create a new account")
    void verifyfuncRegister() {
        registerPage registerPage = new registerPage(driver);
        registerPage.open();
        Assert.assertTrue(driver.getCurrentUrl().contains(pros.getProperty("url_RegisterPage")));
        registerPage.fillFormRandom();
        registerPage.submitForm();
        Assert.assertEquals(driver.findElement(By.className("result")).getText(), "Your registration completed");
        Assert.assertTrue(driver.findElement(By.xpath(pros.getProperty("xpath_btnContinue"))).isDisplayed());
    }

    @Test(testName = "Verify that customer can go to Register from Home page")
    void homeToRegister() {
        pros = spPros.load(locFile);
        registerPage regPage = new registerPage(driver);
        regPage.open(pros.getProperty("url_homePage"));
        driver.findElement(By.xpath(pros.getProperty("xpath_lnkRegister"))).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(pros.getProperty("url_RegisterPage")));
    }

    @Test(testName = "Verify that customer can go to Register from Login page")
    void loginToRegister() {
        pros = spPros.load(locFile);
        registerPage regPage = new registerPage(driver);
        regPage.open(pros.getProperty("url_loginPage"));
        driver.findElement(By.xpath(pros.getProperty("xpath_btnRegister"))).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(pros.getProperty("url_RegisterPage")));
    }
}
