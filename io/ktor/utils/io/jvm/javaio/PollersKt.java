package io.ktor.utils.io.jvm.javaio;

/* compiled from: Pollers.kt */
/* loaded from: classes3.dex */
public final class PollersKt {
    public static final ThreadLocal<Parking<Thread>> parkingImplLocal = new ThreadLocal<>();

    public static final Parking<Thread> getParkingImpl() {
        Parking<Thread> parking = parkingImplLocal.get();
        if (parking == null) {
            return DefaultParking.INSTANCE;
        }
        return parking;
    }
}
