package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VerticalWidgetRun extends WidgetRun {
    public final DependencyNode baseline;
    public BaselineDimensionDependency baselineDimension;

    /* renamed from: androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun$1 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType;

        static {
            int[] r0 = new int[WidgetRun.RunType.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType = r0;
            try {
                r0[WidgetRun.RunType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[WidgetRun.RunType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[WidgetRun.RunType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public VerticalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        DependencyNode dependencyNode = new DependencyNode(this);
        this.baseline = dependencyNode;
        this.baselineDimension = null;
        this.start.type = DependencyNode.Type.TOP;
        this.end.type = DependencyNode.Type.BOTTOM;
        dependencyNode.type = DependencyNode.Type.BASELINE;
        this.orientation = 1;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final void apply() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5 = this.widget;
        boolean z = constraintWidget5.measured;
        DimensionDependency dimensionDependency = this.dimension;
        if (z) {
            dimensionDependency.resolve(constraintWidget5.getHeight());
        }
        boolean z2 = dimensionDependency.resolved;
        DependencyNode dependencyNode = this.end;
        DependencyNode dependencyNode2 = this.start;
        if (!z2) {
            ConstraintWidget constraintWidget6 = this.widget;
            this.dimensionBehavior = constraintWidget6.mListDimensionBehaviors[1];
            if (constraintWidget6.hasBaseline) {
                this.baselineDimension = new BaselineDimensionDependency(this);
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.dimensionBehavior;
            if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (constraintWidget4 = this.widget.mParent) != null && constraintWidget4.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED) {
                    int height = (constraintWidget4.getHeight() - this.widget.mTop.getMargin()) - this.widget.mBottom.getMargin();
                    VerticalWidgetRun verticalWidgetRun = constraintWidget4.verticalRun;
                    WidgetRun.addTarget(dependencyNode2, verticalWidgetRun.start, this.widget.mTop.getMargin());
                    WidgetRun.addTarget(dependencyNode, verticalWidgetRun.end, -this.widget.mBottom.getMargin());
                    dimensionDependency.resolve(height);
                    return;
                }
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED) {
                    dimensionDependency.resolve(this.widget.getHeight());
                }
            }
        } else if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (constraintWidget2 = (constraintWidget = this.widget).mParent) != null && constraintWidget2.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED) {
            VerticalWidgetRun verticalWidgetRun2 = constraintWidget2.verticalRun;
            WidgetRun.addTarget(dependencyNode2, verticalWidgetRun2.start, constraintWidget.mTop.getMargin());
            WidgetRun.addTarget(dependencyNode, verticalWidgetRun2.end, -this.widget.mBottom.getMargin());
            return;
        }
        boolean z3 = dimensionDependency.resolved;
        DependencyNode dependencyNode3 = this.baseline;
        if (z3) {
            ConstraintWidget constraintWidget7 = this.widget;
            if (constraintWidget7.measured) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget7.mListAnchors;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[2];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
                if (constraintAnchor2 != null && constraintAnchorArr[3].mTarget != null) {
                    if (constraintWidget7.isInVerticalChain()) {
                        dependencyNode2.margin = this.widget.mListAnchors[2].getMargin();
                        dependencyNode.margin = -this.widget.mListAnchors[3].getMargin();
                    } else {
                        DependencyNode target = WidgetRun.getTarget(this.widget.mListAnchors[2]);
                        if (target != null) {
                            WidgetRun.addTarget(dependencyNode2, target, this.widget.mListAnchors[2].getMargin());
                        }
                        DependencyNode target2 = WidgetRun.getTarget(this.widget.mListAnchors[3]);
                        if (target2 != null) {
                            WidgetRun.addTarget(dependencyNode, target2, -this.widget.mListAnchors[3].getMargin());
                        }
                        dependencyNode2.delegateToWidgetRun = true;
                        dependencyNode.delegateToWidgetRun = true;
                    }
                    ConstraintWidget constraintWidget8 = this.widget;
                    if (constraintWidget8.hasBaseline) {
                        WidgetRun.addTarget(dependencyNode3, dependencyNode2, constraintWidget8.mBaselineDistance);
                        return;
                    }
                    return;
                }
                if (constraintAnchor2 != null) {
                    DependencyNode target3 = WidgetRun.getTarget(constraintAnchor);
                    if (target3 != null) {
                        WidgetRun.addTarget(dependencyNode2, target3, this.widget.mListAnchors[2].getMargin());
                        WidgetRun.addTarget(dependencyNode, dependencyNode2, dimensionDependency.value);
                        ConstraintWidget constraintWidget9 = this.widget;
                        if (constraintWidget9.hasBaseline) {
                            WidgetRun.addTarget(dependencyNode3, dependencyNode2, constraintWidget9.mBaselineDistance);
                            return;
                        }
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr[3];
                if (constraintAnchor3.mTarget != null) {
                    DependencyNode target4 = WidgetRun.getTarget(constraintAnchor3);
                    if (target4 != null) {
                        WidgetRun.addTarget(dependencyNode, target4, -this.widget.mListAnchors[3].getMargin());
                        WidgetRun.addTarget(dependencyNode2, dependencyNode, -dimensionDependency.value);
                    }
                    ConstraintWidget constraintWidget10 = this.widget;
                    if (constraintWidget10.hasBaseline) {
                        WidgetRun.addTarget(dependencyNode3, dependencyNode2, constraintWidget10.mBaselineDistance);
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor4 = constraintAnchorArr[4];
                if (constraintAnchor4.mTarget != null) {
                    DependencyNode target5 = WidgetRun.getTarget(constraintAnchor4);
                    if (target5 != null) {
                        WidgetRun.addTarget(dependencyNode3, target5, 0);
                        WidgetRun.addTarget(dependencyNode2, dependencyNode3, -this.widget.mBaselineDistance);
                        WidgetRun.addTarget(dependencyNode, dependencyNode2, dimensionDependency.value);
                        return;
                    }
                    return;
                }
                if (!(constraintWidget7 instanceof Helper) && constraintWidget7.mParent != null && constraintWidget7.getAnchor(ConstraintAnchor.Type.CENTER).mTarget == null) {
                    ConstraintWidget constraintWidget11 = this.widget;
                    WidgetRun.addTarget(dependencyNode2, constraintWidget11.mParent.verticalRun.start, constraintWidget11.getY());
                    WidgetRun.addTarget(dependencyNode, dependencyNode2, dimensionDependency.value);
                    ConstraintWidget constraintWidget12 = this.widget;
                    if (constraintWidget12.hasBaseline) {
                        WidgetRun.addTarget(dependencyNode3, dependencyNode2, constraintWidget12.mBaselineDistance);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        ArrayList arrayList = dimensionDependency.targets;
        if (!z3 && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget13 = this.widget;
            int r11 = constraintWidget13.mMatchConstraintDefaultHeight;
            ArrayList arrayList2 = dimensionDependency.dependencies;
            if (r11 != 2) {
                if (r11 == 3 && !constraintWidget13.isInVerticalChain()) {
                    ConstraintWidget constraintWidget14 = this.widget;
                    if (constraintWidget14.mMatchConstraintDefaultWidth != 3) {
                        DimensionDependency dimensionDependency2 = constraintWidget14.horizontalRun.dimension;
                        arrayList.add(dimensionDependency2);
                        dimensionDependency2.dependencies.add(dimensionDependency);
                        dimensionDependency.delegateToWidgetRun = true;
                        arrayList2.add(dependencyNode2);
                        arrayList2.add(dependencyNode);
                    }
                }
            } else {
                ConstraintWidget constraintWidget15 = constraintWidget13.mParent;
                if (constraintWidget15 != null) {
                    DimensionDependency dimensionDependency3 = constraintWidget15.verticalRun.dimension;
                    arrayList.add(dimensionDependency3);
                    dimensionDependency3.dependencies.add(dimensionDependency);
                    dimensionDependency.delegateToWidgetRun = true;
                    arrayList2.add(dependencyNode2);
                    arrayList2.add(dependencyNode);
                }
            }
        } else {
            dimensionDependency.addDependency(this);
        }
        ConstraintWidget constraintWidget16 = this.widget;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget16.mListAnchors;
        ConstraintAnchor constraintAnchor5 = constraintAnchorArr2[2];
        ConstraintAnchor constraintAnchor6 = constraintAnchor5.mTarget;
        if (constraintAnchor6 != null && constraintAnchorArr2[3].mTarget != null) {
            if (constraintWidget16.isInVerticalChain()) {
                dependencyNode2.margin = this.widget.mListAnchors[2].getMargin();
                dependencyNode.margin = -this.widget.mListAnchors[3].getMargin();
            } else {
                DependencyNode target6 = WidgetRun.getTarget(this.widget.mListAnchors[2]);
                DependencyNode target7 = WidgetRun.getTarget(this.widget.mListAnchors[3]);
                target6.addDependency(this);
                target7.addDependency(this);
                this.mRunType = WidgetRun.RunType.CENTER;
            }
            if (this.widget.hasBaseline) {
                addTarget(dependencyNode3, dependencyNode2, 1, this.baselineDimension);
            }
        } else if (constraintAnchor6 != null) {
            DependencyNode target8 = WidgetRun.getTarget(constraintAnchor5);
            if (target8 != null) {
                WidgetRun.addTarget(dependencyNode2, target8, this.widget.mListAnchors[2].getMargin());
                addTarget(dependencyNode, dependencyNode2, 1, dimensionDependency);
                if (this.widget.hasBaseline) {
                    addTarget(dependencyNode3, dependencyNode2, 1, this.baselineDimension);
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.dimensionBehavior;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour2 == dimensionBehaviour3) {
                    ConstraintWidget constraintWidget17 = this.widget;
                    if (constraintWidget17.mDimensionRatio > 0.0f) {
                        HorizontalWidgetRun horizontalWidgetRun = constraintWidget17.horizontalRun;
                        if (horizontalWidgetRun.dimensionBehavior == dimensionBehaviour3) {
                            horizontalWidgetRun.dimension.dependencies.add(dimensionDependency);
                            arrayList.add(this.widget.horizontalRun.dimension);
                            dimensionDependency.updateDelegate = this;
                        }
                    }
                }
            }
        } else {
            ConstraintAnchor constraintAnchor7 = constraintAnchorArr2[3];
            if (constraintAnchor7.mTarget != null) {
                DependencyNode target9 = WidgetRun.getTarget(constraintAnchor7);
                if (target9 != null) {
                    WidgetRun.addTarget(dependencyNode, target9, -this.widget.mListAnchors[3].getMargin());
                    addTarget(dependencyNode2, dependencyNode, -1, dimensionDependency);
                    if (this.widget.hasBaseline) {
                        addTarget(dependencyNode3, dependencyNode2, 1, this.baselineDimension);
                    }
                }
            } else {
                ConstraintAnchor constraintAnchor8 = constraintAnchorArr2[4];
                if (constraintAnchor8.mTarget != null) {
                    DependencyNode target10 = WidgetRun.getTarget(constraintAnchor8);
                    if (target10 != null) {
                        WidgetRun.addTarget(dependencyNode3, target10, 0);
                        addTarget(dependencyNode2, dependencyNode3, -1, this.baselineDimension);
                        addTarget(dependencyNode, dependencyNode2, 1, dimensionDependency);
                    }
                } else if (!(constraintWidget16 instanceof Helper) && (constraintWidget3 = constraintWidget16.mParent) != null) {
                    WidgetRun.addTarget(dependencyNode2, constraintWidget3.verticalRun.start, constraintWidget16.getY());
                    addTarget(dependencyNode, dependencyNode2, 1, dimensionDependency);
                    if (this.widget.hasBaseline) {
                        addTarget(dependencyNode3, dependencyNode2, 1, this.baselineDimension);
                    }
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = this.dimensionBehavior;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour4 == dimensionBehaviour5) {
                        ConstraintWidget constraintWidget18 = this.widget;
                        if (constraintWidget18.mDimensionRatio > 0.0f) {
                            HorizontalWidgetRun horizontalWidgetRun2 = constraintWidget18.horizontalRun;
                            if (horizontalWidgetRun2.dimensionBehavior == dimensionBehaviour5) {
                                horizontalWidgetRun2.dimension.dependencies.add(dimensionDependency);
                                arrayList.add(this.widget.horizontalRun.dimension);
                                dimensionDependency.updateDelegate = this;
                            }
                        }
                    }
                }
            }
        }
        if (arrayList.size() == 0) {
            dimensionDependency.readyToSolve = true;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final void applyToWidget() {
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.resolved) {
            this.widget.mY = dependencyNode.value;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
        this.baseline.clear();
        this.dimension.clear();
        this.resolved = false;
    }

    public final void reset() {
        this.resolved = false;
        DependencyNode dependencyNode = this.start;
        dependencyNode.clear();
        dependencyNode.resolved = false;
        DependencyNode dependencyNode2 = this.end;
        dependencyNode2.clear();
        dependencyNode2.resolved = false;
        DependencyNode dependencyNode3 = this.baseline;
        dependencyNode3.clear();
        dependencyNode3.resolved = false;
        this.dimension.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final boolean supportsWrapComputation() {
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.widget.mMatchConstraintDefaultHeight == 0) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return "VerticalRun " + this.widget.mDebugName;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public final void update(Dependency dependency) {
        float f;
        float f2;
        float f3;
        int r1;
        if (AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[this.mRunType.ordinal()] != 3) {
            DimensionDependency dimensionDependency = this.dimension;
            if (dimensionDependency.readyToSolve && !dimensionDependency.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintWidget constraintWidget = this.widget;
                int r5 = constraintWidget.mMatchConstraintDefaultHeight;
                if (r5 != 2) {
                    if (r5 == 3) {
                        DimensionDependency dimensionDependency2 = constraintWidget.horizontalRun.dimension;
                        if (dimensionDependency2.resolved) {
                            int r52 = constraintWidget.mDimensionRatioSide;
                            if (r52 != -1) {
                                if (r52 != 0) {
                                    if (r52 != 1) {
                                        r1 = 0;
                                        dimensionDependency.resolve(r1);
                                    } else {
                                        f = dimensionDependency2.value;
                                        f2 = constraintWidget.mDimensionRatio;
                                    }
                                } else {
                                    f3 = dimensionDependency2.value * constraintWidget.mDimensionRatio;
                                    r1 = (int) (f3 + 0.5f);
                                    dimensionDependency.resolve(r1);
                                }
                            } else {
                                f = dimensionDependency2.value;
                                f2 = constraintWidget.mDimensionRatio;
                            }
                            f3 = f / f2;
                            r1 = (int) (f3 + 0.5f);
                            dimensionDependency.resolve(r1);
                        }
                    }
                } else {
                    ConstraintWidget constraintWidget2 = constraintWidget.mParent;
                    if (constraintWidget2 != null) {
                        if (constraintWidget2.verticalRun.dimension.resolved) {
                            dimensionDependency.resolve((int) ((r1.value * constraintWidget.mMatchConstraintPercentHeight) + 0.5f));
                        }
                    }
                }
            }
            DependencyNode dependencyNode = this.start;
            if (dependencyNode.readyToSolve) {
                DependencyNode dependencyNode2 = this.end;
                if (dependencyNode2.readyToSolve) {
                    if (dependencyNode.resolved && dependencyNode2.resolved && dimensionDependency.resolved) {
                        return;
                    }
                    boolean z = dimensionDependency.resolved;
                    ArrayList arrayList = dependencyNode.targets;
                    ArrayList arrayList2 = dependencyNode2.targets;
                    if (!z && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        ConstraintWidget constraintWidget3 = this.widget;
                        if (constraintWidget3.mMatchConstraintDefaultWidth == 0 && !constraintWidget3.isInVerticalChain()) {
                            DependencyNode dependencyNode3 = (DependencyNode) arrayList.get(0);
                            DependencyNode dependencyNode4 = (DependencyNode) arrayList2.get(0);
                            int r0 = dependencyNode3.value + dependencyNode.margin;
                            int r3 = dependencyNode4.value + dependencyNode2.margin;
                            dependencyNode.resolve(r0);
                            dependencyNode2.resolve(r3);
                            dimensionDependency.resolve(r3 - r0);
                            return;
                        }
                    }
                    if (!dimensionDependency.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.matchConstraintsType == 1 && arrayList.size() > 0 && arrayList2.size() > 0) {
                        DependencyNode dependencyNode5 = (DependencyNode) arrayList.get(0);
                        int r53 = (((DependencyNode) arrayList2.get(0)).value + dependencyNode2.margin) - (dependencyNode5.value + dependencyNode.margin);
                        int r02 = dimensionDependency.wrapValue;
                        if (r53 < r02) {
                            dimensionDependency.resolve(r53);
                        } else {
                            dimensionDependency.resolve(r02);
                        }
                    }
                    if (dimensionDependency.resolved && arrayList.size() > 0 && arrayList2.size() > 0) {
                        DependencyNode dependencyNode6 = (DependencyNode) arrayList.get(0);
                        DependencyNode dependencyNode7 = (DependencyNode) arrayList2.get(0);
                        int r54 = dependencyNode6.value;
                        int r6 = dependencyNode.margin + r54;
                        int r7 = dependencyNode7.value;
                        int r8 = dependencyNode2.margin + r7;
                        float f4 = this.widget.mVerticalBiasPercent;
                        if (dependencyNode6 == dependencyNode7) {
                            f4 = 0.5f;
                        } else {
                            r54 = r6;
                            r7 = r8;
                        }
                        dependencyNode.resolve((int) ((((r7 - r54) - dimensionDependency.value) * f4) + r54 + 0.5f));
                        dependencyNode2.resolve(dependencyNode.value + dimensionDependency.value);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        ConstraintWidget constraintWidget4 = this.widget;
        updateRunCenter(constraintWidget4.mTop, constraintWidget4.mBottom, 1);
    }
}
