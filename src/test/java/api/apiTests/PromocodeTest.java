package api.apiTests;

import api.baseApi.ApiBaseTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class PromocodeTest extends ApiBaseTest {

    private static final String VALID_PROMO_CODE = "075D800A28";
    private static final String EXPIRED_PROMO_CODE = "D786952181";

    @Test(groups = "api")
    public void activateValidPromoCode() {
        registerTestUser();
        promoCodeApiSteps.activatePromoCode(
                        VALID_PROMO_CODE,
                        sessionData.getToken()
                )
                .then()
                .statusCode(200)
                .body("status", equalTo(true));
    }

    @Test(groups = "api")
    public void activateExpiredPromoCode() {
        registerTestUser();

        promoCodeApiSteps.activatePromoCode(
                        EXPIRED_PROMO_CODE,
                        sessionData.getToken()
                )
                .then()
                .statusCode(200)
                .body("status", equalTo(false))
                .body("reason", equalTo("expired promocode"));
    }
}