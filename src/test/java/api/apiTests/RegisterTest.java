package api.apiTests;

import api.baseApi.ApiBaseTest;
import org.testng.annotations.Test;

public class RegisterTest extends ApiBaseTest {

    @Test(groups = "api")
    public void registerUser() throws Exception {
        registerTestUser();
    }
}