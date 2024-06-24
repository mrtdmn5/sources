package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class HorizontalWidgetRun extends WidgetRun {
    public static final int[] tempDimensions = new int[2];

    /* renamed from: androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun$1 */
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

    public HorizontalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.start.type = DependencyNode.Type.LEFT;
        this.end.type = DependencyNode.Type.RIGHT;
        this.orientation = 0;
    }

    public static void computeInsetRatio(int[] r2, int r3, int r4, int r5, int r6, float f, int r8) {
        int r42 = r4 - r3;
        int r62 = r6 - r5;
        if (r8 != -1) {
            if (r8 != 0) {
                if (r8 == 1) {
                    r2[0] = r42;
                    r2[1] = (int) ((r42 * f) + 0.5f);
                    return;
                }
                return;
            }
            r2[0] = (int) ((r62 * f) + 0.5f);
            r2[1] = r62;
            return;
        }
        int r32 = (int) ((r62 * f) + 0.5f);
        int r7 = (int) ((r42 / f) + 0.5f);
        if (r32 <= r42) {
            r2[0] = r32;
            r2[1] = r62;
        } else if (r7 <= r62) {
            r2[0] = r42;
            r2[1] = r7;
        }
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
            dimensionDependency.resolve(constraintWidget5.getWidth());
        }
        boolean z2 = dimensionDependency.resolved;
        DependencyNode dependencyNode = this.end;
        DependencyNode dependencyNode2 = this.start;
        if (!z2) {
            ConstraintWidget constraintWidget6 = this.widget;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget6.mListDimensionBehaviors[0];
            this.dimensionBehavior = dimensionBehaviour;
            if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if (dimensionBehaviour == dimensionBehaviour2 && (((constraintWidget4 = constraintWidget6.mParent) != null && constraintWidget4.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED) || constraintWidget4.mListDimensionBehaviors[0] == dimensionBehaviour2)) {
                    int width = (constraintWidget4.getWidth() - this.widget.mLeft.getMargin()) - this.widget.mRight.getMargin();
                    HorizontalWidgetRun horizontalWidgetRun = constraintWidget4.horizontalRun;
                    WidgetRun.addTarget(dependencyNode2, horizontalWidgetRun.start, this.widget.mLeft.getMargin());
                    WidgetRun.addTarget(dependencyNode, horizontalWidgetRun.end, -this.widget.mRight.getMargin());
                    dimensionDependency.resolve(width);
                    return;
                }
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED) {
                    dimensionDependency.resolve(constraintWidget6.getWidth());
                }
            }
        } else {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = this.dimensionBehavior;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (dimensionBehaviour3 == dimensionBehaviour4 && (((constraintWidget2 = (constraintWidget = this.widget).mParent) != null && constraintWidget2.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED) || constraintWidget2.mListDimensionBehaviors[0] == dimensionBehaviour4)) {
                WidgetRun.addTarget(dependencyNode2, constraintWidget2.horizontalRun.start, constraintWidget.mLeft.getMargin());
                WidgetRun.addTarget(dependencyNode, constraintWidget2.horizontalRun.end, -this.widget.mRight.getMargin());
                return;
            }
        }
        if (dimensionDependency.resolved) {
            ConstraintWidget constraintWidget7 = this.widget;
            if (constraintWidget7.measured) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget7.mListAnchors;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[0];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
                if (constraintAnchor2 != null && constraintAnchorArr[1].mTarget != null) {
                    if (constraintWidget7.isInHorizontalChain()) {
                        dependencyNode2.margin = this.widget.mListAnchors[0].getMargin();
                        dependencyNode.margin = -this.widget.mListAnchors[1].getMargin();
                        return;
                    }
                    DependencyNode target = WidgetRun.getTarget(this.widget.mListAnchors[0]);
                    if (target != null) {
                        WidgetRun.addTarget(dependencyNode2, target, this.widget.mListAnchors[0].getMargin());
                    }
                    DependencyNode target2 = WidgetRun.getTarget(this.widget.mListAnchors[1]);
                    if (target2 != null) {
                        WidgetRun.addTarget(dependencyNode, target2, -this.widget.mListAnchors[1].getMargin());
                    }
                    dependencyNode2.delegateToWidgetRun = true;
                    dependencyNode.delegateToWidgetRun = true;
                    return;
                }
                if (constraintAnchor2 != null) {
                    DependencyNode target3 = WidgetRun.getTarget(constraintAnchor);
                    if (target3 != null) {
                        WidgetRun.addTarget(dependencyNode2, target3, this.widget.mListAnchors[0].getMargin());
                        WidgetRun.addTarget(dependencyNode, dependencyNode2, dimensionDependency.value);
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr[1];
                if (constraintAnchor3.mTarget != null) {
                    DependencyNode target4 = WidgetRun.getTarget(constraintAnchor3);
                    if (target4 != null) {
                        WidgetRun.addTarget(dependencyNode, target4, -this.widget.mListAnchors[1].getMargin());
                        WidgetRun.addTarget(dependencyNode2, dependencyNode, -dimensionDependency.value);
                        return;
                    }
                    return;
                }
                if (!(constraintWidget7 instanceof Helper) && constraintWidget7.mParent != null && constraintWidget7.getAnchor(ConstraintAnchor.Type.CENTER).mTarget == null) {
                    ConstraintWidget constraintWidget8 = this.widget;
                    WidgetRun.addTarget(dependencyNode2, constraintWidget8.mParent.horizontalRun.start, constraintWidget8.getX());
                    WidgetRun.addTarget(dependencyNode, dependencyNode2, dimensionDependency.value);
                    return;
                }
                return;
            }
        }
        if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget9 = this.widget;
            int r6 = constraintWidget9.mMatchConstraintDefaultWidth;
            ArrayList arrayList = dimensionDependency.dependencies;
            ArrayList arrayList2 = dimensionDependency.targets;
            if (r6 != 2) {
                if (r6 == 3) {
                    int r62 = constraintWidget9.mMatchConstraintDefaultHeight;
                    VerticalWidgetRun verticalWidgetRun = constraintWidget9.verticalRun;
                    if (r62 == 3) {
                        dependencyNode2.updateDelegate = this;
                        dependencyNode.updateDelegate = this;
                        verticalWidgetRun.start.updateDelegate = this;
                        verticalWidgetRun.end.updateDelegate = this;
                        dimensionDependency.updateDelegate = this;
                        if (constraintWidget9.isInVerticalChain()) {
                            arrayList2.add(this.widget.verticalRun.dimension);
                            this.widget.verticalRun.dimension.dependencies.add(dimensionDependency);
                            VerticalWidgetRun verticalWidgetRun2 = this.widget.verticalRun;
                            verticalWidgetRun2.dimension.updateDelegate = this;
                            arrayList2.add(verticalWidgetRun2.start);
                            arrayList2.add(this.widget.verticalRun.end);
                            this.widget.verticalRun.start.dependencies.add(dimensionDependency);
                            this.widget.verticalRun.end.dependencies.add(dimensionDependency);
                        } else if (this.widget.isInHorizontalChain()) {
                            this.widget.verticalRun.dimension.targets.add(dimensionDependency);
                            arrayList.add(this.widget.verticalRun.dimension);
                        } else {
                            this.widget.verticalRun.dimension.targets.add(dimensionDependency);
                        }
                    } else {
                        DimensionDependency dimensionDependency2 = verticalWidgetRun.dimension;
                        arrayList2.add(dimensionDependency2);
                        dimensionDependency2.dependencies.add(dimensionDependency);
                        this.widget.verticalRun.start.dependencies.add(dimensionDependency);
                        this.widget.verticalRun.end.dependencies.add(dimensionDependency);
                        dimensionDependency.delegateToWidgetRun = true;
                        arrayList.add(dependencyNode2);
                        arrayList.add(dependencyNode);
                        dependencyNode2.targets.add(dimensionDependency);
                        dependencyNode.targets.add(dimensionDependency);
                    }
                }
            } else {
                ConstraintWidget constraintWidget10 = constraintWidget9.mParent;
                if (constraintWidget10 != null) {
                    DimensionDependency dimensionDependency3 = constraintWidget10.verticalRun.dimension;
                    arrayList2.add(dimensionDependency3);
                    dimensionDependency3.dependencies.add(dimensionDependency);
                    dimensionDependency.delegateToWidgetRun = true;
                    arrayList.add(dependencyNode2);
                    arrayList.add(dependencyNode);
                }
            }
        }
        ConstraintWidget constraintWidget11 = this.widget;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget11.mListAnchors;
        ConstraintAnchor constraintAnchor4 = constraintAnchorArr2[0];
        ConstraintAnchor constraintAnchor5 = constraintAnchor4.mTarget;
        if (constraintAnchor5 != null && constraintAnchorArr2[1].mTarget != null) {
            if (constraintWidget11.isInHorizontalChain()) {
                dependencyNode2.margin = this.widget.mListAnchors[0].getMargin();
                dependencyNode.margin = -this.widget.mListAnchors[1].getMargin();
                return;
            }
            DependencyNode target5 = WidgetRun.getTarget(this.widget.mListAnchors[0]);
            DependencyNode target6 = WidgetRun.getTarget(this.widget.mListAnchors[1]);
            target5.addDependency(this);
            target6.addDependency(this);
            this.mRunType = WidgetRun.RunType.CENTER;
            return;
        }
        if (constraintAnchor5 != null) {
            DependencyNode target7 = WidgetRun.getTarget(constraintAnchor4);
            if (target7 != null) {
                WidgetRun.addTarget(dependencyNode2, target7, this.widget.mListAnchors[0].getMargin());
                addTarget(dependencyNode, dependencyNode2, 1, dimensionDependency);
                return;
            }
            return;
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchorArr2[1];
        if (constraintAnchor6.mTarget != null) {
            DependencyNode target8 = WidgetRun.getTarget(constraintAnchor6);
            if (target8 != null) {
                WidgetRun.addTarget(dependencyNode, target8, -this.widget.mListAnchors[1].getMargin());
                addTarget(dependencyNode2, dependencyNode, -1, dimensionDependency);
                return;
            }
            return;
        }
        if (!(constraintWidget11 instanceof Helper) && (constraintWidget3 = constraintWidget11.mParent) != null) {
            WidgetRun.addTarget(dependencyNode2, constraintWidget3.horizontalRun.start, constraintWidget11.getX());
            addTarget(dependencyNode, dependencyNode2, 1, dimensionDependency);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final void applyToWidget() {
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.resolved) {
            this.widget.mX = dependencyNode.value;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
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
        this.dimension.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final boolean supportsWrapComputation() {
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.widget.mMatchConstraintDefaultWidth == 0) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return "HorizontalRun " + this.widget.mDebugName;
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x0242, code lost:            if (r15 != 1) goto L313;     */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void update(androidx.constraintlayout.solver.widgets.analyzer.Dependency r23) {
        /*
            Method dump skipped, instructions count: 895
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun.update(androidx.constraintlayout.solver.widgets.analyzer.Dependency):void");
    }
}
