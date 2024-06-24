package io.ktor.client.plugins;

import io.ktor.client.plugins.HttpRequestRetry;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.AttributeKey;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.slf4j.Logger;

/* compiled from: HttpRequestRetry.kt */
/* loaded from: classes3.dex */
public final class HttpRequestRetryKt {
    public static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpRequestRetry");
    public static final AttributeKey<Integer> MaxRetriesPerRequestAttributeKey = new AttributeKey<>("MaxRetriesPerRequestAttributeKey");
    public static final AttributeKey<Function3<HttpRequestRetry.ShouldRetryContext, HttpRequest, HttpResponse, Boolean>> ShouldRetryPerRequestAttributeKey = new AttributeKey<>("ShouldRetryPerRequestAttributeKey");
    public static final AttributeKey<Function3<HttpRequestRetry.ShouldRetryContext, HttpRequestBuilder, Throwable, Boolean>> ShouldRetryOnExceptionPerRequestAttributeKey = new AttributeKey<>("ShouldRetryOnExceptionPerRequestAttributeKey");
    public static final AttributeKey<Function2<HttpRequestRetry.ModifyRequestContext, HttpRequestBuilder, Unit>> ModifyRequestPerRequestAttributeKey = new AttributeKey<>("ModifyRequestPerRequestAttributeKey");
    public static final AttributeKey<Function2<HttpRequestRetry.DelayContext, Integer, Long>> RetryDelayPerRequestAttributeKey = new AttributeKey<>("RetryDelayPerRequestAttributeKey");
}
