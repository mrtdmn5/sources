package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextFieldSelectionManager.kt */
/* loaded from: classes.dex */
public final class TextFieldSelectionManagerKt {

    /* compiled from: TextFieldSelectionManager.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[Handle.values().length];
            try {
                r0[Handle.Cursor.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[Handle.SelectionStart.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[Handle.SelectionEnd.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static final void TextFieldSelectionHandle(final boolean z, final ResolvedTextDirection direction, final TextFieldSelectionManager manager, Composer composer, final int r14) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(manager, "manager");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1344558920);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Boolean valueOf = Boolean.valueOf(z);
        startRestartGroup.startReplaceableGroup(511388516);
        boolean changed = startRestartGroup.changed(valueOf) | startRestartGroup.changed(manager);
        Object nextSlot = startRestartGroup.nextSlot();
        if (changed || nextSlot == Composer.Companion.Empty) {
            nextSlot = new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$handleDragObserver$1
                @Override // androidx.compose.foundation.text.TextDragObserver
                /* renamed from: onDown-k-4lQ0M */
                public final void mo118onDownk4lQ0M() {
                    Handle handle;
                    boolean z2 = z;
                    if (z2) {
                        handle = Handle.SelectionStart;
                    } else {
                        handle = Handle.SelectionEnd;
                    }
                    TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                    textFieldSelectionManager.draggingHandle$delegate.setValue(handle);
                    textFieldSelectionManager.currentDragPosition$delegate.setValue(new Offset(SelectionHandlesKt.m141getAdjustedCoordinatesk4lQ0M(textFieldSelectionManager.m154getHandlePositiontuRUvjQ$foundation_release(z2))));
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // androidx.compose.foundation.text.TextDragObserver
                /* renamed from: onDrag-k-4lQ0M */
                public final void mo119onDragk4lQ0M(long j) {
                    TextLayoutResultProxy layoutResult;
                    TextLayoutResult textLayoutResult;
                    int originalToTransformed;
                    int m519getOffsetForPositionk4lQ0M;
                    TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                    textFieldSelectionManager.dragTotalDistance = Offset.m262plusMKHz9U(textFieldSelectionManager.dragTotalDistance, j);
                    TextFieldState textFieldState = textFieldSelectionManager.state;
                    if (textFieldState != null && (layoutResult = textFieldState.getLayoutResult()) != null && (textLayoutResult = layoutResult.value) != null) {
                        boolean z2 = z;
                        Offset offset = new Offset(Offset.m262plusMKHz9U(textFieldSelectionManager.dragBeginPosition, textFieldSelectionManager.dragTotalDistance));
                        ParcelableSnapshotMutableState parcelableSnapshotMutableState = textFieldSelectionManager.currentDragPosition$delegate;
                        parcelableSnapshotMutableState.setValue(offset);
                        if (z2) {
                            Offset offset2 = (Offset) parcelableSnapshotMutableState.getValue();
                            Intrinsics.checkNotNull(offset2);
                            originalToTransformed = textLayoutResult.m519getOffsetForPositionk4lQ0M(offset2.packedValue);
                        } else {
                            OffsetMapping offsetMapping = textFieldSelectionManager.offsetMapping;
                            long j2 = textFieldSelectionManager.getValue$foundation_release().selection;
                            int r3 = TextRange.$r8$clinit;
                            originalToTransformed = offsetMapping.originalToTransformed((int) (j2 >> 32));
                        }
                        int r2 = originalToTransformed;
                        if (z2) {
                            m519getOffsetForPositionk4lQ0M = textFieldSelectionManager.offsetMapping.originalToTransformed(TextRange.m523getEndimpl(textFieldSelectionManager.getValue$foundation_release().selection));
                        } else {
                            Offset offset3 = (Offset) parcelableSnapshotMutableState.getValue();
                            Intrinsics.checkNotNull(offset3);
                            m519getOffsetForPositionk4lQ0M = textLayoutResult.m519getOffsetForPositionk4lQ0M(offset3.packedValue);
                        }
                        TextFieldSelectionManager.access$updateSelection(textFieldSelectionManager, textFieldSelectionManager.getValue$foundation_release(), r2, m519getOffsetForPositionk4lQ0M, z2, SelectionAdjustment.Companion.Character);
                    }
                    TextFieldState textFieldState2 = textFieldSelectionManager.state;
                    if (textFieldState2 != null) {
                        textFieldState2.showFloatingToolbar = false;
                    }
                }

                @Override // androidx.compose.foundation.text.TextDragObserver
                /* renamed from: onStart-k-4lQ0M */
                public final void mo120onStartk4lQ0M(long j) {
                    Handle handle;
                    TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                    boolean z2 = z;
                    long m141getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m141getAdjustedCoordinatesk4lQ0M(textFieldSelectionManager.m154getHandlePositiontuRUvjQ$foundation_release(z2));
                    textFieldSelectionManager.dragBeginPosition = m141getAdjustedCoordinatesk4lQ0M;
                    textFieldSelectionManager.currentDragPosition$delegate.setValue(new Offset(m141getAdjustedCoordinatesk4lQ0M));
                    textFieldSelectionManager.dragTotalDistance = Offset.Zero;
                    if (z2) {
                        handle = Handle.SelectionStart;
                    } else {
                        handle = Handle.SelectionEnd;
                    }
                    textFieldSelectionManager.draggingHandle$delegate.setValue(handle);
                    TextFieldState textFieldState = textFieldSelectionManager.state;
                    if (textFieldState != null) {
                        textFieldState.showFloatingToolbar = false;
                    }
                }

                @Override // androidx.compose.foundation.text.TextDragObserver
                public final void onStop() {
                    TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                    TextToolbarStatus textToolbarStatus = null;
                    textFieldSelectionManager.draggingHandle$delegate.setValue(null);
                    textFieldSelectionManager.currentDragPosition$delegate.setValue(null);
                    TextFieldState textFieldState = textFieldSelectionManager.state;
                    if (textFieldState != null) {
                        textFieldState.showFloatingToolbar = true;
                    }
                    TextToolbar textToolbar = textFieldSelectionManager.textToolbar;
                    if (textToolbar != null) {
                        textToolbarStatus = textToolbar.getStatus();
                    }
                    if (textToolbarStatus == TextToolbarStatus.Hidden) {
                        textFieldSelectionManager.showSelectionToolbar$foundation_release();
                    }
                }

                @Override // androidx.compose.foundation.text.TextDragObserver
                public final void onUp() {
                    TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                    textFieldSelectionManager.draggingHandle$delegate.setValue(null);
                    textFieldSelectionManager.currentDragPosition$delegate.setValue(null);
                }

                @Override // androidx.compose.foundation.text.TextDragObserver
                public final void onCancel() {
                }
            };
            startRestartGroup.updateValue(nextSlot);
        }
        startRestartGroup.end(false);
        TextDragObserver textDragObserver = (TextDragObserver) nextSlot;
        int r0 = r14 << 3;
        AndroidSelectionHandles_androidKt.m132SelectionHandle8fL75g(manager.m154getHandlePositiontuRUvjQ$foundation_release(z), z, direction, TextRange.m526getReversedimpl(manager.getValue$foundation_release().selection), SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion.$$INSTANCE, textDragObserver, new TextFieldSelectionManagerKt$TextFieldSelectionHandle$1(textDragObserver, null)), null, startRestartGroup, (r0 & 112) | 196608 | (r0 & 896));
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt$TextFieldSelectionHandle$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    int updateChangedFlags = Strings.updateChangedFlags(r14 | 1);
                    ResolvedTextDirection resolvedTextDirection = direction;
                    TextFieldSelectionManager textFieldSelectionManager = manager;
                    TextFieldSelectionManagerKt.TextFieldSelectionHandle(z, resolvedTextDirection, textFieldSelectionManager, composer2, updateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final boolean isSelectionHandleInVisibleBound(TextFieldSelectionManager textFieldSelectionManager, boolean z) {
        LayoutCoordinates layoutCoordinates;
        Intrinsics.checkNotNullParameter(textFieldSelectionManager, "<this>");
        TextFieldState textFieldState = textFieldSelectionManager.state;
        if (textFieldState != null && (layoutCoordinates = textFieldState.layoutCoordinates) != null) {
            return SelectionManagerKt.m146containsInclusiveUv8p0NA(textFieldSelectionManager.m154getHandlePositiontuRUvjQ$foundation_release(z), SelectionManagerKt.visibleBounds(layoutCoordinates));
        }
        return false;
    }
}
