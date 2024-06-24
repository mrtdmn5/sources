package com.amplifyframework.auth.cognito.exceptions.service;

import com.amplifyframework.auth.exceptions.ServiceException;

/* compiled from: ParseTokenException.kt */
/* loaded from: classes.dex */
public class ParseTokenException extends ServiceException {
    public ParseTokenException() {
        super("Failed to parse token", "Sorry, we don't have a suggested fix for this error yet.", null, 4, null);
    }
}
