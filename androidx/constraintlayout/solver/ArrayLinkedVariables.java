package androidx.constraintlayout.solver;

import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import androidx.constraintlayout.solver.ArrayRow;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda0;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class ArrayLinkedVariables implements ArrayRow.ArrayRowVariables {
    public final Cache mCache;
    public final ArrayRow mRow;
    public int currentSize = 0;
    public int ROW_SIZE = 8;
    public int[] mArrayIndices = new int[8];
    public int[] mArrayNextIndices = new int[8];
    public float[] mArrayValues = new float[8];
    public int mHead = -1;
    public int mLast = -1;
    public boolean mDidFillOnce = false;

    public ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void add(SolverVariable solverVariable, float f, boolean z) {
        if (f > -0.001f && f < 0.001f) {
            return;
        }
        int r1 = this.mHead;
        ArrayRow arrayRow = this.mRow;
        if (r1 == -1) {
            this.mHead = 0;
            this.mArrayValues[0] = f;
            this.mArrayIndices[0] = solverVariable.id;
            this.mArrayNextIndices[0] = -1;
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(arrayRow);
            this.currentSize++;
            if (!this.mDidFillOnce) {
                int r12 = this.mLast + 1;
                this.mLast = r12;
                int[] r13 = this.mArrayIndices;
                if (r12 >= r13.length) {
                    this.mDidFillOnce = true;
                    this.mLast = r13.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int r8 = -1;
        for (int r7 = 0; r1 != -1 && r7 < this.currentSize; r7++) {
            int r9 = this.mArrayIndices[r1];
            int r10 = solverVariable.id;
            if (r9 == r10) {
                float[] fArr = this.mArrayValues;
                float f2 = fArr[r1] + f;
                if (f2 > -0.001f && f2 < 0.001f) {
                    f2 = 0.0f;
                }
                fArr[r1] = f2;
                if (f2 == 0.0f) {
                    if (r1 == this.mHead) {
                        this.mHead = this.mArrayNextIndices[r1];
                    } else {
                        int[] r132 = this.mArrayNextIndices;
                        r132[r8] = r132[r1];
                    }
                    if (z) {
                        solverVariable.removeFromRow(arrayRow);
                    }
                    if (this.mDidFillOnce) {
                        this.mLast = r1;
                    }
                    solverVariable.usageInRowCount--;
                    this.currentSize--;
                    return;
                }
                return;
            }
            if (r9 < r10) {
                r8 = r1;
            }
            r1 = this.mArrayNextIndices[r1];
        }
        int r14 = this.mLast;
        int r0 = r14 + 1;
        if (this.mDidFillOnce) {
            int[] r02 = this.mArrayIndices;
            if (r02[r14] != -1) {
                r14 = r02.length;
            }
        } else {
            r14 = r0;
        }
        int[] r03 = this.mArrayIndices;
        if (r14 >= r03.length && this.currentSize < r03.length) {
            int r04 = 0;
            while (true) {
                int[] r15 = this.mArrayIndices;
                if (r04 >= r15.length) {
                    break;
                }
                if (r15[r04] == -1) {
                    r14 = r04;
                    break;
                }
                r04++;
            }
        }
        int[] r05 = this.mArrayIndices;
        if (r14 >= r05.length) {
            r14 = r05.length;
            int r06 = this.ROW_SIZE * 2;
            this.ROW_SIZE = r06;
            this.mDidFillOnce = false;
            this.mLast = r14 - 1;
            this.mArrayValues = Arrays.copyOf(this.mArrayValues, r06);
            this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
            this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
        }
        this.mArrayIndices[r14] = solverVariable.id;
        this.mArrayValues[r14] = f;
        if (r8 != -1) {
            int[] r133 = this.mArrayNextIndices;
            r133[r14] = r133[r8];
            r133[r8] = r14;
        } else {
            this.mArrayNextIndices[r14] = this.mHead;
            this.mHead = r14;
        }
        solverVariable.usageInRowCount++;
        solverVariable.addToRow(arrayRow);
        this.currentSize++;
        if (!this.mDidFillOnce) {
            this.mLast++;
        }
        int r122 = this.mLast;
        int[] r134 = this.mArrayIndices;
        if (r122 >= r134.length) {
            this.mDidFillOnce = true;
            this.mLast = r134.length - 1;
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void clear() {
        int r0 = this.mHead;
        for (int r2 = 0; r0 != -1 && r2 < this.currentSize; r2++) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[r0]];
            if (solverVariable != null) {
                solverVariable.removeFromRow(this.mRow);
            }
            r0 = this.mArrayNextIndices[r0];
        }
        this.mHead = -1;
        this.mLast = -1;
        this.mDidFillOnce = false;
        this.currentSize = 0;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final boolean contains(SolverVariable solverVariable) {
        int r0 = this.mHead;
        if (r0 == -1) {
            return false;
        }
        for (int r3 = 0; r0 != -1 && r3 < this.currentSize; r3++) {
            if (this.mArrayIndices[r0] == solverVariable.id) {
                return true;
            }
            r0 = this.mArrayNextIndices[r0];
        }
        return false;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void divideByAmount(float f) {
        int r0 = this.mHead;
        for (int r1 = 0; r0 != -1 && r1 < this.currentSize; r1++) {
            float[] fArr = this.mArrayValues;
            fArr[r0] = fArr[r0] / f;
            r0 = this.mArrayNextIndices[r0];
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final float get(SolverVariable solverVariable) {
        int r0 = this.mHead;
        for (int r1 = 0; r0 != -1 && r1 < this.currentSize; r1++) {
            if (this.mArrayIndices[r0] == solverVariable.id) {
                return this.mArrayValues[r0];
            }
            r0 = this.mArrayNextIndices[r0];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final int getCurrentSize() {
        return this.currentSize;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final SolverVariable getVariable(int r4) {
        int r0 = this.mHead;
        for (int r1 = 0; r0 != -1 && r1 < this.currentSize; r1++) {
            if (r1 == r4) {
                return this.mCache.mIndexedVariables[this.mArrayIndices[r0]];
            }
            r0 = this.mArrayNextIndices[r0];
        }
        return null;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final float getVariableValue(int r4) {
        int r0 = this.mHead;
        for (int r1 = 0; r0 != -1 && r1 < this.currentSize; r1++) {
            if (r1 == r4) {
                return this.mArrayValues[r0];
            }
            r0 = this.mArrayNextIndices[r0];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void invert() {
        int r0 = this.mHead;
        for (int r1 = 0; r0 != -1 && r1 < this.currentSize; r1++) {
            float[] fArr = this.mArrayValues;
            fArr[r0] = fArr[r0] * (-1.0f);
            r0 = this.mArrayNextIndices[r0];
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void put(SolverVariable solverVariable, float f) {
        if (f == 0.0f) {
            remove(solverVariable, true);
            return;
        }
        int r0 = this.mHead;
        ArrayRow arrayRow = this.mRow;
        if (r0 == -1) {
            this.mHead = 0;
            this.mArrayValues[0] = f;
            this.mArrayIndices[0] = solverVariable.id;
            this.mArrayNextIndices[0] = -1;
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(arrayRow);
            this.currentSize++;
            if (!this.mDidFillOnce) {
                int r10 = this.mLast + 1;
                this.mLast = r10;
                int[] r11 = this.mArrayIndices;
                if (r10 >= r11.length) {
                    this.mDidFillOnce = true;
                    this.mLast = r11.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int r6 = -1;
        for (int r5 = 0; r0 != -1 && r5 < this.currentSize; r5++) {
            int r7 = this.mArrayIndices[r0];
            int r8 = solverVariable.id;
            if (r7 == r8) {
                this.mArrayValues[r0] = f;
                return;
            }
            if (r7 < r8) {
                r6 = r0;
            }
            r0 = this.mArrayNextIndices[r0];
        }
        int r02 = this.mLast;
        int r52 = r02 + 1;
        if (this.mDidFillOnce) {
            int[] r53 = this.mArrayIndices;
            if (r53[r02] != -1) {
                r02 = r53.length;
            }
        } else {
            r02 = r52;
        }
        int[] r54 = this.mArrayIndices;
        if (r02 >= r54.length && this.currentSize < r54.length) {
            int r55 = 0;
            while (true) {
                int[] r72 = this.mArrayIndices;
                if (r55 >= r72.length) {
                    break;
                }
                if (r72[r55] == -1) {
                    r02 = r55;
                    break;
                }
                r55++;
            }
        }
        int[] r56 = this.mArrayIndices;
        if (r02 >= r56.length) {
            r02 = r56.length;
            int r57 = this.ROW_SIZE * 2;
            this.ROW_SIZE = r57;
            this.mDidFillOnce = false;
            this.mLast = r02 - 1;
            this.mArrayValues = Arrays.copyOf(this.mArrayValues, r57);
            this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
            this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
        }
        this.mArrayIndices[r02] = solverVariable.id;
        this.mArrayValues[r02] = f;
        if (r6 != -1) {
            int[] r112 = this.mArrayNextIndices;
            r112[r02] = r112[r6];
            r112[r6] = r02;
        } else {
            this.mArrayNextIndices[r02] = this.mHead;
            this.mHead = r02;
        }
        solverVariable.usageInRowCount++;
        solverVariable.addToRow(arrayRow);
        int r102 = this.currentSize + 1;
        this.currentSize = r102;
        if (!this.mDidFillOnce) {
            this.mLast++;
        }
        int[] r113 = this.mArrayIndices;
        if (r102 >= r113.length) {
            this.mDidFillOnce = true;
        }
        if (this.mLast >= r113.length) {
            this.mDidFillOnce = true;
            this.mLast = r113.length - 1;
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final float remove(SolverVariable solverVariable, boolean z) {
        int r0 = this.mHead;
        if (r0 == -1) {
            return 0.0f;
        }
        int r3 = 0;
        int r4 = -1;
        while (r0 != -1 && r3 < this.currentSize) {
            if (this.mArrayIndices[r0] == solverVariable.id) {
                if (r0 == this.mHead) {
                    this.mHead = this.mArrayNextIndices[r0];
                } else {
                    int[] r2 = this.mArrayNextIndices;
                    r2[r4] = r2[r0];
                }
                if (z) {
                    solverVariable.removeFromRow(this.mRow);
                }
                solverVariable.usageInRowCount--;
                this.currentSize--;
                this.mArrayIndices[r0] = -1;
                if (this.mDidFillOnce) {
                    this.mLast = r0;
                }
                return this.mArrayValues[r0];
            }
            r3++;
            r4 = r0;
            r0 = this.mArrayNextIndices[r0];
        }
        return 0.0f;
    }

    public final String toString() {
        int r0 = this.mHead;
        String str = "";
        for (int r2 = 0; r0 != -1 && r2 < this.currentSize; r2++) {
            StringBuilder m = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m(ComposableInvoker$$ExternalSyntheticOutline0.m(str, " -> "));
            m.append(this.mArrayValues[r0]);
            m.append(" : ");
            StringBuilder m2 = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m(m.toString());
            m2.append(this.mCache.mIndexedVariables[this.mArrayIndices[r0]]);
            str = m2.toString();
            r0 = this.mArrayNextIndices[r0];
        }
        return str;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final float use(ArrayRow arrayRow, boolean z) {
        float f = get(arrayRow.variable);
        remove(arrayRow.variable, z);
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize = arrayRowVariables.getCurrentSize();
        for (int r2 = 0; r2 < currentSize; r2++) {
            SolverVariable variable = arrayRowVariables.getVariable(r2);
            add(variable, arrayRowVariables.get(variable) * f, z);
        }
        return f;
    }
}
