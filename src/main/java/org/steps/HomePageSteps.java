package org.steps;

import org.page.HomePage;

public class HomePageSteps {

    private final HomePage homePage;

    public HomePageSteps(HomePage homePage) {
        this.homePage = homePage;
    }

    public void searchProduct(String productName) {

        homePage.enterSearchText(productName);
        homePage.clickSearchButton();
    }

    public void logout() {
        homePage.logout();
    }
}