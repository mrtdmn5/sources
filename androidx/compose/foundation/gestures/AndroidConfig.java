package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidScrollable.android.kt */
/* loaded from: classes.dex */
public final class AndroidConfig implements ScrollConfig {
    public static final AndroidConfig INSTANCE = new AndroidConfig();

    @Override // androidx.compose.foundation.gestures.ScrollConfig
    /* renamed from: calculateMouseWheelScroll-8xgXZGE, reason: not valid java name */
    public final long mo32calculateMouseWheelScroll8xgXZGE(AwaitPointerEventScope calculateMouseWheelScroll, PointerEvent pointerEvent) {
        Intrinsics.checkNotNullParameter(calculateMouseWheelScroll, "$this$calculateMouseWheelScroll");
        Offset offset = new Offset(Offset.Zero);
        List<PointerInputChange> list = pointerEvent.changes;
        int size = list.size();
        int r1 = 0;
        while (true) {
            long j = offset.packedValue;
            if (r1 < size) {
                Offset offset2 = new Offset(Offset.m262plusMKHz9U(j, list.get(r1).scrollDelta));
                r1++;
                offset = offset2;
            } else {
                return Offset.m263timestuRUvjQ(-calculateMouseWheelScroll.mo49toPx0680j_4(64), j);
            }
        }
    }
}
