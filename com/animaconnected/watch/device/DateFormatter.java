package com.animaconnected.watch.device;

import kotlinx.datetime.TimeZone;

/* compiled from: StringsBackend.kt */
/* loaded from: classes3.dex */
public interface DateFormatter {
    static /* synthetic */ String format$default(DateFormatter dateFormatter, long j, TimeZone timeZone, boolean z, int r5, Object obj) {
        if (obj == null) {
            if ((r5 & 2) != 0) {
                TimeZone.Companion.getClass();
                timeZone = TimeZone.Companion.currentSystemDefault();
            }
            if ((r5 & 4) != 0) {
                z = false;
            }
            return dateFormatter.format(j, timeZone, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: format");
    }

    String format(long j, TimeZone timeZone, boolean z);

    String getFormat();

    FormattingContext getFormattingContext();

    long parse(String str, TimeZone timeZone);

    void setFormat(String str);

    void setFormattingContext(FormattingContext formattingContext);
}
