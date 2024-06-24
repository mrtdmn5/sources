package androidx.compose.foundation.text.selection;

import androidx.compose.animation.EnterExitTransitionKt$shrinkExpand$1$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.MagnifierKt;
import androidx.compose.foundation.MagnifierStyle;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.KeyCommand;
import androidx.compose.foundation.text.KeyMapping_androidKt;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectionContainer.kt */
/* loaded from: classes.dex */
public final class SelectionContainerKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void SelectionContainer(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int r11, final int r12) {
        int r1;
        Intrinsics.checkNotNullParameter(content, "content");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1075498320);
        int r0 = r12 & 1;
        if (r0 != 0) {
            r1 = r11 | 6;
        } else if ((r11 & 14) == 0) {
            r1 = (startRestartGroup.changed(modifier) ? 4 : 2) | r11;
        } else {
            r1 = r11;
        }
        if ((r12 & 2) != 0) {
            r1 |= 48;
        } else if ((r11 & 112) == 0) {
            r1 |= startRestartGroup.changedInstance(content) ? 32 : 16;
        }
        if ((r1 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (r0 != 0) {
                modifier = Modifier.Companion.$$INSTANCE;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            startRestartGroup.startReplaceableGroup(-492369756);
            Object nextSlot = startRestartGroup.nextSlot();
            Object obj = Composer.Companion.Empty;
            if (nextSlot == obj) {
                nextSlot = Platform.mutableStateOf$default(null);
                startRestartGroup.updateValue(nextSlot);
            }
            startRestartGroup.end(false);
            final MutableState mutableState = (MutableState) nextSlot;
            Selection selection = (Selection) mutableState.getValue();
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed = startRestartGroup.changed(mutableState);
            Object nextSlot2 = startRestartGroup.nextSlot();
            if (changed || nextSlot2 == obj) {
                nextSlot2 = new Function1<Selection, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Selection selection2) {
                        mutableState.setValue(selection2);
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateValue(nextSlot2);
            }
            startRestartGroup.end(false);
            SelectionContainer(modifier, selection, (Function1) nextSlot2, content, startRestartGroup, (r1 & 14) | ((r1 << 6) & 7168), 0);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                int updateChangedFlags = Strings.updateChangedFlags(r11 | 1);
                SelectionContainerKt.SelectionContainer(Modifier.this, content, composer2, updateChangedFlags, r12);
                return Unit.INSTANCE;
            }
        };
    }

    /* JADX WARN: Type inference failed for: r3v14, types: [androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$3$1, kotlin.jvm.internal.Lambda] */
    public static final void SelectionContainer(final Modifier modifier, final Selection selection, final Function1<? super Selection, Unit> onSelectionChange, final Function2<? super Composer, ? super Integer, Unit> children, Composer composer, final int r14, final int r15) {
        final int r1;
        Intrinsics.checkNotNullParameter(onSelectionChange, "onSelectionChange");
        Intrinsics.checkNotNullParameter(children, "children");
        ComposerImpl startRestartGroup = composer.startRestartGroup(2078139907);
        int r0 = r15 & 1;
        if (r0 != 0) {
            r1 = r14 | 6;
        } else if ((r14 & 14) == 0) {
            r1 = (startRestartGroup.changed(modifier) ? 4 : 2) | r14;
        } else {
            r1 = r14;
        }
        if ((r15 & 2) != 0) {
            r1 |= 48;
        } else if ((r14 & 112) == 0) {
            r1 |= startRestartGroup.changed(selection) ? 32 : 16;
        }
        if ((r15 & 4) != 0) {
            r1 |= 384;
        } else if ((r14 & 896) == 0) {
            r1 |= startRestartGroup.changedInstance(onSelectionChange) ? 256 : 128;
        }
        if ((r15 & 8) != 0) {
            r1 |= 3072;
        } else if ((r14 & 7168) == 0) {
            r1 |= startRestartGroup.changedInstance(children) ? 2048 : 1024;
        }
        if ((r1 & 5851) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (r0 != 0) {
                modifier = Modifier.Companion.$$INSTANCE;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            startRestartGroup.startReplaceableGroup(-492369756);
            Object nextSlot = startRestartGroup.nextSlot();
            Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
            if (nextSlot == composer$Companion$Empty$1) {
                nextSlot = new SelectionRegistrarImpl();
                startRestartGroup.updateValue(nextSlot);
            }
            startRestartGroup.end(false);
            SelectionRegistrarImpl selectionRegistrarImpl = (SelectionRegistrarImpl) nextSlot;
            startRestartGroup.startReplaceableGroup(-492369756);
            Object nextSlot2 = startRestartGroup.nextSlot();
            if (nextSlot2 == composer$Companion$Empty$1) {
                nextSlot2 = new SelectionManager(selectionRegistrarImpl);
                startRestartGroup.updateValue(nextSlot2);
            }
            startRestartGroup.end(false);
            final SelectionManager selectionManager = (SelectionManager) nextSlot2;
            selectionManager.hapticFeedBack = (HapticFeedback) startRestartGroup.consume(CompositionLocalsKt.LocalHapticFeedback);
            selectionManager.clipboardManager = (ClipboardManager) startRestartGroup.consume(CompositionLocalsKt.LocalClipboardManager);
            selectionManager.textToolbar = (TextToolbar) startRestartGroup.consume(CompositionLocalsKt.LocalTextToolbar);
            selectionManager.onSelectionChange = onSelectionChange;
            selectionManager._selection.setValue(selection);
            if (selection != null) {
                selectionManager.updateHandleOffsets();
            }
            startRestartGroup.startReplaceableGroup(605522716);
            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{SelectionRegistrarKt.LocalSelectionRegistrar.provides(selectionRegistrarImpl)}, ComposableLambdaKt.composableLambda(startRestartGroup, 935424596, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r1v9, types: [androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$3$1$1, kotlin.jvm.internal.Lambda] */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    Modifier modifier2;
                    Composer composer3 = composer2;
                    if ((num.intValue() & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        final SelectionManager selectionManager2 = selectionManager;
                        selectionManager2.getClass();
                        Modifier modifier3 = Modifier.Companion.$$INSTANCE;
                        Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$modifier$1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                SelectionManager.this.onRelease();
                                return Unit.INSTANCE;
                            }
                        };
                        if (selectionManager2.getHasFocus()) {
                            modifier2 = SuspendingPointerInputFilterKt.pointerInput(modifier3, Unit.INSTANCE, new SelectionManager$onClearSelectionRequested$1(selectionManager2, function0, null));
                        } else {
                            modifier2 = modifier3;
                        }
                        boolean z = true;
                        Modifier onKeyEvent = KeyInputModifierKt.onKeyEvent(FocusableKt.focusable(null, FocusChangedModifierKt.onFocusChanged(FocusRequesterModifierKt.focusRequester(OnGloballyPositionedModifierKt.onGloballyPositioned(modifier2, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$modifier$2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(LayoutCoordinates layoutCoordinates) {
                                TextToolbarStatus textToolbarStatus;
                                LayoutCoordinates it = layoutCoordinates;
                                Intrinsics.checkNotNullParameter(it, "it");
                                SelectionManager selectionManager3 = SelectionManager.this;
                                selectionManager3.containerLayoutCoordinates = it;
                                if (selectionManager3.getHasFocus() && selectionManager3.getSelection() != null) {
                                    Offset offset = new Offset(it.mo426localToWindowMKHz9U(Offset.Zero));
                                    if (!Intrinsics.areEqual(selectionManager3.previousPosition, offset)) {
                                        selectionManager3.previousPosition = offset;
                                        selectionManager3.updateHandleOffsets();
                                        if (selectionManager3.getHasFocus()) {
                                            TextToolbar textToolbar = selectionManager3.textToolbar;
                                            if (textToolbar != null) {
                                                textToolbarStatus = textToolbar.getStatus();
                                            } else {
                                                textToolbarStatus = null;
                                            }
                                            if (textToolbarStatus == TextToolbarStatus.Shown) {
                                                selectionManager3.showSelectionToolbar$foundation_release();
                                            }
                                        }
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), selectionManager2.focusRequester), new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$modifier$3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(FocusState focusState) {
                                FocusState focusState2 = focusState;
                                Intrinsics.checkNotNullParameter(focusState2, "focusState");
                                boolean isFocused = focusState2.isFocused();
                                SelectionManager selectionManager3 = SelectionManager.this;
                                if (!isFocused && selectionManager3.getHasFocus()) {
                                    selectionManager3.onRelease();
                                }
                                selectionManager3.hasFocus$delegate.setValue(Boolean.valueOf(focusState2.isFocused()));
                                return Unit.INSTANCE;
                            }
                        }), true), new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$modifier$4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(KeyEvent keyEvent) {
                                boolean z2;
                                android.view.KeyEvent it = keyEvent.nativeKeyEvent;
                                Intrinsics.checkNotNullParameter(it, "it");
                                boolean z3 = true;
                                if (KeyMapping_androidKt.platformDefaultKeyMapping.mo117mapZmokQxo(it) == KeyCommand.COPY) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (z2) {
                                    SelectionManager.this.copy$foundation_release();
                                } else {
                                    z3 = false;
                                }
                                return Boolean.valueOf(z3);
                            }
                        });
                        if (((Handle) selectionManager2.draggingHandle$delegate.getValue()) == null) {
                            z = false;
                        }
                        if (z && MagnifierStyle.TextDefault.isSupported()) {
                            modifier3 = ComposedModifierKt.composed(modifier3, InspectableValueKt.NoInspectorInfo, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.selection.SelectionManager_androidKt$selectionMagnifier$1
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Modifier invoke(Modifier modifier4, Composer composer4, Integer num2) {
                                    Modifier composed;
                                    Modifier modifier5 = modifier4;
                                    Composer composer5 = composer4;
                                    EnterExitTransitionKt$shrinkExpand$1$$ExternalSyntheticOutline0.m(num2, modifier5, "$this$composed", composer5, -1914520728);
                                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
                                    final Density density = (Density) composer5.consume(CompositionLocalsKt.LocalDensity);
                                    composer5.startReplaceableGroup(-492369756);
                                    Object rememberedValue = composer5.rememberedValue();
                                    Composer$Companion$Empty$1 composer$Companion$Empty$12 = Composer.Companion.Empty;
                                    if (rememberedValue == composer$Companion$Empty$12) {
                                        rememberedValue = Platform.mutableStateOf$default(new IntSize(0L));
                                        composer5.updateRememberedValue(rememberedValue);
                                    }
                                    composer5.endReplaceableGroup();
                                    final MutableState mutableState = (MutableState) rememberedValue;
                                    final SelectionManager selectionManager3 = SelectionManager.this;
                                    Function0<Offset> function02 = new Function0<Offset>() { // from class: androidx.compose.foundation.text.selection.SelectionManager_androidKt$selectionMagnifier$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Multi-variable type inference failed */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Offset invoke() {
                                            int r4;
                                            long j;
                                            long j2 = mutableState.getValue().packedValue;
                                            SelectionManager manager = SelectionManager.this;
                                            Intrinsics.checkNotNullParameter(manager, "manager");
                                            Selection selection2 = manager.getSelection();
                                            if (selection2 == null) {
                                                j = Offset.Unspecified;
                                            } else {
                                                Handle handle = (Handle) manager.draggingHandle$delegate.getValue();
                                                if (handle == null) {
                                                    r4 = -1;
                                                } else {
                                                    r4 = SelectionManagerKt.WhenMappings.$EnumSwitchMapping$0[handle.ordinal()];
                                                }
                                                if (r4 != -1) {
                                                    if (r4 != 1) {
                                                        if (r4 != 2) {
                                                            if (r4 != 3) {
                                                                throw new NoWhenBranchMatchedException();
                                                            }
                                                            throw new IllegalStateException("SelectionContainer does not support cursor".toString());
                                                        }
                                                        j = SelectionManagerKt.calculateSelectionMagnifierCenterAndroid_O0kMr_c$getMagnifierCenter(manager, j2, selection2.end, false);
                                                    } else {
                                                        j = SelectionManagerKt.calculateSelectionMagnifierCenterAndroid_O0kMr_c$getMagnifierCenter(manager, j2, selection2.start, true);
                                                    }
                                                } else {
                                                    j = Offset.Unspecified;
                                                }
                                            }
                                            return new Offset(j);
                                        }
                                    };
                                    composer5.startReplaceableGroup(511388516);
                                    boolean changed = composer5.changed(mutableState) | composer5.changed(density);
                                    Object rememberedValue2 = composer5.rememberedValue();
                                    if (changed || rememberedValue2 == composer$Companion$Empty$12) {
                                        rememberedValue2 = new Function1<Function0<? extends Offset>, Modifier>() { // from class: androidx.compose.foundation.text.selection.SelectionManager_androidKt$selectionMagnifier$1$2$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Modifier invoke(Function0<? extends Offset> function03) {
                                                final Function0<? extends Offset> center = function03;
                                                Intrinsics.checkNotNullParameter(center, "center");
                                                MagnifierStyle magnifierStyle = MagnifierStyle.TextDefault;
                                                Function1<Density, Offset> function1 = new Function1<Density, Offset>() { // from class: androidx.compose.foundation.text.selection.SelectionManager_androidKt$selectionMagnifier$1$2$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Offset invoke(Density density2) {
                                                        Density magnifier = density2;
                                                        Intrinsics.checkNotNullParameter(magnifier, "$this$magnifier");
                                                        return new Offset(center.invoke().packedValue);
                                                    }
                                                };
                                                final Density density2 = Density.this;
                                                final MutableState<IntSize> mutableState2 = mutableState;
                                                return MagnifierKt.magnifier$default(function1, magnifierStyle, new Function1<DpSize, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager_androidKt$selectionMagnifier$1$2$1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(DpSize dpSize) {
                                                        long j = dpSize.packedValue;
                                                        float m587getWidthD9Ej5fM = DpSize.m587getWidthD9Ej5fM(j);
                                                        Density density3 = Density.this;
                                                        mutableState2.setValue(new IntSize(IntSizeKt.IntSize(density3.mo44roundToPx0680j_4(m587getWidthD9Ej5fM), density3.mo44roundToPx0680j_4(DpSize.m586getHeightD9Ej5fM(j)))));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                            }
                                        };
                                        composer5.updateRememberedValue(rememberedValue2);
                                    }
                                    composer5.endReplaceableGroup();
                                    Function1 platformMagnifier = (Function1) rememberedValue2;
                                    AnimationVector2D animationVector2D = SelectionMagnifierKt.UnspecifiedAnimationVector2D;
                                    Intrinsics.checkNotNullParameter(platformMagnifier, "platformMagnifier");
                                    composed = ComposedModifierKt.composed(modifier5, InspectableValueKt.NoInspectorInfo, new SelectionMagnifierKt$animatedSelectionMagnifier$1(platformMagnifier, function02));
                                    composer5.endReplaceableGroup();
                                    return composed;
                                }
                            });
                        }
                        Modifier then = Modifier.this.then(onKeyEvent.then(modifier3));
                        final Function2<Composer, Integer, Unit> function2 = children;
                        final int r3 = r1;
                        SimpleLayoutKt.SimpleLayout(then, ComposableLambdaKt.composableLambda(composer3, 1375295262, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$3$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(Composer composer4, Integer num2) {
                                Selection selection2;
                                Offset offset;
                                ResolvedTextDirection resolvedTextDirection;
                                Composer composer5 = composer4;
                                if ((num2.intValue() & 11) == 2 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
                                    function2.invoke(composer5, Integer.valueOf((r3 >> 9) & 14));
                                    final SelectionManager selectionManager3 = selectionManager2;
                                    if (selectionManager3.getHasFocus() && (selection2 = selectionManager3.getSelection()) != null) {
                                        List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Boolean[]{Boolean.TRUE, Boolean.FALSE});
                                        int size = listOf.size();
                                        for (int r152 = 0; r152 < size; r152++) {
                                            final boolean booleanValue = ((Boolean) listOf.get(r152)).booleanValue();
                                            Boolean valueOf = Boolean.valueOf(booleanValue);
                                            composer5.startReplaceableGroup(1157296644);
                                            boolean changed = composer5.changed(valueOf);
                                            Object rememberedValue = composer5.rememberedValue();
                                            if (changed || rememberedValue == Composer.Companion.Empty) {
                                                rememberedValue = new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.SelectionManager$handleDragObserver$1
                                                    @Override // androidx.compose.foundation.text.TextDragObserver
                                                    public final void onCancel() {
                                                        SelectionManager selectionManager4 = SelectionManager.this;
                                                        selectionManager4.showSelectionToolbar$foundation_release();
                                                        selectionManager4.setDraggingHandle(null);
                                                        selectionManager4.m143setCurrentDragPosition_kEHs6E(null);
                                                    }

                                                    @Override // androidx.compose.foundation.text.TextDragObserver
                                                    /* renamed from: onDown-k-4lQ0M */
                                                    public final void mo118onDownk4lQ0M() {
                                                        Selection.AnchorInfo anchorInfo;
                                                        LayoutCoordinates layoutCoordinates;
                                                        Handle handle;
                                                        SelectionManager selectionManager4 = SelectionManager.this;
                                                        Selection selection3 = selectionManager4.getSelection();
                                                        if (selection3 == null) {
                                                            return;
                                                        }
                                                        boolean z2 = booleanValue;
                                                        if (z2) {
                                                            anchorInfo = selection3.start;
                                                        } else {
                                                            anchorInfo = selection3.end;
                                                        }
                                                        Selectable anchorSelectable$foundation_release = selectionManager4.getAnchorSelectable$foundation_release(anchorInfo);
                                                        if (anchorSelectable$foundation_release == null || (layoutCoordinates = anchorSelectable$foundation_release.getLayoutCoordinates()) == null) {
                                                            return;
                                                        }
                                                        selectionManager4.m143setCurrentDragPosition_kEHs6E(new Offset(selectionManager4.requireContainerCoordinates$foundation_release().mo424localPositionOfR5De75A(layoutCoordinates, SelectionHandlesKt.m141getAdjustedCoordinatesk4lQ0M(anchorSelectable$foundation_release.mo134getHandlePositiondBAh8RU(selection3, z2)))));
                                                        if (z2) {
                                                            handle = Handle.SelectionStart;
                                                        } else {
                                                            handle = Handle.SelectionEnd;
                                                        }
                                                        selectionManager4.setDraggingHandle(handle);
                                                    }

                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    @Override // androidx.compose.foundation.text.TextDragObserver
                                                    /* renamed from: onDrag-k-4lQ0M */
                                                    public final void mo119onDragk4lQ0M(long j) {
                                                        SelectionManager selectionManager4 = SelectionManager.this;
                                                        Offset offset2 = new Offset(Offset.m262plusMKHz9U(((Offset) selectionManager4.dragTotalDistance$delegate.getValue()).packedValue, j));
                                                        ParcelableSnapshotMutableState parcelableSnapshotMutableState = selectionManager4.dragTotalDistance$delegate;
                                                        parcelableSnapshotMutableState.setValue(offset2);
                                                        ParcelableSnapshotMutableState parcelableSnapshotMutableState2 = selectionManager4.dragBeginPosition$delegate;
                                                        long m262plusMKHz9U = Offset.m262plusMKHz9U(((Offset) parcelableSnapshotMutableState2.getValue()).packedValue, ((Offset) parcelableSnapshotMutableState.getValue()).packedValue);
                                                        if (selectionManager4.m145updateSelectionRHHTvR4$foundation_release(new Offset(m262plusMKHz9U), new Offset(((Offset) parcelableSnapshotMutableState2.getValue()).packedValue), booleanValue, SelectionAdjustment.Companion.CharacterWithWordAccelerate)) {
                                                            parcelableSnapshotMutableState2.setValue(new Offset(m262plusMKHz9U));
                                                            parcelableSnapshotMutableState.setValue(new Offset(Offset.Zero));
                                                        }
                                                    }

                                                    @Override // androidx.compose.foundation.text.TextDragObserver
                                                    /* renamed from: onStart-k-4lQ0M */
                                                    public final void mo120onStartk4lQ0M(long j) {
                                                        long mo134getHandlePositiondBAh8RU;
                                                        SelectionManager selectionManager4 = SelectionManager.this;
                                                        selectionManager4.hideSelectionToolbar$foundation_release();
                                                        Selection selection3 = selectionManager4.getSelection();
                                                        Intrinsics.checkNotNull(selection3);
                                                        SelectionRegistrarImpl selectionRegistrarImpl2 = selectionManager4.selectionRegistrar;
                                                        Selectable selectable = (Selectable) selectionRegistrarImpl2._selectableMap.get(Long.valueOf(selection3.start.selectableId));
                                                        Selectable selectable2 = (Selectable) selectionRegistrarImpl2._selectableMap.get(Long.valueOf(selection3.end.selectableId));
                                                        LayoutCoordinates layoutCoordinates = null;
                                                        boolean z2 = booleanValue;
                                                        if (z2) {
                                                            if (selectable != null) {
                                                                layoutCoordinates = selectable.getLayoutCoordinates();
                                                            }
                                                            Intrinsics.checkNotNull(layoutCoordinates);
                                                        } else {
                                                            if (selectable2 != null) {
                                                                layoutCoordinates = selectable2.getLayoutCoordinates();
                                                            }
                                                            Intrinsics.checkNotNull(layoutCoordinates);
                                                        }
                                                        if (z2) {
                                                            Intrinsics.checkNotNull(selectable);
                                                            mo134getHandlePositiondBAh8RU = selectable.mo134getHandlePositiondBAh8RU(selection3, true);
                                                        } else {
                                                            Intrinsics.checkNotNull(selectable2);
                                                            mo134getHandlePositiondBAh8RU = selectable2.mo134getHandlePositiondBAh8RU(selection3, false);
                                                        }
                                                        selectionManager4.dragBeginPosition$delegate.setValue(new Offset(selectionManager4.requireContainerCoordinates$foundation_release().mo424localPositionOfR5De75A(layoutCoordinates, SelectionHandlesKt.m141getAdjustedCoordinatesk4lQ0M(mo134getHandlePositiondBAh8RU))));
                                                        selectionManager4.dragTotalDistance$delegate.setValue(new Offset(Offset.Zero));
                                                    }

                                                    @Override // androidx.compose.foundation.text.TextDragObserver
                                                    public final void onStop() {
                                                        SelectionManager selectionManager4 = SelectionManager.this;
                                                        selectionManager4.showSelectionToolbar$foundation_release();
                                                        selectionManager4.setDraggingHandle(null);
                                                        selectionManager4.m143setCurrentDragPosition_kEHs6E(null);
                                                    }

                                                    @Override // androidx.compose.foundation.text.TextDragObserver
                                                    public final void onUp() {
                                                        SelectionManager selectionManager4 = SelectionManager.this;
                                                        selectionManager4.setDraggingHandle(null);
                                                        selectionManager4.m143setCurrentDragPosition_kEHs6E(null);
                                                    }
                                                };
                                                composer5.updateRememberedValue(rememberedValue);
                                            }
                                            composer5.endReplaceableGroup();
                                            TextDragObserver textDragObserver = (TextDragObserver) rememberedValue;
                                            if (booleanValue) {
                                                offset = (Offset) selectionManager3.startHandlePosition$delegate.getValue();
                                            } else {
                                                offset = (Offset) selectionManager3.endHandlePosition$delegate.getValue();
                                            }
                                            if (booleanValue) {
                                                resolvedTextDirection = selection2.start.direction;
                                            } else {
                                                resolvedTextDirection = selection2.end.direction;
                                            }
                                            if (offset != null) {
                                                AndroidSelectionHandles_androidKt.m132SelectionHandle8fL75g(offset.packedValue, booleanValue, resolvedTextDirection, selection2.handlesCrossed, SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion.$$INSTANCE, textDragObserver, new SelectionContainerKt$SelectionContainer$3$1$1$1$1$1(textDragObserver, null)), null, composer5, 196608);
                                            }
                                        }
                                    }
                                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$14 = ComposerKt.removeCurrentGroupInstance;
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 48, 0);
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 56);
            startRestartGroup.end(false);
            EffectsKt.DisposableEffect(selectionManager, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    DisposableEffectScope DisposableEffect = disposableEffectScope;
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    final SelectionManager selectionManager2 = SelectionManager.this;
                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$4$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public final void dispose() {
                            SelectionManager selectionManager3 = SelectionManager.this;
                            selectionManager3.onRelease();
                            selectionManager3.hasFocus$delegate.setValue(Boolean.FALSE);
                        }
                    };
                }
            }, startRestartGroup);
        }
        final Modifier modifier2 = modifier;
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                SelectionContainerKt.SelectionContainer(Modifier.this, selection, onSelectionChange, children, composer2, Strings.updateChangedFlags(r14 | 1), r15);
                return Unit.INSTANCE;
            }
        };
    }
}
