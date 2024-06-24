package androidx.compose.material;

import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.FocusInteraction$Unfocus;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction$Cancel;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.foundation.interaction.PressInteraction$Release;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlowImpl;

/* compiled from: FloatingActionButton.kt */
@DebugMetadata(c = "androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$1$1", f = "FloatingActionButton.kt", l = {276}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DefaultFloatingActionButtonElevation$elevation$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ InteractionSource $interactionSource;
    public final /* synthetic */ SnapshotStateList<Interaction> $interactions;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultFloatingActionButtonElevation$elevation$1$1(InteractionSource interactionSource, SnapshotStateList<Interaction> snapshotStateList, Continuation<? super DefaultFloatingActionButtonElevation$elevation$1$1> continuation) {
        super(2, continuation);
        this.$interactionSource = interactionSource;
        this.$interactions = snapshotStateList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultFloatingActionButtonElevation$elevation$1$1(this.$interactionSource, this.$interactions, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultFloatingActionButtonElevation$elevation$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            SharedFlowImpl interactions = this.$interactionSource.getInteractions();
            final SnapshotStateList<Interaction> snapshotStateList = this.$interactions;
            FlowCollector<Interaction> flowCollector = new FlowCollector<Interaction>() { // from class: androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$1$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Interaction interaction, Continuation continuation) {
                    Interaction interaction2 = interaction;
                    boolean z = interaction2 instanceof HoverInteraction$Enter;
                    SnapshotStateList<Interaction> snapshotStateList2 = snapshotStateList;
                    if (z) {
                        snapshotStateList2.add(interaction2);
                    } else if (interaction2 instanceof HoverInteraction$Exit) {
                        snapshotStateList2.remove(((HoverInteraction$Exit) interaction2).enter);
                    } else if (interaction2 instanceof FocusInteraction$Focus) {
                        snapshotStateList2.add(interaction2);
                    } else if (interaction2 instanceof FocusInteraction$Unfocus) {
                        snapshotStateList2.remove(((FocusInteraction$Unfocus) interaction2).focus);
                    } else if (interaction2 instanceof PressInteraction$Press) {
                        snapshotStateList2.add(interaction2);
                    } else if (interaction2 instanceof PressInteraction$Release) {
                        snapshotStateList2.remove(((PressInteraction$Release) interaction2).press);
                    } else if (interaction2 instanceof PressInteraction$Cancel) {
                        snapshotStateList2.remove(((PressInteraction$Cancel) interaction2).press);
                    }
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            interactions.getClass();
            if (SharedFlowImpl.collect$suspendImpl(interactions, flowCollector, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
