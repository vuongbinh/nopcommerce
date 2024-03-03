package framework.pages;

import org.openqa.selenium.WebDriver;

public class login extends pageController{
    String loginURL = baseURL.concat("/login");
    public login(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(loginURL);
    }
}
