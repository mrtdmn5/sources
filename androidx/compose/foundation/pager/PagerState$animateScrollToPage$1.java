package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: PagerState.kt */
@DebugMetadata(c = "androidx.compose.foundation.pager.PagerState", f = "PagerState.kt", l = {453, 478, 490}, m = "animateScrollToPage")
/* loaded from: classes.dex */
public final class PagerState$animateScrollToPage$1 extends ContinuationImpl {
    public float F$0;
    public int I$0;
    public int I$1;
    public PagerState L$0;
    public AnimationSpec L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ PagerState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerState$animateScrollToPage$1(PagerState pagerState, Continuation<? super PagerState$animateScrollToPage$1> continuation) {
        super(continuation);
        this.this$0 = pagerState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.animateScrollToPage(0, 0.0f, null, this);
    }
}
