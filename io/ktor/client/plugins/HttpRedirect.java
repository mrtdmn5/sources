package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpSend;
import io.ktor.client.statement.HttpResponse;
import io.ktor.events.EventDefinition;
import io.ktor.util.AttributeKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpRedirect.kt */
/* loaded from: classes3.dex */
public final class HttpRedirect {
    public static final Plugin Plugin = new Plugin();
    public static final AttributeKey<HttpRedirect> key = new AttributeKey<>("HttpRedirect");
    public static final EventDefinition<HttpResponse> HttpResponseRedirect = new EventDefinition<>();
    public final boolean checkHttpMethod = true;
    public final boolean allowHttpsDowngrade = false;

    /* compiled from: HttpRedirect.kt */
    /* loaded from: classes3.dex */
    public static final class Config {
    }

    /* compiled from: HttpRedirect.kt */
    /* loaded from: classes3.dex */
    public static final class Plugin implements HttpClientPlugin<Config, HttpRedirect> {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:12:0x022c  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x022f  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0167  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x016e  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x01cf  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x020e  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0210  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x01c1  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
        /* JADX WARN: Type inference failed for: r14v7, types: [T, io.ktor.client.request.HttpRequestBuilder] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0210 -> B:10:0x0218). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static final java.lang.Object access$handleCall(io.ktor.client.plugins.HttpRedirect.Plugin r21, io.ktor.client.plugins.Sender r22, io.ktor.client.request.HttpRequestBuilder r23, io.ktor.client.call.HttpClientCall r24, boolean r25, io.ktor.client.HttpClient r26, kotlin.coroutines.Continuation r27) {
            /*
                Method dump skipped, instructions count: 565
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpRedirect.Plugin.access$handleCall(io.ktor.client.plugins.HttpRedirect$Plugin, io.ktor.client.plugins.Sender, io.ktor.client.request.HttpRequestBuilder, io.ktor.client.call.HttpClientCall, boolean, io.ktor.client.HttpClient, kotlin.coroutines.Continuation):java.lang.Object");
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final AttributeKey<HttpRedirect> getKey() {
            return HttpRedirect.key;
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final void install(HttpClient scope, Object obj) {
            HttpRedirect plugin = (HttpRedirect) obj;
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            HttpSend.Plugin plugin2 = HttpSend.Plugin;
            HttpSend httpSend = (HttpSend) HttpClientPluginKt.plugin(scope);
            httpSend.interceptors.add(new HttpRedirect$Plugin$install$1(plugin, scope, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final HttpRedirect prepare(Function1<? super Config, Unit> function1) {
            function1.invoke(new Config());
            return new HttpRedirect();
        }
    }
}
