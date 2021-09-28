package com.ffmanager.core.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.ffmanager.core.domain.FeatureFlag;
import com.mashape.unirest.http.JsonNode;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FeatureFlagServiceClientImpl extends HttpClient implements FeatureFlagServiceClient {

    @Override
    public List<FeatureFlag> getLatestFeatureFlags() throws IOException {
        try {
            JsonNode getResponse = this.executeGetRequest("http://localhost:12300/featureflags");
            List<FeatureFlag> featureFlags = new ArrayList();
            JSONArray featureFlagJsonArray = getResponse.getArray();
            for (int i = 0; i < featureFlagJsonArray.length(); i++) {
                String name = (String) featureFlagJsonArray.getJSONObject(i).get("name");
                int value = (int) featureFlagJsonArray.getJSONObject(i).get("value");
                FeatureFlag featureFlag = new FeatureFlag(name, value);
                featureFlags.add(featureFlag);
            }
            return featureFlags;
        }
        catch (Exception e) {
            throw new IOException("Invalid API Call Inputs");
        }
    }

    @Override
    public List<FeatureFlag> insertFeatureFlag(String featureFlagName, int featureFlagValue) throws JsonProcessingException {
        final JSONObject body = new JSONObject()
                .put("name", featureFlagName)
                .put("value", featureFlagValue);

        JSONObject postResponse = this.executePostRequest("http://localhost:12300/featureflags", body);

        ObjectMapper mapper = new ObjectMapper();

        List<FeatureFlag> featureFlags = mapper.readValue(postResponse.toString(), new TypeReference<List<FeatureFlag>>(){});

        return featureFlags;
    }

}
