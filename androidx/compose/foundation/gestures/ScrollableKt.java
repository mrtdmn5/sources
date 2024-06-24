package androidx.compose.foundation.gestures;

import androidx.compose.animation.EnterExitTransitionKt$shrinkExpand$1$$ExternalSyntheticOutline0;
import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.FocusableKt$focusGroup$1;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusPropertiesKt;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableModifier;
import androidx.compose.ui.platform.InspectableValueKt;
import com.google.common.collect.Platform;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Scrollable.kt */
/* loaded from: classes.dex */
public final class ScrollableKt {
    public static final ScrollableKt$NoOpOnDragStarted$1 NoOpOnDragStarted = new ScrollableKt$NoOpOnDragStarted$1(null);
    public static final ScrollableKt$NoOpScrollScope$1 NoOpScrollScope = new ScrollableKt$NoOpScrollScope$1();
    public static final ProvidableModifierLocal<Boolean> ModifierLocalScrollableContainer = ModifierLocalKt.modifierLocalOf(new Function0<Boolean>() { // from class: androidx.compose.foundation.gestures.ScrollableKt$ModifierLocalScrollableContainer$1
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    });
    public static final ScrollableKt$DefaultScrollMotionDurationScale$1 DefaultScrollMotionDurationScale = new ScrollableKt$DefaultScrollMotionDurationScale$1();

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0048  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003c -> B:10:0x003f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object access$awaitScrollEvent(androidx.compose.ui.input.pointer.AwaitPointerEventScope r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof androidx.compose.foundation.gestures.ScrollableKt$awaitScrollEvent$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.compose.foundation.gestures.ScrollableKt$awaitScrollEvent$1 r0 = (androidx.compose.foundation.gestures.ScrollableKt$awaitScrollEvent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.ScrollableKt$awaitScrollEvent$1 r0 = new androidx.compose.foundation.gestures.ScrollableKt$awaitScrollEvent$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L3f
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
        L34:
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r5, r0)
            if (r6 != r1) goto L3f
            goto L4c
        L3f:
            androidx.compose.ui.input.pointer.PointerEvent r6 = (androidx.compose.ui.input.pointer.PointerEvent) r6
            int r2 = r6.type
            r4 = 6
            if (r2 != r4) goto L48
            r2 = r3
            goto L49
        L48:
            r2 = 0
        L49:
            if (r2 == 0) goto L34
            r1 = r6
        L4c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt.access$awaitScrollEvent(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Modifier scrollable(Modifier modifier, final ScrollableState state, final Orientation orientation, final OverscrollEffect overscrollEffect, final boolean z, final boolean z2, final FlingBehavior flingBehavior, final MutableInteractionSource mutableInteractionSource) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.NoInspectorInfo, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.gestures.ScrollableKt$scrollable$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function3
            public final Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                FlingBehavior flingBehavior2;
                Modifier modifier3;
                Composer composer2 = composer;
                EnterExitTransitionKt$shrinkExpand$1$$ExternalSyntheticOutline0.m(num, modifier2, "$this$composed", composer2, -629830927);
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                composer2.startReplaceableGroup(773894976);
                composer2.startReplaceableGroup(-492369756);
                Object rememberedValue = composer2.rememberedValue();
                Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
                if (rememberedValue == composer$Companion$Empty$1) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(composer2));
                    composer2.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                    rememberedValue = compositionScopedCoroutineScopeCanceller;
                }
                composer2.endReplaceableGroup();
                CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).coroutineScope;
                composer2.endReplaceableGroup();
                boolean z3 = z2;
                Boolean valueOf = Boolean.valueOf(z3);
                Orientation orientation2 = orientation;
                ScrollableState scrollableState = state;
                Object[] objArr = {coroutineScope, orientation2, scrollableState, valueOf};
                composer2.startReplaceableGroup(-568225417);
                boolean z4 = false;
                for (int r9 = 0; r9 < 4; r9++) {
                    z4 |= composer2.changed(objArr[r9]);
                }
                Object rememberedValue2 = composer2.rememberedValue();
                if (z4 || rememberedValue2 == composer$Companion$Empty$1) {
                    rememberedValue2 = new ContentInViewModifier(coroutineScope, orientation2, scrollableState, z3);
                    composer2.updateRememberedValue(rememberedValue2);
                }
                composer2.endReplaceableGroup();
                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                InspectableModifier inspectableModifier = FocusableKt.focusGroupInspectorInfo;
                companion.then(inspectableModifier);
                Modifier focusProperties = FocusPropertiesKt.focusProperties(inspectableModifier, FocusableKt$focusGroup$1.INSTANCE);
                Intrinsics.checkNotNullParameter(focusProperties, "<this>");
                Modifier then = focusProperties.then(FocusTargetNode.FocusTargetElement.INSTANCE).then(((ContentInViewModifier) rememberedValue2).modifier);
                MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                Orientation orientation3 = orientation;
                boolean z5 = z2;
                ScrollableState scrollableState2 = state;
                OverscrollEffect overscrollEffect2 = overscrollEffect;
                boolean z6 = z;
                composer2.startReplaceableGroup(-2012025036);
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                composer2.startReplaceableGroup(-1730185954);
                FlingBehavior flingBehavior3 = flingBehavior;
                if (flingBehavior3 == null) {
                    composer2.startReplaceableGroup(1107739818);
                    DecayAnimationSpec rememberSplineBasedDecay = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer2);
                    composer2.startReplaceableGroup(1157296644);
                    boolean changed = composer2.changed(rememberSplineBasedDecay);
                    Object rememberedValue3 = composer2.rememberedValue();
                    if (changed || rememberedValue3 == composer$Companion$Empty$1) {
                        rememberedValue3 = new DefaultFlingBehavior(rememberSplineBasedDecay);
                        composer2.updateRememberedValue(rememberedValue3);
                    }
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    flingBehavior2 = (DefaultFlingBehavior) rememberedValue3;
                } else {
                    flingBehavior2 = flingBehavior3;
                }
                composer2.endReplaceableGroup();
                composer2.startReplaceableGroup(-492369756);
                Object rememberedValue4 = composer2.rememberedValue();
                if (rememberedValue4 == composer$Companion$Empty$1) {
                    rememberedValue4 = Platform.mutableStateOf$default(new NestedScrollDispatcher());
                    composer2.updateRememberedValue(rememberedValue4);
                }
                composer2.endReplaceableGroup();
                MutableState mutableState = (MutableState) rememberedValue4;
                final MutableState rememberUpdatedState = Platform.rememberUpdatedState(new ScrollingLogic(orientation3, z5, mutableState, scrollableState2, flingBehavior2, overscrollEffect2), composer2);
                Boolean valueOf2 = Boolean.valueOf(z6);
                composer2.startReplaceableGroup(1157296644);
                boolean changed2 = composer2.changed(valueOf2);
                Object rememberedValue5 = composer2.rememberedValue();
                if (changed2 || rememberedValue5 == composer$Companion$Empty$1) {
                    rememberedValue5 = new ScrollableKt$scrollableNestedScrollConnection$1(rememberUpdatedState, z6);
                    composer2.updateRememberedValue(rememberedValue5);
                }
                composer2.endReplaceableGroup();
                NestedScrollConnection nestedScrollConnection = (NestedScrollConnection) rememberedValue5;
                composer2.startReplaceableGroup(-492369756);
                Object rememberedValue6 = composer2.rememberedValue();
                if (rememberedValue6 == composer$Companion$Empty$1) {
                    rememberedValue6 = new ScrollDraggableState(rememberUpdatedState);
                    composer2.updateRememberedValue(rememberedValue6);
                }
                composer2.endReplaceableGroup();
                ScrollDraggableState scrollDraggableState = (ScrollDraggableState) rememberedValue6;
                composer2.startReplaceableGroup(-1485272842);
                composer2.endReplaceableGroup();
                ScrollableKt$NoOpOnDragStarted$1 scrollableKt$NoOpOnDragStarted$1 = ScrollableKt.NoOpOnDragStarted;
                ScrollableKt$pointerScrollable$1 scrollableKt$pointerScrollable$1 = new Function1<PointerInputChange, Boolean>() { // from class: androidx.compose.foundation.gestures.ScrollableKt$pointerScrollable$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(PointerInputChange pointerInputChange) {
                        boolean z7;
                        PointerInputChange down = pointerInputChange;
                        Intrinsics.checkNotNullParameter(down, "down");
                        if (down.type == 2) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        return Boolean.valueOf(!z7);
                    }
                };
                composer2.startReplaceableGroup(1157296644);
                boolean changed3 = composer2.changed(rememberUpdatedState);
                Object rememberedValue7 = composer2.rememberedValue();
                if (changed3 || rememberedValue7 == composer$Companion$Empty$1) {
                    rememberedValue7 = new Function0<Boolean>() { // from class: androidx.compose.foundation.gestures.ScrollableKt$pointerScrollable$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:8:0x0029, code lost:            if (r0 != false) goto L11;     */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // kotlin.jvm.functions.Function0
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final java.lang.Boolean invoke() {
                            /*
                                r2 = this;
                                androidx.compose.runtime.State<androidx.compose.foundation.gestures.ScrollingLogic> r0 = r1
                                java.lang.Object r0 = r0.getValue()
                                androidx.compose.foundation.gestures.ScrollingLogic r0 = (androidx.compose.foundation.gestures.ScrollingLogic) r0
                                androidx.compose.foundation.gestures.ScrollableState r1 = r0.scrollableState
                                boolean r1 = r1.isScrollInProgress()
                                if (r1 != 0) goto L2b
                                androidx.compose.runtime.ParcelableSnapshotMutableState r1 = r0.isNestedFlinging
                                java.lang.Object r1 = r1.getValue()
                                java.lang.Boolean r1 = (java.lang.Boolean) r1
                                boolean r1 = r1.booleanValue()
                                if (r1 != 0) goto L2b
                                r1 = 0
                                androidx.compose.foundation.OverscrollEffect r0 = r0.overscrollEffect
                                if (r0 == 0) goto L28
                                boolean r0 = r0.isInProgress()
                                goto L29
                            L28:
                                r0 = r1
                            L29:
                                if (r0 == 0) goto L2c
                            L2b:
                                r1 = 1
                            L2c:
                                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
                                return r0
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt$pointerScrollable$2$1.invoke():java.lang.Object");
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue7);
                }
                composer2.endReplaceableGroup();
                Function0 function0 = (Function0) rememberedValue7;
                composer2.startReplaceableGroup(511388516);
                boolean changed4 = composer2.changed(mutableState) | composer2.changed(rememberUpdatedState);
                Object rememberedValue8 = composer2.rememberedValue();
                if (changed4 || rememberedValue8 == composer$Companion$Empty$1) {
                    rememberedValue8 = new ScrollableKt$pointerScrollable$3$1(mutableState, rememberUpdatedState, null);
                    composer2.updateRememberedValue(rememberedValue8);
                }
                composer2.endReplaceableGroup();
                Modifier nestedScroll = NestedScrollModifierKt.nestedScroll(then.then(new DraggableElement(scrollDraggableState, scrollableKt$pointerScrollable$1, orientation3, z6, mutableInteractionSource2, function0, scrollableKt$NoOpOnDragStarted$1, (Function3) rememberedValue8, false)).then(new MouseWheelScrollElement(rememberUpdatedState)), nestedScrollConnection, (NestedScrollDispatcher) mutableState.getValue());
                composer2.endReplaceableGroup();
                if (z) {
                    modifier3 = ModifierLocalScrollableContainerProvider.INSTANCE;
                } else {
                    modifier3 = companion;
                }
                Modifier then2 = nestedScroll.then(modifier3);
                composer2.endReplaceableGroup();
                return then2;
            }
        });
    }
}
