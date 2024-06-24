package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcr;
import com.google.android.gms.internal.measurement.zzef;
import com.google.android.gms.measurement.internal.zzhy;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.2.0 */
/* loaded from: classes3.dex */
public final class FirebaseAnalytics {
    public static volatile FirebaseAnalytics zza;
    public final zzef zzb;

    public FirebaseAnalytics(zzef zzefVar) {
        Preconditions.checkNotNull(zzefVar);
        this.zzb = zzefVar;
    }

    @Keep
    public static FirebaseAnalytics getInstance(Context context) {
        if (zza == null) {
            synchronized (FirebaseAnalytics.class) {
                if (zza == null) {
                    zza = new FirebaseAnalytics(zzef.zzg(context, null));
                }
            }
        }
        return zza;
    }

    @Keep
    public static zzhy getScionFrontendApiImplementation(Context context, Bundle bundle) {
        zzef zzg = zzef.zzg(context, bundle);
        if (zzg == null) {
            return null;
        }
        return new zzd(zzg);
    }

    @Keep
    public String getFirebaseInstanceId() {
        try {
            Object obj = FirebaseInstallations.lockGenerateFid;
            return (String) Tasks.await(((FirebaseInstallations) FirebaseApp.getInstance().get(FirebaseInstallationsApi.class)).getId(), 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        } catch (ExecutionException e2) {
            throw new IllegalStateException(e2.getCause());
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
    }

    @Keep
    @Deprecated
    public void setCurrentScreen(Activity activity, String str, String str2) {
        zzef zzefVar = this.zzb;
        zzefVar.getClass();
        zzefVar.zzV(new zzcr(zzefVar, activity, str, str2));
    }
}
