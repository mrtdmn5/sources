package io.ktor.client;

import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.engine.HttpClientEngineFactory;
import io.ktor.client.engine.android.AndroidClientEngine;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* compiled from: HttpClientJvm.kt */
/* loaded from: classes3.dex */
public final class HttpClientJvmKt {
    public static final HttpClientEngineFactory<?> FACTORY;
    public static final List<HttpClientEngineContainer> engines;

    static {
        HttpClientEngineFactory<?> factory;
        ServiceLoader load = ServiceLoader.load(HttpClientEngineContainer.class, HttpClientEngineContainer.class.getClassLoader());
        Intrinsics.checkNotNullExpressionValue(load, "load(it, it.classLoader)");
        List<HttpClientEngineContainer> list = CollectionsKt___CollectionsKt.toList(load);
        engines = list;
        HttpClientEngineContainer httpClientEngineContainer = (HttpClientEngineContainer) CollectionsKt___CollectionsKt.firstOrNull((List) list);
        if (httpClientEngineContainer != null && (factory = httpClientEngineContainer.getFactory()) != null) {
            FACTORY = factory;
            return;
        }
        throw new IllegalStateException("Failed to find HTTP client engine implementation in the classpath: consider adding client engine dependency. See https://ktor.io/docs/http-client-engines.html".toString());
    }

    public static final HttpClient HttpClient(Function1<? super HttpClientConfig<?>, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        HttpClientEngineFactory<?> engineFactory = FACTORY;
        Intrinsics.checkNotNullParameter(engineFactory, "engineFactory");
        HttpClientConfig httpClientConfig = new HttpClientConfig();
        block.invoke(httpClientConfig);
        final AndroidClientEngine create = engineFactory.create(httpClientConfig.engineConfig);
        HttpClient httpClient = new HttpClient(create, httpClientConfig);
        CoroutineContext.Element element = httpClient.coroutineContext.get(Job.Key.$$INSTANCE);
        Intrinsics.checkNotNull(element);
        ((Job) element).invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: io.ktor.client.HttpClientKt$HttpClient$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Throwable th) {
                HttpClientEngine.this.close();
                return Unit.INSTANCE;
            }
        });
        return httpClient;
    }
}
