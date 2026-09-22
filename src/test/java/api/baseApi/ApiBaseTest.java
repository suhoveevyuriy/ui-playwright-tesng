package api.baseApi;

import api.models.SessionData;
import io.restassured.response.Response;
import net.datafaker.Faker;
import api.client.ApiClient;
import api.facade.AuthApiFacade;
import api.facade.PromoCodeApiFacade;
import org.testng.annotations.BeforeClass;

public class ApiBaseTest {

    protected ApiClient apiClient;
    protected SessionData sessionData;
    protected AuthApiFacade authApiFacade;
    protected PromoCodeApiFacade promoCodeApiFacade;

    private static final Faker FAKER = new Faker();

    @BeforeClass(alwaysRun = true)
    public void setUpApi() {
        apiClient = new ApiClient(
                "https://stage.slotcity.ua",
                "intusers",
                "GjRQVKrtZAFc"
        );

        sessionData = new SessionData();
        authApiFacade = new AuthApiFacade(apiClient);
        promoCodeApiFacade = new PromoCodeApiFacade(apiClient);
    }

    protected Response registerTestUser() {
        String email = FAKER.bothify("haribo??##")
                + "+" + System.currentTimeMillis()
                + "@sharkscode.com";

        String password = "test123@";

        String requestBody = """
                {
                  "type": "email",
                  "password": "%s",
                  "email": "%s",
                  "is_accept": 1,
                  "device": {
                    "platform": "WEB",
                    "device_id": "test-device",
                    "device_model": "Web",
                    "os_version": "1",
                    "browser_name": "Chrome",
                    "browser_version": "151",
                    "user_agent": "Mozilla/5.0"
                  }
                }
                """.formatted(password, email);

        Response response = apiClient.postWithBasicAuth(
                "/auth/v2/register?on_device=true",
                requestBody
        );

        sessionData.setEmail(email);
        sessionData.setPassword(password);
        sessionData.setToken(
                response.jsonPath().getString("user.token")
        );

        return response;
    }
}