package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$LongRef;

/* compiled from: Scrollable.kt */
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2", f = "Scrollable.kt", l = {500}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ScrollingLogic$doFlingAnimation$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ long $available;
    public final /* synthetic */ Ref$LongRef $result;
    public long J$0;
    public /* synthetic */ Object L$0;
    public ScrollingLogic L$1;
    public Ref$LongRef L$2;
    public int label;
    public final /* synthetic */ ScrollingLogic this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollingLogic$doFlingAnimation$2(ScrollingLogic scrollingLogic, Ref$LongRef ref$LongRef, long j, Continuation<? super ScrollingLogic$doFlingAnimation$2> continuation) {
        super(2, continuation);
        this.this$0 = scrollingLogic;
        this.$result = ref$LongRef;
        this.$available = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ScrollingLogic$doFlingAnimation$2 scrollingLogic$doFlingAnimation$2 = new ScrollingLogic$doFlingAnimation$2(this.this$0, this.$result, this.$available, continuation);
        scrollingLogic$doFlingAnimation$2.L$0 = obj;
        return scrollingLogic$doFlingAnimation$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
        return ((ScrollingLogic$doFlingAnimation$2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v3, types: [androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2$scope$1] */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2$outerScopeScroll$1] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        final ScrollingLogic scrollingLogic;
        Ref$LongRef ref$LongRef;
        float m605getYimpl;
        long j;
        ScrollingLogic scrollingLogic2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        int r3 = 1;
        if (r1 != 0) {
            if (r1 == 1) {
                j = this.J$0;
                ref$LongRef = this.L$2;
                scrollingLogic = this.L$1;
                scrollingLogic2 = (ScrollingLogic) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            final ScrollScope scrollScope = (ScrollScope) this.L$0;
            scrollingLogic = this.this$0;
            final ?? r12 = new Function1<Offset, Offset>() { // from class: androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2$outerScopeScroll$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Offset invoke(Offset offset) {
                    long j2 = offset.packedValue;
                    ScrollingLogic scrollingLogic3 = ScrollingLogic.this;
                    if (scrollingLogic3.reverseDirection) {
                        j2 = Offset.m263timestuRUvjQ(-1.0f, j2);
                    }
                    long m54dispatchScroll3eAAhYA = scrollingLogic3.m54dispatchScroll3eAAhYA(scrollScope, j2, 2);
                    if (scrollingLogic3.reverseDirection) {
                        m54dispatchScroll3eAAhYA = Offset.m263timestuRUvjQ(-1.0f, m54dispatchScroll3eAAhYA);
                    }
                    return new Offset(m54dispatchScroll3eAAhYA);
                }
            };
            ?? r14 = new ScrollScope() { // from class: androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2$scope$1
                @Override // androidx.compose.foundation.gestures.ScrollScope
                public final float scrollBy(float f) {
                    ScrollingLogic scrollingLogic3 = ScrollingLogic.this;
                    return scrollingLogic3.m57toFloatk4lQ0M(r12.invoke(new Offset(scrollingLogic3.m58toOffsettuRUvjQ(f))).packedValue);
                }
            };
            FlingBehavior flingBehavior = scrollingLogic.flingBehavior;
            ref$LongRef = this.$result;
            long j2 = ref$LongRef.element;
            Orientation orientation = Orientation.Horizontal;
            Orientation orientation2 = scrollingLogic.orientation;
            long j3 = this.$available;
            if (orientation2 == orientation) {
                m605getYimpl = Velocity.m604getXimpl(j3);
            } else {
                m605getYimpl = Velocity.m605getYimpl(j3);
            }
            if (scrollingLogic.reverseDirection) {
                m605getYimpl *= -1;
            }
            this.L$0 = scrollingLogic;
            this.L$1 = scrollingLogic;
            this.L$2 = ref$LongRef;
            this.J$0 = j2;
            this.label = 1;
            obj = flingBehavior.performFling(r14, m605getYimpl, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
            j = j2;
            scrollingLogic2 = scrollingLogic;
        }
        float floatValue = ((Number) obj).floatValue();
        if (scrollingLogic2.reverseDirection) {
            floatValue *= -1;
        }
        float f = 0.0f;
        if (scrollingLogic.orientation == Orientation.Horizontal) {
            r3 = 2;
        } else {
            f = floatValue;
            floatValue = 0.0f;
        }
        ref$LongRef.element = Velocity.m603copyOhffZ5M$default(j, floatValue, f, r3);
        return Unit.INSTANCE;
    }
}
