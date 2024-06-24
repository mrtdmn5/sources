package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;

/* compiled from: SelectionHandles.kt */
/* loaded from: classes.dex */
public final class SelectionHandlesKt {
    public static final float HandleHeight;
    public static final float HandleWidth;
    public static final SemanticsPropertyKey<SelectionHandleInfo> SelectionHandleInfoKey = new SemanticsPropertyKey<>("SelectionHandleInfo", SemanticsPropertyKey.AnonymousClass1.INSTANCE);

    static {
        float f = 25;
        HandleWidth = f;
        HandleHeight = f;
    }

    /* renamed from: getAdjustedCoordinates-k-4lQ0M, reason: not valid java name */
    public static final long m141getAdjustedCoordinatesk4lQ0M(long j) {
        return OffsetKt.Offset(Offset.m259getXimpl(j), Offset.m260getYimpl(j) - 1.0f);
    }
}
