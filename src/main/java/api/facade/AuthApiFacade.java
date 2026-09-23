package api.facade;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import api.client.ApiClient;
import ui.utils.dto.DeviceDto;
import ui.utils.dto.LoginRequestDto;

public class AuthApiFacade {

    private final ApiClient apiClient;

    public AuthApiFacade(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
@Step("Get response after login")
public Response login(String email, String password) {
    DeviceDto device = DeviceDto.builder()
            .platform("WEB")
            .device_id("test-device")
            .device_model("Web")
            .os_version("11")
            .browser_name("Chrome")
            .browser_version("151")
            .user_agent("Mozilla/5.0")
            .build();

    LoginRequestDto requestBody = LoginRequestDto.builder()
            .type("email")
            .email(email)
            .password(password)
            .device(device)
            .build();

    return apiClient.postWithBasicAuth(
            "/auth/login?on_device=true",
            requestBody
    );
    }
}