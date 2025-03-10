package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public abstract class zzl extends zzj {
    public static final WeakReference zza = new WeakReference(null);
    public WeakReference zzb;

    public zzl(byte[] bArr) {
        super(bArr);
        this.zzb = zza;
    }

    public abstract byte[] zzb();

    @Override // com.google.android.gms.common.zzj
    public final byte[] zzf() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.zzb.get();
            if (bArr == null) {
                bArr = zzb();
                this.zzb = new WeakReference(bArr);
            }
        }
        return bArr;
    }
}
