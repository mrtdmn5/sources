package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Pager.kt */
/* loaded from: classes.dex */
public final class ConsumeAllFlingOnDirection implements NestedScrollConnection {
    public final Orientation orientation;

    public ConsumeAllFlingOnDirection(Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        this.orientation = orientation;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY */
    public final Object mo51onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        long m603copyOhffZ5M$default;
        Orientation orientation = this.orientation;
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        if (orientation == Orientation.Vertical) {
            m603copyOhffZ5M$default = Velocity.m603copyOhffZ5M$default(j2, 0.0f, 0.0f, 2);
        } else {
            m603copyOhffZ5M$default = Velocity.m603copyOhffZ5M$default(j2, 0.0f, 0.0f, 1);
        }
        return new Velocity(m603copyOhffZ5M$default);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public final long mo52onPostScrollDzOQY0M(int r2, long j, long j2) {
        boolean z;
        if (r2 == 2) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Orientation orientation = this.orientation;
            Intrinsics.checkNotNullParameter(orientation, "orientation");
            if (orientation == Orientation.Vertical) {
                return Offset.m256copydBAh8RU$default(j2, 2);
            }
            return Offset.m256copydBAh8RU$default(j2, 1);
        }
        return Offset.Zero;
    }
}
