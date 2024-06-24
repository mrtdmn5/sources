package com.google.api.client.googleapis.extensions.android.gms.auth;

import com.google.android.gms.auth.UserRecoverableAuthException;

/* loaded from: classes3.dex */
public class UserRecoverableAuthIOException extends GoogleAuthIOException {
    @Override // com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAuthIOException, java.lang.Throwable
    public UserRecoverableAuthException getCause() {
        return (UserRecoverableAuthException) super.getCause();
    }
}
