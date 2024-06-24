package com.google.android.gms.internal.measurement;

import androidx.compose.foundation.text.HeightInLinesModifierKt$$ExternalSyntheticOutline0;
import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public abstract class zzje implements Iterable, Serializable {
    public static final zzjb zzb = new zzjb(zzkn.zzd);
    public int zzc = 0;

    static {
        int r0 = zziq.$r8$clinit;
    }

    public static int zzj(int r3, int r4, int r5) {
        int r0 = r4 - r3;
        if ((r3 | r4 | r0 | (r5 - r4)) < 0) {
            if (r3 >= 0) {
                if (r4 < r3) {
                    throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("Beginning index larger than ending index: ", r3, ", ", r4));
                }
                throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("End index: ", r4, " >= ", r5));
            }
            throw new IndexOutOfBoundsException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Beginning index: ", r3, " < 0"));
        }
        return r0;
    }

    public static zzjb zzl(byte[] bArr, int r4, int r5) {
        zzj(r4, r4 + r5, bArr.length);
        byte[] bArr2 = new byte[r5];
        System.arraycopy(bArr, r4, bArr2, 0, r5);
        return new zzjb(bArr2);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int r0 = this.zzc;
        if (r0 == 0) {
            int zzd = zzd();
            r0 = zze(zzd, zzd);
            if (r0 == 0) {
                r0 = 1;
            }
            this.zzc = r0;
        }
        return r0;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zziv(this);
    }

    public final String toString() {
        String concat;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzd());
        if (zzd() <= 50) {
            concat = zzmm.zza(this);
        } else {
            concat = zzmm.zza(zzf()).concat("...");
        }
        objArr[2] = concat;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int r1);

    public abstract byte zzb(int r1);

    public abstract int zzd();

    public abstract int zze(int r1, int r2);

    public abstract zzjb zzf();

    public abstract String zzg(Charset charset);

    public abstract void zzh(zzjm zzjmVar) throws IOException;

    public abstract boolean zzi();
}
