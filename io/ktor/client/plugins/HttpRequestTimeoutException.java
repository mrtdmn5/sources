package io.ktor.client.plugins;

import java.io.IOException;

/* compiled from: HttpTimeout.kt */
/* loaded from: classes3.dex */
public final class HttpRequestTimeoutException extends IOException {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public HttpRequestTimeoutException(io.ktor.client.request.HttpRequestBuilder r4) {
        /*
            r3 = this;
            java.lang.String r0 = "request"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            io.ktor.http.URLBuilder r0 = r4.url
            java.lang.String r0 = r0.buildString()
            io.ktor.client.plugins.HttpTimeout$Plugin r1 = io.ktor.client.plugins.HttpTimeout.Plugin
            io.ktor.util.AttributesJvmBase r4 = r4.attributes
            io.ktor.util.AttributeKey<java.util.Map<io.ktor.client.engine.HttpClientEngineCapability<?>, java.lang.Object>> r2 = io.ktor.client.engine.HttpClientEngineCapabilityKt.ENGINE_CAPABILITIES_KEY
            java.lang.Object r4 = r4.getOrNull(r2)
            java.util.Map r4 = (java.util.Map) r4
            r2 = 0
            if (r4 == 0) goto L1f
            java.lang.Object r4 = r4.get(r1)
            goto L20
        L1f:
            r4 = r2
        L20:
            io.ktor.client.plugins.HttpTimeout$HttpTimeoutCapabilityConfiguration r4 = (io.ktor.client.plugins.HttpTimeout.HttpTimeoutCapabilityConfiguration) r4
            if (r4 == 0) goto L26
            java.lang.Long r2 = r4._requestTimeoutMillis
        L26:
            java.lang.String r4 = "Request timeout has expired [url="
            java.lang.String r1 = ", request_timeout="
            java.lang.StringBuilder r4 = androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticOutline0.m(r4, r0, r1)
            if (r2 != 0) goto L32
            java.lang.String r2 = "unknown"
        L32:
            r4.append(r2)
            java.lang.String r0 = " ms]"
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpRequestTimeoutException.<init>(io.ktor.client.request.HttpRequestBuilder):void");
    }
}
