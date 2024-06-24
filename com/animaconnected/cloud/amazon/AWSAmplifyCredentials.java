package com.animaconnected.cloud.amazon;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amplifyframework.auth.cognito.asf.SignatureGenerator$Companion$$ExternalSyntheticOutline0;

/* compiled from: AWSAmplifyCredentials.kt */
/* loaded from: classes.dex */
public final class AWSAmplifyCredentials implements AWSCredentialsProvider {
    private final String awsAccessKey;
    private final String awsSecretKey;
    private final String sessionToken;

    public AWSAmplifyCredentials(String str, String str2, String str3) {
        SignatureGenerator$Companion$$ExternalSyntheticOutline0.m(str, "awsAccessKey", str2, "awsSecretKey", str3, "sessionToken");
        this.awsAccessKey = str;
        this.awsSecretKey = str2;
        this.sessionToken = str3;
    }

    @Override // com.amazonaws.auth.AWSCredentialsProvider
    public AWSCredentials getCredentials() {
        return new BasicSessionCredentials(this.awsAccessKey, this.awsSecretKey, this.sessionToken);
    }

    @Override // com.amazonaws.auth.AWSCredentialsProvider
    public void refresh() {
    }
}
