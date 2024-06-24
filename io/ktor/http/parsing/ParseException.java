package io.ktor.http.parsing;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParseException.kt */
/* loaded from: classes3.dex */
public final class ParseException extends IllegalArgumentException {
    public final Throwable cause;
    public final String message;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParseException(String message) {
        super(message, null);
        Intrinsics.checkNotNullParameter(message, "message");
        this.message = message;
        this.cause = null;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.cause;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.message;
    }
}
