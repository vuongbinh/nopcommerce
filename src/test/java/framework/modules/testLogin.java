package framework.modules;

import framework.pages.login;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class testLogin extends testController {
    @Test
    void verifyLoginPage() {
        login loginPage = new login(driver);
        loginPage.open();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
}
