package androidx.compose.foundation.gestures;

import com.animaconnected.watch.display.PascalDisplay;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: TapGestureDetector.kt */
@DebugMetadata(c = "androidx.compose.foundation.gestures.PressGestureScopeImpl", f = "TapGestureDetector.kt", l = {PascalDisplay.right}, m = "tryAwaitRelease")
/* loaded from: classes.dex */
public final class PressGestureScopeImpl$tryAwaitRelease$1 extends ContinuationImpl {
    public PressGestureScopeImpl L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ PressGestureScopeImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PressGestureScopeImpl$tryAwaitRelease$1(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super PressGestureScopeImpl$tryAwaitRelease$1> continuation) {
        super(continuation);
        this.this$0 = pressGestureScopeImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.tryAwaitRelease(this);
    }
}
