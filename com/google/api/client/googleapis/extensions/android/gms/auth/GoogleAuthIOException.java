package com.google.api.client.googleapis.extensions.android.gms.auth;

import com.google.android.gms.auth.GoogleAuthException;
import java.io.IOException;

/* loaded from: classes3.dex */
public class GoogleAuthIOException extends IOException {
    @Override // java.lang.Throwable
    public GoogleAuthException getCause() {
        return (GoogleAuthException) super.getCause();
    }
}
