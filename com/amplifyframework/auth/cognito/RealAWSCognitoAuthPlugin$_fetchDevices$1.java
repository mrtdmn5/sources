package com.amplifyframework.auth.cognito;

import com.amplifyframework.auth.AuthDevice;
import com.amplifyframework.auth.AuthException;
import com.amplifyframework.core.Consumer;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: RealAWSCognitoAuthPlugin.kt */
@DebugMetadata(c = "com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$_fetchDevices$1", f = "RealAWSCognitoAuthPlugin.kt", l = {1131, 1133}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RealAWSCognitoAuthPlugin$_fetchDevices$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Consumer<AuthException> $onError;
    final /* synthetic */ Consumer<List<AuthDevice>> $onSuccess;
    int label;
    final /* synthetic */ RealAWSCognitoAuthPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealAWSCognitoAuthPlugin$_fetchDevices$1(RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin, Consumer<List<AuthDevice>> consumer, Consumer<AuthException> consumer2, Continuation<? super RealAWSCognitoAuthPlugin$_fetchDevices$1> continuation) {
        super(2, continuation);
        this.this$0 = realAWSCognitoAuthPlugin;
        this.$onSuccess = consumer;
        this.$onError = consumer2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RealAWSCognitoAuthPlugin$_fetchDevices$1(this.this$0, this.$onSuccess, this.$onError, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006b A[Catch: Exception -> 0x0096, TryCatch #0 {Exception -> 0x0096, blocks: (B:6:0x000d, B:7:0x005c, B:9:0x0062, B:10:0x0064, B:12:0x006b, B:13:0x0071, B:15:0x0077, B:19:0x0083, B:22:0x0090, B:29:0x0019, B:30:0x002b, B:32:0x0041, B:37:0x0020), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0062 A[Catch: Exception -> 0x0096, TryCatch #0 {Exception -> 0x0096, blocks: (B:6:0x000d, B:7:0x005c, B:9:0x0062, B:10:0x0064, B:12:0x006b, B:13:0x0071, B:15:0x0077, B:19:0x0083, B:22:0x0090, B:29:0x0019, B:30:0x002b, B:32:0x0041, B:37:0x0020), top: B:2:0x0007 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r5.label
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L1d
            if (r1 == r3) goto L19
            if (r1 != r2) goto L11
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Exception -> L96
            goto L5c
        L11:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L19:
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Exception -> L96
            goto L2b
        L1d:
            kotlin.ResultKt.throwOnFailure(r6)
            com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin r6 = r5.this$0     // Catch: java.lang.Exception -> L96
            r5.label = r3     // Catch: java.lang.Exception -> L96
            java.lang.Object r6 = com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin.access$getSession(r6, r5)     // Catch: java.lang.Exception -> L96
            if (r6 != r0) goto L2b
            return r0
        L2b:
            com.amplifyframework.auth.cognito.AWSCognitoAuthSession r6 = (com.amplifyframework.auth.cognito.AWSCognitoAuthSession) r6     // Catch: java.lang.Exception -> L96
            com.amplifyframework.auth.result.AuthSessionResult r6 = r6.getUserPoolTokensResult()     // Catch: java.lang.Exception -> L96
            com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin r1 = r5.this$0     // Catch: java.lang.Exception -> L96
            com.amplifyframework.auth.cognito.AuthEnvironment r1 = com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin.access$getAuthEnvironment$p(r1)     // Catch: java.lang.Exception -> L96
            com.amplifyframework.auth.cognito.AWSCognitoAuthService r1 = r1.getCognitoAuthService()     // Catch: java.lang.Exception -> L96
            aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient r1 = r1.getCognitoIdentityProviderClient()     // Catch: java.lang.Exception -> L96
            if (r1 == 0) goto L5f
            com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$_fetchDevices$1$response$1 r3 = new com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$_fetchDevices$1$response$1     // Catch: java.lang.Exception -> L96
            r3.<init>()     // Catch: java.lang.Exception -> L96
            aws.sdk.kotlin.services.cognitoidentityprovider.model.ListDevicesRequest$Builder r6 = new aws.sdk.kotlin.services.cognitoidentityprovider.model.ListDevicesRequest$Builder     // Catch: java.lang.Exception -> L96
            r6.<init>()     // Catch: java.lang.Exception -> L96
            r3.invoke(r6)     // Catch: java.lang.Exception -> L96
            aws.sdk.kotlin.services.cognitoidentityprovider.model.ListDevicesRequest r3 = new aws.sdk.kotlin.services.cognitoidentityprovider.model.ListDevicesRequest     // Catch: java.lang.Exception -> L96
            r3.<init>(r6)     // Catch: java.lang.Exception -> L96
            r5.label = r2     // Catch: java.lang.Exception -> L96
            java.lang.Object r6 = r1.listDevices(r3, r5)     // Catch: java.lang.Exception -> L96
            if (r6 != r0) goto L5c
            return r0
        L5c:
            aws.sdk.kotlin.services.cognitoidentityprovider.model.ListDevicesResponse r6 = (aws.sdk.kotlin.services.cognitoidentityprovider.model.ListDevicesResponse) r6     // Catch: java.lang.Exception -> L96
            goto L60
        L5f:
            r6 = r4
        L60:
            if (r6 == 0) goto L64
            java.util.List<aws.sdk.kotlin.services.cognitoidentityprovider.model.DeviceType> r4 = r6.devices     // Catch: java.lang.Exception -> L96
        L64:
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch: java.lang.Exception -> L96
            r6.<init>()     // Catch: java.lang.Exception -> L96
            if (r4 == 0) goto L90
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch: java.lang.Exception -> L96
            java.util.Iterator r0 = r4.iterator()     // Catch: java.lang.Exception -> L96
        L71:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Exception -> L96
            if (r1 == 0) goto L90
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Exception -> L96
            aws.sdk.kotlin.services.cognitoidentityprovider.model.DeviceType r1 = (aws.sdk.kotlin.services.cognitoidentityprovider.model.DeviceType) r1     // Catch: java.lang.Exception -> L96
            java.lang.String r1 = r1.deviceKey     // Catch: java.lang.Exception -> L96
            if (r1 != 0) goto L83
            java.lang.String r1 = ""
        L83:
            com.amplifyframework.auth.AuthDevice r1 = com.amplifyframework.auth.AuthDevice.fromId(r1)     // Catch: java.lang.Exception -> L96
            java.lang.String r2 = "fromId(it.deviceKey ?: \"\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch: java.lang.Exception -> L96
            r6.add(r1)     // Catch: java.lang.Exception -> L96
            goto L71
        L90:
            com.amplifyframework.core.Consumer<java.util.List<com.amplifyframework.auth.AuthDevice>> r0 = r5.$onSuccess     // Catch: java.lang.Exception -> L96
            r0.accept(r6)     // Catch: java.lang.Exception -> L96
            goto La4
        L96:
            r6 = move-exception
            com.amplifyframework.core.Consumer<com.amplifyframework.auth.AuthException> r0 = r5.$onError
            com.amplifyframework.auth.cognito.CognitoAuthExceptionConverter$Companion r1 = com.amplifyframework.auth.cognito.CognitoAuthExceptionConverter.Companion
            java.lang.String r2 = "Fetch devices failed."
            com.amplifyframework.auth.AuthException r6 = r1.lookup(r6, r2)
            r0.accept(r6)
        La4:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$_fetchDevices$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RealAWSCognitoAuthPlugin$_fetchDevices$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
