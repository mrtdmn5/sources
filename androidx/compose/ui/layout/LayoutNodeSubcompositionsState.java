package androidx.compose.ui.layout;

import android.view.ViewGroup;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotIdSet;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeSlotReusePolicy;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.UiApplier;
import androidx.compose.ui.platform.Wrapper_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.common.collect.Platform;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubcomposeLayout.kt */
/* loaded from: classes.dex */
public final class LayoutNodeSubcompositionsState {
    public final String NoIntrinsicsMessage;
    public CompositionContext compositionContext;
    public int currentIndex;
    public Function2<? super SubcomposeIntermediateMeasureScope, ? super Constraints, ? extends MeasureResult> intermediateMeasurePolicy;
    public final IntermediateMeasureScopeImpl intermediateMeasureScope;
    public final LinkedHashMap nodeToNodeState;
    public final LinkedHashMap precomposeMap;
    public int precomposedCount;
    public int reusableCount;
    public final SubcomposeSlotReusePolicy.SlotIdsSet reusableSlotIdsSet;
    public final LayoutNode root;
    public final Scope scope;
    public final LinkedHashMap slotIdToNode;
    public SubcomposeSlotReusePolicy slotReusePolicy;

    /* compiled from: SubcomposeLayout.kt */
    /* loaded from: classes.dex */
    public final class IntermediateMeasureScopeImpl implements SubcomposeIntermediateMeasureScope, MeasureScope {
        public final /* synthetic */ Scope $$delegate_0;
        public Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> lookaheadMeasurePolicy;

        public IntermediateMeasureScopeImpl() {
            this.$$delegate_0 = LayoutNodeSubcompositionsState.this.scope;
            ConstraintsKt.Constraints$default(0, 0, 15);
        }

        @Override // androidx.compose.ui.unit.Density
        public final float getDensity() {
            return this.$$delegate_0.density;
        }

