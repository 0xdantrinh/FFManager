package com.ffmanager.core.domain;

import static com.ffmanager.core.utils.BinaryUtils.integerToBinary;

public class FeatureFlag {
    private final String name;
    private int identityInformationValue;
    private int isAsiaEnabled;
    private int isKoreaEnabled;
    private int isEuropeEnabled;
    private int isJapanEnabled;
    private int isAmericaEnabled;

    public FeatureFlag(String name, int identityInformationValue) {
        this.name = name;
        this.identityInformationValue = identityInformationValue;
        int[] binaryIdentityInformation = integerToBinary(identityInformationValue);
        this.isAsiaEnabled = binaryIdentityInformation[4] == 1 ? 1 : 0;
        this.isKoreaEnabled = binaryIdentityInformation[3] == 1 ? 1 : 0;
        this.isEuropeEnabled = binaryIdentityInformation[2] == 1 ? 1 : 0;
        this.isJapanEnabled = binaryIdentityInformation[1] == 1 ? 1 : 0;
        this.isAmericaEnabled = binaryIdentityInformation[0] == 1 ? 1 : 0;
    }

    public int getIdentityInformationValue() {
        return identityInformationValue;
    }

    public int isAsiaEnabled() {
        return isAsiaEnabled;
    }

    public int isKoreaEnabled() {
        return isKoreaEnabled;
    }

    public int isEuropeEnabled() {
        return isEuropeEnabled;
    }

    public int isJapanEnabled() {
        return isJapanEnabled;
    }

    public int isAmericaEnabled() { return isAmericaEnabled; }

    public String getName() { return name; }
}
