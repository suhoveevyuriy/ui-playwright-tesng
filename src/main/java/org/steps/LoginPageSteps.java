package org.steps;

import io.qameta.allure.Step;
import org.page.LoginPage;

public class LoginPageSteps {

    private final LoginPage loginPage;

    public LoginPageSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }
    @Step("Check that user can login")
    public void login(String email, String password) {
        loginPage
                .clickLoginButton()
                .enterEmail(email)
                .enterPassword(password)
                .clickSubmitLogin();
    }
    public boolean isLoginErrorDisplayed() {
        return loginPage.isValidationMessageVisible();
    }
}
