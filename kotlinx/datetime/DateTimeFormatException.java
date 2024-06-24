package kotlinx.datetime;

import j$.time.DateTimeException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Exceptions.kt */
/* loaded from: classes4.dex */
public final class DateTimeFormatException extends IllegalArgumentException {
    public DateTimeFormatException() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DateTimeFormatException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }

    public DateTimeFormatException(DateTimeException dateTimeException) {
        super(dateTimeException);
    }
}
