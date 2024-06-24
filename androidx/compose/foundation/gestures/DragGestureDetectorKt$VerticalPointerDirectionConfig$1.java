package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;

/* compiled from: DragGestureDetector.kt */
/* loaded from: classes.dex */
public final class DragGestureDetectorKt$VerticalPointerDirectionConfig$1 implements PointerDirectionConfig {
    @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
    /* renamed from: crossAxisDelta-k-4lQ0M */
    public final float mo39crossAxisDeltak4lQ0M(long j) {
        return Offset.m259getXimpl(j);
    }

    @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
    /* renamed from: mainAxisDelta-k-4lQ0M */
    public final float mo40mainAxisDeltak4lQ0M(long j) {
        return Offset.m260getYimpl(j);
    }

    @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
    /* renamed from: offsetFromChanges-dBAh8RU */
    public final long mo41offsetFromChangesdBAh8RU(float f, float f2) {
        return OffsetKt.Offset(f2, f);
    }
}
