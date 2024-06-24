package com.google.firebase.messaging;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.util.DebugUtils;
import androidx.profileinstaller.ProfileInstallReceiver$$ExternalSyntheticLambda0;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.cloudmessaging.zzr;
import com.google.android.gms.cloudmessaging.zzs;
import com.google.android.gms.cloudmessaging.zzt;
import com.google.android.gms.cloudmessaging.zzv;
import com.google.android.gms.cloudmessaging.zzz;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

/* loaded from: classes3.dex */
public final class GmsRpc {

    /* renamed from: app */
    public final FirebaseApp f142app;
    public final FirebaseInstallationsApi firebaseInstallations;
    public final Provider<HeartBeatInfo> heartbeatInfo;
    public final Metadata metadata;
    public final Rpc rpc;
    public final Provider<UserAgentPublisher> userAgentPublisher;

    public GmsRpc(FirebaseApp firebaseApp, Metadata metadata, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        firebaseApp.checkNotDeleted();
        Rpc rpc = new Rpc(firebaseApp.applicationContext);
        this.f142app = firebaseApp;
        this.metadata = metadata;
        this.rpc = rpc;
        this.userAgentPublisher = provider;
        this.heartbeatInfo = provider2;
        this.firebaseInstallations = firebaseInstallationsApi;
    }

    public final Task<String> extractResponseWhenComplete(Task<Bundle> task) {
        return task.continueWith(new ProfileInstallReceiver$$ExternalSyntheticLambda0(), new Continuation() { // from class: com.google.firebase.messaging.GmsRpc$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                GmsRpc.this.getClass();
                Bundle bundle = (Bundle) task2.getResult$1();
                if (bundle != null) {
                    String string = bundle.getString("registration_id");
                    if (string != null || (string = bundle.getString("unregistered")) != null) {
                        return string;
                    }
                    String string2 = bundle.getString("error");
                    if (!"RST".equals(string2)) {
                        if (string2 != null) {
                            throw new IOException(string2);
                        }
                        Log.w("FirebaseMessaging", "Unexpected response: " + bundle, new Throwable());
                        throw new IOException("SERVICE_NOT_AVAILABLE");
                    }
                    throw new IOException("INSTANCE_ID_RESET");
                }
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
        });
    }

    public final void setDefaultAttributesToBundle(String str, String str2, Bundle bundle) throws ExecutionException, InterruptedException {
        int r0;
        String str3;
        String str4;
        String str5;
        HeartBeatInfo.HeartBeat heartBeatCode;
        PackageInfo packageInfo;
        bundle.putString("scope", str2);
        bundle.putString("sender", str);
        bundle.putString("subtype", str);
        FirebaseApp firebaseApp = this.f142app;
        firebaseApp.checkNotDeleted();
        bundle.putString("gmp_app_id", firebaseApp.options.applicationId);
        Metadata metadata = this.metadata;
        synchronized (metadata) {
            if (metadata.gmsVersionCode == 0 && (packageInfo = metadata.getPackageInfo("com.google.android.gms")) != null) {
                metadata.gmsVersionCode = packageInfo.versionCode;
            }
            r0 = metadata.gmsVersionCode;
        }
        bundle.putString("gmsv", Integer.toString(r0));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        Metadata metadata2 = this.metadata;
        synchronized (metadata2) {
            if (metadata2.appVersionCode == null) {
                metadata2.populateAppVersionInfo();
            }
            str3 = metadata2.appVersionCode;
        }
        bundle.putString("app_ver", str3);
        Metadata metadata3 = this.metadata;
        synchronized (metadata3) {
            if (metadata3.appVersionName == null) {
                metadata3.populateAppVersionInfo();
            }
            str4 = metadata3.appVersionName;
        }
        bundle.putString("app_ver_name", str4);
        FirebaseApp firebaseApp2 = this.f142app;
        firebaseApp2.checkNotDeleted();
        try {
            str5 = Base64.encodeToString(MessageDigest.getInstance("SHA-1").digest(firebaseApp2.name.getBytes()), 11);
        } catch (NoSuchAlgorithmException unused) {
            str5 = "[HASH-ERROR]";
        }
        bundle.putString("firebase-app-name-hash", str5);
        try {
            String token = ((InstallationTokenResult) Tasks.await(this.firebaseInstallations.getToken())).getToken();
            if (!TextUtils.isEmpty(token)) {
                bundle.putString("Goog-Firebase-Installations-Auth", token);
            } else {
                Log.w("FirebaseMessaging", "FIS auth token is empty");
            }
        } catch (InterruptedException | ExecutionException e) {
            Log.e("FirebaseMessaging", "Failed to get FIS auth token", e);
        }
        bundle.putString("appid", (String) Tasks.await(this.firebaseInstallations.getId()));
        bundle.putString("cliv", "fcm-23.1.2");
        HeartBeatInfo heartBeatInfo = this.heartbeatInfo.get();
        UserAgentPublisher userAgentPublisher = this.userAgentPublisher.get();
        if (heartBeatInfo != null && userAgentPublisher != null && (heartBeatCode = heartBeatInfo.getHeartBeatCode()) != HeartBeatInfo.HeartBeat.NONE) {
            bundle.putString("Firebase-Client-Log-Type", Integer.toString(heartBeatCode.getCode()));
            bundle.putString("Firebase-Client", userAgentPublisher.getUserAgent());
        }
    }

    public final Task<Bundle> startRpc(String str, String str2, final Bundle bundle) {
        int r0;
        int r02;
        PackageInfo packageInfo;
        try {
            setDefaultAttributesToBundle(str, str2, bundle);
            final Rpc rpc = this.rpc;
            zzt zztVar = rpc.zzg;
            synchronized (zztVar) {
                if (zztVar.zzb == 0) {
                    try {
                        packageInfo = Wrappers.packageManager(zztVar.zza).getPackageInfo(0, "com.google.android.gms");
                    } catch (PackageManager.NameNotFoundException e) {
                        String valueOf = String.valueOf(e);
                        StringBuilder sb = new StringBuilder(valueOf.length() + 23);
                        sb.append("Failed to find package ");
                        sb.append(valueOf);
                        Log.w("Metadata", sb.toString());
                        packageInfo = null;
                    }
                    if (packageInfo != null) {
                        zztVar.zzb = packageInfo.versionCode;
                    }
                }
                r0 = zztVar.zzb;
            }
            if (r0 < 12000000) {
                if (rpc.zzg.zzb() != 0) {
                    return rpc.zze(bundle).continueWithTask(zzz.zza, new Continuation() { // from class: com.google.android.gms.cloudmessaging.zzu
                        @Override // com.google.android.gms.tasks.Continuation
                        public final Object then(Task task) {
                            boolean z;
                            Rpc rpc2 = Rpc.this;
                            rpc2.getClass();
                            if (task.isSuccessful()) {
                                Bundle bundle2 = (Bundle) task.getResult();
                                if (bundle2 != null && bundle2.containsKey("google.messenger")) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z) {
                                    return rpc2.zze(bundle).onSuccessTask(zzz.zza, DebugUtils.zza);
                                }
                                return task;
                            }
                            return task;
                        }
                    });
                }
                return Tasks.forException(new IOException("MISSING_INSTANCEID_SERVICE"));
            }
            zzs zzb = zzs.zzb(rpc.zzf);
            synchronized (zzb) {
                r02 = zzb.zze;
                zzb.zze = r02 + 1;
            }
            return zzb.zzg(new zzr(r02, bundle)).continueWith(zzz.zza, zzv.zza);
        } catch (InterruptedException | ExecutionException e2) {
            return Tasks.forException(e2);
        }
    }
}
