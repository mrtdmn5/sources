package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public class zza implements IInterface {
    public final IBinder zza;
    public final String zzb;

    public zza(IBinder iBinder, String str) {
        this.zza = iBinder;
        this.zzb = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.zza;
    }
}
