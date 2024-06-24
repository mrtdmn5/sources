package androidx.compose.runtime;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Composer.kt */
/* loaded from: classes.dex */
public final class ProvidedValue<T> {
    public final boolean canOverride;
    public final CompositionLocal<T> compositionLocal;
    public final T value;

    public ProvidedValue(CompositionLocal<T> compositionLocal, T t, boolean z) {
        Intrinsics.checkNotNullParameter(compositionLocal, "compositionLocal");
        this.compositionLocal = compositionLocal;
        this.value = t;
        this.canOverride = z;
    }
}
