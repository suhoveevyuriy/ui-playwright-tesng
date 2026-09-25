package api.facade;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import utils.builder.DeviceDto;
import utils.builder.LoginRequestDto;
import api.client.ApiLogger;

public class AuthApiFacade {

    private final ApiLogger apiLogger;

    public AuthApiFacade(ApiLogger apiLogger) {
        this.apiLogger = apiLogger;
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

    LoginRequestDto request = LoginRequestDto.builder()
            .type("EMAIL")
            .email("haribo+2@sharkscode.com")
            .password("Test123@")
            .device(device)
            .build();

    return apiLogger.postWithBasicAuth(
            "/auth/login?on_device=true",
            request
    );
    }
}