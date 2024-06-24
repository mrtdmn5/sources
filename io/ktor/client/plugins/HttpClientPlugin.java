package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.util.AttributeKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: HttpClientPlugin.kt */
/* loaded from: classes3.dex */
public interface HttpClientPlugin<TConfig, TPlugin> {
    AttributeKey<TPlugin> getKey();

    void install(HttpClient httpClient, Object obj);

    TPlugin prepare(Function1<? super TConfig, Unit> function1);
}
