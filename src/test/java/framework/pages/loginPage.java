package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginPage extends pageController {
    public loginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        pros = spPros.load(locFile);
        driver.get(pros.getProperty("url_loginPage"));
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    private void createAccount() {
        registerPage reg = new registerPage(driver);
        reg.open();
        reg.fillFormRandom();
        reg.submitForm();
    }

    public void login(boolean isRememberMe) {
        pros = spPros.load(userFile);
        fillForm(pros.getProperty("email"), pros.getProperty("password"), isRememberMe);
        submitForm();
    }

    public void login(String usr, String pwd, boolean isRememberMe) {
        pros = spPros.load(userFile);
        fillForm(usr, pwd, isRememberMe);
        submitForm();
    }

    public void fillForm(String usr, String pwd, boolean isRemember) {
        pros = spPros.load(locFile);
        driver.findElement(By.id(pros.getProperty("id_tbxEmail"))).sendKeys(usr);
        driver.findElement(By.id(pros.getProperty("id_tbxPassword"))).sendKeys(pwd);
        if ((isRemember && !driver.findElement(By.id(pros.getProperty("id_cBoxRememberMe"))).isSelected())
                || (!isRemember && driver.findElement(By.id(pros.getProperty("id_cBoxRememberMe"))).isSelected())) {
            driver.findElement(By.id(pros.getProperty("id_cBoxRememberMe"))).click();
        }
    }

    public void submitForm() {
        pros = spPros.load(locFile);
        driver.findElement(By.xpath(pros.getProperty("xpath_btnLogin"))).click();
    }
}
