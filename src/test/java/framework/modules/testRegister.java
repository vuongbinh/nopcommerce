package framework.modules;

import framework.pages.register;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class testRegister extends testController{
    {
        try {
            InputStream input = new FileInputStream("src/test/java/framework/supporter/resources/locators.properties");
            pros.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void verifyRegisterURL(){
        register registerPage =  new register(driver);
        registerPage.open();
        Assert.assertTrue(driver.getCurrentUrl().contains("/register"));
        registerPage.fillFormRandom();
        registerPage.submitForm();
        Assert.assertEquals(driver.findElement(By.className("result")).getText(),"Your registration completed");
        Assert.assertTrue(driver.findElement(By.xpath(pros.getProperty("xpath_btnContinue"))).isDisplayed());
    }
}
