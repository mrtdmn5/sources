package kotlin.jvm.internal;

import java.io.Serializable;

/* compiled from: Lambda.kt */
/* loaded from: classes.dex */
public abstract class Lambda<R> implements FunctionBase<R>, Serializable {
    private final int arity;

    public Lambda(int r1) {
        this.arity = r1;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        Reflection.factory.getClass();
        String renderLambdaToString = ReflectionFactory.renderLambdaToString(this);
        Intrinsics.checkNotNullExpressionValue(renderLambdaToString, "renderLambdaToString(...)");
        return renderLambdaToString;
    }
}