        @Override // androidx.compose.ui.unit.Density
        public final float getFontScale() {
            return this.$$delegate_0.fontScale;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public final LayoutDirection getLayoutDirection() {
            return this.$$delegate_0.layoutDirection;
        }

        @Override // androidx.compose.ui.layout.SubcomposeIntermediateMeasureScope
        public final Function2<SubcomposeMeasureScope, Constraints, MeasureResult> getLookaheadMeasurePolicy() {
            Function2 function2 = this.lookaheadMeasurePolicy;
            if (function2 != null) {
                return function2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("lookaheadMeasurePolicy");
            throw null;
        }

        @Override // androidx.compose.ui.layout.MeasureScope
        public final MeasureResult layout(int r2, int r3, Map<AlignmentLine, Integer> alignmentLines, Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
            Intrinsics.checkNotNullParameter(alignmentLines, "alignmentLines");
            Intrinsics.checkNotNullParameter(placementBlock, "placementBlock");
            return this.$$delegate_0.layout(r2, r3, alignmentLines, placementBlock);
        }

        @Override // androidx.compose.ui.layout.SubcomposeIntermediateMeasureScope
        public final List<Measurable> measurablesForSlot(Object obj) {
            LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.slotIdToNode.get(obj);
            if (layoutNode != null) {
                return layoutNode.getChildMeasurables$ui_release();
            }
            return EmptyList.INSTANCE;
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: roundToPx-0680j_4 */
        public final int mo44roundToPx0680j_4(float f) {
            return this.$$delegate_0.mo44roundToPx0680j_4(f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDp-u2uoSUM */
        public final float mo46toDpu2uoSUM(int r2) {
            return this.$$delegate_0.mo46toDpu2uoSUM(r2);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDpSize-k-rfVVM */
        public final long mo47toDpSizekrfVVM(long j) {
            return this.$$delegate_0.mo47toDpSizekrfVVM(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toPx--R2X_6o */
        public final float mo48toPxR2X_6o(long j) {
            return this.$$delegate_0.mo48toPxR2X_6o(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toPx-0680j_4 */
        public final float mo49toPx0680j_4(float f) {
            return this.$$delegate_0.getDensity() * f;
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSize-XkaWNTQ */
        public final long mo50toSizeXkaWNTQ(long j) {
            return this.$$delegate_0.mo50toSizeXkaWNTQ(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDp-u2uoSUM */
        public final float mo45toDpu2uoSUM(float f) {
            return f / this.$$delegate_0.getDensity();
        }
    }

    /* compiled from: SubcomposeLayout.kt */
    /* loaded from: classes.dex */
    public static final class NodeState {
        public final ParcelableSnapshotMutableState active$delegate;
        public Composition composition;
        public Function2<? super Composer, ? super Integer, Unit> content;
        public boolean forceRecompose;
        public Object slotId;

        public NodeState() {
            throw null;
        }

        public NodeState(Object obj, ComposableLambdaImpl content) {
            Intrinsics.checkNotNullParameter(content, "content");
            this.slotId = obj;
            this.content = content;
            this.composition = null;
            this.active$delegate = Platform.mutableStateOf$default(Boolean.TRUE);
        }
    }

    /* compiled from: SubcomposeLayout.kt */
    /* loaded from: classes.dex */
    public final class Scope implements SubcomposeMeasureScope {
        public float density;
        public float fontScale;
        public LayoutDirection layoutDirection = LayoutDirection.Rtl;

        public Scope() {
        }

        @Override // androidx.compose.ui.unit.Density
        public final float getDensity() {
            return this.density;
        }

        @Override // androidx.compose.ui.unit.Density
        public final float getFontScale() {
            return this.fontScale;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public final LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public final List<Measurable> subcompose(Object obj, Function2<? super Composer, ? super Integer, Unit> content) {
            boolean z;
            boolean z2;
            boolean z3;
            Intrinsics.checkNotNullParameter(content, "content");
            LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = LayoutNodeSubcompositionsState.this;
            layoutNodeSubcompositionsState.getClass();
            layoutNodeSubcompositionsState.makeSureStateIsConsistent();
            LayoutNode layoutNode = layoutNodeSubcompositionsState.root;
            LayoutNode.LayoutState layoutState = layoutNode.layoutDelegate.layoutState;
            LayoutNode.LayoutState layoutState2 = LayoutNode.LayoutState.Measuring;
            if (layoutState != layoutState2 && layoutState != LayoutNode.LayoutState.LayingOut && layoutState != LayoutNode.LayoutState.LookaheadMeasuring && layoutState != LayoutNode.LayoutState.LookaheadLayingOut) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                LinkedHashMap linkedHashMap = layoutNodeSubcompositionsState.slotIdToNode;
                Object obj2 = linkedHashMap.get(obj);
                if (obj2 == null) {
                    obj2 = (LayoutNode) layoutNodeSubcompositionsState.precomposeMap.remove(obj);
                    if (obj2 != null) {
                        int r8 = layoutNodeSubcompositionsState.precomposedCount;
                        if (r8 > 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            layoutNodeSubcompositionsState.precomposedCount = r8 - 1;
                        } else {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                    } else {
                        obj2 = layoutNodeSubcompositionsState.takeNodeFromReusables(obj);
                        if (obj2 == null) {
                            int r7 = layoutNodeSubcompositionsState.currentIndex;
                            LayoutNode layoutNode2 = new LayoutNode(true, 2, 0);
                            layoutNode.ignoreRemeasureRequests = true;
                            layoutNode.insertAt$ui_release(r7, layoutNode2);
                            layoutNode.ignoreRemeasureRequests = false;
                            obj2 = layoutNode2;
                        }
                    }
                    linkedHashMap.put(obj, obj2);
                }
                LayoutNode layoutNode3 = (LayoutNode) obj2;
                int indexOf = layoutNode.getFoldedChildren$ui_release().indexOf(layoutNode3);
                int r82 = layoutNodeSubcompositionsState.currentIndex;
                if (indexOf >= r82) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    if (r82 != indexOf) {
                        layoutNode.ignoreRemeasureRequests = true;
                        layoutNode.move$ui_release(indexOf, r82, 1);
                        layoutNode.ignoreRemeasureRequests = false;
                    }
                    layoutNodeSubcompositionsState.currentIndex++;
                    layoutNodeSubcompositionsState.subcompose(layoutNode3, obj, content);
                    if (layoutState != layoutState2 && layoutState != LayoutNode.LayoutState.LayingOut) {
                        return layoutNode3.getChildLookaheadMeasurables$ui_release();
                    }
                    return layoutNode3.getChildMeasurables$ui_release();
                }
                throw new IllegalArgumentException(("Key \"" + obj + "\" was already used. If you are using LazyColumn/Row please make sure you provide a unique key for each item.").toString());
            }
            throw new IllegalStateException("subcompose can only be used inside the measure or layout blocks".toString());
        }
    }

    public LayoutNodeSubcompositionsState(LayoutNode root, SubcomposeSlotReusePolicy slotReusePolicy) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(slotReusePolicy, "slotReusePolicy");
        this.root = root;
        this.slotReusePolicy = slotReusePolicy;
        this.nodeToNodeState = new LinkedHashMap();
        this.slotIdToNode = new LinkedHashMap();
        this.scope = new Scope();
        this.intermediateMeasureScope = new IntermediateMeasureScopeImpl();
        this.intermediateMeasurePolicy = new Function2<SubcomposeIntermediateMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$intermediateMeasurePolicy$1
            @Override // kotlin.jvm.functions.Function2
            public final MeasureResult invoke(SubcomposeIntermediateMeasureScope subcomposeIntermediateMeasureScope, Constraints constraints) {
                SubcomposeIntermediateMeasureScope subcomposeIntermediateMeasureScope2 = subcomposeIntermediateMeasureScope;
                long j = constraints.value;
                Intrinsics.checkNotNullParameter(subcomposeIntermediateMeasureScope2, "$this$null");
                return subcomposeIntermediateMeasureScope2.getLookaheadMeasurePolicy().invoke(subcomposeIntermediateMeasureScope2, new Constraints(j));
            }
        };
        this.precomposeMap = new LinkedHashMap();
        this.reusableSlotIdsSet = new SubcomposeSlotReusePolicy.SlotIdsSet(0);
        this.NoIntrinsicsMessage = "Asking for intrinsic measurements of SubcomposeLayout layouts is not supported. This includes components that are built on top of SubcomposeLayout, such as lazy lists, BoxWithConstraints, TabRow, etc. To mitigate this:\n- if intrinsic measurements are used to achieve 'match parent' sizing,, consider replacing the parent of the component with a custom layout which controls the order in which children are measured, making intrinsic measurement not needed\n- adding a size modifier to the component, in order to fast return the queried intrinsic measurement.";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void disposeOrReuseStartingFromIndex(int r13) {
        boolean z;
        boolean z2 = false;
        this.reusableCount = 0;
        int size = (this.root.getFoldedChildren$ui_release().size() - this.precomposedCount) - 1;
        if (r13 <= size) {
            this.reusableSlotIdsSet.clear();
            if (r13 <= size) {
                int r3 = r13;
                while (true) {
                    SubcomposeSlotReusePolicy.SlotIdsSet slotIdsSet = this.reusableSlotIdsSet;
                    Object obj = this.nodeToNodeState.get(this.root.getFoldedChildren$ui_release().get(r3));
                    Intrinsics.checkNotNull(obj);
                    slotIdsSet.set.add(((NodeState) obj).slotId);
                    if (r3 == size) {
                        break;
                    } else {
                        r3++;
                    }
                }
            }
            this.slotReusePolicy.getSlotsToRetain(this.reusableSlotIdsSet);
            Snapshot createTransparentSnapshotWithNoParentReadObserver = SnapshotKt.createTransparentSnapshotWithNoParentReadObserver(SnapshotKt.threadSnapshot.get(), null, false);
            try {
                Snapshot makeCurrent = createTransparentSnapshotWithNoParentReadObserver.makeCurrent();
                z = false;
                while (size >= r13) {
                    try {
                        LayoutNode layoutNode = this.root.getFoldedChildren$ui_release().get(size);
                        Object obj2 = this.nodeToNodeState.get(layoutNode);
                        Intrinsics.checkNotNull(obj2);
                        NodeState nodeState = (NodeState) obj2;
                        Object obj3 = nodeState.slotId;
                        if (this.reusableSlotIdsSet.contains(obj3)) {
                            LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate = layoutNode.layoutDelegate.measurePassDelegate;
                            LayoutNode.UsageByParent usageByParent = LayoutNode.UsageByParent.NotUsed;
                            measurePassDelegate.getClass();
                            Intrinsics.checkNotNullParameter(usageByParent, "<set-?>");
                            measurePassDelegate.measuredByParent = usageByParent;
                            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = layoutNode.layoutDelegate.lookaheadPassDelegate;
                            if (lookaheadPassDelegate != null) {
                                lookaheadPassDelegate.measuredByParent = usageByParent;
                            }
                            this.reusableCount++;
                            if (((Boolean) nodeState.active$delegate.getValue()).booleanValue()) {
                                nodeState.active$delegate.setValue(Boolean.FALSE);
                                z = true;
                            }
                        } else {
                            LayoutNode layoutNode2 = this.root;
                            layoutNode2.ignoreRemeasureRequests = true;
                            this.nodeToNodeState.remove(layoutNode);
                            Composition composition = nodeState.composition;
                            if (composition != null) {
                                composition.dispose();
                            }
                            this.root.removeAt$ui_release(size, 1);
                            layoutNode2.ignoreRemeasureRequests = false;
                        }
                        this.slotIdToNode.remove(obj3);
                        size--;
                    } catch (Throwable th) {
                        Snapshot.restoreCurrent(makeCurrent);
                        throw th;
                    }
                }
                Unit unit = Unit.INSTANCE;
                Snapshot.restoreCurrent(makeCurrent);
            } finally {
                createTransparentSnapshotWithNoParentReadObserver.dispose();
            }
        } else {
            z = false;
        }
        if (z) {
            synchronized (SnapshotKt.lock) {
                IdentityArraySet<StateObject> identityArraySet = SnapshotKt.currentGlobalSnapshot.get().modified;
                if (identityArraySet != null) {
                    if (identityArraySet.isNotEmpty()) {
                        z2 = true;
                    }
                }
            }
            if (z2) {
                SnapshotKt.advanceGlobalSnapshot(new Function1<SnapshotIdSet, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$advanceGlobalSnapshot$3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(SnapshotIdSet snapshotIdSet) {
                        SnapshotIdSet it = snapshotIdSet;
                        Intrinsics.checkNotNullParameter(it, "it");
                        return Unit.INSTANCE;
                    }
                });
            }
        }
        makeSureStateIsConsistent();
    }

    public final void makeSureStateIsConsistent() {
        boolean z;
        boolean z2;
        LinkedHashMap linkedHashMap = this.nodeToNodeState;
        int size = linkedHashMap.size();
        LayoutNode layoutNode = this.root;
        boolean z3 = true;
        if (size == layoutNode.getFoldedChildren$ui_release().size()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if ((layoutNode.getFoldedChildren$ui_release().size() - this.reusableCount) - this.precomposedCount >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                LinkedHashMap linkedHashMap2 = this.precomposeMap;
                if (linkedHashMap2.size() != this.precomposedCount) {
                    z3 = false;
                }
                if (z3) {
                    return;
                }
                throw new IllegalArgumentException(("Incorrect state. Precomposed children " + this.precomposedCount + ". Map size " + linkedHashMap2.size()).toString());
            }
            throw new IllegalArgumentException(("Incorrect state. Total children " + layoutNode.getFoldedChildren$ui_release().size() + ". Reusable children " + this.reusableCount + ". Precomposed children " + this.precomposedCount).toString());
        }
        throw new IllegalArgumentException(("Inconsistency between the count of nodes tracked by the state (" + linkedHashMap.size() + ") and the children count on the SubcomposeLayout (" + layoutNode.getFoldedChildren$ui_release().size() + "). Are you trying to use the state of the disposed SubcomposeLayout?").toString());
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [androidx.compose.ui.layout.LayoutNodeSubcompositionsState$subcompose$3$1$1, kotlin.jvm.internal.Lambda] */
    public final void subcompose(LayoutNode layoutNode, Object obj, Function2<? super Composer, ? super Integer, Unit> function2) {
        boolean z;
        LinkedHashMap linkedHashMap = this.nodeToNodeState;
        Object obj2 = linkedHashMap.get(layoutNode);
        if (obj2 == null) {
            obj2 = new NodeState(obj, ComposableSingletons$SubcomposeLayoutKt.f10lambda1);
            linkedHashMap.put(layoutNode, obj2);
        }
        final NodeState nodeState = (NodeState) obj2;
        Composition composition = nodeState.composition;
        if (composition != null) {
            z = composition.getHasInvalidations();
        } else {
            z = true;
        }
        if (nodeState.content != function2 || z || nodeState.forceRecompose) {
            Intrinsics.checkNotNullParameter(function2, "<set-?>");
            nodeState.content = function2;
            Snapshot createTransparentSnapshotWithNoParentReadObserver = SnapshotKt.createTransparentSnapshotWithNoParentReadObserver(SnapshotKt.threadSnapshot.get(), null, false);
            try {
                Snapshot makeCurrent = createTransparentSnapshotWithNoParentReadObserver.makeCurrent();
                try {
                    LayoutNode layoutNode2 = this.root;
                    layoutNode2.ignoreRemeasureRequests = true;
                    final Function2<? super Composer, ? super Integer, Unit> function22 = nodeState.content;
                    Composition composition2 = nodeState.composition;
                    CompositionContext compositionContext = this.compositionContext;
                    if (compositionContext != null) {
                        ComposableLambdaImpl composableLambdaInstance = ComposableLambdaKt.composableLambdaInstance(-34810602, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$subcompose$3$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(Composer composer, Integer num) {
                                Composer composer2 = composer;
                                if ((num.intValue() & 11) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                } else {
                                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                                    boolean booleanValue = ((Boolean) LayoutNodeSubcompositionsState.NodeState.this.active$delegate.getValue()).booleanValue();
                                    composer2.startReusableGroup(Boolean.valueOf(booleanValue));
                                    boolean changed = composer2.changed(booleanValue);
                                    if (booleanValue) {
                                        function22.invoke(composer2, 0);
                                    } else {
                                        composer2.deactivateToEndGroup(changed);
                                    }
                                    composer2.endReusableGroup();
                                }
                                return Unit.INSTANCE;
                            }
                        }, true);
                        if (composition2 == null || composition2.isDisposed()) {
                            ViewGroup.LayoutParams layoutParams = Wrapper_androidKt.DefaultLayoutParams;
                            composition2 = CompositionKt.Composition(new UiApplier(layoutNode), compositionContext);
                        }
                        composition2.setContent(composableLambdaInstance);
                        nodeState.composition = composition2;
                        layoutNode2.ignoreRemeasureRequests = false;
                        Unit unit = Unit.INSTANCE;
                        createTransparentSnapshotWithNoParentReadObserver.dispose();
                        nodeState.forceRecompose = false;
                        return;
                    }
                    throw new IllegalStateException("parent composition reference not set".toString());
                } finally {
                    Snapshot.restoreCurrent(makeCurrent);
                }
            } catch (Throwable th) {
                createTransparentSnapshotWithNoParentReadObserver.dispose();
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b8, code lost:            if (r2.isNotEmpty() == true) goto L79;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.compose.ui.node.LayoutNode takeNodeFromReusables(java.lang.Object r10) {
        /*
            r9 = this;
            int r0 = r9.reusableCount
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            androidx.compose.ui.node.LayoutNode r0 = r9.root
            java.util.List r0 = r0.getFoldedChildren$ui_release()
            int r0 = r0.size()
            int r2 = r9.precomposedCount
            int r0 = r0 - r2
            int r2 = r9.reusableCount
            int r2 = r0 - r2
            r3 = 1
            int r0 = r0 - r3
            r4 = r0
        L1a:
            r5 = -1
            if (r4 < r2) goto L41
            androidx.compose.ui.node.LayoutNode r6 = r9.root
            java.util.List r6 = r6.getFoldedChildren$ui_release()
            java.lang.Object r6 = r6.get(r4)
            androidx.compose.ui.node.LayoutNode r6 = (androidx.compose.ui.node.LayoutNode) r6
            java.util.LinkedHashMap r7 = r9.nodeToNodeState
            java.lang.Object r6 = r7.get(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            androidx.compose.ui.layout.LayoutNodeSubcompositionsState$NodeState r6 = (androidx.compose.ui.layout.LayoutNodeSubcompositionsState.NodeState) r6
            java.lang.Object r6 = r6.slotId
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r10)
            if (r6 == 0) goto L3e
            r6 = r4
            goto L42
        L3e:
            int r4 = r4 + (-1)
            goto L1a
        L41:
            r6 = r5
        L42:
            if (r6 != r5) goto L70
        L44:
            if (r0 < r2) goto L6f
            androidx.compose.ui.node.LayoutNode r4 = r9.root
            java.util.List r4 = r4.getFoldedChildren$ui_release()
            java.lang.Object r4 = r4.get(r0)
            androidx.compose.ui.node.LayoutNode r4 = (androidx.compose.ui.node.LayoutNode) r4
            java.util.LinkedHashMap r7 = r9.nodeToNodeState
            java.lang.Object r4 = r7.get(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            androidx.compose.ui.layout.LayoutNodeSubcompositionsState$NodeState r4 = (androidx.compose.ui.layout.LayoutNodeSubcompositionsState.NodeState) r4
            androidx.compose.ui.layout.SubcomposeSlotReusePolicy r7 = r9.slotReusePolicy
            java.lang.Object r8 = r4.slotId
            boolean r7 = r7.areCompatible(r10, r8)
            if (r7 == 0) goto L6c
            r4.slotId = r10
            r4 = r0
            r6 = r4
            goto L70
        L6c:
            int r0 = r0 + (-1)
            goto L44
        L6f:
            r4 = r0
        L70:
            if (r6 != r5) goto L73
            goto Lc2
        L73:
            r10 = 0
            if (r4 == r2) goto L7f
            androidx.compose.ui.node.LayoutNode r0 = r9.root
            r0.ignoreRemeasureRequests = r3
            r0.move$ui_release(r4, r2, r3)
            r0.ignoreRemeasureRequests = r10
        L7f:
            int r0 = r9.reusableCount
            int r0 = r0 + r5
            r9.reusableCount = r0
            androidx.compose.ui.node.LayoutNode r0 = r9.root
            java.util.List r0 = r0.getFoldedChildren$ui_release()
            java.lang.Object r0 = r0.get(r2)
            r1 = r0
            androidx.compose.ui.node.LayoutNode r1 = (androidx.compose.ui.node.LayoutNode) r1
            java.util.LinkedHashMap r0 = r9.nodeToNodeState
            java.lang.Object r0 = r0.get(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            androidx.compose.ui.layout.LayoutNodeSubcompositionsState$NodeState r0 = (androidx.compose.ui.layout.LayoutNodeSubcompositionsState.NodeState) r0
            androidx.compose.runtime.ParcelableSnapshotMutableState r2 = r0.active$delegate
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            r2.setValue(r4)
            r0.forceRecompose = r3
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotKt.lock
            monitor-enter(r0)
            java.util.concurrent.atomic.AtomicReference<androidx.compose.runtime.snapshots.GlobalSnapshot> r2 = androidx.compose.runtime.snapshots.SnapshotKt.currentGlobalSnapshot     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object r2 = r2.get()     // Catch: java.lang.Throwable -> Lc3
            androidx.compose.runtime.snapshots.GlobalSnapshot r2 = (androidx.compose.runtime.snapshots.GlobalSnapshot) r2     // Catch: java.lang.Throwable -> Lc3
            androidx.compose.runtime.collection.IdentityArraySet<androidx.compose.runtime.snapshots.StateObject> r2 = r2.modified     // Catch: java.lang.Throwable -> Lc3
            if (r2 == 0) goto Lbb
            boolean r2 = r2.isNotEmpty()     // Catch: java.lang.Throwable -> Lc3
            if (r2 != r3) goto Lbb
            goto Lbc
        Lbb:
            r3 = r10
        Lbc:
            monitor-exit(r0)
            if (r3 == 0) goto Lc2
            androidx.compose.runtime.snapshots.SnapshotKt.access$advanceGlobalSnapshot()
        Lc2:
            return r1
        Lc3:
            r10 = move-exception
            monitor-exit(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.LayoutNodeSubcompositionsState.takeNodeFromReusables(java.lang.Object):androidx.compose.ui.node.LayoutNode");
    }
}
