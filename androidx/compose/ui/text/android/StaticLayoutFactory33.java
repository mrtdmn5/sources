package androidx.compose.ui.text.android;

import android.graphics.text.LineBreakConfig;
import android.text.StaticLayout;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StaticLayoutFactory.kt */
/* loaded from: classes.dex */
public final class StaticLayoutFactory33 {
    public static final boolean isFallbackLineSpacingEnabled(StaticLayout layout) {
        boolean isFallbackLineSpacingEnabled;
        Intrinsics.checkNotNullParameter(layout, "layout");
        isFallbackLineSpacingEnabled = layout.isFallbackLineSpacingEnabled();
        return isFallbackLineSpacingEnabled;
    }

    public static final void setLineBreakConfig(StaticLayout.Builder builder, int r2, int r3) {
        LineBreakConfig.Builder lineBreakStyle;
        LineBreakConfig.Builder lineBreakWordStyle;
        LineBreakConfig build;
        Intrinsics.checkNotNullParameter(builder, "builder");
        lineBreakStyle = StaticLayoutFactory33$$ExternalSyntheticApiModelOutline5.m().setLineBreakStyle(r2);
        lineBreakWordStyle = lineBreakStyle.setLineBreakWordStyle(r3);
        build = lineBreakWordStyle.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …\n                .build()");
        builder.setLineBreakConfig(build);
    }
}
