package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.ReflectionFactory;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes.dex */
public abstract class SuspendLambda extends ContinuationImpl implements FunctionBase<Object> {
    private final int arity;

    public SuspendLambda(int r1, Continuation<Object> continuation) {
        super(continuation);
        this.arity = r1;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public String toString() {
        if (getCompletion() == null) {
            Reflection.factory.getClass();
            String renderLambdaToString = ReflectionFactory.renderLambdaToString(this);
            Intrinsics.checkNotNullExpressionValue(renderLambdaToString, "renderLambdaToString(...)");
            return renderLambdaToString;
        }
        return super.toString();
    }

    public SuspendLambda(int r2) {
        this(r2, null);
    }
}
