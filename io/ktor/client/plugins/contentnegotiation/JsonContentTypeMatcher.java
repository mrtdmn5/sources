package io.ktor.client.plugins.contentnegotiation;

import io.ktor.http.ContentType;
import io.ktor.http.ContentTypeMatcher;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: JsonContentTypeMatcher.kt */
/* loaded from: classes3.dex */
public final class JsonContentTypeMatcher implements ContentTypeMatcher {
    public static final JsonContentTypeMatcher INSTANCE = new JsonContentTypeMatcher();

    @Override // io.ktor.http.ContentTypeMatcher
    public final boolean contains(ContentType contentType) {
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        if (contentType.match(ContentType.Application.Json)) {
            return true;
        }
        if (!contentType.parameters.isEmpty()) {
            contentType = new ContentType(contentType.contentType, contentType.contentSubtype);
        }
        String headerValueWithParameters = contentType.toString();
        if (StringsKt__StringsJVMKt.startsWith(headerValueWithParameters, "application/", false) && StringsKt__StringsJVMKt.endsWith(headerValueWithParameters, "+json", false)) {
            return true;
        }
        return false;
    }
}
