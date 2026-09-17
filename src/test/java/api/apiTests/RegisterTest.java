package api.apiTests;

import api.baseApi.ApiBaseTest;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class RegisterTest extends ApiBaseTest {

    @Test(groups = "api")
    public void registerUser() {
        registerTestUser()
                .then()
                .statusCode(200)
                .body("status", equalTo(true))
                .body("user.token", notNullValue());
    }
}