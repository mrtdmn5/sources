package com.google.android.gms.common;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzk extends zzj {
    public final byte[] zza;

    public zzk(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.zza = bArr;
    }

    @Override // com.google.android.gms.common.zzj
    public final byte[] zzf() {
        return this.zza;
    }
}
