package api.apiTests;

import api.baseApi.ApiBaseTest;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.http.HttpResponse;

public class PromoCodeTest extends ApiBaseTest {

    @Test(groups = "api")
    public void activateValidPromoCode() throws Exception {
        registerTestUser();

        String requestBody = """
                {
                    "code": "075D800A28"
                }
                """;

        HttpResponse<String> response = apiClient.post(
                "/apiv2/promocodes/activate",
                requestBody,
                sessionData.getToken()
        );

        Assert.assertEquals(response.statusCode(), 200);
        JsonNode json = objectMapper.readTree(response.body());

        Assert.assertTrue(json.get("status").asBoolean());
        System.out.println("Valid promo code activated");
        System.out.println(response.body());
    }

    @Test(groups = "api")
    public void activateExpiredPromoCode() throws Exception {
        registerTestUser();

        String requestBody = """
                {
                    "code": "D786952181"
                }
                """;

        HttpResponse<String> response = apiClient.post(
                "/apiv2/promocodes/activate",
                requestBody,
                sessionData.getToken()
        );

        Assert.assertEquals(response.statusCode(), 200);
        JsonNode json = objectMapper.readTree(response.body());

        Assert.assertFalse(json.get("status").asBoolean());
        Assert.assertEquals(
                json.get("reason").asText(),
                "expired promocode"
        );
        System.out.println("Expired promo code rejected");
        System.out.println(response.body());
    }
}