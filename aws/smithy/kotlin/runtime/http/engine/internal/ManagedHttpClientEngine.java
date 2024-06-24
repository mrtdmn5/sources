package aws.smithy.kotlin.runtime.http.engine.internal;

import aws.smithy.kotlin.runtime.http.engine.CloseableHttpClientEngine;
import aws.smithy.kotlin.runtime.http.engine.okhttp.OkHttpEngine;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.response.HttpCall;
import aws.smithy.kotlin.runtime.io.SdkManagedCloseable;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* compiled from: ManagedHttpClientEngine.kt */
/* loaded from: classes.dex */
public final class ManagedHttpClientEngine extends SdkManagedCloseable implements CloseableHttpClientEngine {
    public final CloseableHttpClientEngine delegate;

    public ManagedHttpClientEngine(OkHttpEngine okHttpEngine) {
        super(okHttpEngine);
        this.delegate = okHttpEngine;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.delegate.close();
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.delegate.getCoroutineContext();
    }

    @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngine
    public final Object roundTrip(ExecutionContext executionContext, HttpRequest httpRequest, Continuation<? super HttpCall> continuation) {
        return this.delegate.roundTrip(executionContext, httpRequest, continuation);
    }
}
