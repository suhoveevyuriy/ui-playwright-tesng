package org.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class RegisterPage extends BasePage {


    private final Locator registerLink;
    private final Locator maleRadioButton;
    private final Locator firstNameInput;
    private final Locator lastNameInput;
    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator confirmPasswordInput;
    private final Locator registerButton;

    public RegisterPage(Page page) {
        super(page);

        registerLink = page.locator(".ico-register");

        maleRadioButton = page.locator("#gender-male");

        firstNameInput = page.locator("#FirstName");
        lastNameInput = page.locator("#LastName");
        emailInput = page.locator("#Email");

        passwordInput = page.locator("#Password");
        confirmPasswordInput = page.locator("#ConfirmPassword");

        registerButton = page.locator("#register-button");

    }

    public HomePage selectMaleGender() {
        maleRadioButton.check();
        return this.selectMaleGender();
    }

    public RegisterPage enterFirstName(String firstName) {
        firstNameInput.fill(firstName);
        return this;
    }

    public RegisterPage enterLastName(String lastName) {
        lastNameInput.fill(lastName);
        return this;
    }

    public RegisterPage enterEmail(String email) {
        emailInput.fill(email);
        return this;
    }

    public RegisterPage enterPassword(String password) {
        passwordInput.fill(password);
        return this;
    }

    public RegisterPage enterConfirmPassword(String password) {
        confirmPasswordInput.fill(password);
        return this;
    }

    public RegisterPage clickRegisterButton() {
        registerButton.click();
        return this;
    }
}