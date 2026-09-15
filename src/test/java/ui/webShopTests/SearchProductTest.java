package ui.webShopTests;
import ui.base.UiBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductTest extends UiBaseTest {

    private static final Logger logger =
            LogManager.getLogger(SearchProductTest.class);

    @Test
    public void verifySearchProduct() {
        logger.info("Search Product test started");
        homePageSteps.searchProduct("Camcorder");
        Assert.assertTrue(
                page.locator(".product-title").first().isVisible()
        );
        logger.info("Search Product test finished");
    }
}
