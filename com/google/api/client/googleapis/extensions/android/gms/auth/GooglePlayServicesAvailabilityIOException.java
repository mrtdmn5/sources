package com.google.api.client.googleapis.extensions.android.gms.auth;

import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GooglePlayServicesAvailabilityException;
import com.google.android.gms.auth.UserRecoverableAuthException;

/* loaded from: classes3.dex */
public class GooglePlayServicesAvailabilityIOException extends UserRecoverableAuthIOException {
    @Override // com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException, com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAuthIOException, java.lang.Throwable
    public final GoogleAuthException getCause() {
        return (GooglePlayServicesAvailabilityException) super.getCause();
    }

    @Override // com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException, com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAuthIOException, java.lang.Throwable
    public final UserRecoverableAuthException getCause() {
        return (GooglePlayServicesAvailabilityException) super.getCause();
    }

    @Override // com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException, com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAuthIOException, java.lang.Throwable
    public final Throwable getCause() {
        return (GooglePlayServicesAvailabilityException) super.getCause();
    }
}
