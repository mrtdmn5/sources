package com.amplifyframework.auth.cognito.exceptions.service;

import com.amplifyframework.auth.exceptions.ServiceException;

/* compiled from: CodeExpiredException.kt */
/* loaded from: classes.dex */
public class CodeExpiredException extends ServiceException {
    public CodeExpiredException(Throwable th) {
        super("Confirmation code has expired.", "Resend a new confirmation code and then retry operation with it.", th);
    }
}
