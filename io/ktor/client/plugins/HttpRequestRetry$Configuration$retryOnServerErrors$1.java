package io.ktor.client.plugins;

import io.ktor.client.plugins.HttpRequestRetry;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.statement.HttpResponse;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: HttpRequestRetry.kt */
/* loaded from: classes3.dex */
public final class HttpRequestRetry$Configuration$retryOnServerErrors$1 extends Lambda implements Function3<HttpRequestRetry.ShouldRetryContext, HttpRequest, HttpResponse, Boolean> {
    public static final HttpRequestRetry$Configuration$retryOnServerErrors$1 INSTANCE = new HttpRequestRetry$Configuration$retryOnServerErrors$1();

    public HttpRequestRetry$Configuration$retryOnServerErrors$1() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Boolean invoke(HttpRequestRetry.ShouldRetryContext shouldRetryContext, HttpRequest httpRequest, HttpResponse httpResponse) {
        boolean z;
        HttpRequestRetry.ShouldRetryContext retryIf = shouldRetryContext;
        HttpResponse response = httpResponse;
        Intrinsics.checkNotNullParameter(retryIf, "$this$retryIf");
        Intrinsics.checkNotNullParameter(httpRequest, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(response, "response");
        int r2 = response.getStatus().value;
        if (500 <= r2 && r2 < 600) {
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
