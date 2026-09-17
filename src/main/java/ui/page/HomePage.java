package ui.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage extends BasePage {

    private final Locator searchInput;
    private final Locator searchButton;
    private final Locator logoutButton;

    public HomePage(Page page) {
        super(page);

        searchInput = page.locator("#small-searchterms");
        searchButton = page.locator("input.search-box-button");
        logoutButton = page.locator(".ico-logout");
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
}