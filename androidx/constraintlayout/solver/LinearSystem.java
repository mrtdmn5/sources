package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class LinearSystem {
    public static boolean OPTIMIZED_ENGINE = true;
    public static int POOL_SIZE = 1000;
    public final Cache mCache;
    public final PriorityGoalRow mGoal;
    public ArrayRow[] mRows;
    public ArrayRow mTempGoal;
    public int mVariablesID = 0;
    public int TABLE_SIZE = 32;
    public int mMaxColumns = 32;
    public boolean newgraphOptimizer = false;
    public boolean[] mAlreadyTestedCandidates = new boolean[32];
    public int mNumColumns = 1;
    public int mNumRows = 0;
    public int mMaxRows = 32;
    public SolverVariable[] mPoolVariables = new SolverVariable[POOL_SIZE];
    public int mPoolVariablesCount = 0;

    /* loaded from: classes.dex */
    public interface Row {
        SolverVariable getPivotCandidate(boolean[] zArr);
    }

    /* loaded from: classes.dex */
    public class ValuesRow extends ArrayRow {
        public ValuesRow(Cache cache) {
            this.variables = new SolverVariableValues(this, cache);
        }
    }

    public LinearSystem() {
        this.mRows = null;
        this.mRows = new ArrayRow[32];
        releaseRows();
        Cache cache = new Cache();
        this.mCache = cache;
        this.mGoal = new PriorityGoalRow(cache);
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(cache);
        } else {
            this.mTempGoal = new ArrayRow(cache);
        }
    }

    public static int getObjectVariableValue(ConstraintAnchor constraintAnchor) {
        SolverVariable solverVariable = constraintAnchor.mSolverVariable;
        if (solverVariable != null) {
            return (int) (solverVariable.computedValue + 0.5f);
        }
        return 0;
    }

    public final SolverVariable acquireSolverVariable(SolverVariable.Type type) {
        SolverVariable solverVariable = (SolverVariable) this.mCache.solverVariablePool.acquire();
        if (solverVariable == null) {
            solverVariable = new SolverVariable(type);
            solverVariable.mType = type;
        } else {
            solverVariable.reset();
            solverVariable.mType = type;
        }
        int r4 = this.mPoolVariablesCount;
        int r1 = POOL_SIZE;
        if (r4 >= r1) {
            int r12 = r1 * 2;
            POOL_SIZE = r12;
            this.mPoolVariables = (SolverVariable[]) Arrays.copyOf(this.mPoolVariables, r12);
        }
        SolverVariable[] solverVariableArr = this.mPoolVariables;
        int r13 = this.mPoolVariablesCount;
        this.mPoolVariablesCount = r13 + 1;
        solverVariableArr[r13] = solverVariable;
        return solverVariable;
    }

    public final void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int r9, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int r13, int r14) {
        ArrayRow createRow = createRow();
        if (solverVariable2 == solverVariable3) {
            createRow.variables.put(solverVariable, 1.0f);
            createRow.variables.put(solverVariable4, 1.0f);
            createRow.variables.put(solverVariable2, -2.0f);
        } else if (f == 0.5f) {
            createRow.variables.put(solverVariable, 1.0f);
            createRow.variables.put(solverVariable2, -1.0f);
            createRow.variables.put(solverVariable3, -1.0f);
            createRow.variables.put(solverVariable4, 1.0f);
            if (r9 > 0 || r13 > 0) {
                createRow.constantValue = (-r9) + r13;
            }
        } else if (f <= 0.0f) {
            createRow.variables.put(solverVariable, -1.0f);
            createRow.variables.put(solverVariable2, 1.0f);
            createRow.constantValue = r9;
        } else if (f >= 1.0f) {
            createRow.variables.put(solverVariable4, -1.0f);
            createRow.variables.put(solverVariable3, 1.0f);
            createRow.constantValue = -r13;
        } else {
            float f2 = 1.0f - f;
            createRow.variables.put(solverVariable, f2 * 1.0f);
            createRow.variables.put(solverVariable2, f2 * (-1.0f));
            createRow.variables.put(solverVariable3, (-1.0f) * f);
            createRow.variables.put(solverVariable4, 1.0f * f);
            if (r9 > 0 || r13 > 0) {
                createRow.constantValue = (r13 * f) + ((-r9) * f2);
            }
        }
        if (r14 != 8) {
            createRow.addError(this, r14);
        }
        addConstraint(createRow);
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x00bf, code lost:            if (r4.usageInRowCount <= 1) goto L229;     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00cb, code lost:            r12 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00c8, code lost:            if (r4.usageInRowCount <= 1) goto L229;     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00e6, code lost:            if (r4.usageInRowCount <= 1) goto L250;     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x00f2, code lost:            r14 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x00ef, code lost:            if (r4.usageInRowCount <= 1) goto L250;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void addConstraint(androidx.constraintlayout.solver.ArrayRow r17) {
        /*
            Method dump skipped, instructions count: 438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.LinearSystem.addConstraint(androidx.constraintlayout.solver.ArrayRow):void");
    }

    public final void addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int r8, int r9) {
        boolean z = false;
        if (r9 == 8 && solverVariable2.isFinalValue && solverVariable.definitionId == -1) {
            solverVariable.computedValue = solverVariable2.computedValue + r8;
            solverVariable.isFinalValue = true;
            int r7 = solverVariable.mClientEquationsCount;
            for (int r82 = 0; r82 < r7; r82++) {
                solverVariable.mClientEquations[r82].updateFromFinalVariable(solverVariable, false);
            }
            solverVariable.mClientEquationsCount = 0;
            return;
        }
        ArrayRow createRow = createRow();
        if (r8 != 0) {
            if (r8 < 0) {
                r8 *= -1;
                z = true;
            }
            createRow.constantValue = r8;
        }
        if (!z) {
            createRow.variables.put(solverVariable, -1.0f);
            createRow.variables.put(solverVariable2, 1.0f);
        } else {
            createRow.variables.put(solverVariable, 1.0f);
            createRow.variables.put(solverVariable2, -1.0f);
        }
        if (r9 != 8) {
            createRow.addError(this, r9);
        }
        addConstraint(createRow);
    }

    public final void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int r6, int r7) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, r6);
        if (r7 != 8) {
            createRow.variables.put(createErrorVariable(r7), (int) (createRow.variables.get(createSlackVariable) * (-1.0f)));
        }
        addConstraint(createRow);
    }

    public final void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int r6, int r7) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, r6);
        if (r7 != 8) {
            createRow.variables.put(createErrorVariable(r7), (int) (createRow.variables.get(createSlackVariable) * (-1.0f)));
        }
        addConstraint(createRow);
    }

    public final void addRow(ArrayRow arrayRow) {
        boolean z = OPTIMIZED_ENGINE;
        Cache cache = this.mCache;
        if (z) {
            ArrayRow arrayRow2 = this.mRows[this.mNumRows];
            if (arrayRow2 != null) {
                cache.optimizedArrayRowPool.release(arrayRow2);
            }
        } else {
            ArrayRow arrayRow3 = this.mRows[this.mNumRows];
            if (arrayRow3 != null) {
                cache.arrayRowPool.release(arrayRow3);
            }
        }
        ArrayRow[] arrayRowArr = this.mRows;
        int r1 = this.mNumRows;
        arrayRowArr[r1] = arrayRow;
        SolverVariable solverVariable = arrayRow.variable;
        solverVariable.definitionId = r1;
        this.mNumRows = r1 + 1;
        solverVariable.updateReferencesWithNewDefinition(arrayRow);
    }

    public final SolverVariable createErrorVariable(int r5) {
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.ERROR);
        int r1 = this.mVariablesID + 1;
        this.mVariablesID = r1;
        this.mNumColumns++;
        acquireSolverVariable.id = r1;
        acquireSolverVariable.strength = r5;
        this.mCache.mIndexedVariables[r1] = acquireSolverVariable;
        PriorityGoalRow priorityGoalRow = this.mGoal;
        priorityGoalRow.accessor.variable = acquireSolverVariable;
        float[] fArr = acquireSolverVariable.goalStrengthVector;
        Arrays.fill(fArr, 0.0f);
        fArr[acquireSolverVariable.strength] = 1.0f;
        priorityGoalRow.addToGoal(acquireSolverVariable);
        return acquireSolverVariable;
    }

    public final SolverVariable createObjectVariable(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.mSolverVariable;
            if (solverVariable == null) {
                constraintAnchor.resetSolverVariable();
                solverVariable = constraintAnchor.mSolverVariable;
            }
            int r5 = solverVariable.id;
            Cache cache = this.mCache;
            if (r5 == -1 || r5 > this.mVariablesID || cache.mIndexedVariables[r5] == null) {
                if (r5 != -1) {
                    solverVariable.reset();
                }
                int r52 = this.mVariablesID + 1;
                this.mVariablesID = r52;
                this.mNumColumns++;
                solverVariable.id = r52;
                solverVariable.mType = SolverVariable.Type.UNRESTRICTED;
                cache.mIndexedVariables[r52] = solverVariable;
            }
        }
        return solverVariable;
    }

    public final ArrayRow createRow() {
        boolean z = OPTIMIZED_ENGINE;
        Cache cache = this.mCache;
        if (z) {
            ArrayRow arrayRow = (ArrayRow) cache.optimizedArrayRowPool.acquire();
            if (arrayRow == null) {
                return new ValuesRow(cache);
            }
            arrayRow.variable = null;
            arrayRow.variables.clear();
            arrayRow.constantValue = 0.0f;
            arrayRow.isSimpleDefinition = false;
            return arrayRow;
        }
        ArrayRow arrayRow2 = (ArrayRow) cache.arrayRowPool.acquire();
        if (arrayRow2 == null) {
            return new ArrayRow(cache);
        }
        arrayRow2.variable = null;
        arrayRow2.variables.clear();
        arrayRow2.constantValue = 0.0f;
        arrayRow2.isSimpleDefinition = false;
        return arrayRow2;
    }

    public final SolverVariable createSlackVariable() {
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK);
        int r1 = this.mVariablesID + 1;
        this.mVariablesID = r1;
        this.mNumColumns++;
        acquireSolverVariable.id = r1;
        this.mCache.mIndexedVariables[r1] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    public final void increaseTableSize() {
        int r0 = this.TABLE_SIZE * 2;
        this.TABLE_SIZE = r0;
        this.mRows = (ArrayRow[]) Arrays.copyOf(this.mRows, r0);
        Cache cache = this.mCache;
        cache.mIndexedVariables = (SolverVariable[]) Arrays.copyOf(cache.mIndexedVariables, this.TABLE_SIZE);
        int r02 = this.TABLE_SIZE;
        this.mAlreadyTestedCandidates = new boolean[r02];
        this.mMaxColumns = r02;
        this.mMaxRows = r02;
    }

    public final void minimizeGoal(PriorityGoalRow priorityGoalRow) throws Exception {
        float f;
        int r5;
        boolean z;
        Cache cache;
        int r2 = 0;
        while (true) {
            f = 0.0f;
            r5 = 1;
            if (r2 < this.mNumRows) {
                ArrayRow arrayRow = this.mRows[r2];
                if (arrayRow.variable.mType != SolverVariable.Type.UNRESTRICTED && arrayRow.constantValue < 0.0f) {
                    z = true;
                    break;
                }
                r2++;
            } else {
                z = false;
                break;
            }
        }
        if (z) {
            boolean z2 = false;
            int r3 = 0;
            while (!z2) {
                r3 += r5;
                float f2 = Float.MAX_VALUE;
                int r9 = -1;
                int r10 = -1;
                int r8 = 0;
                int r11 = 0;
                while (true) {
                    int r12 = this.mNumRows;
                    cache = this.mCache;
                    if (r8 >= r12) {
                        break;
                    }
                    ArrayRow arrayRow2 = this.mRows[r8];
                    if (arrayRow2.variable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow2.isSimpleDefinition && arrayRow2.constantValue < f) {
                        int r14 = r5;
                        while (r14 < this.mNumColumns) {
                            SolverVariable solverVariable = cache.mIndexedVariables[r14];
                            float f3 = arrayRow2.variables.get(solverVariable);
                            if (f3 > f) {
                                for (int r4 = 0; r4 < 9; r4++) {
                                    float f4 = solverVariable.strengthVector[r4] / f3;
                                    if ((f4 < f2 && r4 == r11) || r4 > r11) {
                                        r11 = r4;
                                        f2 = f4;
                                        r9 = r8;
                                        r10 = r14;
                                    }
                                }
                            }
                            r14++;
                            f = 0.0f;
                        }
                    }
                    r8++;
                    f = 0.0f;
                    r5 = 1;
                }
                if (r9 != -1) {
                    ArrayRow arrayRow3 = this.mRows[r9];
                    arrayRow3.variable.definitionId = -1;
                    arrayRow3.pivot(cache.mIndexedVariables[r10]);
                    SolverVariable solverVariable2 = arrayRow3.variable;
                    solverVariable2.definitionId = r9;
                    solverVariable2.updateReferencesWithNewDefinition(arrayRow3);
                } else {
                    z2 = true;
                }
                if (r3 > this.mNumColumns / 2) {
                    z2 = true;
                }
                f = 0.0f;
                r5 = 1;
            }
        }
        optimize(priorityGoalRow);
        for (int r1 = 0; r1 < this.mNumRows; r1++) {
            ArrayRow arrayRow4 = this.mRows[r1];
            arrayRow4.variable.computedValue = arrayRow4.constantValue;
        }
    }

    public final void optimize(ArrayRow arrayRow) {
        for (int r1 = 0; r1 < this.mNumColumns; r1++) {
            this.mAlreadyTestedCandidates[r1] = false;
        }
        boolean z = false;
        int r2 = 0;
        while (!z) {
            r2++;
            if (r2 >= this.mNumColumns * 2) {
                return;
            }
            SolverVariable solverVariable = arrayRow.variable;
            if (solverVariable != null) {
                this.mAlreadyTestedCandidates[solverVariable.id] = true;
            }
            SolverVariable pivotCandidate = arrayRow.getPivotCandidate(this.mAlreadyTestedCandidates);
            if (pivotCandidate != null) {
                boolean[] zArr = this.mAlreadyTestedCandidates;
                int r6 = pivotCandidate.id;
                if (zArr[r6]) {
                    return;
                } else {
                    zArr[r6] = true;
                }
            }
            if (pivotCandidate != null) {
                float f = Float.MAX_VALUE;
                int r7 = -1;
                for (int r62 = 0; r62 < this.mNumRows; r62++) {
                    ArrayRow arrayRow2 = this.mRows[r62];
                    if (arrayRow2.variable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow2.isSimpleDefinition && arrayRow2.variables.contains(pivotCandidate)) {
                        float f2 = arrayRow2.variables.get(pivotCandidate);
                        if (f2 < 0.0f) {
                            float f3 = (-arrayRow2.constantValue) / f2;
                            if (f3 < f) {
                                r7 = r62;
                                f = f3;
                            }
                        }
                    }
                }
                if (r7 > -1) {
                    ArrayRow arrayRow3 = this.mRows[r7];
                    arrayRow3.variable.definitionId = -1;
                    arrayRow3.pivot(pivotCandidate);
                    SolverVariable solverVariable2 = arrayRow3.variable;
                    solverVariable2.definitionId = r7;
                    solverVariable2.updateReferencesWithNewDefinition(arrayRow3);
                }
            } else {
                z = true;
            }
        }
    }

    public final void releaseRows() {
        boolean z = OPTIMIZED_ENGINE;
        Cache cache = this.mCache;
        int r3 = 0;
        if (z) {
            while (true) {
                ArrayRow[] arrayRowArr = this.mRows;
                if (r3 < arrayRowArr.length) {
                    ArrayRow arrayRow = arrayRowArr[r3];
                    if (arrayRow != null) {
                        cache.optimizedArrayRowPool.release(arrayRow);
                    }
                    this.mRows[r3] = null;
                    r3++;
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                ArrayRow[] arrayRowArr2 = this.mRows;
                if (r3 < arrayRowArr2.length) {
                    ArrayRow arrayRow2 = arrayRowArr2[r3];
                    if (arrayRow2 != null) {
                        cache.arrayRowPool.release(arrayRow2);
                    }
                    this.mRows[r3] = null;
                    r3++;
                } else {
                    return;
                }
            }
        }
    }

    public final void reset() {
        Cache cache;
        int r1 = 0;
        while (true) {
            cache = this.mCache;
            SolverVariable[] solverVariableArr = cache.mIndexedVariables;
            if (r1 >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[r1];
            if (solverVariable != null) {
                solverVariable.reset();
            }
            r1++;
        }
        SolverVariable[] solverVariableArr2 = this.mPoolVariables;
        int r3 = this.mPoolVariablesCount;
        Pools$SimplePool pools$SimplePool = cache.solverVariablePool;
        pools$SimplePool.getClass();
        if (r3 > solverVariableArr2.length) {
            r3 = solverVariableArr2.length;
        }
        for (int r5 = 0; r5 < r3; r5++) {
            SolverVariable solverVariable2 = solverVariableArr2[r5];
            int r7 = pools$SimplePool.mPoolSize;
            Object[] objArr = pools$SimplePool.mPool;
            if (r7 < objArr.length) {
                objArr[r7] = solverVariable2;
                pools$SimplePool.mPoolSize = r7 + 1;
            }
        }
        this.mPoolVariablesCount = 0;
        Arrays.fill(cache.mIndexedVariables, (Object) null);
        this.mVariablesID = 0;
        PriorityGoalRow priorityGoalRow = this.mGoal;
        priorityGoalRow.numGoals = 0;
        priorityGoalRow.constantValue = 0.0f;
        this.mNumColumns = 1;
        for (int r12 = 0; r12 < this.mNumRows; r12++) {
            this.mRows[r12].getClass();
        }
        releaseRows();
        this.mNumRows = 0;
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(cache);
        } else {
            this.mTempGoal = new ArrayRow(cache);
        }
    }

    public final void addEquality(SolverVariable solverVariable, int r6) {
        int r0 = solverVariable.definitionId;
        if (r0 == -1) {
            solverVariable.computedValue = r6;
            solverVariable.isFinalValue = true;
            int r62 = solverVariable.mClientEquationsCount;
            for (int r1 = 0; r1 < r62; r1++) {
                solverVariable.mClientEquations[r1].updateFromFinalVariable(solverVariable, false);
            }
            solverVariable.mClientEquationsCount = 0;
            return;
        }
        if (r0 != -1) {
            ArrayRow arrayRow = this.mRows[r0];
            if (arrayRow.isSimpleDefinition) {
                arrayRow.constantValue = r6;
                return;
            }
            if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.isSimpleDefinition = true;
                arrayRow.constantValue = r6;
                return;
            }
            ArrayRow createRow = createRow();
            if (r6 < 0) {
                createRow.constantValue = r6 * (-1);
                createRow.variables.put(solverVariable, 1.0f);
            } else {
                createRow.constantValue = r6;
                createRow.variables.put(solverVariable, -1.0f);
            }
            addConstraint(createRow);
            return;
        }
        ArrayRow createRow2 = createRow();
        createRow2.variable = solverVariable;
        float f = r6;
        solverVariable.computedValue = f;
        createRow2.constantValue = f;
        createRow2.isSimpleDefinition = true;
        addConstraint(createRow2);
    }
}
