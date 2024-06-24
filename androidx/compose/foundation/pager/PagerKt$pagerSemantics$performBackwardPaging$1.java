package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpecKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Pager.kt */
@DebugMetadata(c = "androidx.compose.foundation.pager.PagerKt$pagerSemantics$performBackwardPaging$1", f = "Pager.kt", l = {859}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PagerKt$pagerSemantics$performBackwardPaging$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ PagerState $state;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerKt$pagerSemantics$performBackwardPaging$1(PagerState pagerState, Continuation<? super PagerKt$pagerSemantics$performBackwardPaging$1> continuation) {
        super(2, continuation);
        this.$state = pagerState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PagerKt$pagerSemantics$performBackwardPaging$1(this.$state, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PagerKt$pagerSemantics$performBackwardPaging$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object obj3 = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            float f = PagerStateKt.DefaultPositionThreshold;
            PagerState pagerState = this.$state;
            if (pagerState.getCurrentPage() - 1 >= 0) {
                obj2 = pagerState.animateScrollToPage(pagerState.getCurrentPage() - 1, 0.0f, AnimationSpecKt.spring$default(400.0f, null, 5), this);
                if (obj2 != obj3) {
                    obj2 = Unit.INSTANCE;
                }
            } else {
                obj2 = Unit.INSTANCE;
            }
            if (obj2 == obj3) {
                return obj3;
            }
        }
        return Unit.INSTANCE;
    }
}
