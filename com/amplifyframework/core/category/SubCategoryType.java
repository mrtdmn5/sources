package com.amplifyframework.core.category;

/* loaded from: classes.dex */
public enum SubCategoryType {
    PUSH_NOTIFICATIONS("push"),
    INAPP_MESSAGING("inapp_messaging");

    private final String configurationKey;

    SubCategoryType(String str) {
        this.configurationKey = str;
    }

    public String getConfigurationKey() {
        return this.configurationKey;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.configurationKey;
    }
}
