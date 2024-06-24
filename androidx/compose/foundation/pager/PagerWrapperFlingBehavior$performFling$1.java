package androidx.compose.foundation.pager;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Pager.kt */
@DebugMetadata(c = "androidx.compose.foundation.pager.PagerWrapperFlingBehavior", f = "Pager.kt", l = {794}, m = "performFling")
/* loaded from: classes.dex */
public final class PagerWrapperFlingBehavior$performFling$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ PagerWrapperFlingBehavior this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerWrapperFlingBehavior$performFling$1(PagerWrapperFlingBehavior pagerWrapperFlingBehavior, Continuation<? super PagerWrapperFlingBehavior$performFling$1> continuation) {
        super(continuation);
        this.this$0 = pagerWrapperFlingBehavior;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.performFling(null, 0.0f, this);
    }
}
