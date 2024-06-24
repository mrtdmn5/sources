package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.selection.MultiWidgetSelectionDelegate;
import androidx.compose.foundation.text.selection.Selectable;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2;
import androidx.compose.ui.input.pointer.PointerIconModifierLocal;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectionController.kt */
/* loaded from: classes.dex */
public final class SelectionController implements RememberObserver {
    public final long backgroundSelectionColor;
    public final Modifier modifier;
    public StaticTextSelectionParams params;
    public Selectable selectable;
    public final long selectableId;
    public final SelectionRegistrar selectionRegistrar;

    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.compose.foundation.text.modifiers.SelectionController$modifier$1] */
    /* JADX WARN: Type inference failed for: r6v0, types: [androidx.compose.foundation.text.modifiers.SelectionController$modifier$2] */
    /* JADX WARN: Type inference failed for: r9v1, types: [androidx.compose.foundation.text.modifiers.SelectionControllerKt$makeSelectionModifier$longPressDragObserver$1, java.lang.Object] */
    public SelectionController(final SelectionRegistrar selectionRegistrar, long j) {
        StaticTextSelectionParams staticTextSelectionParams = StaticTextSelectionParams.Empty;
        this.selectionRegistrar = selectionRegistrar;
        this.backgroundSelectionColor = j;
        this.params = staticTextSelectionParams;
        final long nextSelectableId = selectionRegistrar.nextSelectableId();
        this.selectableId = nextSelectableId;
        final ?? r2 = new Function0<LayoutCoordinates>() { // from class: androidx.compose.foundation.text.modifiers.SelectionController$modifier$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final LayoutCoordinates invoke() {
                return SelectionController.this.params.layoutCoordinates;
            }
        };
        final ?? r6 = new Function0<TextLayoutResult>() { // from class: androidx.compose.foundation.text.modifiers.SelectionController$modifier$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final TextLayoutResult invoke() {
                return SelectionController.this.params.textLayoutResult;
            }
        };
        ?? r9 = new TextDragObserver() { // from class: androidx.compose.foundation.text.modifiers.SelectionControllerKt$makeSelectionModifier$longPressDragObserver$1
            public long dragTotalDistance;
            public long lastPosition;

            {
                long j2 = Offset.Zero;
                this.lastPosition = j2;
                this.dragTotalDistance = j2;
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public final void onCancel() {
                long j2 = nextSelectableId;
                SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                if (SelectionRegistrarKt.hasSelection(selectionRegistrar2, j2)) {
                    selectionRegistrar2.notifySelectionUpdateEnd();
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public final void mo119onDragk4lQ0M(long j2) {
                LayoutCoordinates invoke = r2.invoke();
                if (invoke != null) {
                    SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                    if (!invoke.isAttached() || !SelectionRegistrarKt.hasSelection(selectionRegistrar2, nextSelectableId)) {
                        return;
                    }
                    long m262plusMKHz9U = Offset.m262plusMKHz9U(this.dragTotalDistance, j2);
                    this.dragTotalDistance = m262plusMKHz9U;
                    long m262plusMKHz9U2 = Offset.m262plusMKHz9U(this.lastPosition, m262plusMKHz9U);
                    if (!SelectionControllerKt.m129access$outOfBoundary2x9bVx0(r6.invoke(), this.lastPosition, m262plusMKHz9U2) && selectionRegistrar2.mo149notifySelectionUpdate5iVPX68(invoke, m262plusMKHz9U2, this.lastPosition, SelectionAdjustment.Companion.CharacterWithWordAccelerate)) {
                        this.lastPosition = m262plusMKHz9U2;
                        this.dragTotalDistance = Offset.Zero;
                    }
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public final void mo120onStartk4lQ0M(long j2) {
                LayoutCoordinates invoke = r2.invoke();
                long j3 = nextSelectableId;
                SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                if (invoke != null) {
                    if (!invoke.isAttached()) {
                        return;
                    }
                    if (SelectionControllerKt.m129access$outOfBoundary2x9bVx0(r6.invoke(), j2, j2)) {
                        selectionRegistrar2.notifySelectionUpdateSelectAll(j3);
                    } else {
                        selectionRegistrar2.mo150notifySelectionUpdateStartd4ec7I(invoke, j2, SelectionAdjustment.Companion.Word);
                    }
                    this.lastPosition = j2;
                }
                if (!SelectionRegistrarKt.hasSelection(selectionRegistrar2, j3)) {
                    return;
                }
                this.dragTotalDistance = Offset.Zero;
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public final void onStop() {
                long j2 = nextSelectableId;
                SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                if (SelectionRegistrarKt.hasSelection(selectionRegistrar2, j2)) {
                    selectionRegistrar2.notifySelectionUpdateEnd();
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public final void mo118onDownk4lQ0M() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public final void onUp() {
            }
        };
        Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion.$$INSTANCE, r9, new SelectionControllerKt$makeSelectionModifier$1(r9, null));
        Intrinsics.checkNotNullParameter(pointerInput, "<this>");
        ProvidableModifierLocal<PointerIconModifierLocal> providableModifierLocal = PointerIconKt.ModifierLocalPointerIcon;
        this.modifier = ComposedModifierKt.composed(pointerInput, InspectableValueKt.NoInspectorInfo, new PointerIconKt$pointerHoverIcon$2(false));
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onAbandoned() {
        Selectable selectable = this.selectable;
        if (selectable != null) {
            this.selectionRegistrar.unsubscribe(selectable);
            this.selectable = null;
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onForgotten() {
        Selectable selectable = this.selectable;
        if (selectable != null) {
            this.selectionRegistrar.unsubscribe(selectable);
            this.selectable = null;
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.compose.foundation.text.modifiers.SelectionController$onRemembered$1] */
    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.compose.foundation.text.modifiers.SelectionController$onRemembered$2] */
    @Override // androidx.compose.runtime.RememberObserver
    public final void onRemembered() {
        this.selectable = this.selectionRegistrar.subscribe(new MultiWidgetSelectionDelegate(this.selectableId, new Function0<LayoutCoordinates>() { // from class: androidx.compose.foundation.text.modifiers.SelectionController$onRemembered$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final LayoutCoordinates invoke() {
                return SelectionController.this.params.layoutCoordinates;
            }
        }, new Function0<TextLayoutResult>() { // from class: androidx.compose.foundation.text.modifiers.SelectionController$onRemembered$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final TextLayoutResult invoke() {
                return SelectionController.this.params.textLayoutResult;
            }
        }));
    }
}
