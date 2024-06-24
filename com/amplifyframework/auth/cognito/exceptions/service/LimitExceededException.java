package com.amplifyframework.auth.cognito.exceptions.service;

import com.amplifyframework.auth.exceptions.ServiceException;

/* compiled from: LimitExceededException.kt */
/* loaded from: classes.dex */
public class LimitExceededException extends ServiceException {
    public LimitExceededException(Throwable th) {
        super("Number of allowed operation has exceeded.", "Please wait a while before re-attempting or increase the service limit.", th);
    }
}
