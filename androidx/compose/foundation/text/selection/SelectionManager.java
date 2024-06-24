package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import com.google.common.collect.Platform;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectionManager.kt */
/* loaded from: classes.dex */
public final class SelectionManager {
    public final ParcelableSnapshotMutableState _selection;
    public ClipboardManager clipboardManager;
    public LayoutCoordinates containerLayoutCoordinates;
    public final ParcelableSnapshotMutableState currentDragPosition$delegate;
    public final ParcelableSnapshotMutableState dragBeginPosition$delegate;
    public final ParcelableSnapshotMutableState dragTotalDistance$delegate;
    public final ParcelableSnapshotMutableState draggingHandle$delegate;
    public final ParcelableSnapshotMutableState endHandlePosition$delegate;
    public final FocusRequester focusRequester;
    public HapticFeedback hapticFeedBack;
    public final ParcelableSnapshotMutableState hasFocus$delegate;
    public Function1<? super Selection, Unit> onSelectionChange;
    public Offset previousPosition;
    public final SelectionRegistrarImpl selectionRegistrar;
    public final ParcelableSnapshotMutableState startHandlePosition$delegate;
    public TextToolbar textToolbar;

    public SelectionManager(SelectionRegistrarImpl selectionRegistrar) {
        Intrinsics.checkNotNullParameter(selectionRegistrar, "selectionRegistrar");
        this.selectionRegistrar = selectionRegistrar;
        this._selection = Platform.mutableStateOf$default(null);
        this.onSelectionChange = new Function1<Selection, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$onSelectionChange$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Selection selection) {
                return Unit.INSTANCE;
            }
        };
        this.focusRequester = new FocusRequester();
        this.hasFocus$delegate = Platform.mutableStateOf$default(Boolean.FALSE);
        long j = Offset.Zero;
        this.dragBeginPosition$delegate = Platform.mutableStateOf$default(new Offset(j));
        this.dragTotalDistance$delegate = Platform.mutableStateOf$default(new Offset(j));
        this.startHandlePosition$delegate = Platform.mutableStateOf$default(null);
        this.endHandlePosition$delegate = Platform.mutableStateOf$default(null);
        this.draggingHandle$delegate = Platform.mutableStateOf$default(null);
        this.currentDragPosition$delegate = Platform.mutableStateOf$default(null);
        new Function1<Long, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.1
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:            if (r3 != false) goto L20;     */
            @Override // kotlin.jvm.functions.Function1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final kotlin.Unit invoke(java.lang.Long r8) {
                /*
                    r7 = this;
                    java.lang.Number r8 = (java.lang.Number) r8
                    long r0 = r8.longValue()
                    androidx.compose.foundation.text.selection.SelectionManager r8 = androidx.compose.foundation.text.selection.SelectionManager.this
                    androidx.compose.foundation.text.selection.Selection r2 = r8.getSelection()
                    r3 = 1
                    r4 = 0
                    if (r2 == 0) goto L1c
                    androidx.compose.foundation.text.selection.Selection$AnchorInfo r2 = r2.start
                    if (r2 == 0) goto L1c
                    long r5 = r2.selectableId
                    int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                    if (r2 != 0) goto L1c
                    r2 = r3
                    goto L1d
                L1c:
                    r2 = r4
                L1d:
                    if (r2 != 0) goto L33
                    androidx.compose.foundation.text.selection.Selection r2 = r8.getSelection()
                    if (r2 == 0) goto L30
                    androidx.compose.foundation.text.selection.Selection$AnchorInfo r2 = r2.end
                    if (r2 == 0) goto L30
                    long r5 = r2.selectableId
                    int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                    if (r0 != 0) goto L30
                    goto L31
                L30:
                    r3 = r4
                L31:
                    if (r3 == 0) goto L4d
                L33:
                    r8.updateHandleOffsets()
                    boolean r0 = r8.getHasFocus()
                    if (r0 == 0) goto L4d
                    androidx.compose.ui.platform.TextToolbar r0 = r8.textToolbar
                    if (r0 == 0) goto L45
                    androidx.compose.ui.platform.TextToolbarStatus r0 = r0.getStatus()
                    goto L46
                L45:
                    r0 = 0
                L46:
                    androidx.compose.ui.platform.TextToolbarStatus r1 = androidx.compose.ui.platform.TextToolbarStatus.Shown
                    if (r0 != r1) goto L4d
                    r8.showSelectionToolbar$foundation_release()
                L4d:
                    kotlin.Unit r8 = kotlin.Unit.INSTANCE
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionManager.AnonymousClass1.invoke(java.lang.Object):java.lang.Object");
            }
        };
        selectionRegistrar.onSelectionUpdateStartCallback = new Function3<LayoutCoordinates, Offset, SelectionAdjustment, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.2
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(LayoutCoordinates layoutCoordinates, Offset offset, SelectionAdjustment selectionAdjustment) {
                LayoutCoordinates layoutCoordinates2 = layoutCoordinates;
                long j2 = offset.packedValue;
                SelectionAdjustment selectionMode = selectionAdjustment;
                Intrinsics.checkNotNullParameter(layoutCoordinates2, "layoutCoordinates");
                Intrinsics.checkNotNullParameter(selectionMode, "selectionMode");
                SelectionManager selectionManager = SelectionManager.this;
                Offset m142convertToContainerCoordinatesQ7Q5hAU = selectionManager.m142convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates2, j2);
                if (m142convertToContainerCoordinatesQ7Q5hAU != null) {
                    SelectionManager selectionManager2 = SelectionManager.this;
                    long j3 = m142convertToContainerCoordinatesQ7Q5hAU.packedValue;
                    selectionManager2.m144updateSelection3R_tFg$foundation_release(j3, j3, null, false, selectionMode);
                    selectionManager.focusRequester.focus$ui_release();
                    selectionManager.hideSelectionToolbar$foundation_release();
                }
                return Unit.INSTANCE;
            }
        };
        selectionRegistrar.onSelectionUpdateSelectAll = new Function1<Long, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Long l) {
                HapticFeedback hapticFeedback;
                Selection selection;
                long longValue = l.longValue();
                SelectionManager selectionManager = SelectionManager.this;
                Selection selection2 = selectionManager.getSelection();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                LayoutCoordinates requireContainerCoordinates$foundation_release = selectionManager.requireContainerCoordinates$foundation_release();
                SelectionRegistrarImpl selectionRegistrarImpl = selectionManager.selectionRegistrar;
                ArrayList sort = selectionRegistrarImpl.sort(requireContainerCoordinates$foundation_release);
                int size = sort.size();
                Selection selection3 = null;
                for (int r8 = 0; r8 < size; r8++) {
                    Selectable selectable = (Selectable) sort.get(r8);
                    if (selectable.getSelectableId() == longValue) {
                        selection = selectable.getSelectAllSelection();
                    } else {
                        selection = null;
                    }
                    if (selection != null) {
                        linkedHashMap.put(Long.valueOf(selectable.getSelectableId()), selection);
                    }
                    selection3 = SelectionManagerKt.merge(selection3, selection);
                }
                if (!Intrinsics.areEqual(selection3, selection2) && (hapticFeedback = selectionManager.hapticFeedBack) != null) {
                    hapticFeedback.mo396performHapticFeedbackCdsT49E();
                }
                if (!Intrinsics.areEqual(selection3, selectionManager.getSelection())) {
                    selectionRegistrarImpl.subselections$delegate.setValue(linkedHashMap);
                    selectionManager.onSelectionChange.invoke(selection3);
                }
                selectionManager.focusRequester.focus$ui_release();
                selectionManager.hideSelectionToolbar$foundation_release();
                return Unit.INSTANCE;
            }
        };
        selectionRegistrar.onSelectionUpdateCallback = new Function5<LayoutCoordinates, Offset, Offset, Boolean, SelectionAdjustment, Boolean>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.4
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public final Boolean invoke(LayoutCoordinates layoutCoordinates, Offset offset, Offset offset2, Boolean bool, SelectionAdjustment selectionAdjustment) {
                LayoutCoordinates layoutCoordinates2 = layoutCoordinates;
                long j2 = offset.packedValue;
                long j3 = offset2.packedValue;
                boolean booleanValue = bool.booleanValue();
                SelectionAdjustment selectionMode = selectionAdjustment;
                Intrinsics.checkNotNullParameter(layoutCoordinates2, "layoutCoordinates");
                Intrinsics.checkNotNullParameter(selectionMode, "selectionMode");
                SelectionManager selectionManager = SelectionManager.this;
                return Boolean.valueOf(selectionManager.m145updateSelectionRHHTvR4$foundation_release(selectionManager.m142convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates2, j2), selectionManager.m142convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates2, j3), booleanValue, selectionMode));
            }
        };
        selectionRegistrar.onSelectionUpdateEndCallback = new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.5
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                SelectionManager selectionManager = SelectionManager.this;
                selectionManager.showSelectionToolbar$foundation_release();
                selectionManager.setDraggingHandle(null);
                selectionManager.m143setCurrentDragPosition_kEHs6E(null);
                return Unit.INSTANCE;
            }
        };
        new Function1<Long, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Long l) {
                Long valueOf = Long.valueOf(l.longValue());
                SelectionManager selectionManager = SelectionManager.this;
                if (selectionManager.selectionRegistrar.getSubselections().containsKey(valueOf)) {
                    selectionManager.onRelease();
                    selectionManager._selection.setValue(null);
                }
                return Unit.INSTANCE;
            }
        };
        selectionRegistrar.afterSelectableUnsubscribe = new Function1<Long, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.7
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:            if (r3 != false) goto L20;     */
            @Override // kotlin.jvm.functions.Function1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final kotlin.Unit invoke(java.lang.Long r8) {
                /*
                    r7 = this;
                    java.lang.Number r8 = (java.lang.Number) r8
                    long r0 = r8.longValue()
                    androidx.compose.foundation.text.selection.SelectionManager r8 = androidx.compose.foundation.text.selection.SelectionManager.this
                    androidx.compose.foundation.text.selection.Selection r2 = r8.getSelection()
                    r3 = 1
                    r4 = 0
                    if (r2 == 0) goto L1c
                    androidx.compose.foundation.text.selection.Selection$AnchorInfo r2 = r2.start
                    if (r2 == 0) goto L1c
                    long r5 = r2.selectableId
                    int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                    if (r2 != 0) goto L1c
                    r2 = r3
                    goto L1d
                L1c:
                    r2 = r4
                L1d:
                    if (r2 != 0) goto L33
                    androidx.compose.foundation.text.selection.Selection r2 = r8.getSelection()
                    if (r2 == 0) goto L30
                    androidx.compose.foundation.text.selection.Selection$AnchorInfo r2 = r2.end
                    if (r2 == 0) goto L30
                    long r5 = r2.selectableId
                    int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                    if (r0 != 0) goto L30
                    goto L31
                L30:
                    r3 = r4
                L31:
                    if (r3 == 0) goto L3e
                L33:
                    androidx.compose.runtime.ParcelableSnapshotMutableState r0 = r8.startHandlePosition$delegate
                    r1 = 0
                    r0.setValue(r1)
                    androidx.compose.runtime.ParcelableSnapshotMutableState r8 = r8.endHandlePosition$delegate
                    r8.setValue(r1)
                L3e:
                    kotlin.Unit r8 = kotlin.Unit.INSTANCE
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionManager.AnonymousClass7.invoke(java.lang.Object):java.lang.Object");
            }
        };
    }

    /* renamed from: convertToContainerCoordinates-Q7Q5hAU, reason: not valid java name */
    public final Offset m142convertToContainerCoordinatesQ7Q5hAU(LayoutCoordinates layoutCoordinates, long j) {
        LayoutCoordinates layoutCoordinates2 = this.containerLayoutCoordinates;
        if (layoutCoordinates2 != null && layoutCoordinates2.isAttached()) {
            return new Offset(requireContainerCoordinates$foundation_release().mo424localPositionOfR5De75A(layoutCoordinates, j));
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d5 A[EDGE_INSN: B:24:0x00d5->B:52:0x00d5 BREAK  A[LOOP:0: B:4:0x0018->B:12:0x00d1], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ce A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d1 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void copy$foundation_release() {
        /*
            r18 = this;
            r0 = r18
            androidx.compose.ui.layout.LayoutCoordinates r1 = r18.requireContainerCoordinates$foundation_release()
            androidx.compose.foundation.text.selection.SelectionRegistrarImpl r2 = r0.selectionRegistrar
            java.util.ArrayList r1 = r2.sort(r1)
            androidx.compose.foundation.text.selection.Selection r2 = r18.getSelection()
            r3 = 0
            if (r2 == 0) goto Ld5
            int r4 = r1.size()
            r6 = 0
        L18:
            if (r6 >= r4) goto Ld5
            java.lang.Object r7 = r1.get(r6)
            androidx.compose.foundation.text.selection.Selectable r7 = (androidx.compose.foundation.text.selection.Selectable) r7
            long r8 = r7.getSelectableId()
            androidx.compose.foundation.text.selection.Selection$AnchorInfo r10 = r2.start
            long r11 = r10.selectableId
            int r8 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            androidx.compose.foundation.text.selection.Selection$AnchorInfo r9 = r2.end
            if (r8 == 0) goto L3f
            long r11 = r7.getSelectableId()
            long r13 = r9.selectableId
            int r8 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r8 == 0) goto L3f
            if (r3 != 0) goto L3f
            r17 = r6
            r10 = 0
            goto Ld1
        L3f:
            androidx.compose.ui.text.AnnotatedString r8 = r7.getText()
            long r11 = r7.getSelectableId()
            long r13 = r10.selectableId
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            boolean r12 = r2.handlesCrossed
            if (r11 == 0) goto L5d
            long r15 = r7.getSelectableId()
            r17 = r6
            long r5 = r9.selectableId
            int r5 = (r15 > r5 ? 1 : (r15 == r5 ? 0 : -1))
            if (r5 == 0) goto L5f
            r5 = r12
            goto L81
        L5d:
            r17 = r6
        L5f:
            long r5 = r7.getSelectableId()
            int r5 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            int r6 = r10.offset
            if (r5 != 0) goto L83
            long r15 = r7.getSelectableId()
            r5 = r12
            long r11 = r9.selectableId
            int r11 = (r15 > r11 ? 1 : (r15 == r11 ? 0 : -1))
            if (r11 != 0) goto L84
            int r11 = r9.offset
            if (r5 == 0) goto L7d
            androidx.compose.ui.text.AnnotatedString r8 = r8.subSequence(r11, r6)
            goto L81
        L7d:
            androidx.compose.ui.text.AnnotatedString r8 = r8.subSequence(r6, r11)
        L81:
            r10 = 0
            goto Lb2
        L83:
            r5 = r12
        L84:
            long r11 = r7.getSelectableId()
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 != 0) goto L9e
            if (r5 == 0) goto L94
            r10 = 0
            androidx.compose.ui.text.AnnotatedString r8 = r8.subSequence(r10, r6)
            goto Lb2
        L94:
            r10 = 0
            int r11 = r8.length()
            androidx.compose.ui.text.AnnotatedString r8 = r8.subSequence(r6, r11)
            goto Lb2
        L9e:
            r10 = 0
            if (r5 == 0) goto Lac
            int r6 = r9.offset
            int r11 = r8.length()
            androidx.compose.ui.text.AnnotatedString r8 = r8.subSequence(r6, r11)
            goto Lb2
        Lac:
            int r6 = r9.offset
            androidx.compose.ui.text.AnnotatedString r8 = r8.subSequence(r10, r6)
        Lb2:
            if (r3 == 0) goto Lb9
            androidx.compose.ui.text.AnnotatedString r3 = r3.plus(r8)
            goto Lba
        Lb9:
            r3 = r8
        Lba:
            long r11 = r7.getSelectableId()
            long r8 = r9.selectableId
            int r6 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r6 != 0) goto Lc6
            if (r5 == 0) goto Ld5
        Lc6:
            long r6 = r7.getSelectableId()
            int r6 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r6 != 0) goto Ld1
            if (r5 == 0) goto Ld1
            goto Ld5
        Ld1:
            int r6 = r17 + 1
            goto L18
        Ld5:
            if (r3 == 0) goto Lde
            androidx.compose.ui.platform.ClipboardManager r1 = r0.clipboardManager
            if (r1 == 0) goto Lde
            r1.setText(r3)
        Lde:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionManager.copy$foundation_release():void");
    }

    public final Selectable getAnchorSelectable$foundation_release(Selection.AnchorInfo anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return (Selectable) this.selectionRegistrar._selectableMap.get(Long.valueOf(anchor.selectableId));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getHasFocus() {
        return ((Boolean) this.hasFocus$delegate.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Selection getSelection() {
        return (Selection) this._selection.getValue();
    }

    public final void hideSelectionToolbar$foundation_release() {
        TextToolbarStatus textToolbarStatus;
        TextToolbar textToolbar;
        if (getHasFocus()) {
            TextToolbar textToolbar2 = this.textToolbar;
            if (textToolbar2 != null) {
                textToolbarStatus = textToolbar2.getStatus();
            } else {
                textToolbarStatus = null;
            }
            if (textToolbarStatus == TextToolbarStatus.Shown && (textToolbar = this.textToolbar) != null) {
                textToolbar.hide();
            }
        }
    }

    public final void onRelease() {
        this.selectionRegistrar.subselections$delegate.setValue(EmptyMap.INSTANCE);
        hideSelectionToolbar$foundation_release();
        if (getSelection() != null) {
            this.onSelectionChange.invoke(null);
            HapticFeedback hapticFeedback = this.hapticFeedBack;
            if (hapticFeedback != null) {
                hapticFeedback.mo396performHapticFeedbackCdsT49E();
            }
        }
    }

    public final LayoutCoordinates requireContainerCoordinates$foundation_release() {
        boolean z;
        LayoutCoordinates layoutCoordinates = this.containerLayoutCoordinates;
        if (layoutCoordinates != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (layoutCoordinates.isAttached()) {
                return layoutCoordinates;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* renamed from: setCurrentDragPosition-_kEHs6E, reason: not valid java name */
    public final void m143setCurrentDragPosition_kEHs6E(Offset offset) {
        this.currentDragPosition$delegate.setValue(offset);
    }

    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle$delegate.setValue(handle);
    }

    public final void showSelectionToolbar$foundation_release() {
        TextToolbar textToolbar;
        LayoutCoordinates layoutCoordinates;
        LayoutCoordinates layoutCoordinates2;
        LayoutCoordinates layoutCoordinates3;
        if (getHasFocus() && getSelection() != null && (textToolbar = this.textToolbar) != null) {
            Selection selection = getSelection();
            Rect rect = Rect.Zero;
            if (selection != null) {
                Selection.AnchorInfo anchorInfo = selection.start;
                Selectable anchorSelectable$foundation_release = getAnchorSelectable$foundation_release(anchorInfo);
                Selection.AnchorInfo anchorInfo2 = selection.end;
                Selectable anchorSelectable$foundation_release2 = getAnchorSelectable$foundation_release(anchorInfo2);
                if (anchorSelectable$foundation_release != null && (layoutCoordinates = anchorSelectable$foundation_release.getLayoutCoordinates()) != null && anchorSelectable$foundation_release2 != null && (layoutCoordinates2 = anchorSelectable$foundation_release2.getLayoutCoordinates()) != null && (layoutCoordinates3 = this.containerLayoutCoordinates) != null && layoutCoordinates3.isAttached()) {
                    long mo424localPositionOfR5De75A = layoutCoordinates3.mo424localPositionOfR5De75A(layoutCoordinates, anchorSelectable$foundation_release.mo134getHandlePositiondBAh8RU(selection, true));
                    long mo424localPositionOfR5De75A2 = layoutCoordinates3.mo424localPositionOfR5De75A(layoutCoordinates2, anchorSelectable$foundation_release2.mo134getHandlePositiondBAh8RU(selection, false));
                    long mo425localToRootMKHz9U = layoutCoordinates3.mo425localToRootMKHz9U(mo424localPositionOfR5De75A);
                    long mo425localToRootMKHz9U2 = layoutCoordinates3.mo425localToRootMKHz9U(mo424localPositionOfR5De75A2);
                    rect = new Rect(Math.min(Offset.m259getXimpl(mo425localToRootMKHz9U), Offset.m259getXimpl(mo425localToRootMKHz9U2)), Math.min(Offset.m260getYimpl(layoutCoordinates3.mo425localToRootMKHz9U(layoutCoordinates3.mo424localPositionOfR5De75A(layoutCoordinates, OffsetKt.Offset(0.0f, anchorSelectable$foundation_release.getBoundingBox(anchorInfo.offset).top)))), Offset.m260getYimpl(layoutCoordinates3.mo425localToRootMKHz9U(layoutCoordinates3.mo424localPositionOfR5De75A(layoutCoordinates2, OffsetKt.Offset(0.0f, anchorSelectable$foundation_release2.getBoundingBox(anchorInfo2.offset).top))))), Math.max(Offset.m259getXimpl(mo425localToRootMKHz9U), Offset.m259getXimpl(mo425localToRootMKHz9U2)), Math.max(Offset.m260getYimpl(mo425localToRootMKHz9U), Offset.m260getYimpl(mo425localToRootMKHz9U2)) + ((float) (SelectionHandlesKt.HandleHeight * 4.0d)));
                }
            }
            textToolbar.showMenu(rect, new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$showSelectionToolbar$1$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    SelectionManager selectionManager = SelectionManager.this;
                    selectionManager.copy$foundation_release();
                    selectionManager.onRelease();
                    return Unit.INSTANCE;
                }
            }, null, null, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateHandleOffsets() {
        Selectable selectable;
        Selectable selectable2;
        LayoutCoordinates layoutCoordinates;
        LayoutCoordinates layoutCoordinates2;
        boolean z;
        Selection.AnchorInfo anchorInfo;
        Selection.AnchorInfo anchorInfo2;
        Selection selection = getSelection();
        LayoutCoordinates layoutCoordinates3 = this.containerLayoutCoordinates;
        Offset offset = null;
        if (selection != null && (anchorInfo2 = selection.start) != null) {
            selectable = getAnchorSelectable$foundation_release(anchorInfo2);
        } else {
            selectable = null;
        }
        if (selection != null && (anchorInfo = selection.end) != null) {
            selectable2 = getAnchorSelectable$foundation_release(anchorInfo);
        } else {
            selectable2 = null;
        }
        if (selectable != null) {
            layoutCoordinates = selectable.getLayoutCoordinates();
        } else {
            layoutCoordinates = null;
        }
        if (selectable2 != null) {
            layoutCoordinates2 = selectable2.getLayoutCoordinates();
        } else {
            layoutCoordinates2 = null;
        }
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.endHandlePosition$delegate;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState2 = this.startHandlePosition$delegate;
        if (selection != null && layoutCoordinates3 != null && layoutCoordinates3.isAttached() && layoutCoordinates != null && layoutCoordinates2 != null) {
            boolean z2 = true;
            long mo424localPositionOfR5De75A = layoutCoordinates3.mo424localPositionOfR5De75A(layoutCoordinates, selectable.mo134getHandlePositiondBAh8RU(selection, true));
            long mo424localPositionOfR5De75A2 = layoutCoordinates3.mo424localPositionOfR5De75A(layoutCoordinates2, selectable2.mo134getHandlePositiondBAh8RU(selection, false));
            Rect visibleBounds = SelectionManagerKt.visibleBounds(layoutCoordinates3);
            Offset offset2 = new Offset(mo424localPositionOfR5De75A);
            boolean m146containsInclusiveUv8p0NA = SelectionManagerKt.m146containsInclusiveUv8p0NA(mo424localPositionOfR5De75A, visibleBounds);
            ParcelableSnapshotMutableState parcelableSnapshotMutableState3 = this.draggingHandle$delegate;
            if (!m146containsInclusiveUv8p0NA && ((Handle) parcelableSnapshotMutableState3.getValue()) != Handle.SelectionStart) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                offset2 = null;
            }
            parcelableSnapshotMutableState2.setValue(offset2);
            Offset offset3 = new Offset(mo424localPositionOfR5De75A2);
            if (!SelectionManagerKt.m146containsInclusiveUv8p0NA(mo424localPositionOfR5De75A2, visibleBounds) && ((Handle) parcelableSnapshotMutableState3.getValue()) != Handle.SelectionEnd) {
                z2 = false;
            }
            if (z2) {
                offset = offset3;
            }
            parcelableSnapshotMutableState.setValue(offset);
            return;
        }
        parcelableSnapshotMutableState2.setValue(null);
        parcelableSnapshotMutableState.setValue(null);
    }

    /* renamed from: updateSelection-3R_-tFg$foundation_release, reason: not valid java name */
    public final boolean m144updateSelection3R_tFg$foundation_release(long j, long j2, Offset offset, boolean z, SelectionAdjustment adjustment) {
        Handle handle;
        Offset offset2;
        Intrinsics.checkNotNullParameter(adjustment, "adjustment");
        if (z) {
            handle = Handle.SelectionStart;
        } else {
            handle = Handle.SelectionEnd;
        }
        setDraggingHandle(handle);
        if (z) {
            offset2 = new Offset(j);
        } else {
            offset2 = new Offset(j2);
        }
        m143setCurrentDragPosition_kEHs6E(offset2);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LayoutCoordinates requireContainerCoordinates$foundation_release = requireContainerCoordinates$foundation_release();
        SelectionRegistrarImpl selectionRegistrarImpl = this.selectionRegistrar;
        ArrayList sort = selectionRegistrarImpl.sort(requireContainerCoordinates$foundation_release);
        int size = sort.size();
        Selection selection = null;
        int r4 = 0;
        boolean z2 = false;
        while (r4 < size) {
            Selectable selectable = (Selectable) sort.get(r4);
            int r21 = r4;
            Selection selection2 = selection;
            int r22 = size;
            ArrayList arrayList = sort;
            SelectionRegistrarImpl selectionRegistrarImpl2 = selectionRegistrarImpl;
            LinkedHashMap linkedHashMap2 = linkedHashMap;
            Pair<Selection, Boolean> mo136updateSelectionqCDeeow = selectable.mo136updateSelectionqCDeeow(j, j2, offset, z, requireContainerCoordinates$foundation_release(), adjustment, selectionRegistrarImpl.getSubselections().get(Long.valueOf(selectable.getSelectableId())));
            Selection selection3 = mo136updateSelectionqCDeeow.first;
            boolean booleanValue = mo136updateSelectionqCDeeow.second.booleanValue();
            if (!z2 && !booleanValue) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (selection3 != null) {
                linkedHashMap2.put(Long.valueOf(selectable.getSelectableId()), selection3);
            }
            selection = SelectionManagerKt.merge(selection2, selection3);
            r4 = r21 + 1;
            selectionRegistrarImpl = selectionRegistrarImpl2;
            linkedHashMap = linkedHashMap2;
            size = r22;
            sort = arrayList;
        }
        Selection selection4 = selection;
        SelectionRegistrarImpl selectionRegistrarImpl3 = selectionRegistrarImpl;
        LinkedHashMap linkedHashMap3 = linkedHashMap;
        if (!Intrinsics.areEqual(selection4, getSelection())) {
            HapticFeedback hapticFeedback = this.hapticFeedBack;
            if (hapticFeedback != null) {
                hapticFeedback.mo396performHapticFeedbackCdsT49E();
            }
            selectionRegistrarImpl3.subselections$delegate.setValue(linkedHashMap3);
            this.onSelectionChange.invoke(selection4);
        }
        return z2;
    }

    /* renamed from: updateSelection-RHHTvR4$foundation_release, reason: not valid java name */
    public final boolean m145updateSelectionRHHTvR4$foundation_release(Offset offset, Offset offset2, boolean z, SelectionAdjustment adjustment) {
        Selection selection;
        long j;
        Offset m142convertToContainerCoordinatesQ7Q5hAU;
        long j2;
        long j3;
        Intrinsics.checkNotNullParameter(adjustment, "adjustment");
        if (offset != null && (selection = getSelection()) != null) {
            if (z) {
                j = selection.end.selectableId;
            } else {
                j = selection.start.selectableId;
            }
            Selectable selectable = (Selectable) this.selectionRegistrar._selectableMap.get(Long.valueOf(j));
            if (selectable == null) {
                m142convertToContainerCoordinatesQ7Q5hAU = null;
            } else {
                LayoutCoordinates layoutCoordinates = selectable.getLayoutCoordinates();
                Intrinsics.checkNotNull(layoutCoordinates);
                m142convertToContainerCoordinatesQ7Q5hAU = m142convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, SelectionHandlesKt.m141getAdjustedCoordinatesk4lQ0M(selectable.mo134getHandlePositiondBAh8RU(selection, !z)));
            }
            if (m142convertToContainerCoordinatesQ7Q5hAU != null) {
                long j4 = offset.packedValue;
                long j5 = m142convertToContainerCoordinatesQ7Q5hAU.packedValue;
                if (z) {
                    j2 = j4;
                } else {
                    j2 = j5;
                }
                if (z) {
                    j3 = j5;
                } else {
                    j3 = j4;
                }
                return m144updateSelection3R_tFg$foundation_release(j2, j3, offset2, z, adjustment);
            }
        }
        return false;
    }
}
