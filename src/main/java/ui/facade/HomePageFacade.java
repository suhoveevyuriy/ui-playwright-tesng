package ui.facade;

import ui.page.HomePage;
import io.qameta.allure.Step;

public class HomePageFacade {

    private final HomePage homePage;
    public HomePageFacade(HomePage homePage) {
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