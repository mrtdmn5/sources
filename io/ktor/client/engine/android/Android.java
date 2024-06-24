package io.ktor.client.engine.android;

import io.ktor.client.HttpClientConfig$engineConfig$1;
import io.ktor.client.engine.HttpClientEngineFactory;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Android.kt */
/* loaded from: classes3.dex */
public final class Android implements HttpClientEngineFactory<AndroidEngineConfig> {
    public static final Android INSTANCE = new Android();

    @Override // io.ktor.client.engine.HttpClientEngineFactory
    public final AndroidClientEngine create(HttpClientConfig$engineConfig$1 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        AndroidEngineConfig androidEngineConfig = new AndroidEngineConfig();
        block.invoke(androidEngineConfig);
        return new AndroidClientEngine(androidEngineConfig);
    }
}
