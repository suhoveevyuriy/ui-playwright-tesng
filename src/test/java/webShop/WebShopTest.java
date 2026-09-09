package webShop;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebShopTest extends BaseTest {

    private static final String EMAIL = "your_existing_email@gmail.com";
    private static final String PASSWORD = "Test123!";

    @Test
    public void verifySuccessfulRegistration() {

        String uniqueEmail =
                "user" + System.currentTimeMillis() + "@gmail.com";

        homePageSteps.goToRegisterPage();

        registerPageSteps.registerMaleUser(
                "Yuriy",
                "Test",
                uniqueEmail,
                PASSWORD
        );

        Assert.assertTrue(
                registerPageSteps.isRegistrationSuccessful()
        );
    }

    @Test
    public void verifyLogin() {

        homePageSteps.goToLoginPage();

        loginPageSteps.login(
                EMAIL,
                PASSWORD
        );

        Assert.assertTrue(
                homePageSteps.isUserLoggedIn(EMAIL)
        );
    }

    @Test
    public void verifyLogout() {

        homePageSteps.goToLoginPage();

        loginPageSteps.login(
                EMAIL,
                PASSWORD
        );

        homePageSteps.logout();

        Assert.assertTrue(
                homePageSteps.isUserLoggedOut()
        );
    }

    @Test
    public void verifyInvalidLogin() {

        homePageSteps.goToLoginPage();

        loginPageSteps.login(
                "wrong@gmail.com",
                "wrongPassword"
        );

        Assert.assertTrue(
                loginPageSteps.isLoginErrorDisplayed()
        );
    }

    @Test
    public void verifySearchProduct() {

        homePageSteps.searchProduct("Camcorder");

        Assert.assertTrue(
                homePageSteps.isProductFound("Camcorder")
        );
    }
}
