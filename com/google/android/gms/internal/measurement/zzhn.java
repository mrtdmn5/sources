package com.google.android.gms.internal.measurement;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzhn {
    public static zzhn zza;
    public final Context zzb;
    public final zzhm zzc;

    public zzhn() {
        this.zzb = null;
        this.zzc = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x003b, code lost:            if (r6.isUserRunning(android.os.Process.myUserHandle()) == false) goto L26;     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003d, code lost:            r0 = true;     */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.google.android.gms.internal.measurement.zzhl] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String zzc(final java.lang.String r10) {
        /*
            r9 = this;
            android.content.Context r0 = r9.zzb
            r1 = 0
            if (r0 == 0) goto L91
            boolean r2 = com.google.android.gms.internal.measurement.zzhb.zzb
            r3 = 0
            if (r2 == 0) goto Lb
            goto L59
        Lb:
            java.lang.Class<com.google.android.gms.internal.measurement.zzhb> r2 = com.google.android.gms.internal.measurement.zzhb.class
            monitor-enter(r2)
            boolean r4 = com.google.android.gms.internal.measurement.zzhb.zzb     // Catch: java.lang.Throwable -> L8e
            if (r4 == 0) goto L14
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L8e
            goto L59
        L14:
            r4 = 1
            r5 = r4
        L16:
            r6 = 2
            if (r5 > r6) goto L4c
            android.os.UserManager r6 = com.google.android.gms.internal.measurement.zzhb.zza     // Catch: java.lang.Throwable -> L8e
            if (r6 != 0) goto L27
            java.lang.Class<android.os.UserManager> r6 = android.os.UserManager.class
            java.lang.Object r6 = r0.getSystemService(r6)     // Catch: java.lang.Throwable -> L8e
            android.os.UserManager r6 = (android.os.UserManager) r6     // Catch: java.lang.Throwable -> L8e
            com.google.android.gms.internal.measurement.zzhb.zza = r6     // Catch: java.lang.Throwable -> L8e
        L27:
            android.os.UserManager r6 = com.google.android.gms.internal.measurement.zzhb.zza     // Catch: java.lang.Throwable -> L8e
            if (r6 != 0) goto L2d
            r0 = r4
            goto L51
        L2d:
            boolean r7 = r6.isUserUnlocked()     // Catch: java.lang.NullPointerException -> L3f java.lang.Throwable -> L8e
            if (r7 != 0) goto L3d
            android.os.UserHandle r7 = android.os.Process.myUserHandle()     // Catch: java.lang.NullPointerException -> L3f java.lang.Throwable -> L8e
            boolean r0 = r6.isUserRunning(r7)     // Catch: java.lang.NullPointerException -> L3f java.lang.Throwable -> L8e
            if (r0 != 0) goto L4c
        L3d:
            r0 = r4
            goto L4d
        L3f:
            r6 = move-exception
            java.lang.String r7 = "DirectBootUtils"
            java.lang.String r8 = "Failed to check if user is unlocked."
            android.util.Log.w(r7, r8, r6)     // Catch: java.lang.Throwable -> L8e
            com.google.android.gms.internal.measurement.zzhb.zza = r1     // Catch: java.lang.Throwable -> L8e
            int r5 = r5 + 1
            goto L16
        L4c:
            r0 = r3
        L4d:
            if (r0 == 0) goto L51
            com.google.android.gms.internal.measurement.zzhb.zza = r1     // Catch: java.lang.Throwable -> L8e
        L51:
            if (r0 == 0) goto L55
            com.google.android.gms.internal.measurement.zzhb.zzb = r4     // Catch: java.lang.Throwable -> L8e
        L55:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L8e
            if (r0 != 0) goto L59
            r3 = r4
        L59:
            if (r3 == 0) goto L5c
            goto L91
        L5c:
            com.google.android.gms.internal.measurement.zzhl r0 = new com.google.android.gms.internal.measurement.zzhl     // Catch: java.lang.NullPointerException -> L79 java.lang.SecurityException -> L7b java.lang.IllegalStateException -> L7d
            r0.<init>()     // Catch: java.lang.NullPointerException -> L79 java.lang.SecurityException -> L7b java.lang.IllegalStateException -> L7d
            java.lang.Object r0 = r0.zza()     // Catch: java.lang.SecurityException -> L66 java.lang.NullPointerException -> L79 java.lang.IllegalStateException -> L7d
            goto L71
        L66:
            long r2 = android.os.Binder.clearCallingIdentity()     // Catch: java.lang.NullPointerException -> L79 java.lang.SecurityException -> L7b java.lang.IllegalStateException -> L7d
            java.lang.Object r0 = r0.zza()     // Catch: java.lang.Throwable -> L74
            android.os.Binder.restoreCallingIdentity(r2)     // Catch: java.lang.NullPointerException -> L79 java.lang.SecurityException -> L7b java.lang.IllegalStateException -> L7d
        L71:
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.NullPointerException -> L79 java.lang.SecurityException -> L7b java.lang.IllegalStateException -> L7d
            return r0
        L74:
            r0 = move-exception
            android.os.Binder.restoreCallingIdentity(r2)     // Catch: java.lang.NullPointerException -> L79 java.lang.SecurityException -> L7b java.lang.IllegalStateException -> L7d
            throw r0     // Catch: java.lang.NullPointerException -> L79 java.lang.SecurityException -> L7b java.lang.IllegalStateException -> L7d
        L79:
            r0 = move-exception
            goto L7e
        L7b:
            r0 = move-exception
            goto L7e
        L7d:
            r0 = move-exception
        L7e:
            java.lang.String r2 = "GservicesLoader"
            java.lang.String r3 = "Unable to read GServices for: "
            java.lang.String r10 = java.lang.String.valueOf(r10)
            java.lang.String r10 = r3.concat(r10)
            android.util.Log.e(r2, r10, r0)
            return r1
        L8e:
            r10 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L8e
            throw r10
        L91:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhn.zzc(java.lang.String):java.lang.String");
    }

    public zzhn(Context context) {
        this.zzb = context;
        zzhm zzhmVar = new zzhm();
        this.zzc = zzhmVar;
        context.getContentResolver().registerContentObserver(zzha.zza, true, zzhmVar);
    }
}
