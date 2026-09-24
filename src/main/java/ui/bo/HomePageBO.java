package ui.bo;

import ui.page.HomePage;
import io.qameta.allure.Step;

public class HomePageBO {

    private final HomePage homePage;
    public HomePageBO(HomePage homePage) {
        this.homePage = homePage;
    }
    @Step ("Check that product can be searched")
    public void searchProduct(String productName) {
        homePage
                .enterSearchText(productName)
                .clickSearchButton();
    }
    @Step ("Check that user can logout")
    public void logout() {
        homePage.logout();
    }
}