package io.ktor.http;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Codecs.kt */
/* loaded from: classes3.dex */
public final class URLDecodeException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public URLDecodeException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
