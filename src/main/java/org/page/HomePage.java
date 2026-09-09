package org.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {

    private final Page page;
    private final Locator searchInput;
    private final Locator searchButton;
    private final Locator logoutButton;
    private final Locator homeButton;

    public HomePage(Page page) {
        this.page = page;

        searchInput = page.locator("#small-searchterms");
        searchButton = page.locator("input.search-box-button");
        logoutButton = page.locator(".ico-logout");
        homeButton = page.locator(".header-logo a");
    }

    public void logout() {
        logoutButton.click();
    }

    public void enterSearchText(String productName) {
        searchInput.fill(productName);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void openHomePage() {
        homeButton.click();
    }
}