package com.amplifyframework.auth;

/* compiled from: CognitoCredentialsProvider.kt */
/* loaded from: classes.dex */
public final class CognitoCredentialsProviderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final AWSAuthSessionInternal toAWSAuthSession(AuthSession authSession) {
        if (authSession instanceof AWSAuthSessionInternal) {
            return (AWSAuthSessionInternal) authSession;
        }
        return null;
    }
}
