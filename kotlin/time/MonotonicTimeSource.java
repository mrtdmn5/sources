package kotlin.time;

/* compiled from: MonoTimeSource.kt */
/* loaded from: classes.dex */
public final class MonotonicTimeSource implements TimeSource {
    public static final /* synthetic */ int $r8$clinit = 0;
    public static final long zero = System.nanoTime();

    public static long read() {
        return System.nanoTime() - zero;
    }
}
