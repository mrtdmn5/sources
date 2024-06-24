package androidx.compose.ui.modifier;

import androidx.compose.ui.Modifier;

/* compiled from: ModifierLocalConsumer.kt */
/* loaded from: classes.dex */
public interface ModifierLocalConsumer extends Modifier.Element {
    void onModifierLocalsUpdated(ModifierLocalReadScope modifierLocalReadScope);
}
