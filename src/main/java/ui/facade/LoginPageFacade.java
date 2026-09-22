package ui.facade;

import io.qameta.allure.Step;
import ui.page.LoginPage;

public class LoginPageFacade {

    private final LoginPage loginPage;

    public LoginPageFacade(LoginPage loginPage) {
        this.loginPage = loginPage;
    }
    @Step("Check that user can login")
    public void login(String email, String password) {
        loginPage
                .clickLoginButton()
                .enterEmail(email)
                .enterPassword(password)
                .clickSubmitLogin();
    }
    public boolean isLoginErrorDisplayed() {
        return loginPage.isValidationMessageVisible();
    }
}
