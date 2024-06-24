package io.ktor.client.plugins;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.coroutines.Continuation;

/* compiled from: HttpSend.kt */
/* loaded from: classes3.dex */
public interface Sender {
    Object execute(HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpClientCall> continuation);
}
