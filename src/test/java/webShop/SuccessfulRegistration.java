package webShop;

import base.BaseTest;
import org.steps.RegisterPageSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuccessfulRegistration extends BaseTest {

    private RegisterPageSteps registerPageSteps;

    @Test
    public void verifyRegistration() {

        page.navigate("https://demowebshop.tricentis.com/register");

        String email = "test" + System.currentTimeMillis() + "@gmail.com";

        registerPageSteps.registerMaleUser(
                "Yurii",
                "Testovich",
                email,
                "Test123@"
        );

        String actualResult = page.locator(".result").textContent();

        Assert.assertEquals(
                actualResult,
                "Your registration completed"
        );
    }
}