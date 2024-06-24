package kotlinx.coroutines;

import kotlinx.coroutines.internal.Segment;

/* compiled from: Waiter.kt */
/* loaded from: classes4.dex */
public interface Waiter {
    void invokeOnCancellation(Segment<?> segment, int r2);
}
