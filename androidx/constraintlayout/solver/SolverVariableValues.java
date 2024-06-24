package androidx.constraintlayout.solver;

import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import androidx.constraintlayout.solver.ArrayRow;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda0;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class SolverVariableValues implements ArrayRow.ArrayRowVariables {
    public final Cache mCache;
    public final ArrayRow mRow;
    public int SIZE = 16;
    public final int[] keys = new int[16];
    public int[] nextKeys = new int[16];
    public int[] variables = new int[16];
    public float[] values = new float[16];
    public int[] previous = new int[16];
    public int[] next = new int[16];
    public int mCount = 0;
    public int head = -1;

    public SolverVariableValues(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
        clear();
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void add(SolverVariable solverVariable, float f, boolean z) {
        if (f > -0.001f && f < 0.001f) {
            return;
        }
        int indexOf = indexOf(solverVariable);
        if (indexOf == -1) {
            put(solverVariable, f);
            return;
        }
        float[] fArr = this.values;
        float f2 = fArr[indexOf] + f;
        fArr[indexOf] = f2;
        if (f2 > -0.001f && f2 < 0.001f) {
            fArr[indexOf] = 0.0f;
            remove(solverVariable, z);
        }
    }

    public final void addToHashMap(SolverVariable solverVariable, int r5) {
        int[] r4;
        int r42 = solverVariable.id % 16;
        int[] r0 = this.keys;
        int r1 = r0[r42];
        if (r1 == -1) {
            r0[r42] = r5;
        } else {
            while (true) {
                r4 = this.nextKeys;
                int r02 = r4[r1];
                if (r02 == -1) {
                    break;
                } else {
                    r1 = r02;
                }
            }
            r4[r1] = r5;
        }
        this.nextKeys[r5] = -1;
    }

    public final void addVariable(int r3, SolverVariable solverVariable, float f) {
        this.variables[r3] = solverVariable.id;
        this.values[r3] = f;
        this.previous[r3] = -1;
        this.next[r3] = -1;
        solverVariable.addToRow(this.mRow);
        solverVariable.usageInRowCount++;
        this.mCount++;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void clear() {
        int r0 = this.mCount;
        for (int r2 = 0; r2 < r0; r2++) {
            SolverVariable variable = getVariable(r2);
            if (variable != null) {
                variable.removeFromRow(this.mRow);
            }
        }
        for (int r02 = 0; r02 < this.SIZE; r02++) {
            this.variables[r02] = -1;
            this.nextKeys[r02] = -1;
        }
        for (int r03 = 0; r03 < 16; r03++) {
            this.keys[r03] = -1;
        }
        this.mCount = 0;
        this.head = -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final boolean contains(SolverVariable solverVariable) {
        if (indexOf(solverVariable) != -1) {
            return true;
        }
        return false;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void divideByAmount(float f) {
        int r0 = this.mCount;
        int r1 = this.head;
        for (int r2 = 0; r2 < r0; r2++) {
            float[] fArr = this.values;
            fArr[r1] = fArr[r1] / f;
            r1 = this.next[r1];
            if (r1 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final float get(SolverVariable solverVariable) {
        int indexOf = indexOf(solverVariable);
        if (indexOf != -1) {
            return this.values[indexOf];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final int getCurrentSize() {
        return this.mCount;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final SolverVariable getVariable(int r7) {
        int r0 = this.mCount;
        if (r0 == 0) {
            return null;
        }
        int r2 = this.head;
        for (int r3 = 0; r3 < r0; r3++) {
            if (r3 == r7 && r2 != -1) {
                return this.mCache.mIndexedVariables[this.variables[r2]];
            }
            r2 = this.next[r2];
            if (r2 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final float getVariableValue(int r5) {
        int r0 = this.mCount;
        int r1 = this.head;
        for (int r2 = 0; r2 < r0; r2++) {
            if (r2 == r5) {
                return this.values[r1];
            }
            r1 = this.next[r1];
            if (r1 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    public final int indexOf(SolverVariable solverVariable) {
        if (this.mCount == 0) {
            return -1;
        }
        int r4 = solverVariable.id;
        int r0 = this.keys[r4 % 16];
        if (r0 == -1) {
            return -1;
        }
        if (this.variables[r0] == r4) {
            return r0;
        }
        do {
            r0 = this.nextKeys[r0];
            if (r0 == -1) {
                break;
            }
        } while (this.variables[r0] != r4);
        if (r0 == -1 || this.variables[r0] != r4) {
            return -1;
        }
        return r0;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void invert() {
        int r0 = this.mCount;
        int r1 = this.head;
        for (int r2 = 0; r2 < r0; r2++) {
            float[] fArr = this.values;
            fArr[r1] = fArr[r1] * (-1.0f);
            r1 = this.next[r1];
            if (r1 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void put(SolverVariable solverVariable, float f) {
        if (f > -0.001f && f < 0.001f) {
            remove(solverVariable, true);
            return;
        }
        int r2 = 0;
        if (this.mCount == 0) {
            addVariable(0, solverVariable, f);
            addToHashMap(solverVariable, 0);
            this.head = 0;
            return;
        }
        int indexOf = indexOf(solverVariable);
        if (indexOf != -1) {
            this.values[indexOf] = f;
            return;
        }
        int r0 = this.mCount + 1;
        int r1 = this.SIZE;
        if (r0 >= r1) {
            int r12 = r1 * 2;
            this.variables = Arrays.copyOf(this.variables, r12);
            this.values = Arrays.copyOf(this.values, r12);
            this.previous = Arrays.copyOf(this.previous, r12);
            this.next = Arrays.copyOf(this.next, r12);
            this.nextKeys = Arrays.copyOf(this.nextKeys, r12);
            for (int r02 = this.SIZE; r02 < r12; r02++) {
                this.variables[r02] = -1;
                this.nextKeys[r02] = -1;
            }
            this.SIZE = r12;
        }
        int r03 = this.mCount;
        int r13 = this.head;
        int r5 = -1;
        for (int r4 = 0; r4 < r03; r4++) {
            int r6 = this.variables[r13];
            int r7 = solverVariable.id;
            if (r6 == r7) {
                this.values[r13] = f;
                return;
            }
            if (r6 < r7) {
                r5 = r13;
            }
            r13 = this.next[r13];
            if (r13 == -1) {
                break;
            }
        }
        while (true) {
            if (r2 < this.SIZE) {
                if (this.variables[r2] == -1) {
                    break;
                } else {
                    r2++;
                }
            } else {
                r2 = -1;
                break;
            }
        }
        addVariable(r2, solverVariable, f);
        if (r5 != -1) {
            this.previous[r2] = r5;
            int[] r10 = this.next;
            r10[r2] = r10[r5];
            r10[r5] = r2;
        } else {
            this.previous[r2] = -1;
            if (this.mCount > 0) {
                this.next[r2] = this.head;
                this.head = r2;
            } else {
                this.next[r2] = -1;
            }
        }
        int r102 = this.next[r2];
        if (r102 != -1) {
            this.previous[r102] = r2;
        }
        addToHashMap(solverVariable, r2);
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final float remove(SolverVariable solverVariable, boolean z) {
        int[] r3;
        int r4;
        int indexOf = indexOf(solverVariable);
        if (indexOf == -1) {
            return 0.0f;
        }
        int r2 = solverVariable.id;
        int r32 = r2 % 16;
        int[] r42 = this.keys;
        int r5 = r42[r32];
        if (r5 != -1) {
            if (this.variables[r5] == r2) {
                int[] r22 = this.nextKeys;
                r42[r32] = r22[r5];
                r22[r5] = -1;
            } else {
                while (true) {
                    r3 = this.nextKeys;
                    r4 = r3[r5];
                    if (r4 == -1 || this.variables[r4] == r2) {
                        break;
                    }
                    r5 = r4;
                }
                if (r4 != -1 && this.variables[r4] == r2) {
                    r3[r5] = r3[r4];
                    r3[r4] = -1;
                }
            }
        }
        float f = this.values[indexOf];
        if (this.head == indexOf) {
            this.head = this.next[indexOf];
        }
        this.variables[indexOf] = -1;
        int[] r33 = this.previous;
        int r43 = r33[indexOf];
        if (r43 != -1) {
            int[] r52 = this.next;
            r52[r43] = r52[indexOf];
        }
        int r44 = this.next[indexOf];
        if (r44 != -1) {
            r33[r44] = r33[indexOf];
        }
        this.mCount--;
        solverVariable.usageInRowCount--;
        if (z) {
            solverVariable.removeFromRow(this.mRow);
        }
        return f;
    }

    public final String toString() {
        String m;
        String m2;
        String str = hashCode() + " { ";
        int r1 = this.mCount;
        for (int r2 = 0; r2 < r1; r2++) {
            SolverVariable variable = getVariable(r2);
            if (variable != null) {
                String str2 = str + variable + " = " + getVariableValue(r2) + " ";
                int indexOf = indexOf(variable);
                String m3 = ComposableInvoker$$ExternalSyntheticOutline0.m(str2, "[p: ");
                int r4 = this.previous[indexOf];
                Cache cache = this.mCache;
                if (r4 != -1) {
                    StringBuilder m4 = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m(m3);
                    m4.append(cache.mIndexedVariables[this.variables[this.previous[indexOf]]]);
                    m = m4.toString();
                } else {
                    m = ComposableInvoker$$ExternalSyntheticOutline0.m(m3, "none");
                }
                String m5 = ComposableInvoker$$ExternalSyntheticOutline0.m(m, ", n: ");
                if (this.next[indexOf] != -1) {
                    StringBuilder m6 = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m(m5);
                    m6.append(cache.mIndexedVariables[this.variables[this.next[indexOf]]]);
                    m2 = m6.toString();
                } else {
                    m2 = ComposableInvoker$$ExternalSyntheticOutline0.m(m5, "none");
                }
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(m2, "]");
            }
        }
        return ComposableInvoker$$ExternalSyntheticOutline0.m(str, " }");
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final float use(ArrayRow arrayRow, boolean z) {
        float f = get(arrayRow.variable);
        remove(arrayRow.variable, z);
        SolverVariableValues solverVariableValues = (SolverVariableValues) arrayRow.variables;
        int r1 = solverVariableValues.mCount;
        int r2 = 0;
        int r3 = 0;
        while (r2 < r1) {
            int r4 = solverVariableValues.variables[r3];
            if (r4 != -1) {
                add(this.mCache.mIndexedVariables[r4], solverVariableValues.values[r3] * f, z);
                r2++;
            }
            r3++;
        }
        return f;
    }
}
