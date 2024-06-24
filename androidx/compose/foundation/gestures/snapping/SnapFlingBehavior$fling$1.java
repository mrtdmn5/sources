package androidx.compose.foundation.gestures.snapping;

import com.animaconnected.secondo.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* compiled from: SnapFlingBehavior.kt */
@DebugMetadata(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehavior", f = "SnapFlingBehavior.kt", l = {R.styleable.AppTheme_stepsHistoryBackgroundActivity}, m = "fling")
/* loaded from: classes.dex */
public final class SnapFlingBehavior$fling$1 extends ContinuationImpl {
    public Function1 L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SnapFlingBehavior this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnapFlingBehavior$fling$1(SnapFlingBehavior snapFlingBehavior, Continuation<? super SnapFlingBehavior$fling$1> continuation) {
        super(continuation);
        this.this$0 = snapFlingBehavior;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fling(null, 0.0f, null, this);
    }
}
