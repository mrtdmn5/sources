package androidx.transition;

import android.graphics.Path;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ProvidableModifierLocal;

/* loaded from: classes.dex */
public abstract class PathMotion {
    public abstract boolean contains$ui_release(ModifierLocal modifierLocal);

    public abstract Object get$ui_release(ProvidableModifierLocal providableModifierLocal);

    public abstract Path getPath(float f, float f2, float f3, float f4);
}
