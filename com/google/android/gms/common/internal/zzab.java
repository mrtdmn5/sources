package com.google.android.gms.common.internal;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public abstract class zzab extends com.google.android.gms.internal.common.zzb {
    public zzab() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x004f, code lost:            if (r7.zza >= r5.zza) goto L60;     */
    @Override // com.google.android.gms.internal.common.zzb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zza(int r10, android.os.Parcel r11, android.os.Parcel r12) throws android.os.RemoteException {
        /*
            r9 = this;
            r0 = -1
            r1 = 0
            r2 = 1
            if (r10 == r2) goto L94
            r3 = 2
            if (r10 == r3) goto L79
            r3 = 3
            if (r10 == r3) goto Ld
            r10 = 0
            return r10
        Ld:
            int r10 = r11.readInt()
            android.os.IBinder r3 = r11.readStrongBinder()
            android.os.Parcelable$Creator<com.google.android.gms.common.internal.zzj> r4 = com.google.android.gms.common.internal.zzj.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.common.zzc.zza(r11, r4)
            com.google.android.gms.common.internal.zzj r4 = (com.google.android.gms.common.internal.zzj) r4
            com.google.android.gms.internal.common.zzc.zzb(r11)
            r11 = r9
            com.google.android.gms.common.internal.zzd r11 = (com.google.android.gms.common.internal.zzd) r11
            com.google.android.gms.common.internal.BaseGmsClient r5 = r11.zza
            java.lang.String r6 = "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5, r6)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            r5.zzD = r4
            boolean r5 = r5.usesClientTelemetry()
            if (r5 == 0) goto L58
            com.google.android.gms.common.internal.ConnectionTelemetryConfiguration r5 = r4.zzd
            com.google.android.gms.common.internal.RootTelemetryConfigManager r6 = com.google.android.gms.common.internal.RootTelemetryConfigManager.getInstance()
            if (r5 != 0) goto L3f
            r5 = r1
            goto L41
        L3f:
            com.google.android.gms.common.internal.RootTelemetryConfiguration r5 = r5.zza
        L41:
            monitor-enter(r6)
            if (r5 != 0) goto L47
            com.google.android.gms.common.internal.RootTelemetryConfiguration r5 = com.google.android.gms.common.internal.RootTelemetryConfigManager.zzb     // Catch: java.lang.Throwable -> L55
            goto L51
        L47:
            com.google.android.gms.common.internal.RootTelemetryConfiguration r7 = r6.zzc     // Catch: java.lang.Throwable -> L55
            if (r7 == 0) goto L51
            int r7 = r7.zza     // Catch: java.lang.Throwable -> L55
            int r8 = r5.zza     // Catch: java.lang.Throwable -> L55
            if (r7 >= r8) goto L53
        L51:
            r6.zzc = r5     // Catch: java.lang.Throwable -> L55
        L53:
            monitor-exit(r6)
            goto L58
        L55:
            r10 = move-exception
            monitor-exit(r6)
            throw r10
        L58:
            android.os.Bundle r4 = r4.zza
            com.google.android.gms.common.internal.BaseGmsClient r5 = r11.zza
            java.lang.String r6 = "onPostInitComplete can be called only once per call to getRemoteService"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5, r6)
            com.google.android.gms.common.internal.BaseGmsClient r5 = r11.zza
            r5.getClass()
            com.google.android.gms.common.internal.zzf r6 = new com.google.android.gms.common.internal.zzf
            r6.<init>(r5, r10, r3, r4)
            com.google.android.gms.common.internal.zzb r10 = r5.zzb
            int r3 = r11.zzb
            android.os.Message r0 = r10.obtainMessage(r2, r3, r0, r6)
            r10.sendMessage(r0)
            r11.zza = r1
            goto Lc8
        L79:
            r11.readInt()
            android.os.Parcelable$Creator r10 = android.os.Bundle.CREATOR
            android.os.Parcelable r10 = com.google.android.gms.internal.common.zzc.zza(r11, r10)
            android.os.Bundle r10 = (android.os.Bundle) r10
            com.google.android.gms.internal.common.zzc.zzb(r11)
            java.lang.Exception r10 = new java.lang.Exception
            r10.<init>()
            java.lang.String r11 = "GmsClient"
            java.lang.String r0 = "received deprecated onAccountValidationComplete callback, ignoring"
            android.util.Log.wtf(r11, r0, r10)
            goto Lc8
        L94:
            int r10 = r11.readInt()
            android.os.IBinder r3 = r11.readStrongBinder()
            android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.common.zzc.zza(r11, r4)
            android.os.Bundle r4 = (android.os.Bundle) r4
            com.google.android.gms.internal.common.zzc.zzb(r11)
            r11 = r9
            com.google.android.gms.common.internal.zzd r11 = (com.google.android.gms.common.internal.zzd) r11
            com.google.android.gms.common.internal.BaseGmsClient r5 = r11.zza
            java.lang.String r6 = "onPostInitComplete can be called only once per call to getRemoteService"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5, r6)
            com.google.android.gms.common.internal.BaseGmsClient r5 = r11.zza
            r5.getClass()
            com.google.android.gms.common.internal.zzf r6 = new com.google.android.gms.common.internal.zzf
            r6.<init>(r5, r10, r3, r4)
            com.google.android.gms.common.internal.zzb r10 = r5.zzb
            int r3 = r11.zzb
            android.os.Message r0 = r10.obtainMessage(r2, r3, r0, r6)
            r10.sendMessage(r0)
            r11.zza = r1
        Lc8:
            r12.writeNoException()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzab.zza(int, android.os.Parcel, android.os.Parcel):boolean");
    }
}
