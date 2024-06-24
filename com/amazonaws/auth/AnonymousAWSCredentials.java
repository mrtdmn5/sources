package com.amazonaws.auth;

/* loaded from: classes.dex */
public class AnonymousAWSCredentials implements AWSCredentials {
    @Override // com.amazonaws.auth.AWSCredentials
    public String getAWSAccessKeyId() {
        return null;
    }

    @Override // com.amazonaws.auth.AWSCredentials
    public String getAWSSecretKey() {
        return null;
    }
}
