package org.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage extends BasePage {

    private final Locator searchInput;
    private final Locator searchButton;
    private final Locator logoutButton;
    private final Locator homeButton;

    public HomePage(Page page) {
        super(page);

        searchInput = page.locator("#small-searchterms");
        searchButton = page.locator("input.search-box-button");
        logoutButton = page.locator(".ico-logout");
        homeButton = page.locator(".header-logo a");
    }

    public HomePage logout() {
        logoutButton.click();
        return this;
    }

    public HomePage enterSearchText(String productName) {
        searchInput.fill(productName);
        return this;
    }

    public HomePage clickSearchButton() {
        searchButton.click();
        return this;
    }

    public HomePage clickLogout() {
        logoutButton.click();
        return this;
    }

    public void openHomePage() {
        homeButton.click();
    }
}