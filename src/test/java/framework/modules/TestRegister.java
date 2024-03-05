package framework.modules;

import framework.pages.register;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestRegister extends TestController {
    {
        try {
            InputStream input = new FileInputStream("src/test/java/framework/supporter/resources/locators.properties");
            pros.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
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
    void gotoRegisterPage(){
        register regPage = new register(driver);
        regPage.open(regPage.getBaseURL());
    }
}
