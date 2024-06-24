package androidx.constraintlayout.solver;

/* loaded from: classes.dex */
public final class Cache {
    public final Pools$SimplePool optimizedArrayRowPool = new Pools$SimplePool();
    public final Pools$SimplePool arrayRowPool = new Pools$SimplePool();
    public final Pools$SimplePool solverVariablePool = new Pools$SimplePool();
    public SolverVariable[] mIndexedVariables = new SolverVariable[32];
}
