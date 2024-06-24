package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.SolidColor;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextForegroundStyle.kt */
/* loaded from: classes.dex */
public interface TextForegroundStyle {

    /* compiled from: TextForegroundStyle.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public static TextForegroundStyle from(float f, Brush brush) {
            boolean z;
            Unspecified unspecified = Unspecified.INSTANCE;
            if (brush != null) {
                if (brush instanceof SolidColor) {
                    boolean isNaN = Float.isNaN(f);
                    long j = ((SolidColor) brush).value;
                    if (!isNaN && f < 1.0f) {
                        j = ColorKt.Color(Color.m322getRedimpl(j), Color.m321getGreenimpl(j), Color.m319getBlueimpl(j), Color.m318getAlphaimpl(j) * f, Color.m320getColorSpaceimpl(j));
                    }
                    if (j != Color.Unspecified) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        return new ColorStyle(j);
                    }
                    return unspecified;
                }
                if (brush instanceof ShaderBrush) {
                    return new BrushStyle((ShaderBrush) brush, f);
                }
                throw new NoWhenBranchMatchedException();
            }
            return unspecified;
        }
    }

    /* compiled from: TextForegroundStyle.kt */
    /* loaded from: classes.dex */
    public static final class Unspecified implements TextForegroundStyle {
        public static final Unspecified INSTANCE = new Unspecified();

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        public final float getAlpha() {
            return Float.NaN;
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        public final Brush getBrush() {
            return null;
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        /* renamed from: getColor-0d7_KjU */
        public final long mo553getColor0d7_KjU() {
            int r0 = Color.$r8$clinit;
            return Color.Unspecified;
        }
    }

    float getAlpha();

    Brush getBrush();

    /* renamed from: getColor-0d7_KjU */
    long mo553getColor0d7_KjU();

    default TextForegroundStyle merge(TextForegroundStyle textForegroundStyle) {
        boolean z = textForegroundStyle instanceof BrushStyle;
        if (z && (this instanceof BrushStyle)) {
            BrushStyle brushStyle = (BrushStyle) textForegroundStyle;
            float alpha = textForegroundStyle.getAlpha();
            Function0<Float> function0 = new Function0<Float>() { // from class: androidx.compose.ui.text.style.TextForegroundStyle$merge$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    return Float.valueOf(TextForegroundStyle.this.getAlpha());
                }
            };
            if (Float.isNaN(alpha)) {
                alpha = ((Number) function0.invoke()).floatValue();
            }
            return new BrushStyle(brushStyle.value, alpha);
        }
        if (!z || (this instanceof BrushStyle)) {
            if (!z && (this instanceof BrushStyle)) {
                return this;
            }
            return textForegroundStyle.takeOrElse(new Function0<TextForegroundStyle>() { // from class: androidx.compose.ui.text.style.TextForegroundStyle$merge$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final TextForegroundStyle invoke() {
                    return TextForegroundStyle.this;
                }
            });
        }
        return textForegroundStyle;
    }

    default TextForegroundStyle takeOrElse(Function0<? extends TextForegroundStyle> other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (!Intrinsics.areEqual(this, Unspecified.INSTANCE)) {
            return this;
        }
        return other.invoke();
    }
}
