package androidx.compose.material;

import com.animaconnected.secondo.R;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Swipeable.kt */
@DebugMetadata(c = "androidx.compose.material.SwipeableState", f = "Swipeable.kt", l = {R.styleable.AppTheme_styleMarbleText, 183, 186}, m = "processNewAnchors$material_release")
/* loaded from: classes.dex */
public final class SwipeableState$processNewAnchors$1 extends ContinuationImpl {
    public float F$0;
    public SwipeableState L$0;
    public Map L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SwipeableState<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeableState$processNewAnchors$1(SwipeableState<T> swipeableState, Continuation<? super SwipeableState$processNewAnchors$1> continuation) {
        super(continuation);
        this.this$0 = swipeableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.processNewAnchors$material_release(null, null, this);
    }
}
