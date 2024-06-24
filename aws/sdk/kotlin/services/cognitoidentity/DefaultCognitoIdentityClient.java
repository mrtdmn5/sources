package aws.sdk.kotlin.services.cognitoidentity;

import aws.sdk.kotlin.runtime.client.AwsClientOption;
import aws.sdk.kotlin.runtime.http.ApiMetadata;
import aws.sdk.kotlin.runtime.http.AwsUserAgentMetadata;
import aws.sdk.kotlin.services.cognitoidentity.CognitoIdentityClient;
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

/* compiled from: DefaultCognitoIdentityClient.kt */
/* loaded from: classes.dex */
public final class DefaultCognitoIdentityClient implements CognitoIdentityClient {
    public final AwsUserAgentMetadata awsUserAgentMetadata;
    public final SdkHttpClient client;
    public final CognitoIdentityClient.Config config;
    public final SdkManagedGroup managedResources;

    public DefaultCognitoIdentityClient(CognitoIdentityClient.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        SdkManagedGroup sdkManagedGroup = new SdkManagedGroup(0);
        this.managedResources = sdkManagedGroup;
        CloseableHttpClientEngine closeableHttpClientEngine = config.httpClientEngine;
        this.client = new SdkHttpClient(closeableHttpClientEngine);
        SdkManagedGroupKt.addIfManaged(sdkManagedGroup, closeableHttpClientEngine);
        SdkManagedGroupKt.addIfManaged(sdkManagedGroup, config.credentialsProvider);
        this.awsUserAgentMetadata = AwsUserAgentMetadata.Companion.fromEnvironment(new ApiMetadata("Cognito Identity", "0.21.1-beta"));
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
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0113, code lost:            r6 = new aws.smithy.kotlin.runtime.tracing.TraceSpanContextElement(r4);        r4 = new aws.sdk.kotlin.services.cognitoidentity.DefaultCognitoIdentityClient$getCredentialsForIdentity$$inlined$withRootTraceSpan$1(null, r12, r5, r2);        r0.L$0 = r13;        r0.L$1 = null;        r0.L$2 = null;        r0.label = 2;        r12 = kotlinx.coroutines.BuildersKt.withContext(r6, r4, r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0129, code lost:            if (r12 != r1) goto L45;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x012b, code lost:            return r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x012c, code lost:            r13 = r12;        r12 = r13;     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0112, code lost:            r4 = r13;     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f4 A[Catch: all -> 0x013f, TRY_LEAVE, TryCatch #0 {all -> 0x013f, blocks: (B:25:0x00e9, B:27:0x00f4, B:31:0x00fe, B:38:0x010c, B:39:0x0113, B:44:0x0133, B:45:0x013e), top: B:24:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // aws.sdk.kotlin.services.cognitoidentity.CognitoIdentityClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getCredentialsForIdentity(aws.sdk.kotlin.services.cognitoidentity.model.GetCredentialsForIdentityRequest r12, kotlin.coroutines.Continuation<? super aws.sdk.kotlin.services.cognitoidentity.model.GetCredentialsForIdentityResponse> r13) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.services.cognitoidentity.DefaultCognitoIdentityClient.getCredentialsForIdentity(aws.sdk.kotlin.services.cognitoidentity.model.GetCredentialsForIdentityRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0108, code lost:            if (r6 == null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010a, code lost:            if (r8 != null) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x010c, code lost:            r4 = new aws.smithy.kotlin.runtime.tracing.WrappedRootSpan(r13, r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0113, code lost:            r6 = new aws.smithy.kotlin.runtime.tracing.TraceSpanContextElement(r4);        r4 = new aws.sdk.kotlin.services.cognitoidentity.DefaultCognitoIdentityClient$getId$$inlined$withRootTraceSpan$1(null, r12, r5, r2);        r0.L$0 = r13;        r0.L$1 = null;        r0.L$2 = null;        r0.label = 2;        r12 = kotlinx.coroutines.BuildersKt.withContext(r6, r4, r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0129, code lost:            if (r12 != r1) goto L45;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x012b, code lost:            return r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x012c, code lost:            r13 = r12;        r12 = r13;     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0112, code lost:            r4 = r13;     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f4 A[Catch: all -> 0x013f, TRY_LEAVE, TryCatch #0 {all -> 0x013f, blocks: (B:25:0x00e9, B:27:0x00f4, B:31:0x00fe, B:38:0x010c, B:39:0x0113, B:44:0x0133, B:45:0x013e), top: B:24:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // aws.sdk.kotlin.services.cognitoidentity.CognitoIdentityClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getId(aws.sdk.kotlin.services.cognitoidentity.model.GetIdRequest r12, kotlin.coroutines.Continuation<? super aws.sdk.kotlin.services.cognitoidentity.model.GetIdResponse> r13) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.services.cognitoidentity.DefaultCognitoIdentityClient.getId(aws.sdk.kotlin.services.cognitoidentity.model.GetIdRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Unit mergeServiceDefaults(ExecutionContext executionContext) {
        CognitoIdentityClient.Config config = this.config;
        AttributesKt.putIfAbsent(executionContext, AwsClientOption.Region, config.region);
        AttributesKt.putIfAbsent(executionContext, SetsKt__SetsKt.ServiceName, "Cognito Identity");
        AttributesKt.putIfAbsent(executionContext, SetsKt__SetsKt.LogMode, config.sdkLogMode);
        AttributesKt.putIfAbsent(executionContext, AwsSigningAttributes.SigningService, "cognito-identity");
        AttributesKt.putIfAbsent(executionContext, AwsSigningAttributes.Signer, config.signer);
        AttributesKt.putIfAbsent(executionContext, AwsSigningAttributes.SigningRegion, config.region);
        AttributesKt.putIfAbsent(executionContext, AwsSigningAttributes.CredentialsProvider, config.credentialsProvider);
        return Unit.INSTANCE;
    }
}
