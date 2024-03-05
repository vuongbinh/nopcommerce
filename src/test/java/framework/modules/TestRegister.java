package framework.modules;

import framework.pages.register;
import framework.supporter.SupportProperty;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRegister extends TestController {
    SupportProperty spPros = new SupportProperty();
    @Test(testName = "Verify customer is able to create a new account")
    void verifyfuncRegister(){
        register registerPage =  new register(driver);
        registerPage.open();
        Assert.assertTrue(driver.getCurrentUrl().contains("/register"));
        registerPage.fillFormRandom();
        registerPage.submitForm();
        Assert.assertEquals(driver.findElement(By.className("result")).getText(),"Your registration completed");
        Assert.assertTrue(driver.findElement(By.xpath(pros.getProperty("xpath_btnContinue"))).isDisplayed());
    }
    @Test(testName = "Verify that customer can go to Register from Home page")
    void homeToRegister(){
        pros = spPros.load(locFile);
        register regPage = new register(driver);
        regPage.open(regPage.getBaseURL());
        driver.findElement(By.xpath(pros.getProperty("xpath_lnkRegister"))).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/register"));
    }
    @Test(testName = "Verify that customer can go to Register from Login page")
    void loginToRegister(){
        pros = spPros.load(locFile);
        register regPage = new register(driver);
        regPage.open(regPage.getBaseURL()+"/login");
        driver.findElement(By.xpath(pros.getProperty("xpath_btnRegister"))).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/register"));
    }
}
