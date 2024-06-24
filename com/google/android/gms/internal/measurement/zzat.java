package com.google.android.gms.internal.measurement;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import com.amplifyframework.core.model.ModelIdentifier;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzat implements Iterable, zzap {
    public final String zza;

    public zzat(String str) {
        if (str != null) {
            this.zza = str;
            return;
        }
        throw new IllegalArgumentException("StringValue cannot be null.");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzat)) {
            return false;
        }
        return this.zza.equals(((zzat) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new zzas(this);
    }

    public final String toString() {
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder(ModelIdentifier.Helper.PRIMARY_KEY_ENCAPSULATE_CHAR), this.zza, ModelIdentifier.Helper.PRIMARY_KEY_ENCAPSULATE_CHAR);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x02e4, code lost:            if (r2[r7].isEmpty() == false) goto L138;     */
    /* JADX WARN: Failed to find 'out' block for switch in B:44:0x016e. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0508  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0558  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x059a  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0255  */
    @Override // com.google.android.gms.internal.measurement.zzap
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.measurement.zzap zzbR(java.lang.String r20, com.google.android.gms.internal.measurement.zzg r21, java.util.ArrayList r22) {
        /*
            Method dump skipped, instructions count: 1664
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzat.zzbR(java.lang.String, com.google.android.gms.internal.measurement.zzg, java.util.ArrayList):com.google.android.gms.internal.measurement.zzap");
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzd() {
        return new zzat(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Boolean zzg() {
        return Boolean.valueOf(!this.zza.isEmpty());
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Double zzh() {
        String str = this.zza;
        if (str.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final String zzi() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Iterator zzl() {
        return new zzar(this);
    }
}
