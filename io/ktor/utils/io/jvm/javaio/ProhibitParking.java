package io.ktor.utils.io.jvm.javaio;

import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Pollers.kt */
/* loaded from: classes3.dex */
public final class ProhibitParking implements Parking<Thread> {
    public static final ProhibitParking INSTANCE = new ProhibitParking();

    @Override // io.ktor.utils.io.jvm.javaio.Parking
    public final void park(long j) {
        throw new UnsupportedOperationException("Parking is prohibited on this thread. Most likely you are using blocking operation on the wrong thread/dispatcher that doesn't allow blocking. Consider wrapping you blocking code withContext(Dispatchers.IO) {...}.");
    }

    @Override // io.ktor.utils.io.jvm.javaio.Parking
    public final void unpark(Thread thread) {
        Thread token = thread;
        Intrinsics.checkNotNullParameter(token, "token");
        LockSupport.unpark(token);
    }
}
