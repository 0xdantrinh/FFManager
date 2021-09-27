package com.ffmanager.core.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ffmanager.core.domain.FeatureFlag;

import java.util.List;

public interface FeatureFlagServiceClient {

    List<FeatureFlag> getLatestFeatureFlags() throws JsonProcessingException;

    List<FeatureFlag> insertFeatureFlag(String featureFlagName, String featureFlagValue);

}
