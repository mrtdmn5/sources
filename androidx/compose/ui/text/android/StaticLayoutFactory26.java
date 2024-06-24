package androidx.compose.ui.text.android;

import android.text.StaticLayout;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StaticLayoutFactory.kt */
/* loaded from: classes.dex */
public final class StaticLayoutFactory26 {
    public static final void setJustificationMode(StaticLayout.Builder builder, int r2) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.setJustificationMode(r2);
    }
}
