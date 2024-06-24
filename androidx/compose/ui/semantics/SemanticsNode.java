package androidx.compose.ui.semantics;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemanticsNode.kt */
/* loaded from: classes.dex */
public final class SemanticsNode {
    public SemanticsNode fakeNodeParent;
    public final int id;
    public boolean isFake;
    public final LayoutNode layoutNode;
    public final boolean mergingEnabled;
    public final Modifier.Node outerSemanticsNode;
    public final SemanticsConfiguration unmergedConfig;

    public SemanticsNode(Modifier.Node outerSemanticsNode, boolean z, LayoutNode layoutNode, SemanticsConfiguration unmergedConfig) {
        Intrinsics.checkNotNullParameter(outerSemanticsNode, "outerSemanticsNode");
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        Intrinsics.checkNotNullParameter(unmergedConfig, "unmergedConfig");
        this.outerSemanticsNode = outerSemanticsNode;
        this.mergingEnabled = z;
        this.layoutNode = layoutNode;
        this.unmergedConfig = unmergedConfig;
        this.id = layoutNode.semanticsId;
    }

    /* renamed from: fakeSemanticsNode-ypyhhiA */
    public final SemanticsNode m505fakeSemanticsNodeypyhhiA(Role role, Function1<? super SemanticsPropertyReceiver, Unit> function1) {
        int r6;
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        semanticsConfiguration.isMergingSemanticsOfDescendants = false;
        semanticsConfiguration.isClearingSemantics = false;
        function1.invoke(semanticsConfiguration);
        SemanticsNode$fakeSemanticsNode$fakeNode$1 semanticsNode$fakeSemanticsNode$fakeNode$1 = new SemanticsNode$fakeSemanticsNode$fakeNode$1(function1);
        if (role != null) {
            r6 = 1000000000;
        } else {
            r6 = 2000000000;
        }
        SemanticsNode semanticsNode = new SemanticsNode(semanticsNode$fakeSemanticsNode$fakeNode$1, false, new LayoutNode(true, this.id + r6), semanticsConfiguration);
        semanticsNode.isFake = true;
        semanticsNode.fakeNodeParent = this;
        return semanticsNode;
    }

    public final void fillOneLayerOfSemanticsWrappers(LayoutNode layoutNode, ArrayList arrayList) {
        MutableVector<LayoutNode> zSortedChildren = layoutNode.getZSortedChildren();
        int r0 = zSortedChildren.size;
        if (r0 > 0) {
            LayoutNode[] layoutNodeArr = zSortedChildren.content;
            int r1 = 0;
            do {
                LayoutNode layoutNode2 = layoutNodeArr[r1];
                if (layoutNode2.isAttached()) {
                    if (layoutNode2.nodes.m460hasH91voCI$ui_release(8)) {
                        arrayList.add(SemanticsNodeKt.SemanticsNode(layoutNode2, this.mergingEnabled));
                    } else {
                        fillOneLayerOfSemanticsWrappers(layoutNode2, arrayList);
                    }
                }
                r1++;
            } while (r1 < r0);
        }
    }

    public final NodeCoordinator findCoordinatorToGetBounds$ui_release() {
        if (this.isFake) {
            SemanticsNode parent = getParent();
            if (parent != null) {
                return parent.findCoordinatorToGetBounds$ui_release();
            }
            return null;
        }
        DelegatableNode outerMergingSemantics = SemanticsNodeKt.getOuterMergingSemantics(this.layoutNode);
        if (outerMergingSemantics == null) {
            outerMergingSemantics = this.outerSemanticsNode;
        }
        return DelegatableNodeKt.m441requireCoordinator64DMado(outerMergingSemantics, 8);
    }

    public final void findOneLayerOfMergingSemanticsNodes(List list) {
        List<SemanticsNode> unmergedChildren$ui_release = unmergedChildren$ui_release(false);
        int size = unmergedChildren$ui_release.size();
        for (int r0 = 0; r0 < size; r0++) {
            SemanticsNode semanticsNode = unmergedChildren$ui_release.get(r0);
            if (semanticsNode.isMergingSemanticsOfDescendants()) {
                list.add(semanticsNode);
            } else if (!semanticsNode.unmergedConfig.isClearingSemantics) {
                semanticsNode.findOneLayerOfMergingSemanticsNodes(list);
            }
        }
    }

