package ui.bo;

import io.qameta.allure.Step;
import ui.page.LoginPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPageBO {

    private final LoginPage loginPage;

    public LoginPageBO(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @Step("Check that user can login")
    public void login(String email, String password) {
        loginPage
                .enterEmail(email)
                .enterPassword(password)
                .clickSubmitLogin();
    }

    @Step("Verify successful login")
    public void verifySuccessfulLogin() {
        assertThat(loginPage.getValidationMessage()).not().isVisible();
    }

    @Step("Verify invalid login")
    public void verifyInvalidLogin() {
        assertThat(loginPage.getValidationMessage()).isVisible();
    }
}
