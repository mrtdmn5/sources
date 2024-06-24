package com.amplifyframework.auth;

import com.amplifyframework.annotations.InternalApiWarning;
import com.amplifyframework.auth.result.AuthSessionResult;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AWSAuthSessionInternal.kt */
@InternalApiWarning
/* loaded from: classes.dex */
public class AWSAuthSessionInternal extends AuthSession {
    private final AuthSessionResult<AWSCredentials> awsCredentialsResult;
    private final AuthSessionResult<String> identityIdResult;
    private final boolean isSignedIn;
    private final AuthSessionResult<AWSCognitoUserPoolTokens> userPoolTokensResult;
    private final AuthSessionResult<String> userSubResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AWSAuthSessionInternal(boolean z, AuthSessionResult<String> identityIdResult, AuthSessionResult<AWSCredentials> awsCredentialsResult, AuthSessionResult<String> userSubResult, AuthSessionResult<AWSCognitoUserPoolTokens> userPoolTokensResult) {
        super(z);
        Intrinsics.checkNotNullParameter(identityIdResult, "identityIdResult");
        Intrinsics.checkNotNullParameter(awsCredentialsResult, "awsCredentialsResult");
        Intrinsics.checkNotNullParameter(userSubResult, "userSubResult");
        Intrinsics.checkNotNullParameter(userPoolTokensResult, "userPoolTokensResult");
        this.isSignedIn = z;
        this.identityIdResult = identityIdResult;
        this.awsCredentialsResult = awsCredentialsResult;
        this.userSubResult = userSubResult;
        this.userPoolTokensResult = userPoolTokensResult;
    }

    public AuthSessionResult<AWSCredentials> getAwsCredentialsResult() {
        return this.awsCredentialsResult;
    }

    public AuthSessionResult<String> getIdentityIdResult() {
        return this.identityIdResult;
    }

    public boolean getSignedIn() {
        return this.isSignedIn;
    }

    public AuthSessionResult<AWSCognitoUserPoolTokens> getUserPoolTokensResult() {
        return this.userPoolTokensResult;
    }

    public AuthSessionResult<String> getUserSubResult() {
        return this.userSubResult;
    }
}
