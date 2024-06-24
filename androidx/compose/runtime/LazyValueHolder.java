package androidx.compose.runtime;

import kotlin.LazyKt__LazyJVMKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ValueHolders.kt */
/* loaded from: classes.dex */
public final class LazyValueHolder<T> implements State<T> {
    public final SynchronizedLazyImpl current$delegate;

    public LazyValueHolder(Function0<? extends T> valueProducer) {
        Intrinsics.checkNotNullParameter(valueProducer, "valueProducer");
        this.current$delegate = LazyKt__LazyJVMKt.lazy(valueProducer);
    }

    @Override // androidx.compose.runtime.State
    public final T getValue() {
        return (T) this.current$delegate.getValue();
    }
}
