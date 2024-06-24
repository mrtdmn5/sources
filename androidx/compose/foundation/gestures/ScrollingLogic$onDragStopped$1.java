package androidx.compose.foundation.gestures;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Scrollable.kt */
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic", f = "Scrollable.kt", l = {477, 479}, m = "onDragStopped-sF-c-tU")
/* loaded from: classes.dex */
public final class ScrollingLogic$onDragStopped$1 extends ContinuationImpl {
    public ScrollingLogic L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ScrollingLogic this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollingLogic$onDragStopped$1(ScrollingLogic scrollingLogic, Continuation<? super ScrollingLogic$onDragStopped$1> continuation) {
        super(continuation);
        this.this$0 = scrollingLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m56onDragStoppedsFctU(0L, this);
    }
}
