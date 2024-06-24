package aws.sdk.kotlin.services.cognitoidentityprovider;

import aws.sdk.kotlin.runtime.client.AwsClientOption;
import aws.sdk.kotlin.runtime.http.ApiMetadata;
import aws.sdk.kotlin.runtime.http.AwsUserAgentMetadata;
import aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSigningAttributes;
import aws.smithy.kotlin.runtime.http.SdkHttpClient;
import aws.smithy.kotlin.runtime.http.engine.CloseableHttpClientEngine;
import aws.smithy.kotlin.runtime.io.SdkManaged;
import aws.smithy.kotlin.runtime.io.SdkManagedGroup;
import aws.smithy.kotlin.runtime.io.SdkManagedGroupKt;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.util.AttributesKt;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultCognitoIdentityProviderClient.kt */
/* loaded from: classes.dex */
public final class DefaultCognitoIdentityProviderClient implements CognitoIdentityProviderClient {
    public final AwsUserAgentMetadata awsUserAgentMetadata;
    public final SdkHttpClient client;
    public final CognitoIdentityProviderClient.Config config;
    public final SdkManagedGroup managedResources;

    public DefaultCognitoIdentityProviderClient(CognitoIdentityProviderClient.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        SdkManagedGroup sdkManagedGroup = new SdkManagedGroup(0);
        this.managedResources = sdkManagedGroup;
        CloseableHttpClientEngine closeableHttpClientEngine = config.httpClientEngine;
        this.client = new SdkHttpClient(closeableHttpClientEngine);
        SdkManagedGroupKt.addIfManaged(sdkManagedGroup, closeableHttpClientEngine);
        SdkManagedGroupKt.addIfManaged(sdkManagedGroup, config.credentialsProvider);
        this.awsUserAgentMetadata = AwsUserAgentMetadata.Companion.fromEnvironment(new ApiMetadata("Cognito Identity Provider", "0.21.1-beta"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0108, code lost:            if (r6 == null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010a, code lost:            if (r8 != null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x010c, code lost:            r4 = new aws.smithy.kotlin.runtime.tracing.WrappedRootSpan(r13, r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0113, code lost:            r6 = new aws.smithy.kotlin.runtime.tracing.TraceSpanContextElement(r4);        r4 = new aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient$changePassword$$inlined$withRootTraceSpan$1(null, r12, r5, r2);        r0.L$0 = r13;        r0.L$1 = null;        r0.L$2 = null;        r0.label = 2;        r12 = kotlinx.coroutines.BuildersKt.withContext(r6, r4, r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0129, code lost:            if (r12 != r1) goto L45;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x012b, code lost:            return r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x012c, code lost:            r13 = r12;        r12 = r13;     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0112, code lost:            r4 = r13;     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f4 A[Catch: all -> 0x013f, TRY_LEAVE, TryCatch #0 {all -> 0x013f, blocks: (B:25:0x00e9, B:27:0x00f4, B:31:0x00fe, B:38:0x010c, B:39:0x0113, B:44:0x0133, B:45:0x013e), top: B:24:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object changePassword(aws.sdk.kotlin.services.cognitoidentityprovider.model.ChangePasswordRequest r12, kotlin.coroutines.Continuation<? super aws.sdk.kotlin.services.cognitoidentityprovider.model.ChangePasswordResponse> r13) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient.changePassword(aws.sdk.kotlin.services.cognitoidentityprovider.model.ChangePasswordRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Iterator<T> it = this.managedResources.resources.iterator();
        while (it.hasNext()) {
            ((SdkManaged) it.next()).unshare();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0108, code lost:            if (r6 == null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010a, code lost:            if (r8 != null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x010c, code lost:            r4 = new aws.smithy.kotlin.runtime.tracing.WrappedRootSpan(r13, r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0113, code lost:            r6 = new aws.smithy.kotlin.runtime.tracing.TraceSpanContextElement(r4);        r4 = new aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient$confirmDevice$$inlined$withRootTraceSpan$1(null, r12, r5, r2);        r0.L$0 = r13;        r0.L$1 = null;        r0.L$2 = null;        r0.label = 2;        r12 = kotlinx.coroutines.BuildersKt.withContext(r6, r4, r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0129, code lost:            if (r12 != r1) goto L45;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x012b, code lost:            return r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x012c, code lost:            r13 = r12;        r12 = r13;     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0112, code lost:            r4 = r13;     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f4 A[Catch: all -> 0x013f, TRY_LEAVE, TryCatch #0 {all -> 0x013f, blocks: (B:25:0x00e9, B:27:0x00f4, B:31:0x00fe, B:38:0x010c, B:39:0x0113, B:44:0x0133, B:45:0x013e), top: B:24:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object confirmDevice(aws.sdk.kotlin.services.cognitoidentityprovider.model.ConfirmDeviceRequest r12, kotlin.coroutines.Continuation<? super aws.sdk.kotlin.services.cognitoidentityprovider.model.ConfirmDeviceResponse> r13) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient.confirmDevice(aws.sdk.kotlin.services.cognitoidentityprovider.model.ConfirmDeviceRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0108, code lost:            if (r6 == null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010a, code lost:            if (r8 != null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x010c, code lost:            r4 = new aws.smithy.kotlin.runtime.tracing.WrappedRootSpan(r13, r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0113, code lost:            r6 = new aws.smithy.kotlin.runtime.tracing.TraceSpanContextElement(r4);        r4 = new aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient$confirmForgotPassword$$inlined$withRootTraceSpan$1(null, r12, r5, r2);        r0.L$0 = r13;        r0.L$1 = null;        r0.L$2 = null;        r0.label = 2;        r12 = kotlinx.coroutines.BuildersKt.withContext(r6, r4, r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0129, code lost:            if (r12 != r1) goto L45;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x012b, code lost:            return r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x012c, code lost:            r13 = r12;        r12 = r13;     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0112, code lost:            r4 = r13;     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f4 A[Catch: all -> 0x013f, TRY_LEAVE, TryCatch #0 {all -> 0x013f, blocks: (B:25:0x00e9, B:27:0x00f4, B:31:0x00fe, B:38:0x010c, B:39:0x0113, B:44:0x0133, B:45:0x013e), top: B:24:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object confirmForgotPassword(aws.sdk.kotlin.services.cognitoidentityprovider.model.ConfirmForgotPasswordRequest r12, kotlin.coroutines.Continuation<? super aws.sdk.kotlin.services.cognitoidentityprovider.model.ConfirmForgotPasswordResponse> r13) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient.confirmForgotPassword(aws.sdk.kotlin.services.cognitoidentityprovider.model.ConfirmForgotPasswordRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0108, code lost:            if (r6 == null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010a, code lost:            if (r8 != null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x010c, code lost:            r4 = new aws.smithy.kotlin.runtime.tracing.WrappedRootSpan(r13, r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0113, code lost:            r6 = new aws.smithy.kotlin.runtime.tracing.TraceSpanContextElement(r4);        r4 = new aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient$confirmSignUp$$inlined$withRootTraceSpan$1(null, r12, r5, r2);        r0.L$0 = r13;        r0.L$1 = null;        r0.L$2 = null;        r0.label = 2;        r12 = kotlinx.coroutines.BuildersKt.withContext(r6, r4, r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0129, code lost:            if (r12 != r1) goto L45;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x012b, code lost:            return r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x012c, code lost:            r13 = r12;        r12 = r13;     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0112, code lost:            r4 = r13;     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f4 A[Catch: all -> 0x013f, TRY_LEAVE, TryCatch #0 {all -> 0x013f, blocks: (B:25:0x00e9, B:27:0x00f4, B:31:0x00fe, B:38:0x010c, B:39:0x0113, B:44:0x0133, B:45:0x013e), top: B:24:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object confirmSignUp(aws.sdk.kotlin.services.cognitoidentityprovider.model.ConfirmSignUpRequest r12, kotlin.coroutines.Continuation<? super aws.sdk.kotlin.services.cognitoidentityprovider.model.ConfirmSignUpResponse> r13) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient.confirmSignUp(aws.sdk.kotlin.services.cognitoidentityprovider.model.ConfirmSignUpRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0108, code lost:            if (r6 == null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010a, code lost:            if (r8 != null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x010c, code lost:            r4 = new aws.smithy.kotlin.runtime.tracing.WrappedRootSpan(r13, r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0113, code lost:            r6 = new aws.smithy.kotlin.runtime.tracing.TraceSpanContextElement(r4);        r4 = new aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient$deleteUser$$inlined$withRootTraceSpan$1(null, r12, r5, r2);        r0.L$0 = r13;        r0.L$1 = null;        r0.L$2 = null;        r0.label = 2;        r12 = kotlinx.coroutines.BuildersKt.withContext(r6, r4, r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0129, code lost:            if (r12 != r1) goto L45;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x012b, code lost:            return r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x012c, code lost:            r13 = r12;        r12 = r13;     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0112, code lost:            r4 = r13;     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f4 A[Catch: all -> 0x013f, TRY_LEAVE, TryCatch #0 {all -> 0x013f, blocks: (B:25:0x00e9, B:27:0x00f4, B:31:0x00fe, B:38:0x010c, B:39:0x0113, B:44:0x0133, B:45:0x013e), top: B:24:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object deleteUser(aws.sdk.kotlin.services.cognitoidentityprovider.model.DeleteUserRequest r12, kotlin.coroutines.Continuation<? super aws.sdk.kotlin.services.cognitoidentityprovider.model.DeleteUserResponse> r13) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient.deleteUser(aws.sdk.kotlin.services.cognitoidentityprovider.model.DeleteUserRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0108, code lost:            if (r6 == null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010a, code lost:            if (r8 != null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x010c, code lost:            r4 = new aws.smithy.kotlin.runtime.tracing.WrappedRootSpan(r13, r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0113, code lost:            r6 = new aws.smithy.kotlin.runtime.tracing.TraceSpanContextElement(r4);        r4 = new aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient$forgotPassword$$inlined$withRootTraceSpan$1(null, r12, r5, r2);        r0.L$0 = r13;        r0.L$1 = null;        r0.L$2 = null;        r0.label = 2;        r12 = kotlinx.coroutines.BuildersKt.withContext(r6, r4, r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0129, code lost:            if (r12 != r1) goto L45;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x012b, code lost:            return r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x012c, code lost:            r13 = r12;        r12 = r13;     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0112, code lost:            r4 = r13;     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f4 A[Catch: all -> 0x013f, TRY_LEAVE, TryCatch #0 {all -> 0x013f, blocks: (B:25:0x00e9, B:27:0x00f4, B:31:0x00fe, B:38:0x010c, B:39:0x0113, B:44:0x0133, B:45:0x013e), top: B:24:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object forgotPassword(aws.sdk.kotlin.services.cognitoidentityprovider.model.ForgotPasswordRequest r12, kotlin.coroutines.Continuation<? super aws.sdk.kotlin.services.cognitoidentityprovider.model.ForgotPasswordResponse> r13) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient.forgotPassword(aws.sdk.kotlin.services.cognitoidentityprovider.model.ForgotPasswordRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0108, code lost:            if (r6 == null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010a, code lost:            if (r8 != null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x010c, code lost:            r4 = new aws.smithy.kotlin.runtime.tracing.WrappedRootSpan(r13, r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0113, code lost:            r6 = new aws.smithy.kotlin.runtime.tracing.TraceSpanContextElement(r4);        r4 = new aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient$getUser$$inlined$withRootTraceSpan$1(null, r12, r5, r2);        r0.L$0 = r13;        r0.L$1 = null;        r0.L$2 = null;        r0.label = 2;        r12 = kotlinx.coroutines.BuildersKt.withContext(r6, r4, r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0129, code lost:            if (r12 != r1) goto L45;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x012b, code lost:            return r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x012c, code lost:            r13 = r12;        r12 = r13;     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0112, code lost:            r4 = r13;     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f4 A[Catch: all -> 0x013f, TRY_LEAVE, TryCatch #0 {all -> 0x013f, blocks: (B:25:0x00e9, B:27:0x00f4, B:31:0x00fe, B:38:0x010c, B:39:0x0113, B:44:0x0133, B:45:0x013e), top: B:24:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getUser(aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserRequest r12, kotlin.coroutines.Continuation<? super aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserResponse> r13) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient.getUser(aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0108, code lost:            if (r6 == null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010a, code lost:            if (r8 != null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x010c, code lost:            r4 = new aws.smithy.kotlin.runtime.tracing.WrappedRootSpan(r13, r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0113, code lost:            r6 = new aws.smithy.kotlin.runtime.tracing.TraceSpanContextElement(r4);        r4 = new aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient$getUserAttributeVerificationCode$$inlined$withRootTraceSpan$1(null, r12, r5, r2);        r0.L$0 = r13;        r0.L$1 = null;        r0.L$2 = null;        r0.label = 2;        r12 = kotlinx.coroutines.BuildersKt.withContext(r6, r4, r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0129, code lost:            if (r12 != r1) goto L45;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x012b, code lost:            return r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x012c, code lost:            r13 = r12;        r12 = r13;     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0112, code lost:            r4 = r13;     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f4 A[Catch: all -> 0x013f, TRY_LEAVE, TryCatch #0 {all -> 0x013f, blocks: (B:25:0x00e9, B:27:0x00f4, B:31:0x00fe, B:38:0x010c, B:39:0x0113, B:44:0x0133, B:45:0x013e), top: B:24:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getUserAttributeVerificationCode(aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeRequest r12, kotlin.coroutines.Continuation<? super aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeResponse> r13) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient.getUserAttributeVerificationCode(aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0108, code lost:            if (r6 == null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010a, code lost:            if (r8 != null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x010c, code lost:            r4 = new aws.smithy.kotlin.runtime.tracing.WrappedRootSpan(r13, r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0113, code lost:            r6 = new aws.smithy.kotlin.runtime.tracing.TraceSpanContextElement(r4);        r4 = new aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient$globalSignOut$$inlined$withRootTraceSpan$1(null, r12, r5, r2);        r0.L$0 = r13;        r0.L$1 = null;        r0.L$2 = null;        r0.label = 2;        r12 = kotlinx.coroutines.BuildersKt.withContext(r6, r4, r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0129, code lost:            if (r12 != r1) goto L45;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x012b, code lost:            return r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x012c, code lost:            r13 = r12;        r12 = r13;     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0112, code lost:            r4 = r13;     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f4 A[Catch: all -> 0x013f, TRY_LEAVE, TryCatch #0 {all -> 0x013f, blocks: (B:25:0x00e9, B:27:0x00f4, B:31:0x00fe, B:38:0x010c, B:39:0x0113, B:44:0x0133, B:45:0x013e), top: B:24:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object globalSignOut(aws.sdk.kotlin.services.cognitoidentityprovider.model.GlobalSignOutRequest r12, kotlin.coroutines.Continuation<? super aws.sdk.kotlin.services.cognitoidentityprovider.model.GlobalSignOutResponse> r13) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient.globalSignOut(aws.sdk.kotlin.services.cognitoidentityprovider.model.GlobalSignOutRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0108, code lost:            if (r6 == null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010a, code lost:            if (r8 != null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x010c, code lost:            r4 = new aws.smithy.kotlin.runtime.tracing.WrappedRootSpan(r13, r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0113, code lost:            r6 = new aws.smithy.kotlin.runtime.tracing.TraceSpanContextElement(r4);        r4 = new aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient$initiateAuth$$inlined$withRootTraceSpan$1(null, r12, r5, r2);        r0.L$0 = r13;        r0.L$1 = null;        r0.L$2 = null;        r0.label = 2;        r12 = kotlinx.coroutines.BuildersKt.withContext(r6, r4, r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0129, code lost:            if (r12 != r1) goto L45;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x012b, code lost:            return r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x012c, code lost:            r13 = r12;        r12 = r13;     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0112, code lost:            r4 = r13;     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f4 A[Catch: all -> 0x013f, TRY_LEAVE, TryCatch #0 {all -> 0x013f, blocks: (B:25:0x00e9, B:27:0x00f4, B:31:0x00fe, B:38:0x010c, B:39:0x0113, B:44:0x0133, B:45:0x013e), top: B:24:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object initiateAuth(aws.sdk.kotlin.services.cognitoidentityprovider.model.InitiateAuthRequest r12, kotlin.coroutines.Continuation<? super aws.sdk.kotlin.services.cognitoidentityprovider.model.InitiateAuthResponse> r13) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient.initiateAuth(aws.sdk.kotlin.services.cognitoidentityprovider.model.InitiateAuthRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0108, code lost:            if (r6 == null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010a, code lost:            if (r8 != null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x010c, code lost:            r4 = new aws.smithy.kotlin.runtime.tracing.WrappedRootSpan(r13, r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0113, code lost:            r6 = new aws.smithy.kotlin.runtime.tracing.TraceSpanContextElement(r4);        r4 = new aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient$listDevices$$inlined$withRootTraceSpan$1(null, r12, r5, r2);        r0.L$0 = r13;        r0.L$1 = null;        r0.L$2 = null;        r0.label = 2;        r12 = kotlinx.coroutines.BuildersKt.withContext(r6, r4, r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0129, code lost:            if (r12 != r1) goto L45;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x012b, code lost:            return r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x012c, code lost:            r13 = r12;        r12 = r13;     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0112, code lost:            r4 = r13;     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f4 A[Catch: all -> 0x013f, TRY_LEAVE, TryCatch #0 {all -> 0x013f, blocks: (B:25:0x00e9, B:27:0x00f4, B:31:0x00fe, B:38:0x010c, B:39:0x0113, B:44:0x0133, B:45:0x013e), top: B:24:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object listDevices(aws.sdk.kotlin.services.cognitoidentityprovider.model.ListDevicesRequest r12, kotlin.coroutines.Continuation<? super aws.sdk.kotlin.services.cognitoidentityprovider.model.ListDevicesResponse> r13) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient.listDevices(aws.sdk.kotlin.services.cognitoidentityprovider.model.ListDevicesRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Unit mergeServiceDefaults(ExecutionContext executionContext) {
        CognitoIdentityProviderClient.Config config = this.config;
        AttributesKt.putIfAbsent(executionContext, AwsClientOption.Region, config.region);
        AttributesKt.putIfAbsent(executionContext, SetsKt__SetsKt.ServiceName, "Cognito Identity Provider");
        AttributesKt.putIfAbsent(executionContext, SetsKt__SetsKt.LogMode, config.sdkLogMode);
        AttributesKt.putIfAbsent(executionContext, AwsSigningAttributes.SigningService, "cognito-idp");
        AttributesKt.putIfAbsent(executionContext, AwsSigningAttributes.Signer, config.signer);
        AttributesKt.putIfAbsent(executionContext, AwsSigningAttributes.SigningRegion, config.region);
        AttributesKt.putIfAbsent(executionContext, AwsSigningAttributes.CredentialsProvider, config.credentialsProvider);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0108, code lost:            if (r6 == null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010a, code lost:            if (r8 != null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x010c, code lost:            r4 = new aws.smithy.kotlin.runtime.tracing.WrappedRootSpan(r13, r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0113, code lost:            r6 = new aws.smithy.kotlin.runtime.tracing.TraceSpanContextElement(r4);        r4 = new aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient$resendConfirmationCode$$inlined$withRootTraceSpan$1(null, r12, r5, r2);        r0.L$0 = r13;        r0.L$1 = null;        r0.L$2 = null;        r0.label = 2;        r12 = kotlinx.coroutines.BuildersKt.withContext(r6, r4, r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0129, code lost:            if (r12 != r1) goto L45;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x012b, code lost:            return r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x012c, code lost:            r13 = r12;        r12 = r13;     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0112, code lost:            r4 = r13;     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f4 A[Catch: all -> 0x013f, TRY_LEAVE, TryCatch #0 {all -> 0x013f, blocks: (B:25:0x00e9, B:27:0x00f4, B:31:0x00fe, B:38:0x010c, B:39:0x0113, B:44:0x0133, B:45:0x013e), top: B:24:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object resendConfirmationCode(aws.sdk.kotlin.services.cognitoidentityprovider.model.ResendConfirmationCodeRequest r12, kotlin.coroutines.Continuation<? super aws.sdk.kotlin.services.cognitoidentityprovider.model.ResendConfirmationCodeResponse> r13) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient.resendConfirmationCode(aws.sdk.kotlin.services.cognitoidentityprovider.model.ResendConfirmationCodeRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0108, code lost:            if (r6 == null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010a, code lost:            if (r8 != null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x010c, code lost:            r4 = new aws.smithy.kotlin.runtime.tracing.WrappedRootSpan(r13, r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0113, code lost:            r6 = new aws.smithy.kotlin.runtime.tracing.TraceSpanContextElement(r4);        r4 = new aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient$respondToAuthChallenge$$inlined$withRootTraceSpan$1(null, r12, r5, r2);        r0.L$0 = r13;        r0.L$1 = null;        r0.L$2 = null;        r0.label = 2;        r12 = kotlinx.coroutines.BuildersKt.withContext(r6, r4, r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0129, code lost:            if (r12 != r1) goto L45;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x012b, code lost:            return r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x012c, code lost:            r13 = r12;        r12 = r13;     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0112, code lost:            r4 = r13;     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f4 A[Catch: all -> 0x013f, TRY_LEAVE, TryCatch #0 {all -> 0x013f, blocks: (B:25:0x00e9, B:27:0x00f4, B:31:0x00fe, B:38:0x010c, B:39:0x0113, B:44:0x0133, B:45:0x013e), top: B:24:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object respondToAuthChallenge(aws.sdk.kotlin.services.cognitoidentityprovider.model.RespondToAuthChallengeRequest r12, kotlin.coroutines.Continuation<? super aws.sdk.kotlin.services.cognitoidentityprovider.model.RespondToAuthChallengeResponse> r13) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient.respondToAuthChallenge(aws.sdk.kotlin.services.cognitoidentityprovider.model.RespondToAuthChallengeRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0108, code lost:            if (r6 == null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010a, code lost:            if (r8 != null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x010c, code lost:            r4 = new aws.smithy.kotlin.runtime.tracing.WrappedRootSpan(r13, r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0113, code lost:            r6 = new aws.smithy.kotlin.runtime.tracing.TraceSpanContextElement(r4);        r4 = new aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient$revokeToken$$inlined$withRootTraceSpan$1(null, r12, r5, r2);        r0.L$0 = r13;        r0.L$1 = null;        r0.L$2 = null;        r0.label = 2;        r12 = kotlinx.coroutines.BuildersKt.withContext(r6, r4, r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0129, code lost:            if (r12 != r1) goto L45;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x012b, code lost:            return r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x012c, code lost:            r13 = r12;        r12 = r13;     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0112, code lost:            r4 = r13;     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f4 A[Catch: all -> 0x013f, TRY_LEAVE, TryCatch #0 {all -> 0x013f, blocks: (B:25:0x00e9, B:27:0x00f4, B:31:0x00fe, B:38:0x010c, B:39:0x0113, B:44:0x0133, B:45:0x013e), top: B:24:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object revokeToken(aws.sdk.kotlin.services.cognitoidentityprovider.model.RevokeTokenRequest r12, kotlin.coroutines.Continuation<? super aws.sdk.kotlin.services.cognitoidentityprovider.model.RevokeTokenResponse> r13) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient.revokeToken(aws.sdk.kotlin.services.cognitoidentityprovider.model.RevokeTokenRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0108, code lost:            if (r6 == null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010a, code lost:            if (r8 != null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x010c, code lost:            r4 = new aws.smithy.kotlin.runtime.tracing.WrappedRootSpan(r13, r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0113, code lost:            r6 = new aws.smithy.kotlin.runtime.tracing.TraceSpanContextElement(r4);        r4 = new aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient$signUp$$inlined$withRootTraceSpan$1(null, r12, r5, r2);        r0.L$0 = r13;        r0.L$1 = null;        r0.L$2 = null;        r0.label = 2;        r12 = kotlinx.coroutines.BuildersKt.withContext(r6, r4, r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0129, code lost:            if (r12 != r1) goto L45;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x012b, code lost:            return r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x012c, code lost:            r13 = r12;        r12 = r13;     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0112, code lost:            r4 = r13;     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f4 A[Catch: all -> 0x013f, TRY_LEAVE, TryCatch #0 {all -> 0x013f, blocks: (B:25:0x00e9, B:27:0x00f4, B:31:0x00fe, B:38:0x010c, B:39:0x0113, B:44:0x0133, B:45:0x013e), top: B:24:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object signUp(aws.sdk.kotlin.services.cognitoidentityprovider.model.SignUpRequest r12, kotlin.coroutines.Continuation<? super aws.sdk.kotlin.services.cognitoidentityprovider.model.SignUpResponse> r13) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient.signUp(aws.sdk.kotlin.services.cognitoidentityprovider.model.SignUpRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0108, code lost:            if (r6 == null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010a, code lost:            if (r8 != null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x010c, code lost:            r4 = new aws.smithy.kotlin.runtime.tracing.WrappedRootSpan(r13, r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0113, code lost:            r6 = new aws.smithy.kotlin.runtime.tracing.TraceSpanContextElement(r4);        r4 = new aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient$updateDeviceStatus$$inlined$withRootTraceSpan$1(null, r12, r5, r2);        r0.L$0 = r13;        r0.L$1 = null;        r0.L$2 = null;        r0.label = 2;        r12 = kotlinx.coroutines.BuildersKt.withContext(r6, r4, r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0129, code lost:            if (r12 != r1) goto L45;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x012b, code lost:            return r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x012c, code lost:            r13 = r12;        r12 = r13;     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0112, code lost:            r4 = r13;     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f4 A[Catch: all -> 0x013f, TRY_LEAVE, TryCatch #0 {all -> 0x013f, blocks: (B:25:0x00e9, B:27:0x00f4, B:31:0x00fe, B:38:0x010c, B:39:0x0113, B:44:0x0133, B:45:0x013e), top: B:24:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object updateDeviceStatus(aws.sdk.kotlin.services.cognitoidentityprovider.model.UpdateDeviceStatusRequest r12, kotlin.coroutines.Continuation<? super aws.sdk.kotlin.services.cognitoidentityprovider.model.UpdateDeviceStatusResponse> r13) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient.updateDeviceStatus(aws.sdk.kotlin.services.cognitoidentityprovider.model.UpdateDeviceStatusRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0108, code lost:            if (r6 == null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010a, code lost:            if (r8 != null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x010c, code lost:            r4 = new aws.smithy.kotlin.runtime.tracing.WrappedRootSpan(r13, r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0113, code lost:            r6 = new aws.smithy.kotlin.runtime.tracing.TraceSpanContextElement(r4);        r4 = new aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient$updateUserAttributes$$inlined$withRootTraceSpan$1(null, r12, r5, r2);        r0.L$0 = r13;        r0.L$1 = null;        r0.L$2 = null;        r0.label = 2;        r12 = kotlinx.coroutines.BuildersKt.withContext(r6, r4, r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0129, code lost:            if (r12 != r1) goto L45;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x012b, code lost:            return r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x012c, code lost:            r13 = r12;        r12 = r13;     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0112, code lost:            r4 = r13;     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f4 A[Catch: all -> 0x013f, TRY_LEAVE, TryCatch #0 {all -> 0x013f, blocks: (B:25:0x00e9, B:27:0x00f4, B:31:0x00fe, B:38:0x010c, B:39:0x0113, B:44:0x0133, B:45:0x013e), top: B:24:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object updateUserAttributes(aws.sdk.kotlin.services.cognitoidentityprovider.model.UpdateUserAttributesRequest r12, kotlin.coroutines.Continuation<? super aws.sdk.kotlin.services.cognitoidentityprovider.model.UpdateUserAttributesResponse> r13) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient.updateUserAttributes(aws.sdk.kotlin.services.cognitoidentityprovider.model.UpdateUserAttributesRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0108, code lost:            if (r6 == null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010a, code lost:            if (r8 != null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x010c, code lost:            r4 = new aws.smithy.kotlin.runtime.tracing.WrappedRootSpan(r13, r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0113, code lost:            r6 = new aws.smithy.kotlin.runtime.tracing.TraceSpanContextElement(r4);        r4 = new aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient$verifyUserAttribute$$inlined$withRootTraceSpan$1(null, r12, r5, r2);        r0.L$0 = r13;        r0.L$1 = null;        r0.L$2 = null;        r0.label = 2;        r12 = kotlinx.coroutines.BuildersKt.withContext(r6, r4, r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0129, code lost:            if (r12 != r1) goto L45;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x012b, code lost:            return r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x012c, code lost:            r13 = r12;        r12 = r13;     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0112, code lost:            r4 = r13;     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f4 A[Catch: all -> 0x013f, TRY_LEAVE, TryCatch #0 {all -> 0x013f, blocks: (B:25:0x00e9, B:27:0x00f4, B:31:0x00fe, B:38:0x010c, B:39:0x0113, B:44:0x0133, B:45:0x013e), top: B:24:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object verifyUserAttribute(aws.sdk.kotlin.services.cognitoidentityprovider.model.VerifyUserAttributeRequest r12, kotlin.coroutines.Continuation<? super aws.sdk.kotlin.services.cognitoidentityprovider.model.VerifyUserAttributeResponse> r13) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient.verifyUserAttribute(aws.sdk.kotlin.services.cognitoidentityprovider.model.VerifyUserAttributeRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
