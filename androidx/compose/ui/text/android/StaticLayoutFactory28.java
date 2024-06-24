package androidx.compose.ui.text.android;

import android.text.StaticLayout;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StaticLayoutFactory.kt */
/* loaded from: classes.dex */
public final class StaticLayoutFactory28 {
    public static final void setUseLineSpacingFromFallbacks(StaticLayout.Builder builder, boolean z) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.setUseLineSpacingFromFallbacks(z);
    }
}
