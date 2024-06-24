package com.google.firebase.remoteconfig;

/* loaded from: classes3.dex */
public class FirebaseRemoteConfigServerException extends FirebaseRemoteConfigException {
    public final int httpStatusCode;

    public FirebaseRemoteConfigServerException(int r1, String str) {
        super(str);
        this.httpStatusCode = r1;
    }

    public FirebaseRemoteConfigServerException(int r1, String str, FirebaseRemoteConfigServerException firebaseRemoteConfigServerException) {
        super(str, firebaseRemoteConfigServerException);
        this.httpStatusCode = r1;
    }
}
