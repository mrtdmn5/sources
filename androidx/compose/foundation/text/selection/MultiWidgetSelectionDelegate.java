package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.modifiers.SelectionController$onRemembered$1;
import androidx.compose.foundation.text.modifiers.SelectionController$onRemembered$2;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import com.google.android.gms.internal.fitness.zzba;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: MultiWidgetSelectionDelegate.kt */
/* loaded from: classes.dex */
public final class MultiWidgetSelectionDelegate implements Selectable {
    public int _previousLastVisibleOffset = -1;
    public TextLayoutResult _previousTextLayoutResult;
    public final Function0<LayoutCoordinates> coordinatesCallback;
    public final Function0<TextLayoutResult> layoutResultCallback;
    public final long selectableId;

    public MultiWidgetSelectionDelegate(long j, SelectionController$onRemembered$1 selectionController$onRemembered$1, SelectionController$onRemembered$2 selectionController$onRemembered$2) {
        this.selectableId = j;
        this.coordinatesCallback = selectionController$onRemembered$1;
        this.layoutResultCallback = selectionController$onRemembered$2;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public final Rect getBoundingBox(int r5) {
        TextLayoutResult invoke = this.layoutResultCallback.invoke();
        Rect rect = Rect.Zero;
        if (invoke == null) {
            return rect;
        }
        int length = invoke.layoutInput.text.length();
        if (length < 1) {
            return rect;
        }
        return invoke.getBoundingBox(RangesKt___RangesKt.coerceIn(r5, 0, length - 1));
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    /* renamed from: getHandlePosition-dBAh8RU */
    public final long mo134getHandlePositiondBAh8RU(Selection selection, boolean z) {
        int r1;
        long j = this.selectableId;
        Selection.AnchorInfo anchorInfo = selection.start;
        if (!z || anchorInfo.selectableId == j) {
            Selection.AnchorInfo anchorInfo2 = selection.end;
            if (z || anchorInfo2.selectableId == j) {
                if (getLayoutCoordinates() == null) {
                    return Offset.Zero;
                }
                TextLayoutResult invoke = this.layoutResultCallback.invoke();
                if (invoke == null) {
                    return Offset.Zero;
                }
                if (z) {
                    r1 = anchorInfo.offset;
                } else {
                    r1 = anchorInfo2.offset;
                }
                int coerceIn = RangesKt___RangesKt.coerceIn(r1, 0, getLastVisibleOffset(invoke));
                return OffsetKt.Offset(zzba.getHorizontalPosition(invoke, coerceIn, z, selection.handlesCrossed), invoke.getLineBottom(invoke.getLineForOffset(coerceIn)));
            }
        }
        return Offset.Zero;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0048 A[Catch: all -> 0x005c, LOOP:0: B:19:0x0039->B:21:0x0048, LOOP_END, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000c, B:12:0x001f, B:15:0x0026, B:19:0x0039, B:21:0x0048, B:23:0x0050, B:24:0x004b, B:26:0x0058), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized int getLastVisibleOffset(androidx.compose.ui.text.TextLayoutResult r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            androidx.compose.ui.text.TextLayoutResult r0 = r5._previousTextLayoutResult     // Catch: java.lang.Throwable -> L5c
            if (r0 == r6) goto L58
            androidx.compose.ui.text.MultiParagraph r0 = r6.multiParagraph     // Catch: java.lang.Throwable -> L5c
            boolean r1 = r0.didExceedMaxLines     // Catch: java.lang.Throwable -> L5c
            r2 = 1
            if (r1 != 0) goto L1c
            long r3 = r6.size     // Catch: java.lang.Throwable -> L5c
            int r1 = androidx.compose.ui.unit.IntSize.m593getHeightimpl(r3)     // Catch: java.lang.Throwable -> L5c
            float r1 = (float) r1     // Catch: java.lang.Throwable -> L5c
            float r0 = r0.height     // Catch: java.lang.Throwable -> L5c
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 >= 0) goto L1a
            goto L1c
        L1a:
            r0 = 0
            goto L1d
        L1c:
            r0 = r2
        L1d:
            if (r0 == 0) goto L4b
            androidx.compose.ui.text.MultiParagraph r0 = r6.multiParagraph     // Catch: java.lang.Throwable -> L5c
            boolean r0 = r0.didExceedMaxLines     // Catch: java.lang.Throwable -> L5c
            if (r0 == 0) goto L26
            goto L4b
        L26:
            long r0 = r6.size     // Catch: java.lang.Throwable -> L5c
            int r0 = androidx.compose.ui.unit.IntSize.m593getHeightimpl(r0)     // Catch: java.lang.Throwable -> L5c
            float r0 = (float) r0     // Catch: java.lang.Throwable -> L5c
            int r0 = r6.getLineForVerticalPosition(r0)     // Catch: java.lang.Throwable -> L5c
            androidx.compose.ui.text.MultiParagraph r1 = r6.multiParagraph     // Catch: java.lang.Throwable -> L5c
            int r1 = r1.lineCount     // Catch: java.lang.Throwable -> L5c
            int r1 = r1 - r2
            if (r0 <= r1) goto L39
            r0 = r1
        L39:
            float r1 = r6.getLineTop(r0)     // Catch: java.lang.Throwable -> L5c
            long r3 = r6.size     // Catch: java.lang.Throwable -> L5c
            int r3 = androidx.compose.ui.unit.IntSize.m593getHeightimpl(r3)     // Catch: java.lang.Throwable -> L5c
            float r3 = (float) r3     // Catch: java.lang.Throwable -> L5c
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 < 0) goto L50
            int r0 = r0 + (-1)
            goto L39
        L4b:
            androidx.compose.ui.text.MultiParagraph r0 = r6.multiParagraph     // Catch: java.lang.Throwable -> L5c
            int r0 = r0.lineCount     // Catch: java.lang.Throwable -> L5c
            int r0 = r0 - r2
        L50:
            int r0 = r6.getLineEnd(r0, r2)     // Catch: java.lang.Throwable -> L5c
            r5._previousLastVisibleOffset = r0     // Catch: java.lang.Throwable -> L5c
            r5._previousTextLayoutResult = r6     // Catch: java.lang.Throwable -> L5c
        L58:
            int r6 = r5._previousLastVisibleOffset     // Catch: java.lang.Throwable -> L5c
            monitor-exit(r5)
            return r6
        L5c:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.MultiWidgetSelectionDelegate.getLastVisibleOffset(androidx.compose.ui.text.TextLayoutResult):int");
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public final LayoutCoordinates getLayoutCoordinates() {
        LayoutCoordinates invoke = this.coordinatesCallback.invoke();
        if (invoke != null && invoke.isAttached()) {
            return invoke;
        }
        return null;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    /* renamed from: getRangeOfLineContaining--jx7JFs */
    public final long mo135getRangeOfLineContainingjx7JFs(int r5) {
        TextLayoutResult invoke = this.layoutResultCallback.invoke();
        if (invoke == null) {
            int r52 = TextRange.$r8$clinit;
            return TextRange.Zero;
        }
        int lastVisibleOffset = getLastVisibleOffset(invoke);
        if (lastVisibleOffset < 1) {
            int r53 = TextRange.$r8$clinit;
            return TextRange.Zero;
        }
        int lineForOffset = invoke.getLineForOffset(RangesKt___RangesKt.coerceIn(r5, 0, lastVisibleOffset - 1));
        return TextRangeKt.TextRange(invoke.getLineStart(lineForOffset), invoke.getLineEnd(lineForOffset, true));
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public final Selection getSelectAllSelection() {
        TextLayoutResult invoke = this.layoutResultCallback.invoke();
        if (invoke == null) {
            return null;
        }
        return MultiWidgetSelectionDelegateKt.m137getAssembledSelectionInfovJH6DeI(TextRangeKt.TextRange(0, invoke.layoutInput.text.length()), false, this.selectableId, invoke);
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public final long getSelectableId() {
        return this.selectableId;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public final AnnotatedString getText() {
        TextLayoutResult invoke = this.layoutResultCallback.invoke();
        if (invoke == null) {
            return new AnnotatedString("", null, 6);
        }
        return invoke.layoutInput.text;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    @Override // androidx.compose.foundation.text.selection.Selectable
    /* renamed from: updateSelection-qCDeeow */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlin.Pair<androidx.compose.foundation.text.selection.Selection, java.lang.Boolean> mo136updateSelectionqCDeeow(long r24, long r26, androidx.compose.ui.geometry.Offset r28, boolean r29, androidx.compose.ui.layout.LayoutCoordinates r30, androidx.compose.foundation.text.selection.SelectionAdjustment r31, androidx.compose.foundation.text.selection.Selection r32) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.MultiWidgetSelectionDelegate.mo136updateSelectionqCDeeow(long, long, androidx.compose.ui.geometry.Offset, boolean, androidx.compose.ui.layout.LayoutCoordinates, androidx.compose.foundation.text.selection.SelectionAdjustment, androidx.compose.foundation.text.selection.Selection):kotlin.Pair");
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public final int getLastVisibleOffset() {
        TextLayoutResult invoke = this.layoutResultCallback.invoke();
        if (invoke == null) {
            return 0;
        }
        return getLastVisibleOffset(invoke);
    }
}
