package org.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {
    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator loginButton;
    private final Locator validationMessage;
    private final Locator submitLogin;

    public LoginPage(Page page) {
       super(page);

        emailInput = page.locator("#Email");
        passwordInput = page.locator("#Password");
        loginButton = page.locator(".ico-login");
        validationMessage = page.locator(".validation-summary-errors");
        submitLogin =page.locator(".login-button");
    }
    public LoginPage enterEmail(String email) {
        emailInput.fill(email);
        return this;
    }
    public LoginPage enterPassword(String password) {
        passwordInput.fill(password);
        return this;
    }
    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }
    public boolean isValidationMessageVisible() {
        return validationMessage.isVisible();
    }
    public LoginPage clickSubmitLogin () {
        submitLogin.click();
        return this;
    }
}