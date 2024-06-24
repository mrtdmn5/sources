package androidx.compose.foundation.gestures;

import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ProvidableModifierLocal;

/* compiled from: Scrollable.kt */
/* loaded from: classes.dex */
public final class ModifierLocalScrollableContainerProvider implements ModifierLocalProvider<Boolean> {
    public static final ModifierLocalScrollableContainerProvider INSTANCE = new ModifierLocalScrollableContainerProvider();
    public static final ProvidableModifierLocal<Boolean> key = ScrollableKt.ModifierLocalScrollableContainer;
    public static final boolean value = true;

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public final ProvidableModifierLocal<Boolean> getKey() {
        return key;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public final Boolean getValue() {
        return Boolean.valueOf(value);
    }
}
