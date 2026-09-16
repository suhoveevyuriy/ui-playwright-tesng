package org.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class ApiClient {

    private final HttpClient client;
    private final String baseUrl;
    private final String basicAuth;

    public ApiClient(String baseUrl, String username, String password) {
        this.client = HttpClient.newHttpClient();
        this.baseUrl = baseUrl;
        String credentials = username + ":" + password;
        this.basicAuth = "Basic " + Base64.getEncoder()
                .encodeToString(credentials.getBytes(StandardCharsets.UTF_8));
    }
    public HttpResponse<String> post(
            String endpoint,
            String body
    ) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + endpoint))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", basicAuth)
                .header("localization", "ua")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        return client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );
    }
    public HttpResponse<String> post(
            String endpoint,
            String body,
            String token
    ) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + endpoint))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + token)
                .header("localization", "ua")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        return client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );
    }
}