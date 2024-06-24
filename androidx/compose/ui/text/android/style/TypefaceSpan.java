package androidx.compose.ui.text.android.style;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypefaceSpan.kt */
/* loaded from: classes.dex */
public final class TypefaceSpan extends MetricAffectingSpan {
    public final Typeface typeface;

    public TypefaceSpan(Typeface typeface) {
        Intrinsics.checkNotNullParameter(typeface, "typeface");
        this.typeface = typeface;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint ds) {
        Intrinsics.checkNotNullParameter(ds, "ds");
        ds.setTypeface(this.typeface);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        paint.setTypeface(this.typeface);
    }
}
