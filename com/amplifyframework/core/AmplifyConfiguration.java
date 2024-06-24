package com.amplifyframework.core;

import android.content.Context;
import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.analytics.AnalyticsCategoryConfiguration;
import com.amplifyframework.api.ApiCategoryConfiguration;
import com.amplifyframework.auth.AuthCategoryConfiguration;
import com.amplifyframework.core.Resources;
import com.amplifyframework.core.category.CategoryConfiguration;
import com.amplifyframework.core.category.CategoryType;
import com.amplifyframework.core.category.EmptyCategoryConfiguration;
import com.amplifyframework.datastore.DataStoreCategoryConfiguration;
import com.amplifyframework.geo.GeoCategoryConfiguration;
import com.amplifyframework.hub.HubCategoryConfiguration;
import com.amplifyframework.logging.LoggingCategoryConfiguration;
import com.amplifyframework.notifications.NotificationsCategoryConfiguration;
import com.amplifyframework.predictions.PredictionsCategoryConfiguration;
import com.amplifyframework.storage.StorageCategoryConfiguration;
import com.amplifyframework.util.Immutable;
import com.amplifyframework.util.UserAgent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class AmplifyConfiguration {
    private static final String DEFAULT_IDENTIFIER = "amplifyconfiguration";
    private final Map<String, CategoryConfiguration> categoryConfigurations;
    private final boolean devMenuEnabled;
    private final Map<UserAgent.Platform, String> platformVersions;

    /* loaded from: classes.dex */
    public static final class Builder {
        private final Map<String, CategoryConfiguration> categoryConfiguration;
        private boolean devMenuEnabled;
        private final Map<UserAgent.Platform, String> platformVersions;

        public Builder addPlatform(UserAgent.Platform platform, String str) {
            if (!UserAgent.Platform.ANDROID.equals(platform)) {
                Map<UserAgent.Platform, String> map = this.platformVersions;
                Objects.requireNonNull(platform);
                Objects.requireNonNull(str);
                map.put(platform, str);
            }
            return this;
        }

        public AmplifyConfiguration build() {
            return new AmplifyConfiguration(this.categoryConfiguration, this.platformVersions, this.devMenuEnabled);
        }

        public Builder devMenuEnabled(boolean z) {
            this.devMenuEnabled = z;
            return this;
        }

        private Builder(Map<String, CategoryConfiguration> map) {
            this.devMenuEnabled = false;
            this.categoryConfiguration = map;
            this.platformVersions = new LinkedHashMap();
        }
    }

    public static Builder builder(Context context) throws AmplifyException {
        try {
            return builder(context, Resources.getRawResourceId(context, DEFAULT_IDENTIFIER));
        } catch (Resources.ResourceLoadingException e) {
            throw new AmplifyException("Failed to load the amplifyconfiguration configuration file.", e, "Is there an Amplify configuration file present in your app project, under ./app/src/main/res/raw/amplifyconfiguration?");
        }
    }

    private static Map<String, CategoryConfiguration> configsFromJson(JSONObject jSONObject) throws AmplifyException {
        List<CategoryConfiguration> asList = Arrays.asList(new AnalyticsCategoryConfiguration(), new ApiCategoryConfiguration(), new AuthCategoryConfiguration(), new DataStoreCategoryConfiguration(), new GeoCategoryConfiguration(), new HubCategoryConfiguration(), new LoggingCategoryConfiguration(), new PredictionsCategoryConfiguration(), new StorageCategoryConfiguration(), new NotificationsCategoryConfiguration());
        HashMap hashMap = new HashMap();
        try {
            for (CategoryConfiguration categoryConfiguration : asList) {
                String configurationKey = categoryConfiguration.getCategoryType().getConfigurationKey();
                if (jSONObject.has(configurationKey)) {
                    categoryConfiguration.populateFromJSON(jSONObject.getJSONObject(configurationKey));
                    hashMap.put(configurationKey, categoryConfiguration);
                }
            }
            return Immutable.of(hashMap);
        } catch (JSONException e) {
            throw new AmplifyException("Could not parse amplifyconfiguration.json ", e, "Check any modifications made to the file.");
        }
    }

    public static AmplifyConfiguration fromConfigFile(Context context) throws AmplifyException {
        return builder(context).build();
    }

    public static AmplifyConfiguration fromJson(JSONObject jSONObject) throws AmplifyException {
        return builder(jSONObject).build();
    }

    public CategoryConfiguration forCategoryType(CategoryType categoryType) {
        CategoryConfiguration categoryConfiguration = this.categoryConfigurations.get(categoryType.getConfigurationKey());
        if (categoryConfiguration == null) {
            return EmptyCategoryConfiguration.forCategoryType(categoryType);
        }
        return categoryConfiguration;
    }

    public Map<UserAgent.Platform, String> getPlatformVersions() {
        return Immutable.of(this.platformVersions);
    }

    public boolean isDevMenuEnabled() {
        return this.devMenuEnabled;
    }

    public AmplifyConfiguration(Map<String, CategoryConfiguration> map) {
        this(map, new LinkedHashMap(), false);
    }

    public static AmplifyConfiguration fromConfigFile(Context context, int r1) throws AmplifyException {
        return builder(context, r1).build();
    }

    public AmplifyConfiguration(Map<String, CategoryConfiguration> map, boolean z) {
        this(map, new LinkedHashMap(), z);
    }

    private AmplifyConfiguration(Map<String, CategoryConfiguration> map, Map<UserAgent.Platform, String> map2, boolean z) {
        HashMap hashMap = new HashMap();
        this.categoryConfigurations = hashMap;
        hashMap.putAll(map);
        this.platformVersions = map2;
        this.devMenuEnabled = z;
    }

    public static Builder builder(Context context, int r3) throws AmplifyException {
        Objects.requireNonNull(context);
        try {
            return builder(Resources.readJsonResourceFromId(context, r3));
        } catch (Resources.ResourceLoadingException e) {
            throw new AmplifyException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Failed to read JSON from resource = ", r3), e, "If you are attempting to load a custom configuration file, please ensure that it exists in your application project under app/src/main/res/raw/<YOUR_CUSTOM_CONFIG_FILE>.");
        }
    }

    public static Builder builder(JSONObject jSONObject) throws AmplifyException {
        Objects.requireNonNull(jSONObject);
        return new Builder(configsFromJson(jSONObject));
    }
}
