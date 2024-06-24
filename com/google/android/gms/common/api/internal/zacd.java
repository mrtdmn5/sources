package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.OnCompleteListener;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zacd implements OnCompleteListener {
    public final GoogleApiManager zaa;
    public final int zab;
    public final ApiKey zac;
    public final long zad;
    public final long zae;

    public zacd(GoogleApiManager googleApiManager, int r2, ApiKey apiKey, long j, long j2) {
        this.zaa = googleApiManager;
        this.zab = r2;
        this.zac = apiKey;
        this.zad = j;
        this.zae = j2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0027, code lost:            if (r2 != false) goto L33;     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0037, code lost:            if (r2 == false) goto L33;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.common.internal.ConnectionTelemetryConfiguration zab(com.google.android.gms.common.api.internal.zabq r7, com.google.android.gms.common.internal.BaseGmsClient r8, int r9) {
        /*
            com.google.android.gms.common.internal.zzj r8 = r8.zzD
            r0 = 0
            if (r8 != 0) goto L7
            r8 = r0
            goto L9
        L7:
            com.google.android.gms.common.internal.ConnectionTelemetryConfiguration r8 = r8.zzd
        L9:
            if (r8 == 0) goto L41
            boolean r1 = r8.zzb
            if (r1 == 0) goto L41
            int[] r1 = r8.zzd
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L2a
            int[] r1 = r8.zzf
            if (r1 != 0) goto L1a
            goto L3a
        L1a:
            int r4 = r1.length
            r5 = r2
        L1c:
            if (r5 >= r4) goto L27
            r6 = r1[r5]
            if (r6 != r9) goto L24
            r2 = r3
            goto L27
        L24:
            int r5 = r5 + 1
            goto L1c
        L27:
            if (r2 == 0) goto L3a
            goto L41
        L2a:
            int r4 = r1.length
            r5 = r2
        L2c:
            if (r5 >= r4) goto L37
            r6 = r1[r5]
            if (r6 != r9) goto L34
            r2 = r3
            goto L37
        L34:
            int r5 = r5 + 1
            goto L2c
        L37:
            if (r2 != 0) goto L3a
            goto L41
        L3a:
            int r7 = r7.zam
            int r9 = r8.zze
            if (r7 >= r9) goto L41
            return r8
        L41:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zacd.zab(com.google.android.gms.common.api.internal.zabq, com.google.android.gms.common.internal.BaseGmsClient, int):com.google.android.gms.common.internal.ConnectionTelemetryConfiguration");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007d  */
    @Override // com.google.android.gms.tasks.OnCompleteListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onComplete(com.google.android.gms.tasks.Task r26) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zacd.onComplete(com.google.android.gms.tasks.Task):void");
    }
}
