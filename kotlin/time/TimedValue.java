package kotlin.time;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: measureTime.kt */
/* loaded from: classes.dex */
public final class TimedValue<T> {
    public final long duration;
    public final T value;

    /* JADX WARN: Multi-variable type inference failed */
    public TimedValue(Object obj, long j) {
        this.value = obj;
        this.duration = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimedValue)) {
            return false;
        }
        TimedValue timedValue = (TimedValue) obj;
        if (Intrinsics.areEqual(this.value, timedValue.value) && Duration.m1675equalsimpl0(this.duration, timedValue.duration)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        T t = this.value;
        if (t == null) {
            hashCode = 0;
        } else {
            hashCode = t.hashCode();
        }
        int r1 = Duration.$r8$clinit;
        return Long.hashCode(this.duration) + (hashCode * 31);
    }

    public final String toString() {
        return "TimedValue(value=" + this.value + ", duration=" + ((Object) Duration.m1690toStringimpl(this.duration)) + ')';
    }
}
