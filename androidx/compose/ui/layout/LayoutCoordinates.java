package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Rect;

/* compiled from: LayoutCoordinates.kt */
/* loaded from: classes.dex */
public interface LayoutCoordinates {
    LayoutCoordinates getParentLayoutCoordinates();

    /* renamed from: getSize-YbymL2g, reason: not valid java name */
    long mo423getSizeYbymL2g();

    boolean isAttached();

    Rect localBoundingBoxOf(LayoutCoordinates layoutCoordinates, boolean z);

    /* renamed from: localPositionOf-R5De75A, reason: not valid java name */
    long mo424localPositionOfR5De75A(LayoutCoordinates layoutCoordinates, long j);

    /* renamed from: localToRoot-MK-Hz9U, reason: not valid java name */
    long mo425localToRootMKHz9U(long j);

    /* renamed from: localToWindow-MK-Hz9U, reason: not valid java name */
    long mo426localToWindowMKHz9U(long j);

    /* renamed from: windowToLocal-MK-Hz9U, reason: not valid java name */
    long mo427windowToLocalMKHz9U(long j);
}
