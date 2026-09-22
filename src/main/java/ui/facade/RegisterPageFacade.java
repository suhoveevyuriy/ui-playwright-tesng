package ui.facade;

import io.qameta.allure.Step;
import ui.page.RegisterPage;

public class RegisterPageFacade {

    private final RegisterPage registerPage;

    public RegisterPageFacade(RegisterPage registerPage) {
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
