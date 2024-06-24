package androidx.compose.ui.modifier;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModifierLocal.kt */
/* loaded from: classes.dex */
public final class ProvidableModifierLocal<T> extends ModifierLocal<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProvidableModifierLocal(Function0<? extends T> defaultFactory) {
        super(defaultFactory);
        Intrinsics.checkNotNullParameter(defaultFactory, "defaultFactory");
    }
}
