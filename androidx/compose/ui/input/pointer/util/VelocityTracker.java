package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.geometry.Offset;

/* compiled from: VelocityTracker.kt */
/* loaded from: classes.dex */
public final class VelocityTracker {
    public final VelocityTracker1D xVelocityTracker = new VelocityTracker1D();
    public final VelocityTracker1D yVelocityTracker = new VelocityTracker1D();
    public long currentPointerPositionAccumulator = Offset.Zero;
}
