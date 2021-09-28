package com.ffmanager.core.repository;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.RequestBuilder;
import org.asynchttpclient.Response;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.asynchttpclient.Dsl.*;

/**
 * Base class for http clients
 * @author Daniel
 */
public abstract class HttpClient {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClient.class);
    
    protected static AsyncHttpClient ASYNC_HTTP_CLIENT = asyncHttpClient();
    
    private RequestBuilder buildPostRequest(String url, JSONObject body) {
        LOGGER.debug("Executing post request to url: {} and body: {}", url, body.toString());

        RequestBuilder builder = post(url)
                .addHeader("accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .setBody(body.toString());

        return builder;
    }
    
    public JSONObject executePostRequest(String url, JSONObject body) {
        org.asynchttpclient.Request request = this.buildPostRequest(url, body).build();
        try {
            final Response response = ASYNC_HTTP_CLIENT.executeRequest(request).get();
            final JSONObject jsonResponse = new JSONObject(response.getResponseBody());
            LOGGER.debug("Response for post request to url {} with json body request {} was {}", url, body, jsonResponse);
            return jsonResponse;
        } catch (Exception e) {
            LOGGER.error("Error executing post request to url {} with json body request {}", url, body);
            return null;
        } 
    }

    public JsonNode executeGetRequest(String url) throws IOException {
        JsonNode jsonResponse = null;
        try {
            jsonResponse = Unirest.get(url)
                    .header("Content-Type", "application/json")
                    .asJson()
                    .getBody();
        } catch (Exception e) {
            throw new IOException(e);
        }
        return jsonResponse;

    }

}
