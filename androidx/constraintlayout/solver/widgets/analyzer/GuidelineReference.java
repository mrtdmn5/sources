package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Guideline;

/* loaded from: classes.dex */
public final class GuidelineReference extends WidgetRun {
    public GuidelineReference(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        constraintWidget.horizontalRun.clear();
        constraintWidget.verticalRun.clear();
        this.orientation = ((Guideline) constraintWidget).mOrientation;
    }

    public final void addDependency(DependencyNode dependencyNode) {
        DependencyNode dependencyNode2 = this.start;
        dependencyNode2.dependencies.add(dependencyNode);
        dependencyNode.targets.add(dependencyNode2);
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final void apply() {
        ConstraintWidget constraintWidget = this.widget;
        Guideline guideline = (Guideline) constraintWidget;
        int r2 = guideline.mRelativeBegin;
        int r3 = guideline.mRelativeEnd;
        int r1 = guideline.mOrientation;
        DependencyNode dependencyNode = this.start;
        if (r1 == 1) {
            if (r2 != -1) {
                dependencyNode.targets.add(constraintWidget.mParent.horizontalRun.start);
                this.widget.mParent.horizontalRun.start.dependencies.add(dependencyNode);
                dependencyNode.margin = r2;
            } else if (r3 != -1) {
                dependencyNode.targets.add(constraintWidget.mParent.horizontalRun.end);
                this.widget.mParent.horizontalRun.end.dependencies.add(dependencyNode);
                dependencyNode.margin = -r3;
            } else {
                dependencyNode.delegateToWidgetRun = true;
                dependencyNode.targets.add(constraintWidget.mParent.horizontalRun.end);
                this.widget.mParent.horizontalRun.end.dependencies.add(dependencyNode);
            }
            addDependency(this.widget.horizontalRun.start);
            addDependency(this.widget.horizontalRun.end);
            return;
        }
        if (r2 != -1) {
            dependencyNode.targets.add(constraintWidget.mParent.verticalRun.start);
            this.widget.mParent.verticalRun.start.dependencies.add(dependencyNode);
            dependencyNode.margin = r2;
        } else if (r3 != -1) {
            dependencyNode.targets.add(constraintWidget.mParent.verticalRun.end);
            this.widget.mParent.verticalRun.end.dependencies.add(dependencyNode);
            dependencyNode.margin = -r3;
        } else {
            dependencyNode.delegateToWidgetRun = true;
            dependencyNode.targets.add(constraintWidget.mParent.verticalRun.end);
            this.widget.mParent.verticalRun.end.dependencies.add(dependencyNode);
        }
        addDependency(this.widget.verticalRun.start);
        addDependency(this.widget.verticalRun.end);
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final void applyToWidget() {
        ConstraintWidget constraintWidget = this.widget;
        int r1 = ((Guideline) constraintWidget).mOrientation;
        DependencyNode dependencyNode = this.start;
        if (r1 == 1) {
            constraintWidget.mX = dependencyNode.value;
        } else {
            constraintWidget.mY = dependencyNode.value;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final void clear() {
        this.start.clear();
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final boolean supportsWrapComputation() {
        return false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public final void update(Dependency dependency) {
        DependencyNode dependencyNode = this.start;
        if (!dependencyNode.readyToSolve || dependencyNode.resolved) {
            return;
        }
        dependencyNode.resolve((int) ((((DependencyNode) dependencyNode.targets.get(0)).value * ((Guideline) this.widget).mRelativePercent) + 0.5f));
    }
}
