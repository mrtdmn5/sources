package androidx.compose.runtime;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: SnapshotState.kt */
/* loaded from: classes.dex */
public interface MutableState<T> extends State<T> {
    T component1();

    Function1<T, Unit> component2();

    void setValue(T t);
}
