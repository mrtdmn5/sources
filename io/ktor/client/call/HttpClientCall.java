package io.ktor.client.call;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HttpClientCall.kt */
/* loaded from: classes3.dex */
public class HttpClientCall implements CoroutineScope {
    public static final AttributeKey<Object> CustomResponse = new AttributeKey<>("CustomResponse");
    public static final /* synthetic */ AtomicIntegerFieldUpdater received$FU = AtomicIntegerFieldUpdater.newUpdater(HttpClientCall.class, "received");
    public final HttpClient client;
    private volatile /* synthetic */ int received;
    public HttpRequest request;
    public HttpResponse response;

    public HttpClientCall(HttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
        this.received = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00be A[Catch: all -> 0x00e2, TryCatch #1 {all -> 0x00e2, blocks: (B:12:0x002c, B:13:0x00ad, B:17:0x00be, B:20:0x00ce, B:21:0x00e1), top: B:11:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ab A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object bodyNullable(io.ktor.util.reflect.TypeInfo r8, kotlin.coroutines.Continuation<java.lang.Object> r9) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.call.HttpClientCall.bodyNullable(io.ktor.util.reflect.TypeInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean getAllowDoubleReceive() {
        return false;
    }

    public final Attributes getAttributes() {
        return getRequest().getAttributes();
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return getResponse().getCoroutineContext();
    }

    public final HttpRequest getRequest() {
        HttpRequest httpRequest = this.request;
        if (httpRequest != null) {
            return httpRequest;
        }
        Intrinsics.throwUninitializedPropertyAccessException("request");
        throw null;
    }

    public final HttpResponse getResponse() {
        HttpResponse httpResponse = this.response;
        if (httpResponse != null) {
            return httpResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        throw null;
    }

    public Object getResponseContent() {
        return getResponse().getContent();
    }

    public final String toString() {
        return "HttpClientCall[" + getRequest().getUrl() + ", " + getResponse().getStatus() + ']';
    }
}
