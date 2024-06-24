package com.amplifyframework.auth.cognito;

import com.amplifyframework.auth.AWSAuthSessionInternal;
import com.amplifyframework.auth.AWSCognitoUserPoolTokens;
import com.amplifyframework.auth.AWSCredentials;
import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.cognito.helpers.SessionHelper;
import com.amplifyframework.auth.exceptions.ConfigurationException;
import com.amplifyframework.auth.exceptions.InvalidStateException;
import com.amplifyframework.auth.exceptions.SignedOutException;
import com.amplifyframework.auth.exceptions.UnknownException;
import com.amplifyframework.auth.result.AuthSessionResult;
import com.amplifyframework.statemachine.codegen.data.AmplifyCredential;
import com.amplifyframework.statemachine.codegen.data.CognitoUserPoolTokens;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AWSCognitoAuthSession.kt */
/* loaded from: classes.dex */
public final class AWSCognitoAuthSessionKt {
    public static final AWSAuthSessionInternal getCognitoSession(AmplifyCredential amplifyCredential, AuthException exception) {
        Intrinsics.checkNotNullParameter(amplifyCredential, "<this>");
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (amplifyCredential instanceof AmplifyCredential.UserPool) {
            AuthSessionResult failure = AuthSessionResult.failure(new ConfigurationException("Could not retrieve Identity ID", "Cognito Identity not configured. Please check amplifyconfiguration.json file.", null, 4, null));
            Intrinsics.checkNotNullExpressionValue(failure, "failure(\n               …          )\n            )");
            AuthSessionResult failure2 = AuthSessionResult.failure(new ConfigurationException("Could not fetch AWS Cognito credentials", "Cognito Identity not configured. Please check amplifyconfiguration.json file.", null, 4, null));
            Intrinsics.checkNotNullExpressionValue(failure2, "failure(\n               …          )\n            )");
            AmplifyCredential.UserPool userPool = (AmplifyCredential.UserPool) amplifyCredential;
            return new AWSCognitoAuthSession(true, failure, failure2, getCognitoSession$getUserSubResult(userPool.getSignedInData().getCognitoUserPoolTokens()), getCognitoSession$getUserPoolTokensResult(userPool.getSignedInData().getCognitoUserPoolTokens()));
        }
        if (amplifyCredential instanceof AmplifyCredential.UserAndIdentityPool) {
            AmplifyCredential.UserAndIdentityPool userAndIdentityPool = (AmplifyCredential.UserAndIdentityPool) amplifyCredential;
            return new AWSCognitoAuthSession(true, getCognitoSession$getIdentityIdResult(userAndIdentityPool.getIdentityId()), getCognitoSession$getCredentialsResult(userAndIdentityPool.getCredentials()), getCognitoSession$getUserSubResult(userAndIdentityPool.getSignedInData().getCognitoUserPoolTokens()), getCognitoSession$getUserPoolTokensResult(userAndIdentityPool.getSignedInData().getCognitoUserPoolTokens()));
        }
        if (amplifyCredential instanceof AmplifyCredential.IdentityPool) {
            AmplifyCredential.IdentityPool identityPool = (AmplifyCredential.IdentityPool) amplifyCredential;
            AuthSessionResult<String> cognitoSession$getIdentityIdResult = getCognitoSession$getIdentityIdResult(identityPool.getIdentityId());
            AuthSessionResult<AWSCredentials> cognitoSession$getCredentialsResult = getCognitoSession$getCredentialsResult(identityPool.getCredentials());
            AuthSessionResult failure3 = AuthSessionResult.failure(new SignedOutException(null, null, null, 7, null));
            Intrinsics.checkNotNullExpressionValue(failure3, "failure(SignedOutException())");
            AuthSessionResult failure4 = AuthSessionResult.failure(new SignedOutException(null, null, null, 7, null));
            Intrinsics.checkNotNullExpressionValue(failure4, "failure(SignedOutException())");
            return new AWSCognitoAuthSession(false, cognitoSession$getIdentityIdResult, cognitoSession$getCredentialsResult, failure3, failure4);
        }
        if (amplifyCredential instanceof AmplifyCredential.IdentityPoolFederated) {
            InvalidStateException invalidStateException = new InvalidStateException("Users Federated to Identity Pool do not have User Pool access.", "To access User Pool data, you must use a Sign In method.", null, 4, null);
            AmplifyCredential.IdentityPoolFederated identityPoolFederated = (AmplifyCredential.IdentityPoolFederated) amplifyCredential;
            AuthSessionResult<String> cognitoSession$getIdentityIdResult2 = getCognitoSession$getIdentityIdResult(identityPoolFederated.getIdentityId());
            AuthSessionResult<AWSCredentials> cognitoSession$getCredentialsResult2 = getCognitoSession$getCredentialsResult(identityPoolFederated.getCredentials());
            AuthSessionResult failure5 = AuthSessionResult.failure(invalidStateException);
            Intrinsics.checkNotNullExpressionValue(failure5, "failure(userPoolException)");
            AuthSessionResult failure6 = AuthSessionResult.failure(invalidStateException);
            Intrinsics.checkNotNullExpressionValue(failure6, "failure(userPoolException)");
            return new AWSCognitoAuthSession(true, cognitoSession$getIdentityIdResult2, cognitoSession$getCredentialsResult2, failure5, failure6);
        }
        AuthSessionResult failure7 = AuthSessionResult.failure(exception);
        Intrinsics.checkNotNullExpressionValue(failure7, "failure(exception)");
        AuthSessionResult failure8 = AuthSessionResult.failure(exception);
        Intrinsics.checkNotNullExpressionValue(failure8, "failure(exception)");
        AuthSessionResult failure9 = AuthSessionResult.failure(exception);
        Intrinsics.checkNotNullExpressionValue(failure9, "failure(exception)");
        AuthSessionResult failure10 = AuthSessionResult.failure(exception);
        Intrinsics.checkNotNullExpressionValue(failure10, "failure(exception)");
        return new AWSCognitoAuthSession(false, failure7, failure8, failure9, failure10);
    }

