package kotlinx.coroutines.sync;

import kotlinx.coroutines.internal.Symbol;

/* compiled from: Mutex.kt */
/* loaded from: classes4.dex */
public final class MutexKt {
    public static final Symbol NO_OWNER = new Symbol("NO_OWNER");

    public static MutexImpl Mutex$default() {
        return new MutexImpl(false);
    }
}
