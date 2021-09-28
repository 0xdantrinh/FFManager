package com.ffmanager.core.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ffmanager.core.domain.FeatureFlag;

import java.io.IOException;
import java.util.List;

public interface FeatureFlagServiceClient {

    List<FeatureFlag> getLatestFeatureFlags() throws IOException;

    List<FeatureFlag> insertFeatureFlag(String featureFlagName, int featureFlagValue) throws JsonProcessingException;

}
