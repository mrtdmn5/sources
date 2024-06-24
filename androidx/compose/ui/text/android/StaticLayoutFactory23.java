package androidx.compose.ui.text.android;

import android.os.Build;
import android.text.StaticLayout;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StaticLayoutFactory.kt */
/* loaded from: classes.dex */
public final class StaticLayoutFactory23 implements StaticLayoutFactoryImpl {
    @Override // androidx.compose.ui.text.android.StaticLayoutFactoryImpl
    public StaticLayout create(StaticLayoutParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(params.text, params.start, params.end, params.paint, params.width);
        obtain.setTextDirection(params.textDir);
        obtain.setAlignment(params.alignment);
        obtain.setMaxLines(params.maxLines);
        obtain.setEllipsize(params.ellipsize);
        obtain.setEllipsizedWidth(params.ellipsizedWidth);
        obtain.setLineSpacing(params.lineSpacingExtra, params.lineSpacingMultiplier);
        obtain.setIncludePad(params.includePadding);
        obtain.setBreakStrategy(params.breakStrategy);
        obtain.setHyphenationFrequency(params.hyphenationFrequency);
        obtain.setIndents(params.leftIndents, params.rightIndents);
        int r1 = Build.VERSION.SDK_INT;
        if (r1 >= 26) {
            StaticLayoutFactory26.setJustificationMode(obtain, params.justificationMode);
        }
        if (r1 >= 28) {
            StaticLayoutFactory28.setUseLineSpacingFromFallbacks(obtain, params.useFallbackLineSpacing);
        }
        if (r1 >= 33) {
            StaticLayoutFactory33.setLineBreakConfig(obtain, params.lineBreakStyle, params.lineBreakWordStyle);
        }
        StaticLayout build = obtain.build();
        Intrinsics.checkNotNullExpressionValue(build, "obtain(params.text, para…  }\n            }.build()");
        return build;
    }
}
