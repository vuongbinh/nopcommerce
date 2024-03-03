package framework.pages;

import com.github.javafaker.Faker;
import framework.objects.customer;
import org.openqa.selenium.WebDriver;

import java.util.Date;

public class register extends pageController {
    Faker faker = new Faker();
    String registerURL = baseURL.concat("/register");


    public register(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(registerURL);
    }
}
