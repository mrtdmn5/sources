package androidx.compose.runtime;

import kotlin.jvm.functions.Function0;

/* compiled from: CompositionLocal.kt */
/* loaded from: classes.dex */
public abstract class CompositionLocal<T> {
    public final LazyValueHolder<T> defaultValueHolder;

    public CompositionLocal() {
        throw null;
    }

    public CompositionLocal(Function0 function0) {
        this.defaultValueHolder = new LazyValueHolder<>(function0);
    }

    public abstract State provided$runtime_release(Object obj, Composer composer);
}
