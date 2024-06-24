package androidx.compose.ui.graphics.vector.compat;

import android.graphics.Shader;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt$ShaderBrush$1;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.SolidColor;
import androidx.core.content.res.ComplexColorCompat;

/* compiled from: XmlVectorParser.android.kt */
/* loaded from: classes.dex */
public final class XmlVectorParser_androidKt {
    public static final Brush obtainBrushFromComplexColor(ComplexColorCompat complexColorCompat) {
        boolean z;
        Shader shader = complexColorCompat.mShader;
        boolean z2 = true;
        if (shader != null) {
            z = true;
        } else {
            z = false;
        }
        if (!z && complexColorCompat.mColor == 0) {
            z2 = false;
        }
        if (z2) {
            if (shader != null) {
                return new BrushKt$ShaderBrush$1(shader);
            }
            return new SolidColor(ColorKt.Color(complexColorCompat.mColor));
        }
        return null;
    }
}
