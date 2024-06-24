package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.util.AttributeKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpRequestLifecycle.kt */
/* loaded from: classes3.dex */
public final class HttpRequestLifecycle {
    public static final Plugin Plugin = new Plugin();
    public static final AttributeKey<HttpRequestLifecycle> key = new AttributeKey<>("RequestLifecycle");

    /* compiled from: HttpRequestLifecycle.kt */
    /* loaded from: classes3.dex */
    public static final class Plugin implements HttpClientPlugin<Unit, HttpRequestLifecycle> {
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final AttributeKey<HttpRequestLifecycle> getKey() {
            return HttpRequestLifecycle.key;
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final void install(HttpClient scope, Object obj) {
            HttpRequestLifecycle plugin = (HttpRequestLifecycle) obj;
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            scope.requestPipeline.intercept(HttpRequestPipeline.Before, new HttpRequestLifecycle$Plugin$install$1(scope, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final HttpRequestLifecycle prepare(Function1<? super Unit, Unit> function1) {
            return new HttpRequestLifecycle();
        }
    }
}
