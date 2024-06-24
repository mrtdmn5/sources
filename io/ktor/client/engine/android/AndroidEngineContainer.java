package io.ktor.client.engine.android;

import io.ktor.client.HttpClientEngineContainer;
import io.ktor.client.engine.HttpClientEngineFactory;

/* compiled from: Android.kt */
/* loaded from: classes3.dex */
public final class AndroidEngineContainer implements HttpClientEngineContainer {
    public final Android factory = Android.INSTANCE;

    @Override // io.ktor.client.HttpClientEngineContainer
    public HttpClientEngineFactory<?> getFactory() {
        return this.factory;
    }

    public final String toString() {
        return "Android";
    }
}
