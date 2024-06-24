package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidComposeView$resendMotionEventOnLayout$1;
import androidx.compose.ui.unit.Constraints;
import java.util.Arrays;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MeasureAndLayoutDelegate.kt */
/* loaded from: classes.dex */
public final class MeasureAndLayoutDelegate {
    public boolean duringMeasureLayout;
    public final long measureIteration;
    public final MutableVector<Owner.OnLayoutCompletedListener> onLayoutCompletedListeners;
    public final OnPositionedDispatcher onPositionedDispatcher;
    public final MutableVector<PostponedRequest> postponedMeasureRequests;
    public final DepthSortedSetsForDifferentPasses relayoutNodes;
    public final LayoutNode root;
    public Constraints rootConstraints;

    /* compiled from: MeasureAndLayoutDelegate.kt */
    /* loaded from: classes.dex */
    public static final class PostponedRequest {
        public final boolean isForced;
        public final boolean isLookahead;
        public final LayoutNode node;

        public PostponedRequest(LayoutNode node, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(node, "node");
            this.node = node;
            this.isLookahead = z;
            this.isForced = z2;
        }
    }

    /* compiled from: MeasureAndLayoutDelegate.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[LayoutNode.LayoutState.values().length];
            try {
                r0[LayoutNode.LayoutState.LookaheadMeasuring.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[LayoutNode.LayoutState.Measuring.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[LayoutNode.LayoutState.LookaheadLayingOut.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[LayoutNode.LayoutState.LayingOut.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[LayoutNode.LayoutState.Idle.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public MeasureAndLayoutDelegate(LayoutNode root) {
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        this.relayoutNodes = new DepthSortedSetsForDifferentPasses();
        this.onPositionedDispatcher = new OnPositionedDispatcher();
        this.onLayoutCompletedListeners = new MutableVector<>(new Owner.OnLayoutCompletedListener[16]);
        this.measureIteration = 1L;
        this.postponedMeasureRequests = new MutableVector<>(new PostponedRequest[16]);
    }

    public static boolean getCanAffectParentInLookahead(LayoutNode layoutNode) {
        boolean z;
        LookaheadAlignmentLines lookaheadAlignmentLines;
        if (!layoutNode.layoutDelegate.lookaheadMeasurePending) {
            return false;
        }
        if (layoutNode.getMeasuredByParentInLookahead$ui_release() != LayoutNode.UsageByParent.InMeasureBlock) {
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = layoutNode.layoutDelegate.lookaheadPassDelegate;
            if (lookaheadPassDelegate != null && (lookaheadAlignmentLines = lookaheadPassDelegate.alignmentLines) != null && lookaheadAlignmentLines.getRequired$ui_release()) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public final void dispatchOnPositionedCallbacks(boolean z) {
        OnPositionedDispatcher onPositionedDispatcher = this.onPositionedDispatcher;
        if (z) {
            onPositionedDispatcher.getClass();
            LayoutNode rootNode = this.root;
            Intrinsics.checkNotNullParameter(rootNode, "rootNode");
            MutableVector<LayoutNode> mutableVector = onPositionedDispatcher.layoutNodes;
            mutableVector.clear();
            mutableVector.add(rootNode);
            rootNode.needsOnPositionedDispatch = true;
        }
        OnPositionedDispatcher$Companion$DepthComparator onPositionedDispatcher$Companion$DepthComparator = OnPositionedDispatcher$Companion$DepthComparator.INSTANCE;
        MutableVector<LayoutNode> mutableVector2 = onPositionedDispatcher.layoutNodes;
        mutableVector2.getClass();
        LayoutNode[] layoutNodeArr = mutableVector2.content;
        int r2 = mutableVector2.size;
        Intrinsics.checkNotNullParameter(layoutNodeArr, "<this>");
        Arrays.sort(layoutNodeArr, 0, r2, onPositionedDispatcher$Companion$DepthComparator);
        int r5 = mutableVector2.size;
        if (r5 > 0) {
            int r52 = r5 - 1;
            LayoutNode[] layoutNodeArr2 = mutableVector2.content;
            do {
                LayoutNode layoutNode = layoutNodeArr2[r52];
                if (layoutNode.needsOnPositionedDispatch) {
                    OnPositionedDispatcher.dispatchHierarchy(layoutNode);
                }
                r52--;
            } while (r52 >= 0);
        }
        mutableVector2.clear();
    }

    /* renamed from: doLookaheadRemeasure-sdFAvZA */
    public final boolean m456doLookaheadRemeasuresdFAvZA(LayoutNode layoutNode, Constraints constraints) {
        Constraints constraints2;
        boolean m451remeasureBRTryo0;
        LayoutNode layoutNode2 = layoutNode.lookaheadRoot;
        if (layoutNode2 == null) {
            return false;
        }
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate;
        if (constraints != null) {
            if (layoutNode2 != null) {
                LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
                Intrinsics.checkNotNull(lookaheadPassDelegate);
                m451remeasureBRTryo0 = lookaheadPassDelegate.m451remeasureBRTryo0(constraints.value);
            }
            m451remeasureBRTryo0 = false;
        } else {
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate2 = layoutNodeLayoutDelegate.lookaheadPassDelegate;
            if (lookaheadPassDelegate2 != null) {
                constraints2 = lookaheadPassDelegate2.lookaheadConstraints;
            } else {
                constraints2 = null;
            }
            if (constraints2 != null && layoutNode2 != null) {
                Intrinsics.checkNotNull(lookaheadPassDelegate2);
                m451remeasureBRTryo0 = lookaheadPassDelegate2.m451remeasureBRTryo0(constraints2.value);
            }
            m451remeasureBRTryo0 = false;
        }
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        if (m451remeasureBRTryo0 && parent$ui_release != null) {
            if (parent$ui_release.lookaheadRoot == null) {
                requestRemeasure(parent$ui_release, false);
            } else if (layoutNode.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                requestLookaheadRemeasure(parent$ui_release, false);
            } else if (layoutNode.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InLayoutBlock) {
                requestLookaheadRelayout(parent$ui_release, false);
            }
        }
        return m451remeasureBRTryo0;
    }

