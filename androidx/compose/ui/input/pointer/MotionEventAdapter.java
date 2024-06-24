package androidx.compose.ui.input.pointer;

import android.util.SparseBooleanArray;
import android.util.SparseLongArray;
import java.util.ArrayList;

/* compiled from: MotionEventAdapter.android.kt */
/* loaded from: classes.dex */
public final class MotionEventAdapter {
    public long nextId;
    public final SparseLongArray motionEventToComposePointerIdMap = new SparseLongArray();
    public final SparseBooleanArray canHover = new SparseBooleanArray();
    public final ArrayList pointers = new ArrayList();
    public int previousToolType = -1;
    public int previousSource = -1;

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0152, code lost:            if (r6 != 4) goto L228;     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x015d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.compose.ui.input.pointer.PointerInputEvent convertToPointerInputEvent$ui_release(android.view.MotionEvent r37, androidx.compose.ui.input.pointer.PositionCalculator r38) {
        /*
            Method dump skipped, instructions count: 623
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.MotionEventAdapter.convertToPointerInputEvent$ui_release(android.view.MotionEvent, androidx.compose.ui.input.pointer.PositionCalculator):androidx.compose.ui.input.pointer.PointerInputEvent");
    }
}
