package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.BuildDrawCacheParams;
import androidx.compose.ui.draw.DrawCacheModifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusOrderModifier;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusRequesterModifier;
import androidx.compose.ui.focus.FocusRequesterModifierNode;
import androidx.compose.ui.focus.FocusStateImpl;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.modifier.BackwardsCompatLocalMap;
import androidx.compose.ui.modifier.EmptyMap;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalManager;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsModifier;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.transition.PathMotion;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BackwardsCompatNode.kt */
/* loaded from: classes.dex */
public final class BackwardsCompatNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, SemanticsModifierNode, PointerInputModifierNode, ModifierLocalModifierNode, ModifierLocalReadScope, ParentDataModifierNode, LayoutAwareModifierNode, GlobalPositionAwareModifierNode, FocusEventModifierNode, FocusPropertiesModifierNode, FocusRequesterModifierNode, OwnerScope, BuildDrawCacheParams {
    public BackwardsCompatLocalMap _providedValues;
    public Modifier.Element element;
    public boolean invalidateCache;
    public LayoutCoordinates lastOnPlacedCoordinates;
    public final HashSet<ModifierLocal<?>> readValues;

    public BackwardsCompatNode(Modifier.Element element) {
        Intrinsics.checkNotNullParameter(element, "element");
        this.kindSet = NodeKindKt.calculateNodeKindSetFrom(element);
        this.element = element;
        this.invalidateCache = true;
        this.readValues = new HashSet<>();
    }

