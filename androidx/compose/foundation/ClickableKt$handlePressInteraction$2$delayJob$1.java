package androidx.compose.foundation;

import androidx.compose.foundation.AbstractClickableNode;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: Clickable.kt */
@DebugMetadata(c = "androidx.compose.foundation.ClickableKt$handlePressInteraction$2$delayJob$1", f = "Clickable.kt", l = {293, 296}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ClickableKt$handlePressInteraction$2$delayJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function0<Boolean> $delayPressInteraction;
    public final /* synthetic */ AbstractClickableNode.InteractionData $interactionData;
    public final /* synthetic */ MutableInteractionSource $interactionSource;
    public final /* synthetic */ long $pressPoint;
    public PressInteraction$Press L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickableKt$handlePressInteraction$2$delayJob$1(Function0<Boolean> function0, long j, MutableInteractionSource mutableInteractionSource, AbstractClickableNode.InteractionData interactionData, Continuation<? super ClickableKt$handlePressInteraction$2$delayJob$1> continuation) {
        super(2, continuation);
        this.$delayPressInteraction = function0;
        this.$pressPoint = j;
        this.$interactionSource = mutableInteractionSource;
        this.$interactionData = interactionData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ClickableKt$handlePressInteraction$2$delayJob$1(this.$delayPressInteraction, this.$pressPoint, this.$interactionSource, this.$interactionData, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ClickableKt$handlePressInteraction$2$delayJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PressInteraction$Press pressInteraction$Press;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    pressInteraction$Press = this.L$0;
                    ResultKt.throwOnFailure(obj);
                    this.$interactionData.pressInteraction = pressInteraction$Press;
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            if (this.$delayPressInteraction.invoke().booleanValue()) {
                long j = Clickable_androidKt.TapIndicationDelay;
                this.label = 1;
                if (DelayKt.delay(j, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        }
        PressInteraction$Press pressInteraction$Press2 = new PressInteraction$Press(this.$pressPoint);
        this.L$0 = pressInteraction$Press2;
        this.label = 2;
        if (this.$interactionSource.emit(pressInteraction$Press2, this) == coroutineSingletons) {
            return coroutineSingletons;
        }
        pressInteraction$Press = pressInteraction$Press2;
        this.$interactionData.pressInteraction = pressInteraction$Press;
        return Unit.INSTANCE;
    }
}
