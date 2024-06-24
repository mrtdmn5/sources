package com.animaconnected.watch.device;

import com.animaconnected.watch.strings.Language;

/* compiled from: StringsBackend.kt */
/* loaded from: classes3.dex */
public interface StringsBackend {
    static /* synthetic */ DateFormatter createDateFormatter$default(StringsBackend stringsBackend, String str, boolean z, int r3, Object obj) {
        if (obj == null) {
            if ((r3 & 2) != 0) {
                z = false;
            }
            return stringsBackend.createDateFormatter(str, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDateFormatter");
    }

    String brand();

    DateFormatter createDateFormatter(String str, boolean z);

    NumberFormatter createNumberFormatter(int r1, int r2, int r3, int r4);

    Language getLanguage();

    boolean is24HourFormat();
}
