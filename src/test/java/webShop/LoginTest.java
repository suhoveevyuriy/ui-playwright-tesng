package webShop;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.page.BasePage;
import org.steps.LoginPageSteps;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private static final Logger logger =
            LogManager.getLogger(LoginTest.class);

    @Test (dataProvider = "loginUsers")
    public void verifyLogin(String email, String password) {

        logger.info("Login test started");


        loginPage.clickLoginButton();

        loginPageSteps.login(email,password);

        Assert.assertFalse( loginPageSteps.isLoginErrorDisplayed());
    }

    @Test
    public void verifyInvalidLogin() throws InterruptedException {

        logger.info("Invalid login test started");


        LoginPageSteps loginSteps = new LoginPageSteps(loginPage);

        loginPage.clickLoginButton();

        loginSteps.login("tesdf@gmail.com", "Test123@");

        Assert.assertTrue(loginPage.isValidationMessageVisible());
        logger.info("Invalid login finished");
    }

    @DataProvider
    public Object[][] loginUsers() {
        return new Object[][]{
                {"suho43434@gmail.com", "Test123@"},
                {"suhoy07@gmail.com", "Test123@"}
        };
    }
}
