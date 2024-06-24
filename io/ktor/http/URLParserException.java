package io.ktor.http;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: URLParser.kt */
/* loaded from: classes3.dex */
public final class URLParserException extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public URLParserException(String urlString, Throwable th) {
        super("Fail to parse url: ".concat(urlString), th);
        Intrinsics.checkNotNullParameter(urlString, "urlString");
    }
}
