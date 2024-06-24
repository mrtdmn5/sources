package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.ScrollScope;
import com.animaconnected.secondo.R;
import com.google.android.gms.common.zzw;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SnapFlingBehavior.kt */
@DebugMetadata(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1", f = "SnapFlingBehavior.kt", l = {133, R.styleable.AppTheme_stepsHistoryColumnColorActivity}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SnapFlingBehavior$fling$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AnimationResult<Float, AnimationVector1D>>, Object> {
    public final /* synthetic */ float $initialVelocity;
    public final /* synthetic */ Function1<Float, Unit> $onRemainingScrollOffsetUpdate;
    public final /* synthetic */ ScrollScope $this_fling;
    public int label;
    public final /* synthetic */ SnapFlingBehavior this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnapFlingBehavior$fling$result$1(float f, ScrollScope scrollScope, SnapFlingBehavior snapFlingBehavior, Continuation continuation, Function1 function1) {
        super(2, continuation);
        this.$initialVelocity = f;
        this.this$0 = snapFlingBehavior;
        this.$this_fling = scrollScope;
        this.$onRemainingScrollOffsetUpdate = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SnapFlingBehavior$fling$result$1(this.$initialVelocity, this.$this_fling, this.this$0, continuation, this.$onRemainingScrollOffsetUpdate);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        return ((SnapFlingBehavior$fling$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return (AnimationResult) obj;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return (AnimationResult) obj;
        }
        ResultKt.throwOnFailure(obj);
        float f = this.$initialVelocity;
        float abs = Math.abs(f);
        SnapFlingBehavior snapFlingBehavior = this.this$0;
        float abs2 = Math.abs(snapFlingBehavior.velocityThreshold);
        final Function1<Float, Unit> function1 = this.$onRemainingScrollOffsetUpdate;
        if (abs <= abs2) {
            ScrollScope scrollScope = this.$this_fling;
            this.label = 1;
            float calculateSnappingOffset = snapFlingBehavior.snapLayoutInfoProvider.calculateSnappingOffset(0.0f, snapFlingBehavior.density);
            final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
            ref$FloatRef.element = calculateSnappingOffset;
            obj = SnapFlingBehaviorKt.access$animateSnap(scrollScope, calculateSnappingOffset, calculateSnappingOffset, zzw.AnimationState$default(f, 28), snapFlingBehavior.snapAnimationSpec, new Function1<Float, Unit>() { // from class: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$shortSnap$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Float f2) {
                    float floatValue = f2.floatValue();
                    Ref$FloatRef ref$FloatRef2 = Ref$FloatRef.this;
                    float f3 = ref$FloatRef2.element - floatValue;
                    ref$FloatRef2.element = f3;
                    function1.invoke(Float.valueOf(f3));
                    return Unit.INSTANCE;
                }
            }, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
            return (AnimationResult) obj;
        }
        this.label = 2;
        obj = SnapFlingBehavior.access$longSnap(f, this.$this_fling, snapFlingBehavior, this, function1);
        if (obj == coroutineSingletons) {
            return coroutineSingletons;
        }
        return (AnimationResult) obj;
    }
}
