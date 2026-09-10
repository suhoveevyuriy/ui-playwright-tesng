package webShop;

import base.BaseTest;
import org.page.HomePage;
import org.steps.HomePageSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductTest extends BaseTest {

    @Test
    public void verifySearchProduct() {

        HomePage homePage = new HomePage(page);
        HomePageSteps homePageSteps = new HomePageSteps(homePage);

        homePageSteps.searchProduct("Camcorder");

        Assert.assertTrue(
                page.locator(".product-title").first().isVisible()
        );
    }
}
