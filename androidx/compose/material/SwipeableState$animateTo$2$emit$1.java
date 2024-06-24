package androidx.compose.material;

import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Swipeable.kt */
@DebugMetadata(c = "androidx.compose.material.SwipeableState$animateTo$2", f = "Swipeable.kt", l = {335}, m = "emit")
/* loaded from: classes.dex */
public final class SwipeableState$animateTo$2$emit$1 extends ContinuationImpl {
    public SwipeableState$animateTo$2 L$0;
    public Map L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SwipeableState$animateTo$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeableState$animateTo$2$emit$1(SwipeableState$animateTo$2 swipeableState$animateTo$2, Continuation<? super SwipeableState$animateTo$2$emit$1> continuation) {
        super(continuation);
        this.this$0 = swipeableState$animateTo$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit2((Map<Float, Object>) null, (Continuation<? super Unit>) this);
    }
}
