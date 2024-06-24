package androidx.compose.ui.focus;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import java.util.Arrays;
import java.util.Comparator;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OneDimensionalFocusSearch.kt */
/* loaded from: classes.dex */
public final class FocusableChildrenComparator implements Comparator<FocusTargetNode> {
    public static final FocusableChildrenComparator INSTANCE = new FocusableChildrenComparator();

    @Override // java.util.Comparator
    public final int compare(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2) {
        LayoutNode layoutNode;
        FocusTargetNode focusTargetNode3 = focusTargetNode;
        FocusTargetNode focusTargetNode4 = focusTargetNode2;
        if (focusTargetNode3 != null) {
            if (focusTargetNode4 != null) {
                int r2 = 0;
                if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode3) && FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode4)) {
                    NodeCoordinator nodeCoordinator = focusTargetNode3.coordinator;
                    LayoutNode layoutNode2 = null;
                    if (nodeCoordinator != null) {
                        layoutNode = nodeCoordinator.layoutNode;
                    } else {
                        layoutNode = null;
                    }
                    if (layoutNode != null) {
                        NodeCoordinator nodeCoordinator2 = focusTargetNode4.coordinator;
                        if (nodeCoordinator2 != null) {
                            layoutNode2 = nodeCoordinator2.layoutNode;
                        }
                        if (layoutNode2 != null) {
                            if (Intrinsics.areEqual(layoutNode, layoutNode2)) {
                                return 0;
                            }
                            Object[] objArr = new LayoutNode[16];
                            int r4 = 0;
                            while (layoutNode != null) {
                                int r6 = r4 + 1;
                                if (objArr.length < r6) {
                                    objArr = Arrays.copyOf(objArr, Math.max(r6, objArr.length * 2));
                                    Intrinsics.checkNotNullExpressionValue(objArr, "copyOf(this, newSize)");
                                }
                                if (r4 != 0) {
                                    ArraysKt___ArraysJvmKt.copyInto(0 + 1, 0, r4, objArr, objArr);
                                }
                                objArr[0] = layoutNode;
                                r4++;
                                layoutNode = layoutNode.getParent$ui_release();
                            }
                            Object[] objArr2 = new LayoutNode[16];
                            int r10 = 0;
                            while (layoutNode2 != null) {
                                int r62 = r10 + 1;
                                if (objArr2.length < r62) {
                                    objArr2 = Arrays.copyOf(objArr2, Math.max(r62, objArr2.length * 2));
                                    Intrinsics.checkNotNullExpressionValue(objArr2, "copyOf(this, newSize)");
                                }
                                if (r10 != 0) {
                                    ArraysKt___ArraysJvmKt.copyInto(0 + 1, 0, r10, objArr2, objArr2);
                                }
                                objArr2[0] = layoutNode2;
                                r10++;
                                layoutNode2 = layoutNode2.getParent$ui_release();
                            }
                            int min = Math.min(r4 - 1, r10 - 1);
                            if (min >= 0) {
                                while (Intrinsics.areEqual(objArr[r2], objArr2[r2])) {
                                    if (r2 != min) {
                                        r2++;
                                    }
                                }
                                return Intrinsics.compare(((LayoutNode) objArr[r2]).getPlaceOrder$ui_release(), ((LayoutNode) objArr2[r2]).getPlaceOrder$ui_release());
                            }
                            throw new IllegalStateException("Could not find a common ancestor between the two FocusModifiers.".toString());
                        }
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                    throw new IllegalStateException("Required value was null.".toString());
                }
                if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode3)) {
                    return -1;
                }
                if (!FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode4)) {
                    return 0;
                }
                return 1;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
