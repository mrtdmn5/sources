package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.UndoManager;
import androidx.compose.foundation.text.ValidatingOffsetMappingKt;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import com.google.android.gms.internal.fitness.zzba;
import com.google.common.collect.Platform;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.helpers.NormalizedParameters;

/* compiled from: TextFieldSelectionManager.kt */
/* loaded from: classes.dex */
public final class TextFieldSelectionManager {
    public ClipboardManager clipboardManager;
    public final ParcelableSnapshotMutableState currentDragPosition$delegate;
    public Integer dragBeginOffsetInText;
    public long dragBeginPosition;
    public long dragTotalDistance;
    public final ParcelableSnapshotMutableState draggingHandle$delegate;
    public final ParcelableSnapshotMutableState editable$delegate;
    public FocusRequester focusRequester;
    public HapticFeedback hapticFeedBack;
    public OffsetMapping offsetMapping;
    public TextFieldValue oldValue;
    public Function1<? super TextFieldValue, Unit> onValueChange;
    public TextFieldState state;
    public TextToolbar textToolbar;
    public final TextFieldSelectionManager$touchSelectionObserver$1 touchSelectionObserver;
    public final UndoManager undoManager;
    public final ParcelableSnapshotMutableState value$delegate;

    public TextFieldSelectionManager() {
        this(null);
    }

