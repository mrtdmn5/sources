package io.ktor.client.request;

import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.engine.HttpClientEngineCapabilityKt;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.http.Headers;
import io.ktor.http.HeadersImpl;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmBase;
import java.util.Map;
import java.util.Set;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* compiled from: HttpRequest.kt */
/* loaded from: classes3.dex */
public final class HttpRequestData {
    public final Attributes attributes;
    public final OutgoingContent body;
    public final Job executionContext;
    public final Headers headers;
    public final HttpMethod method;
    public final Set<HttpClientEngineCapability<?>> requiredCapabilities;
    public final Url url;

    public HttpRequestData(Url url, HttpMethod method, HeadersImpl headersImpl, OutgoingContent outgoingContent, Job executionContext, AttributesJvmBase attributes) {
        Set<HttpClientEngineCapability<?>> keySet;
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(executionContext, "executionContext");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.url = url;
        this.method = method;
        this.headers = headersImpl;
        this.body = outgoingContent;
        this.executionContext = executionContext;
        this.attributes = attributes;
        Map map = (Map) attributes.getOrNull(HttpClientEngineCapabilityKt.ENGINE_CAPABILITIES_KEY);
        this.requiredCapabilities = (map == null || (keySet = map.keySet()) == null) ? EmptySet.INSTANCE : keySet;
    }

    public final Object getCapabilityOrNull() {
        HttpTimeout.Plugin plugin = HttpTimeout.Plugin;
        Map map = (Map) this.attributes.getOrNull(HttpClientEngineCapabilityKt.ENGINE_CAPABILITIES_KEY);
        if (map != null) {
            return map.get(plugin);
        }
        return null;
    }

    public final String toString() {
        return "HttpRequestData(url=" + this.url + ", method=" + this.method + ')';
    }
}
