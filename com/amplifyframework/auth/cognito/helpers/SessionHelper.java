package com.amplifyframework.auth.cognito.helpers;

import com.amplifyframework.statemachine.codegen.data.AWSCredentials;
import com.amplifyframework.statemachine.codegen.data.CognitoUserPoolTokens;
import j$.time.Instant;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SessionHelper.kt */
/* loaded from: classes.dex */
public final class SessionHelper {
    public static final SessionHelper INSTANCE = new SessionHelper();

    private SessionHelper() {
    }

    public final Instant getExpiration$aws_auth_cognito_release(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        String claim = JWTParser.INSTANCE.getClaim(token, "exp");
        if (claim != null) {
            return Instant.ofEpochSecond(Long.parseLong(claim));
        }
        return null;
    }

    public final String getUserSub(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        return JWTParser.INSTANCE.getClaim(token, "sub");
    }

    public final String getUsername(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        return JWTParser.INSTANCE.getClaim(token, "username");
    }

    public final boolean isValidSession(AWSCredentials awsCredentials) {
        Instant instant;
        Intrinsics.checkNotNullParameter(awsCredentials, "awsCredentials");
        Instant now = Instant.now();
        Long expiration = awsCredentials.getExpiration();
        if (expiration != null) {
            instant = Instant.ofEpochSecond(expiration.longValue());
        } else {
            instant = null;
        }
        if (now.compareTo(instant) < 0) {
            return true;
        }
        return false;
    }

    public final boolean isValidTokens(CognitoUserPoolTokens userPoolTokens) {
        Intrinsics.checkNotNullParameter(userPoolTokens, "userPoolTokens");
        Instant now = Instant.now();
        if (userPoolTokens.getIdToken() == null || userPoolTokens.getAccessToken() == null || now.compareTo(getExpiration$aws_auth_cognito_release(userPoolTokens.getIdToken())) >= 0 || now.compareTo(getExpiration$aws_auth_cognito_release(userPoolTokens.getAccessToken())) >= 0) {
            return false;
        }
        return true;
    }
}