    public static final void access$updateSelection(TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, int r16, int r17, boolean z, SelectionAdjustment adjustment) {
        TextLayoutResult textLayoutResult;
        long TextRange;
        TextLayoutResultProxy layoutResult;
        OffsetMapping offsetMapping = textFieldSelectionManager.offsetMapping;
        long j = textFieldValue.selection;
        int r6 = TextRange.$r8$clinit;
        int originalToTransformed = offsetMapping.originalToTransformed((int) (j >> 32));
        OffsetMapping offsetMapping2 = textFieldSelectionManager.offsetMapping;
        long j2 = textFieldValue.selection;
        long TextRange2 = TextRangeKt.TextRange(originalToTransformed, offsetMapping2.originalToTransformed(TextRange.m523getEndimpl(j2)));
        TextFieldState textFieldState = textFieldSelectionManager.state;
        TextRange textRange = null;
        if (textFieldState != null && (layoutResult = textFieldState.getLayoutResult()) != null) {
            textLayoutResult = layoutResult.value;
        } else {
            textLayoutResult = null;
        }
        if (!TextRange.m522getCollapsedimpl(TextRange2)) {
            textRange = new TextRange(TextRange2);
        }
        TextRange textRange2 = textRange;
        Intrinsics.checkNotNullParameter(adjustment, "adjustment");
        if (textLayoutResult != null) {
            TextRange = TextRangeKt.TextRange(r16, r17);
            if (textRange2 != null || !Intrinsics.areEqual(adjustment, SelectionAdjustment.Companion.Character)) {
                TextRange = adjustment.mo139adjustZXO7KMw(textLayoutResult, TextRange, -1, z, textRange2);
            }
        } else {
            TextRange = TextRangeKt.TextRange(0, 0);
        }
        long TextRange3 = TextRangeKt.TextRange(textFieldSelectionManager.offsetMapping.transformedToOriginal((int) (TextRange >> 32)), textFieldSelectionManager.offsetMapping.transformedToOriginal(TextRange.m523getEndimpl(TextRange)));
        if (!TextRange.m521equalsimpl0(TextRange3, j2)) {
            HapticFeedback hapticFeedback = textFieldSelectionManager.hapticFeedBack;
            if (hapticFeedback != null) {
                hapticFeedback.mo396performHapticFeedbackCdsT49E();
            }
            textFieldSelectionManager.onValueChange.invoke(m152createTextFieldValueFDrldGo(textFieldValue.annotatedString, TextRange3));
            TextFieldState textFieldState2 = textFieldSelectionManager.state;
            if (textFieldState2 != null) {
                textFieldState2.showSelectionHandleStart$delegate.setValue(Boolean.valueOf(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, true)));
            }
            TextFieldState textFieldState3 = textFieldSelectionManager.state;
            if (textFieldState3 != null) {
                textFieldState3.showSelectionHandleEnd$delegate.setValue(Boolean.valueOf(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, false)));
            }
        }
    }

    /* renamed from: createTextFieldValue-FDrldGo, reason: not valid java name */
    public static TextFieldValue m152createTextFieldValueFDrldGo(AnnotatedString annotatedString, long j) {
        return new TextFieldValue(annotatedString, j, (TextRange) null);
    }

    public final void copy$foundation_release(boolean z) {
        if (TextRange.m522getCollapsedimpl(getValue$foundation_release().selection)) {
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(NormalizedParameters.getSelectedText(getValue$foundation_release()));
        }
        if (!z) {
            return;
        }
        int m524getMaximpl = TextRange.m524getMaximpl(getValue$foundation_release().selection);
        this.onValueChange.invoke(m152createTextFieldValueFDrldGo(getValue$foundation_release().annotatedString, TextRangeKt.TextRange(m524getMaximpl, m524getMaximpl)));
        setHandleState(HandleState.None);
    }

    public final void cut$foundation_release() {
        if (TextRange.m522getCollapsedimpl(getValue$foundation_release().selection)) {
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(NormalizedParameters.getSelectedText(getValue$foundation_release()));
        }
        AnnotatedString plus = NormalizedParameters.getTextBeforeSelection(getValue$foundation_release(), getValue$foundation_release().annotatedString.text.length()).plus(NormalizedParameters.getTextAfterSelection(getValue$foundation_release(), getValue$foundation_release().annotatedString.text.length()));
        int m525getMinimpl = TextRange.m525getMinimpl(getValue$foundation_release().selection);
        this.onValueChange.invoke(m152createTextFieldValueFDrldGo(plus, TextRangeKt.TextRange(m525getMinimpl, m525getMinimpl)));
        setHandleState(HandleState.None);
        UndoManager undoManager = this.undoManager;
        if (undoManager != null) {
            undoManager.forceNextSnapshot = true;
        }
    }

    /* renamed from: deselect-_kEHs6E$foundation_release, reason: not valid java name */
    public final void m153deselect_kEHs6E$foundation_release(Offset offset) {
        HandleState handleState;
        TextLayoutResultProxy textLayoutResultProxy;
        int m524getMaximpl;
        boolean z = true;
        if (!TextRange.m522getCollapsedimpl(getValue$foundation_release().selection)) {
            TextFieldState textFieldState = this.state;
            if (textFieldState != null) {
                textLayoutResultProxy = textFieldState.getLayoutResult();
            } else {
                textLayoutResultProxy = null;
            }
            if (offset != null && textLayoutResultProxy != null) {
                m524getMaximpl = this.offsetMapping.transformedToOriginal(textLayoutResultProxy.m123getOffsetForPosition3MmeM6k(offset.packedValue, true));
            } else {
                m524getMaximpl = TextRange.m524getMaximpl(getValue$foundation_release().selection);
            }
            this.onValueChange.invoke(TextFieldValue.m545copy3r_uNRQ$default(getValue$foundation_release(), null, TextRangeKt.TextRange(m524getMaximpl, m524getMaximpl), 5));
        }
        if (offset != null) {
            if (getValue$foundation_release().annotatedString.text.length() <= 0) {
                z = false;
            }
            if (z) {
                handleState = HandleState.Cursor;
                setHandleState(handleState);
                hideSelectionToolbar$foundation_release();
            }
        }
        handleState = HandleState.None;
        setHandleState(handleState);
        hideSelectionToolbar$foundation_release();
    }

    public final void enterSelectionMode$foundation_release() {
        FocusRequester focusRequester;
        TextFieldState textFieldState = this.state;
        boolean z = false;
        if (textFieldState != null && !textFieldState.getHasFocus()) {
            z = true;
        }
        if (z && (focusRequester = this.focusRequester) != null) {
            focusRequester.focus$ui_release();
        }
        this.oldValue = getValue$foundation_release();
        TextFieldState textFieldState2 = this.state;
        if (textFieldState2 != null) {
            textFieldState2.showFloatingToolbar = true;
        }
        setHandleState(HandleState.Selection);
    }

    /* renamed from: getHandlePosition-tuRUvjQ$foundation_release, reason: not valid java name */
    public final long m154getHandlePositiontuRUvjQ$foundation_release(boolean z) {
        int m523getEndimpl;
        TextLayoutResultProxy textLayoutResultProxy;
        TextFieldValue value$foundation_release = getValue$foundation_release();
        if (z) {
            long j = value$foundation_release.selection;
            int r2 = TextRange.$r8$clinit;
            m523getEndimpl = (int) (j >> 32);
        } else {
            m523getEndimpl = TextRange.m523getEndimpl(value$foundation_release.selection);
        }
        TextFieldState textFieldState = this.state;
        if (textFieldState != null) {
            textLayoutResultProxy = textFieldState.getLayoutResult();
        } else {
            textLayoutResultProxy = null;
        }
        Intrinsics.checkNotNull(textLayoutResultProxy);
        int originalToTransformed = this.offsetMapping.originalToTransformed(m523getEndimpl);
        boolean m526getReversedimpl = TextRange.m526getReversedimpl(getValue$foundation_release().selection);
        TextLayoutResult textLayoutResult = textLayoutResultProxy.value;
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        return OffsetKt.Offset(zzba.getHorizontalPosition(textLayoutResult, originalToTransformed, z, m526getReversedimpl), textLayoutResult.getLineBottom(textLayoutResult.getLineForOffset(originalToTransformed)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TextFieldValue getValue$foundation_release() {
        return (TextFieldValue) this.value$delegate.getValue();
    }

    public final void hideSelectionToolbar$foundation_release() {
        TextToolbarStatus textToolbarStatus;
        TextToolbar textToolbar;
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

    public final void paste$foundation_release() {
        AnnotatedString text;
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null && (text = clipboardManager.getText()) != null) {
            AnnotatedString plus = NormalizedParameters.getTextBeforeSelection(getValue$foundation_release(), getValue$foundation_release().annotatedString.text.length()).plus(text).plus(NormalizedParameters.getTextAfterSelection(getValue$foundation_release(), getValue$foundation_release().annotatedString.text.length()));
            int length = text.length() + TextRange.m525getMinimpl(getValue$foundation_release().selection);
            this.onValueChange.invoke(m152createTextFieldValueFDrldGo(plus, TextRangeKt.TextRange(length, length)));
            setHandleState(HandleState.None);
            UndoManager undoManager = this.undoManager;
            if (undoManager != null) {
                undoManager.forceNextSnapshot = true;
            }
        }
    }

    public final void setHandleState(HandleState handleState) {
        TextFieldState textFieldState = this.state;
        if (textFieldState != null) {
            Intrinsics.checkNotNullParameter(handleState, "<set-?>");
            textFieldState.handleState$delegate.setValue(handleState);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void showSelectionToolbar$foundation_release() {
        /*
            Method dump skipped, instructions count: 369
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldSelectionManager.showSelectionToolbar$foundation_release():void");
    }

    /* JADX WARN: Type inference failed for: r7v11, types: [androidx.compose.foundation.text.selection.TextFieldSelectionManager$touchSelectionObserver$1] */
    public TextFieldSelectionManager(UndoManager undoManager) {
        this.undoManager = undoManager;
        this.offsetMapping = ValidatingOffsetMappingKt.ValidatingEmptyOffsetMappingIdentity;
        this.onValueChange = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$onValueChange$1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(TextFieldValue textFieldValue) {
                TextFieldValue it = textFieldValue;
                Intrinsics.checkNotNullParameter(it, "it");
                return Unit.INSTANCE;
            }
        };
        this.value$delegate = Platform.mutableStateOf$default(new TextFieldValue((String) null, 0L, 7));
        VisualTransformation.Companion.getClass();
        this.editable$delegate = Platform.mutableStateOf$default(Boolean.TRUE);
        long j = Offset.Zero;
        this.dragBeginPosition = j;
        this.dragTotalDistance = j;
        this.draggingHandle$delegate = Platform.mutableStateOf$default(null);
        this.currentDragPosition$delegate = Platform.mutableStateOf$default(null);
        this.oldValue = new TextFieldValue((String) null, 0L, 7);
        this.touchSelectionObserver = new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$touchSelectionObserver$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public final void mo119onDragk4lQ0M(long j2) {
                boolean z;
                TextLayoutResultProxy layoutResult;
                int m123getOffsetForPosition3MmeM6k;
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                if (textFieldSelectionManager.getValue$foundation_release().annotatedString.text.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
                textFieldSelectionManager.dragTotalDistance = Offset.m262plusMKHz9U(textFieldSelectionManager.dragTotalDistance, j2);
                TextFieldState textFieldState = textFieldSelectionManager.state;
                if (textFieldState != null && (layoutResult = textFieldState.getLayoutResult()) != null) {
                    Offset offset = new Offset(Offset.m262plusMKHz9U(textFieldSelectionManager.dragBeginPosition, textFieldSelectionManager.dragTotalDistance));
                    ParcelableSnapshotMutableState parcelableSnapshotMutableState = textFieldSelectionManager.currentDragPosition$delegate;
                    parcelableSnapshotMutableState.setValue(offset);
                    Integer num = textFieldSelectionManager.dragBeginOffsetInText;
                    if (num != null) {
                        m123getOffsetForPosition3MmeM6k = num.intValue();
                    } else {
                        m123getOffsetForPosition3MmeM6k = layoutResult.m123getOffsetForPosition3MmeM6k(textFieldSelectionManager.dragBeginPosition, false);
                    }
                    int r2 = m123getOffsetForPosition3MmeM6k;
                    Offset offset2 = (Offset) parcelableSnapshotMutableState.getValue();
                    Intrinsics.checkNotNull(offset2);
                    TextFieldSelectionManager.access$updateSelection(textFieldSelectionManager, textFieldSelectionManager.getValue$foundation_release(), r2, layoutResult.m123getOffsetForPosition3MmeM6k(offset2.packedValue, false), false, SelectionAdjustment.Companion.Word);
                }
                TextFieldState textFieldState2 = textFieldSelectionManager.state;
                if (textFieldState2 != null) {
                    textFieldState2.showFloatingToolbar = false;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:28:0x00b2  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00b5 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:31:0x00b6  */
            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void mo120onStartk4lQ0M(long r10) {
                /*
                    r9 = this;
                    androidx.compose.foundation.text.selection.TextFieldSelectionManager r6 = androidx.compose.foundation.text.selection.TextFieldSelectionManager.this
                    androidx.compose.runtime.ParcelableSnapshotMutableState r0 = r6.draggingHandle$delegate
                    java.lang.Object r0 = r0.getValue()
                    androidx.compose.foundation.text.Handle r0 = (androidx.compose.foundation.text.Handle) r0
                    if (r0 == 0) goto Ld
                    return
                Ld:
                    androidx.compose.foundation.text.Handle r0 = androidx.compose.foundation.text.Handle.SelectionEnd
                    androidx.compose.runtime.ParcelableSnapshotMutableState r1 = r6.draggingHandle$delegate
                    r1.setValue(r0)
                    r6.hideSelectionToolbar$foundation_release()
                    androidx.compose.foundation.text.TextFieldState r0 = r6.state
                    r1 = 1
                    r2 = 0
                    if (r0 == 0) goto L54
                    androidx.compose.foundation.text.TextLayoutResultProxy r0 = r0.getLayoutResult()
                    if (r0 == 0) goto L54
                    long r3 = r0.m122coercedInVisibleBoundsOfInputTextMKHz9U(r10)
                    long r3 = r0.m124relativeToInputTextMKHz9U(r3)
                    float r5 = androidx.compose.ui.geometry.Offset.m260getYimpl(r3)
                    androidx.compose.ui.text.TextLayoutResult r0 = r0.value
                    int r5 = r0.getLineForVerticalPosition(r5)
                    float r7 = androidx.compose.ui.geometry.Offset.m259getXimpl(r3)
                    float r8 = r0.getLineLeft(r5)
                    int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
                    if (r7 < 0) goto L4f
                    float r3 = androidx.compose.ui.geometry.Offset.m259getXimpl(r3)
                    float r0 = r0.getLineRight(r5)
                    int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
                    if (r0 > 0) goto L4f
                    r0 = r1
                    goto L50
                L4f:
                    r0 = r2
                L50:
                    if (r0 != r1) goto L54
                    r0 = r1
                    goto L55
                L54:
                    r0 = r2
                L55:
                    if (r0 != 0) goto La4
                    androidx.compose.foundation.text.TextFieldState r0 = r6.state
                    if (r0 == 0) goto La4
                    androidx.compose.foundation.text.TextLayoutResultProxy r0 = r0.getLayoutResult()
                    if (r0 == 0) goto La4
                    androidx.compose.ui.text.input.OffsetMapping r1 = r6.offsetMapping
                    float r10 = androidx.compose.ui.geometry.Offset.m260getYimpl(r10)
                    r11 = 0
                    long r10 = androidx.compose.ui.geometry.OffsetKt.Offset(r11, r10)
                    long r10 = r0.m122coercedInVisibleBoundsOfInputTextMKHz9U(r10)
                    long r10 = r0.m124relativeToInputTextMKHz9U(r10)
                    float r10 = androidx.compose.ui.geometry.Offset.m260getYimpl(r10)
                    androidx.compose.ui.text.TextLayoutResult r11 = r0.value
                    int r10 = r11.getLineForVerticalPosition(r10)
                    int r10 = r11.getLineEnd(r10, r2)
                    int r10 = r1.transformedToOriginal(r10)
                    androidx.compose.ui.hapticfeedback.HapticFeedback r11 = r6.hapticFeedBack
                    if (r11 == 0) goto L8d
                    r11.mo396performHapticFeedbackCdsT49E()
                L8d:
                    androidx.compose.ui.text.input.TextFieldValue r11 = r6.getValue$foundation_release()
                    androidx.compose.ui.text.AnnotatedString r11 = r11.annotatedString
                    long r0 = androidx.compose.ui.text.TextRangeKt.TextRange(r10, r10)
                    androidx.compose.ui.text.input.TextFieldValue r10 = androidx.compose.foundation.text.selection.TextFieldSelectionManager.m152createTextFieldValueFDrldGo(r11, r0)
                    r6.enterSelectionMode$foundation_release()
                    kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r11 = r6.onValueChange
                    r11.invoke(r10)
                    return
                La4:
                    androidx.compose.ui.text.input.TextFieldValue r0 = r6.getValue$foundation_release()
                    androidx.compose.ui.text.AnnotatedString r0 = r0.annotatedString
                    java.lang.String r0 = r0.text
                    int r0 = r0.length()
                    if (r0 != 0) goto Lb3
                    r2 = r1
                Lb3:
                    if (r2 == 0) goto Lb6
                    return
                Lb6:
                    r6.enterSelectionMode$foundation_release()
                    androidx.compose.foundation.text.TextFieldState r0 = r6.state
                    if (r0 == 0) goto Lda
                    androidx.compose.foundation.text.TextLayoutResultProxy r0 = r0.getLayoutResult()
                    if (r0 == 0) goto Lda
                    int r7 = r0.m123getOffsetForPosition3MmeM6k(r10, r1)
                    androidx.compose.ui.text.input.TextFieldValue r1 = r6.getValue$foundation_release()
                    r4 = 0
                    androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$Word$1 r5 = androidx.compose.foundation.text.selection.SelectionAdjustment.Companion.Word
                    r0 = r6
                    r2 = r7
                    r3 = r7
                    androidx.compose.foundation.text.selection.TextFieldSelectionManager.access$updateSelection(r0, r1, r2, r3, r4, r5)
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r7)
                    r6.dragBeginOffsetInText = r0
                Lda:
                    r6.dragBeginPosition = r10
                    androidx.compose.ui.geometry.Offset r0 = new androidx.compose.ui.geometry.Offset
                    r0.<init>(r10)
                    androidx.compose.runtime.ParcelableSnapshotMutableState r10 = r6.currentDragPosition$delegate
                    r10.setValue(r0)
                    long r10 = androidx.compose.ui.geometry.Offset.Zero
                    r6.dragTotalDistance = r10
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldSelectionManager$touchSelectionObserver$1.mo120onStartk4lQ0M(long):void");
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public final void onStop() {
                TextToolbarStatus textToolbarStatus;
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                textFieldSelectionManager.draggingHandle$delegate.setValue(null);
                textFieldSelectionManager.currentDragPosition$delegate.setValue(null);
                TextFieldState textFieldState = textFieldSelectionManager.state;
                if (textFieldState != null) {
                    textFieldState.showFloatingToolbar = true;
                }
                TextToolbar textToolbar = textFieldSelectionManager.textToolbar;
                if (textToolbar != null) {
                    textToolbarStatus = textToolbar.getStatus();
                } else {
                    textToolbarStatus = null;
                }
                if (textToolbarStatus == TextToolbarStatus.Hidden) {
                    textFieldSelectionManager.showSelectionToolbar$foundation_release();
                }
                textFieldSelectionManager.dragBeginOffsetInText = null;
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public final void onCancel() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public final void mo118onDownk4lQ0M() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public final void onUp() {
            }
        };
        new Object(this) { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$mouseSelectionObserver$1
        };
    }
}
