package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;

/* loaded from: classes.dex */
public abstract class WidgetRun implements Dependency {
    public ConstraintWidget.DimensionBehaviour dimensionBehavior;
    public int matchConstraintsType;
    public RunGroup runGroup;
    public ConstraintWidget widget;
    public final DimensionDependency dimension = new DimensionDependency(this);
    public int orientation = 0;
    public boolean resolved = false;
    public final DependencyNode start = new DependencyNode(this);
    public final DependencyNode end = new DependencyNode(this);
    public RunType mRunType = RunType.NONE;

    /* renamed from: androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;

        static {
            int[] r0 = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = r0;
            try {
                r0[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum RunType {
        NONE,
        START,
        END,
        CENTER
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.widget = constraintWidget;
    }

    public static void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int r3) {
        dependencyNode.targets.add(dependencyNode2);
        dependencyNode.margin = r3;
        dependencyNode2.dependencies.add(dependencyNode);
    }

    public static DependencyNode getTarget(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null) {
            return null;
        }
        int r1 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[constraintAnchor2.mType.ordinal()];
        ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        if (r1 == 1) {
            return constraintWidget.horizontalRun.start;
        }
        if (r1 == 2) {
            return constraintWidget.horizontalRun.end;
        }
        if (r1 == 3) {
            return constraintWidget.verticalRun.start;
        }
        if (r1 == 4) {
            return constraintWidget.verticalRun.baseline;
        }
        if (r1 != 5) {
            return null;
        }
        return constraintWidget.verticalRun.end;
    }

    public abstract void apply();

    public abstract void applyToWidget();

    public abstract void clear();

    public final int getLimitedDimension(int r2, int r3) {
        int max;
        if (r3 == 0) {
            ConstraintWidget constraintWidget = this.widget;
            int r0 = constraintWidget.mMatchConstraintMaxWidth;
            max = Math.max(constraintWidget.mMatchConstraintMinWidth, r2);
            if (r0 > 0) {
                max = Math.min(r0, r2);
            }
            if (max == r2) {
                return r2;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.widget;
            int r02 = constraintWidget2.mMatchConstraintMaxHeight;
            max = Math.max(constraintWidget2.mMatchConstraintMinHeight, r2);
            if (r02 > 0) {
                max = Math.min(r02, r2);
            }
            if (max == r2) {
                return r2;
            }
        }
        return max;
    }

    public long getWrapDimension() {
        if (this.dimension.resolved) {
            return r0.value;
        }
        return 0L;
    }

    public abstract boolean supportsWrapComputation();

    public final void updateRunCenter(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int r15) {
        float f;
        WidgetRun widgetRun;
        float f2;
        int r4;
        DependencyNode target = getTarget(constraintAnchor);
        DependencyNode target2 = getTarget(constraintAnchor2);
        if (target.resolved && target2.resolved) {
            int margin = constraintAnchor.getMargin() + target.value;
            int margin2 = target2.value - constraintAnchor2.getMargin();
            int r14 = margin2 - margin;
            DimensionDependency dimensionDependency = this.dimension;
            if (!dimensionDependency.resolved) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.dimensionBehavior;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour == dimensionBehaviour2) {
                    int r42 = this.matchConstraintsType;
                    if (r42 != 0) {
                        if (r42 != 1) {
                            if (r42 != 2) {
                                if (r42 == 3) {
                                    ConstraintWidget constraintWidget = this.widget;
                                    WidgetRun widgetRun2 = constraintWidget.horizontalRun;
                                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = widgetRun2.dimensionBehavior;
                                    WidgetRun widgetRun3 = constraintWidget.verticalRun;
                                    if (dimensionBehaviour3 != dimensionBehaviour2 || widgetRun2.matchConstraintsType != 3 || widgetRun3.dimensionBehavior != dimensionBehaviour2 || widgetRun3.matchConstraintsType != 3) {
                                        if (r15 == 0) {
                                            widgetRun2 = widgetRun3;
                                        }
                                        if (widgetRun2.dimension.resolved) {
                                            float f3 = constraintWidget.mDimensionRatio;
                                            if (r15 == 1) {
                                                r4 = (int) ((r6.value / f3) + 0.5f);
                                            } else {
                                                r4 = (int) ((f3 * r6.value) + 0.5f);
                                            }
                                            dimensionDependency.resolve(r4);
                                        }
                                    }
                                }
                            } else {
                                ConstraintWidget constraintWidget2 = this.widget;
                                ConstraintWidget constraintWidget3 = constraintWidget2.mParent;
                                if (constraintWidget3 != null) {
                                    if (r15 == 0) {
                                        widgetRun = constraintWidget3.horizontalRun;
                                    } else {
                                        widgetRun = constraintWidget3.verticalRun;
                                    }
                                    if (widgetRun.dimension.resolved) {
                                        if (r15 == 0) {
                                            f2 = constraintWidget2.mMatchConstraintPercentWidth;
                                        } else {
                                            f2 = constraintWidget2.mMatchConstraintPercentHeight;
                                        }
                                        dimensionDependency.resolve(getLimitedDimension((int) ((r6.value * f2) + 0.5f), r15));
                                    }
                                }
                            }
                        } else {
                            dimensionDependency.resolve(Math.min(getLimitedDimension(dimensionDependency.wrapValue, r15), r14));
                        }
                    } else {
                        dimensionDependency.resolve(getLimitedDimension(r14, r15));
                    }
                }
            }
            if (!dimensionDependency.resolved) {
                return;
            }
            int r43 = dimensionDependency.value;
            DependencyNode dependencyNode = this.end;
            DependencyNode dependencyNode2 = this.start;
            if (r43 == r14) {
                dependencyNode2.resolve(margin);
                dependencyNode.resolve(margin2);
                return;
            }
            ConstraintWidget constraintWidget4 = this.widget;
            if (r15 == 0) {
                f = constraintWidget4.mHorizontalBiasPercent;
            } else {
                f = constraintWidget4.mVerticalBiasPercent;
            }
            if (target == target2) {
                margin = target.value;
                margin2 = target2.value;
                f = 0.5f;
            }
            dependencyNode2.resolve((int) ((((margin2 - margin) - r43) * f) + margin + 0.5f));
            dependencyNode.resolve(dependencyNode2.value + dimensionDependency.value);
        }
    }

    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int r5, DimensionDependency dimensionDependency) {
        dependencyNode.targets.add(dependencyNode2);
        dependencyNode.targets.add(this.dimension);
        dependencyNode.marginFactor = r5;
        dependencyNode.marginDependency = dimensionDependency;
        dependencyNode2.dependencies.add(dependencyNode);
        dimensionDependency.dependencies.add(dependencyNode);
    }

    public static DependencyNode getTarget(ConstraintAnchor constraintAnchor, int r3) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        WidgetRun widgetRun = r3 == 0 ? constraintWidget.horizontalRun : constraintWidget.verticalRun;
        int r2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[constraintAnchor2.mType.ordinal()];
        if (r2 != 1) {
            if (r2 != 2) {
                if (r2 != 3) {
                    if (r2 != 5) {
                        return null;
                    }
                }
            }
            return widgetRun.end;
        }
        return widgetRun.start;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
    }
}
