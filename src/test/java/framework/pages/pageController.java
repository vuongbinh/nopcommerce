package framework.pages;

import framework.supporter.SupportProperty;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public abstract class pageController {
    public final String locFile = "locators";
    public final String userFile = "userAccounts";
    protected WebDriver driver;
    Properties pros = new Properties();
    public SupportProperty spPros = new SupportProperty();

    protected pageController(WebDriver driver) {
        this.driver = driver;
    }

    protected abstract void open();
}
