package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.util.Base64OutputStream;
import androidx.core.os.UserManagerCompat$Api24Impl;
import com.amazonaws.services.s3.internal.Constants;
import com.animaconnected.firebase.AnalyticsConstants;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class DefaultHeartBeatController implements HeartBeatController, HeartBeatInfo {
    public final Context applicationContext;
    public final Executor backgroundExecutor;
    public final Set<HeartBeatConsumer> consumers;
    public final Provider<HeartBeatInfoStorage> storageProvider;
    public final Provider<UserAgentPublisher> userAgentProvider;

    public DefaultHeartBeatController() {
        throw null;
    }

    public DefaultHeartBeatController(final Context context, final String str, Set<HeartBeatConsumer> set, Provider<UserAgentPublisher> provider, Executor executor) {
        this.storageProvider = new Provider() { // from class: com.google.firebase.heartbeatinfo.DefaultHeartBeatController$$ExternalSyntheticLambda3
            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                return new HeartBeatInfoStorage(context, str);
            }
        };
        this.consumers = set;
        this.backgroundExecutor = executor;
        this.userAgentProvider = provider;
        this.applicationContext = context;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatInfo
    public final synchronized HeartBeatInfo.HeartBeat getHeartBeatCode() {
        boolean shouldSendSdkHeartBeat;
        long currentTimeMillis = System.currentTimeMillis();
        HeartBeatInfoStorage heartBeatInfoStorage = this.storageProvider.get();
        synchronized (heartBeatInfoStorage) {
            shouldSendSdkHeartBeat = heartBeatInfoStorage.shouldSendSdkHeartBeat(currentTimeMillis);
        }
        if (shouldSendSdkHeartBeat) {
            synchronized (heartBeatInfoStorage) {
                String formattedDate = heartBeatInfoStorage.getFormattedDate(System.currentTimeMillis());
                heartBeatInfoStorage.firebaseSharedPreferences.edit().putString("last-used-date", formattedDate).commit();
                heartBeatInfoStorage.removeStoredDate(formattedDate);
            }
            return HeartBeatInfo.HeartBeat.GLOBAL;
        }
        return HeartBeatInfo.HeartBeat.NONE;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatController
    public final zzw getHeartBeatsHeader() {
        if (!UserManagerCompat$Api24Impl.isUserUnlocked(this.applicationContext)) {
            return Tasks.forResult("");
        }
        return Tasks.call(this.backgroundExecutor, new Callable() { // from class: com.google.firebase.heartbeatinfo.DefaultHeartBeatController$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String byteArrayOutputStream;
                DefaultHeartBeatController defaultHeartBeatController = DefaultHeartBeatController.this;
                synchronized (defaultHeartBeatController) {
                    HeartBeatInfoStorage heartBeatInfoStorage = defaultHeartBeatController.storageProvider.get();
                    ArrayList allHeartBeats = heartBeatInfoStorage.getAllHeartBeats();
                    heartBeatInfoStorage.deleteAllHeartBeats();
                    JSONArray jSONArray = new JSONArray();
                    for (int r3 = 0; r3 < allHeartBeats.size(); r3++) {
                        HeartBeatResult heartBeatResult = (HeartBeatResult) allHeartBeats.get(r3);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("agent", heartBeatResult.getUserAgent());
                        jSONObject.put("dates", new JSONArray((Collection) heartBeatResult.getUsedDates()));
                        jSONArray.put(jSONObject);
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("heartbeats", jSONArray);
                    jSONObject2.put(AnalyticsConstants.KEY_VERSION, "2");
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream2, 11);
                    try {
                        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                        try {
                            gZIPOutputStream.write(jSONObject2.toString().getBytes(Constants.DEFAULT_ENCODING));
                            gZIPOutputStream.close();
                            base64OutputStream.close();
                            byteArrayOutputStream = byteArrayOutputStream2.toString(Constants.DEFAULT_ENCODING);
                        } finally {
                        }
                    } finally {
                    }
                }
                return byteArrayOutputStream;
            }
        });
    }

    public final void registerHeartBeat() {
        if (this.consumers.size() <= 0) {
            Tasks.forResult(null);
        } else if (!UserManagerCompat$Api24Impl.isUserUnlocked(this.applicationContext)) {
            Tasks.forResult(null);
        } else {
            Tasks.call(this.backgroundExecutor, new Callable() { // from class: com.google.firebase.heartbeatinfo.DefaultHeartBeatController$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    DefaultHeartBeatController defaultHeartBeatController = DefaultHeartBeatController.this;
                    synchronized (defaultHeartBeatController) {
                        defaultHeartBeatController.storageProvider.get().storeHeartBeat(System.currentTimeMillis(), defaultHeartBeatController.userAgentProvider.get().getUserAgent());
                    }
                    return null;
                }
            });
        }
    }
}
