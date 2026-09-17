package api.baseApi;

import api.models.SessionData;
import io.restassured.response.Response;
import net.datafaker.Faker;
import org.client.ApiClient;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.steps.AuthApiSteps;
import java.util.Locale;

import static org.hamcrest.Matchers.equalTo;


public class ApiBaseTest {


    protected ApiClient apiClient;
    protected SessionData sessionData;
    protected AuthApiSteps authApiSteps;

    private static final Faker FAKER = new Faker(Locale.ENGLISH);

    @BeforeClass(alwaysRun = true)
    public void setUpApi() {
        apiClient = new ApiClient(
                "https://stage.slotcity.ua",
                "intusers",
                "GjRQVKrtZAFc"
        );

        sessionData = new SessionData();
        authApiSteps = new AuthApiSteps(apiClient);
    }

    protected void registerTestUser() {
        String email = FAKER.bothify("haribo??##")
                + "+"
                + System.currentTimeMillis()
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
                        "os_version": "11",
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
        String token = response.then()
                .statusCode(200)
                .body("status", equalTo(true))
                .extract()
                .path("user.token");

        Assert.assertNotNull(
                token,
                "No token after registration"
        );
        Assert.assertFalse(
                token.isBlank(),
                "Token can't be blank"
        );
        sessionData.setEmail(email);
        sessionData.setPassword(password);
        sessionData.setToken(token);
    }
}