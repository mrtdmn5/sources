package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzcx extends zzdu {
    public final /* synthetic */ String zza = null;
    public final /* synthetic */ String zzb = null;
    public final /* synthetic */ Context zzc;
    public final /* synthetic */ Bundle zzd;
    public final /* synthetic */ zzef zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcx(zzef zzefVar, Context context, Bundle bundle) {
        super(zzefVar, true);
        this.zze = zzefVar;
        this.zzc = context;
        this.zzd = bundle;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:2|3|(4:6|7|8|(8:10|11|(1:13)(1:31)|14|15|16|17|(2:19|20)(4:22|(1:24)(1:27)|25|26)))|34|11|(0)(0)|14|15|16|17|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0053, code lost:            r5 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0054, code lost:            r3.zzT(r5, true, false);     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0027 A[Catch: Exception -> 0x00a4, TRY_ENTER, TryCatch #2 {Exception -> 0x00a4, blocks: (B:3:0x0004, B:7:0x0011, B:13:0x0027, B:14:0x0036, B:16:0x0042, B:17:0x0057, B:19:0x005f, B:22:0x0069, B:25:0x007e, B:30:0x0054), top: B:2:0x0004, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f A[Catch: Exception -> 0x00a4, TryCatch #2 {Exception -> 0x00a4, blocks: (B:3:0x0004, B:7:0x0011, B:13:0x0027, B:14:0x0036, B:16:0x0042, B:17:0x0057, B:19:0x005f, B:22:0x0069, B:25:0x007e, B:30:0x0054), top: B:2:0x0004, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0069 A[Catch: Exception -> 0x00a4, TryCatch #2 {Exception -> 0x00a4, blocks: (B:3:0x0004, B:7:0x0011, B:13:0x0027, B:14:0x0036, B:16:0x0042, B:17:0x0057, B:19:0x005f, B:22:0x0069, B:25:0x007e, B:30:0x0054), top: B:2:0x0004, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0033  */
    @Override // com.google.android.gms.internal.measurement.zzdu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza() {
        /*
            r14 = this;
            java.lang.String r0 = "com.google.android.gms.measurement.dynamite"
            r1 = 1
            r2 = 0
            com.google.android.gms.internal.measurement.zzef r3 = r14.zze     // Catch: java.lang.Exception -> La4
            java.lang.String r4 = r14.zza     // Catch: java.lang.Exception -> La4
            java.lang.String r5 = r14.zzb     // Catch: java.lang.Exception -> La4
            r3.getClass()     // Catch: java.lang.Exception -> La4
            if (r5 == 0) goto L23
            if (r4 == 0) goto L23
            java.lang.String r3 = "com.google.firebase.analytics.FirebaseAnalytics"
            java.lang.Class<com.google.android.gms.internal.measurement.zzef> r4 = com.google.android.gms.internal.measurement.zzef.class
            java.lang.ClassLoader r4 = r4.getClassLoader()     // Catch: java.lang.ClassNotFoundException -> L1e java.lang.Exception -> La4
            java.lang.Class.forName(r3, r2, r4)     // Catch: java.lang.ClassNotFoundException -> L1e java.lang.Exception -> La4
            r3 = r1
            goto L1f
        L1e:
            r3 = r2
        L1f:
            if (r3 != 0) goto L23
            r3 = r1
            goto L24
        L23:
            r3 = r2
        L24:
            r4 = 0
            if (r3 == 0) goto L33
            java.lang.String r3 = r14.zzb     // Catch: java.lang.Exception -> La4
            java.lang.String r5 = r14.zza     // Catch: java.lang.Exception -> La4
            com.google.android.gms.internal.measurement.zzef r6 = r14.zze     // Catch: java.lang.Exception -> La4
            java.lang.String r6 = r6.zzd     // Catch: java.lang.Exception -> La4
            r11 = r3
            r10 = r5
            r9 = r6
            goto L36
        L33:
            r9 = r4
            r10 = r9
            r11 = r10
        L36:
            android.content.Context r3 = r14.zzc     // Catch: java.lang.Exception -> La4
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch: java.lang.Exception -> La4
            com.google.android.gms.internal.measurement.zzef r3 = r14.zze     // Catch: java.lang.Exception -> La4
            android.content.Context r5 = r14.zzc     // Catch: java.lang.Exception -> La4
            r3.getClass()     // Catch: java.lang.Exception -> La4
            com.google.android.gms.dynamite.zzi r6 = com.google.android.gms.dynamite.DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION     // Catch: com.google.android.gms.dynamite.DynamiteModule.LoadingException -> L53 java.lang.Exception -> La4
            com.google.android.gms.dynamite.DynamiteModule r5 = com.google.android.gms.dynamite.DynamiteModule.load(r5, r6, r0)     // Catch: com.google.android.gms.dynamite.DynamiteModule.LoadingException -> L53 java.lang.Exception -> La4
            java.lang.String r6 = "com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"
            android.os.IBinder r5 = r5.instantiate(r6)     // Catch: com.google.android.gms.dynamite.DynamiteModule.LoadingException -> L53 java.lang.Exception -> La4
            com.google.android.gms.internal.measurement.zzcc r4 = com.google.android.gms.internal.measurement.zzcb.asInterface(r5)     // Catch: com.google.android.gms.dynamite.DynamiteModule.LoadingException -> L53 java.lang.Exception -> La4
            goto L57
        L53:
            r5 = move-exception
            r3.zzT(r5, r1, r2)     // Catch: java.lang.Exception -> La4
        L57:
            r3.zzj = r4     // Catch: java.lang.Exception -> La4
            com.google.android.gms.internal.measurement.zzef r3 = r14.zze     // Catch: java.lang.Exception -> La4
            com.google.android.gms.internal.measurement.zzcc r3 = r3.zzj     // Catch: java.lang.Exception -> La4
            if (r3 != 0) goto L69
            com.google.android.gms.internal.measurement.zzef r0 = r14.zze     // Catch: java.lang.Exception -> La4
            java.lang.String r0 = r0.zzd     // Catch: java.lang.Exception -> La4
            java.lang.String r3 = "Failed to connect to measurement client."
            android.util.Log.w(r0, r3)     // Catch: java.lang.Exception -> La4
            return
        L69:
            android.content.Context r3 = r14.zzc     // Catch: java.lang.Exception -> La4
            int r3 = com.google.android.gms.dynamite.DynamiteModule.getLocalVersion(r3, r0)     // Catch: java.lang.Exception -> La4
            android.content.Context r4 = r14.zzc     // Catch: java.lang.Exception -> La4
            int r0 = com.google.android.gms.dynamite.DynamiteModule.zza(r4, r0, r2)     // Catch: java.lang.Exception -> La4
            int r4 = java.lang.Math.max(r3, r0)     // Catch: java.lang.Exception -> La4
            if (r0 >= r3) goto L7d
            r8 = r1
            goto L7e
        L7d:
            r8 = r2
        L7e:
            com.google.android.gms.internal.measurement.zzcl r0 = new com.google.android.gms.internal.measurement.zzcl     // Catch: java.lang.Exception -> La4
            long r6 = (long) r4     // Catch: java.lang.Exception -> La4
            r4 = 74029(0x1212d, double:3.6575E-319)
            android.os.Bundle r12 = r14.zzd     // Catch: java.lang.Exception -> La4
            android.content.Context r3 = r14.zzc     // Catch: java.lang.Exception -> La4
            java.lang.String r13 = com.google.android.gms.measurement.internal.zzfj.zza(r3)     // Catch: java.lang.Exception -> La4
            r3 = r0
            r3.<init>(r4, r6, r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Exception -> La4
            com.google.android.gms.internal.measurement.zzef r3 = r14.zze     // Catch: java.lang.Exception -> La4
            com.google.android.gms.internal.measurement.zzcc r3 = r3.zzj     // Catch: java.lang.Exception -> La4
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch: java.lang.Exception -> La4
            android.content.Context r4 = r14.zzc     // Catch: java.lang.Exception -> La4
            com.google.android.gms.dynamic.ObjectWrapper r5 = new com.google.android.gms.dynamic.ObjectWrapper     // Catch: java.lang.Exception -> La4
            r5.<init>(r4)     // Catch: java.lang.Exception -> La4
            long r6 = r14.zzh     // Catch: java.lang.Exception -> La4
            r3.initialize(r5, r0, r6)     // Catch: java.lang.Exception -> La4
            return
        La4:
            r0 = move-exception
            com.google.android.gms.internal.measurement.zzef r3 = r14.zze
            r3.zzT(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzcx.zza():void");
    }
}
