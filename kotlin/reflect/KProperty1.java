package kotlin.reflect;

import kotlin.jvm.functions.Function1;

/* compiled from: KProperty.kt */
/* loaded from: classes.dex */
public interface KProperty1<T, V> extends KProperty<V>, Function1<T, V> {
    V get(T t);

    void getGetter();
}
