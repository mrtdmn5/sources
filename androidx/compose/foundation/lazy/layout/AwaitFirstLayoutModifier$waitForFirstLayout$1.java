package androidx.compose.foundation.lazy.layout;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AwaitFirstLayoutModifier.kt */
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier", f = "AwaitFirstLayoutModifier.kt", l = {35}, m = "waitForFirstLayout")
/* loaded from: classes.dex */
public final class AwaitFirstLayoutModifier$waitForFirstLayout$1 extends ContinuationImpl {
    public Continuation L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ AwaitFirstLayoutModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AwaitFirstLayoutModifier$waitForFirstLayout$1(AwaitFirstLayoutModifier awaitFirstLayoutModifier, Continuation<? super AwaitFirstLayoutModifier$waitForFirstLayout$1> continuation) {
        super(continuation);
        this.this$0 = awaitFirstLayoutModifier;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.waitForFirstLayout(this);
    }
}
