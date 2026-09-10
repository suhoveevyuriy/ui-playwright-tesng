package org.steps;

import org.page.LoginPage;

public class LoginPageSteps {

    private final LoginPage loginPage;

    public LoginPageSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public void login(String email, String password) {
        loginPage.clickLoginButton();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmitLogin();
    }

    public boolean isLoginErrorDisplayed() {
        return loginPage.isValidationMessageVisible();
    }
}
