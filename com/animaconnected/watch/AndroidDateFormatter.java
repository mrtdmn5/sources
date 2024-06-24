package com.animaconnected.watch;

import com.animaconnected.watch.device.DateFormatter;
import com.animaconnected.watch.device.FormattingContext;
import com.animaconnected.watch.provider.DateTimeFormattersKt;
import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZonedDateTime;
import j$.time.format.DateTimeFormatter;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.datetime.TimeZone;

/* compiled from: AndroidStringsBackend.kt */
/* loaded from: classes3.dex */
public final class AndroidDateFormatter implements DateFormatter {
    private String format;
    private FormattingContext formattingContext;
    private final Locale locale;

    public AndroidDateFormatter() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.animaconnected.watch.device.DateFormatter
    public String format(long j, TimeZone timeZone, boolean z) {
        DateTimeFormatter ofPattern;
        String str;
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        if (Intrinsics.areEqual(getFormat(), DateTimeFormattersKt.shortDayNameInWeekFormat)) {
            Locale locale = this.locale;
            if (locale != null) {
                str = locale.getLanguage();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, "es")) {
                String format = LocalDateTime.ofInstant(Instant.ofEpochMilli(j), ZoneId.of(timeZone.getId())).format(DateTimeFormatter.ofPattern(DateTimeFormattersKt.mediumDayNameInWeekFormat, this.locale));
                Intrinsics.checkNotNull(format);
                if (StringsKt__StringsJVMKt.startsWith(format, "mié", true)) {
                    return "x";
                }
            }
        }
        ZonedDateTime atZone = LocalDateTime.ofInstant(Instant.ofEpochMilli(j), ZoneId.of(timeZone.getId())).atZone(ZoneId.of(timeZone.getId()));
        if (this.locale != null && !z) {
            ofPattern = DateTimeFormatter.ofPattern(getFormat(), this.locale);
        } else {
            ofPattern = DateTimeFormatter.ofPattern(getFormat());
        }
        String format2 = atZone.format(ofPattern);
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        return format2;
    }

    @Override // com.animaconnected.watch.device.DateFormatter
    public String getFormat() {
        return this.format;
    }

    @Override // com.animaconnected.watch.device.DateFormatter
    public FormattingContext getFormattingContext() {
        return this.formattingContext;
    }

    public final Locale getLocale() {
        return this.locale;
    }

    @Override // com.animaconnected.watch.device.DateFormatter
    public long parse(String date, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(getFormat())).atStartOfDay(ZoneId.of(timeZone.getId())).toInstant().getEpochSecond();
    }

    @Override // com.animaconnected.watch.device.DateFormatter
    public void setFormat(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.format = str;
    }

    @Override // com.animaconnected.watch.device.DateFormatter
    public void setFormattingContext(FormattingContext formattingContext) {
        Intrinsics.checkNotNullParameter(formattingContext, "<set-?>");
        this.formattingContext = formattingContext;
    }

    public AndroidDateFormatter(String format, Locale locale) {
        Intrinsics.checkNotNullParameter(format, "format");
        this.format = format;
        this.locale = locale;
        this.formattingContext = FormattingContext.UNKNOWN;
    }

    public /* synthetic */ AndroidDateFormatter(String str, Locale locale, int r3, DefaultConstructorMarker defaultConstructorMarker) {
        this((r3 & 1) != 0 ? "" : str, (r3 & 2) != 0 ? null : locale);
    }
}
