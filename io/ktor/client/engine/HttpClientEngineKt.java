package io.ktor.client.engine;

import io.ktor.client.HttpClientConfig;
import io.ktor.util.AttributeKey;
import kotlinx.coroutines.CoroutineName;

/* compiled from: HttpClientEngine.kt */
/* loaded from: classes3.dex */
public final class HttpClientEngineKt {
    public static final CoroutineName CALL_COROUTINE = new CoroutineName("call-context");
    public static final AttributeKey<HttpClientConfig<?>> CLIENT_CONFIG = new AttributeKey<>("client-config");
}
