package com.google.firebase.remoteconfig.internal;

import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigFetchThrottledException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class ConfigFetchHandler {
    public final Provider<AnalyticsConnector> analyticsConnector;
    public final Map<String, String> customHttpHeaders;
    public final Executor executor;
    public final ConfigCacheClient fetchedConfigsCache;
    public final FirebaseInstallationsApi firebaseInstallations;
    public final ConfigFetchHttpClient frcBackendApiClient;
    public final ConfigMetadataClient frcMetadata;
    public final Random randomGenerator;
    public static final long DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS = TimeUnit.HOURS.toSeconds(12);
    public static final int[] BACKOFF_TIME_DURATIONS_IN_MINUTES = {2, 4, 8, 16, 32, 64, 128, 256};

    /* loaded from: classes3.dex */
    public static class FetchResponse {
        public final ConfigContainer fetchedConfigs;
        public final String lastFetchETag;
        public final int status;

        public FetchResponse(int r1, ConfigContainer configContainer, String str) {
            this.status = r1;
            this.fetchedConfigs = configContainer;
            this.lastFetchETag = str;
        }
    }

    public ConfigFetchHandler(FirebaseInstallationsApi firebaseInstallationsApi, Provider provider, Executor executor, Random random, ConfigCacheClient configCacheClient, ConfigFetchHttpClient configFetchHttpClient, ConfigMetadataClient configMetadataClient, HashMap hashMap) {
        this.firebaseInstallations = firebaseInstallationsApi;
        this.analyticsConnector = provider;
        this.executor = executor;
        this.randomGenerator = random;
        this.fetchedConfigsCache = configCacheClient;
        this.frcBackendApiClient = configFetchHttpClient;
        this.frcMetadata = configMetadataClient;
        this.customHttpHeaders = hashMap;
    }

    public final FetchResponse fetchFromBackend(String str, String str2, Date date) throws FirebaseRemoteConfigException {
        boolean z;
        String str3;
        Long l;
        boolean z2 = false;
        try {
            ConfigFetchHttpClient configFetchHttpClient = this.frcBackendApiClient;
            configFetchHttpClient.getClass();
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(String.format("https://firebaseremoteconfig.googleapis.com/v1/projects/%s/namespaces/%s:fetch", configFetchHttpClient.projectNumber, configFetchHttpClient.namespace)).openConnection();
                ConfigFetchHttpClient configFetchHttpClient2 = this.frcBackendApiClient;
                HashMap userProperties = getUserProperties();
                String string = this.frcMetadata.frcMetadata.getString("last_fetch_etag", null);
                Map<String, String> map = this.customHttpHeaders;
                AnalyticsConnector analyticsConnector = this.analyticsConnector.get();
                if (analyticsConnector == null) {
                    l = null;
                } else {
                    l = (Long) analyticsConnector.getUserProperties(true).get("_fot");
                }
                FetchResponse fetch = configFetchHttpClient2.fetch(httpURLConnection, str, str2, userProperties, string, map, l, date);
                String str4 = fetch.lastFetchETag;
                if (str4 != null) {
                    ConfigMetadataClient configMetadataClient = this.frcMetadata;
                    synchronized (configMetadataClient.frcInfoLock) {
                        configMetadataClient.frcMetadata.edit().putString("last_fetch_etag", str4).apply();
                    }
                }
                this.frcMetadata.setBackoffMetadata(0, ConfigMetadataClient.NO_BACKOFF_TIME);
                return fetch;
            } catch (IOException e) {
                throw new FirebaseRemoteConfigException(e.getMessage());
            }
        } catch (FirebaseRemoteConfigServerException e2) {
            int r14 = e2.httpStatusCode;
            if (r14 != 429 && r14 != 502 && r14 != 503 && r14 != 504) {
                z = false;
            } else {
                z = true;
            }
            ConfigMetadataClient configMetadataClient2 = this.frcMetadata;
            if (z) {
                int r142 = configMetadataClient2.getBackoffMetadata().numFailedFetches + 1;
                TimeUnit timeUnit = TimeUnit.MINUTES;
                int[] r5 = BACKOFF_TIME_DURATIONS_IN_MINUTES;
                configMetadataClient2.setBackoffMetadata(r142, new Date(date.getTime() + (timeUnit.toMillis(r5[Math.min(r142, r5.length) - 1]) / 2) + this.randomGenerator.nextInt((int) r4)));
            }
            ConfigMetadataClient.BackoffMetadata backoffMetadata = configMetadataClient2.getBackoffMetadata();
            int r15 = e2.httpStatusCode;
            if (backoffMetadata.numFailedFetches > 1 || r15 == 429) {
                z2 = true;
            }
            if (!z2) {
                if (r15 != 401) {
                    if (r15 != 403) {
                        if (r15 != 429) {
                            if (r15 != 500) {
                                switch (r15) {
                                    case 502:
                                    case 503:
                                    case 504:
                                        str3 = "The server is unavailable. Please try again later.";
                                        break;
                                    default:
                                        str3 = "The server returned an unexpected error.";
                                        break;
                                }
                            } else {
                                str3 = "There was an internal server error.";
                            }
                        } else {
                            throw new FirebaseRemoteConfigClientException("The throttled response from the server was not handled correctly by the FRC SDK.");
                        }
                    } else {
                        str3 = "The user is not authorized to access the project. Please make sure you are using the API key that corresponds to your Firebase project.";
                    }
                } else {
                    str3 = "The request did not have the required credentials. Please make sure your google-services.json is valid.";
                }
                throw new FirebaseRemoteConfigServerException(e2.httpStatusCode, "Fetch failed: ".concat(str3), e2);
            }
            backoffMetadata.backoffEndTime.getTime();
            throw new FirebaseRemoteConfigFetchThrottledException();
        }
    }

    public final HashMap getUserProperties() {
        HashMap hashMap = new HashMap();
        AnalyticsConnector analyticsConnector = this.analyticsConnector.get();
        if (analyticsConnector == null) {
            return hashMap;
        }
        for (Map.Entry<String, Object> entry : analyticsConnector.getUserProperties(false).entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue().toString());
        }
        return hashMap;
    }
}
