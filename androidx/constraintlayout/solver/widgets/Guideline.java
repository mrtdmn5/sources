package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class Guideline extends ConstraintWidget {
    public float mRelativePercent = -1.0f;
    public int mRelativeBegin = -1;
    public int mRelativeEnd = -1;
    public ConstraintAnchor mAnchor = this.mTop;
    public int mOrientation = 0;

    /* renamed from: androidx.constraintlayout.solver.widgets.Guideline$1 */
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
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public Guideline() {
        this.mAnchors.clear();
        this.mAnchors.add(this.mAnchor);
        int length = this.mListAnchors.length;
        for (int r0 = 0; r0 < length; r0++) {
            this.mListAnchors[r0] = this.mAnchor;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public final void addToSolver(LinearSystem linearSystem) {
        boolean z;
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) this.mParent;
        if (constraintWidgetContainer == null) {
            return;
        }
        ConstraintAnchor anchor = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor anchor2 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintWidget constraintWidget = this.mParent;
        boolean z2 = true;
        if (constraintWidget != null && constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            z = true;
        } else {
            z = false;
        }
        if (this.mOrientation == 0) {
            anchor = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.TOP);
            anchor2 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.BOTTOM);
            ConstraintWidget constraintWidget2 = this.mParent;
            if (constraintWidget2 == null || constraintWidget2.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                z2 = false;
            }
            z = z2;
        }
        if (this.mRelativeBegin != -1) {
            SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mAnchor);
            linearSystem.addEquality(createObjectVariable, linearSystem.createObjectVariable(anchor), this.mRelativeBegin, 8);
            if (z) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(anchor2), createObjectVariable, 0, 5);
                return;
            }
            return;
        }
        if (this.mRelativeEnd != -1) {
            SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mAnchor);
            SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(anchor2);
            linearSystem.addEquality(createObjectVariable2, createObjectVariable3, -this.mRelativeEnd, 8);
            if (z) {
                linearSystem.addGreaterThan(createObjectVariable2, linearSystem.createObjectVariable(anchor), 0, 5);
                linearSystem.addGreaterThan(createObjectVariable3, createObjectVariable2, 0, 5);
                return;
            }
            return;
        }
        if (this.mRelativePercent != -1.0f) {
            SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mAnchor);
            SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(anchor2);
            float f = this.mRelativePercent;
            ArrayRow createRow = linearSystem.createRow();
            createRow.variables.put(createObjectVariable4, -1.0f);
            createRow.variables.put(createObjectVariable5, f);
            linearSystem.addConstraint(createRow);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public final boolean allowedInBarrier() {
        return true;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public final ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[type.ordinal()]) {
            case 1:
            case 2:
                if (this.mOrientation == 1) {
                    return this.mAnchor;
                }
                break;
            case 3:
            case 4:
                if (this.mOrientation == 0) {
                    return this.mAnchor;
                }
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
        }
        throw new AssertionError(type.name());
    }

    public final void setOrientation(int r4) {
        if (this.mOrientation == r4) {
            return;
        }
        this.mOrientation = r4;
        ArrayList<ConstraintAnchor> arrayList = this.mAnchors;
        arrayList.clear();
        if (this.mOrientation == 1) {
            this.mAnchor = this.mLeft;
        } else {
            this.mAnchor = this.mTop;
        }
        arrayList.add(this.mAnchor);
        ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
        int length = constraintAnchorArr.length;
        for (int r1 = 0; r1 < length; r1++) {
            constraintAnchorArr[r1] = this.mAnchor;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public final void updateFromSolver(LinearSystem linearSystem) {
        if (this.mParent == null) {
            return;
        }
        ConstraintAnchor constraintAnchor = this.mAnchor;
        linearSystem.getClass();
        int objectVariableValue = LinearSystem.getObjectVariableValue(constraintAnchor);
        if (this.mOrientation == 1) {
            this.mX = objectVariableValue;
            this.mY = 0;
            setHeight(this.mParent.getHeight());
            setWidth(0);
            return;
        }
        this.mX = 0;
        this.mY = objectVariableValue;
        setWidth(this.mParent.getWidth());
        setHeight(0);
    }
}
