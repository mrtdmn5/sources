package com.google.android.gms.internal.base;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public class zaa implements IInterface {
    public final IBinder zaa;
    public final String zab;

    public zaa(IBinder iBinder, String str) {
        this.zaa = iBinder;
        this.zab = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.zaa;
    }
}
