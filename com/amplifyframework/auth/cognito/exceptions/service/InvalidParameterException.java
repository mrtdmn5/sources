package com.amplifyframework.auth.cognito.exceptions.service;

import com.amplifyframework.auth.exceptions.ServiceException;

/* compiled from: InvalidParameterException.kt */
/* loaded from: classes.dex */
public class InvalidParameterException extends ServiceException {
    public InvalidParameterException(Throwable th) {
        super("One or more parameters are incorrect.", "Enter correct parameters.", th);
    }
}
