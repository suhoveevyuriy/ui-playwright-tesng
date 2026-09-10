package org.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {

    private final Page page;

    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator loginButton;
    private final Locator validationMessage;
    private final Locator submitLogin;

    public LoginPage(Page page) {
        this.page = page;

        emailInput = page.locator("#Email");
        passwordInput = page.locator("#Password");
        loginButton = page.locator(".ico-login");
        validationMessage = page.locator(".validation-summary-errors");
        submitLogin =page.locator(".login-button");
    }

    public void enterEmail(String email) {
        emailInput.fill(email);
    }

    public void enterPassword(String password) {
        passwordInput.fill(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getValidationMessage() {
        return validationMessage.textContent();
    }

    public boolean isValidationMessageVisible() {
        return validationMessage.isVisible();
    }
    public void clickSubmitLogin () {
        submitLogin.click();
    }
}