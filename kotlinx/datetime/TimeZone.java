package kotlinx.datetime;

import j$.time.DateTimeException;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.serializers.TimeZoneSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: TimeZoneJvm.kt */
@Serializable(with = TimeZoneSerializer.class)
/* loaded from: classes4.dex */
public class TimeZone {
    public static final Companion Companion = new Companion();
    public static final FixedOffsetTimeZone UTC;
    public final ZoneId zoneId;

    /* compiled from: TimeZoneJvm.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static TimeZone currentSystemDefault() {
            ZoneId systemDefault = ZoneId.systemDefault();
            Intrinsics.checkNotNullExpressionValue(systemDefault, "systemDefault()");
            return ofZone$kotlinx_datetime(systemDefault);
        }

        public static TimeZone of(String zoneId) {
            Intrinsics.checkNotNullParameter(zoneId, "zoneId");
            try {
                ZoneId of = ZoneId.of(zoneId);
                Intrinsics.checkNotNullExpressionValue(of, "of(zoneId)");
                return ofZone$kotlinx_datetime(of);
            } catch (Exception e) {
                if (e instanceof DateTimeException) {
                    throw new IllegalTimeZoneException(e);
                }
                throw e;
            }
        }

        public static TimeZone ofZone$kotlinx_datetime(ZoneId zoneId) {
            boolean z;
            if (zoneId instanceof ZoneOffset) {
                return new FixedOffsetTimeZone(new UtcOffset((ZoneOffset) zoneId));
            }
            try {
                z = zoneId.getRules().isFixedOffset();
            } catch (ArrayIndexOutOfBoundsException unused) {
                z = false;
            }
            if (z) {
                ZoneId normalized = zoneId.normalized();
                Intrinsics.checkNotNull(normalized, "null cannot be cast to non-null type java.time.ZoneOffset");
                return new FixedOffsetTimeZone(new UtcOffset((ZoneOffset) normalized), zoneId);
            }
            return new TimeZone(zoneId);
        }

        public final KSerializer<TimeZone> serializer() {
            return TimeZoneSerializer.INSTANCE;
        }
    }

    static {
        ZoneOffset UTC2 = ZoneOffset.UTC;
        Intrinsics.checkNotNullExpressionValue(UTC2, "UTC");
        UTC = new FixedOffsetTimeZone(new UtcOffset(UTC2));
    }

    public TimeZone(ZoneId zoneId) {
        Intrinsics.checkNotNullParameter(zoneId, "zoneId");
        this.zoneId = zoneId;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof TimeZone) {
                if (Intrinsics.areEqual(this.zoneId, ((TimeZone) obj).zoneId)) {
                }
            }
            return false;
        }
        return true;
    }

    public final String getId() {
        String id = this.zoneId.getId();
        Intrinsics.checkNotNullExpressionValue(id, "zoneId.id");
        return id;
    }

    public final int hashCode() {
        return this.zoneId.hashCode();
    }

    public final String toString() {
        String zoneId = this.zoneId.toString();
        Intrinsics.checkNotNullExpressionValue(zoneId, "zoneId.toString()");
        return zoneId;
    }
}
