package com.amplifyframework.core.category;

/* loaded from: classes.dex */
public enum CategoryType {
    ANALYTICS("analytics"),
    API("api"),
    AUTH("auth"),
    DATASTORE("dataStore"),
    HUB("hub"),
    LOGGING("logging"),
    NOTIFICATIONS("notifications"),
    PREDICTIONS("predictions"),
    STORAGE("storage"),
    GEO("geo");

    private final String configurationKey;

    CategoryType(String str) {
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
