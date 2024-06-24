package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
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

/* compiled from: Swipeable.kt */
@DebugMetadata(c = "androidx.compose.material.SwipeableState$animateInternalToOffset$2", f = "Swipeable.kt", l = {223}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SwipeableState$animateInternalToOffset$2 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ AnimationSpec<Float> $spec;
    public final /* synthetic */ float $target;
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ SwipeableState<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeableState$animateInternalToOffset$2(SwipeableState<T> swipeableState, float f, AnimationSpec<Float> animationSpec, Continuation<? super SwipeableState$animateInternalToOffset$2> continuation) {
        super(2, continuation);
        this.this$0 = swipeableState;
        this.$target = f;
        this.$spec = animationSpec;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SwipeableState$animateInternalToOffset$2 swipeableState$animateInternalToOffset$2 = new SwipeableState$animateInternalToOffset$2(this.this$0, this.$target, this.$spec, continuation);
        swipeableState$animateInternalToOffset$2.L$0 = obj;
        return swipeableState$animateInternalToOffset$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(DragScope dragScope, Continuation<? super Unit> continuation) {
        return ((SwipeableState$animateInternalToOffset$2) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [androidx.compose.material.SwipeableState$animateInternalToOffset$2$1] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        SwipeableState<T> swipeableState = this.this$0;
        try {
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
                ref$FloatRef.element = swipeableState.absoluteOffset.getFloatValue();
                float f = this.$target;
                swipeableState.animationTarget.setValue(new Float(f));
                swipeableState.isAnimationRunning$delegate.setValue(Boolean.TRUE);
                Animatable Animatable$default = zzu.Animatable$default(ref$FloatRef.element);
                Float f2 = new Float(f);
                AnimationSpec<Float> animationSpec = this.$spec;
                ?? r10 = new Function1<Animatable<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material.SwipeableState$animateInternalToOffset$2.1
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
                if (Animatable.animateTo$default(Animatable$default, f2, animationSpec, r10, this, 4) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            swipeableState.animationTarget.setValue(null);
            swipeableState.isAnimationRunning$delegate.setValue(Boolean.FALSE);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            swipeableState.animationTarget.setValue(null);
            swipeableState.isAnimationRunning$delegate.setValue(Boolean.FALSE);
            throw th;
        }
    }
}
