package com.ffmanager.core.repository;

import com.ffmanager.core.domain.FeatureFlag;

import java.util.List;

public interface FeatureFlagDao {

    List<FeatureFlag> getLatestFeatureFlags();

}
