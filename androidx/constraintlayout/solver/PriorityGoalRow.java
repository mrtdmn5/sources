package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda0;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes.dex */
public final class PriorityGoalRow extends ArrayRow {
    public final GoalVariableAccessor accessor;
    public SolverVariable[] arrayGoals;
    public int numGoals;
    public SolverVariable[] sortArray;

    /* renamed from: androidx.constraintlayout.solver.PriorityGoalRow$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Comparator<SolverVariable> {
        @Override // java.util.Comparator
        public final int compare(SolverVariable solverVariable, SolverVariable solverVariable2) {
            return solverVariable.id - solverVariable2.id;
        }
    }

    /* loaded from: classes.dex */
    public class GoalVariableAccessor implements Comparable {
        public SolverVariable variable;

        public GoalVariableAccessor() {
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return this.variable.id - ((SolverVariable) obj).id;
        }

        public final String toString() {
            String str = "[ ";
            if (this.variable != null) {
                for (int r0 = 0; r0 < 9; r0++) {
                    StringBuilder m = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m(str);
                    m.append(this.variable.goalStrengthVector[r0]);
                    m.append(" ");
                    str = m.toString();
                }
            }
            StringBuilder m2 = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(str, "] ");
            m2.append(this.variable);
            return m2.toString();
        }
    }

    public PriorityGoalRow(Cache cache) {
        super(cache);
        this.arrayGoals = new SolverVariable[128];
        this.sortArray = new SolverVariable[128];
        this.numGoals = 0;
        this.accessor = new GoalVariableAccessor();
    }

