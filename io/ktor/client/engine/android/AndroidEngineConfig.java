package io.ktor.client.engine.android;

import io.ktor.client.engine.HttpClientEngineConfig;

/* compiled from: AndroidEngineConfig.kt */
/* loaded from: classes3.dex */
public final class AndroidEngineConfig extends HttpClientEngineConfig {
    public final int connectTimeout = 100000;
    public final int socketTimeout = 100000;
    public final AndroidEngineConfig$sslManager$1 sslManager = AndroidEngineConfig$sslManager$1.INSTANCE;
    public final AndroidEngineConfig$requestConfig$1 requestConfig = AndroidEngineConfig$requestConfig$1.INSTANCE;
}
