package com.animaconnected.cloud;

import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.AuthSession;
import com.amplifyframework.auth.options.AuthFetchSessionOptions;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.Consumer;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Cloud.kt */
/* loaded from: classes.dex */
public final class CloudKt {
    public static final Object forceFetchAuthSession(Continuation<? super AuthSession> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        Amplify.Auth.fetchAuthSession(AuthFetchSessionOptions.Companion.builder().forceRefresh(true).build(), new Consumer() { // from class: com.animaconnected.cloud.CloudKt$forceFetchAuthSession$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthSession it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.animaconnected.cloud.CloudKt$forceFetchAuthSession$2$2
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

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d0, code lost:            if (r14 <= kotlin.time.Duration.m1679getInWholeSecondsimpl(kotlin.time.DurationKt.toDuration(1.5d, kotlin.time.DurationUnit.HOURS))) goto L34;     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object getAuthSession(com.amplifyframework.kotlin.auth.KotlinAuthFacade r19, kotlin.coroutines.Continuation<? super com.amplifyframework.auth.cognito.AWSCognitoAuthSession> r20) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.cloud.CloudKt.getAuthSession(com.amplifyframework.kotlin.auth.KotlinAuthFacade, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