    /* renamed from: doRemeasure-sdFAvZA */
    public final boolean m457doRemeasuresdFAvZA(LayoutNode layoutNode, Constraints constraints) {
        boolean m446remeasure_Sx5XlM$ui_release$default;
        if (constraints != null) {
            m446remeasure_Sx5XlM$ui_release$default = layoutNode.m448remeasure_Sx5XlM$ui_release(constraints);
        } else {
            m446remeasure_Sx5XlM$ui_release$default = LayoutNode.m446remeasure_Sx5XlM$ui_release$default(layoutNode);
        }
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        if (m446remeasure_Sx5XlM$ui_release$default && parent$ui_release != null) {
            LayoutNode.UsageByParent usageByParent = layoutNode.layoutDelegate.measurePassDelegate.measuredByParent;
            if (usageByParent == LayoutNode.UsageByParent.InMeasureBlock) {
                requestRemeasure(parent$ui_release, false);
            } else if (usageByParent == LayoutNode.UsageByParent.InLayoutBlock) {
                requestRelayout(parent$ui_release, false);
            }
        }
        return m446remeasure_Sx5XlM$ui_release$default;
    }

    public final void forceMeasureTheSubtree(LayoutNode layoutNode, final boolean z) {
        boolean z2;
        boolean remove;
        boolean remove2;
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        DepthSortedSetsForDifferentPasses depthSortedSetsForDifferentPasses = this.relayoutNodes;
        int r2 = 0;
        if (depthSortedSetsForDifferentPasses.set.set.isEmpty() && depthSortedSetsForDifferentPasses.lookaheadSet.set.isEmpty()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return;
        }
        if (this.duringMeasureLayout) {
            Function1<LayoutNode, Boolean> function1 = new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.node.MeasureAndLayoutDelegate$forceMeasureTheSubtree$pending$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(LayoutNode layoutNode2) {
                    boolean z3;
                    LayoutNode it = layoutNode2;
                    Intrinsics.checkNotNullParameter(it, "it");
                    boolean z4 = z;
                    LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = it.layoutDelegate;
                    if (z4) {
                        z3 = layoutNodeLayoutDelegate.lookaheadMeasurePending;
                    } else {
                        z3 = layoutNodeLayoutDelegate.measurePending;
                    }
                    return Boolean.valueOf(z3);
                }
            };
            if (!((Boolean) function1.invoke(layoutNode)).booleanValue()) {
                MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
                int r5 = mutableVector.size;
                DepthSortedSet depthSortedSet = depthSortedSetsForDifferentPasses.lookaheadSet;
                DepthSortedSet depthSortedSet2 = depthSortedSetsForDifferentPasses.set;
                if (r5 > 0) {
                    LayoutNode[] layoutNodeArr = mutableVector.content;
                    do {
                        LayoutNode node = layoutNodeArr[r2];
                        if (((Boolean) function1.invoke(node)).booleanValue()) {
                            Intrinsics.checkNotNullParameter(node, "node");
                            if (z) {
                                remove2 = depthSortedSet.remove(node);
                            } else {
                                remove2 = depthSortedSet2.remove(node);
                            }
                            if (remove2) {
                                remeasureAndRelayoutIfNeeded(node, z);
                            }
                        }
                        if (!((Boolean) function1.invoke(node)).booleanValue()) {
                            forceMeasureTheSubtree(node, z);
                        }
                        r2++;
                    } while (r2 < r5);
                }
                if (((Boolean) function1.invoke(layoutNode)).booleanValue()) {
                    if (z) {
                        remove = depthSortedSet.remove(layoutNode);
                    } else {
                        remove = depthSortedSet2.remove(layoutNode);
                    }
                    if (remove) {
                        remeasureAndRelayoutIfNeeded(layoutNode, true);
                        return;
                    }
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean measureAndLayout(AndroidComposeView$resendMotionEventOnLayout$1 androidComposeView$resendMotionEventOnLayout$1) {
        boolean z;
        int r2;
        int r6;
        DepthSortedSetsForDifferentPasses depthSortedSetsForDifferentPasses = this.relayoutNodes;
        LayoutNode layoutNode = this.root;
        if (layoutNode.isAttached()) {
            if (layoutNode.isPlaced()) {
                if (!this.duringMeasureLayout) {
                    int r3 = 0;
                    byte b = 0;
                    if (this.rootConstraints != null) {
                        this.duringMeasureLayout = true;
                        try {
                            if (depthSortedSetsForDifferentPasses.set.set.isEmpty() && depthSortedSetsForDifferentPasses.lookaheadSet.set.isEmpty()) {
                                r2 = true;
                            } else {
                                r2 = false;
                            }
                            int r22 = r2 ^ true;
                            DepthSortedSet depthSortedSet = depthSortedSetsForDifferentPasses.set;
                            if (r22 != false) {
                                z = false;
                                while (true) {
                                    boolean isEmpty = depthSortedSet.set.isEmpty();
                                    DepthSortedSet depthSortedSet2 = depthSortedSetsForDifferentPasses.lookaheadSet;
                                    if (isEmpty && depthSortedSet2.set.isEmpty()) {
                                        r6 = true;
                                    } else {
                                        r6 = false;
                                    }
                                    if ((r6 ^ true) != true) {
                                        break;
                                    }
                                    boolean z2 = !depthSortedSet2.set.isEmpty();
                                    if (!z2) {
                                        depthSortedSet2 = depthSortedSet;
                                    }
                                    LayoutNode pop = depthSortedSet2.pop();
                                    boolean remeasureAndRelayoutIfNeeded = remeasureAndRelayoutIfNeeded(pop, z2);
                                    if (pop == layoutNode && remeasureAndRelayoutIfNeeded) {
                                        z = true;
                                    }
                                }
                                if (androidComposeView$resendMotionEventOnLayout$1 != null) {
                                    androidComposeView$resendMotionEventOnLayout$1.invoke();
                                }
                            } else {
                                z = false;
                            }
                        } finally {
                            this.duringMeasureLayout = false;
                        }
                    } else {
                        z = false;
                    }
                    MutableVector<Owner.OnLayoutCompletedListener> mutableVector = this.onLayoutCompletedListeners;
                    int r0 = mutableVector.size;
                    if (r0 > 0) {
                        Owner.OnLayoutCompletedListener[] onLayoutCompletedListenerArr = mutableVector.content;
                        do {
                            onLayoutCompletedListenerArr[r3].onLayoutComplete();
                            r3++;
                        } while (r3 < r0);
                    }
                    mutableVector.clear();
                    return z;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* renamed from: measureAndLayout-0kLqBqw */
    public final void m458measureAndLayout0kLqBqw(LayoutNode layoutNode, long j) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        LayoutNode layoutNode2 = this.root;
        if (!Intrinsics.areEqual(layoutNode, layoutNode2)) {
            if (layoutNode2.isAttached()) {
                if (layoutNode2.isPlaced()) {
                    if (!this.duringMeasureLayout) {
                        int r1 = 0;
                        byte b = 0;
                        if (this.rootConstraints != null) {
                            this.duringMeasureLayout = true;
                            try {
                                DepthSortedSetsForDifferentPasses depthSortedSetsForDifferentPasses = this.relayoutNodes;
                                depthSortedSetsForDifferentPasses.getClass();
                                depthSortedSetsForDifferentPasses.lookaheadSet.remove(layoutNode);
                                depthSortedSetsForDifferentPasses.set.remove(layoutNode);
                                boolean m456doLookaheadRemeasuresdFAvZA = m456doLookaheadRemeasuresdFAvZA(layoutNode, new Constraints(j));
                                m457doRemeasuresdFAvZA(layoutNode, new Constraints(j));
                                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate;
                                if ((m456doLookaheadRemeasuresdFAvZA || layoutNodeLayoutDelegate.lookaheadLayoutPending) && Intrinsics.areEqual(layoutNode.isPlacedInLookahead(), Boolean.TRUE)) {
                                    layoutNode.lookaheadReplace$ui_release();
                                }
                                if (layoutNodeLayoutDelegate.layoutPending && layoutNode.isPlaced()) {
                                    layoutNode.replace$ui_release();
                                    OnPositionedDispatcher onPositionedDispatcher = this.onPositionedDispatcher;
                                    onPositionedDispatcher.getClass();
                                    onPositionedDispatcher.layoutNodes.add(layoutNode);
                                    layoutNode.needsOnPositionedDispatch = true;
                                }
                            } finally {
                                this.duringMeasureLayout = false;
                            }
                        }
                        MutableVector<Owner.OnLayoutCompletedListener> mutableVector = this.onLayoutCompletedListeners;
                        int r6 = mutableVector.size;
                        if (r6 > 0) {
                            Owner.OnLayoutCompletedListener[] onLayoutCompletedListenerArr = mutableVector.content;
                            do {
                                onLayoutCompletedListenerArr[r1].onLayoutComplete();
                                r1++;
                            } while (r1 < r6);
                        }
                        mutableVector.clear();
                        return;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final void measureOnly() {
        LayoutNode layoutNode = this.root;
        if (layoutNode.isAttached()) {
            if (layoutNode.isPlaced()) {
                if (!this.duringMeasureLayout) {
                    if (this.rootConstraints != null) {
                        this.duringMeasureLayout = true;
                        try {
                            recurseRemeasure(layoutNode);
                            return;
                        } finally {
                            this.duringMeasureLayout = false;
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final void recurseRemeasure(LayoutNode layoutNode) {
        boolean z;
        remeasureOnly(layoutNode);
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        int r1 = mutableVector.size;
        if (r1 > 0) {
            LayoutNode[] layoutNodeArr = mutableVector.content;
            int r3 = 0;
            do {
                LayoutNode layoutNode2 = layoutNodeArr[r3];
                LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate = layoutNode2.layoutDelegate.measurePassDelegate;
                if (measurePassDelegate.measuredByParent != LayoutNode.UsageByParent.InMeasureBlock && !measurePassDelegate.alignmentLines.getRequired$ui_release()) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    recurseRemeasure(layoutNode2);
                }
                r3++;
            } while (r3 < r1);
        }
        remeasureOnly(layoutNode);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean remeasureAndRelayoutIfNeeded(androidx.compose.ui.node.LayoutNode r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.MeasureAndLayoutDelegate.remeasureAndRelayoutIfNeeded(androidx.compose.ui.node.LayoutNode, boolean):boolean");
    }

    public final void remeasureOnly(LayoutNode layoutNode) {
        Constraints constraints;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate;
        if (!layoutNodeLayoutDelegate.measurePending && !layoutNodeLayoutDelegate.lookaheadMeasurePending) {
            return;
        }
        if (layoutNode == this.root) {
            constraints = this.rootConstraints;
            Intrinsics.checkNotNull(constraints);
        } else {
            constraints = null;
        }
        if (layoutNode.layoutDelegate.lookaheadMeasurePending) {
            m456doLookaheadRemeasuresdFAvZA(layoutNode, constraints);
        }
        m457doRemeasuresdFAvZA(layoutNode, constraints);
    }

    public final boolean requestLookaheadRelayout(LayoutNode layoutNode, boolean z) {
        boolean z2;
        boolean z3;
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate;
        int r1 = WhenMappings.$EnumSwitchMapping$0[layoutNodeLayoutDelegate.layoutState.ordinal()];
        if (r1 == 1) {
            return false;
        }
        if (r1 != 2) {
            if (r1 == 3) {
                return false;
            }
            if (r1 != 4 && r1 != 5) {
                throw new NoWhenBranchMatchedException();
            }
        }
        if ((layoutNodeLayoutDelegate.lookaheadMeasurePending || layoutNodeLayoutDelegate.lookaheadLayoutPending) && !z) {
            return false;
        }
        layoutNodeLayoutDelegate.lookaheadLayoutPending = true;
        layoutNodeLayoutDelegate.lookaheadLayoutPendingForAlignment = true;
        layoutNodeLayoutDelegate.layoutPending = true;
        layoutNodeLayoutDelegate.layoutPendingForAlignment = true;
        if (Intrinsics.areEqual(layoutNode.isPlacedInLookahead(), Boolean.TRUE)) {
            LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
            if (parent$ui_release != null && parent$ui_release.layoutDelegate.lookaheadMeasurePending) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                if (parent$ui_release != null && parent$ui_release.layoutDelegate.lookaheadLayoutPending) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    this.relayoutNodes.add(layoutNode, true);
                }
            }
        }
        if (this.duringMeasureLayout) {
            return false;
        }
        return true;
    }

    public final boolean requestLookaheadRemeasure(LayoutNode layoutNode, boolean z) {
        boolean z2;
        boolean z3;
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        if (layoutNode.lookaheadRoot != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate;
            int r3 = WhenMappings.$EnumSwitchMapping$0[layoutNodeLayoutDelegate.layoutState.ordinal()];
            if (r3 != 1) {
                if (r3 != 2 && r3 != 3 && r3 != 4) {
                    if (r3 == 5) {
                        if (!layoutNodeLayoutDelegate.lookaheadMeasurePending || z) {
                            layoutNodeLayoutDelegate.lookaheadMeasurePending = true;
                            layoutNodeLayoutDelegate.measurePending = true;
                            if (Intrinsics.areEqual(layoutNode.isPlacedInLookahead(), Boolean.TRUE) || getCanAffectParentInLookahead(layoutNode)) {
                                LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
                                if (parent$ui_release != null && parent$ui_release.layoutDelegate.lookaheadMeasurePending) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (!z3) {
                                    this.relayoutNodes.add(layoutNode, true);
                                }
                            }
                            if (!this.duringMeasureLayout) {
                                return true;
                            }
                        }
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    this.postponedMeasureRequests.add(new PostponedRequest(layoutNode, true, z));
                }
            }
            return false;
        }
        throw new IllegalStateException("Error: requestLookaheadRemeasure cannot be called on a node outside LookaheadLayout".toString());
    }

    public final boolean requestRelayout(LayoutNode layoutNode, boolean z) {
        boolean z2;
        boolean z3;
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate;
        int r1 = WhenMappings.$EnumSwitchMapping$0[layoutNodeLayoutDelegate.layoutState.ordinal()];
        if (r1 != 1 && r1 != 2 && r1 != 3 && r1 != 4) {
            if (r1 == 5) {
                if (z || (!layoutNodeLayoutDelegate.measurePending && !layoutNodeLayoutDelegate.layoutPending)) {
                    layoutNodeLayoutDelegate.layoutPending = true;
                    layoutNodeLayoutDelegate.layoutPendingForAlignment = true;
                    if (layoutNode.isPlaced()) {
                        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
                        if (parent$ui_release != null && parent$ui_release.layoutDelegate.layoutPending) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!z2) {
                            if (parent$ui_release != null && parent$ui_release.layoutDelegate.measurePending) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (!z3) {
                                this.relayoutNodes.add(layoutNode, false);
                            }
                        }
                    }
                    if (!this.duringMeasureLayout) {
                        return true;
                    }
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:            if (r7 == false) goto L87;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean requestRemeasure(androidx.compose.ui.node.LayoutNode r6, boolean r7) {
        /*
            r5 = this;
            java.lang.String r0 = "layoutNode"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            androidx.compose.ui.node.LayoutNodeLayoutDelegate r0 = r6.layoutDelegate
            androidx.compose.ui.node.LayoutNode$LayoutState r1 = r0.layoutState
            int[] r2 = androidx.compose.ui.node.MeasureAndLayoutDelegate.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r2[r1]
            r2 = 1
            r3 = 0
            if (r1 == r2) goto L7a
            r4 = 2
            if (r1 == r4) goto L7a
            r4 = 3
            if (r1 == r4) goto L70
            r4 = 4
            if (r1 == r4) goto L70
            r4 = 5
            if (r1 != r4) goto L6a
            boolean r1 = r0.measurePending
            if (r1 == 0) goto L28
            if (r7 != 0) goto L28
            goto L7a
        L28:
            r0.measurePending = r2
            boolean r7 = r6.isPlaced()
            if (r7 != 0) goto L4f
            boolean r7 = r0.measurePending
            if (r7 == 0) goto L4c
            androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate r7 = r0.measurePassDelegate
            androidx.compose.ui.node.LayoutNode$UsageByParent r0 = r7.measuredByParent
            androidx.compose.ui.node.LayoutNode$UsageByParent r1 = androidx.compose.ui.node.LayoutNode.UsageByParent.InMeasureBlock
            if (r0 == r1) goto L47
            androidx.compose.ui.node.LayoutNodeAlignmentLines r7 = r7.alignmentLines
            boolean r7 = r7.getRequired$ui_release()
            if (r7 == 0) goto L45
            goto L47
        L45:
            r7 = r3
            goto L48
        L47:
            r7 = r2
        L48:
            if (r7 == 0) goto L4c
            r7 = r2
            goto L4d
        L4c:
            r7 = r3
        L4d:
            if (r7 == 0) goto L65
        L4f:
            androidx.compose.ui.node.LayoutNode r7 = r6.getParent$ui_release()
            if (r7 == 0) goto L5d
            androidx.compose.ui.node.LayoutNodeLayoutDelegate r7 = r7.layoutDelegate
            boolean r7 = r7.measurePending
            if (r7 != r2) goto L5d
            r7 = r2
            goto L5e
        L5d:
            r7 = r3
        L5e:
            if (r7 != 0) goto L65
            androidx.compose.ui.node.DepthSortedSetsForDifferentPasses r7 = r5.relayoutNodes
            r7.add(r6, r3)
        L65:
            boolean r6 = r5.duringMeasureLayout
            if (r6 != 0) goto L7a
            goto L7b
        L6a:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L70:
            androidx.compose.ui.node.MeasureAndLayoutDelegate$PostponedRequest r0 = new androidx.compose.ui.node.MeasureAndLayoutDelegate$PostponedRequest
            r0.<init>(r6, r3, r7)
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.node.MeasureAndLayoutDelegate$PostponedRequest> r6 = r5.postponedMeasureRequests
            r6.add(r0)
        L7a:
            r2 = r3
        L7b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.MeasureAndLayoutDelegate.requestRemeasure(androidx.compose.ui.node.LayoutNode, boolean):boolean");
    }

    /* renamed from: updateRootConstraints-BRTryo0 */
    public final void m459updateRootConstraintsBRTryo0(long j) {
        boolean m559equalsimpl0;
        Constraints constraints = this.rootConstraints;
        boolean z = false;
        if (constraints == null) {
            m559equalsimpl0 = false;
        } else {
            m559equalsimpl0 = Constraints.m559equalsimpl0(constraints.value, j);
        }
        if (!m559equalsimpl0) {
            if (!this.duringMeasureLayout) {
                this.rootConstraints = new Constraints(j);
                LayoutNode layoutNode = this.root;
                LayoutNode layoutNode2 = layoutNode.lookaheadRoot;
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate;
                if (layoutNode2 != null) {
                    layoutNodeLayoutDelegate.lookaheadMeasurePending = true;
                }
                layoutNodeLayoutDelegate.measurePending = true;
                if (layoutNode2 != null) {
                    z = true;
                }
                this.relayoutNodes.add(layoutNode, z);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }
}
