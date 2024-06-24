package io.ktor.client.request;

import io.ktor.http.HttpMessage;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import io.ktor.util.Attributes;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HttpRequest.kt */
/* loaded from: classes3.dex */
public interface HttpRequest extends HttpMessage, CoroutineScope {
    Attributes getAttributes();

    CoroutineContext getCoroutineContext();

    HttpMethod getMethod();

    Url getUrl();
}
