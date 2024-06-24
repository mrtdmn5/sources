package com.amplifyframework.auth.cognito.exceptions.service;

import com.amplifyframework.auth.exceptions.ServiceException;

/* compiled from: UsernameExistsException.kt */
/* loaded from: classes.dex */
public class UsernameExistsException extends ServiceException {
    public UsernameExistsException(Throwable th) {
        super("Username already exists in the system.", "Retry operation and enter another username.", th);
    }
}
