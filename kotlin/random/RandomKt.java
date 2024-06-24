package kotlin.random;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Random.kt */
/* loaded from: classes.dex */
public final class RandomKt {
    public static final String boundsErrorMessage(Number from, Number until) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }
}
