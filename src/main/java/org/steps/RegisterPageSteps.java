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

////// треба розібратись так як в RegisterPage вказав return this але не можу вказувати методи просто через крапку
        registerPage.selectMaleGender();
        registerPage.enterFirstName(firstName);
        registerPage.enterLastName(lastName);
        registerPage.enterEmail(email);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
        registerPage.clickRegisterButton();
    }

}
