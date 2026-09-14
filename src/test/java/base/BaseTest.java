package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.page.HomePage;
import org.page.LoginPage;
import org.page.RegisterPage;
import org.steps.HomePageSteps;
import org.steps.LoginPageSteps;
import org.steps.RegisterPageSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.ITestResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

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

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
        );

        context = browser.newContext();

        page = context.newPage();

        page.navigate("https://demowebshop.tricentis.com/");

        homePage = new HomePage(page);
        loginPage = new LoginPage(page);
        registerPage = new RegisterPage(page);

        homePageSteps = new HomePageSteps(homePage);
        loginPageSteps = new LoginPageSteps(loginPage);
        registerPageSteps = new RegisterPageSteps(registerPage);
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.FAILURE
                    && page != null
                    && !page.isClosed()) {

                Path directory = Paths.get("build", "screenshots");
                Files.createDirectories(directory);

                String fileName = result.getMethod().getMethodName()
                        + "_" + UUID.randomUUID() + ".png";

                Path screenshotPath = directory.resolve(fileName);

                page.screenshot(new Page.ScreenshotOptions()
                        .setPath(screenshotPath)
                        .setFullPage(true));

                System.out.println(
                        "Screenshot: " + screenshotPath.toAbsolutePath()
                );
            }
        } catch (Exception e) {
            System.err.println(
                    "Failed to take a screenshot: " + e.getMessage()
            );
        } finally {
            context.close();
            browser.close();
            playwright.close();
        }
    }
}