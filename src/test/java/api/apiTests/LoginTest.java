package api.apiTests;

import api.baseApi.ApiBaseTest;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.http.HttpResponse;

public class LoginTest extends ApiBaseTest {

    @Test(groups = "api")
    public void loginUser() throws Exception {

        registerTestUser();

        String requestBody = """
                {
                    "type": "email",
                    "password": "%s",
                    "email": "%s",
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
                """.formatted(
                sessionData.getPassword(),
                sessionData.getEmail()
        );

        HttpResponse<String> response = apiClient.post(
                "/auth/login?on_device=true",
                requestBody
        );

        Assert.assertEquals(response.statusCode(), 200);
        JsonNode json = objectMapper.readTree(response.body());

        Assert.assertTrue(json.get("status").asBoolean());
        String loginToken = json.get("user").get("token").asText();

        Assert.assertFalse(loginToken.isEmpty());
        sessionData.setToken(loginToken);

        System.out.println("Login successful");
        System.out.println("Email: " + sessionData.getEmail());
        System.out.println("Token: " + sessionData.getToken());
    }
}