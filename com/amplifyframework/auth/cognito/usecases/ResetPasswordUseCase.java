package com.amplifyframework.auth.cognito.usecases;

import aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResetPasswordUseCase.kt */
/* loaded from: classes.dex */
public final class ResetPasswordUseCase {
    private final String appClientId;
    private final String appClientSecret;
    private final CognitoIdentityProviderClient cognitoIdentityProviderClient;

    public ResetPasswordUseCase(CognitoIdentityProviderClient cognitoIdentityProviderClient, String appClientId, String str) {
        Intrinsics.checkNotNullParameter(cognitoIdentityProviderClient, "cognitoIdentityProviderClient");
        Intrinsics.checkNotNullParameter(appClientId, "appClientId");
        this.cognitoIdentityProviderClient = cognitoIdentityProviderClient;
        this.appClientId = appClientId;
        this.appClientSecret = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0098 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x002a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x005a  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object execute(java.lang.String r18, com.amplifyframework.auth.options.AuthResetPasswordOptions r19, java.lang.String r20, java.lang.String r21, com.amplifyframework.core.Consumer<com.amplifyframework.auth.result.AuthResetPasswordResult> r22, com.amplifyframework.core.Consumer<com.amplifyframework.auth.AuthException> r23, kotlin.coroutines.Continuation<? super kotlin.Unit> r24) {
        /*
            r17 = this;
            r0 = r24
            boolean r1 = r0 instanceof com.amplifyframework.auth.cognito.usecases.ResetPasswordUseCase$execute$1
            if (r1 == 0) goto L17
            r1 = r0
            com.amplifyframework.auth.cognito.usecases.ResetPasswordUseCase$execute$1 r1 = (com.amplifyframework.auth.cognito.usecases.ResetPasswordUseCase$execute$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.label = r2
            r9 = r17
            goto L1e
        L17:
            com.amplifyframework.auth.cognito.usecases.ResetPasswordUseCase$execute$1 r1 = new com.amplifyframework.auth.cognito.usecases.ResetPasswordUseCase$execute$1
            r9 = r17
            r1.<init>(r9, r0)
        L1e:
            java.lang.Object r0 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r10 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r1.label
            r11 = 3
            r12 = 2
            r13 = 1
            r14 = 0
            if (r2 == 0) goto L5a
            if (r2 == r13) goto L46
            if (r2 == r12) goto L3d
            if (r2 != r11) goto L35
            kotlin.ResultKt.throwOnFailure(r0)
            goto Lb4
        L35:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3d:
            java.lang.Object r2 = r1.L$0
            com.amplifyframework.core.Consumer r2 = (com.amplifyframework.core.Consumer) r2
            kotlin.ResultKt.throwOnFailure(r0)     // Catch: java.lang.Exception -> L57
            goto Lb4
        L46:
            java.lang.Object r2 = r1.L$1
            com.amplifyframework.core.Consumer r2 = (com.amplifyframework.core.Consumer) r2
            java.lang.Object r3 = r1.L$0
            com.amplifyframework.core.Consumer r3 = (com.amplifyframework.core.Consumer) r3
            kotlin.ResultKt.throwOnFailure(r0)     // Catch: java.lang.Exception -> L57
            r16 = r3
            r3 = r2
            r2 = r16
            goto L81
        L57:
            r0 = move-exception
            r3 = r2
            goto L9e
        L5a:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlinx.coroutines.scheduling.DefaultIoScheduler r0 = kotlinx.coroutines.Dispatchers.IO     // Catch: java.lang.Exception -> L9b
            com.amplifyframework.auth.cognito.usecases.ResetPasswordUseCase$execute$response$1 r15 = new com.amplifyframework.auth.cognito.usecases.ResetPasswordUseCase$execute$response$1     // Catch: java.lang.Exception -> L9b
            r8 = 0
            r2 = r15
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r2.<init>(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Exception -> L9b
            r2 = r22
            r1.L$0 = r2     // Catch: java.lang.Exception -> L9b
            r3 = r23
            r1.L$1 = r3     // Catch: java.lang.Exception -> L99
            r1.label = r13     // Catch: java.lang.Exception -> L99
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r0, r15, r1)     // Catch: java.lang.Exception -> L99
            if (r0 != r10) goto L81
            return r10
        L81:
            aws.sdk.kotlin.services.cognitoidentityprovider.model.ForgotPasswordResponse r0 = (aws.sdk.kotlin.services.cognitoidentityprovider.model.ForgotPasswordResponse) r0     // Catch: java.lang.Exception -> L99
            kotlinx.coroutines.scheduling.DefaultScheduler r4 = kotlinx.coroutines.Dispatchers.Default     // Catch: java.lang.Exception -> L99
            kotlinx.coroutines.MainCoroutineDispatcher r4 = kotlinx.coroutines.internal.MainDispatcherLoader.dispatcher     // Catch: java.lang.Exception -> L99
            com.amplifyframework.auth.cognito.usecases.ResetPasswordUseCase$execute$2 r5 = new com.amplifyframework.auth.cognito.usecases.ResetPasswordUseCase$execute$2     // Catch: java.lang.Exception -> L99
            r5.<init>(r2, r0, r14)     // Catch: java.lang.Exception -> L99
            r1.L$0 = r3     // Catch: java.lang.Exception -> L99
            r1.L$1 = r14     // Catch: java.lang.Exception -> L99
            r1.label = r12     // Catch: java.lang.Exception -> L99
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r4, r5, r1)     // Catch: java.lang.Exception -> L99
            if (r0 != r10) goto Lb4
            return r10
        L99:
            r0 = move-exception
            goto L9e
        L9b:
            r0 = move-exception
            r3 = r23
        L9e:
            kotlinx.coroutines.scheduling.DefaultScheduler r2 = kotlinx.coroutines.Dispatchers.Default
            kotlinx.coroutines.MainCoroutineDispatcher r2 = kotlinx.coroutines.internal.MainDispatcherLoader.dispatcher
            com.amplifyframework.auth.cognito.usecases.ResetPasswordUseCase$execute$3 r4 = new com.amplifyframework.auth.cognito.usecases.ResetPasswordUseCase$execute$3
            r4.<init>(r3, r0, r14)
            r1.L$0 = r14
            r1.L$1 = r14
            r1.label = r11
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r2, r4, r1)
            if (r0 != r10) goto Lb4
            return r10
        Lb4:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.usecases.ResetPasswordUseCase.execute(java.lang.String, com.amplifyframework.auth.options.AuthResetPasswordOptions, java.lang.String, java.lang.String, com.amplifyframework.core.Consumer, com.amplifyframework.core.Consumer, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
