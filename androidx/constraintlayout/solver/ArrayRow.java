package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ArrayRow implements LinearSystem.Row {
    public ArrayRowVariables variables;
    public SolverVariable variable = null;
    public float constantValue = 0.0f;
    public final ArrayList<SolverVariable> variablesToUpdate = new ArrayList<>();
    public boolean isSimpleDefinition = false;

    /* loaded from: classes.dex */
    public interface ArrayRowVariables {
        void add(SolverVariable solverVariable, float f, boolean z);

        void clear();

        boolean contains(SolverVariable solverVariable);

        void divideByAmount(float f);

        float get(SolverVariable solverVariable);

        int getCurrentSize();

        SolverVariable getVariable(int r1);

        float getVariableValue(int r1);

        void invert();

        void put(SolverVariable solverVariable, float f);

        float remove(SolverVariable solverVariable, boolean z);

        float use(ArrayRow arrayRow, boolean z);
    }

    public ArrayRow() {
    }

    public final void addError(LinearSystem linearSystem, int r5) {
        this.variables.put(linearSystem.createErrorVariable(r5), 1.0f);
        this.variables.put(linearSystem.createErrorVariable(r5), -1.0f);
    }

    public final void createRowGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int r6) {
        boolean z = false;
        if (r6 != 0) {
            if (r6 < 0) {
                r6 *= -1;
                z = true;
            }
            this.constantValue = r6;
        }
        if (!z) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, 1.0f);
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
        }
    }

    public final void createRowLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int r6) {
        boolean z = false;
        if (r6 != 0) {
            if (r6 < 0) {
                r6 *= -1;
                z = true;
            }
            this.constantValue = r6;
        }
        if (!z) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, 1.0f);
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public SolverVariable getPivotCandidate(boolean[] zArr) {
        return pickPivotInVariables(zArr, null);
    }

    public final SolverVariable pickPivotInVariables(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int currentSize = this.variables.getCurrentSize();
        SolverVariable solverVariable2 = null;
        float f = 0.0f;
        for (int r3 = 0; r3 < currentSize; r3++) {
            float variableValue = this.variables.getVariableValue(r3);
            if (variableValue < 0.0f) {
                SolverVariable variable = this.variables.getVariable(r3);
                if ((zArr == null || !zArr[variable.id]) && variable != solverVariable && (((type = variable.mType) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR) && variableValue < f)) {
                    f = variableValue;
                    solverVariable2 = variable;
                }
            }
        }
        return solverVariable2;
    }

    public final void pivot(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.variable;
        if (solverVariable2 != null) {
            this.variables.put(solverVariable2, -1.0f);
            this.variable = null;
        }
        float remove = this.variables.remove(solverVariable, true) * (-1.0f);
        this.variable = solverVariable;
        if (remove == 1.0f) {
            return;
        }
        this.constantValue /= remove;
        this.variables.divideByAmount(remove);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            r9 = this;
            androidx.constraintlayout.solver.SolverVariable r0 = r9.variable
            if (r0 != 0) goto L7
            java.lang.String r0 = "0"
            goto L17
        L7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r0.<init>(r1)
            androidx.constraintlayout.solver.SolverVariable r1 = r9.variable
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L17:
            java.lang.String r1 = " = "
            java.lang.String r0 = androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0.m(r0, r1)
            float r1 = r9.constantValue
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L35
            java.lang.StringBuilder r0 = com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda0.m(r0)
            float r1 = r9.constantValue
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = r3
            goto L36
        L35:
            r1 = r4
        L36:
            androidx.constraintlayout.solver.ArrayRow$ArrayRowVariables r5 = r9.variables
            int r5 = r5.getCurrentSize()
        L3c:
            if (r4 >= r5) goto L9b
            androidx.constraintlayout.solver.ArrayRow$ArrayRowVariables r6 = r9.variables
            androidx.constraintlayout.solver.SolverVariable r6 = r6.getVariable(r4)
            if (r6 != 0) goto L47
            goto L98
        L47:
            androidx.constraintlayout.solver.ArrayRow$ArrayRowVariables r7 = r9.variables
            float r7 = r7.getVariableValue(r4)
            int r8 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r8 != 0) goto L52
            goto L98
        L52:
            java.lang.String r6 = r6.toString()
            if (r1 != 0) goto L63
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 >= 0) goto L75
            java.lang.String r1 = "- "
            java.lang.String r0 = androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0.m(r0, r1)
            goto L72
        L63:
            if (r8 <= 0) goto L6c
            java.lang.String r1 = " + "
            java.lang.String r0 = androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0.m(r0, r1)
            goto L75
        L6c:
            java.lang.String r1 = " - "
            java.lang.String r0 = androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0.m(r0, r1)
        L72:
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r7 = r7 * r1
        L75:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L80
            java.lang.String r0 = androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0.m(r0, r6)
            goto L97
        L80:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L97:
            r1 = r3
        L98:
            int r4 = r4 + 1
            goto L3c
        L9b:
            if (r1 != 0) goto La3
            java.lang.String r1 = "0.0"
            java.lang.String r0 = androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0.m(r0, r1)
        La3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.ArrayRow.toString():java.lang.String");
    }

    public final void updateFromFinalVariable(SolverVariable solverVariable, boolean z) {
        if (!solverVariable.isFinalValue) {
            return;
        }
        float f = this.variables.get(solverVariable);
        this.constantValue = (solverVariable.computedValue * f) + this.constantValue;
        this.variables.remove(solverVariable, z);
        if (z) {
            solverVariable.removeFromRow(this);
        }
    }

    public void updateFromRow(ArrayRow arrayRow, boolean z) {
        float use = this.variables.use(arrayRow, z);
        this.constantValue = (arrayRow.constantValue * use) + this.constantValue;
        if (z) {
            arrayRow.variable.removeFromRow(this);
        }
    }

    public ArrayRow(Cache cache) {
        this.variables = new ArrayLinkedVariables(this, cache);
    }
}
