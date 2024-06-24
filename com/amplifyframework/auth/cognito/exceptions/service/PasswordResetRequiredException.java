package com.amplifyframework.auth.cognito.exceptions.service;

import com.amplifyframework.auth.exceptions.ServiceException;

/* compiled from: PasswordResetRequiredException.kt */
/* loaded from: classes.dex */
public class PasswordResetRequiredException extends ServiceException {
    public PasswordResetRequiredException(Throwable th) {
        super("Required to reset the password of the user.", "Reset the password of the user.", th);
    }
}
