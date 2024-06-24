package kotlin.reflect;

import java.util.List;
import java.util.Map;

/* compiled from: KCallable.kt */
/* loaded from: classes.dex */
public interface KCallable<R> extends KAnnotatedElement {
    R call(Object... objArr);

    R callBy(Map<Object, ? extends Object> map);

    String getName();

    List<Object> getParameters();

    KType getReturnType();

    List<KTypeParameter> getTypeParameters();

    KVisibility getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
