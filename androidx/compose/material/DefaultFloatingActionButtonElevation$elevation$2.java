package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Dp;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FloatingActionButton.kt */
@DebugMetadata(c = "androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$2", f = "FloatingActionButton.kt", l = {321}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DefaultFloatingActionButtonElevation$elevation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Animatable<Dp, AnimationVector1D> $animatable;
    public final /* synthetic */ Interaction $interaction;
    public final /* synthetic */ float $target;
    public int label;
    public final /* synthetic */ DefaultFloatingActionButtonElevation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultFloatingActionButtonElevation$elevation$2(Animatable<Dp, AnimationVector1D> animatable, DefaultFloatingActionButtonElevation defaultFloatingActionButtonElevation, float f, Interaction interaction, Continuation<? super DefaultFloatingActionButtonElevation$elevation$2> continuation) {
        super(2, continuation);
        this.$animatable = animatable;
        this.this$0 = defaultFloatingActionButtonElevation;
        this.$target = f;
        this.$interaction = interaction;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultFloatingActionButtonElevation$elevation$2(this.$animatable, this.this$0, this.$target, this.$interaction, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultFloatingActionButtonElevation$elevation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Interaction interaction;
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
            Animatable<Dp, AnimationVector1D> animatable = this.$animatable;
            float f = ((Dp) animatable.targetValue$delegate.getValue()).value;
            DefaultFloatingActionButtonElevation defaultFloatingActionButtonElevation = this.this$0;
            if (Dp.m579equalsimpl0(f, defaultFloatingActionButtonElevation.pressedElevation)) {
                interaction = new PressInteraction$Press(Offset.Zero);
            } else if (Dp.m579equalsimpl0(f, defaultFloatingActionButtonElevation.hoveredElevation)) {
                interaction = new HoverInteraction$Enter();
            } else if (Dp.m579equalsimpl0(f, defaultFloatingActionButtonElevation.focusedElevation)) {
                interaction = new FocusInteraction$Focus();
            } else {
                interaction = null;
            }
            this.label = 1;
            if (ElevationKt.m183animateElevationrAjV9yQ(animatable, this.$target, interaction, this.$interaction, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
