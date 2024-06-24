package androidx.compose.ui.graphics;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ColorFilter.kt */
/* loaded from: classes.dex */
public final class ColorFilter {
    public final android.graphics.ColorFilter nativeColorFilter;

    public ColorFilter(android.graphics.ColorFilter nativeColorFilter) {
        Intrinsics.checkNotNullParameter(nativeColorFilter, "nativeColorFilter");
        this.nativeColorFilter = nativeColorFilter;
    }
}
