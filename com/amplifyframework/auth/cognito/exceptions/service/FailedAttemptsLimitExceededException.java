package com.amplifyframework.auth.cognito.exceptions.service;

import com.amplifyframework.auth.exceptions.ServiceException;

/* compiled from: FailedAttemptsLimitExceededException.kt */
/* loaded from: classes.dex */
public class FailedAttemptsLimitExceededException extends ServiceException {
    public FailedAttemptsLimitExceededException(Throwable th) {
        super("User has made too many failed attempts for a given action.", "Please check out the service configuration to see the condition of locking.", th);
    }
}
