package com.ffmanager.core.repository;

import com.ffmanager.core.domain.FeatureFlag;
import org.json.JSONObject;

import java.util.Collections;
import java.util.List;

public class FeatureFlagServiceClientImpl extends HttpClient implements FeatureFlagServiceClient {

    public FeatureFlagServiceClientImpl() {
//        WebClient client = WebClient.builder()
//                .baseUrl("http://localhost:12300")
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .defaultUriVariables(Collections.singletonMap("url", "http://localhost:12300"))
//                .build();
    }

    @Override
    public List<FeatureFlag> getLatestFeatureFlags() {


        return null;
    }

    @Override
    public List<FeatureFlag> insertFeatureFlag(String featureFlagName, String featureFlagValue) {
        final JSONObject body = new JSONObject()
                .put("name", featureFlagName)
                .put("value", featureFlagValue);

        JSONObject postResponse = this.executePostRequest("http://localhost:12300/featureflags", body);
        return null;
    }
}
