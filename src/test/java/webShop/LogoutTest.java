package webShop;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    private static final Logger logger =
            LogManager.getLogger(LogoutTest.class);

    @Test
    public void logoutTest() {

        logger.info("Logout test started");

        loginPageSteps.login(
                "suhoveev07@gmail.com",
                "Test123@"
        );

        homePageSteps.logout();

        Assert.assertTrue(
                page.locator(".ico-login").isVisible()
        );
    }
}
