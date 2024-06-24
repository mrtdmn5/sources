package androidx.compose.ui.modifier;

import androidx.compose.ui.Modifier;

/* compiled from: ModifierLocalProvider.kt */
/* loaded from: classes.dex */
public interface ModifierLocalProvider<T> extends Modifier.Element {
    ProvidableModifierLocal<T> getKey();

    T getValue();
}