    public static /* synthetic */ AWSAuthSessionInternal getCognitoSession$default(AmplifyCredential amplifyCredential, AuthException authException, int r8, Object obj) {
        if ((r8 & 1) != 0) {
            authException = new SignedOutException(null, null, null, 7, null);
        }
        return getCognitoSession(amplifyCredential, authException);
    }

    private static final AuthSessionResult<AWSCredentials> getCognitoSession$getCredentialsResult(com.amplifyframework.statemachine.codegen.data.AWSCredentials aWSCredentials) {
        AuthSessionResult<AWSCredentials> authSessionResult;
        AWSCredentials createAWSCredentials = AWSCredentials.Factory.createAWSCredentials(aWSCredentials.getAccessKeyId(), aWSCredentials.getSecretAccessKey(), aWSCredentials.getSessionToken(), aWSCredentials.getExpiration());
        if (createAWSCredentials != null) {
            authSessionResult = AuthSessionResult.success(createAWSCredentials);
        } else {
            authSessionResult = null;
        }
        if (authSessionResult == null) {
            AuthSessionResult<AWSCredentials> failure = AuthSessionResult.failure(new UnknownException("Failed to fetch AWS credentials.", null, 2, null));
            Intrinsics.checkNotNullExpressionValue(failure, "failure(UnknownException…fetch AWS credentials.\"))");
            return failure;
        }
        return authSessionResult;
    }

    private static final AuthSessionResult<String> getCognitoSession$getIdentityIdResult(String str) {
        boolean z;
        if (str.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AuthSessionResult<String> success = AuthSessionResult.success(str);
            Intrinsics.checkNotNullExpressionValue(success, "success(identityId)");
            return success;
        }
        AuthSessionResult<String> failure = AuthSessionResult.failure(new UnknownException("Failed to fetch identity id.", null, 2, null));
        Intrinsics.checkNotNullExpressionValue(failure, "failure(UnknownException… to fetch identity id.\"))");
        return failure;
    }

    private static final AuthSessionResult<AWSCognitoUserPoolTokens> getCognitoSession$getUserPoolTokensResult(CognitoUserPoolTokens cognitoUserPoolTokens) {
        AuthSessionResult<AWSCognitoUserPoolTokens> success = AuthSessionResult.success(new AWSCognitoUserPoolTokens(cognitoUserPoolTokens.getAccessToken(), cognitoUserPoolTokens.getIdToken(), cognitoUserPoolTokens.getRefreshToken()));
        Intrinsics.checkNotNullExpressionValue(success, "success(\n            AWS…n\n            )\n        )");
        return success;
    }

    private static final AuthSessionResult<String> getCognitoSession$getUserSubResult(CognitoUserPoolTokens cognitoUserPoolTokens) {
        String userSub;
        if (cognitoUserPoolTokens != null) {
            try {
                String accessToken = cognitoUserPoolTokens.getAccessToken();
                if (accessToken != null) {
                    userSub = SessionHelper.INSTANCE.getUserSub(accessToken);
                    AuthSessionResult<String> success = AuthSessionResult.success(userSub);
                    Intrinsics.checkNotNullExpressionValue(success, "{\n            AuthSessio…r::getUserSub))\n        }");
                    return success;
                }
            } catch (Exception e) {
                AuthSessionResult<String> failure = AuthSessionResult.failure(new UnknownException(null, e, 1, null));
                Intrinsics.checkNotNullExpressionValue(failure, "{\n            AuthSessio…ion(cause = e))\n        }");
                return failure;
            }
        }
        userSub = null;
        AuthSessionResult<String> success2 = AuthSessionResult.success(userSub);
        Intrinsics.checkNotNullExpressionValue(success2, "{\n            AuthSessio…r::getUserSub))\n        }");
        return success2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean isValid(AmplifyCredential amplifyCredential) {
        Intrinsics.checkNotNullParameter(amplifyCredential, "<this>");
        if (amplifyCredential instanceof AmplifyCredential.UserPool) {
            return SessionHelper.INSTANCE.isValidTokens(((AmplifyCredential.UserPool) amplifyCredential).getSignedInData().getCognitoUserPoolTokens());
        }
        if (amplifyCredential instanceof AmplifyCredential.UserAndIdentityPool) {
            SessionHelper sessionHelper = SessionHelper.INSTANCE;
            AmplifyCredential.UserAndIdentityPool userAndIdentityPool = (AmplifyCredential.UserAndIdentityPool) amplifyCredential;
            if (sessionHelper.isValidTokens(userAndIdentityPool.getSignedInData().getCognitoUserPoolTokens()) && sessionHelper.isValidSession(userAndIdentityPool.getCredentials())) {
                return true;
            }
        } else if (amplifyCredential instanceof AmplifyCredential.IdentityPoolTypeCredential) {
            return SessionHelper.INSTANCE.isValidSession(((AmplifyCredential.IdentityPoolTypeCredential) amplifyCredential).getCredentials());
        }
        return false;
    }
}
