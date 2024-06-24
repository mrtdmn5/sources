package com.animaconnected.watch;

import com.animaconnected.watch.device.NumberFormatter;
import java.text.DecimalFormat;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidStringsBackend.kt */
/* loaded from: classes3.dex */
public final class AndroidNumberFormatter implements NumberFormatter {
    private final DecimalFormat decimalFormat;

    public AndroidNumberFormatter(DecimalFormat decimalFormat) {
        Intrinsics.checkNotNullParameter(decimalFormat, "decimalFormat");
        this.decimalFormat = decimalFormat;
    }

    @Override // com.animaconnected.watch.device.NumberFormatter
    public String format(double d) {
        String format = this.decimalFormat.format(d);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}
