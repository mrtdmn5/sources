package io.ktor.util;

import android.text.Spanned;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Throwable.kt */
/* loaded from: classes3.dex */
public class ThrowableKt {
    public static final boolean hasSpan(Spanned spanned, Class cls) {
        Intrinsics.checkNotNullParameter(spanned, "<this>");
        if (spanned.nextSpanTransition(-1, spanned.length(), cls) != spanned.length()) {
            return true;
        }
        return false;
    }
}
