package ui.webShopTests;

import ui.baseUI.UiBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends UiBaseTest {
    private static final Logger logger =
            LogManager.getLogger(LogoutTest.class);

    @Test(groups = "ui")
    public void logoutTest() {
        logger.info("Logout test started");
        loginPageFacade.login(
                "suhoveev07@gmail.com",
                "Test123@"
        );
        homePageFacade.logout();
        Assert.assertTrue(
                page.locator(".ico-login").isVisible()
        );
        logger.info("Logout test finished");
    }
}
