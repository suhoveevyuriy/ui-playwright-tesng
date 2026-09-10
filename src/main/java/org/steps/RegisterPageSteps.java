package org.steps;

import org.page.RegisterPage;

public class RegisterPageSteps {

    private final RegisterPage registerPage;

    public RegisterPageSteps(RegisterPage registerPage) {
        this.registerPage = registerPage;
    }

    public void registerMaleUser(
            String firstName,
            String lastName,
            String email,
            String password
    ) {
        registerPage.selectMaleGender();
        registerPage.enterFirstName(firstName);
        registerPage.enterLastName(lastName);
        registerPage.enterEmail(email);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
        registerPage.clickRegisterButton();
    }

    public void registerFemaleUser(
            String firstName,
            String lastName,
            String email,
            String password
    ) {
        registerPage.selectFemaleGender();
        registerPage.enterFirstName(firstName);
        registerPage.enterLastName(lastName);
        registerPage.enterEmail(email);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
        registerPage.clickRegisterButton();
    }
}
