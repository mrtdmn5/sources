package androidx.compose.foundation.interaction;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: InteractionSource.kt */
/* loaded from: classes.dex */
public final class MutableInteractionSourceImpl implements MutableInteractionSource {
    public final SharedFlowImpl interactions = SharedFlowKt.MutableSharedFlow$default(0, 16, BufferOverflow.DROP_OLDEST, 1);

    @Override // androidx.compose.foundation.interaction.MutableInteractionSource
    public final Object emit(Interaction interaction, Continuation<? super Unit> continuation) {
        Object emit = this.interactions.emit(interaction, continuation);
        if (emit == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return emit;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.interaction.InteractionSource
    public final SharedFlowImpl getInteractions() {
        return this.interactions;
    }

    @Override // androidx.compose.foundation.interaction.MutableInteractionSource
    public final boolean tryEmit(Interaction interaction) {
        return this.interactions.tryEmit(interaction);
    }
}
