package api.client;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApiLogger {

    private static final Logger logger =
            LogManager.getLogger(ApiLogger.class);

    private final ApiClient apiClient;

    public ApiLogger(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public Response postWithBasicAuth(String endpoint, Object body) {

        logger.info("Request: " + endpoint);

        Response response =
                apiClient.postWithBasicAuth(endpoint, body);

        logger.info("Status code: " + response.statusCode());

        return response;
    }
}
