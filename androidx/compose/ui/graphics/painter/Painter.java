package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Painter.kt */
/* loaded from: classes.dex */
public abstract class Painter {
    public ColorFilter colorFilter;
    public AndroidPaint layerPaint;
    public boolean useLayer;
    public float alpha = 1.0f;
    public LayoutDirection layoutDirection = LayoutDirection.Ltr;

    public Painter() {
        new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.graphics.painter.Painter$drawLambda$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(DrawScope drawScope) {
                DrawScope drawScope2 = drawScope;
                Intrinsics.checkNotNullParameter(drawScope2, "$this$null");
                Painter.this.onDraw(drawScope2);
                return Unit.INSTANCE;
            }
        };
    }

    public abstract boolean applyAlpha(float f);

    public abstract boolean applyColorFilter(ColorFilter colorFilter);

    /* renamed from: getIntrinsicSize-NH-jbRc */
    public abstract long mo392getIntrinsicSizeNHjbRc();

    public abstract void onDraw(DrawScope drawScope);
}
