package framework.pages;

import org.openqa.selenium.WebDriver;

public abstract class pageController {
    String baseURL = "https://demo.nopcommerce.com";
    protected WebDriver driver;
    protected pageController(WebDriver driver) {
        this.driver = driver;
    }
    protected abstract void open();
}
