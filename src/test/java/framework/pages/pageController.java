package framework.pages;

import org.openqa.selenium.WebDriver;

import java.util.Properties;

public abstract class pageController {
    public final String baseURL = "https://demo.nopcommerce.com";
    public final String locFile = "locators";
    protected WebDriver driver;
    protected pageController(WebDriver driver) {
        this.driver = driver;
    }
    protected abstract void open();

    public String getBaseURL() {
        return baseURL;
    }

    Properties pros = new Properties();
}
