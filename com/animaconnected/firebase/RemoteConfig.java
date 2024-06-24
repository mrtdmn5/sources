package com.animaconnected.firebase;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.text.format.DateUtils;
import android.util.Log;
import androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda0;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.abt.AbtException;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.concurrent.FirebaseExecutors$DirectExecutor;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda1;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigFetchThrottledException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import com.google.firebase.remoteconfig.internal.ConfigStorageClient;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: RemoteConfig.kt */
/* loaded from: classes.dex */
public final class RemoteConfig {
    private static final int CACHE_EXPIRATION_DEV_MODE_MAX = 43200;
    private static final boolean DEBUG = false;
    private static RemoteConfig sRemoteConfig;
    private long cacheExpirationTime;
    private final int defaultXmlResource;
    private final Set<RemoteConfigListener> listeners;
    private final FirebaseRemoteConfig remoteConfig;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "RemoteConfig";

    /* compiled from: RemoteConfig.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isDebugEnabled(long j) {
            if (j < 43200) {
                return true;
            }
            return false;
        }

        public final RemoteConfig getInstance(int r3) {
            RemoteConfig remoteConfig = RemoteConfig.sRemoteConfig;
            if (remoteConfig == null) {
                RemoteConfig remoteConfig2 = new RemoteConfig(r3, null);
                RemoteConfig.sRemoteConfig = remoteConfig2;
                return remoteConfig2;
            }
            return remoteConfig;
        }

        private Companion() {
        }
    }

    public /* synthetic */ RemoteConfig(int r1, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetch$lambda$0(RemoteConfig this$0, Task task) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            Log.d(TAG, "Completed fetching new config");
            final FirebaseRemoteConfig firebaseRemoteConfig = this$0.remoteConfig;
            final Task<ConfigContainer> task2 = firebaseRemoteConfig.fetchedConfigsCache.get();
            final Task<ConfigContainer> task3 = firebaseRemoteConfig.activatedConfigsCache.get();
            Tasks.whenAllComplete(task2, task3).continueWithTask(firebaseRemoteConfig.executor, new Continuation() { // from class: com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda3
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task4) {
                    boolean z;
                    final FirebaseRemoteConfig firebaseRemoteConfig2 = FirebaseRemoteConfig.this;
                    firebaseRemoteConfig2.getClass();
                    Task task5 = task2;
                    if (task5.isSuccessful() && task5.getResult() != null) {
                        ConfigContainer configContainer = (ConfigContainer) task5.getResult();
                        Task task6 = task3;
                        if (task6.isSuccessful()) {
                            ConfigContainer configContainer2 = (ConfigContainer) task6.getResult();
                            if (configContainer2 != null && configContainer.fetchTime.equals(configContainer2.fetchTime)) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (!z) {
                                return Tasks.forResult(Boolean.FALSE);
                            }
                        }
                        return firebaseRemoteConfig2.activatedConfigsCache.put(configContainer).continueWith(firebaseRemoteConfig2.executor, new Continuation() { // from class: com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda4
                            @Override // com.google.android.gms.tasks.Continuation
                            public final Object then(Task task7) {
                                boolean z2;
                                FirebaseRemoteConfig firebaseRemoteConfig3 = FirebaseRemoteConfig.this;
                                firebaseRemoteConfig3.getClass();
                                if (task7.isSuccessful()) {
                                    ConfigCacheClient configCacheClient = firebaseRemoteConfig3.fetchedConfigsCache;
                                    synchronized (configCacheClient) {
                                        configCacheClient.cachedContainerTask = Tasks.forResult(null);
                                    }
                                    ConfigStorageClient configStorageClient = configCacheClient.storageClient;
                                    synchronized (configStorageClient) {
                                        configStorageClient.context.deleteFile(configStorageClient.fileName);
                                    }
                                    if (task7.getResult() != null) {
                                        JSONArray jSONArray = ((ConfigContainer) task7.getResult()).abtExperiments;
                                        FirebaseABTesting firebaseABTesting = firebaseRemoteConfig3.firebaseAbt;
                                        if (firebaseABTesting != null) {
                                            try {
                                                firebaseABTesting.replaceAllExperiments(FirebaseRemoteConfig.toExperimentInfoMaps(jSONArray));
                                            } catch (AbtException e) {
                                                Log.w("FirebaseRemoteConfig", "Could not update ABT experiments.", e);
                                            } catch (JSONException e2) {
                                                Log.e("FirebaseRemoteConfig", "Could not parse ABT experiments from the JSON response.", e2);
                                            }
                                        }
                                    } else {
                                        Log.e("FirebaseRemoteConfig", "Activated configs written to disk are null.");
                                    }
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                return Boolean.valueOf(z2);
                            }
                        });
                    }
                    return Tasks.forResult(Boolean.FALSE);
                }
            });
        } else {
            Log.d(TAG, "Could not fetch remote config params");
        }
        this$0.onConfigFetched();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetch$lambda$1(RemoteConfig this$0, Exception e) {
        long j;
        int r4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(e, "e");
        ConfigMetadataClient configMetadataClient = this$0.remoteConfig.frcMetadata;
        synchronized (configMetadataClient.frcInfoLock) {
            j = configMetadataClient.frcMetadata.getLong("last_fetch_time_in_millis", -1L);
            r4 = configMetadataClient.frcMetadata.getInt("last_fetch_status", 0);
            int[] r5 = ConfigFetchHandler.BACKOFF_TIME_DURATIONS_IN_MINUTES;
            long j2 = configMetadataClient.frcMetadata.getLong("fetch_timeout_in_seconds", 60L);
            if (j2 >= 0) {
                long j3 = configMetadataClient.frcMetadata.getLong("minimum_fetch_interval_in_seconds", ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS);
                if (j3 < 0) {
                    throw new IllegalArgumentException("Minimum interval between fetches has to be a non-negative number. " + j3 + " is an invalid argument");
                }
            } else {
                throw new IllegalArgumentException(String.format("Fetch connection timeout has to be a non-negative number. %d is an invalid argument", Long.valueOf(j2)));
            }
        }
        String str = TAG;
        Log.d(str, "Failed fetching new config: " + e);
        Log.d(str, "Fetch status: " + r4);
        Log.d(str, "Fetch time: " + j + " ms");
        String message = e.getMessage();
        if (message == null) {
            message = "";
        }
        this$0.onConfigFetchedFailed(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetch$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final RemoteConfig getInstance(int r1) {
        return Companion.getInstance(r1);
    }

    private final void onConfigFetched() {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((RemoteConfigListener) it.next()).onConfigFetched();
        }
    }

    private final void onConfigFetchedFailed(String str) {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((RemoteConfigListener) it.next()).onConfigFetchedFailed(str);
        }
    }

