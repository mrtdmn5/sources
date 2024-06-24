package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class BasicMeasure {
    public final ConstraintWidgetContainer constraintWidgetContainer;
    public final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList<>();
    public final Measure mMeasure = new Measure();

    /* loaded from: classes.dex */
    public static class Measure {
        public ConstraintWidget.DimensionBehaviour horizontalBehavior;
        public int horizontalDimension;
        public int measuredBaseline;
        public boolean measuredHasBaseline;
        public int measuredHeight;
        public boolean measuredNeedsSolverPass;
        public int measuredWidth;
        public boolean useCurrentDimensions;
        public ConstraintWidget.DimensionBehaviour verticalBehavior;
        public int verticalDimension;
    }

    /* loaded from: classes.dex */
    public interface Measurer {
    }

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer) {
        this.constraintWidgetContainer = constraintWidgetContainer;
    }

    public final boolean measure(Measurer measurer, ConstraintWidget constraintWidget, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        Measure measure = this.mMeasure;
        measure.horizontalBehavior = dimensionBehaviour;
        boolean z6 = true;
        measure.verticalBehavior = dimensionBehaviourArr[1];
        measure.horizontalDimension = constraintWidget.getWidth();
        measure.verticalDimension = constraintWidget.getHeight();
        measure.measuredNeedsSolverPass = false;
        measure.useCurrentDimensions = z;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = measure.horizontalBehavior;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour2 == dimensionBehaviour3) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (measure.verticalBehavior == dimensionBehaviour3) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z2 && constraintWidget.mDimensionRatio > 0.0f) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 && constraintWidget.mDimensionRatio > 0.0f) {
            z5 = true;
        } else {
            z5 = false;
        }
        int[] r5 = constraintWidget.mResolvedMatchConstraintDefault;
        if (z4 && r5[0] == 4) {
            measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z5 && r5[1] == 4) {
            measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        ((ConstraintLayout.Measurer) measurer).measure(constraintWidget, measure);
        constraintWidget.setWidth(measure.measuredWidth);
        constraintWidget.setHeight(measure.measuredHeight);
        constraintWidget.hasBaseline = measure.measuredHasBaseline;
        int r7 = measure.measuredBaseline;
        constraintWidget.mBaselineDistance = r7;
        if (r7 <= 0) {
            z6 = false;
        }
        constraintWidget.hasBaseline = z6;
        measure.useCurrentDimensions = false;
        return measure.measuredNeedsSolverPass;
    }

    public final void solveLinearSystem(ConstraintWidgetContainer constraintWidgetContainer, int r5, int r6) {
        int r0 = constraintWidgetContainer.mMinWidth;
        int r1 = constraintWidgetContainer.mMinHeight;
        constraintWidgetContainer.mMinWidth = 0;
        constraintWidgetContainer.mMinHeight = 0;
        constraintWidgetContainer.setWidth(r5);
        constraintWidgetContainer.setHeight(r6);
        if (r0 < 0) {
            constraintWidgetContainer.mMinWidth = 0;
        } else {
            constraintWidgetContainer.mMinWidth = r0;
        }
        if (r1 < 0) {
            constraintWidgetContainer.mMinHeight = 0;
        } else {
            constraintWidgetContainer.mMinHeight = r1;
        }
        this.constraintWidgetContainer.layout();
    }
}