    @Override // androidx.compose.ui.focus.FocusPropertiesModifierNode
    public final void applyFocusProperties(FocusProperties focusProperties) {
        Modifier.Element element = this.element;
        if (element instanceof FocusOrderModifier) {
            new FocusOrderModifierToProperties((FocusOrderModifier) element).invoke(focusProperties);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsConfiguration semanticsConfiguration) {
        Intrinsics.checkNotNullParameter(semanticsConfiguration, "<this>");
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsModifier");
        SemanticsConfiguration peer = ((SemanticsModifier) element).getSemanticsConfiguration();
        Intrinsics.checkNotNullParameter(peer, "peer");
        if (peer.isMergingSemanticsOfDescendants) {
            semanticsConfiguration.isMergingSemanticsOfDescendants = true;
        }
        if (peer.isClearingSemantics) {
            semanticsConfiguration.isClearingSemantics = true;
        }
        for (Map.Entry entry : peer.props.entrySet()) {
            SemanticsPropertyKey semanticsPropertyKey = (SemanticsPropertyKey) entry.getKey();
            Object value = entry.getValue();
            LinkedHashMap linkedHashMap = semanticsConfiguration.props;
            if (!linkedHashMap.containsKey(semanticsPropertyKey)) {
                linkedHashMap.put(semanticsPropertyKey, value);
            } else if (value instanceof AccessibilityAction) {
                Object obj = linkedHashMap.get(semanticsPropertyKey);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
                AccessibilityAction accessibilityAction = (AccessibilityAction) obj;
                String str = accessibilityAction.label;
                if (str == null) {
                    str = ((AccessibilityAction) value).label;
                }
                Function function = accessibilityAction.action;
                if (function == null) {
                    function = ((AccessibilityAction) value).action;
                }
                linkedHashMap.put(semanticsPropertyKey, new AccessibilityAction(str, function));
            }
        }
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.draw.DrawModifier");
        DrawModifier drawModifier = (DrawModifier) element;
        if (this.invalidateCache && (element instanceof DrawCacheModifier)) {
            final Modifier.Element element2 = this.element;
            if (element2 instanceof DrawCacheModifier) {
                DelegatableNodeKt.requireOwner(this).getSnapshotObserver().observeReads$ui_release(this, BackwardsCompatNodeKt.onDrawCacheReadsChanged, new Function0<Unit>(this) { // from class: androidx.compose.ui.node.BackwardsCompatNode$updateDrawCache$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        ((DrawCacheModifier) Modifier.Element.this).onBuildCache();
                        return Unit.INSTANCE;
                    }
                });
            }
            this.invalidateCache = false;
        }
        drawModifier.draw(contentDrawScope);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode, androidx.compose.ui.modifier.ModifierLocalReadScope
    public final Object getCurrent(ProvidableModifierLocal providableModifierLocal) {
        NodeChain nodeChain;
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(providableModifierLocal, "<this>");
        this.readValues.add(providableModifierLocal);
        Modifier.Node node = this.node;
        if (node.isAttached) {
            Modifier.Node node2 = node.parent;
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(this);
            while (requireLayoutNode != null) {
                if ((requireLayoutNode.nodes.head.aggregateChildKindSet & 32) != 0) {
                    while (node2 != null) {
                        if ((node2.kindSet & 32) != 0) {
                            DelegatingNode delegatingNode = node2;
                            ?? r4 = 0;
                            while (delegatingNode != 0) {
                                if (delegatingNode instanceof ModifierLocalModifierNode) {
                                    ModifierLocalModifierNode modifierLocalModifierNode = (ModifierLocalModifierNode) delegatingNode;
                                    if (modifierLocalModifierNode.getProvidedValues().contains$ui_release(providableModifierLocal)) {
                                        return modifierLocalModifierNode.getProvidedValues().get$ui_release(providableModifierLocal);
                                    }
                                } else {
                                    if ((delegatingNode.kindSet & 32) != 0) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (z && (delegatingNode instanceof DelegatingNode)) {
                                        Modifier.Node node3 = delegatingNode.delegate;
                                        int r8 = 0;
                                        delegatingNode = delegatingNode;
                                        r4 = r4;
                                        while (node3 != null) {
                                            if ((node3.kindSet & 32) != 0) {
                                                z2 = true;
                                            } else {
                                                z2 = false;
                                            }
                                            if (z2) {
                                                r8++;
                                                r4 = r4;
                                                if (r8 == 1) {
                                                    delegatingNode = node3;
                                                } else {
                                                    if (r4 == 0) {
                                                        r4 = new MutableVector(new Modifier.Node[16]);
                                                    }
                                                    if (delegatingNode != 0) {
                                                        r4.add(delegatingNode);
                                                        delegatingNode = 0;
                                                    }
                                                    r4.add(node3);
                                                }
                                            }
                                            node3 = node3.child;
                                            delegatingNode = delegatingNode;
                                            r4 = r4;
                                        }
                                        if (r8 == 1) {
                                        }
                                    }
                                }
                                delegatingNode = DelegatableNodeKt.access$pop(r4);
                            }
                        }
                        node2 = node2.parent;
                    }
                }
                requireLayoutNode = requireLayoutNode.getParent$ui_release();
                if (requireLayoutNode != null && (nodeChain = requireLayoutNode.nodes) != null) {
                    node2 = nodeChain.tail;
                } else {
                    node2 = null;
                }
            }
            return providableModifierLocal.defaultFactory.invoke();
        }
        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
    }

    @Override // androidx.compose.ui.draw.BuildDrawCacheParams
    public final Density getDensity() {
        return DelegatableNodeKt.requireLayoutNode(this).density;
    }

    @Override // androidx.compose.ui.draw.BuildDrawCacheParams
    public final LayoutDirection getLayoutDirection() {
        return DelegatableNodeKt.requireLayoutNode(this).layoutDirection;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public final PathMotion getProvidedValues() {
        BackwardsCompatLocalMap backwardsCompatLocalMap = this._providedValues;
        if (backwardsCompatLocalMap == null) {
            return EmptyMap.INSTANCE;
        }
        return backwardsCompatLocalMap;
    }

    @Override // androidx.compose.ui.draw.BuildDrawCacheParams
    /* renamed from: getSize-NH-jbRc */
    public final long mo230getSizeNHjbRc() {
        return IntSizeKt.m595toSizeozmzZPI(DelegatableNodeKt.m441requireCoordinator64DMado(this, 128).measuredSize);
    }

    public final void initializeModifier(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        if (this.isAttached) {
            Modifier.Element element = this.element;
            boolean z8 = false;
            if ((this.kindSet & 32) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (element instanceof ModifierLocalConsumer) {
                    DelegatableNodeKt.requireOwner(this).registerOnEndApplyChangesListener(new Function0<Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNode$initializeModifier$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            BackwardsCompatNode.this.updateModifierLocalConsumer();
                            return Unit.INSTANCE;
                        }
                    });
                }
                if (element instanceof ModifierLocalProvider) {
                    ModifierLocalProvider<?> modifierLocalProvider = (ModifierLocalProvider) element;
                    BackwardsCompatLocalMap backwardsCompatLocalMap = this._providedValues;
                    if (backwardsCompatLocalMap != null && backwardsCompatLocalMap.contains$ui_release(modifierLocalProvider.getKey())) {
                        backwardsCompatLocalMap.element = modifierLocalProvider;
                        ModifierLocalManager modifierLocalManager = DelegatableNodeKt.requireOwner(this).getModifierLocalManager();
                        ProvidableModifierLocal<?> key = modifierLocalProvider.getKey();
                        modifierLocalManager.getClass();
                        Intrinsics.checkNotNullParameter(key, "key");
                        modifierLocalManager.inserted.add(this);
                        modifierLocalManager.insertedLocal.add(key);
                        modifierLocalManager.invalidate();
                    } else {
                        this._providedValues = new BackwardsCompatLocalMap(modifierLocalProvider);
                        if (BackwardsCompatNodeKt.access$isChainUpdate(this)) {
                            ModifierLocalManager modifierLocalManager2 = DelegatableNodeKt.requireOwner(this).getModifierLocalManager();
                            ProvidableModifierLocal<?> key2 = modifierLocalProvider.getKey();
                            modifierLocalManager2.getClass();
                            Intrinsics.checkNotNullParameter(key2, "key");
                            modifierLocalManager2.inserted.add(this);
                            modifierLocalManager2.insertedLocal.add(key2);
                            modifierLocalManager2.invalidate();
                        }
                    }
                }
            }
            if ((this.kindSet & 4) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                if (element instanceof DrawCacheModifier) {
                    this.invalidateCache = true;
                }
                if (!z) {
                    LayoutModifierNodeKt.invalidateLayer(this);
                }
            }
            if ((this.kindSet & 2) != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                if (BackwardsCompatNodeKt.access$isChainUpdate(this)) {
                    NodeCoordinator nodeCoordinator = this.coordinator;
                    Intrinsics.checkNotNull(nodeCoordinator);
                    ((LayoutModifierNodeCoordinator) nodeCoordinator).layoutModifierNode = this;
                    OwnedLayer ownedLayer = nodeCoordinator.layer;
                    if (ownedLayer != null) {
                        ownedLayer.invalidate();
                    }
                }
                if (!z) {
                    LayoutModifierNodeKt.invalidateLayer(this);
                    DelegatableNodeKt.requireLayoutNode(this).invalidateMeasurements$ui_release();
                }
            }
            if (element instanceof RemeasurementModifier) {
                ((RemeasurementModifier) element).onRemeasurementAvailable(DelegatableNodeKt.requireLayoutNode(this));
            }
            if ((this.kindSet & 128) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (z5) {
                if ((element instanceof OnRemeasuredModifier) && BackwardsCompatNodeKt.access$isChainUpdate(this)) {
                    DelegatableNodeKt.requireLayoutNode(this).invalidateMeasurements$ui_release();
                }
                if (element instanceof OnPlacedModifier) {
                    this.lastOnPlacedCoordinates = null;
                    if (BackwardsCompatNodeKt.access$isChainUpdate(this)) {
                        DelegatableNodeKt.requireOwner(this).registerOnLayoutCompletedListener(new Owner.OnLayoutCompletedListener() { // from class: androidx.compose.ui.node.BackwardsCompatNode$initializeModifier$2
                            public BackwardsCompatNode$initializeModifier$2() {
                            }

                            @Override // androidx.compose.ui.node.Owner.OnLayoutCompletedListener
                            public final void onLayoutComplete() {
                                BackwardsCompatNode backwardsCompatNode = BackwardsCompatNode.this;
                                if (backwardsCompatNode.lastOnPlacedCoordinates == null) {
                                    backwardsCompatNode.onPlaced(DelegatableNodeKt.m441requireCoordinator64DMado(backwardsCompatNode, 128));
                                }
                            }
                        });
                    }
                }
            }
            if ((this.kindSet & 256) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (z6 && (element instanceof OnGloballyPositionedModifier) && BackwardsCompatNodeKt.access$isChainUpdate(this)) {
                DelegatableNodeKt.requireLayoutNode(this).invalidateMeasurements$ui_release();
            }
            if (element instanceof FocusRequesterModifier) {
                ((FocusRequesterModifier) element).getFocusRequester().focusRequesterNodes.add(this);
            }
            if ((this.kindSet & 16) != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7 && (element instanceof PointerInputModifier)) {
                ((PointerInputModifier) element).getPointerInputFilter().layoutCoordinates = this.coordinator;
            }
            if ((this.kindSet & 8) != 0) {
                z8 = true;
            }
            if (z8) {
                DelegatableNodeKt.requireOwner(this).onSemanticsChange();
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void interceptOutOfBoundsChildEvents() {
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        ((PointerInputModifier) element).getPointerInputFilter().getClass();
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public final boolean isValidOwnerScope() {
        return this.isAttached;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r5) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element).maxIntrinsicHeight(intrinsicMeasureScope, intrinsicMeasurable, r5);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r5) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element).maxIntrinsicWidth(intrinsicMeasureScope, intrinsicMeasurable, r5);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo31measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element).mo5measure3p2s80s(measure, measurable, j);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r5) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element).minIntrinsicHeight(intrinsicMeasureScope, intrinsicMeasurable, r5);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r5) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element).minIntrinsicWidth(intrinsicMeasureScope, intrinsicMeasurable, r5);
    }

    @Override // androidx.compose.ui.node.ParentDataModifierNode
    public final Object modifyParentData(Density density, Object obj) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.ParentDataModifier");
        return ((ParentDataModifier) element).modifyParentData(density);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        initializeModifier(true);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void onCancelPointerInput() {
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        ((PointerInputModifier) element).getPointerInputFilter().onCancel();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        unInitializeModifier();
    }

    @Override // androidx.compose.ui.focus.FocusEventModifierNode
    public final void onFocusEvent(FocusStateImpl focusState) {
        Intrinsics.checkNotNullParameter(focusState, "focusState");
        Modifier.Element element = this.element;
        if (element instanceof FocusEventModifier) {
            ((FocusEventModifier) element).onFocusEvent();
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public final void onGloballyPositioned(NodeCoordinator nodeCoordinator) {
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.OnGloballyPositionedModifier");
        ((OnGloballyPositionedModifier) element).onGloballyPositioned(nodeCoordinator);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void onMeasureResultChanged() {
        this.invalidateCache = true;
        DrawModifierNodeKt.invalidateDraw(this);
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public final void onPlaced(NodeCoordinator coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        this.lastOnPlacedCoordinates = coordinates;
        Modifier.Element element = this.element;
        if (element instanceof OnPlacedModifier) {
            ((OnPlacedModifier) element).onPlaced(coordinates);
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* renamed from: onPointerEvent-H0pRuoY */
    public final void mo13onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long j) {
        Intrinsics.checkNotNullParameter(pass, "pass");
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        ((PointerInputModifier) element).getPointerInputFilter().m417onPointerEventH0pRuoY(pointerEvent, pass);
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    /* renamed from: onRemeasured-ozmzZPI, reason: not valid java name */
    public final void mo440onRemeasuredozmzZPI(long j) {
        Modifier.Element element = this.element;
        if (element instanceof OnRemeasuredModifier) {
            ((OnRemeasuredModifier) element).mo33onRemeasuredozmzZPI(j);
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final boolean sharePointerInputWithSiblings() {
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        ((PointerInputModifier) element).getPointerInputFilter().getClass();
        return true;
    }

    public final String toString() {
        return this.element.toString();
    }

    public final void unInitializeModifier() {
        boolean z;
        if (this.isAttached) {
            Modifier.Element element = this.element;
            boolean z2 = true;
            if ((this.kindSet & 32) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (element instanceof ModifierLocalProvider) {
                    ModifierLocalManager modifierLocalManager = DelegatableNodeKt.requireOwner(this).getModifierLocalManager();
                    ProvidableModifierLocal key = ((ModifierLocalProvider) element).getKey();
                    modifierLocalManager.getClass();
                    Intrinsics.checkNotNullParameter(key, "key");
                    modifierLocalManager.removed.add(DelegatableNodeKt.requireLayoutNode(this));
                    modifierLocalManager.removedLocal.add(key);
                    modifierLocalManager.invalidate();
                }
                if (element instanceof ModifierLocalConsumer) {
                    ((ModifierLocalConsumer) element).onModifierLocalsUpdated(BackwardsCompatNodeKt.DetachedModifierLocalReadScope);
                }
            }
            if ((this.kindSet & 8) == 0) {
                z2 = false;
            }
            if (z2) {
                DelegatableNodeKt.requireOwner(this).onSemanticsChange();
            }
            if (element instanceof FocusRequesterModifier) {
                ((FocusRequesterModifier) element).getFocusRequester().focusRequesterNodes.remove(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void updateModifierLocalConsumer() {
        if (this.isAttached) {
            this.readValues.clear();
            DelegatableNodeKt.requireOwner(this).getSnapshotObserver().observeReads$ui_release(this, BackwardsCompatNodeKt.updateModifierLocalConsumer, new Function0<Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNode$updateModifierLocalConsumer$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    BackwardsCompatNode backwardsCompatNode = BackwardsCompatNode.this;
                    Modifier.Element element = backwardsCompatNode.element;
                    Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.modifier.ModifierLocalConsumer");
                    ((ModifierLocalConsumer) element).onModifierLocalsUpdated(backwardsCompatNode);
                    return Unit.INSTANCE;
                }
            });
        }
    }
}
