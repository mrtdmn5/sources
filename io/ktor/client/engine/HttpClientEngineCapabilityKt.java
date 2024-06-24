package io.ktor.client.engine;

import io.ktor.client.plugins.HttpTimeout;
import io.ktor.util.AttributeKey;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;

/* compiled from: HttpClientEngineCapability.kt */
/* loaded from: classes3.dex */
public final class HttpClientEngineCapabilityKt {
    public static final AttributeKey<Map<HttpClientEngineCapability<?>, Object>> ENGINE_CAPABILITIES_KEY = new AttributeKey<>("EngineCapabilities");
    public static final Set<HttpTimeout.Plugin> DEFAULT_CAPABILITIES = SetsKt__SetsKt.setOf(HttpTimeout.Plugin);
}
