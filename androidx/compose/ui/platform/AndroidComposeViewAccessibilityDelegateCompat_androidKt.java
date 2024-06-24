package androidx.compose.ui.platform;

import android.graphics.Region;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
/* loaded from: classes.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat_androidKt {
    public static final boolean access$enabled(SemanticsNode semanticsNode) {
        if (SemanticsConfigurationKt.getOrNull(semanticsNode.getConfig(), SemanticsProperties.Disabled) == null) {
            return true;
        }
        return false;
    }

    public static final float access$getGetTraversalIndex(SemanticsNode semanticsNode) {
        SemanticsConfiguration config = semanticsNode.getConfig();
        SemanticsPropertyKey<Float> semanticsPropertyKey = SemanticsProperties.TraversalIndex;
        if (config.contains(semanticsPropertyKey)) {
            return ((Number) semanticsNode.getConfig().get(semanticsPropertyKey)).floatValue();
        }
        return 0.0f;
    }

    public static final boolean access$isRtl(SemanticsNode semanticsNode) {
        if (semanticsNode.layoutNode.layoutDirection == LayoutDirection.Rtl) {
            return true;
        }
        return false;
    }

    /* renamed from: access$toLegacyClassName-V4PA4sw */
    public static final String m490access$toLegacyClassNameV4PA4sw(int r3) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5 = false;
        if (r3 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return "android.widget.Button";
        }
        if (r3 == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return "android.widget.CheckBox";
        }
        if (r3 == 3) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            return "android.widget.RadioButton";
        }
        if (r3 == 5) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            return "android.widget.ImageView";
        }
        if (r3 == 6) {
            z5 = true;
        }
        if (z5) {
            return "android.widget.Spinner";
        }
        return null;
    }

    public static final ScrollObservationScope findById(int r3, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        int size = arrayList.size();
        for (int r1 = 0; r1 < size; r1++) {
            if (((ScrollObservationScope) arrayList.get(r1)).semanticsNodeId == r3) {
                return (ScrollObservationScope) arrayList.get(r1);
            }
        }
        return null;
    }

    public static final LayoutNode findClosestParentNode(LayoutNode layoutNode, Function1<? super LayoutNode, Boolean> function1) {
        for (LayoutNode parent$ui_release = layoutNode.getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            if (function1.invoke(parent$ui_release).booleanValue()) {
                return parent$ui_release;
            }
        }
        return null;
    }

    public static final void getAllUncoveredSemanticsNodesToMap$findAllSemanticNodesRecursive(Region region, SemanticsNode semanticsNode, LinkedHashMap linkedHashMap, SemanticsNode semanticsNode2) {
        boolean z;
        DelegatableNode delegatableNode;
        boolean z2;
        Rect rect;
        LayoutNode layoutNode;
        boolean isPlaced = semanticsNode2.layoutNode.isPlaced();
        boolean z3 = false;
        LayoutNode layoutNode2 = semanticsNode2.layoutNode;
        if (isPlaced && layoutNode2.isAttached()) {
            z = false;
        } else {
            z = true;
        }
        boolean isEmpty = region.isEmpty();
        int r5 = semanticsNode.id;
        int r6 = semanticsNode2.id;
        if (!isEmpty || r6 == r5) {
            if (z && !semanticsNode2.isFake) {
                return;
            }
            SemanticsConfiguration semanticsConfiguration = semanticsNode2.unmergedConfig;
            if (!semanticsConfiguration.isMergingSemanticsOfDescendants || (delegatableNode = SemanticsNodeKt.getOuterMergingSemantics(layoutNode2)) == null) {
                delegatableNode = semanticsNode2.outerSemanticsNode;
            }
            Modifier.Node node = delegatableNode.getNode();
            if (SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsActions.OnClick) != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Intrinsics.checkNotNullParameter(node, "<this>");
            boolean z4 = node.node.isAttached;
            Rect rect2 = Rect.Zero;
            if (z4) {
                if (!z2) {
                    rect2 = LayoutCoordinatesKt.boundsInRoot(DelegatableNodeKt.m441requireCoordinator64DMado(node, 8));
                } else {
                    NodeCoordinator m441requireCoordinator64DMado = DelegatableNodeKt.m441requireCoordinator64DMado(node, 8);
                    if (m441requireCoordinator64DMado.isAttached()) {
                        LayoutCoordinates findRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(m441requireCoordinator64DMado);
                        MutableRect mutableRect = m441requireCoordinator64DMado._rectCache;
                        if (mutableRect == null) {
                            mutableRect = new MutableRect();
                            m441requireCoordinator64DMado._rectCache = mutableRect;
                        }
                        long m462calculateMinimumTouchTargetPaddingE7KxVPU = m441requireCoordinator64DMado.m462calculateMinimumTouchTargetPaddingE7KxVPU(m441requireCoordinator64DMado.m465getMinimumTouchTargetSizeNHjbRc());
                        mutableRect.left = -Size.m276getWidthimpl(m462calculateMinimumTouchTargetPaddingE7KxVPU);
                        mutableRect.top = -Size.m274getHeightimpl(m462calculateMinimumTouchTargetPaddingE7KxVPU);
                        mutableRect.right = Size.m276getWidthimpl(m462calculateMinimumTouchTargetPaddingE7KxVPU) + m441requireCoordinator64DMado.getMeasuredWidth();
                        mutableRect.bottom = Size.m274getHeightimpl(m462calculateMinimumTouchTargetPaddingE7KxVPU) + m441requireCoordinator64DMado.getMeasuredHeight();
                        while (true) {
                            if (m441requireCoordinator64DMado != findRootCoordinates) {
                                m441requireCoordinator64DMado.rectInParent$ui_release(mutableRect, false, true);
                                if (mutableRect.isEmpty()) {
                                    break;
                                }
                                m441requireCoordinator64DMado = m441requireCoordinator64DMado.wrappedBy;
                                Intrinsics.checkNotNull(m441requireCoordinator64DMado);
                            } else {
                                rect2 = new Rect(mutableRect.left, mutableRect.top, mutableRect.right, mutableRect.bottom);
                                break;
                            }
                        }
                    }
                }
            }
            android.graphics.Rect rect3 = new android.graphics.Rect(MathKt__MathJVMKt.roundToInt(rect2.left), MathKt__MathJVMKt.roundToInt(rect2.top), MathKt__MathJVMKt.roundToInt(rect2.right), MathKt__MathJVMKt.roundToInt(rect2.bottom));
            Region region2 = new Region();
            region2.set(rect3);
            if (r6 == r5) {
                r6 = -1;
            }
            if (region2.op(region, region2, Region.Op.INTERSECT)) {
                Integer valueOf = Integer.valueOf(r6);
                android.graphics.Rect bounds = region2.getBounds();
                Intrinsics.checkNotNullExpressionValue(bounds, "region.bounds");
                linkedHashMap.put(valueOf, new SemanticsNodeWithAdjustedBounds(semanticsNode2, bounds));
                List<SemanticsNode> replacedChildren$ui_release = semanticsNode2.getReplacedChildren$ui_release();
                for (int size = replacedChildren$ui_release.size() - 1; -1 < size; size--) {
                    getAllUncoveredSemanticsNodesToMap$findAllSemanticNodesRecursive(region, semanticsNode, linkedHashMap, replacedChildren$ui_release.get(size));
                }
                region.op(rect3, region, Region.Op.REVERSE_DIFFERENCE);
                return;
            }
            if (semanticsNode2.isFake) {
                SemanticsNode parent = semanticsNode2.getParent();
                if (parent != null && (layoutNode = parent.layoutNode) != null && layoutNode.isPlaced()) {
                    z3 = true;
                }
                if (z3) {
                    rect = parent.getBoundsInRoot();
                } else {
                    rect = new Rect(0.0f, 0.0f, 10.0f, 10.0f);
                }
                linkedHashMap.put(Integer.valueOf(r6), new SemanticsNodeWithAdjustedBounds(semanticsNode2, new android.graphics.Rect(MathKt__MathJVMKt.roundToInt(rect.left), MathKt__MathJVMKt.roundToInt(rect.top), MathKt__MathJVMKt.roundToInt(rect.right), MathKt__MathJVMKt.roundToInt(rect.bottom))));
                return;
            }
            if (r6 == -1) {
                Integer valueOf2 = Integer.valueOf(r6);
                android.graphics.Rect bounds2 = region2.getBounds();
                Intrinsics.checkNotNullExpressionValue(bounds2, "region.bounds");
                linkedHashMap.put(valueOf2, new SemanticsNodeWithAdjustedBounds(semanticsNode2, bounds2));
            }
        }
    }

    public static final boolean isTextField(SemanticsNode semanticsNode) {
        SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
        SemanticsPropertyKey<AccessibilityAction<Function1<List<TextLayoutResult>, Boolean>>> semanticsPropertyKey = SemanticsActions.GetTextLayoutResult;
        return semanticsConfiguration.contains(SemanticsActions.SetText);
    }

    public static final AndroidViewHolder semanticsIdToView(AndroidViewsHandler androidViewsHandler, int r4) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(androidViewsHandler, "<this>");
        Set<Map.Entry<LayoutNode, AndroidViewHolder>> entrySet = androidViewsHandler.getLayoutNodeToHolder().entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "layoutNodeToHolder.entries");
        Iterator<T> it = entrySet.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((LayoutNode) ((Map.Entry) obj).getKey()).semanticsId == r4) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry == null) {
            return null;
        }
        return (AndroidViewHolder) entry.getValue();
    }
}
