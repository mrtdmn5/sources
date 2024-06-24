package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$FloatRef;

/* compiled from: AnchoredDraggable.kt */
@DebugMetadata(c = "androidx.compose.material.AnchoredDraggableKt$animateTo$2", f = "AnchoredDraggable.kt", l = {586}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AnchoredDraggableKt$animateTo$2 extends SuspendLambda implements Function3<AnchoredDragScope, Map<Object, ? extends Float>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Object $targetValue;
    public final /* synthetic */ AnchoredDraggableState<Object> $this_animateTo;
    public final /* synthetic */ float $velocity;
    public /* synthetic */ AnchoredDragScope L$0;
    public /* synthetic */ Map L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchoredDraggableKt$animateTo$2(float f, AnchoredDraggableState anchoredDraggableState, Object obj, Continuation continuation) {
        super(3, continuation);
        this.$targetValue = obj;
        this.$this_animateTo = anchoredDraggableState;
        this.$velocity = f;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(AnchoredDragScope anchoredDragScope, Map<Object, ? extends Float> map, Continuation<? super Unit> continuation) {
        Object obj = this.$targetValue;
        AnchoredDraggableState<Object> anchoredDraggableState = this.$this_animateTo;
        AnchoredDraggableKt$animateTo$2 anchoredDraggableKt$animateTo$2 = new AnchoredDraggableKt$animateTo$2(this.$velocity, anchoredDraggableState, obj, continuation);
        anchoredDraggableKt$animateTo$2.L$0 = anchoredDragScope;
        anchoredDraggableKt$animateTo$2.L$1 = map;
        return anchoredDraggableKt$animateTo$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        float offset;
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
            final AnchoredDragScope anchoredDragScope = this.L$0;
            Float f = (Float) this.L$1.get(this.$targetValue);
            if (f != null) {
                final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
                AnchoredDraggableState<Object> anchoredDraggableState = this.$this_animateTo;
                if (Float.isNaN(anchoredDraggableState.getOffset())) {
                    offset = 0.0f;
                } else {
                    offset = anchoredDraggableState.getOffset();
                }
                float f2 = offset;
                ref$FloatRef.element = f2;
                float floatValue = f.floatValue();
                float f3 = this.$velocity;
                AnimationSpec<Float> animationSpec = anchoredDraggableState.animationSpec;
                Function2<Float, Float, Unit> function2 = new Function2<Float, Float, Unit>() { // from class: androidx.compose.material.AnchoredDraggableKt$animateTo$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Float f4, Float f5) {
                        float floatValue2 = f4.floatValue();
                        AnchoredDragScope.this.dragTo(floatValue2, f5.floatValue());
                        ref$FloatRef.element = floatValue2;
                        return Unit.INSTANCE;
                    }
                };
                this.L$0 = null;
                this.label = 1;
                if (SuspendAnimationKt.animate(f2, floatValue, f3, animationSpec, function2, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        }
        return Unit.INSTANCE;
    }
}