    public final Rect getBoundsInRoot() {
        Rect boundsInRoot;
        NodeCoordinator findCoordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (findCoordinatorToGetBounds$ui_release != null) {
            if (!findCoordinatorToGetBounds$ui_release.isAttached()) {
                findCoordinatorToGetBounds$ui_release = null;
            }
            if (findCoordinatorToGetBounds$ui_release != null && (boundsInRoot = LayoutCoordinatesKt.boundsInRoot(findCoordinatorToGetBounds$ui_release)) != null) {
                return boundsInRoot;
            }
        }
        return Rect.Zero;
    }

    public final Rect getBoundsInWindow() {
        NodeCoordinator findCoordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (findCoordinatorToGetBounds$ui_release != null) {
            if (!findCoordinatorToGetBounds$ui_release.isAttached()) {
                findCoordinatorToGetBounds$ui_release = null;
            }
            if (findCoordinatorToGetBounds$ui_release != null) {
                return LayoutCoordinatesKt.boundsInWindow(findCoordinatorToGetBounds$ui_release);
            }
        }
        return Rect.Zero;
    }

    public final List<SemanticsNode> getChildren(boolean z, boolean z2) {
        if (!z && this.unmergedConfig.isClearingSemantics) {
            return EmptyList.INSTANCE;
        }
        if (isMergingSemanticsOfDescendants()) {
            ArrayList arrayList = new ArrayList();
            findOneLayerOfMergingSemanticsNodes(arrayList);
            return arrayList;
        }
        return unmergedChildren$ui_release(z2);
    }

    public final SemanticsConfiguration getConfig() {
        boolean isMergingSemanticsOfDescendants = isMergingSemanticsOfDescendants();
        SemanticsConfiguration semanticsConfiguration = this.unmergedConfig;
        if (isMergingSemanticsOfDescendants) {
            semanticsConfiguration.getClass();
            SemanticsConfiguration semanticsConfiguration2 = new SemanticsConfiguration();
            semanticsConfiguration2.isMergingSemanticsOfDescendants = semanticsConfiguration.isMergingSemanticsOfDescendants;
            semanticsConfiguration2.isClearingSemantics = semanticsConfiguration.isClearingSemantics;
            semanticsConfiguration2.props.putAll(semanticsConfiguration.props);
            mergeConfig(semanticsConfiguration2);
            return semanticsConfiguration2;
        }
        return semanticsConfiguration;
    }

