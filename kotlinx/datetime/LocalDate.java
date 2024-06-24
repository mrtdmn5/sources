package kotlinx.datetime;

import j$.time.chrono.ChronoLocalDate;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.serializers.LocalDateIso8601Serializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: LocalDate.kt */
@Serializable(with = LocalDateIso8601Serializer.class)
/* loaded from: classes4.dex */
public final class LocalDate implements Comparable<LocalDate> {
    public static final Companion Companion = new Companion();
    public final j$.time.LocalDate value;

    /* compiled from: LocalDate.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public final KSerializer<LocalDate> serializer() {
            return LocalDateIso8601Serializer.INSTANCE;
        }
    }

    static {
        j$.time.LocalDate MIN = j$.time.LocalDate.MIN;
        Intrinsics.checkNotNullExpressionValue(MIN, "MIN");
        new LocalDate(MIN);
        j$.time.LocalDate MAX = j$.time.LocalDate.MAX;
        Intrinsics.checkNotNullExpressionValue(MAX, "MAX");
        new LocalDate(MAX);
    }

    public LocalDate(j$.time.LocalDate value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }

    @Override // java.lang.Comparable
    public final int compareTo(LocalDate localDate) {
        LocalDate other = localDate;
        Intrinsics.checkNotNullParameter(other, "other");
        return this.value.compareTo((ChronoLocalDate) other.value);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof LocalDate) {
                if (Intrinsics.areEqual(this.value, ((LocalDate) obj).value)) {
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
        String localDate = this.value.toString();
        Intrinsics.checkNotNullExpressionValue(localDate, "value.toString()");
        return localDate;
    }
}
