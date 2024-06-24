package com.amplifyframework.auth;

import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider;
import com.amplifyframework.core.Consumer;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AWSCredentialsProvider.kt */
/* loaded from: classes.dex */
public final class AWSCredentialsProviderKt {
    public static final <T extends AWSCredentials> CredentialsProvider convertToSdkCredentialsProvider(final AWSCredentialsProvider<? extends T> awsCredentialsProvider) {
        Intrinsics.checkNotNullParameter(awsCredentialsProvider, "awsCredentialsProvider");
        return new CredentialsProvider() { // from class: com.amplifyframework.auth.AWSCredentialsProviderKt$convertToSdkCredentialsProvider$1
            public Object getCredentials(Continuation<? super Credentials> continuation) {
                AWSCredentialsProvider<T> aWSCredentialsProvider = awsCredentialsProvider;
                final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
                aWSCredentialsProvider.fetchAWSCredentials(new Consumer() { // from class: com.amplifyframework.auth.AWSCredentialsProviderKt$convertToSdkCredentialsProvider$1$getCredentials$2$1
                    /* JADX WARN: Incorrect types in method signature: (TT;)V */
                    @Override // com.amplifyframework.core.Consumer
                    public final void accept(AWSCredentials it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        safeContinuation.resumeWith(AWSCredentialsKt.toSdkCredentials(it));
                    }
                }, new Consumer() { // from class: com.amplifyframework.auth.AWSCredentialsProviderKt$convertToSdkCredentialsProvider$1$getCredentials$2$2
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
        };
    }
}
