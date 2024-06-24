package com.animaconnected.watch;

import android.content.Context;
import android.text.format.DateFormat;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.amplifyframework.core.model.ModelIdentifier;
import com.animaconnected.watch.device.DateFormatter;
import com.animaconnected.watch.device.NumberFormatter;
import com.animaconnected.watch.device.StringsBackend;
import com.animaconnected.watch.strings.Language;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Locale;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: AndroidStringsBackend.kt */
/* loaded from: classes3.dex */
public final class StringsBackendImpl implements StringsBackend {
    private final String brand;
    private final Context context;
    private final Locale locale;

    public StringsBackendImpl(Context context, Locale locale, String brand) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(brand, "brand");
        this.context = context;
        this.locale = locale;
        this.brand = brand;
    }

    private final Language toLanguage(Locale locale) {
        Object obj;
        Iterator<E> it = Language.getEntries().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((Language) obj).getCode(), locale.getLanguage())) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Language language = (Language) obj;
        if (language == null) {
            return Language.EN;
        }
        return language;
    }

    @Override // com.animaconnected.watch.device.StringsBackend
    public String brand() {
        return this.brand;
    }

    @Override // com.animaconnected.watch.device.StringsBackend
    public DateFormatter createDateFormatter(String pattern, boolean z) {
        Locale locale;
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        if (z && !toLanguage(this.locale).getLatinSupported()) {
            locale = Locale.ENGLISH;
        } else {
            locale = this.locale;
        }
        return new AndroidDateFormatter(pattern, locale);
    }

    @Override // com.animaconnected.watch.device.StringsBackend
    public NumberFormatter createNumberFormatter(int r8, int r9, int r10, int r11) {
        String str;
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> it = new IntRange(1, r9).iterator();
        while (true) {
            String str2 = "0";
            if (!it.hasNext()) {
                break;
            }
            int nextInt = ((IntIterator) it).nextInt();
            if (((r9 - nextInt) + 1) % 3 == 0) {
                sb.append(",");
            }
            if (nextInt <= r9 - r8) {
                str2 = ModelIdentifier.Helper.PRIMARY_KEY_DELIMITER;
            }
            sb.append(str2);
        }
        if (r11 != 0) {
            sb.append(InstructionFileId.DOT);
            Iterator<Integer> it2 = RangesKt___RangesKt.until(0, r11).iterator();
            while (it2.hasNext()) {
                if (((IntIterator) it2).nextInt() < r10) {
                    str = "0";
                } else {
                    str = ModelIdentifier.Helper.PRIMARY_KEY_DELIMITER;
                }
                sb.append(str);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        NumberFormat numberInstance = NumberFormat.getNumberInstance(this.locale);
        Intrinsics.checkNotNull(numberInstance, "null cannot be cast to non-null type java.text.DecimalFormat");
        DecimalFormat decimalFormat = (DecimalFormat) numberInstance;
        decimalFormat.applyPattern(sb2);
        return new AndroidNumberFormatter(decimalFormat);
    }

    @Override // com.animaconnected.watch.device.StringsBackend
    public Language getLanguage() {
        return toLanguage(this.locale);
    }

    @Override // com.animaconnected.watch.device.StringsBackend
    public boolean is24HourFormat() {
        return DateFormat.is24HourFormat(this.context);
    }
}
