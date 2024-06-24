package com.polidea.rxandroidble2.exceptions;

/* loaded from: classes3.dex */
public class BleConflictingNotificationAlreadySetException extends BleException {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BleConflictingNotificationAlreadySetException(java.util.UUID r3, boolean r4) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Characteristic "
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r3 = " notification already set to "
            r0.append(r3)
            if (r4 == 0) goto L14
            java.lang.String r3 = "indication"
            goto L16
        L14:
            java.lang.String r3 = "notification"
        L16:
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r2.<init>(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.polidea.rxandroidble2.exceptions.BleConflictingNotificationAlreadySetException.<init>(java.util.UUID, boolean):void");
    }
}
