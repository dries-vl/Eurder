package com.driesvl.eurder.helper.repository.domain;

import java.util.List;

public enum Role {
    CUSTOMER(List.of()),
    ADMIN(List.of(Feature.GET_ALL_CUSTOMERS, Feature.GET_CUSTOMER));

    private final List<Feature> featureList;

    Role(List<Feature> featureList) {
        this.featureList = featureList;
    }

    public boolean containsFeature(Feature feature) {
        return featureList.contains(feature);
    }
}
