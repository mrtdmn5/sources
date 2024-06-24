package androidx.compose.foundation.gestures;

import com.animaconnected.secondo.R;
import kotlin.Function;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;

/* compiled from: UpdatableAnimationState.kt */
@DebugMetadata(c = "androidx.compose.foundation.gestures.UpdatableAnimationState", f = "UpdatableAnimationState.kt", l = {100, R.styleable.AppTheme_stepsHistoryHintBackgroundColorDetail}, m = "animateToZero")
/* loaded from: classes.dex */
public final class UpdatableAnimationState$animateToZero$1 extends ContinuationImpl {
    public float F$0;
    public UpdatableAnimationState L$0;
    public Function L$1;
    public Function0 L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ UpdatableAnimationState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdatableAnimationState$animateToZero$1(UpdatableAnimationState updatableAnimationState, Continuation<? super UpdatableAnimationState$animateToZero$1> continuation) {
        super(continuation);
        this.this$0 = updatableAnimationState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.animateToZero(null, null, this);
    }
}
