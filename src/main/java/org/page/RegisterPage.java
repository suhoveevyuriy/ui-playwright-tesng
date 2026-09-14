package org.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class RegisterPage extends BasePage {


    private final Locator registerLink;
    private final Locator maleRadioButton;
    private final Locator femaleRadioButton;
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
        femaleRadioButton = page.locator("#gender-female");

        firstNameInput = page.locator("#FirstName");
        lastNameInput = page.locator("#LastName");
        emailInput = page.locator("#Email");

        passwordInput = page.locator("#Password");
        confirmPasswordInput = page.locator("#ConfirmPassword");

        registerButton = page.locator("#register-button");

    }

    public void selectMaleGender() {
        maleRadioButton.check();
    }

    public void enterFirstName(String firstName) {
        firstNameInput.fill(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.fill(lastName);
    }

    public void enterEmail(String email) {
        emailInput.fill(email);
    }

    public void enterPassword(String password) {
        passwordInput.fill(password);
    }

    public void enterConfirmPassword(String password) {
        confirmPasswordInput.fill(password);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }
}