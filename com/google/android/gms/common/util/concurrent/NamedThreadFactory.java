package com.google.android.gms.common.util.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class NamedThreadFactory implements ThreadFactory {
    public final String zza;
    public final ThreadFactory zzb = Executors.defaultThreadFactory();

    public NamedThreadFactory(String str) {
        this.zza = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.zzb.newThread(new zza(runnable));
        newThread.setName(this.zza);
        return newThread;
    }
}
