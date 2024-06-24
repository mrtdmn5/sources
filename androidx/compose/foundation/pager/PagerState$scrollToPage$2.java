package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.ui.layout.Remeasurement;
import com.amplifyframework.core.model.Model$$ExternalSyntheticOutline0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: PagerState.kt */
@DebugMetadata(c = "androidx.compose.foundation.pager.PagerState$scrollToPage$2", f = "PagerState.kt", l = {421}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PagerState$scrollToPage$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ int $page;
    public final /* synthetic */ float $pageOffsetFraction;
    public int label;
    public final /* synthetic */ PagerState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerState$scrollToPage$2(PagerState pagerState, float f, int r3, Continuation<? super PagerState$scrollToPage$2> continuation) {
        super(2, continuation);
        this.this$0 = pagerState;
        this.$pageOffsetFraction = f;
        this.$page = r3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PagerState$scrollToPage$2(this.this$0, this.$pageOffsetFraction, this.$page, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
        return ((PagerState$scrollToPage$2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        boolean z = true;
        PagerState pagerState = this.this$0;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object waitForFirstLayout = pagerState.awaitLayoutModifier.waitForFirstLayout(this);
            if (waitForFirstLayout != coroutineSingletons) {
                waitForFirstLayout = Unit.INSTANCE;
            }
            if (waitForFirstLayout == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        float f = this.$pageOffsetFraction;
        double d = f;
        if (-0.5d > d || d > 0.5d) {
            z = false;
        }
        if (z) {
            pagerState.scrollPosition.update(pagerState.coerceInPageRange(this.$page), MathKt__MathJVMKt.roundToInt(pagerState.getPageAvailableSpace() * f));
            Remeasurement remeasurement = (Remeasurement) pagerState.remeasurement$delegate.getValue();
            if (remeasurement != null) {
                remeasurement.forceRemeasure();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalArgumentException(Model$$ExternalSyntheticOutline0.m("pageOffsetFraction ", f, " is not within the range -0.5 to 0.5").toString());
    }
}
