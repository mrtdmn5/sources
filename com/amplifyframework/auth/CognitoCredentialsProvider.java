package com.amplifyframework.auth;

import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import com.amplifyframework.auth.result.AuthSessionResult;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.Consumer;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CognitoCredentialsProvider.kt */
/* loaded from: classes.dex */
public class CognitoCredentialsProvider implements AuthCredentialsProvider {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAccessToken$lambda-3, reason: not valid java name */
    public static final void m627getAccessToken$lambda3(Consumer onFailure, Consumer onResult, AuthSession session) {
        AWSAuthSessionInternal aWSAuthSession;
        String str;
        AuthSessionResult<AWSCognitoUserPoolTokens> userPoolTokensResult;
        AWSCognitoUserPoolTokens value;
        Intrinsics.checkNotNullParameter(onFailure, "$onFailure");
        Intrinsics.checkNotNullParameter(onResult, "$onResult");
        Intrinsics.checkNotNullParameter(session, "session");
        aWSAuthSession = CognitoCredentialsProviderKt.toAWSAuthSession(session);
        Unit unit = null;
        if (aWSAuthSession != null && (userPoolTokensResult = aWSAuthSession.getUserPoolTokensResult()) != null && (value = userPoolTokensResult.getValue()) != null) {
            str = value.getAccessToken();
        } else {
            str = null;
        }
        if (str != null) {
            onResult.accept(str);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            onFailure.accept(new AuthException("Token is null", "Token received but is null. Check if you are signed in", null, 4, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAccessToken$lambda-4, reason: not valid java name */
    public static final void m628getAccessToken$lambda4(Consumer onFailure, AuthException it) {
        Intrinsics.checkNotNullParameter(onFailure, "$onFailure");
        Intrinsics.checkNotNullParameter(it, "it");
        onFailure.accept(it);
    }

    public static Object getCredentials$suspendImpl(CognitoCredentialsProvider cognitoCredentialsProvider, Continuation continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        Amplify.Auth.fetchAuthSession(new Consumer() { // from class: com.amplifyframework.auth.CognitoCredentialsProvider$getCredentials$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthSession authSession) {
                AWSAuthSessionInternal aWSAuthSession;
                Unit unit;
                AuthSessionResult<AWSCredentials> awsCredentialsResult;
                AWSCredentials value;
                Intrinsics.checkNotNullParameter(authSession, "authSession");
                aWSAuthSession = CognitoCredentialsProviderKt.toAWSAuthSession(authSession);
                if (aWSAuthSession == null || (awsCredentialsResult = aWSAuthSession.getAwsCredentialsResult()) == null || (value = awsCredentialsResult.getValue()) == null) {
                    unit = null;
                } else {
                    safeContinuation.resumeWith(AWSCredentialsKt.toSdkCredentials(value));
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    safeContinuation.resumeWith(ResultKt.createFailure(new AuthException("Failed to get credentials. Check if you are signed in and configured identity pools correctly.", "Sorry, we don't have a suggested fix for this error yet.", null, 4, null)));
                }
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.CognitoCredentialsProvider$getCredentials$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public static Object getIdentityId$suspendImpl(CognitoCredentialsProvider cognitoCredentialsProvider, Continuation continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        Amplify.Auth.fetchAuthSession(new Consumer() { // from class: com.amplifyframework.auth.CognitoCredentialsProvider$getIdentityId$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthSession authSession) {
                AWSAuthSessionInternal aWSAuthSession;
                Unit unit;
                AuthSessionResult<String> identityIdResult;
                String value;
                Intrinsics.checkNotNullParameter(authSession, "authSession");
                aWSAuthSession = CognitoCredentialsProviderKt.toAWSAuthSession(authSession);
                if (aWSAuthSession == null || (identityIdResult = aWSAuthSession.getIdentityIdResult()) == null || (value = identityIdResult.getValue()) == null) {
                    unit = null;
                } else {
                    safeContinuation.resumeWith(value);
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    safeContinuation.resumeWith(ResultKt.createFailure(new AuthException("Failed to get identity ID. Check if you are signed in and configured identity pools correctly.", "Sorry, we don't have a suggested fix for this error yet.", null, 4, null)));
                }
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.CognitoCredentialsProvider$getIdentityId$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    @Override // com.amplifyframework.auth.AuthCredentialsProvider
    public void getAccessToken(final Consumer<String> onResult, final Consumer<Exception> onFailure) {
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        Amplify.Auth.fetchAuthSession(new Consumer() { // from class: com.amplifyframework.auth.CognitoCredentialsProvider$$ExternalSyntheticLambda0
            @Override // com.amplifyframework.core.Consumer
            public final void accept(Object obj) {
                CognitoCredentialsProvider.m627getAccessToken$lambda3(Consumer.this, onResult, (AuthSession) obj);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.CognitoCredentialsProvider$$ExternalSyntheticLambda1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(Object obj) {
                CognitoCredentialsProvider.m628getAccessToken$lambda4(Consumer.this, (AuthException) obj);
            }
        });
    }

    @Override // com.amplifyframework.auth.AuthCredentialsProvider
    public Object getCredentials(Continuation<? super Credentials> continuation) {
        return getCredentials$suspendImpl(this, continuation);
    }

    @Override // com.amplifyframework.auth.AuthCredentialsProvider
    public Object getIdentityId(Continuation<? super String> continuation) {
        return getIdentityId$suspendImpl(this, continuation);
    }
}
