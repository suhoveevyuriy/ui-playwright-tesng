package api.apiTests;

import api.baseApi.ApiBaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class LoginTest extends ApiBaseTest {

    @Test(groups = "api")
    public void loginUser() {
        registerTestUser();

        Response response = authApiSteps.login(
                sessionData.getEmail(),
                sessionData.getPassword()
        );
        String token = response.then()
                .statusCode(200)
                .body("status", equalTo(true))
                .extract()
                .path("user.token");

        Assert.assertFalse(
                token.isBlank(),
                "Token після login не може бути порожнім"
        );

        sessionData.setToken(token);
    }
}