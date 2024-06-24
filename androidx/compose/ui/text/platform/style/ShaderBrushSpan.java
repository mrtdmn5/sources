package androidx.compose.ui.text.platform.style;

import android.graphics.Shader;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ShaderBrush;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: ShaderBrushSpan.android.kt */
/* loaded from: classes.dex */
public final class ShaderBrushSpan extends CharacterStyle implements UpdateAppearance {
    public final float alpha;
    public Pair<Size, ? extends Shader> cachedShader;
    public final ShaderBrush shaderBrush;
    public long size = Size.Unspecified;

    public ShaderBrushSpan(ShaderBrush shaderBrush, float f) {
        this.shaderBrush = shaderBrush;
        this.alpha = f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        boolean z;
        Shader mo312createShaderuvyYCjk;
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        float f = this.alpha;
        if (!Float.isNaN(f)) {
            textPaint.setAlpha(MathKt__MathJVMKt.roundToInt(RangesKt___RangesKt.coerceIn(f, 0.0f, 1.0f) * 255));
        }
        long j = this.size;
        int r2 = Size.$r8$clinit;
        if (j == Size.Unspecified) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        Pair<Size, ? extends Shader> pair = this.cachedShader;
        if (pair != null && Size.m273equalsimpl0(pair.first.packedValue, j)) {
            mo312createShaderuvyYCjk = (Shader) pair.second;
        } else {
            mo312createShaderuvyYCjk = this.shaderBrush.mo312createShaderuvyYCjk(this.size);
        }
        textPaint.setShader(mo312createShaderuvyYCjk);
        this.cachedShader = new Pair<>(new Size(this.size), mo312createShaderuvyYCjk);
    }
}
