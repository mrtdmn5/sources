package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.gestures.DragScope;
import com.google.android.gms.common.zzu;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$FloatRef;

/* compiled from: Slider.kt */
@DebugMetadata(c = "androidx.compose.material.SliderKt$animateToTarget$2", f = "Slider.kt", l = {955}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SliderKt$animateToTarget$2 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ float $current;
    public final /* synthetic */ float $target;
    public final /* synthetic */ float $velocity;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SliderKt$animateToTarget$2(float f, float f2, float f3, Continuation<? super SliderKt$animateToTarget$2> continuation) {
        super(2, continuation);
        this.$current = f;
        this.$target = f2;
        this.$velocity = f3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SliderKt$animateToTarget$2 sliderKt$animateToTarget$2 = new SliderKt$animateToTarget$2(this.$current, this.$target, this.$velocity, continuation);
        sliderKt$animateToTarget$2.L$0 = obj;
        return sliderKt$animateToTarget$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(DragScope dragScope, Continuation<? super Unit> continuation) {
        return ((SliderKt$animateToTarget$2) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            final DragScope dragScope = (DragScope) this.L$0;
            final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
            float f = this.$current;
            ref$FloatRef.element = f;
            Animatable Animatable$default = zzu.Animatable$default(f);
            Float f2 = new Float(this.$target);
            TweenSpec<Float> tweenSpec = SliderKt.SliderToTickAnimation;
            Float f3 = new Float(this.$velocity);
            Function1<Animatable<Float, AnimationVector1D>, Unit> function1 = new Function1<Animatable<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material.SliderKt$animateToTarget$2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Animatable<Float, AnimationVector1D> animatable) {
                    Animatable<Float, AnimationVector1D> animateTo = animatable;
                    Intrinsics.checkNotNullParameter(animateTo, "$this$animateTo");
                    float floatValue = animateTo.getValue().floatValue();
                    Ref$FloatRef ref$FloatRef2 = ref$FloatRef;
                    DragScope.this.dragBy(floatValue - ref$FloatRef2.element);
                    ref$FloatRef2.element = animateTo.getValue().floatValue();
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (Animatable$default.animateTo(f2, tweenSpec, f3, function1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
