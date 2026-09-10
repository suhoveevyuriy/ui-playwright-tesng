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
import org.pageSteps.RegisterPageSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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
                        .setHeadless(true)
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

    @AfterMethod
    public void tearDown() {

        context.close();
        browser.close();
        playwright.close();
    }
}