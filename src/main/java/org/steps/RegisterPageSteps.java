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
        registerPage
                .selectMaleGender()
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .enterEmail(email)
                .enterPassword(password)
                .enterConfirmPassword(password)
                .clickRegisterButton();
    }

}
