package com.amplifyframework.auth.cognito.exceptions.service;

import com.amplifyframework.auth.exceptions.ServiceException;

/* compiled from: HostedUISignOutException.kt */
/* loaded from: classes.dex */
public class HostedUISignOutException extends ServiceException {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public HostedUISignOutException(boolean r7) {
        /*
            r6 = this;
            java.lang.String r1 = "SignOut failed to redirect to the application. Custom Tab authorize cookie may still be valid."
            if (r7 == 0) goto L7
            java.lang.String r7 = "You can retry the Custom Tab Sign Out by launching Custom Tabs with the provided url."
            goto L9
        L7:
            java.lang.String r7 = "Unable to provide retry URL. Please check HostedUI Configuration in amplifyconfiguration.json"
        L9:
            r2 = r7
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.exceptions.service.HostedUISignOutException.<init>(boolean):void");
    }
}