    public final void addToGoal(SolverVariable solverVariable) {
        int r3;
        int r0 = this.numGoals + 1;
        SolverVariable[] solverVariableArr = this.arrayGoals;
        if (r0 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.arrayGoals = solverVariableArr2;
            this.sortArray = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.arrayGoals;
        int r2 = this.numGoals;
        solverVariableArr3[r2] = solverVariable;
        int r22 = r2 + 1;
        this.numGoals = r22;
        if (r22 > 1 && solverVariableArr3[r22 - 1].id > solverVariable.id) {
            int r23 = 0;
            while (true) {
                r3 = this.numGoals;
                if (r23 >= r3) {
                    break;
                }
                this.sortArray[r23] = this.arrayGoals[r23];
                r23++;
            }
            Arrays.sort(this.sortArray, 0, r3, new AnonymousClass1());
            for (int r02 = 0; r02 < this.numGoals; r02++) {
                this.arrayGoals[r02] = this.sortArray[r02];
            }
        }
        solverVariable.inGoal = true;
        solverVariable.addToRow(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x004d, code lost:            if (r9 < r8) goto L30;     */
    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.constraintlayout.solver.SolverVariable getPivotCandidate(boolean[] r12) {
        /*
            r11 = this;
            r0 = -1
            r1 = 0
            r3 = r0
            r2 = r1
        L4:
            int r4 = r11.numGoals
            if (r2 >= r4) goto L57
            androidx.constraintlayout.solver.SolverVariable[] r4 = r11.arrayGoals
            r5 = r4[r2]
            int r6 = r5.id
            boolean r6 = r12[r6]
            if (r6 == 0) goto L13
            goto L54
        L13:
            androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor r6 = r11.accessor
            r6.variable = r5
            r5 = 1
            r7 = 8
            if (r3 != r0) goto L36
        L1c:
            if (r7 < 0) goto L32
            androidx.constraintlayout.solver.SolverVariable r4 = r6.variable
            float[] r4 = r4.goalStrengthVector
            r4 = r4[r7]
            r8 = 0
            int r9 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r9 <= 0) goto L2a
            goto L32
        L2a:
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 >= 0) goto L2f
            goto L33
        L2f:
            int r7 = r7 + (-1)
            goto L1c
        L32:
            r5 = r1
        L33:
            if (r5 == 0) goto L54
            goto L53
        L36:
            r4 = r4[r3]
        L38:
            if (r7 < 0) goto L50
            float[] r8 = r4.goalStrengthVector
            r8 = r8[r7]
            androidx.constraintlayout.solver.SolverVariable r9 = r6.variable
            float[] r9 = r9.goalStrengthVector
            r9 = r9[r7]
            int r10 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r10 != 0) goto L4b
            int r7 = r7 + (-1)
            goto L38
        L4b:
            int r4 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r4 >= 0) goto L50
            goto L51
        L50:
            r5 = r1
        L51:
            if (r5 == 0) goto L54
        L53:
            r3 = r2
        L54:
            int r2 = r2 + 1
            goto L4
        L57:
            if (r3 != r0) goto L5b
            r12 = 0
            return r12
        L5b:
            androidx.constraintlayout.solver.SolverVariable[] r12 = r11.arrayGoals
            r12 = r12[r3]
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.PriorityGoalRow.getPivotCandidate(boolean[]):androidx.constraintlayout.solver.SolverVariable");
    }

    public final void removeGoal(SolverVariable solverVariable) {
        int r1 = 0;
        while (r1 < this.numGoals) {
            if (this.arrayGoals[r1] == solverVariable) {
                while (true) {
                    int r2 = this.numGoals;
                    if (r1 < r2 - 1) {
                        SolverVariable[] solverVariableArr = this.arrayGoals;
                        int r3 = r1 + 1;
                        solverVariableArr[r1] = solverVariableArr[r3];
                        r1 = r3;
                    } else {
                        this.numGoals = r2 - 1;
                        solverVariable.inGoal = false;
                        return;
                    }
                }
            } else {
                r1++;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow
    public final String toString() {
        String str = " goal -> (" + this.constantValue + ") : ";
        for (int r1 = 0; r1 < this.numGoals; r1++) {
            SolverVariable solverVariable = this.arrayGoals[r1];
            GoalVariableAccessor goalVariableAccessor = this.accessor;
            goalVariableAccessor.variable = solverVariable;
            str = str + goalVariableAccessor + " ";
        }
        return str;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow
    public final void updateFromRow(ArrayRow arrayRow, boolean z) {
        boolean z2;
        SolverVariable solverVariable = arrayRow.variable;
        if (solverVariable == null) {
            return;
        }
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize = arrayRowVariables.getCurrentSize();
        for (int r6 = 0; r6 < currentSize; r6++) {
            SolverVariable variable = arrayRowVariables.getVariable(r6);
            float variableValue = arrayRowVariables.getVariableValue(r6);
            GoalVariableAccessor goalVariableAccessor = this.accessor;
            goalVariableAccessor.variable = variable;
            boolean z3 = variable.inGoal;
            float[] fArr = solverVariable.goalStrengthVector;
            if (z3) {
                boolean z4 = true;
                for (int r10 = 0; r10 < 9; r10++) {
                    float[] fArr2 = goalVariableAccessor.variable.goalStrengthVector;
                    float f = (fArr[r10] * variableValue) + fArr2[r10];
                    fArr2[r10] = f;
                    if (Math.abs(f) < 1.0E-4f) {
                        goalVariableAccessor.variable.goalStrengthVector[r10] = 0.0f;
                    } else {
                        z4 = false;
                    }
                }
                if (z4) {
                    PriorityGoalRow.this.removeGoal(goalVariableAccessor.variable);
                }
                z2 = false;
            } else {
                for (int r5 = 0; r5 < 9; r5++) {
                    float f2 = fArr[r5];
                    if (f2 != 0.0f) {
                        float f3 = f2 * variableValue;
                        if (Math.abs(f3) < 1.0E-4f) {
                            f3 = 0.0f;
                        }
                        goalVariableAccessor.variable.goalStrengthVector[r5] = f3;
                    } else {
                        goalVariableAccessor.variable.goalStrengthVector[r5] = 0.0f;
                    }
                }
                z2 = true;
            }
            if (z2) {
                addToGoal(variable);
            }
            this.constantValue = (arrayRow.constantValue * variableValue) + this.constantValue;
        }
        removeGoal(solverVariable);
    }
}
