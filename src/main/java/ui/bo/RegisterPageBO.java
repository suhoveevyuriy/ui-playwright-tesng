package ui.bo;

import io.qameta.allure.Step;
import ui.page.RegisterPage;

public class RegisterPageBO {

    private final RegisterPage registerPage;

    public RegisterPageBO(RegisterPage registerPage) {
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
