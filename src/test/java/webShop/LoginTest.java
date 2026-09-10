package webShop;

import base.BaseTest;
import org.page.LoginPage;
import org.steps.LoginPageSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLogin() {
        page.navigate("https://demowebshop.tricentis.com/");
        LoginPage loginPage = new LoginPage(page);
        LoginPageSteps loginSteps = new LoginPageSteps(loginPage);

        loginSteps.login("suhoveev07@gmail.com", "Test123@");

        Assert.assertTrue(page.locator(".ico-logout").isVisible());
    }

    @Test
    public void verifyInvalidLogin() {
        page.navigate("https://demowebshop.tricentis.com/");
        LoginPage loginPage = new LoginPage(page);
        LoginPageSteps loginSteps = new LoginPageSteps(loginPage);

        loginSteps.login("wrong@gmail.com", "wrongPassword");

        Assert.assertTrue(loginSteps.isLoginErrorDisplayed());
    }
}
