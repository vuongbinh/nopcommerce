package framework.pages;

import framework.objects.customer;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Random;

public class register extends pageController {
    String registerURL = baseURL.concat("/register");
    {
        try {
            InputStream input = new FileInputStream("src/test/java/framework/supporter/resources/locators.properties");
            pros.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public register(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(registerURL);
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
    public void open(String url) {
        driver.get(url);
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void fillFormRandom() {
        customer cus = new customer();

        By selGenderMale = By.id(pros.getProperty("id_selGenderMale"));
        By selGenderFemale = By.id(pros.getProperty("id_selGenderFemale"));
        By tbxFirstname = By.id(pros.getProperty("id_tbxFirstname"));
        By tbxLastname = By.id(pros.getProperty("id_tbxLastname"));
        By drdDOB = By.name(pros.getProperty("name_drdDOB"));
        By drdMOB = By.name(pros.getProperty("name_drdMOB"));
        By drdYOB = By.name(pros.getProperty("name_drdYOB"));
        By tbxCompany = By.id(pros.getProperty("id_tbxCompanyname"));
        By tbxEmail = By.id(pros.getProperty("id_tbxEmail"));
        By cbxNewlestter = By.id(pros.getProperty("id_cbxNewsletter"));
        By tbxPassword = By.id(pros.getProperty("id_tbxPassword"));
        By tbxConfirmpassword = By.id(pros.getProperty("id_tbxConfirmpassword"));

        Random rand = new Random();
        boolean isMale = rand.nextBoolean();
        if (isMale) {
            driver.findElement(selGenderMale).click();
        } else {
            driver.findElement(selGenderFemale).click();
        }
        driver.findElement(tbxFirstname).sendKeys(cus.getFirstName());
        driver.findElement(tbxLastname).sendKeys(cus.getLastName());

        String[] date = cus.getDOB().split("-");
        driver.findElement(drdDOB).sendKeys(date[1]);
        driver.findElement(drdMOB).sendKeys(date[0]);
        driver.findElement(drdYOB).sendKeys(date[2]);

        driver.findElement(tbxEmail).sendKeys(cus.getEmail());
        driver.findElement(tbxCompany).sendKeys(cus.getCompanyName());

        if (!driver.findElement(cbxNewlestter).isSelected()) {
            driver.findElement(cbxNewlestter).click();
        }

        driver.findElement(tbxPassword).sendKeys(cus.getPassword());
        driver.findElement(tbxConfirmpassword).sendKeys(cus.getPassword());
    }

    public void submitForm() {
        By btnRegister = By.id(pros.getProperty("id_btnRegister"));
        driver.findElement(btnRegister).click();
    }
}
