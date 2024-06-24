package com.google.android.gms.internal.measurement;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HeightInLinesModifierKt$$ExternalSyntheticOutline0;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zziy extends zzjb {
    public final int zzc;

    public zziy(byte[] bArr, int r3) {
        super(bArr);
        zzje.zzj(0, r3, bArr.length);
        this.zzc = r3;
    }

    @Override // com.google.android.gms.internal.measurement.zzjb, com.google.android.gms.internal.measurement.zzje
    public final byte zza(int r5) {
        int r1 = this.zzc;
        if (((r1 - (r5 + 1)) | r5) < 0) {
            if (r5 < 0) {
                throw new ArrayIndexOutOfBoundsException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Index < 0: ", r5));
            }
            throw new ArrayIndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("Index > length: ", r5, ", ", r1));
        }
        return this.zza[r5];
    }

    @Override // com.google.android.gms.internal.measurement.zzjb, com.google.android.gms.internal.measurement.zzje
    public final byte zzb(int r2) {
        return this.zza[r2];
    }

    @Override // com.google.android.gms.internal.measurement.zzjb, com.google.android.gms.internal.measurement.zzje
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzjb
    public final void zzc() {
    }
}
