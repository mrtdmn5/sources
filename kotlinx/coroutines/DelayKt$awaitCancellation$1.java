package kotlinx.coroutines;

import com.animaconnected.secondo.R;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Delay.kt */
@DebugMetadata(c = "kotlinx.coroutines.DelayKt", f = "Delay.kt", l = {R.styleable.AppTheme_tabSelectIndicatorColor}, m = "awaitCancellation")
/* loaded from: classes4.dex */
public final class DelayKt$awaitCancellation$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DelayKt.awaitCancellation(this);
    }
}
