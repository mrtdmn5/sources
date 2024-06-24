package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: Vector.kt */
/* loaded from: classes.dex */
public abstract class VNode {
    public Function0<Unit> invalidateListener;

    public abstract void draw(DrawScope drawScope);

    public Function0<Unit> getInvalidateListener$ui_release() {
        return this.invalidateListener;
    }

    public final void invalidate() {
        Function0<Unit> invalidateListener$ui_release = getInvalidateListener$ui_release();
        if (invalidateListener$ui_release != null) {
            invalidateListener$ui_release.invoke();
        }
    }

    public void setInvalidateListener$ui_release(Function0<Unit> function0) {
        this.invalidateListener = function0;
    }
}
