package framework.modules;

import framework.pages.register;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testRegister extends testController{
    @Test
    void verifyRegisterURL(){
        register registerPage =  new register(driver);
        registerPage.open();
        Assert.assertTrue(driver.getCurrentUrl().contains("/register"));
    }
}
