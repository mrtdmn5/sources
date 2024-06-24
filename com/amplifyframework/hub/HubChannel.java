package com.amplifyframework.hub;

import com.amplifyframework.core.category.CategoryType;

/* loaded from: classes.dex */
public enum HubChannel {
    ANALYTICS(CategoryType.ANALYTICS),
    API(CategoryType.API),
    AUTH(CategoryType.AUTH),
    DATASTORE(CategoryType.DATASTORE),
    GEO(CategoryType.GEO),
    HUB(CategoryType.HUB),
    LOGGING(CategoryType.LOGGING),
    PREDICTIONS(CategoryType.PREDICTIONS),
    NOTIFICATIONS(CategoryType.NOTIFICATIONS),
    STORAGE(CategoryType.STORAGE);

    private final CategoryType categoryType;

    HubChannel(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public static HubChannel forCategoryType(CategoryType categoryType) {
        for (HubChannel hubChannel : values()) {
            if (hubChannel.categoryType.equals(categoryType)) {
                return hubChannel;
            }
        }
        throw new IllegalArgumentException("No HubChannel found for the CategoryType: " + categoryType);
    }
}
