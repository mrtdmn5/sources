package androidx.compose.foundation.gestures.snapping;

import androidx.compose.ui.unit.Density;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SnapFlingBehavior.kt */
@DebugMetadata(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt", f = "SnapFlingBehavior.kt", l = {312}, m = "approach")
/* loaded from: classes.dex */
public final class SnapFlingBehaviorKt$approach$1 extends ContinuationImpl {
    public SnapLayoutInfoProvider L$0;
    public Density L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SnapFlingBehaviorKt.access$approach(null, 0.0f, 0.0f, null, null, null, null, this);
    }
}
