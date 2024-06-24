package j$.time.format;

import j$.time.DateTimeException;

/* loaded from: classes2.dex */
public class DateTimeParseException extends DateTimeException {
    private final int errorIndex;
    private final String parsedString;

    public DateTimeParseException(String str, CharSequence charSequence, int r3) {
        super(str);
        this.parsedString = charSequence.toString();
        this.errorIndex = r3;
    }

    public DateTimeParseException(String str, CharSequence charSequence, int r3, Throwable th) {
        super(str, th);
        this.parsedString = charSequence.toString();
        this.errorIndex = r3;
    }
}
