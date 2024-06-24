package androidx.compose.ui.layout;

import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubcomposeLayout.kt */
/* loaded from: classes.dex */
public final class SubcomposeLayoutState {
    public LayoutNodeSubcompositionsState _state;
    public final SubcomposeLayoutState$setCompositionContext$1 setCompositionContext;
    public final SubcomposeLayoutState$setIntermediateMeasurePolicy$1 setIntermediateMeasurePolicy;
    public final SubcomposeLayoutState$setMeasurePolicy$1 setMeasurePolicy;
    public final SubcomposeLayoutState$setRoot$1 setRoot;
    public final SubcomposeSlotReusePolicy slotReusePolicy;

    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.compose.ui.layout.SubcomposeLayoutState$setRoot$1] */
    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.compose.ui.layout.SubcomposeLayoutState$setCompositionContext$1] */
    /* JADX WARN: Type inference failed for: r1v3, types: [androidx.compose.ui.layout.SubcomposeLayoutState$setMeasurePolicy$1] */
    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.ui.layout.SubcomposeLayoutState$setIntermediateMeasurePolicy$1] */
    public SubcomposeLayoutState(SubcomposeSlotReusePolicy subcomposeSlotReusePolicy) {
        this.slotReusePolicy = subcomposeSlotReusePolicy;
        this.setRoot = new Function2<LayoutNode, SubcomposeLayoutState, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutState$setRoot$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(LayoutNode layoutNode, SubcomposeLayoutState subcomposeLayoutState) {
                LayoutNode layoutNode2 = layoutNode;
                SubcomposeLayoutState it = subcomposeLayoutState;
                Intrinsics.checkNotNullParameter(layoutNode2, "$this$null");
                Intrinsics.checkNotNullParameter(it, "it");
                LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = layoutNode2.subcompositionsState;
                SubcomposeLayoutState subcomposeLayoutState2 = SubcomposeLayoutState.this;
                if (layoutNodeSubcompositionsState == null) {
                    layoutNodeSubcompositionsState = new LayoutNodeSubcompositionsState(layoutNode2, subcomposeLayoutState2.slotReusePolicy);
                    layoutNode2.subcompositionsState = layoutNodeSubcompositionsState;
                }
                subcomposeLayoutState2._state = layoutNodeSubcompositionsState;
                subcomposeLayoutState2.getState().makeSureStateIsConsistent();
                LayoutNodeSubcompositionsState state = subcomposeLayoutState2.getState();
                SubcomposeSlotReusePolicy value = subcomposeLayoutState2.slotReusePolicy;
                Intrinsics.checkNotNullParameter(value, "value");
                if (state.slotReusePolicy != value) {
                    state.slotReusePolicy = value;
                    state.disposeOrReuseStartingFromIndex(0);
                }
                return Unit.INSTANCE;
            }
        };
        this.setCompositionContext = new Function2<LayoutNode, CompositionContext, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutState$setCompositionContext$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(LayoutNode layoutNode, CompositionContext compositionContext) {
                CompositionContext it = compositionContext;
                Intrinsics.checkNotNullParameter(layoutNode, "$this$null");
                Intrinsics.checkNotNullParameter(it, "it");
                SubcomposeLayoutState.this.getState().compositionContext = it;
                return Unit.INSTANCE;
            }
        };
        this.setMeasurePolicy = new Function2<LayoutNode, Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult>, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutState$setMeasurePolicy$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(LayoutNode layoutNode, Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> function2) {
                LayoutNode layoutNode2 = layoutNode;
                final Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> it = function2;
                Intrinsics.checkNotNullParameter(layoutNode2, "$this$null");
                Intrinsics.checkNotNullParameter(it, "it");
                final LayoutNodeSubcompositionsState state = SubcomposeLayoutState.this.getState();
                LayoutNodeSubcompositionsState.IntermediateMeasureScopeImpl intermediateMeasureScopeImpl = state.intermediateMeasureScope;
                intermediateMeasureScopeImpl.getClass();
                intermediateMeasureScopeImpl.lookaheadMeasurePolicy = it;
                layoutNode2.setMeasurePolicy(new LayoutNode.NoIntrinsicsMeasurePolicy(state.NoIntrinsicsMessage) { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo4measure3p2s80s(MeasureScope measure, List<? extends Measurable> measurables, long j) {
                        boolean z;
                        Intrinsics.checkNotNullParameter(measure, "$this$measure");
                        Intrinsics.checkNotNullParameter(measurables, "measurables");
                        final LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = LayoutNodeSubcompositionsState.this;
                        LayoutNodeSubcompositionsState.Scope scope = layoutNodeSubcompositionsState.scope;
                        LayoutDirection layoutDirection = measure.getLayoutDirection();
                        scope.getClass();
                        Intrinsics.checkNotNullParameter(layoutDirection, "<set-?>");
                        scope.layoutDirection = layoutDirection;
                        layoutNodeSubcompositionsState.scope.density = measure.getDensity();
                        layoutNodeSubcompositionsState.scope.fontScale = measure.getFontScale();
                        LayoutNode layoutNode3 = layoutNodeSubcompositionsState.root;
                        LayoutNode.LayoutState layoutState = layoutNode3.layoutDelegate.layoutState;
                        if ((layoutState == LayoutNode.LayoutState.Measuring || layoutState == LayoutNode.LayoutState.LayingOut) && layoutNode3.lookaheadRoot != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            return layoutNodeSubcompositionsState.intermediateMeasurePolicy.invoke(layoutNodeSubcompositionsState.intermediateMeasureScope, new Constraints(j));
                        }
                        layoutNodeSubcompositionsState.currentIndex = 0;
                        layoutNodeSubcompositionsState.intermediateMeasureScope.getClass();
                        final MeasureResult invoke = it.invoke(layoutNodeSubcompositionsState.scope, new Constraints(j));
                        final int r6 = layoutNodeSubcompositionsState.currentIndex;
                        LayoutNodeSubcompositionsState.IntermediateMeasureScopeImpl intermediateMeasureScopeImpl2 = layoutNodeSubcompositionsState.intermediateMeasureScope;
                        invoke.getWidth();
                        invoke.getHeight();
                        intermediateMeasureScopeImpl2.getClass();
                        return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure$1
                            @Override // androidx.compose.ui.layout.MeasureResult
                            public final Map<AlignmentLine, Integer> getAlignmentLines() {
                                return MeasureResult.this.getAlignmentLines();
                            }

                            @Override // androidx.compose.ui.layout.MeasureResult
                            public final int getHeight() {
                                return MeasureResult.this.getHeight();
                            }

                            @Override // androidx.compose.ui.layout.MeasureResult
                            public final int getWidth() {
                                return MeasureResult.this.getWidth();
                            }

                            @Override // androidx.compose.ui.layout.MeasureResult
                            public final void placeChildren() {
                                LayoutNodeSubcompositionsState layoutNodeSubcompositionsState2 = layoutNodeSubcompositionsState;
                                layoutNodeSubcompositionsState2.currentIndex = r6;
                                MeasureResult.this.placeChildren();
                                layoutNodeSubcompositionsState2.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState2.currentIndex);
                            }
                        };
                    }
                });
                return Unit.INSTANCE;
            }
        };
        this.setIntermediateMeasurePolicy = new Function2<LayoutNode, Function2<? super SubcomposeIntermediateMeasureScope, ? super Constraints, ? extends MeasureResult>, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutState$setIntermediateMeasurePolicy$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(LayoutNode layoutNode, Function2<? super SubcomposeIntermediateMeasureScope, ? super Constraints, ? extends MeasureResult> function2) {
                Function2<? super SubcomposeIntermediateMeasureScope, ? super Constraints, ? extends MeasureResult> it = function2;
                Intrinsics.checkNotNullParameter(layoutNode, "$this$null");
                Intrinsics.checkNotNullParameter(it, "it");
                SubcomposeLayoutState.this.getState().intermediateMeasurePolicy = it;
                return Unit.INSTANCE;
            }
        };
    }

    public final LayoutNodeSubcompositionsState getState() {
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this._state;
        if (layoutNodeSubcompositionsState != null) {
            return layoutNodeSubcompositionsState;
        }
        throw new IllegalArgumentException("SubcomposeLayoutState is not attached to SubcomposeLayout".toString());
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [androidx.compose.ui.layout.LayoutNodeSubcompositionsState$precompose$1] */
    public final LayoutNodeSubcompositionsState$precompose$1 precompose(final Object obj, Function2 function2) {
        final LayoutNodeSubcompositionsState state = getState();
        state.makeSureStateIsConsistent();
        if (!state.slotIdToNode.containsKey(obj)) {
            LinkedHashMap linkedHashMap = state.precomposeMap;
            Object obj2 = linkedHashMap.get(obj);
            if (obj2 == null) {
                obj2 = state.takeNodeFromReusables(obj);
                LayoutNode layoutNode = state.root;
                if (obj2 != null) {
                    int indexOf = layoutNode.getFoldedChildren$ui_release().indexOf(obj2);
                    int size = layoutNode.getFoldedChildren$ui_release().size();
                    layoutNode.ignoreRemeasureRequests = true;
                    layoutNode.move$ui_release(indexOf, size, 1);
                    layoutNode.ignoreRemeasureRequests = false;
                    state.precomposedCount++;
                } else {
                    int size2 = layoutNode.getFoldedChildren$ui_release().size();
                    LayoutNode layoutNode2 = new LayoutNode(true, 2, 0);
                    layoutNode.ignoreRemeasureRequests = true;
                    layoutNode.insertAt$ui_release(size2, layoutNode2);
                    layoutNode.ignoreRemeasureRequests = false;
                    state.precomposedCount++;
                    obj2 = layoutNode2;
                }
                linkedHashMap.put(obj, obj2);
            }
            state.subcompose((LayoutNode) obj2, obj, function2);
        }
        return new PrecomposedSlotHandle() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$precompose$1
            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            public final void dispose() {
                boolean z;
                boolean z2;
                LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = LayoutNodeSubcompositionsState.this;
                layoutNodeSubcompositionsState.makeSureStateIsConsistent();
                LayoutNode layoutNode3 = (LayoutNode) layoutNodeSubcompositionsState.precomposeMap.remove(obj);
                if (layoutNode3 != null) {
                    if (layoutNodeSubcompositionsState.precomposedCount > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        LayoutNode layoutNode4 = layoutNodeSubcompositionsState.root;
                        int indexOf2 = layoutNode4.getFoldedChildren$ui_release().indexOf(layoutNode3);
                        int size3 = layoutNode4.getFoldedChildren$ui_release().size();
                        int r7 = layoutNodeSubcompositionsState.precomposedCount;
                        if (indexOf2 >= size3 - r7) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            layoutNodeSubcompositionsState.reusableCount++;
                            layoutNodeSubcompositionsState.precomposedCount = r7 - 1;
                            int size4 = (layoutNode4.getFoldedChildren$ui_release().size() - layoutNodeSubcompositionsState.precomposedCount) - layoutNodeSubcompositionsState.reusableCount;
                            layoutNode4.ignoreRemeasureRequests = true;
                            layoutNode4.move$ui_release(indexOf2, size4, 1);
                            layoutNode4.ignoreRemeasureRequests = false;
                            layoutNodeSubcompositionsState.disposeOrReuseStartingFromIndex(size4);
                            return;
                        }
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            public final int getPlaceablesCount() {
                LayoutNode layoutNode3 = (LayoutNode) LayoutNodeSubcompositionsState.this.precomposeMap.get(obj);
                if (layoutNode3 != null) {
                    return layoutNode3.getChildren$ui_release().size();
                }
                return 0;
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            /* renamed from: premeasure-0kLqBqw, reason: not valid java name */
            public final void mo428premeasure0kLqBqw(int r5, long j) {
                LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = LayoutNodeSubcompositionsState.this;
                LayoutNode layoutNode3 = (LayoutNode) layoutNodeSubcompositionsState.precomposeMap.get(obj);
                if (layoutNode3 != null && layoutNode3.isAttached()) {
                    int size3 = layoutNode3.getChildren$ui_release().size();
                    if (r5 >= 0 && r5 < size3) {
                        if (!layoutNode3.isPlaced()) {
                            LayoutNode layoutNode4 = layoutNodeSubcompositionsState.root;
                            layoutNode4.ignoreRemeasureRequests = true;
                            LayoutNodeKt.requireOwner(layoutNode3).mo484measureAndLayout0kLqBqw(layoutNode3.getChildren$ui_release().get(r5), j);
                            layoutNode4.ignoreRemeasureRequests = false;
                            return;
                        }
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    throw new IndexOutOfBoundsException("Index (" + r5 + ") is out of bound of [0, " + size3 + ')');
                }
            }
        };
    }

    public SubcomposeLayoutState() {
        this(NoOpSubcomposeSlotReusePolicy.INSTANCE);
    }

    /* compiled from: SubcomposeLayout.kt */
    /* loaded from: classes.dex */
    public interface PrecomposedSlotHandle {
        void dispose();

        default int getPlaceablesCount() {
            return 0;
        }

        /* renamed from: premeasure-0kLqBqw */
        default void mo428premeasure0kLqBqw(int r1, long j) {
        }
    }
}
