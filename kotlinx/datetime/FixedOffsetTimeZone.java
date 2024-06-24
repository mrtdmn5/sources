package kotlinx.datetime;

import j$.time.ZoneId;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.serializers.FixedOffsetTimeZoneSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: TimeZoneJvm.kt */
@Serializable(with = FixedOffsetTimeZoneSerializer.class)
/* loaded from: classes4.dex */
public final class FixedOffsetTimeZone extends TimeZone {
    public static final Companion Companion = new Companion();

    /* compiled from: TimeZoneJvm.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public final KSerializer<FixedOffsetTimeZone> serializer() {
            return FixedOffsetTimeZoneSerializer.INSTANCE;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FixedOffsetTimeZone(kotlinx.datetime.UtcOffset r2) {
        /*
            r1 = this;
            java.lang.String r0 = "zoneId"
            j$.time.ZoneOffset r2 = r2.zoneOffset
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.datetime.FixedOffsetTimeZone.<init>(kotlinx.datetime.UtcOffset):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FixedOffsetTimeZone(UtcOffset utcOffset, ZoneId zoneId) {
        super(zoneId);
        Intrinsics.checkNotNullParameter(zoneId, "zoneId");
    }
}
