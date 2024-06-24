package io.ktor.client.plugins.contentnegotiation;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentNegotiation.kt */
/* loaded from: classes3.dex */
public final class ContentConverterException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentConverterException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
