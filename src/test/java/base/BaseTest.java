package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.qameta.allure.Allure;
import org.page.HomePage;
import org.page.LoginPage;
import org.page.RegisterPage;
import org.steps.HomePageSteps;
import org.steps.LoginPageSteps;
import org.steps.RegisterPageSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.ITestResult;
import org.utils.ConfigManager;

import java.io.ByteArrayInputStream;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    protected HomePage homePage;
    protected LoginPage loginPage;
    protected RegisterPage registerPage;

    protected HomePageSteps homePageSteps;
    protected LoginPageSteps loginPageSteps;
    protected RegisterPageSteps registerPageSteps;

    @BeforeMethod
    public void setUp() {
        playwright = Playwright.create();
        boolean headless = Boolean.parseBoolean(ConfigManager.get("headless"));
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(headless)
        );
        context = browser.newContext();
        page = context.newPage();
        page.navigate(ConfigManager.get("baseUrl"));
        homePage = new HomePage(page);
        loginPage = new LoginPage(page);
        registerPage = new RegisterPage(page);
        homePageSteps = new HomePageSteps(homePage);
        loginPageSteps = new LoginPageSteps(loginPage);
        registerPageSteps = new RegisterPageSteps(registerPage);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.FAILURE
                    && page != null
                    && !page.isClosed()) {
                byte[] screenshot = page.screenshot(
                        new Page.ScreenshotOptions()
                                .setFullPage(true)
                );
                Allure.addAttachment(
                        "Failed test screenshot",
                        "image/png",
                        new ByteArrayInputStream(screenshot),
                        ".png"
                );
            }
        } catch (Exception e) {
            System.err.println(
                    "Failed to take screenshot: " + e.getMessage()
            );
        } finally {
            if (context != null) {
                context.close();
            }
            if (browser != null) {
                browser.close();
            }
            if (playwright != null) {
                playwright.close();
            }
        }
    }
}