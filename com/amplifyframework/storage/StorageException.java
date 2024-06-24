package com.amplifyframework.storage;

import com.amplifyframework.AmplifyException;

/* loaded from: classes.dex */
public final class StorageException extends AmplifyException {
    private static final long serialVersionUID = 1;

    public StorageException(String str, Throwable th, String str2) {
        super(str, th, str2);
    }

    public StorageException(String str, String str2) {
        super(str, str2);
    }
}
