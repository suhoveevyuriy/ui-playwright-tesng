package org.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {
    private Page page;
    private Locator searchInput;
    private Locator searchButton;
    private Locator logoutButton;
    private Locator homeButton;

    public string productName;


    public HomePage(Page page) {
        searchInput = page.locator("#small-searchterms");
        searchButton = page.locator("input.search-box-button");
        logoutButton = page.locator(".ico-logout");
        homeButton = page.locator(".header-logo a");

        public void logout () {
            logoutButton.click();
        }

        public void enterSearchText(String productName) {
            searchInput.fill(productName);
        }

        public void clickSearchButton() {
            searchButton.click();
        }
        public void openHomePage () {
            homeButton.click();
        }

    }
}
