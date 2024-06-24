package kotlinx.serialization.internal;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function0;

/* compiled from: Caching.kt */
/* loaded from: classes4.dex */
public final class MutableSoftReference<T> {
    public volatile SoftReference<T> reference = new SoftReference<>(null);

    public final synchronized T getOrSetWithLock(Function0<? extends T> function0) {
        T t = this.reference.get();
        if (t != null) {
            return t;
        }
        T invoke = function0.invoke();
        this.reference = new SoftReference<>(invoke);
        return invoke;
    }
}
