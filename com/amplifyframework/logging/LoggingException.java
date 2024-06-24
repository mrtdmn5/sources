package com.amplifyframework.logging;

import com.amplifyframework.AmplifyException;

/* loaded from: classes.dex */
public final class LoggingException extends AmplifyException {
    private static final long serialVersionUID = 1;

    public LoggingException(String str, Throwable th, String str2) {
        super(str, th, str2);
    }

    public LoggingException(String str, String str2) {
        super(str, str2);
    }
}
