package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.plugins.HttpSend;
import io.ktor.util.AttributeKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpTimeout.kt */
/* loaded from: classes3.dex */
public final class HttpTimeout {
    public static final Plugin Plugin = new Plugin();
    public static final AttributeKey<HttpTimeout> key = new AttributeKey<>("TimeoutPlugin");
    public final Long connectTimeoutMillis;
    public final Long requestTimeoutMillis;
    public final Long socketTimeoutMillis;

    /* compiled from: HttpTimeout.kt */
    /* loaded from: classes3.dex */
    public static final class HttpTimeoutCapabilityConfiguration {
        public Long _connectTimeoutMillis;
        public Long _requestTimeoutMillis = 0L;
        public Long _socketTimeoutMillis;

        static {
            boolean z;
            if ("TimeoutConfiguration".length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
            } else {
                throw new IllegalStateException("Name can't be blank");
            }
        }

        public HttpTimeoutCapabilityConfiguration() {
            this._connectTimeoutMillis = 0L;
            this._socketTimeoutMillis = 0L;
            setRequestTimeoutMillis(null);
            checkTimeoutValue(null);
            this._connectTimeoutMillis = null;
            checkTimeoutValue(null);
            this._socketTimeoutMillis = null;
        }

        public static void checkTimeoutValue(Long l) {
            boolean z;
            if (l != null && l.longValue() <= 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
            } else {
                throw new IllegalArgumentException("Only positive timeout values are allowed, for infinite timeout use HttpTimeout.INFINITE_TIMEOUT_MS".toString());
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || HttpTimeoutCapabilityConfiguration.class != obj.getClass()) {
                return false;
            }
            HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration = (HttpTimeoutCapabilityConfiguration) obj;
            if (Intrinsics.areEqual(this._requestTimeoutMillis, httpTimeoutCapabilityConfiguration._requestTimeoutMillis) && Intrinsics.areEqual(this._connectTimeoutMillis, httpTimeoutCapabilityConfiguration._connectTimeoutMillis) && Intrinsics.areEqual(this._socketTimeoutMillis, httpTimeoutCapabilityConfiguration._socketTimeoutMillis)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            int r0;
            int r2;
            Long l = this._requestTimeoutMillis;
            int r1 = 0;
            if (l != null) {
                r0 = l.hashCode();
            } else {
                r0 = 0;
            }
            int r02 = r0 * 31;
            Long l2 = this._connectTimeoutMillis;
            if (l2 != null) {
                r2 = l2.hashCode();
            } else {
                r2 = 0;
            }
            int r03 = (r02 + r2) * 31;
            Long l3 = this._socketTimeoutMillis;
            if (l3 != null) {
                r1 = l3.hashCode();
            }
            return r03 + r1;
        }

        public final void setRequestTimeoutMillis(Long l) {
            checkTimeoutValue(l);
            this._requestTimeoutMillis = l;
        }
    }

    /* compiled from: HttpTimeout.kt */
    /* loaded from: classes3.dex */
    public static final class Plugin implements HttpClientPlugin<HttpTimeoutCapabilityConfiguration, HttpTimeout>, HttpClientEngineCapability<HttpTimeoutCapabilityConfiguration> {
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final AttributeKey<HttpTimeout> getKey() {
            return HttpTimeout.key;
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final void install(HttpClient scope, Object obj) {
            HttpTimeout plugin = (HttpTimeout) obj;
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            HttpSend.Plugin plugin2 = HttpSend.Plugin;
            HttpSend httpSend = (HttpSend) HttpClientPluginKt.plugin(scope);
            httpSend.interceptors.add(new HttpTimeout$Plugin$install$1(plugin, scope, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final HttpTimeout prepare(Function1<? super HttpTimeoutCapabilityConfiguration, Unit> function1) {
            HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration = new HttpTimeoutCapabilityConfiguration();
            function1.invoke(httpTimeoutCapabilityConfiguration);
            return new HttpTimeout(httpTimeoutCapabilityConfiguration._requestTimeoutMillis, httpTimeoutCapabilityConfiguration._connectTimeoutMillis, httpTimeoutCapabilityConfiguration._socketTimeoutMillis);
        }
    }

    public HttpTimeout(Long l, Long l2, Long l3) {
        this.requestTimeoutMillis = l;
        this.connectTimeoutMillis = l2;
        this.socketTimeoutMillis = l3;
    }
}
