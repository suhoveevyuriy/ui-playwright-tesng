package ui.webShopTests;

import ui.baseUI.UiBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends UiBaseTest {

    private static final Logger logger =
            LogManager.getLogger(LoginTest.class);

    @Test(dataProvider = "loginUsers")
    public void verifyLogin(String email, String password) {
        logger.info("Success Login test started");
        loginPage.clickLoginButton();
        loginPageBO.login(email, password);
        loginPageBO.verifySuccessfulLogin();
    }

    @Test
    public void verifyInvalidLogin() throws InterruptedException {

        logger.info("Invalid login test started");
        loginPage.clickLoginButton();
        loginPageBO.login("yuriy1823@gmail.com", "Test123@");
        loginPageBO.verifyInvalidLogin();
        logger.info("Invalid login finished");
    }

    @DataProvider
    public Object[][] loginUsers() {
        return new Object[][]{
                {"suhoveev044@gmail.com", "Test123@"},
                {"suhoy07@gmail.com", "Test123@"}
        };
    }

}
