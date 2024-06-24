package io.ktor.client;

import io.ktor.client.engine.HttpClientEngineConfig;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: HttpClientConfig.kt */
/* loaded from: classes3.dex */
public final class HttpClientConfig$engineConfig$1<T> extends Lambda implements Function1<T, Unit> {
    public static final HttpClientConfig$engineConfig$1 INSTANCE = new HttpClientConfig$engineConfig$1();

    public HttpClientConfig$engineConfig$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Object obj) {
        Intrinsics.checkNotNullParameter((HttpClientEngineConfig) obj, "$this$null");
        return Unit.INSTANCE;
    }
}
