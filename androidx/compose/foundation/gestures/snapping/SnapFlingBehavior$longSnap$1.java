package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.gestures.ScrollScope;
import com.animaconnected.secondo.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$FloatRef;

/* compiled from: SnapFlingBehavior.kt */
@DebugMetadata(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehavior", f = "SnapFlingBehavior.kt", l = {R.styleable.AppTheme_workoutDetailColorBackground, 191}, m = "longSnap")
/* loaded from: classes.dex */
public final class SnapFlingBehavior$longSnap$1 extends ContinuationImpl {
    public SnapFlingBehavior L$0;
    public ScrollScope L$1;
    public Function1 L$2;
    public Ref$FloatRef L$3;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SnapFlingBehavior this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnapFlingBehavior$longSnap$1(SnapFlingBehavior snapFlingBehavior, Continuation<? super SnapFlingBehavior$longSnap$1> continuation) {
        super(continuation);
        this.this$0 = snapFlingBehavior;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SnapFlingBehavior.access$longSnap(0.0f, null, this.this$0, this, null);
    }
}
