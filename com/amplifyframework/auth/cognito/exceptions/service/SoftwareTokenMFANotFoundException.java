package com.amplifyframework.auth.cognito.exceptions.service;

import com.amplifyframework.auth.exceptions.ServiceException;

/* compiled from: SoftwareTokenMFANotFoundException.kt */
/* loaded from: classes.dex */
public class SoftwareTokenMFANotFoundException extends ServiceException {
    public SoftwareTokenMFANotFoundException(Throwable th) {
        super("Could not find software token MFA.", "Enable the software token MFA for the user.", th);
    }
}
