package androidx.compose.material;

import androidx.compose.runtime.State;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Slider.kt */
@DebugMetadata(c = "androidx.compose.material.SliderKt$Slider$3$drag$1$1", f = "Slider.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SliderKt$Slider$3$drag$1$1 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {
    public final /* synthetic */ State<Function1<Float, Unit>> $gestureEndAction;
    public /* synthetic */ float F$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SliderKt$Slider$3$drag$1$1(State<? extends Function1<? super Float, Unit>> state, Continuation<? super SliderKt$Slider$3$drag$1$1> continuation) {
        super(3, continuation);
        this.$gestureEndAction = state;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, Float f, Continuation<? super Unit> continuation) {
        float floatValue = f.floatValue();
        SliderKt$Slider$3$drag$1$1 sliderKt$Slider$3$drag$1$1 = new SliderKt$Slider$3$drag$1$1(this.$gestureEndAction, continuation);
        sliderKt$Slider$3$drag$1$1.F$0 = floatValue;
        return sliderKt$Slider$3$drag$1$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ResultKt.throwOnFailure(obj);
        this.$gestureEndAction.getValue().invoke(new Float(this.F$0));
        return Unit.INSTANCE;
    }
}