    public final SemanticsNode getParent() {
        LayoutNode layoutNode;
        SemanticsNode semanticsNode = this.fakeNodeParent;
        if (semanticsNode != null) {
            return semanticsNode;
        }
        LayoutNode layoutNode2 = this.layoutNode;
        boolean z = this.mergingEnabled;
        if (z) {
            layoutNode = SemanticsNodeKt.findClosestParentNode(layoutNode2, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.semantics.SemanticsNode$parent$1
                /* JADX WARN: Code restructure failed: missing block: B:4:0x0010, code lost:            if (r2.isMergingSemanticsOfDescendants == true) goto L8;     */
                @Override // kotlin.jvm.functions.Function1
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Boolean invoke(androidx.compose.ui.node.LayoutNode r2) {
                    /*
                        r1 = this;
                        androidx.compose.ui.node.LayoutNode r2 = (androidx.compose.ui.node.LayoutNode) r2
                        java.lang.String r0 = "it"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                        androidx.compose.ui.semantics.SemanticsConfiguration r2 = r2.getCollapsedSemantics$ui_release()
                        if (r2 == 0) goto L13
                        boolean r2 = r2.isMergingSemanticsOfDescendants
                        r0 = 1
                        if (r2 != r0) goto L13
                        goto L14
                    L13:
                        r0 = 0
                    L14:
                        java.lang.Boolean r2 = java.lang.Boolean.valueOf(r0)
                        return r2
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.semantics.SemanticsNode$parent$1.invoke(java.lang.Object):java.lang.Object");
                }
            });
        } else {
            layoutNode = null;
        }
        if (layoutNode == null) {
            layoutNode = SemanticsNodeKt.findClosestParentNode(layoutNode2, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.semantics.SemanticsNode$parent$2
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(LayoutNode layoutNode3) {
                    LayoutNode it = layoutNode3;
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(it.nodes.m460hasH91voCI$ui_release(8));
                }
            });
        }
        if (layoutNode == null) {
            return null;
        }
        return SemanticsNodeKt.SemanticsNode(layoutNode, z);
    }

    public final List<SemanticsNode> getReplacedChildren$ui_release() {
        return getChildren(false, true);
    }

    public final boolean isMergingSemanticsOfDescendants() {
        if (this.mergingEnabled && this.unmergedConfig.isMergingSemanticsOfDescendants) {
            return true;
        }
        return false;
    }

    public final void mergeConfig(SemanticsConfiguration semanticsConfiguration) {
        if (!this.unmergedConfig.isClearingSemantics) {
            List<SemanticsNode> unmergedChildren$ui_release = unmergedChildren$ui_release(false);
            int size = unmergedChildren$ui_release.size();
            for (int r0 = 0; r0 < size; r0++) {
                SemanticsNode semanticsNode = unmergedChildren$ui_release.get(r0);
                if (!semanticsNode.isMergingSemanticsOfDescendants()) {
                    SemanticsConfiguration child = semanticsNode.unmergedConfig;
                    Intrinsics.checkNotNullParameter(child, "child");
                    for (Map.Entry entry : child.props.entrySet()) {
                        SemanticsPropertyKey semanticsPropertyKey = (SemanticsPropertyKey) entry.getKey();
                        Object value = entry.getValue();
                        LinkedHashMap linkedHashMap = semanticsConfiguration.props;
                        Object obj = linkedHashMap.get(semanticsPropertyKey);
                        Intrinsics.checkNotNull(semanticsPropertyKey, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsPropertyKey<kotlin.Any?>");
                        Object invoke = semanticsPropertyKey.mergePolicy.invoke(obj, value);
                        if (invoke != null) {
                            linkedHashMap.put(semanticsPropertyKey, invoke);
                        }
                    }
                    semanticsNode.mergeConfig(semanticsConfiguration);
                }
            }
        }
    }

    public final List<SemanticsNode> unmergedChildren$ui_release(boolean z) {
        final String str;
        if (this.isFake) {
            return EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        fillOneLayerOfSemanticsWrappers(this.layoutNode, arrayList);
        if (z) {
            SemanticsPropertyKey<Role> semanticsPropertyKey = SemanticsProperties.Role;
            SemanticsConfiguration semanticsConfiguration = this.unmergedConfig;
            final Role role = (Role) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, semanticsPropertyKey);
            if (role != null && semanticsConfiguration.isMergingSemanticsOfDescendants && (!arrayList.isEmpty())) {
                arrayList.add(m505fakeSemanticsNodeypyhhiA(role, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsNode$emitFakeNodes$fakeNode$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertyReceiver fakeSemanticsNode = semanticsPropertyReceiver;
                        Intrinsics.checkNotNullParameter(fakeSemanticsNode, "$this$fakeSemanticsNode");
                        SemanticsPropertiesKt.m506setRolekuIjeqM(fakeSemanticsNode, Role.this.value);
                        return Unit.INSTANCE;
                    }
                }));
            }
            SemanticsPropertyKey<List<String>> semanticsPropertyKey2 = SemanticsProperties.ContentDescription;
            if (semanticsConfiguration.contains(semanticsPropertyKey2) && (!arrayList.isEmpty()) && semanticsConfiguration.isMergingSemanticsOfDescendants) {
                List list = (List) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, semanticsPropertyKey2);
                if (list != null) {
                    str = (String) CollectionsKt___CollectionsKt.firstOrNull(list);
                } else {
                    str = null;
                }
                if (str != null) {
                    arrayList.add(0, m505fakeSemanticsNodeypyhhiA(null, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsNode$emitFakeNodes$fakeNode$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertyReceiver fakeSemanticsNode = semanticsPropertyReceiver;
                            Intrinsics.checkNotNullParameter(fakeSemanticsNode, "$this$fakeSemanticsNode");
                            SemanticsPropertiesKt.setContentDescription(fakeSemanticsNode, str);
                            return Unit.INSTANCE;
                        }
                    }));
                }
            }
        }
        return arrayList;
    }
}
