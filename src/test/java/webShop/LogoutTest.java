package webShop;

import base.BaseTest;
import org.page.HomePage;
import org.page.LoginPage;
import org.steps.HomePageSteps;
import org.steps.LoginPageSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() {

        LoginPage loginPage = new LoginPage(page);
        LoginPageSteps loginPageSteps = new LoginPageSteps(loginPage);

        HomePage homePage = new HomePage(page);
        HomePageSteps homePageSteps = new HomePageSteps(homePage);

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
