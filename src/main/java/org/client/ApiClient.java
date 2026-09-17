package org.client;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiClient {
    private final String baseUrl;
    private final String username;
    private final String password;

    public ApiClient(String baseUrl, String username, String password) {
        this.baseUrl = baseUrl;
        this.username = username;
        this.password = password;
    }
    private RequestSpecification baseRequest() {
        return RestAssured.given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("localization", "ua");
    }
    public Response postWithBasicAuth(String endpoint, String body) {
        return baseRequest()
                .auth()
                .preemptive()
                .basic(username, password)
                .body(body)
                .when()
                .post(endpoint);
    }

    public Response postWithBearerToken(
            String endpoint,
            String body,
            String token
    ) {
        return baseRequest()
                .auth()
                .oauth2(token)
                .body(body)
                .when()
                .post(endpoint);
    }
}