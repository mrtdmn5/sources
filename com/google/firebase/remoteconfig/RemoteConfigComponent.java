package com.google.firebase.remoteconfig;

import android.content.Context;
import android.os.Bundle;
import com.animaconnected.secondo.provider.configuration.database.ConfigurationItem;
import com.animaconnected.watch.device.Command;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigFetchHttpClient;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import com.google.firebase.remoteconfig.internal.ConfigStorageClient;
import com.google.firebase.remoteconfig.internal.Personalization;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class RemoteConfigComponent {
    public static final Random DEFAULT_RANDOM = new Random();
    public final Provider<AnalyticsConnector> analyticsConnector;
    public final String appId;
    public final Context context;
    public final HashMap customHeaders;
    public final Executor executor;
    public final FirebaseABTesting firebaseAbt;
    public final FirebaseApp firebaseApp;
    public final FirebaseInstallationsApi firebaseInstallations;
    public final HashMap frcNamespaceInstances;

    public RemoteConfigComponent() {
        throw null;
    }

    public RemoteConfigComponent(Context context, @Blocking Executor executor, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Provider<AnalyticsConnector> provider) {
        this.frcNamespaceInstances = new HashMap();
        this.customHeaders = new HashMap();
        this.context = context;
        this.executor = executor;
        this.firebaseApp = firebaseApp;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.firebaseAbt = firebaseABTesting;
        this.analyticsConnector = provider;
        firebaseApp.checkNotDeleted();
        this.appId = firebaseApp.options.applicationId;
        Tasks.call(executor, new Callable() { // from class: com.google.firebase.remoteconfig.RemoteConfigComponent$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return RemoteConfigComponent.this.getDefault();
            }
        });
    }

    public final synchronized FirebaseRemoteConfig get(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Executor executor, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2, ConfigCacheClient configCacheClient3, ConfigFetchHandler configFetchHandler, ConfigGetParameterHandler configGetParameterHandler, ConfigMetadataClient configMetadataClient) {
        boolean z;
        FirebaseABTesting firebaseABTesting2;
        if (!this.frcNamespaceInstances.containsKey("firebase")) {
            Context context = this.context;
            firebaseApp.checkNotDeleted();
            if (firebaseApp.name.equals("[DEFAULT]")) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                firebaseABTesting2 = firebaseABTesting;
            } else {
                firebaseABTesting2 = null;
            }
            FirebaseRemoteConfig firebaseRemoteConfig = new FirebaseRemoteConfig(context, firebaseInstallationsApi, firebaseABTesting2, executor, configCacheClient, configCacheClient2, configCacheClient3, configFetchHandler, configGetParameterHandler, configMetadataClient);
            configCacheClient2.get();
            configCacheClient3.get();
            configCacheClient.get();
            this.frcNamespaceInstances.put("firebase", firebaseRemoteConfig);
        }
        return (FirebaseRemoteConfig) this.frcNamespaceInstances.get("firebase");
    }

    public final ConfigCacheClient getCacheClient(String str) {
        ConfigStorageClient configStorageClient;
        ConfigCacheClient configCacheClient;
        String format = String.format("%s_%s_%s_%s.json", "frc", this.appId, "firebase", str);
        Executor executor = this.executor;
        Context context = this.context;
        HashMap hashMap = ConfigStorageClient.clientInstances;
        synchronized (ConfigStorageClient.class) {
            HashMap hashMap2 = ConfigStorageClient.clientInstances;
            if (!hashMap2.containsKey(format)) {
                hashMap2.put(format, new ConfigStorageClient(context, format));
            }
            configStorageClient = (ConfigStorageClient) hashMap2.get(format);
        }
        HashMap hashMap3 = ConfigCacheClient.clientInstances;
        synchronized (ConfigCacheClient.class) {
            String str2 = configStorageClient.fileName;
            HashMap hashMap4 = ConfigCacheClient.clientInstances;
            if (!hashMap4.containsKey(str2)) {
                hashMap4.put(str2, new ConfigCacheClient(executor, configStorageClient));
            }
            configCacheClient = (ConfigCacheClient) hashMap4.get(str2);
        }
        return configCacheClient;
    }

    public final FirebaseRemoteConfig getDefault() {
        final Personalization personalization;
        FirebaseRemoteConfig firebaseRemoteConfig;
        synchronized (this) {
            ConfigCacheClient cacheClient = getCacheClient("fetch");
            ConfigCacheClient cacheClient2 = getCacheClient("activate");
            ConfigCacheClient cacheClient3 = getCacheClient("defaults");
            ConfigMetadataClient configMetadataClient = new ConfigMetadataClient(this.context.getSharedPreferences(String.format("%s_%s_%s_%s", "frc", this.appId, "firebase", Command.SETTINGS), 0));
            ConfigGetParameterHandler configGetParameterHandler = new ConfigGetParameterHandler(this.executor, cacheClient2, cacheClient3);
            FirebaseApp firebaseApp = this.firebaseApp;
            Provider<AnalyticsConnector> provider = this.analyticsConnector;
            firebaseApp.checkNotDeleted();
            if (firebaseApp.name.equals("[DEFAULT]")) {
                personalization = new Personalization(provider);
            } else {
                personalization = null;
            }
            if (personalization != null) {
                BiConsumer biConsumer = new BiConsumer() { // from class: com.google.firebase.remoteconfig.RemoteConfigComponent$$ExternalSyntheticLambda0
                    @Override // com.google.android.gms.common.util.BiConsumer
                    public final void accept(String str, ConfigContainer configContainer) {
                        JSONObject optJSONObject;
                        Personalization personalization2 = Personalization.this;
                        AnalyticsConnector analyticsConnector = personalization2.analyticsConnector.get();
                        if (analyticsConnector != null) {
                            JSONObject jSONObject = configContainer.personalizationMetadata;
                            if (jSONObject.length() >= 1) {
                                JSONObject jSONObject2 = configContainer.configsJson;
                                if (jSONObject2.length() >= 1 && (optJSONObject = jSONObject.optJSONObject(str)) != null) {
                                    String optString = optJSONObject.optString("choiceId");
                                    if (!optString.isEmpty()) {
                                        synchronized (personalization2.loggedChoiceIds) {
                                            if (!optString.equals(personalization2.loggedChoiceIds.get(str))) {
                                                personalization2.loggedChoiceIds.put(str, optString);
                                                Bundle bundle = new Bundle();
                                                bundle.putString("arm_key", str);
                                                bundle.putString("arm_value", jSONObject2.optString(str));
                                                bundle.putString("personalization_id", optJSONObject.optString("personalizationId"));
                                                bundle.putInt("arm_index", optJSONObject.optInt("armIndex", -1));
                                                bundle.putString(ConfigurationItem.COLUMN_NAME_GROUP, optJSONObject.optString(ConfigurationItem.COLUMN_NAME_GROUP));
                                                analyticsConnector.logEvent("fp", "personalization_assignment", bundle);
                                                Bundle bundle2 = new Bundle();
                                                bundle2.putString("_fpid", optString);
                                                analyticsConnector.logEvent("fp", "_fpc", bundle2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                };
                synchronized (configGetParameterHandler.listeners) {
                    configGetParameterHandler.listeners.add(biConsumer);
                }
            }
            firebaseRemoteConfig = get(this.firebaseApp, this.firebaseInstallations, this.firebaseAbt, this.executor, cacheClient, cacheClient2, cacheClient3, getFetchHandler(cacheClient, configMetadataClient), configGetParameterHandler, configMetadataClient);
        }
        return firebaseRemoteConfig;
    }

    public final synchronized ConfigFetchHandler getFetchHandler(ConfigCacheClient configCacheClient, ConfigMetadataClient configMetadataClient) {
        FirebaseInstallationsApi firebaseInstallationsApi;
        Provider remoteConfigComponent$$ExternalSyntheticLambda2;
        Provider provider;
        Executor executor;
        Random random;
        String str;
        FirebaseApp firebaseApp;
        firebaseInstallationsApi = this.firebaseInstallations;
        FirebaseApp firebaseApp2 = this.firebaseApp;
        firebaseApp2.checkNotDeleted();
        if (firebaseApp2.name.equals("[DEFAULT]")) {
            remoteConfigComponent$$ExternalSyntheticLambda2 = this.analyticsConnector;
        } else {
            remoteConfigComponent$$ExternalSyntheticLambda2 = new RemoteConfigComponent$$ExternalSyntheticLambda2();
        }
        provider = remoteConfigComponent$$ExternalSyntheticLambda2;
        executor = this.executor;
        random = DEFAULT_RANDOM;
        FirebaseApp firebaseApp3 = this.firebaseApp;
        firebaseApp3.checkNotDeleted();
        str = firebaseApp3.options.apiKey;
        firebaseApp = this.firebaseApp;
        firebaseApp.checkNotDeleted();
        return new ConfigFetchHandler(firebaseInstallationsApi, provider, executor, random, configCacheClient, new ConfigFetchHttpClient(this.context, firebaseApp.options.applicationId, str, configMetadataClient.frcMetadata.getLong("fetch_timeout_in_seconds", 60L), configMetadataClient.frcMetadata.getLong("fetch_timeout_in_seconds", 60L)), configMetadataClient, this.customHeaders);
    }
}
