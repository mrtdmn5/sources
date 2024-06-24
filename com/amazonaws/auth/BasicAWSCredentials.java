package com.amazonaws.auth;

/* loaded from: classes.dex */
public class BasicAWSCredentials implements AWSCredentials {
    private final String accessKey;
    private final String secretKey;

    public BasicAWSCredentials(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                this.accessKey = str;
                this.secretKey = str2;
                return;
            }
            throw new IllegalArgumentException("Secret key cannot be null.");
        }
        throw new IllegalArgumentException("Access key cannot be null.");
    }

    @Override // com.amazonaws.auth.AWSCredentials
    public String getAWSAccessKeyId() {
        return this.accessKey;
    }

    @Override // com.amazonaws.auth.AWSCredentials
    public String getAWSSecretKey() {
        return this.secretKey;
    }
}
