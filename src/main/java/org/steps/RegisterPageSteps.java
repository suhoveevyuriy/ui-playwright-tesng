package org.steps;

import io.qameta.allure.Step;
import org.page.RegisterPage;

public class RegisterPageSteps {

    private final RegisterPage registerPage;

    public RegisterPageSteps(RegisterPage registerPage) {
        this.registerPage = registerPage;
    }

    @Step("Check that user can fill needed fields")
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
