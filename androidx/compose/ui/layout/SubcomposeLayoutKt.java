package androidx.compose.ui.layout;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.unit.Constraints;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubcomposeLayout.kt */
/* loaded from: classes.dex */
public final class SubcomposeLayoutKt {
    public static final void SubcomposeLayout(final Modifier modifier, final Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> measurePolicy, Composer composer, final int r10, final int r11) {
        int r1;
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1298353104);
        int r0 = r11 & 1;
        if (r0 != 0) {
            r1 = r10 | 6;
        } else if ((r10 & 14) == 0) {
            r1 = (startRestartGroup.changed(modifier) ? 4 : 2) | r10;
        } else {
            r1 = r10;
        }
        if ((r11 & 2) != 0) {
            r1 |= 48;
        } else if ((r10 & 112) == 0) {
            r1 |= startRestartGroup.changedInstance(measurePolicy) ? 32 : 16;
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
            if (nextSlot == Composer.Companion.Empty) {
                nextSlot = new SubcomposeLayoutState();
                startRestartGroup.updateValue(nextSlot);
            }
            startRestartGroup.end(false);
            int r12 = r1 << 3;
            SubcomposeLayout((SubcomposeLayoutState) nextSlot, modifier, measurePolicy, startRestartGroup, (r12 & 112) | 8 | (r12 & 896), 0);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                int updateChangedFlags = Strings.updateChangedFlags(r10 | 1);
                SubcomposeLayoutKt.SubcomposeLayout(Modifier.this, measurePolicy, composer2, updateChangedFlags, r11);
                return Unit.INSTANCE;
            }
        };
    }

    public static final void SubcomposeLayout(final SubcomposeLayoutState state, Modifier modifier, final Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> measurePolicy, Composer composer, final int r12, final int r13) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-511989831);
        if ((r13 & 2) != 0) {
            modifier = Modifier.Companion.$$INSTANCE;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        SubcomposeLayout(state, modifier, new Function2<SubcomposeIntermediateMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$6
            @Override // kotlin.jvm.functions.Function2
            public final MeasureResult invoke(SubcomposeIntermediateMeasureScope subcomposeIntermediateMeasureScope, Constraints constraints) {
                SubcomposeIntermediateMeasureScope SubcomposeLayout = subcomposeIntermediateMeasureScope;
                long j = constraints.value;
                Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                return SubcomposeLayout.getLookaheadMeasurePolicy().invoke(SubcomposeLayout, new Constraints(j));
            }
        }, measurePolicy, startRestartGroup, (r12 & 112) | 392 | ((r12 << 3) & 7168), 0);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier2 = modifier;
        endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                SubcomposeLayoutKt.SubcomposeLayout(SubcomposeLayoutState.this, modifier2, measurePolicy, composer2, Strings.updateChangedFlags(r12 | 1), r13);
                return Unit.INSTANCE;
            }
        };
    }

    public static final void SubcomposeLayout(final SubcomposeLayoutState state, Modifier modifier, Function2<? super SubcomposeIntermediateMeasureScope, ? super Constraints, ? extends MeasureResult> function2, final Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> measurePolicy, Composer composer, final int r12, final int r13) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        ComposerImpl startRestartGroup = composer.startRestartGroup(2129414763);
        if ((r13 & 2) != 0) {
            modifier = Modifier.Companion.$$INSTANCE;
        }
        final Modifier modifier2 = modifier;
        if ((r13 & 4) != 0) {
            function2 = new Function2<SubcomposeIntermediateMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$8
                @Override // kotlin.jvm.functions.Function2
                public final MeasureResult invoke(SubcomposeIntermediateMeasureScope subcomposeIntermediateMeasureScope, Constraints constraints) {
                    SubcomposeIntermediateMeasureScope subcomposeIntermediateMeasureScope2 = subcomposeIntermediateMeasureScope;
                    long j = constraints.value;
                    Intrinsics.checkNotNullParameter(subcomposeIntermediateMeasureScope2, "$this$null");
                    return subcomposeIntermediateMeasureScope2.getLookaheadMeasurePolicy().invoke(subcomposeIntermediateMeasureScope2, new Constraints(j));
                }
            };
        }
        final Function2<? super SubcomposeIntermediateMeasureScope, ? super Constraints, ? extends MeasureResult> function22 = function2;
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        CompositionContext rememberCompositionContext = ComposablesKt.rememberCompositionContext(startRestartGroup);
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier2);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        final LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = LayoutNode.Constructor;
        startRestartGroup.startReplaceableGroup(1886828752);
        if (startRestartGroup.applier instanceof Applier) {
            startRestartGroup.startNode();
            if (startRestartGroup.inserting) {
                startRestartGroup.createNode(new Function0<LayoutNode>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$$inlined$ComposeNode$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.node.LayoutNode, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function0
                    public final LayoutNode invoke() {
                        return layoutNode$Companion$Constructor$1.invoke();
                    }
                });
            } else {
                startRestartGroup.useNode();
            }
            Updater.m228setimpl(startRestartGroup, state, state.setRoot);
            Updater.m228setimpl(startRestartGroup, rememberCompositionContext, state.setCompositionContext);
            Updater.m228setimpl(startRestartGroup, measurePolicy, state.setMeasurePolicy);
            Updater.m228setimpl(startRestartGroup, function22, state.setIntermediateMeasurePolicy);
            ComposeUiNode.Companion.getClass();
            Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Updater.m228setimpl(startRestartGroup, materializeModifier, ComposeUiNode.Companion.SetModifier);
            ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
            if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
            }
            startRestartGroup.end(true);
            startRestartGroup.end(false);
            startRestartGroup.startReplaceableGroup(-607836798);
            if (!startRestartGroup.getSkipping()) {
                EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$10
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        LayoutNodeSubcompositionsState state2 = SubcomposeLayoutState.this.getState();
                        Iterator it = state2.nodeToNodeState.entrySet().iterator();
                        while (it.hasNext()) {
                            ((LayoutNodeSubcompositionsState.NodeState) ((Map.Entry) it.next()).getValue()).forceRecompose = true;
                        }
                        LayoutNode layoutNode = state2.root;
                        if (!layoutNode.layoutDelegate.measurePending) {
                            LayoutNode.requestRemeasure$ui_release$default(layoutNode, false, 3);
                        }
                        return Unit.INSTANCE;
                    }
                }, startRestartGroup);
            }
            startRestartGroup.end(false);
            final MutableState rememberUpdatedState = Platform.rememberUpdatedState(state, startRestartGroup);
            Unit unit = Unit.INSTANCE;
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed = startRestartGroup.changed(rememberUpdatedState);
            Object nextSlot = startRestartGroup.nextSlot();
            if (changed || nextSlot == Composer.Companion.Empty) {
                nextSlot = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$11$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        DisposableEffectScope DisposableEffect = disposableEffectScope;
                        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                        final State<SubcomposeLayoutState> state2 = rememberUpdatedState;
                        return new DisposableEffectResult() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$11$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public final void dispose() {
                                LayoutNodeSubcompositionsState state3 = ((SubcomposeLayoutState) State.this.getValue()).getState();
                                LayoutNode layoutNode = state3.root;
                                layoutNode.ignoreRemeasureRequests = true;
                                LinkedHashMap linkedHashMap = state3.nodeToNodeState;
                                Iterator it = linkedHashMap.values().iterator();
                                while (it.hasNext()) {
                                    Composition composition = ((LayoutNodeSubcompositionsState.NodeState) it.next()).composition;
                                    if (composition != null) {
                                        composition.dispose();
                                    }
                                }
                                layoutNode.removeAll$ui_release();
                                layoutNode.ignoreRemeasureRequests = false;
                                linkedHashMap.clear();
                                state3.slotIdToNode.clear();
                                state3.precomposedCount = 0;
                                state3.reusableCount = 0;
                                state3.precomposeMap.clear();
                                state3.makeSureStateIsConsistent();
                            }
                        };
                    }
                };
                startRestartGroup.updateValue(nextSlot);
            }
            startRestartGroup.end(false);
            EffectsKt.DisposableEffect(unit, (Function1) nextSlot, startRestartGroup);
            RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$12
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    SubcomposeLayoutKt.SubcomposeLayout(SubcomposeLayoutState.this, modifier2, function22, measurePolicy, composer2, Strings.updateChangedFlags(r12 | 1), r13);
                    return Unit.INSTANCE;
                }
            };
            return;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }
}
