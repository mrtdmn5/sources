package io.ktor.client;

import io.ktor.client.engine.HttpClientEngineConfig;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.util.Attributes;
import io.ktor.util.ConcurrentSafeAttributes;
import io.ktor.util.PlatformUtils;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpClientConfig.kt */
/* loaded from: classes3.dex */
public final class HttpClientConfig<T extends HttpClientEngineConfig> {
    public boolean expectSuccess;
    public final LinkedHashMap plugins = new LinkedHashMap();
    public final LinkedHashMap pluginConfigurations = new LinkedHashMap();
    public final LinkedHashMap customInterceptors = new LinkedHashMap();
    public final HttpClientConfig$engineConfig$1 engineConfig = HttpClientConfig$engineConfig$1.INSTANCE;
    public boolean followRedirects = true;
    public boolean useDefaultTransformers = true;
    public final boolean developmentMode = PlatformUtils.IS_DEVELOPMENT_MODE;

    public final <TBuilder, TPlugin> void install(final HttpClientPlugin<? extends TBuilder, TPlugin> plugin, final Function1<? super TBuilder, Unit> configure) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(configure, "configure");
        LinkedHashMap linkedHashMap = this.pluginConfigurations;
        final Function1 function1 = (Function1) linkedHashMap.get(plugin.getKey());
        linkedHashMap.put(plugin.getKey(), new Function1<Object, Unit>() { // from class: io.ktor.client.HttpClientConfig$install$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                Intrinsics.checkNotNullParameter(obj, "$this$null");
                Function1<Object, Unit> function12 = function1;
                if (function12 != null) {
                    function12.invoke(obj);
                }
                configure.invoke(obj);
                return Unit.INSTANCE;
            }
        });
        LinkedHashMap linkedHashMap2 = this.plugins;
        if (linkedHashMap2.containsKey(plugin.getKey())) {
            return;
        }
        linkedHashMap2.put(plugin.getKey(), new Function1<HttpClient, Unit>() { // from class: io.ktor.client.HttpClientConfig$install$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(HttpClient httpClient) {
                HttpClient scope = httpClient;
                Intrinsics.checkNotNullParameter(scope, "scope");
                Attributes attributes = (Attributes) scope.attributes.computeIfAbsent(HttpClientPluginKt.PLUGIN_INSTALLED_LIST, new Function0<Attributes>() { // from class: io.ktor.client.HttpClientConfig$install$3$attributes$1
                    @Override // kotlin.jvm.functions.Function0
                    public final Attributes invoke() {
                        return new ConcurrentSafeAttributes();
                    }
                });
                LinkedHashMap linkedHashMap3 = scope.config.pluginConfigurations;
                HttpClientPlugin<TBuilder, TPlugin> httpClientPlugin = plugin;
                Object obj = linkedHashMap3.get(httpClientPlugin.getKey());
                Intrinsics.checkNotNull(obj);
                Object prepare = httpClientPlugin.prepare((Function1) obj);
                httpClientPlugin.install(scope, prepare);
                attributes.put(httpClientPlugin.getKey(), prepare);
                return Unit.INSTANCE;
            }
        });
    }
}
