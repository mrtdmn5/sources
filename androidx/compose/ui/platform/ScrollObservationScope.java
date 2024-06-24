package androidx.compose.ui.platform;

import androidx.compose.ui.node.OwnerScope;
import androidx.compose.ui.semantics.ScrollAxisRange;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
/* loaded from: classes.dex */
public final class ScrollObservationScope implements OwnerScope {
    public final List<ScrollObservationScope> allScopes;
    public ScrollAxisRange horizontalScrollAxisRange;
    public Float oldXValue;
    public Float oldYValue;
    public final int semanticsNodeId;
    public ScrollAxisRange verticalScrollAxisRange;

    public ScrollObservationScope(int r2, ArrayList allScopes) {
        Intrinsics.checkNotNullParameter(allScopes, "allScopes");
        this.semanticsNodeId = r2;
        this.allScopes = allScopes;
        this.oldXValue = null;
        this.oldYValue = null;
        this.horizontalScrollAxisRange = null;
        this.verticalScrollAxisRange = null;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public final boolean isValidOwnerScope() {
        return this.allScopes.contains(this);
    }
}
