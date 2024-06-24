package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class HelperReferences extends WidgetRun {
    public final void addDependency(DependencyNode dependencyNode) {
        DependencyNode dependencyNode2 = this.start;
        dependencyNode2.dependencies.add(dependencyNode);
        dependencyNode.targets.add(dependencyNode2);
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final void apply() {
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget instanceof Barrier) {
            DependencyNode dependencyNode = this.start;
            dependencyNode.delegateToWidgetRun = true;
            Barrier barrier = (Barrier) constraintWidget;
            int r3 = barrier.mBarrierType;
            boolean z = barrier.mAllowsGoneWidget;
            ArrayList arrayList = dependencyNode.targets;
            int r7 = 0;
            if (r3 != 0) {
                if (r3 != 1) {
                    if (r3 != 2) {
                        if (r3 == 3) {
                            dependencyNode.type = DependencyNode.Type.BOTTOM;
                            while (r7 < barrier.mWidgetsCount) {
                                ConstraintWidget constraintWidget2 = barrier.mWidgets[r7];
                                if (z || constraintWidget2.mVisibility != 8) {
                                    DependencyNode dependencyNode2 = constraintWidget2.verticalRun.end;
                                    dependencyNode2.dependencies.add(dependencyNode);
                                    arrayList.add(dependencyNode2);
                                }
                                r7++;
                            }
                            addDependency(this.widget.verticalRun.start);
                            addDependency(this.widget.verticalRun.end);
                            return;
                        }
                        return;
                    }
                    dependencyNode.type = DependencyNode.Type.TOP;
                    while (r7 < barrier.mWidgetsCount) {
                        ConstraintWidget constraintWidget3 = barrier.mWidgets[r7];
                        if (z || constraintWidget3.mVisibility != 8) {
                            DependencyNode dependencyNode3 = constraintWidget3.verticalRun.start;
                            dependencyNode3.dependencies.add(dependencyNode);
                            arrayList.add(dependencyNode3);
                        }
                        r7++;
                    }
                    addDependency(this.widget.verticalRun.start);
                    addDependency(this.widget.verticalRun.end);
                    return;
                }
                dependencyNode.type = DependencyNode.Type.RIGHT;
                while (r7 < barrier.mWidgetsCount) {
                    ConstraintWidget constraintWidget4 = barrier.mWidgets[r7];
                    if (z || constraintWidget4.mVisibility != 8) {
                        DependencyNode dependencyNode4 = constraintWidget4.horizontalRun.end;
                        dependencyNode4.dependencies.add(dependencyNode);
                        arrayList.add(dependencyNode4);
                    }
                    r7++;
                }
                addDependency(this.widget.horizontalRun.start);
                addDependency(this.widget.horizontalRun.end);
                return;
            }
            dependencyNode.type = DependencyNode.Type.LEFT;
            while (r7 < barrier.mWidgetsCount) {
                ConstraintWidget constraintWidget5 = barrier.mWidgets[r7];
                if (z || constraintWidget5.mVisibility != 8) {
                    DependencyNode dependencyNode5 = constraintWidget5.horizontalRun.start;
                    dependencyNode5.dependencies.add(dependencyNode);
                    arrayList.add(dependencyNode5);
                }
                r7++;
            }
            addDependency(this.widget.horizontalRun.start);
            addDependency(this.widget.horizontalRun.end);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final void applyToWidget() {
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget instanceof Barrier) {
            int r1 = ((Barrier) constraintWidget).mBarrierType;
            DependencyNode dependencyNode = this.start;
            if (r1 != 0 && r1 != 1) {
                constraintWidget.mY = dependencyNode.value;
            } else {
                constraintWidget.mX = dependencyNode.value;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final void clear() {
        this.runGroup = null;
        this.start.clear();
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final boolean supportsWrapComputation() {
        return false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public final void update(Dependency dependency) {
        Barrier barrier = (Barrier) this.widget;
        int r0 = barrier.mBarrierType;
        DependencyNode dependencyNode = this.start;
        Iterator it = dependencyNode.targets.iterator();
        int r4 = 0;
        int r5 = -1;
        while (it.hasNext()) {
            int r6 = ((DependencyNode) it.next()).value;
            if (r5 == -1 || r6 < r5) {
                r5 = r6;
            }
            if (r4 < r6) {
                r4 = r6;
            }
        }
        if (r0 != 0 && r0 != 2) {
            dependencyNode.resolve(r4 + barrier.mMargin);
        } else {
            dependencyNode.resolve(r5 + barrier.mMargin);
        }
    }
}
