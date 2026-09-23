package ui.webShopTests;

import ui.baseUI.UiBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends UiBaseTest {

    private static final Logger logger =
            LogManager.getLogger(LoginTest.class);

    @Test(dataProvider = "loginUsers")
    public void verifyLogin(String email, String password) {
        logger.info("Success Login test started");
        loginPage.clickLoginButton();
        loginPageFacade.login(email, password);
        loginPageFacade.verifySuccessfulLogin();
    }

    @Test (groups= "ui")
    public void verifyInvalidLogin() throws InterruptedException {

        logger.info("Invalid login test started");
        loginPage.clickLoginButton();
        loginPageFacade.login("yuriy123@gmail.com", "Test123@");
        loginPageFacade.verifyInvalidLogin();
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
