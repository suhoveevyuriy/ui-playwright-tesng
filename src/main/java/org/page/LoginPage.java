package org.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;
    private Locator loginButton;
    private Locator emailInput;
    private Locator passwordInput;

    public LoginPage(Page page) {
        this.page = page;

        loginButton =page.locator("ico-login");
        emailInput=page.locator("Email");
        passwordInput=page.locator("password");


        private void successLogin () {
            loginButton.click();
            emailInput.fill("suhoveev07@gmail.com");
            passwordInput.fill("Test123");
        }
    }


}