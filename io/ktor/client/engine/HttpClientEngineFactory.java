package io.ktor.client.engine;

import io.ktor.client.HttpClientConfig$engineConfig$1;
import io.ktor.client.engine.HttpClientEngineConfig;
import io.ktor.client.engine.android.AndroidClientEngine;

/* compiled from: HttpClientEngine.kt */
/* loaded from: classes3.dex */
public interface HttpClientEngineFactory<T extends HttpClientEngineConfig> {
    AndroidClientEngine create(HttpClientConfig$engineConfig$1 httpClientConfig$engineConfig$1);
}
