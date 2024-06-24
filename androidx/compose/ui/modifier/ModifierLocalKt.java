package androidx.compose.ui.modifier;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModifierLocal.kt */
/* loaded from: classes.dex */
public final class ModifierLocalKt {
    public static final ProvidableModifierLocal modifierLocalOf(Function0 defaultFactory) {
        Intrinsics.checkNotNullParameter(defaultFactory, "defaultFactory");
        return new ProvidableModifierLocal(defaultFactory);
    }
}
