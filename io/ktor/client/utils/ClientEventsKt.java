package io.ktor.client.utils;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.events.EventDefinition;

/* compiled from: ClientEvents.kt */
/* loaded from: classes3.dex */
public final class ClientEventsKt {
    public static final EventDefinition<HttpRequestBuilder> HttpRequestCreated = new EventDefinition<>();
    public static final EventDefinition<HttpRequestBuilder> HttpRequestIsReadyForSending = new EventDefinition<>();
    public static final EventDefinition<HttpResponse> HttpResponseReceived = new EventDefinition<>();
    public static final EventDefinition<Object> HttpResponseReceiveFailed = new EventDefinition<>();
    public static final EventDefinition<HttpResponse> HttpResponseCancelled = new EventDefinition<>();
}
