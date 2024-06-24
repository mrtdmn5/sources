package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Size;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Brush.kt */
/* loaded from: classes.dex */
public abstract class ShaderBrush extends Brush {
    public long createdSize;
    public Shader internalShader;

    public ShaderBrush() {
        int r0 = Size.$r8$clinit;
        this.createdSize = Size.Unspecified;
    }

    @Override // androidx.compose.ui.graphics.Brush
    /* renamed from: applyTo-Pq9zytI */
    public final void mo310applyToPq9zytI(float f, long j, Paint p) {
        boolean z;
        Intrinsics.checkNotNullParameter(p, "p");
        Shader shader = this.internalShader;
        if (shader == null || !Size.m273equalsimpl0(this.createdSize, j)) {
            if (Size.m277isEmptyimpl(j)) {
                shader = null;
                this.internalShader = null;
                int r5 = Size.$r8$clinit;
                this.createdSize = Size.Unspecified;
            } else {
                shader = mo312createShaderuvyYCjk(j);
                this.internalShader = shader;
                this.createdSize = j;
            }
        }
        long mo293getColor0d7_KjU = p.mo293getColor0d7_KjU();
        int r1 = Color.$r8$clinit;
        long j2 = Color.Black;
        if (!Color.m317equalsimpl0(mo293getColor0d7_KjU, j2)) {
            p.mo298setColor8_81llA(j2);
        }
        if (!Intrinsics.areEqual(p.getShader(), shader)) {
            p.setShader(shader);
        }
        if (p.getAlpha() == f) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            p.setAlpha(f);
        }
    }

    /* renamed from: createShader-uvyYCjk */
    public abstract Shader mo312createShaderuvyYCjk(long j);
}
