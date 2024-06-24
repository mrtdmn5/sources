package androidx.compose.runtime;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CompositionLocal.kt */
/* loaded from: classes.dex */
public abstract class ProvidableCompositionLocal<T> extends CompositionLocal<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProvidableCompositionLocal(Function0<? extends T> defaultFactory) {
        super(defaultFactory);
        Intrinsics.checkNotNullParameter(defaultFactory, "defaultFactory");
    }

    public final ProvidedValue<T> provides(T t) {
        return new ProvidedValue<>(this, t, true);
    }
}
