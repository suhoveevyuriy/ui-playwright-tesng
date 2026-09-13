package webShop;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.page.LoginPage;
import org.steps.LoginPageSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private static final Logger logger =
            LogManager.getLogger(LoginTest.class);

    @Test
    public void verifyLogin() {

        logger.info("Login test started");

        LoginPageSteps loginSteps = new LoginPageSteps(loginPage);

        loginPage.clickLoginButton();

        loginSteps.login("suhoveev07@gmail.com", "Test123@");

        Assert.assertFalse(loginSteps.isLoginErrorDisplayed());
    }

    @Test
    public void verifyInvalidLogin() throws InterruptedException {

        logger.info("Invalid login test started");


        LoginPageSteps loginSteps = new LoginPageSteps(loginPage);

        loginPage.clickLoginButton();

        loginSteps.login("tesdf@gmail.com", "Test123@");

        Assert.assertTrue(loginPage.isValidationMessageVisible());
    }
}
