package androidx.compose.foundation.lazy;

import androidx.compose.foundation.MutatePriority;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

/* compiled from: LazyListState.kt */
@DebugMetadata(c = "androidx.compose.foundation.lazy.LazyListState", f = "LazyListState.kt", l = {269, 270}, m = "scroll")
/* loaded from: classes.dex */
public final class LazyListState$scroll$1 extends ContinuationImpl {
    public LazyListState L$0;
    public MutatePriority L$1;
    public Function2 L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ LazyListState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyListState$scroll$1(LazyListState lazyListState, Continuation<? super LazyListState$scroll$1> continuation) {
        super(continuation);
        this.this$0 = lazyListState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.scroll(null, null, this);
    }
}
