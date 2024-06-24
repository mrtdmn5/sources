package com.amplifyframework.auth.cognito.exceptions.service;

import com.amplifyframework.auth.exceptions.ServiceException;

/* compiled from: InvalidPasswordException.kt */
/* loaded from: classes.dex */
public class InvalidPasswordException extends ServiceException {
    public InvalidPasswordException(Throwable th) {
        super("The password given is invalid.", "Enter correct password.", th);
    }
}
