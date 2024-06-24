package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import com.google.android.gms.common.zzw;
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
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Scrollable.kt */
@DebugMetadata(c = "androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2", f = "Scrollable.kt", l = {603}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DefaultFlingBehavior$performFling$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Float>, Object> {
    public final /* synthetic */ float $initialVelocity;
    public final /* synthetic */ ScrollScope $this_performFling;
    public Ref$FloatRef L$0;
    public int label;
    public final /* synthetic */ DefaultFlingBehavior this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultFlingBehavior$performFling$2(float f, DefaultFlingBehavior defaultFlingBehavior, ScrollScope scrollScope, Continuation<? super DefaultFlingBehavior$performFling$2> continuation) {
        super(2, continuation);
        this.$initialVelocity = f;
        this.this$0 = defaultFlingBehavior;
        this.$this_performFling = scrollScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultFlingBehavior$performFling$2(this.$initialVelocity, this.this$0, this.$this_performFling, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Float> continuation) {
        return ((DefaultFlingBehavior$performFling$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        float f;
        Ref$FloatRef ref$FloatRef;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ref$FloatRef = this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            f = this.$initialVelocity;
            if (Math.abs(f) > 1.0f) {
                final Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
                ref$FloatRef2.element = f;
                final Ref$FloatRef ref$FloatRef3 = new Ref$FloatRef();
                AnimationState AnimationState$default = zzw.AnimationState$default(f, 28);
                final DefaultFlingBehavior defaultFlingBehavior = this.this$0;
                DecayAnimationSpec<Float> decayAnimationSpec = defaultFlingBehavior.flingDecay;
                final ScrollScope scrollScope = this.$this_performFling;
                Function1<AnimationScope<Float, AnimationVector1D>, Unit> function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                        AnimationScope<Float, AnimationVector1D> animateDecay = animationScope;
                        Intrinsics.checkNotNullParameter(animateDecay, "$this$animateDecay");
                        float floatValue = animateDecay.getValue().floatValue();
                        Ref$FloatRef ref$FloatRef4 = Ref$FloatRef.this;
                        float f2 = floatValue - ref$FloatRef4.element;
                        float scrollBy = scrollScope.scrollBy(f2);
                        ref$FloatRef4.element = animateDecay.getValue().floatValue();
                        ref$FloatRef2.element = animateDecay.typeConverter.getConvertFromVector().invoke(animateDecay.velocityVector).floatValue();
                        if (Math.abs(f2 - scrollBy) > 0.5f) {
                            animateDecay.cancelAnimation();
                        }
                        defaultFlingBehavior.getClass();
                        return Unit.INSTANCE;
                    }
                };
                this.L$0 = ref$FloatRef2;
                this.label = 1;
                if (SuspendAnimationKt.animateDecay(AnimationState$default, decayAnimationSpec, false, function1, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                ref$FloatRef = ref$FloatRef2;
            }
            return new Float(f);
        }
        f = ref$FloatRef.element;
        return new Float(f);
    }
}
