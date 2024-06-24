package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import kotlin.Pair;

/* compiled from: Selectable.kt */
/* loaded from: classes.dex */
public interface Selectable {
    Rect getBoundingBox(int r1);

    /* renamed from: getHandlePosition-dBAh8RU */
    long mo134getHandlePositiondBAh8RU(Selection selection, boolean z);

    int getLastVisibleOffset();

    LayoutCoordinates getLayoutCoordinates();

    /* renamed from: getRangeOfLineContaining--jx7JFs */
    long mo135getRangeOfLineContainingjx7JFs(int r1);

    Selection getSelectAllSelection();

    long getSelectableId();

    AnnotatedString getText();

    /* renamed from: updateSelection-qCDeeow */
    Pair<Selection, Boolean> mo136updateSelectionqCDeeow(long j, long j2, Offset offset, boolean z, LayoutCoordinates layoutCoordinates, SelectionAdjustment selectionAdjustment, Selection selection);
}
