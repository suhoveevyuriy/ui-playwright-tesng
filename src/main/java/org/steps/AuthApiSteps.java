package org.steps;

import io.restassured.response.Response;
import org.client.ApiClient;

public class AuthApiSteps {

    private final ApiClient apiClient;

    public AuthApiSteps(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

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