package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import com.animaconnected.watch.display.PascalDisplay;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SnackbarHost.kt */
@DebugMetadata(c = "androidx.compose.material.SnackbarHostKt$animatedOpacity$2", f = "SnackbarHost.kt", l = {PascalDisplay.visibleWidth}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SnackbarHostKt$animatedOpacity$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Animatable<Float, AnimationVector1D> $alpha;
    public final /* synthetic */ AnimationSpec<Float> $animation;
    public final /* synthetic */ Function0<Unit> $onAnimationFinish;
    public final /* synthetic */ boolean $visible;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnackbarHostKt$animatedOpacity$2(Animatable<Float, AnimationVector1D> animatable, boolean z, AnimationSpec<Float> animationSpec, Function0<Unit> function0, Continuation<? super SnackbarHostKt$animatedOpacity$2> continuation) {
        super(2, continuation);
        this.$alpha = animatable;
        this.$visible = z;
        this.$animation = animationSpec;
        this.$onAnimationFinish = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SnackbarHostKt$animatedOpacity$2(this.$alpha, this.$visible, this.$animation, this.$onAnimationFinish, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SnackbarHostKt$animatedOpacity$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        float f;
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
            Animatable<Float, AnimationVector1D> animatable = this.$alpha;
            if (this.$visible) {
                f = 1.0f;
            } else {
                f = 0.0f;
            }
            Float f2 = new Float(f);
            AnimationSpec<Float> animationSpec = this.$animation;
            this.label = 1;
            if (Animatable.animateTo$default(animatable, f2, animationSpec, null, this, 12) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        this.$onAnimationFinish.invoke();
        return Unit.INSTANCE;
    }
}
