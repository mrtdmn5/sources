package io.ktor.client.plugins.auth;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.auth.HttpAuthHeader;
import kotlin.coroutines.Continuation;

/* compiled from: AuthProvider.kt */
/* loaded from: classes3.dex */
public interface AuthProvider {
    Object addRequestHeaders(HttpRequestBuilder httpRequestBuilder, Continuation continuation);

    boolean isApplicable(HttpAuthHeader httpAuthHeader);

    Object refreshToken(HttpResponse httpResponse, Continuation<? super Boolean> continuation);

    boolean sendWithoutRequest(HttpRequestBuilder httpRequestBuilder);
}
