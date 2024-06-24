package androidx.compose.ui.node;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.layout.MeasurePolicy;
import com.google.common.collect.Platform;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IntrinsicsPolicy.kt */
/* loaded from: classes.dex */
public final class IntrinsicsPolicy {
    public final LayoutNode layoutNode;
    public final ParcelableSnapshotMutableState measurePolicyState$delegate;

    public IntrinsicsPolicy(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.layoutNode = layoutNode;
        this.measurePolicyState$delegate = Platform.mutableStateOf$default(null);
    }

    public final MeasurePolicy measurePolicyFromState() {
        MeasurePolicy measurePolicy = (MeasurePolicy) this.measurePolicyState$delegate.getValue();
        if (measurePolicy != null) {
            return measurePolicy;
        }
        throw new IllegalStateException("Intrinsic size is queried but there is no measure policy in place.".toString());
    }
}
