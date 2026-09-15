package org.steps;

import org.page.HomePage;
import io.qameta.allure.Step;

public class HomePageSteps {

    private final HomePage homePage;
    public HomePageSteps(HomePage homePage) {
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