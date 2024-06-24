package androidx.compose.foundation.text.selection;

import androidx.compose.ui.layout.LayoutCoordinates;
import java.util.Map;

/* compiled from: SelectionRegistrar.kt */
/* loaded from: classes.dex */
public interface SelectionRegistrar {
    Map<Long, Selection> getSubselections();

    long nextSelectableId();

    /* renamed from: notifySelectionUpdate-5iVPX68, reason: not valid java name */
    boolean mo149notifySelectionUpdate5iVPX68(LayoutCoordinates layoutCoordinates, long j, long j2, SelectionAdjustment selectionAdjustment);

    void notifySelectionUpdateEnd();

    void notifySelectionUpdateSelectAll(long j);

    /* renamed from: notifySelectionUpdateStart-d-4ec7I, reason: not valid java name */
    void mo150notifySelectionUpdateStartd4ec7I(LayoutCoordinates layoutCoordinates, long j, SelectionAdjustment selectionAdjustment);

    Selectable subscribe(MultiWidgetSelectionDelegate multiWidgetSelectionDelegate);

    void unsubscribe(Selectable selectable);
}
