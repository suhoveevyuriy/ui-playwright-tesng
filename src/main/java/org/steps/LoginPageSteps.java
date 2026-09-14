package org.steps;

import org.page.LoginPage;

public class LoginPageSteps {

    private final LoginPage loginPage;

    public LoginPageSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

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
