package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import com.google.common.collect.Platform;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectionRegistrarImpl.kt */
/* loaded from: classes.dex */
public final class SelectionRegistrarImpl implements SelectionRegistrar {
    public Function1<? super Long, Unit> afterSelectableUnsubscribe;
    public Function5<? super LayoutCoordinates, ? super Offset, ? super Offset, ? super Boolean, ? super SelectionAdjustment, Boolean> onSelectionUpdateCallback;
    public Function0<Unit> onSelectionUpdateEndCallback;
    public Function1<? super Long, Unit> onSelectionUpdateSelectAll;
    public Function3<? super LayoutCoordinates, ? super Offset, ? super SelectionAdjustment, Unit> onSelectionUpdateStartCallback;
    public boolean sorted;
    public final ArrayList _selectables = new ArrayList();
    public final LinkedHashMap _selectableMap = new LinkedHashMap();
    public final AtomicLong incrementId = new AtomicLong(1);
    public final ParcelableSnapshotMutableState subselections$delegate = Platform.mutableStateOf$default(EmptyMap.INSTANCE);

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public final Map<Long, Selection> getSubselections() {
        return (Map) this.subselections$delegate.getValue();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public final long nextSelectableId() {
        AtomicLong atomicLong = this.incrementId;
        long andIncrement = atomicLong.getAndIncrement();
        while (andIncrement == 0) {
            andIncrement = atomicLong.getAndIncrement();
        }
        return andIncrement;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    /* renamed from: notifySelectionUpdate-5iVPX68 */
    public final boolean mo149notifySelectionUpdate5iVPX68(LayoutCoordinates layoutCoordinates, long j, long j2, SelectionAdjustment adjustment) {
        Intrinsics.checkNotNullParameter(adjustment, "adjustment");
        Function5<? super LayoutCoordinates, ? super Offset, ? super Offset, ? super Boolean, ? super SelectionAdjustment, Boolean> function5 = this.onSelectionUpdateCallback;
        if (function5 != null) {
            return function5.invoke(layoutCoordinates, new Offset(j), new Offset(j2), Boolean.FALSE, adjustment).booleanValue();
        }
        return true;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public final void notifySelectionUpdateEnd() {
        Function0<Unit> function0 = this.onSelectionUpdateEndCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public final void notifySelectionUpdateSelectAll(long j) {
        Function1<? super Long, Unit> function1 = this.onSelectionUpdateSelectAll;
        if (function1 != null) {
            function1.invoke(Long.valueOf(j));
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    /* renamed from: notifySelectionUpdateStart-d-4ec7I */
    public final void mo150notifySelectionUpdateStartd4ec7I(LayoutCoordinates layoutCoordinates, long j, SelectionAdjustment selectionAdjustment) {
        Function3<? super LayoutCoordinates, ? super Offset, ? super SelectionAdjustment, Unit> function3 = this.onSelectionUpdateStartCallback;
        if (function3 != null) {
            function3.invoke(layoutCoordinates, new Offset(j), selectionAdjustment);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.foundation.text.selection.SelectionRegistrarImpl$sort$1] */
    public final ArrayList sort(final LayoutCoordinates layoutCoordinates) {
        boolean z = this.sorted;
        ArrayList arrayList = this._selectables;
        if (!z) {
            final ?? r0 = new Function2<Selectable, Selectable, Integer>() { // from class: androidx.compose.foundation.text.selection.SelectionRegistrarImpl$sort$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Integer invoke(Selectable selectable, Selectable selectable2) {
                    long j;
                    long j2;
                    boolean z2;
                    int compareValues;
                    Selectable a = selectable;
                    Selectable b = selectable2;
                    Intrinsics.checkNotNullParameter(a, "a");
                    Intrinsics.checkNotNullParameter(b, "b");
                    LayoutCoordinates layoutCoordinates2 = a.getLayoutCoordinates();
                    LayoutCoordinates layoutCoordinates3 = b.getLayoutCoordinates();
                    LayoutCoordinates layoutCoordinates4 = LayoutCoordinates.this;
                    if (layoutCoordinates2 != null) {
                        j = layoutCoordinates4.mo424localPositionOfR5De75A(layoutCoordinates2, Offset.Zero);
                    } else {
                        j = Offset.Zero;
                    }
                    if (layoutCoordinates3 != null) {
                        j2 = layoutCoordinates4.mo424localPositionOfR5De75A(layoutCoordinates3, Offset.Zero);
                    } else {
                        j2 = Offset.Zero;
                    }
                    if (Offset.m260getYimpl(j) == Offset.m260getYimpl(j2)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        compareValues = BorderStrokeKt.compareValues(Float.valueOf(Offset.m259getXimpl(j)), Float.valueOf(Offset.m259getXimpl(j2)));
                    } else {
                        compareValues = BorderStrokeKt.compareValues(Float.valueOf(Offset.m260getYimpl(j)), Float.valueOf(Offset.m260getYimpl(j2)));
                    }
                    return Integer.valueOf(compareValues);
                }
            };
            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new Comparator() { // from class: androidx.compose.foundation.text.selection.SelectionRegistrarImpl$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    Function2 tmp0 = r0;
                    Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
                    return ((Number) tmp0.invoke(obj, obj2)).intValue();
                }
            });
            this.sorted = true;
        }
        return arrayList;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public final Selectable subscribe(MultiWidgetSelectionDelegate multiWidgetSelectionDelegate) {
        boolean z;
        long j = multiWidgetSelectionDelegate.selectableId;
        if (j != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            LinkedHashMap linkedHashMap = this._selectableMap;
            if (true ^ linkedHashMap.containsKey(Long.valueOf(j))) {
                linkedHashMap.put(Long.valueOf(j), multiWidgetSelectionDelegate);
                this._selectables.add(multiWidgetSelectionDelegate);
                this.sorted = false;
                return multiWidgetSelectionDelegate;
            }
            throw new IllegalArgumentException(("Another selectable with the id: " + multiWidgetSelectionDelegate + ".selectableId has already subscribed.").toString());
        }
        throw new IllegalArgumentException(("The selectable contains an invalid id: " + j).toString());
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public final void unsubscribe(Selectable selectable) {
        LinkedHashMap linkedHashMap = this._selectableMap;
        if (!linkedHashMap.containsKey(Long.valueOf(selectable.getSelectableId()))) {
            return;
        }
        this._selectables.remove(selectable);
        linkedHashMap.remove(Long.valueOf(selectable.getSelectableId()));
        Function1<? super Long, Unit> function1 = this.afterSelectableUnsubscribe;
        if (function1 != null) {
            function1.invoke(Long.valueOf(selectable.getSelectableId()));
        }
    }
}
