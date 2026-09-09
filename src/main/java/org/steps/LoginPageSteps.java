package org.pageSteps;

import org.page.LoginPage;

public class LoginPageSteps {

    private final LoginPage loginPage;

    public LoginPageSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public void login(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    public boolean isLoginErrorDisplayed() {
        return loginPage.isValidationMessageVisible();
    }

    public String getLoginErrorMessage() {
        return loginPage.getValidationMessage();
    }
}
