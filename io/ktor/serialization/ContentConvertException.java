package io.ktor.serialization;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentConvertException.kt */
/* loaded from: classes3.dex */
public class ContentConvertException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentConvertException(String message) {
        super(message, null);
        Intrinsics.checkNotNullParameter(message, "message");
    }

    public ContentConvertException(Throwable th) {
        super("Illegal input", th);
    }
}
