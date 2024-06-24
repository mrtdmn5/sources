package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import java.util.List;

/* compiled from: Brush.kt */
/* loaded from: classes.dex */
public abstract class Brush {

    /* compiled from: Brush.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        /* renamed from: verticalGradient-8A-3gB4$default, reason: not valid java name */
        public static LinearGradient m311verticalGradient8A3gB4$default(List list, float f, float f2, int r12) {
            if ((r12 & 2) != 0) {
                f = 0.0f;
            }
            if ((r12 & 4) != 0) {
                f2 = Float.POSITIVE_INFINITY;
            }
            return new LinearGradient(list, OffsetKt.Offset(0.0f, f), OffsetKt.Offset(0.0f, f2), 0);
        }
    }

    static {
        new Companion();
    }

    public Brush() {
        int r0 = Size.$r8$clinit;
    }

    /* renamed from: applyTo-Pq9zytI, reason: not valid java name */
    public abstract void mo310applyToPq9zytI(float f, long j, Paint paint);
}
