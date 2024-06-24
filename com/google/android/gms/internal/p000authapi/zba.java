package com.google.android.gms.internal.p000authapi;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-auth@@20.4.0 */
/* loaded from: classes3.dex */
public class zba implements IInterface {
    public final IBinder zba;
    public final String zbb;

    public zba(IBinder iBinder, String str) {
        this.zba = iBinder;
        this.zbb = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.zba;
    }
}
