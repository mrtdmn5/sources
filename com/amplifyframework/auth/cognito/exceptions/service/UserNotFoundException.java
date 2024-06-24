package com.amplifyframework.auth.cognito.exceptions.service;

import com.amplifyframework.auth.exceptions.ServiceException;

/* compiled from: UserNotFoundException.kt */
/* loaded from: classes.dex */
public class UserNotFoundException extends ServiceException {
    public UserNotFoundException(Throwable th) {
        super("User not found in the system.", "Please enter correct username.", th);
    }
}
