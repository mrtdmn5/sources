package aws.smithy.kotlin.runtime.http.engine;

import aws.smithy.kotlin.runtime.net.DefaultHostResolver;
import aws.smithy.kotlin.runtime.net.HostResolver;
import kotlin.collections.EmptyList;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* compiled from: HttpClientEngineConfig.kt */
/* loaded from: classes.dex */
public class HttpClientEngineConfig {
    public final EmptyList alpn;
    public final long connectTimeout;
    public final long connectionIdleTimeout;
    public final DefaultHostResolver hostResolver;
    public final int maxConnections;
    public final EnvironmentProxySelector proxySelector;
    public final long socketReadTimeout;
    public final long socketWriteTimeout;

    /* compiled from: HttpClientEngineConfig.kt */
    /* loaded from: classes.dex */
    public static class Builder {
        public final EmptyList alpn;
        public long connectTimeout;
        public final long connectionIdleTimeout;
        public final DefaultHostResolver hostResolver;
        public final int maxConnections;
        public final EnvironmentProxySelector proxySelector;
        public long socketReadTimeout;
        public final long socketWriteTimeout;

        public Builder() {
            int r0 = Duration.$r8$clinit;
            DurationUnit durationUnit = DurationUnit.SECONDS;
            this.socketReadTimeout = DurationKt.toDuration(30, durationUnit);
            this.socketWriteTimeout = DurationKt.toDuration(30, durationUnit);
            this.maxConnections = 16;
            this.connectTimeout = DurationKt.toDuration(2, durationUnit);
            DurationKt.toDuration(10, durationUnit);
            this.connectionIdleTimeout = DurationKt.toDuration(60, durationUnit);
            this.alpn = EmptyList.INSTANCE;
            this.proxySelector = new EnvironmentProxySelector();
            HostResolver.Companion.getClass();
            this.hostResolver = DefaultHostResolver.INSTANCE;
        }
    }

    static {
        new HttpClientEngineConfig(new Builder());
    }

    public HttpClientEngineConfig(Builder builder) {
        this.socketReadTimeout = builder.socketReadTimeout;
        this.socketWriteTimeout = builder.socketWriteTimeout;
        this.maxConnections = builder.maxConnections;
        this.connectTimeout = builder.connectTimeout;
        this.connectionIdleTimeout = builder.connectionIdleTimeout;
        this.alpn = builder.alpn;
        this.proxySelector = builder.proxySelector;
        this.hostResolver = builder.hostResolver;
    }
}
