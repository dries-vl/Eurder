package com.driesvl.eurder.authorization.repository.domain;

import java.util.List;

public enum Role {
    CUSTOMER(List.of(Feature.PLACE_ORDER)),
    ADMIN(List.of(Feature.GET_ALL_CUSTOMERS, Feature.GET_CUSTOMER, Feature.GET_ALL_ITEMS_BY_URGENCY, Feature.ADD_ITEM));

    private final List<Feature> featureList;

    Role(List<Feature> featureList) {
        this.featureList = featureList;
    }

    public boolean containsFeature(Feature feature) {
        return featureList.contains(feature);
    }
}