    private final void setConfigSettings(boolean z) {
        FirebaseRemoteConfigSettings.Builder builder = new FirebaseRemoteConfigSettings.Builder();
        if (z) {
            builder.setMinimumFetchIntervalInSeconds(0L);
        }
        final FirebaseRemoteConfig firebaseRemoteConfig = this.remoteConfig;
        final FirebaseRemoteConfigSettings firebaseRemoteConfigSettings = new FirebaseRemoteConfigSettings(builder);
        firebaseRemoteConfig.getClass();
        Tasks.call(firebaseRemoteConfig.executor, new Callable() { // from class: com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                FirebaseRemoteConfig firebaseRemoteConfig2 = FirebaseRemoteConfig.this;
                FirebaseRemoteConfigSettings firebaseRemoteConfigSettings2 = firebaseRemoteConfigSettings;
                ConfigMetadataClient configMetadataClient = firebaseRemoteConfig2.frcMetadata;
                synchronized (configMetadataClient.frcInfoLock) {
                    configMetadataClient.frcMetadata.edit().putLong("fetch_timeout_in_seconds", firebaseRemoteConfigSettings2.fetchTimeoutInSeconds).putLong("minimum_fetch_interval_in_seconds", firebaseRemoteConfigSettings2.minimumFetchInterval).commit();
                }
                return null;
            }
        });
    }

    public final void fetch() {
        setConfigSettings(Companion.isDebugEnabled(this.cacheExpirationTime));
        FirebaseRemoteConfig firebaseRemoteConfig = this.remoteConfig;
        final long j = this.cacheExpirationTime;
        final ConfigFetchHandler configFetchHandler = firebaseRemoteConfig.fetchHandler;
        zzw addOnFailureListener = configFetchHandler.fetchedConfigsCache.get().continueWithTask(configFetchHandler.executor, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.ConfigFetchHandler$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task continueWithTask;
                boolean before;
                final ConfigFetchHandler configFetchHandler2 = ConfigFetchHandler.this;
                configFetchHandler2.getClass();
                final Date date = new Date(System.currentTimeMillis());
                boolean isSuccessful = task.isSuccessful();
                Date date2 = null;
                ConfigMetadataClient configMetadataClient = configFetchHandler2.frcMetadata;
                if (isSuccessful) {
                    configMetadataClient.getClass();
                    Date date3 = new Date(configMetadataClient.frcMetadata.getLong("last_fetch_time_in_millis", -1L));
                    if (date3.equals(ConfigMetadataClient.LAST_FETCH_TIME_NO_FETCH_YET)) {
                        before = false;
                    } else {
                        before = date.before(new Date(TimeUnit.SECONDS.toMillis(j) + date3.getTime()));
                    }
                    if (before) {
                        return Tasks.forResult(new ConfigFetchHandler.FetchResponse(2, null, null));
                    }
                }
                Date date4 = configMetadataClient.getBackoffMetadata().backoffEndTime;
                if (date.before(date4)) {
                    date2 = date4;
                }
                Executor executor = configFetchHandler2.executor;
                if (date2 != null) {
                    String format = String.format("Fetch is throttled. Please wait before calling fetch again: %s", DateUtils.formatElapsedTime(TimeUnit.MILLISECONDS.toSeconds(date2.getTime() - date.getTime())));
                    date2.getTime();
                    continueWithTask = Tasks.forException(new FirebaseRemoteConfigFetchThrottledException(format));
                } else {
                    FirebaseInstallationsApi firebaseInstallationsApi = configFetchHandler2.firebaseInstallations;
                    final zzw id = firebaseInstallationsApi.getId();
                    final zzw token = firebaseInstallationsApi.getToken();
                    continueWithTask = Tasks.whenAllComplete(id, token).continueWithTask(executor, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.ConfigFetchHandler$$ExternalSyntheticLambda1
                        @Override // com.google.android.gms.tasks.Continuation
                        public final Object then(Task task2) {
                            Object onSuccessTask;
                            Date date5 = date;
                            ConfigFetchHandler configFetchHandler3 = ConfigFetchHandler.this;
                            configFetchHandler3.getClass();
                            Task task3 = id;
                            if (!task3.isSuccessful()) {
                                return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation ID for fetch.", task3.getException()));
                            }
                            Task task4 = token;
                            if (!task4.isSuccessful()) {
                                return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation auth token for fetch.", task4.getException()));
                            }
                            try {
                                ConfigFetchHandler.FetchResponse fetchFromBackend = configFetchHandler3.fetchFromBackend((String) task3.getResult(), ((InstallationTokenResult) task4.getResult()).getToken(), date5);
                                if (fetchFromBackend.status != 0) {
                                    onSuccessTask = Tasks.forResult(fetchFromBackend);
                                } else {
                                    onSuccessTask = configFetchHandler3.fetchedConfigsCache.put(fetchFromBackend.fetchedConfigs).onSuccessTask(configFetchHandler3.executor, new Rgb$$ExternalSyntheticLambda0(fetchFromBackend));
                                }
                                return onSuccessTask;
                            } catch (FirebaseRemoteConfigException e) {
                                return Tasks.forException(e);
                            }
                        }
                    });
                }
                return continueWithTask.continueWithTask(executor, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.ConfigFetchHandler$$ExternalSyntheticLambda2
                    @Override // com.google.android.gms.tasks.Continuation
                    public final Object then(Task task2) {
                        ConfigFetchHandler configFetchHandler3 = ConfigFetchHandler.this;
                        Date date5 = date;
                        configFetchHandler3.getClass();
                        if (task2.isSuccessful()) {
                            ConfigMetadataClient configMetadataClient2 = configFetchHandler3.frcMetadata;
                            synchronized (configMetadataClient2.frcInfoLock) {
                                configMetadataClient2.frcMetadata.edit().putInt("last_fetch_status", -1).putLong("last_fetch_time_in_millis", date5.getTime()).apply();
                            }
                        } else {
                            Exception exception = task2.getException();
                            if (exception != null) {
                                if (exception instanceof FirebaseRemoteConfigFetchThrottledException) {
                                    ConfigMetadataClient configMetadataClient3 = configFetchHandler3.frcMetadata;
                                    synchronized (configMetadataClient3.frcInfoLock) {
                                        configMetadataClient3.frcMetadata.edit().putInt("last_fetch_status", 2).apply();
                                    }
                                } else {
                                    ConfigMetadataClient configMetadataClient4 = configFetchHandler3.frcMetadata;
                                    synchronized (configMetadataClient4.frcInfoLock) {
                                        configMetadataClient4.frcMetadata.edit().putInt("last_fetch_status", 1).apply();
                                    }
                                }
                            }
                        }
                        return task2;
                    }
                });
            }
        }).onSuccessTask(FirebaseExecutors$DirectExecutor.INSTANCE, new FirebaseRemoteConfig$$ExternalSyntheticLambda1()).addOnCompleteListener(new OnCompleteListener() { // from class: com.animaconnected.firebase.RemoteConfig$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                RemoteConfig.fetch$lambda$0(RemoteConfig.this, task);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.animaconnected.firebase.RemoteConfig$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                RemoteConfig.fetch$lambda$1(RemoteConfig.this, exc);
            }
        });
        final RemoteConfig$fetch$3 remoteConfig$fetch$3 = new Function1<Void, Unit>() { // from class: com.animaconnected.firebase.RemoteConfig$fetch$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r2) {
                String str;
                str = RemoteConfig.TAG;
                Log.d(str, "Successfully fetched new config");
            }
        };
        addOnFailureListener.addOnSuccessListener(new OnSuccessListener() { // from class: com.animaconnected.firebase.RemoteConfig$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                RemoteConfig.fetch$lambda$2(Function1.this, obj);
            }
        });
    }

    public final List<String> getAllKeys(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        XmlResourceParser xml = context.getResources().getXml(this.defaultXmlResource);
        Intrinsics.checkNotNullExpressionValue(xml, "getXml(...)");
        while (xml.getEventType() != 1) {
            try {
                if (xml.getEventType() == 2 && Intrinsics.areEqual(xml.getName(), TransferTable.COLUMN_KEY)) {
                    String nextText = xml.nextText();
                    Intrinsics.checkNotNullExpressionValue(nextText, "nextText(...)");
                    arrayList.add(nextText);
                }
                xml.next();
            } catch (IOException e) {
                Log.e(TAG, "Failed getting all keys " + e);
            } catch (XmlPullParserException e2) {
                Log.e(TAG, "Failed getting all keys " + e2);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:            if (r3.matcher(r0).matches() != false) goto L19;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean getBoolean(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.google.firebase.remoteconfig.FirebaseRemoteConfig r0 = r6.remoteConfig
            com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler r0 = r0.getHandler
            com.google.firebase.remoteconfig.internal.ConfigCacheClient r1 = r0.activatedConfigsCache
            java.lang.String r2 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.getStringFromCache(r1, r7)
            java.util.regex.Pattern r3 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.FALSE_REGEX
            java.util.regex.Pattern r4 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.TRUE_REGEX
            if (r2 == 0) goto L39
            java.util.regex.Matcher r5 = r4.matcher(r2)
            boolean r5 = r5.matches()
            if (r5 == 0) goto L27
            com.google.firebase.remoteconfig.internal.ConfigContainer r1 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.getConfigsFromCache(r1)
            r0.callListeners(r1, r7)
            goto L4b
        L27:
            java.util.regex.Matcher r2 = r3.matcher(r2)
            boolean r2 = r2.matches()
            if (r2 == 0) goto L39
            com.google.firebase.remoteconfig.internal.ConfigContainer r1 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.getConfigsFromCache(r1)
            r0.callListeners(r1, r7)
            goto L69
        L39:
            com.google.firebase.remoteconfig.internal.ConfigCacheClient r0 = r0.defaultConfigsCache
            java.lang.String r0 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.getStringFromCache(r0, r7)
            if (r0 == 0) goto L58
            java.util.regex.Matcher r1 = r4.matcher(r0)
            boolean r1 = r1.matches()
            if (r1 == 0) goto L4d
        L4b:
            r7 = 1
            goto L6a
        L4d:
            java.util.regex.Matcher r0 = r3.matcher(r0)
            boolean r0 = r0.matches()
            if (r0 == 0) goto L58
            goto L69
        L58:
            java.lang.String r0 = "No value of type '%s' exists for parameter key '%s'."
            java.lang.String r1 = "Boolean"
            java.lang.Object[] r7 = new java.lang.Object[]{r1, r7}
            java.lang.String r7 = java.lang.String.format(r0, r7)
            java.lang.String r0 = "FirebaseRemoteConfig"
            android.util.Log.w(r0, r7)
        L69:
            r7 = 0
        L6a:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.firebase.RemoteConfig.getBoolean(java.lang.String):boolean");
    }

    public final long getCacheExpirationTime() {
        return this.cacheExpirationTime;
    }

    public final String[] getList(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (String[]) StringsKt__StringsKt.split$default(getString(key), new String[]{","}, 0, 6).toArray(new String[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long getLong(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.google.firebase.remoteconfig.FirebaseRemoteConfig r0 = r6.remoteConfig
            com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler r0 = r0.getHandler
            com.google.firebase.remoteconfig.internal.ConfigCacheClient r1 = r0.activatedConfigsCache
            com.google.firebase.remoteconfig.internal.ConfigContainer r2 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.getConfigsFromCache(r1)
            r3 = 0
            if (r2 != 0) goto L14
        L12:
            r2 = r3
            goto L1e
        L14:
            org.json.JSONObject r2 = r2.configsJson     // Catch: org.json.JSONException -> L12
            long r4 = r2.getLong(r7)     // Catch: org.json.JSONException -> L12
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch: org.json.JSONException -> L12
        L1e:
            if (r2 == 0) goto L2c
            com.google.firebase.remoteconfig.internal.ConfigContainer r1 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.getConfigsFromCache(r1)
            r0.callListeners(r1, r7)
            long r0 = r2.longValue()
            goto L59
        L2c:
            com.google.firebase.remoteconfig.internal.ConfigCacheClient r0 = r0.defaultConfigsCache
            com.google.firebase.remoteconfig.internal.ConfigContainer r0 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.getConfigsFromCache(r0)
            if (r0 != 0) goto L35
            goto L3f
        L35:
            org.json.JSONObject r0 = r0.configsJson     // Catch: org.json.JSONException -> L3f
            long r0 = r0.getLong(r7)     // Catch: org.json.JSONException -> L3f
            java.lang.Long r3 = java.lang.Long.valueOf(r0)     // Catch: org.json.JSONException -> L3f
        L3f:
            if (r3 == 0) goto L46
            long r0 = r3.longValue()
            goto L59
        L46:
            java.lang.String r0 = "No value of type '%s' exists for parameter key '%s'."
            java.lang.String r1 = "Long"
            java.lang.Object[] r7 = new java.lang.Object[]{r1, r7}
            java.lang.String r7 = java.lang.String.format(r0, r7)
            java.lang.String r0 = "FirebaseRemoteConfig"
            android.util.Log.w(r0, r7)
            r0 = 0
        L59:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.firebase.RemoteConfig.getLong(java.lang.String):long");
    }

    public final <T> T getObject(String key, Class<T> cls) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            return (T) new Gson().fromJson(getString(key), (Class) cls);
        } catch (JsonSyntaxException unused) {
            return null;
        }
    }

    public final String getString(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        ConfigGetParameterHandler configGetParameterHandler = this.remoteConfig.getHandler;
        ConfigCacheClient configCacheClient = configGetParameterHandler.activatedConfigsCache;
        String stringFromCache = ConfigGetParameterHandler.getStringFromCache(configCacheClient, key);
        if (stringFromCache != null) {
            configGetParameterHandler.callListeners(ConfigGetParameterHandler.getConfigsFromCache(configCacheClient), key);
            return stringFromCache;
        }
        String stringFromCache2 = ConfigGetParameterHandler.getStringFromCache(configGetParameterHandler.defaultConfigsCache, key);
        if (stringFromCache2 == null) {
            Log.w("FirebaseRemoteConfig", String.format("No value of type '%s' exists for parameter key '%s'.", "String", key));
            return "";
        }
        return stringFromCache2;
    }

    public final void registerListener(RemoteConfigListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
        listener.onConfigFetched();
    }

    public final void setCacheExpirationTime(long j) {
        this.cacheExpirationTime = j;
    }

    public final void unregisterListener(RemoteConfigListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00af A[Catch: IOException -> 0x00b8, IOException | XmlPullParserException -> 0x00ba, TryCatch #3 {IOException | XmlPullParserException -> 0x00ba, blocks: (B:3:0x0032, B:5:0x0038, B:15:0x003f, B:20:0x0050, B:22:0x00b3, B:25:0x0059, B:29:0x0069, B:31:0x006d, B:37:0x007b, B:45:0x00a4, B:47:0x00aa, B:49:0x00af, B:51:0x008a, B:54:0x0095), top: B:2:0x0032 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private RemoteConfig(int r11) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.firebase.RemoteConfig.<init>(int):void");
    }

    public final <T> T getObject(String key, Type type) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            return (T) new Gson().fromJson(getString(key), type);
        } catch (JsonSyntaxException unused) {
            return null;
        }
    }
}
