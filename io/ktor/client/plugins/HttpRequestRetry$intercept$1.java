package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: HttpRequestRetry.kt */
@DebugMetadata(c = "io.ktor.client.plugins.HttpRequestRetry$intercept$1", f = "HttpRequestRetry.kt", l = {298, 314}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class HttpRequestRetry$intercept$1 extends SuspendLambda implements Function3<Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> {
    public final /* synthetic */ HttpClient $client;
    public int I$0;
    public int I$1;
    public /* synthetic */ Sender L$0;
    public /* synthetic */ HttpRequestBuilder L$1;
    public Function3 L$2;
    public Function3 L$3;
    public Function2 L$4;
    public Function2 L$5;
    public Object L$6;
    public int label;
    public final /* synthetic */ HttpRequestRetry this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpRequestRetry$intercept$1(HttpRequestRetry httpRequestRetry, HttpClient httpClient, Continuation<? super HttpRequestRetry$intercept$1> continuation) {
        super(3, continuation);
        this.this$0 = httpRequestRetry;
        this.$client = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Sender sender, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpClientCall> continuation) {
        HttpRequestRetry$intercept$1 httpRequestRetry$intercept$1 = new HttpRequestRetry$intercept$1(this.this$0, this.$client, continuation);
        httpRequestRetry$intercept$1.L$0 = sender;
        httpRequestRetry$intercept$1.L$1 = httpRequestBuilder;
        return httpRequestRetry$intercept$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00f7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0103 A[Catch: all -> 0x0134, TryCatch #0 {all -> 0x0134, blocks: (B:40:0x00d5, B:10:0x00dd, B:14:0x00f8, B:16:0x0103, B:21:0x0124), top: B:39:0x00d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0123 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0124 A[Catch: all -> 0x0134, TRY_LEAVE, TryCatch #0 {all -> 0x0134, blocks: (B:40:0x00d5, B:10:0x00dd, B:14:0x00f8, B:16:0x0103, B:21:0x0124), top: B:39:0x00d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x01a4 -> B:6:0x002e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 457
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpRequestRetry$intercept$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
