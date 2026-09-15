package api.baseApi;

import api.models.SessionData;
import org.client.ApiClient;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import java.net.http.HttpResponse;

public class ApiBaseTest {

    protected ApiClient apiClient;
    protected SessionData sessionData;
    protected ObjectMapper objectMapper;

    @BeforeClass(alwaysRun = true)
    public void setUpApi() {
        apiClient = new ApiClient(
                "https://stage.slotcity.ua",
                "intusers",
                "GjRQVKrtZAFc"
        );

        sessionData = new SessionData();
        objectMapper = new ObjectMapper();
    }

    protected void registerTestUser() throws Exception {

        String email = "haribo+" + System.currentTimeMillis() + "@sharkscode.com";
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

        HttpResponse<String> response = apiClient.post(
                "/auth/v2/register?on_device=true",
                requestBody
        );

        Assert.assertEquals(response.statusCode(), 200);

        JsonNode json = objectMapper.readTree(response.body());

        Assert.assertTrue(json.get("status").asBoolean());

        sessionData.setEmail(email);
        sessionData.setPassword(password);
        sessionData.setToken(json.get("user").get("token").asText());
    }
}