package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.StructuralEqualityPolicy;
import androidx.compose.runtime.saveable.SaverKt$Saver$1;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextRange;
import com.airbnb.lottie.L;
import com.google.common.base.Objects;
import com.google.common.collect.Platform;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextFieldScroll.kt */
/* loaded from: classes.dex */
public final class TextFieldScrollerPosition {
    public static final SaverKt$Saver$1 Saver = L.listSaver(new Function2<SaverScope, TextFieldScrollerPosition, List<? extends Object>>() { // from class: androidx.compose.foundation.text.TextFieldScrollerPosition$Companion$Saver$1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public final List<? extends Object> invoke(SaverScope saverScope, TextFieldScrollerPosition textFieldScrollerPosition) {
            SaverScope listSaver = saverScope;
            TextFieldScrollerPosition it = textFieldScrollerPosition;
            Intrinsics.checkNotNullParameter(listSaver, "$this$listSaver");
            Intrinsics.checkNotNullParameter(it, "it");
            Object[] objArr = new Object[2];
            boolean z = false;
            objArr[0] = Float.valueOf(it.getOffset());
            if (((Orientation) it.orientation$delegate.getValue()) == Orientation.Vertical) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            return CollectionsKt__CollectionsKt.listOf(objArr);
        }
    }, new Function1<List<? extends Object>, TextFieldScrollerPosition>() { // from class: androidx.compose.foundation.text.TextFieldScrollerPosition$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        public final TextFieldScrollerPosition invoke(List<? extends Object> list) {
            Orientation orientation;
            List<? extends Object> restored = list;
            Intrinsics.checkNotNullParameter(restored, "restored");
            Object obj = restored.get(1);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            if (((Boolean) obj).booleanValue()) {
                orientation = Orientation.Vertical;
            } else {
                orientation = Orientation.Horizontal;
            }
            Object obj2 = restored.get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
            return new TextFieldScrollerPosition(orientation, ((Float) obj2).floatValue());
        }
    });
    public final ParcelableSnapshotMutableFloatState maximum$delegate;
    public final ParcelableSnapshotMutableFloatState offset$delegate;
    public final ParcelableSnapshotMutableState orientation$delegate;
    public Rect previousCursorRect;
    public long previousSelection;

    public TextFieldScrollerPosition(Orientation initialOrientation, float f) {
        Intrinsics.checkNotNullParameter(initialOrientation, "initialOrientation");
        this.offset$delegate = Objects.mutableFloatStateOf(f);
        this.maximum$delegate = Objects.mutableFloatStateOf(0.0f);
        this.previousCursorRect = Rect.Zero;
        this.previousSelection = TextRange.Zero;
        this.orientation$delegate = Platform.mutableStateOf(initialOrientation, StructuralEqualityPolicy.INSTANCE);
    }

    public final float getOffset() {
        return this.offset$delegate.getFloatValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002b, code lost:            if (r0 == false) goto L13;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void update(androidx.compose.foundation.gestures.Orientation r9, androidx.compose.ui.geometry.Rect r10, int r11, int r12) {
        /*
            r8 = this;
            java.lang.String r0 = "orientation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            int r12 = r12 - r11
            float r12 = (float) r12
            androidx.compose.runtime.ParcelableSnapshotMutableFloatState r0 = r8.maximum$delegate
            r0.setFloatValue(r12)
            androidx.compose.ui.geometry.Rect r0 = r8.previousCursorRect
            float r1 = r0.left
            float r2 = r10.left
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            r3 = 1
            r4 = 0
            if (r1 != 0) goto L1a
            r1 = r3
            goto L1b
        L1a:
            r1 = r4
        L1b:
            androidx.compose.runtime.ParcelableSnapshotMutableFloatState r5 = r8.offset$delegate
            r6 = 0
            float r7 = r10.top
            if (r1 == 0) goto L2d
            float r0 = r0.top
            int r0 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r0 != 0) goto L2a
            r0 = r3
            goto L2b
        L2a:
            r0 = r4
        L2b:
            if (r0 != 0) goto L6a
        L2d:
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r9 != r0) goto L32
            goto L33
        L32:
            r3 = r4
        L33:
            if (r3 == 0) goto L36
            r2 = r7
        L36:
            if (r3 == 0) goto L3b
            float r9 = r10.bottom
            goto L3d
        L3b:
            float r9 = r10.right
        L3d:
            float r0 = r8.getOffset()
            float r11 = (float) r11
            float r1 = r0 + r11
            int r3 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r3 <= 0) goto L49
            goto L53
        L49:
            int r3 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r3 >= 0) goto L55
            float r4 = r9 - r2
            int r4 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r4 <= 0) goto L55
        L53:
            float r9 = r9 - r1
            goto L60
        L55:
            if (r3 >= 0) goto L5f
            float r9 = r9 - r2
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 > 0) goto L5f
            float r9 = r2 - r0
            goto L60
        L5f:
            r9 = r6
        L60:
            float r11 = r8.getOffset()
            float r11 = r11 + r9
            r5.setFloatValue(r11)
            r8.previousCursorRect = r10
        L6a:
            float r9 = r8.getOffset()
            float r9 = kotlin.ranges.RangesKt___RangesKt.coerceIn(r9, r6, r12)
            r5.setFloatValue(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextFieldScrollerPosition.update(androidx.compose.foundation.gestures.Orientation, androidx.compose.ui.geometry.Rect, int, int):void");
    }

    public TextFieldScrollerPosition() {
        this(Orientation.Vertical, 0.0f);
    }
}
