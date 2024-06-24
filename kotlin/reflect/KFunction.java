package kotlin.reflect;

import kotlin.Function;

/* compiled from: KFunction.kt */
/* loaded from: classes.dex */
public interface KFunction<R> extends KCallable<R>, Function<R> {
    boolean isExternal();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    @Override // kotlin.reflect.KCallable
    boolean isSuspend();
}
