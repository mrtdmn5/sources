package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;

/* compiled from: TextLayoutResultProxy.kt */
/* loaded from: classes.dex */
public final class TextLayoutResultProxy {
    public LayoutCoordinates decorationBoxCoordinates;
    public LayoutCoordinates innerTextFieldCoordinates;
    public final TextLayoutResult value;

    public TextLayoutResultProxy(TextLayoutResult textLayoutResult) {
        this.value = textLayoutResult;
    }

    /* renamed from: coercedInVisibleBoundsOfInputText-MK-Hz9U, reason: not valid java name */
    public final long m122coercedInVisibleBoundsOfInputTextMKHz9U(long j) {
        Rect rect;
        LayoutCoordinates layoutCoordinates = this.innerTextFieldCoordinates;
        Rect rect2 = Rect.Zero;
        if (layoutCoordinates != null) {
            if (layoutCoordinates.isAttached()) {
                LayoutCoordinates layoutCoordinates2 = this.decorationBoxCoordinates;
                if (layoutCoordinates2 != null) {
                    rect = layoutCoordinates2.localBoundingBoxOf(layoutCoordinates, true);
                } else {
                    rect = null;
                }
            } else {
                rect = rect2;
            }
            if (rect != null) {
                rect2 = rect;
            }
        }
        float m259getXimpl = Offset.m259getXimpl(j);
        float f = rect2.left;
        if (m259getXimpl >= f) {
            float m259getXimpl2 = Offset.m259getXimpl(j);
            f = rect2.right;
            if (m259getXimpl2 <= f) {
                f = Offset.m259getXimpl(j);
            }
        }
        float m260getYimpl = Offset.m260getYimpl(j);
        float f2 = rect2.top;
        if (m260getYimpl >= f2) {
            float m260getYimpl2 = Offset.m260getYimpl(j);
            f2 = rect2.bottom;
            if (m260getYimpl2 <= f2) {
                f2 = Offset.m260getYimpl(j);
            }
        }
        return OffsetKt.Offset(f, f2);
    }

    /* renamed from: getOffsetForPosition-3MmeM6k, reason: not valid java name */
    public final int m123getOffsetForPosition3MmeM6k(long j, boolean z) {
        if (z) {
            j = m122coercedInVisibleBoundsOfInputTextMKHz9U(j);
        }
        return this.value.m519getOffsetForPositionk4lQ0M(m124relativeToInputTextMKHz9U(j));
    }

    /* renamed from: relativeToInputText-MK-Hz9U, reason: not valid java name */
    public final long m124relativeToInputTextMKHz9U(long j) {
        Offset offset;
        long j2;
        LayoutCoordinates layoutCoordinates = this.innerTextFieldCoordinates;
        if (layoutCoordinates != null) {
            LayoutCoordinates layoutCoordinates2 = this.decorationBoxCoordinates;
            if (layoutCoordinates2 != null) {
                if (layoutCoordinates.isAttached() && layoutCoordinates2.isAttached()) {
                    j2 = layoutCoordinates.mo424localPositionOfR5De75A(layoutCoordinates2, j);
                } else {
                    j2 = j;
                }
                offset = new Offset(j2);
            } else {
                offset = null;
            }
            if (offset != null) {
                return offset.packedValue;
            }
            return j;
        }
        return j;
    }
}
