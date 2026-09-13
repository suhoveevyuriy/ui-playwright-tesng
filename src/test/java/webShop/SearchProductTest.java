package webShop;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.steps.HomePageSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductTest extends BaseTest {

    private static final Logger logger =
            LogManager.getLogger(SearchProductTest.class);

    @Test
    public void verifySearchProduct() {
        HomePageSteps homePageSteps = new HomePageSteps(homePage);

        homePageSteps.searchProduct("Camcorder");

        Assert.assertTrue(
                page.locator(".product-title").first().isVisible()
        );
    }
}
