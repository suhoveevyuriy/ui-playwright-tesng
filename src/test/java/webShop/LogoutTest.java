package webShop;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() {



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
