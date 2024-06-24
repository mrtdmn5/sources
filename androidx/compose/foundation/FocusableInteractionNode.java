package androidx.compose.foundation;

import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import kotlinx.coroutines.BuildersKt;

/* compiled from: Focusable.kt */
/* loaded from: classes.dex */
public final class FocusableInteractionNode extends Modifier.Node {
    public FocusInteraction$Focus focusedInteraction;
    public MutableInteractionSource interactionSource;

    public FocusableInteractionNode(MutableInteractionSource mutableInteractionSource) {
        this.interactionSource = mutableInteractionSource;
    }

    public final void emitWithFallback(MutableInteractionSource mutableInteractionSource, Interaction interaction) {
        if (this.isAttached) {
            BuildersKt.launch$default(getCoroutineScope(), null, null, new FocusableInteractionNode$emitWithFallback$1(mutableInteractionSource, interaction, null), 3);
        } else {
            mutableInteractionSource.tryEmit(interaction);
        }
    }
}
