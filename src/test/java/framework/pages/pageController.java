package framework.pages;

import org.openqa.selenium.WebDriver;

import java.util.Properties;

public abstract class pageController {
    public String baseURL = "https://demo.nopcommerce.com";
    protected WebDriver driver;
    protected pageController(WebDriver driver) {
        this.driver = driver;
    }
    protected abstract void open();
    Properties pros = new Properties();
}
