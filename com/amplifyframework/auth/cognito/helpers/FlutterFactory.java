package com.amplifyframework.auth.cognito.helpers;

import com.amplifyframework.auth.AWSCognitoUserPoolTokens;
import com.amplifyframework.auth.AWSCredentials;
import com.amplifyframework.auth.cognito.AWSCognitoAuthSession;
import com.amplifyframework.auth.result.AuthSessionResult;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FlutterFactory.kt */
/* loaded from: classes.dex */
public final class FlutterFactory {
    public static final FlutterFactory INSTANCE = new FlutterFactory();

    private FlutterFactory() {
    }

    public final AWSCognitoAuthSession createAWSCognitoAuthSession(boolean z, AuthSessionResult<String> identityIdResult, AuthSessionResult<AWSCredentials> awsCredentialsResult, AuthSessionResult<String> userSubResult, AuthSessionResult<AWSCognitoUserPoolTokens> userPoolTokensResult) {
        Intrinsics.checkNotNullParameter(identityIdResult, "identityIdResult");
        Intrinsics.checkNotNullParameter(awsCredentialsResult, "awsCredentialsResult");
        Intrinsics.checkNotNullParameter(userSubResult, "userSubResult");
        Intrinsics.checkNotNullParameter(userPoolTokensResult, "userPoolTokensResult");
        return new AWSCognitoAuthSession(z, identityIdResult, awsCredentialsResult, userSubResult, userPoolTokensResult);
    }

    public final AWSCognitoUserPoolTokens createAWSCognitoUserPoolTokens(String str, String str2, String str3) {
        return new AWSCognitoUserPoolTokens(str, str2, str3);
    }
}
