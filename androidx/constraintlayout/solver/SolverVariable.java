package androidx.constraintlayout.solver;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class SolverVariable {
    public float computedValue;
    public boolean inGoal;
    public Type mType;
    public int id = -1;
    public int definitionId = -1;
    public int strength = 0;
    public boolean isFinalValue = false;
    public final float[] strengthVector = new float[9];
    public final float[] goalStrengthVector = new float[9];
    public ArrayRow[] mClientEquations = new ArrayRow[16];
    public int mClientEquationsCount = 0;
    public int usageInRowCount = 0;

    /* loaded from: classes.dex */
    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(Type type) {
        this.mType = type;
    }

    public final void addToRow(ArrayRow arrayRow) {
        int r0 = 0;
        while (true) {
            int r1 = this.mClientEquationsCount;
            if (r0 < r1) {
                if (this.mClientEquations[r0] == arrayRow) {
                    return;
                } else {
                    r0++;
                }
            } else {
                ArrayRow[] arrayRowArr = this.mClientEquations;
                if (r1 >= arrayRowArr.length) {
                    this.mClientEquations = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.mClientEquations;
                int r12 = this.mClientEquationsCount;
                arrayRowArr2[r12] = arrayRow;
                this.mClientEquationsCount = r12 + 1;
                return;
            }
        }
    }

    public final void removeFromRow(ArrayRow arrayRow) {
        int r0 = this.mClientEquationsCount;
        int r1 = 0;
        while (r1 < r0) {
            if (this.mClientEquations[r1] == arrayRow) {
                while (r1 < r0 - 1) {
                    ArrayRow[] arrayRowArr = this.mClientEquations;
                    int r2 = r1 + 1;
                    arrayRowArr[r1] = arrayRowArr[r2];
                    r1 = r2;
                }
                this.mClientEquationsCount--;
                return;
            }
            r1++;
        }
    }

    public final void reset() {
        this.mType = Type.UNKNOWN;
        this.strength = 0;
        this.id = -1;
        this.definitionId = -1;
        this.computedValue = 0.0f;
        this.isFinalValue = false;
        int r2 = this.mClientEquationsCount;
        for (int r3 = 0; r3 < r2; r3++) {
            this.mClientEquations[r3] = null;
        }
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.inGoal = false;
        Arrays.fill(this.goalStrengthVector, 0.0f);
    }

    public final String toString() {
        return "" + this.id;
    }

    public final void updateReferencesWithNewDefinition(ArrayRow arrayRow) {
        int r0 = this.mClientEquationsCount;
        for (int r2 = 0; r2 < r0; r2++) {
            this.mClientEquations[r2].updateFromRow(arrayRow, false);
        }
        this.mClientEquationsCount = 0;
    }
}
