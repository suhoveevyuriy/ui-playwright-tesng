package org.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class RegisterPage {
    private Page page;
    private Locator openRegisterPage=page.locator("ico-register");
    private Locator gender=page.locator("gender");
    private Locator firstName=page.locator("FirstName");
    private Locator lastName=page.locator("LastName");
    private Locator email=page.locator("Email");
    private Locator registerPassword=page.locator("Password");
    private Locator confirmPassword=page.locator("ConfirmPassword");
    private Locator confirmRegisterButton = page.locator("Register");


    public RegisterPage(Page page) {
        this.page = page;


    }
}