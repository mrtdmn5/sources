package com.google.firebase.remoteconfig.internal;

import android.util.Log;
import com.amazonaws.services.s3.internal.Constants;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.zzw;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import org.json.JSONException;

/* loaded from: classes3.dex */
public final class ConfigGetParameterHandler {
    public static final Pattern FALSE_REGEX;
    public static final Pattern TRUE_REGEX;
    public final ConfigCacheClient activatedConfigsCache;
    public final ConfigCacheClient defaultConfigsCache;
    public final Executor executor;
    public final HashSet listeners = new HashSet();

    static {
        Charset.forName(Constants.DEFAULT_ENCODING);
        TRUE_REGEX = Pattern.compile("^(1|true|t|yes|y|on)$", 2);
        FALSE_REGEX = Pattern.compile("^(0|false|f|no|n|off|)$", 2);
    }

    public ConfigGetParameterHandler(Executor executor, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2) {
        this.executor = executor;
        this.activatedConfigsCache = configCacheClient;
        this.defaultConfigsCache = configCacheClient2;
    }

    public static ConfigContainer getConfigsFromCache(ConfigCacheClient configCacheClient) {
        synchronized (configCacheClient) {
            zzw zzwVar = configCacheClient.cachedContainerTask;
            if (zzwVar != null && zzwVar.isSuccessful()) {
                return (ConfigContainer) configCacheClient.cachedContainerTask.getResult();
            }
            try {
                return (ConfigContainer) ConfigCacheClient.await(configCacheClient.get(), TimeUnit.SECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                Log.d("FirebaseRemoteConfig", "Reading from storage file failed.", e);
                return null;
            }
        }
    }

    public static String getStringFromCache(ConfigCacheClient configCacheClient, String str) {
        ConfigContainer configsFromCache = getConfigsFromCache(configCacheClient);
        if (configsFromCache == null) {
            return null;
        }
        try {
            return configsFromCache.configsJson.getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final void callListeners(final ConfigContainer configContainer, final String str) {
        if (configContainer == null) {
            return;
        }
        synchronized (this.listeners) {
            Iterator it = this.listeners.iterator();
            while (it.hasNext()) {
                final BiConsumer biConsumer = (BiConsumer) it.next();
                this.executor.execute(new Runnable() { // from class: com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        BiConsumer.this.accept(str, configContainer);
                    }
                });
            }
        }
    }
}
