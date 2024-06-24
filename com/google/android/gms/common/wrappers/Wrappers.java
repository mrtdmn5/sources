package com.google.android.gms.common.wrappers;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class Wrappers {
    public static final Wrappers zza = new Wrappers();
    public PackageManagerWrapper zzb = null;

    public static PackageManagerWrapper packageManager(Context context) {
        PackageManagerWrapper packageManagerWrapper;
        Wrappers wrappers = zza;
        synchronized (wrappers) {
            if (wrappers.zzb == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                wrappers.zzb = new PackageManagerWrapper(context);
            }
            packageManagerWrapper = wrappers.zzb;
        }
        return packageManagerWrapper;
    }
}
