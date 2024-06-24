package com.animaconnected.watch;

import com.animaconnected.watch.device.CrashStatus;

/* compiled from: Watch.kt */
/* loaded from: classes3.dex */
public final class WatchKt {
    public static final /* synthetic */ String access$getSha1(CrashStatus crashStatus) {
        return getSha1(crashStatus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0052, code lost:            if (r4 == null) goto L16;     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002b, code lost:            if (r4 == null) goto L8;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String getSha1(com.animaconnected.watch.device.CrashStatus r4) {
        /*
            java.lang.String r0 = r4.getType()
            java.lang.String r1 = "id_apperror"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            java.lang.String r1 = "N/A"
            if (r0 == 0) goto L2e
            com.animaconnected.watch.device.CrashStatus$Registers r4 = r4.getRegisters()
            if (r4 == 0) goto L2d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r2 = r4.getPc()
            r0.append(r2)
            int r4 = r4.getLr()
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            if (r4 != 0) goto L55
        L2d:
            return r1
        L2e:
            com.animaconnected.watch.device.CrashStatus$AppInfo r4 = r4.getAppInfo()
            if (r4 == 0) goto L60
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r4.getFilename()
            r0.append(r2)
            int r2 = r4.getLineNumber()
            r0.append(r2)
            long r2 = r4.getErrorCode()
            r0.append(r2)
            java.lang.String r4 = r0.toString()
            if (r4 != 0) goto L55
            goto L60
        L55:
            com.animaconnected.watch.ServiceLocator r0 = com.animaconnected.watch.ServiceLocator.INSTANCE
            com.animaconnected.watch.device.CrashBackend r0 = r0.getCrashBackend()
            java.lang.String r4 = r0.calculateSha1(r4)
            return r4
        L60:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.WatchKt.getSha1(com.animaconnected.watch.device.CrashStatus):java.lang.String");
    }
}
