package io.ktor.client.request;

import kotlin.Unit;

/* compiled from: utils.kt */
/* loaded from: classes3.dex */
public final class UtilsKt {
    public static final void parameter(HttpRequestBuilder httpRequestBuilder, String str, Object obj) {
        if (obj != null) {
            httpRequestBuilder.url.parameters.append(str, obj.toString());
            Unit unit = Unit.INSTANCE;
        }
    }
}
