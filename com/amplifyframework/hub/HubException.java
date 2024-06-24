package com.amplifyframework.hub;

import com.amplifyframework.AmplifyException;

/* loaded from: classes.dex */
public final class HubException extends AmplifyException {
    private static final long serialVersionUID = 1;

    public HubException(String str, Throwable th, String str2) {
        super(str, th, str2);
    }

    public HubException(String str, String str2) {
        super(str, str2);
    }
}
