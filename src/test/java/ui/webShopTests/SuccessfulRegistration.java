package ui.webShopTests;

import ui.baseUI.UiBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import net.datafaker.Faker;

import java.util.Locale;

public class SuccessfulRegistration extends UiBaseTest {

    private static final Logger logger =
            LogManager.getLogger(SuccessfulRegistration.class);

    private final Faker faker = new Faker(Locale.ENGLISH);

    @Test(groups = "ui")
    public void verifyRegistration() {
        logger.info("Successful registration test started");
        page.navigate("https://demowebshop.tricentis.com/register");
        registerPage.clickRegisterButton();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        registerPageBO.registerMaleUser(
                firstName,
                lastName,
                email,
                "Test123@"
        );
        String actualResult = page.locator(".result").textContent().trim();
        Assert.assertEquals(
                actualResult,
                "Your registration completed"
        );
        logger.info("Successful registration test finished");
    }
}