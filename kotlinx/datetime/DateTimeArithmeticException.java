package kotlinx.datetime;

import j$.time.DateTimeException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Exceptions.kt */
/* loaded from: classes4.dex */
public final class DateTimeArithmeticException extends RuntimeException {
    public DateTimeArithmeticException() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DateTimeArithmeticException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }

    public DateTimeArithmeticException(DateTimeException dateTimeException) {
        super(dateTimeException);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DateTimeArithmeticException(String message, Exception exc) {
        super(message, exc);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
