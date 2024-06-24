package aws.sdk.kotlin.runtime.config.imds;

import aws.smithy.kotlin.runtime.http.SdkHttpClient;
import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperation;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.io.middleware.ModifyRequest;
import aws.smithy.kotlin.runtime.io.middleware.ModifyRequestMiddleware;
import aws.smithy.kotlin.runtime.io.middleware.ModifyRequestMiddleware$handle$1;
import aws.smithy.kotlin.runtime.io.middleware.Phase;
import aws.smithy.kotlin.runtime.time.Clock;
import aws.smithy.kotlin.runtime.util.CachedValue;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* compiled from: TokenMiddleware.kt */
/* loaded from: classes.dex */
public final class TokenMiddleware implements ModifyRequest {
    public final CachedValue<Token> cachedToken;
    public final Clock clock;
    public final SdkHttpClient httpClient;
    public final long ttl;

    public TokenMiddleware(SdkHttpClient sdkHttpClient, long j, Clock.System system) {
        this.httpClient = sdkHttpClient;
        this.ttl = j;
        this.clock = system;
        int r2 = Duration.$r8$clinit;
        this.cachedToken = new CachedValue<>(DurationKt.toDuration(120, DurationUnit.SECONDS), system);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0145 A[Catch: all -> 0x0196, TRY_LEAVE, TryCatch #0 {all -> 0x0196, blocks: (B:21:0x005c, B:22:0x0141, B:24:0x0145, B:30:0x0169, B:31:0x0172, B:34:0x0112, B:37:0x0120, B:39:0x012a, B:44:0x0173, B:45:0x017c, B:46:0x017d, B:49:0x018c, B:50:0x0195), top: B:7:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0169 A[Catch: all -> 0x0196, TRY_ENTER, TryCatch #0 {all -> 0x0196, blocks: (B:21:0x005c, B:22:0x0141, B:24:0x0145, B:30:0x0169, B:31:0x0172, B:34:0x0112, B:37:0x0120, B:39:0x012a, B:44:0x0173, B:45:0x017c, B:46:0x017d, B:49:0x018c, B:50:0x0195), top: B:7:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0120 A[Catch: all -> 0x0196, TRY_ENTER, TryCatch #0 {all -> 0x0196, blocks: (B:21:0x005c, B:22:0x0141, B:24:0x0145, B:30:0x0169, B:31:0x0172, B:34:0x0112, B:37:0x0120, B:39:0x012a, B:44:0x0173, B:45:0x017c, B:46:0x017d, B:49:0x018c, B:50:0x0195), top: B:7:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x017d A[Catch: all -> 0x0196, TryCatch #0 {all -> 0x0196, blocks: (B:21:0x005c, B:22:0x0141, B:24:0x0145, B:30:0x0169, B:31:0x0172, B:34:0x0112, B:37:0x0120, B:39:0x012a, B:44:0x0173, B:45:0x017c, B:46:0x017d, B:49:0x018c, B:50:0x0195), top: B:7:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0031  */
    /* JADX WARN: Type inference failed for: r5v0, types: [aws.smithy.kotlin.runtime.http.response.HttpCall, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object access$getToken(aws.sdk.kotlin.runtime.config.imds.TokenMiddleware r17, aws.smithy.kotlin.runtime.time.Clock r18, final aws.smithy.kotlin.runtime.http.operation.OperationRequest r19, kotlin.coroutines.Continuation r20) {
        /*
            Method dump skipped, instructions count: 434
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.runtime.config.imds.TokenMiddleware.access$getToken(aws.sdk.kotlin.runtime.config.imds.TokenMiddleware, aws.smithy.kotlin.runtime.time.Clock, aws.smithy.kotlin.runtime.http.operation.OperationRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void install(SdkHttpOperation<?, ?> op) {
        Intrinsics.checkNotNullParameter(op, "op");
        Phase<OperationRequest<HttpRequestBuilder>, ?> phase = op.execution.onEachAttempt;
        Phase.Order order = Phase.Order.After;
        phase.getClass();
        Intrinsics.checkNotNullParameter(order, "order");
        phase.register(new ModifyRequestMiddleware(this), order);
    }

    @Override // aws.smithy.kotlin.runtime.io.middleware.ModifyRequest
    public final /* bridge */ /* synthetic */ Object modifyRequest(Object obj, ModifyRequestMiddleware$handle$1 modifyRequestMiddleware$handle$1) {
        return modifyRequest((OperationRequest<HttpRequestBuilder>) obj, (Continuation<? super OperationRequest<HttpRequestBuilder>>) modifyRequestMiddleware$handle$1);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object modifyRequest(aws.smithy.kotlin.runtime.http.operation.OperationRequest<aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder> r5, kotlin.coroutines.Continuation<? super aws.smithy.kotlin.runtime.http.operation.OperationRequest<aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof aws.sdk.kotlin.runtime.config.imds.TokenMiddleware$modifyRequest$1
            if (r0 == 0) goto L13
            r0 = r6
            aws.sdk.kotlin.runtime.config.imds.TokenMiddleware$modifyRequest$1 r0 = (aws.sdk.kotlin.runtime.config.imds.TokenMiddleware$modifyRequest$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            aws.sdk.kotlin.runtime.config.imds.TokenMiddleware$modifyRequest$1 r0 = new aws.sdk.kotlin.runtime.config.imds.TokenMiddleware$modifyRequest$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            aws.smithy.kotlin.runtime.http.operation.OperationRequest r5 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L47
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            aws.sdk.kotlin.runtime.config.imds.TokenMiddleware$modifyRequest$token$1 r6 = new aws.sdk.kotlin.runtime.config.imds.TokenMiddleware$modifyRequest$token$1
            r2 = 0
            r6.<init>(r4, r5, r2)
            r0.L$0 = r5
            r0.label = r3
            aws.smithy.kotlin.runtime.util.CachedValue<aws.sdk.kotlin.runtime.config.imds.Token> r2 = r4.cachedToken
            java.lang.Object r6 = r2.getOrLoad(r6, r0)
            if (r6 != r1) goto L47
            return r1
        L47:
            aws.sdk.kotlin.runtime.config.imds.Token r6 = (aws.sdk.kotlin.runtime.config.imds.Token) r6
            T r0 = r5.subject
            aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder r0 = (aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder) r0
            aws.smithy.kotlin.runtime.http.HeadersBuilder r0 = r0.headers
            byte[] r6 = r6.value
            java.lang.String r6 = kotlin.text.StringsKt__StringsJVMKt.decodeToString(r6)
            java.lang.String r1 = "x-aws-ec2-metadata-token"
            java.util.List r0 = r0.ensureListForKey(r3, r1)
            r0.add(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.runtime.config.imds.TokenMiddleware.modifyRequest(aws.smithy.kotlin.runtime.http.operation.OperationRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
