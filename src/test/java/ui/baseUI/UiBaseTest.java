package ui.baseUI;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.qameta.allure.Allure;
import ui.page.HomePage;
import ui.page.LoginPage;
import ui.page.RegisterPage;
import ui.bo.HomePageBO;
import ui.bo.LoginPageBO;
import ui.bo.RegisterPageBO;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.ITestResult;
import utils.ConfigManager;

import java.io.ByteArrayInputStream;

public class UiBaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    protected HomePage homePage;
    protected LoginPage loginPage;
    protected RegisterPage registerPage;

    protected HomePageBO homePageBO;
    protected LoginPageBO loginPageBO;
    protected RegisterPageBO registerPageBO;

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
        page.navigate(ConfigManager.getInstance().get("baseUrl"));
        homePage = new HomePage(page);
        loginPage = new LoginPage(page);
        registerPage = new RegisterPage(page);
        homePageBO = new HomePageBO(homePage);
        loginPageBO = new LoginPageBO(loginPage);
        registerPageBO = new RegisterPageBO(registerPage);
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