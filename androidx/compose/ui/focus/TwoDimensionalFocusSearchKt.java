package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TwoDimensionalFocusSearch.kt */
/* loaded from: classes.dex */
public final class TwoDimensionalFocusSearchKt {

    /* compiled from: TwoDimensionalFocusSearch.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[FocusStateImpl.values().length];
            try {
                r0[FocusStateImpl.ActiveParent.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[FocusStateImpl.Active.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0035, code lost:            if (r0 >= r2) goto L139;     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x005d, code lost:            r7 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x005b, code lost:            r7 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0041, code lost:            if (r5 <= r14) goto L139;     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x004d, code lost:            if (r4 >= r13) goto L139;     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0059, code lost:            if (r15 <= r12) goto L139;     */
    /* renamed from: beamBeats-I7lrPNg */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean m246beamBeatsI7lrPNg(androidx.compose.ui.geometry.Rect r16, androidx.compose.ui.geometry.Rect r17, androidx.compose.ui.geometry.Rect r18, int r19) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.TwoDimensionalFocusSearchKt.m246beamBeatsI7lrPNg(androidx.compose.ui.geometry.Rect, androidx.compose.ui.geometry.Rect, androidx.compose.ui.geometry.Rect, int):boolean");
    }

    public static final boolean beamBeats_I7lrPNg$inSourceBeam(int r3, Rect rect, Rect rect2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (r3 == 3) {
            z = true;
        } else {
            z = false;
        }
        if (z || r3 == 4) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (rect.bottom <= rect2.top || rect.top >= rect2.bottom) {
                return false;
            }
        } else {
            if (r3 == 5) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3 || r3 == 6) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                if (rect.right <= rect2.left || rect.left >= rect2.right) {
                    return false;
                }
            } else {
                throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
            }
        }
        return true;
    }

    public static final void collectAccessibleChildren(DelegatableNode delegatableNode, MutableVector<FocusTargetNode> mutableVector) {
        boolean z;
        boolean z2;
        if (delegatableNode.getNode().isAttached) {
            MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16]);
            Modifier.Node node = delegatableNode.getNode().child;
            if (node == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, delegatableNode.getNode());
            } else {
                mutableVector2.add(node);
            }
            while (mutableVector2.isNotEmpty()) {
                Modifier.Node node2 = (Modifier.Node) mutableVector2.removeAt(mutableVector2.size - 1);
                if ((node2.aggregateChildKindSet & 1024) == 0) {
                    DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, node2);
                } else {
                    while (true) {
                        if (node2 == null) {
                            break;
                        }
                        if ((node2.kindSet & 1024) != 0) {
                            MutableVector mutableVector3 = null;
                            while (node2 != null) {
                                if (node2 instanceof FocusTargetNode) {
                                    FocusTargetNode focusTargetNode = (FocusTargetNode) node2;
                                    if (focusTargetNode.isAttached) {
                                        if (focusTargetNode.fetchFocusProperties$ui_release().canFocus) {
                                            mutableVector.add(focusTargetNode);
                                        } else {
                                            collectAccessibleChildren(focusTargetNode, mutableVector);
                                        }
                                    }
                                } else {
                                    if ((node2.kindSet & 1024) != 0) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (z && (node2 instanceof DelegatingNode)) {
                                        int r7 = 0;
                                        for (Modifier.Node node3 = ((DelegatingNode) node2).delegate; node3 != null; node3 = node3.child) {
                                            if ((node3.kindSet & 1024) != 0) {
                                                z2 = true;
                                            } else {
                                                z2 = false;
                                            }
                                            if (z2) {
                                                r7++;
                                                if (r7 == 1) {
                                                    node2 = node3;
                                                } else {
                                                    if (mutableVector3 == null) {
                                                        mutableVector3 = new MutableVector(new Modifier.Node[16]);
                                                    }
                                                    if (node2 != null) {
                                                        mutableVector3.add(node2);
                                                        node2 = null;
                                                    }
                                                    mutableVector3.add(node3);
                                                }
                                            }
                                        }
                                        if (r7 == 1) {
                                        }
                                    }
                                }
                                node2 = DelegatableNodeKt.access$pop(mutableVector3);
                            }
                        } else {
                            node2 = node2.child;
                        }
                    }
                }
            }
            return;
        }
        throw new IllegalStateException("visitChildren called on an unattached node".toString());
    }

    /* renamed from: findBestCandidate-4WY_MpI */
    public static final FocusTargetNode m247findBestCandidate4WY_MpI(MutableVector<FocusTargetNode> mutableVector, Rect rect, int r14) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Rect translate;
        boolean z5;
        if (r14 == 3) {
            z = true;
        } else {
            z = false;
        }
        float f = rect.left;
        float f2 = rect.right;
        if (z) {
            translate = rect.translate((f2 - f) + 1, 0.0f);
        } else {
            if (r14 == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                translate = rect.translate(-((f2 - f) + 1), 0.0f);
            } else {
                if (r14 == 5) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                float f3 = rect.top;
                float f4 = rect.bottom;
                if (z3) {
                    translate = rect.translate(0.0f, (f4 - f3) + 1);
                } else {
                    if (r14 == 6) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        translate = rect.translate(0.0f, -((f4 - f3) + 1));
                    } else {
                        throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
                    }
                }
            }
        }
        int r3 = mutableVector.size;
        FocusTargetNode focusTargetNode = null;
        if (r3 > 0) {
            FocusTargetNode[] focusTargetNodeArr = mutableVector.content;
            int r5 = 0;
            do {
                FocusTargetNode focusTargetNode2 = focusTargetNodeArr[r5];
                if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode2)) {
                    Rect focusRect = FocusTraversalKt.focusRect(focusTargetNode2);
                    if (isBetterCandidate_I7lrPNg$isCandidate(r14, focusRect, rect) && (!isBetterCandidate_I7lrPNg$isCandidate(r14, translate, rect) || m246beamBeatsI7lrPNg(rect, focusRect, translate, r14) || (!m246beamBeatsI7lrPNg(rect, translate, focusRect, r14) && isBetterCandidate_I7lrPNg$weightedDistance(r14, rect, focusRect) < isBetterCandidate_I7lrPNg$weightedDistance(r14, rect, translate)))) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (z5) {
                        focusTargetNode = focusTargetNode2;
                        translate = focusRect;
                    }
                }
                r5++;
            } while (r5 < r3);
        }
        return focusTargetNode;
    }

    /* renamed from: findChildCorrespondingToFocusEnter--OM-vw8 */
    public static final boolean m248findChildCorrespondingToFocusEnterOMvw8(FocusTargetNode focusTargetNode, int r6, Function1<? super FocusTargetNode, Boolean> onFound) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Rect rect;
        Object obj;
        Intrinsics.checkNotNullParameter(onFound, "onFound");
        MutableVector mutableVector = new MutableVector(new FocusTargetNode[16]);
        collectAccessibleChildren(focusTargetNode, mutableVector);
        boolean z5 = true;
        if (mutableVector.size <= 1) {
            if (mutableVector.isEmpty()) {
                obj = null;
            } else {
                obj = mutableVector.content[0];
            }
            FocusTargetNode focusTargetNode2 = (FocusTargetNode) obj;
            if (focusTargetNode2 == null) {
                return false;
            }
            return onFound.invoke(focusTargetNode2).booleanValue();
        }
        if (r6 == 7) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            r6 = 4;
        }
        if (r6 == 4) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 || r6 == 6) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            Rect focusRect = FocusTraversalKt.focusRect(focusTargetNode);
            float f = focusRect.left;
            float f2 = focusRect.top;
            rect = new Rect(f, f2, f, f2);
        } else {
            if (r6 == 3) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z4 && r6 != 5) {
                z5 = false;
            }
            if (z5) {
                Rect focusRect2 = FocusTraversalKt.focusRect(focusTargetNode);
                float f3 = focusRect2.right;
                float f4 = focusRect2.bottom;
                rect = new Rect(f3, f4, f3, f4);
            } else {
                throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
            }
        }
        FocusTargetNode m247findBestCandidate4WY_MpI = m247findBestCandidate4WY_MpI(mutableVector, rect, r6);
        if (m247findBestCandidate4WY_MpI == null) {
            return false;
        }
        return onFound.invoke(m247findBestCandidate4WY_MpI).booleanValue();
    }

    /* renamed from: generateAndSearchChildren-4C6V_qg */
    public static final boolean m249generateAndSearchChildren4C6V_qg(final FocusTargetNode focusTargetNode, final FocusTargetNode focusTargetNode2, final int r3, final Function1<? super FocusTargetNode, Boolean> function1) {
        if (m250searchChildren4C6V_qg(focusTargetNode, focusTargetNode2, r3, function1)) {
            return true;
        }
        Boolean bool = (Boolean) BeyondBoundsLayoutKt.m236searchBeyondBoundsOMvw8(focusTargetNode, r3, new Function1<BeyondBoundsLayout.BeyondBoundsScope, Boolean>() { // from class: androidx.compose.ui.focus.TwoDimensionalFocusSearchKt$generateAndSearchChildren$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(BeyondBoundsLayout.BeyondBoundsScope beyondBoundsScope) {
                boolean z;
                BeyondBoundsLayout.BeyondBoundsScope searchBeyondBounds = beyondBoundsScope;
                Intrinsics.checkNotNullParameter(searchBeyondBounds, "$this$searchBeyondBounds");
                Boolean valueOf = Boolean.valueOf(TwoDimensionalFocusSearchKt.m250searchChildren4C6V_qg(FocusTargetNode.this, focusTargetNode2, r3, function1));
                if (!valueOf.booleanValue() && searchBeyondBounds.getHasMoreContent()) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    return null;
                }
                return valueOf;
            }
        });
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final boolean isBetterCandidate_I7lrPNg$isCandidate(int r7, Rect rect, Rect rect2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (r7 == 3) {
            z = true;
        } else {
            z = false;
        }
        float f = rect.left;
        float f2 = rect.right;
        float f3 = rect2.left;
        float f4 = rect2.right;
        if (z) {
            if ((f4 > f2 || f3 >= f2) && f3 > f) {
                return true;
            }
        } else {
            if (r7 == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if ((f3 < f || f4 <= f) && f4 < f2) {
                    return true;
                }
            } else {
                if (r7 == 5) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                float f5 = rect.top;
                float f6 = rect.bottom;
                float f7 = rect2.top;
                float f8 = rect2.bottom;
                if (z3) {
                    if ((f8 > f6 || f7 >= f6) && f7 > f5) {
                        return true;
                    }
                } else {
                    if (r7 == 6) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        if ((f7 < f5 || f8 <= f5) && f8 < f6) {
                            return true;
                        }
                    } else {
                        throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
                    }
                }
            }
        }
        return false;
    }

    public static final long isBetterCandidate_I7lrPNg$weightedDistance(int r18, Rect rect, Rect rect2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        float f;
        float f2;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        float f3;
        float f4;
        if (r18 == 3) {
            z = true;
        } else {
            z = false;
        }
        float f5 = rect.bottom;
        float f6 = rect.top;
        float f7 = rect.right;
        float f8 = rect.left;
        float f9 = rect2.top;
        float f10 = rect2.bottom;
        float f11 = rect2.left;
        float f12 = rect2.right;
        if (z) {
            f2 = f8;
            f = f12;
        } else {
            if (r18 == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                f = f7;
                f2 = f11;
            } else {
                if (r18 == 5) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    f2 = f6;
                    f = f10;
                } else {
                    if (r18 == 6) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        f = f5;
                        f2 = f9;
                    } else {
                        throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
                    }
                }
            }
        }
        long abs = Math.abs(Math.max(0.0f, f2 - f));
        if (r18 == 3) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5 || r18 == 4) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            f3 = 2;
            f4 = ((f5 - f6) / f3) + f6;
        } else {
            if (r18 == 5) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7 || r18 == 6) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                f3 = 2;
                f4 = ((f7 - f8) / f3) + f8;
                f10 = f12;
                f9 = f11;
            } else {
                throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
            }
        }
        long abs2 = Math.abs(f4 - (((f10 - f9) / f3) + f9));
        return (abs2 * abs2) + (13 * abs * abs);
    }

    /* renamed from: searchChildren-4C6V_qg */
    public static final boolean m250searchChildren4C6V_qg(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2, int r12, Function1<? super FocusTargetNode, Boolean> function1) {
        FocusTargetNode m247findBestCandidate4WY_MpI;
        boolean z;
        boolean z2;
        MutableVector mutableVector = new MutableVector(new FocusTargetNode[16]);
        Modifier.Node node = focusTargetNode.node;
        if (node.isAttached) {
            MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16]);
            Modifier.Node node2 = node.child;
            if (node2 == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, node);
            } else {
                mutableVector2.add(node2);
            }
            while (mutableVector2.isNotEmpty()) {
                Modifier.Node node3 = (Modifier.Node) mutableVector2.removeAt(mutableVector2.size - 1);
                if ((node3.aggregateChildKindSet & 1024) == 0) {
                    DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, node3);
                } else {
                    while (true) {
                        if (node3 == null) {
                            break;
                        }
                        if ((node3.kindSet & 1024) != 0) {
                            MutableVector mutableVector3 = null;
                            while (node3 != null) {
                                if (node3 instanceof FocusTargetNode) {
                                    mutableVector.add((FocusTargetNode) node3);
                                } else {
                                    if ((node3.kindSet & 1024) != 0) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (z && (node3 instanceof DelegatingNode)) {
                                        int r8 = 0;
                                        for (Modifier.Node node4 = ((DelegatingNode) node3).delegate; node4 != null; node4 = node4.child) {
                                            if ((node4.kindSet & 1024) != 0) {
                                                z2 = true;
                                            } else {
                                                z2 = false;
                                            }
                                            if (z2) {
                                                r8++;
                                                if (r8 == 1) {
                                                    node3 = node4;
                                                } else {
                                                    if (mutableVector3 == null) {
                                                        mutableVector3 = new MutableVector(new Modifier.Node[16]);
                                                    }
                                                    if (node3 != null) {
                                                        mutableVector3.add(node3);
                                                        node3 = null;
                                                    }
                                                    mutableVector3.add(node4);
                                                }
                                            }
                                        }
                                        if (r8 == 1) {
                                        }
                                    }
                                }
                                node3 = DelegatableNodeKt.access$pop(mutableVector3);
                            }
                        } else {
                            node3 = node3.child;
                        }
                    }
                }
            }
            while (mutableVector.isNotEmpty() && (m247findBestCandidate4WY_MpI = m247findBestCandidate4WY_MpI(mutableVector, FocusTraversalKt.focusRect(focusTargetNode2), r12)) != null) {
                if (m247findBestCandidate4WY_MpI.fetchFocusProperties$ui_release().canFocus) {
                    return function1.invoke(m247findBestCandidate4WY_MpI).booleanValue();
                }
                if (m249generateAndSearchChildren4C6V_qg(m247findBestCandidate4WY_MpI, focusTargetNode2, r12, function1)) {
                    return true;
                }
                mutableVector.remove(m247findBestCandidate4WY_MpI);
            }
            return false;
        }
        throw new IllegalStateException("visitChildren called on an unattached node".toString());
    }

    /* renamed from: twoDimensionalFocusSearch--OM-vw8 */
    public static final Boolean m251twoDimensionalFocusSearchOMvw8(FocusTargetNode focusTargetNode, int r9, FocusOwnerImpl$moveFocus$foundNextItem$1 focusOwnerImpl$moveFocus$foundNextItem$1) {
        FocusStateImpl focusStateImpl = focusTargetNode.focusState;
        int[] r1 = WhenMappings.$EnumSwitchMapping$0;
        int r0 = r1[focusStateImpl.ordinal()];
        boolean z = true;
        if (r0 != 1) {
            if (r0 != 2 && r0 != 3) {
                if (r0 == 4) {
                    if (focusTargetNode.fetchFocusProperties$ui_release().canFocus) {
                        return (Boolean) focusOwnerImpl$moveFocus$foundNextItem$1.invoke(focusTargetNode);
                    }
                    return Boolean.FALSE;
                }
                throw new NoWhenBranchMatchedException();
            }
            return Boolean.valueOf(m248findChildCorrespondingToFocusEnterOMvw8(focusTargetNode, r9, focusOwnerImpl$moveFocus$foundNextItem$1));
        }
        FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
        if (activeChild != null) {
            int r12 = r1[activeChild.focusState.ordinal()];
            if (r12 != 1) {
                if (r12 != 2 && r12 != 3) {
                    if (r12 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    throw new IllegalStateException("ActiveParent must have a focusedChild".toString());
                }
                return Boolean.valueOf(m249generateAndSearchChildren4C6V_qg(focusTargetNode, activeChild, r9, focusOwnerImpl$moveFocus$foundNextItem$1));
            }
            Boolean m251twoDimensionalFocusSearchOMvw8 = m251twoDimensionalFocusSearchOMvw8(activeChild, r9, focusOwnerImpl$moveFocus$foundNextItem$1);
            if (!Intrinsics.areEqual(m251twoDimensionalFocusSearchOMvw8, Boolean.FALSE)) {
                return m251twoDimensionalFocusSearchOMvw8;
            }
            if (activeChild.focusState != FocusStateImpl.ActiveParent) {
                z = false;
            }
            if (z) {
                FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(activeChild);
                if (findActiveFocusNode != null) {
                    return Boolean.valueOf(m249generateAndSearchChildren4C6V_qg(focusTargetNode, findActiveFocusNode, r9, focusOwnerImpl$moveFocus$foundNextItem$1));
                }
                throw new IllegalStateException("ActiveParent must have a focusedChild".toString());
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new IllegalStateException("ActiveParent must have a focusedChild".toString());
    }
}
