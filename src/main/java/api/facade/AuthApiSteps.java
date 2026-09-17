package api.facade;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import api.client.ApiClient;

public class AuthApiSteps {

    private final ApiClient apiClient;

    public AuthApiSteps(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
@Step("Get response after login")
public Response login(String email, String password) {
        String requestBody = """
                {
                    "type": "email",
                    "password": "%s",
                    "email": "%s",
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

        return apiClient.postWithBasicAuth(
                "/auth/login?on_device=true",
                requestBody
        );
    }
}