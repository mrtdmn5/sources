package androidx.compose.ui.modifier;

import kotlin.jvm.functions.Function0;

/* compiled from: ModifierLocal.kt */
/* loaded from: classes.dex */
public abstract class ModifierLocal<T> {
    public final Function0<T> defaultFactory;

    public ModifierLocal() {
        throw null;
    }

    public ModifierLocal(Function0 function0) {
        this.defaultFactory = function0;
    }
}
