package androidx.compose.foundation.interaction;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: InteractionSource.kt */
/* loaded from: classes.dex */
public interface MutableInteractionSource extends InteractionSource {
    Object emit(Interaction interaction, Continuation<? super Unit> continuation);

    boolean tryEmit(Interaction interaction);
}
