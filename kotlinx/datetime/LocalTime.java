package kotlinx.datetime;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.serializers.LocalTimeIso8601Serializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: LocalTime.kt */
@Serializable(with = LocalTimeIso8601Serializer.class)
/* loaded from: classes4.dex */
public final class LocalTime implements Comparable<LocalTime> {
    public static final Companion Companion = new Companion();
    public final j$.time.LocalTime value;

    /* compiled from: LocalTime.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public final KSerializer<LocalTime> serializer() {
            return LocalTimeIso8601Serializer.INSTANCE;
        }
    }

    static {
        j$.time.LocalTime MIN = j$.time.LocalTime.MIN;
        Intrinsics.checkNotNullExpressionValue(MIN, "MIN");
        new LocalTime(MIN);
        j$.time.LocalTime MAX = j$.time.LocalTime.MAX;
        Intrinsics.checkNotNullExpressionValue(MAX, "MAX");
        new LocalTime(MAX);
    }

    public LocalTime(j$.time.LocalTime value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }

    @Override // java.lang.Comparable
    public final int compareTo(LocalTime localTime) {
        LocalTime other = localTime;
        Intrinsics.checkNotNullParameter(other, "other");
        return this.value.compareTo(other.value);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof LocalTime) {
                if (Intrinsics.areEqual(this.value, ((LocalTime) obj).value)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.value.hashCode();
    }

    public final String toString() {
        String localTime = this.value.toString();
        Intrinsics.checkNotNullExpressionValue(localTime, "value.toString()");
        return localTime;
    }
}
