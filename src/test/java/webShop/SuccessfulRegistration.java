package webShop;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.steps.RegisterPageSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuccessfulRegistration extends BaseTest {

    private static final Logger logger =
            LogManager.getLogger(SuccessfulRegistration.class);

    @Test
    public void verifyRegistration() {

        page.navigate("https://demowebshop.tricentis.com/register");

        registerPage.clickRegisterButton();
        RegisterPageSteps registerPageSteps =new RegisterPageSteps(registerPage);

        String email = "test" + System.currentTimeMillis() + "@gmail.com";

        registerPageSteps.registerMaleUser(
                "Yurii",
                "Testovich",
                email,
                "Test123@"
        );

        String actualResult = page.locator(".result").textContent().trim();

        Assert.assertEquals(
                actualResult,
                "Your registration completed"
        );
    }
}