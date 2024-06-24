package com.google.firebase.installations.remote;

import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes3.dex */
public abstract class InstallationResponse {

    /* loaded from: classes3.dex */
    public enum ResponseCode {
        OK,
        BAD_CONFIG
    }

    public abstract TokenResult getAuthToken();

    public abstract String getFid();

    public abstract String getRefreshToken();

    public abstract ResponseCode getResponseCode();

    public abstract String getUri();
}
