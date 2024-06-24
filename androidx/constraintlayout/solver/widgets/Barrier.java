package androidx.constraintlayout.solver.widgets;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda0;

/* loaded from: classes.dex */
public final class Barrier extends HelperWidget {
    public int mBarrierType = 0;
    public boolean mAllowsGoneWidget = true;
    public int mMargin = 0;

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public final void addToSolver(LinearSystem linearSystem) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int r11;
        int r9;
        int r112;
        int r14;
        ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
        ConstraintAnchor constraintAnchor = this.mLeft;
        constraintAnchorArr[0] = constraintAnchor;
        int r5 = 2;
        ConstraintAnchor constraintAnchor2 = this.mTop;
        constraintAnchorArr[2] = constraintAnchor2;
        ConstraintAnchor constraintAnchor3 = this.mRight;
        constraintAnchorArr[1] = constraintAnchor3;
        ConstraintAnchor constraintAnchor4 = this.mBottom;
        constraintAnchorArr[3] = constraintAnchor4;
        for (ConstraintAnchor constraintAnchor5 : constraintAnchorArr) {
            constraintAnchor5.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor5);
        }
        int r113 = this.mBarrierType;
        if (r113 >= 0 && r113 < 4) {
            ConstraintAnchor constraintAnchor6 = constraintAnchorArr[r113];
            for (int r114 = 0; r114 < this.mWidgetsCount; r114++) {
                ConstraintWidget constraintWidget = this.mWidgets[r114];
                if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((r14 = this.mBarrierType) == 0 || r14 == 1) && constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget != null) || ((r14 == 2 || r14 == 3) && constraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null))) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (!constraintAnchor.hasCenteredDependents() && !constraintAnchor3.hasCenteredDependents()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!constraintAnchor2.hasCenteredDependents() && !constraintAnchor4.hasCenteredDependents()) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (!z && (((r112 = this.mBarrierType) == 0 && z2) || ((r112 == 2 && z3) || ((r112 == 1 && z2) || (r112 == 3 && z3))))) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z4) {
                r11 = 4;
            } else {
                r11 = 5;
            }
            int r12 = 0;
            while (r12 < this.mWidgetsCount) {
                ConstraintWidget constraintWidget2 = this.mWidgets[r12];
                if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                    SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintWidget2.mListAnchors[this.mBarrierType]);
                    int r15 = this.mBarrierType;
                    ConstraintAnchor constraintAnchor7 = constraintWidget2.mListAnchors[r15];
                    constraintAnchor7.mSolverVariable = createObjectVariable;
                    ConstraintAnchor constraintAnchor8 = constraintAnchor7.mTarget;
                    if (constraintAnchor8 != null && constraintAnchor8.mOwner == this) {
                        r9 = constraintAnchor7.mMargin + 0;
                    } else {
                        r9 = 0;
                    }
                    if (r15 != 0 && r15 != r5) {
                        SolverVariable solverVariable = constraintAnchor6.mSolverVariable;
                        int r152 = this.mMargin + r9;
                        ArrayRow createRow = linearSystem.createRow();
                        SolverVariable createSlackVariable = linearSystem.createSlackVariable();
                        createSlackVariable.strength = 0;
                        createRow.createRowGreaterThan(solverVariable, createObjectVariable, createSlackVariable, r152);
                        linearSystem.addConstraint(createRow);
                    } else {
                        SolverVariable solverVariable2 = constraintAnchor6.mSolverVariable;
                        int r7 = this.mMargin - r9;
                        ArrayRow createRow2 = linearSystem.createRow();
                        SolverVariable createSlackVariable2 = linearSystem.createSlackVariable();
                        createSlackVariable2.strength = 0;
                        createRow2.createRowLowerThan(solverVariable2, createObjectVariable, createSlackVariable2, r7);
                        linearSystem.addConstraint(createRow2);
                    }
                    linearSystem.addEquality(constraintAnchor6.mSolverVariable, createObjectVariable, this.mMargin + r9, r11);
                }
                r12++;
                r5 = 2;
            }
            int r2 = this.mBarrierType;
            if (r2 == 0) {
                linearSystem.addEquality(constraintAnchor3.mSolverVariable, constraintAnchor.mSolverVariable, 0, 8);
                linearSystem.addEquality(constraintAnchor.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 4);
                linearSystem.addEquality(constraintAnchor.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 0);
                return;
            }
            if (r2 == 1) {
                linearSystem.addEquality(constraintAnchor.mSolverVariable, constraintAnchor3.mSolverVariable, 0, 8);
                linearSystem.addEquality(constraintAnchor.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 4);
                linearSystem.addEquality(constraintAnchor.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 0);
            } else if (r2 == 2) {
                linearSystem.addEquality(constraintAnchor4.mSolverVariable, constraintAnchor2.mSolverVariable, 0, 8);
                linearSystem.addEquality(constraintAnchor2.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 4);
                linearSystem.addEquality(constraintAnchor2.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 0);
            } else if (r2 == 3) {
                linearSystem.addEquality(constraintAnchor2.mSolverVariable, constraintAnchor4.mSolverVariable, 0, 8);
                linearSystem.addEquality(constraintAnchor2.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 4);
                linearSystem.addEquality(constraintAnchor2.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 0);
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public final boolean allowedInBarrier() {
        return true;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public final String toString() {
        String m = ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder("[Barrier] "), this.mDebugName, " {");
        for (int r1 = 0; r1 < this.mWidgetsCount; r1++) {
            ConstraintWidget constraintWidget = this.mWidgets[r1];
            if (r1 > 0) {
                m = ComposableInvoker$$ExternalSyntheticOutline0.m(m, ", ");
            }
            StringBuilder m2 = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m(m);
            m2.append(constraintWidget.mDebugName);
            m = m2.toString();
        }
        return ComposableInvoker$$ExternalSyntheticOutline0.m(m, "}");
    }
}
