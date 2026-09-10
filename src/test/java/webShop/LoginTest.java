package webShop;

import base.BaseTest;
import org.page.LoginPage;
import org.steps.LoginPageSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLogin() {
        LoginPage loginPage = new LoginPage(page);
        LoginPageSteps loginSteps = new LoginPageSteps(loginPage);

        loginPage.clickLoginButton();

        loginSteps.login("suhoveev07@gmail.com", "Test123@");

        Assert.assertFalse(loginSteps.isLoginErrorDisplayed());
    }

    @Test
    public void verifyInvalidLogin() {
        LoginPage loginPage = new LoginPage(page);
        LoginPageSteps loginSteps = new LoginPageSteps(loginPage);

        loginPage.clickLoginButton();

        loginSteps.login("tesdf@gmail.com", "Test123@");

        Assert.assertTrue(loginSteps.isLoginErrorDisplayed());
    }
}
