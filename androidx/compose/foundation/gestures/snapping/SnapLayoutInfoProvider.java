package androidx.compose.foundation.gestures.snapping;

import androidx.compose.ui.unit.Density;

/* compiled from: SnapLayoutInfoProvider.kt */
/* loaded from: classes.dex */
public interface SnapLayoutInfoProvider {
    float calculateApproachOffset(float f, Density density);

    float calculateSnapStepSize(Density density);

    float calculateSnappingOffset(float f, Density density);
}
