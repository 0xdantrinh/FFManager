package com.ffmanager.core.domain;

import static com.ffmanager.core.utils.BinaryUtils.integerToBinary;

public class FeatureFlag {
    private int identityInformationValue;
    private boolean isAsiaEnabled;
    private boolean isKoreaEnabled;
    private boolean isEuropeEnabled;
    private boolean isJapanEnabled;
    private boolean isAmericaEnabled;

    public FeatureFlag(int identityInformationValue) {
        this.identityInformationValue = identityInformationValue;
        int[] binaryIdentityInformation = integerToBinary(identityInformationValue);
        this.isAsiaEnabled = binaryIdentityInformation[0] == 1;
        this.isKoreaEnabled = binaryIdentityInformation[0] == 1;
        this.isEuropeEnabled = binaryIdentityInformation[0] == 1;
        this.isJapanEnabled = binaryIdentityInformation[0] == 1;
        this.isAmericaEnabled = binaryIdentityInformation[0] == 1;
    }

    public int getIdentityInformationValue() {
        return identityInformationValue;
    }

    public boolean isAsiaEnabled() {
        return isAsiaEnabled;
    }

    public boolean isKoreaEnabled() {
        return isKoreaEnabled;
    }

    public boolean isEuropeEnabled() {
        return isEuropeEnabled;
    }

    public boolean isJapanEnabled() {
        return isJapanEnabled;
    }

    public boolean isAmericaEnabled() {
        return isAmericaEnabled;
    }
}
