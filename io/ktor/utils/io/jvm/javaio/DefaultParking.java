package io.ktor.utils.io.jvm.javaio;

import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Pollers.kt */
/* loaded from: classes3.dex */
public final class DefaultParking implements Parking<Thread> {
    public static final DefaultParking INSTANCE = new DefaultParking();

    @Override // io.ktor.utils.io.jvm.javaio.Parking
    public final void park(long j) {
        boolean z;
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            LockSupport.parkNanos(j);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // io.ktor.utils.io.jvm.javaio.Parking
    public final void unpark(Thread thread) {
        Thread token = thread;
        Intrinsics.checkNotNullParameter(token, "token");
        LockSupport.unpark(token);
    }
}
