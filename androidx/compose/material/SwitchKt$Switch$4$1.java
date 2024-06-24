package androidx.compose.material;

import com.animaconnected.secondo.R;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Switch.kt */
@DebugMetadata(c = "androidx.compose.material.SwitchKt$Switch$4$1", f = "Switch.kt", l = {R.styleable.AppTheme_stepsHistoryColumnColorActivity}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SwitchKt$Switch$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ AnchoredDraggableState<Boolean> $anchoredDraggableState;
    public final /* synthetic */ boolean $checked;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchKt$Switch$4$1(boolean z, AnchoredDraggableState<Boolean> anchoredDraggableState, Continuation<? super SwitchKt$Switch$4$1> continuation) {
        super(2, continuation);
        this.$checked = z;
        this.$anchoredDraggableState = anchoredDraggableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SwitchKt$Switch$4$1(this.$checked, this.$anchoredDraggableState, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SwitchKt$Switch$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object animateTo;
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
            AnchoredDraggableState<Boolean> anchoredDraggableState = this.$anchoredDraggableState;
            boolean booleanValue = anchoredDraggableState.getCurrentValue().booleanValue();
            boolean z = this.$checked;
            if (z != booleanValue) {
                Boolean valueOf = Boolean.valueOf(z);
                this.label = 1;
                animateTo = AnchoredDraggableKt.animateTo(anchoredDraggableState.lastVelocity$delegate.getFloatValue(), anchoredDraggableState, valueOf, this);
                if (animateTo == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        }
        return Unit.INSTANCE;
    }
}
