package org.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.client.ApiClient;

public class PromoCodeApiSteps {

    private final ApiClient apiClient;

    public PromoCodeApiSteps(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    @Step("Activate Promocode")
    public Response activatePromoCode(String promoCode, String token) {
        String requestBody = """
                {
                    "code": "%s"
                }
                """.formatted(promoCode);

        return apiClient.postWithBearerToken(
                "/apiv2/promocodes/activate",
                requestBody,
                token
        );
    }
}