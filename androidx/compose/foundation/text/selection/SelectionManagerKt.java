package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.text.TextRange;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: SelectionManager.kt */
/* loaded from: classes.dex */
public final class SelectionManagerKt {

    /* compiled from: SelectionManager.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[Handle.values().length];
            try {
                r0[Handle.SelectionStart.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[Handle.SelectionEnd.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[Handle.Cursor.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final long calculateSelectionMagnifierCenterAndroid_O0kMr_c$getMagnifierCenter(SelectionManager selectionManager, long j, Selection.AnchorInfo anchorInfo, boolean z) {
        Selectable anchorSelectable$foundation_release = selectionManager.getAnchorSelectable$foundation_release(anchorInfo);
        if (anchorSelectable$foundation_release == null) {
            return Offset.Unspecified;
        }
        LayoutCoordinates layoutCoordinates = selectionManager.containerLayoutCoordinates;
        if (layoutCoordinates == null) {
            return Offset.Unspecified;
        }
        LayoutCoordinates layoutCoordinates2 = anchorSelectable$foundation_release.getLayoutCoordinates();
        if (layoutCoordinates2 == null) {
            return Offset.Unspecified;
        }
        int r9 = anchorInfo.offset;
        if (!z) {
            r9--;
        }
        if (r9 > anchorSelectable$foundation_release.getLastVisibleOffset()) {
            return Offset.Unspecified;
        }
        Offset offset = (Offset) selectionManager.currentDragPosition$delegate.getValue();
        Intrinsics.checkNotNull(offset);
        float m259getXimpl = Offset.m259getXimpl(layoutCoordinates2.mo424localPositionOfR5De75A(layoutCoordinates, offset.packedValue));
        long mo135getRangeOfLineContainingjx7JFs = anchorSelectable$foundation_release.mo135getRangeOfLineContainingjx7JFs(r9);
        Rect boundingBox = anchorSelectable$foundation_release.getBoundingBox(TextRange.m525getMinimpl(mo135getRangeOfLineContainingjx7JFs));
        int m524getMaximpl = TextRange.m524getMaximpl(mo135getRangeOfLineContainingjx7JFs) - 1;
        int m525getMinimpl = TextRange.m525getMinimpl(mo135getRangeOfLineContainingjx7JFs);
        if (m524getMaximpl < m525getMinimpl) {
            m524getMaximpl = m525getMinimpl;
        }
        Rect boundingBox2 = anchorSelectable$foundation_release.getBoundingBox(m524getMaximpl);
        float coerceIn = RangesKt___RangesKt.coerceIn(m259getXimpl, Math.min(boundingBox.left, boundingBox2.left), Math.max(boundingBox.right, boundingBox2.right));
        if (Math.abs(m259getXimpl - coerceIn) > ((int) (j >> 32)) / 2) {
            return Offset.Unspecified;
        }
        return layoutCoordinates.mo424localPositionOfR5De75A(layoutCoordinates2, OffsetKt.Offset(coerceIn, Offset.m260getYimpl(anchorSelectable$foundation_release.getBoundingBox(r9).m269getCenterF1C5BW0())));
    }

    /* renamed from: containsInclusive-Uv8p0NA, reason: not valid java name */
    public static final boolean m146containsInclusiveUv8p0NA(long j, Rect rect) {
        boolean z;
        boolean z2;
        float m259getXimpl = Offset.m259getXimpl(j);
        if (rect.left <= m259getXimpl && m259getXimpl <= rect.right) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            float m260getYimpl = Offset.m260getYimpl(j);
            if (rect.top <= m260getYimpl && m260getYimpl <= rect.bottom) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public static final Selection merge(Selection selection, Selection selection2) {
        if (selection != null) {
            if (selection2 != null) {
                if (selection.handlesCrossed) {
                    selection = Selection.copy$default(selection, selection2.start, null, 6);
                } else {
                    selection = Selection.copy$default(selection, null, selection2.end, 5);
                }
            }
            return selection;
        }
        return selection2;
    }

    public static final Rect visibleBounds(LayoutCoordinates layoutCoordinates) {
        Rect boundsInWindow = LayoutCoordinatesKt.boundsInWindow(layoutCoordinates);
        long mo427windowToLocalMKHz9U = layoutCoordinates.mo427windowToLocalMKHz9U(OffsetKt.Offset(boundsInWindow.left, boundsInWindow.top));
        long mo427windowToLocalMKHz9U2 = layoutCoordinates.mo427windowToLocalMKHz9U(OffsetKt.Offset(boundsInWindow.right, boundsInWindow.bottom));
        return new Rect(Offset.m259getXimpl(mo427windowToLocalMKHz9U), Offset.m260getYimpl(mo427windowToLocalMKHz9U), Offset.m259getXimpl(mo427windowToLocalMKHz9U2), Offset.m260getYimpl(mo427windowToLocalMKHz9U2));
    }
}
