package androidx.compose.ui.input.nestedscroll;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: NestedScrollNode.kt */
@DebugMetadata(c = "androidx.compose.ui.input.nestedscroll.NestedScrollNode", f = "NestedScrollNode.kt", l = {98, 99}, m = "onPreFling-QWom1Mo")
/* loaded from: classes.dex */
public final class NestedScrollNode$onPreFling$1 extends ContinuationImpl {
    public long J$0;
    public NestedScrollNode L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ NestedScrollNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollNode$onPreFling$1(NestedScrollNode nestedScrollNode, Continuation<? super NestedScrollNode$onPreFling$1> continuation) {
        super(continuation);
        this.this$0 = nestedScrollNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo159onPreFlingQWom1Mo(0L, this);
    }
}
