package aws.smithy.kotlin.runtime.http.engine.okhttp;

import aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig;

/* compiled from: OkHttpEngineConfig.kt */
/* loaded from: classes.dex */
public final class OkHttpEngineConfig extends HttpClientEngineConfig {
    public static final OkHttpEngineConfig Default = new OkHttpEngineConfig(new Builder());
    public final int maxConnectionsPerHost;

    /* compiled from: OkHttpEngineConfig.kt */
    /* loaded from: classes.dex */
    public static final class Builder extends HttpClientEngineConfig.Builder {
    }

    public OkHttpEngineConfig(Builder builder) {
        super(builder);
        this.maxConnectionsPerHost = builder.maxConnections;
    }
}
