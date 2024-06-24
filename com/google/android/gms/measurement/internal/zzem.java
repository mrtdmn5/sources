package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzem implements Runnable {
    public final /* synthetic */ zzen zza;
    public final URL zzb;
    public final byte[] zzc;
    public final zzej zzd;
    public final String zze;
    public final Map zzf;

    public zzem(zzen zzenVar, String str, URL url, byte[] bArr, ArrayMap arrayMap, zzej zzejVar) {
        this.zza = zzenVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = url;
        this.zzc = bArr;
        this.zzd = zzejVar;
        this.zze = str;
        this.zzf = arrayMap;
    }

    /* JADX WARN: Not initialized variable reg: 13, insn: 0x00f0: MOVE (r10 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY]) (LINE:241), block:B:77:0x00ef */
    /* JADX WARN: Removed duplicated region for block: B:24:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x014a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0116 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzem.run():void");
    }
}
