package com.amplifyframework.auth.cognito.exceptions.service;

import com.amplifyframework.auth.exceptions.ServiceException;

/* compiled from: AliasExistsException.kt */
/* loaded from: classes.dex */
public class AliasExistsException extends ServiceException {
    public AliasExistsException(Throwable th) {
        super("Alias (an account with this email or phone) already exists in the system.", "Retry operation and use another alias.", th);
    }
}
