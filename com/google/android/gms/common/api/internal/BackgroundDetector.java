package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class BackgroundDetector implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    public static final BackgroundDetector zza = new BackgroundDetector();
    public final AtomicBoolean zzb = new AtomicBoolean();
    public final AtomicBoolean zzc = new AtomicBoolean();
    public final ArrayList zzd = new ArrayList();
    public boolean zze = false;

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    /* loaded from: classes3.dex */
    public interface BackgroundStateChangeListener {
        void onBackgroundStateChanged(boolean z);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.zzb.compareAndSet(true, false);
        this.zzc.set(true);
        if (compareAndSet) {
            zza(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.zzb.compareAndSet(true, false);
        this.zzc.set(true);
        if (compareAndSet) {
            zza(false);
        }
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int r3) {
        if (r3 == 20 && this.zzb.compareAndSet(false, true)) {
            this.zzc.set(true);
            zza(true);
        }
    }

    public final void zza(boolean z) {
        synchronized (zza) {
            Iterator it = this.zzd.iterator();
            while (it.hasNext()) {
                ((BackgroundStateChangeListener) it.next()).onBackgroundStateChanged(z);
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
